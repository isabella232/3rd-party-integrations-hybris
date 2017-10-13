package com.osfglobal.hybris.emarsys.services;

import com.osfglobal.emarsys.client.Contact;
import com.osfglobal.emarsys.client.EmarsysClient;
import com.osfglobal.emarsys.client.beans.EmarsysEvent;
import com.osfglobal.hybris.emarsys.converters.mappings.EmarsysMappingsConverter;
import com.osfglobal.hybris.emarsys.dao.EmarsysOrderDao;
import com.osfglobal.hybris.emarsys.resolvers.EmarsysTransactionalEmailsResolver;
import com.osfglobal.hybris.emarsys.utils.EmarsysObjectUtils;
import de.hybris.platform.basecommerce.model.site.BaseSiteModel;
import de.hybris.platform.commerceservices.customer.CustomerEmailResolutionService;
import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Required;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class EmarsysTransactionalEmailsServiceImpl extends EmarsysBaseService implements EmarsysTransactionalEmailsService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmarsysTransactionalEmailsServiceImpl.class);
    private static final String PRODUCT_SUFFIX = "product_";
    private static final String PRODUCTS = "products";
    private CustomerEmailResolutionService customerEmailResolutionService;
    private Converter<CustomerModel, Contact> customerToContactConverter;
    private EmarsysTransactionalEmailsResolver emarsysTransactionalEmailsResolver;
    private EmarsysOrderDao emarsysOrderDao;
    private EmarsysMappingsConverter emarsysMappingsConverter;
    private String externalEventName;

    /**
     * Get shipped orders
     * @return
     */
    @Override
    public List<OrderModel> getShippedOrders() {
        return emarsysOrderDao.getShippedOrders();
    }

    @Override
    public void sendEmail(OrderModel order) {
        String email = customerEmailResolutionService.getEmailForCustomer((CustomerModel) order.getUser());
        EmarsysClient emarsysClient = getEmarsysClient(order.getSite());
        List<Contact> contacts = emarsysClient.getContactsByEmail(email);
        BaseSiteModel site = order.getSite();
        if(contacts.isEmpty()) {
            Contact contact = customerToContactConverter.convert((CustomerModel) order.getUser());
            contacts.add(emarsysClient.createContact(contact));
        }
        Object externalEvent = EmarsysObjectUtils.getNestedProperty(emarsysConfig.getEmarsysSettings(site), externalEventName);
        String externalEventName = Objects.toString(externalEvent, null);
        LOGGER.debug("externalEventName: {}",externalEventName);
        Map<String, String> placeholders = getPlaceholders(order);
        Map<String, List<Map>> extraPlaceholders = getExtraPlaceholders(order);
        contacts.forEach(contact -> emarsysClient
                .triggerEvent(new EmarsysEvent(externalEventName, contact, placeholders, extraPlaceholders)));
    }


    private Map<String, String> getPlaceholders(OrderModel order) {
        Map<String, String> result = new LinkedHashMap<>();
        emarsysMappingsConverter.convert(order.getSite()).entries()
                .stream()
                .filter(entry->!entry.getValue().startsWith(PRODUCT_SUFFIX))
                .forEach(entry-> {
                    String placeholderValue = emarsysTransactionalEmailsResolver.resolve(entry.getKey(), order);
                    String placeholder = entry.getValue();
                    result.put(placeholder, placeholderValue);
                });
        return result;
    }

    private Map<String, List<Map>> getExtraPlaceholders(OrderModel order) {
        Map<String, List<Map>> result = new HashMap<>();
        List<Map> products = new ArrayList<>();
        result.put(PRODUCTS, products);
        order.getEntries().forEach(entry->{
            Map<String, String> product = new HashMap<>();
            emarsysMappingsConverter.convert(order.getSite()).entries()
                    .stream()
                    .filter(mapping-> mapping.getValue().startsWith(PRODUCT_SUFFIX))
                    .forEach(mapping-> {
                        String path = mapping.getKey();
                        String placeholder = mapping.getValue();
                        String placeholderValue = emarsysTransactionalEmailsResolver.resolve(path, entry);
                        product.put(placeholder, placeholderValue);
                    });
            products.add(product);
        });
        return result;
    }

    @Required
    public void setCustomerToContactConverter(Converter<CustomerModel, Contact> customerToContactConverter) {
        this.customerToContactConverter = customerToContactConverter;
    }

    @Required
    public void setCustomerEmailResolutionService(CustomerEmailResolutionService customerEmailResolutionService) {
        this.customerEmailResolutionService = customerEmailResolutionService;
    }

    @Required
    public void setEmarsysTransactionalEmailsResolver(EmarsysTransactionalEmailsResolver emarsysTransactionalEmailsResolver) {
        this.emarsysTransactionalEmailsResolver = emarsysTransactionalEmailsResolver;
    }
    @Required
    public void setEmarsysOrderDao(EmarsysOrderDao emarsysOrderDao) {
        this.emarsysOrderDao = emarsysOrderDao;
    }
    @Required
    public void setEmarsysMappingsConverter(EmarsysMappingsConverter emarsysMappingsConverter) {
        this.emarsysMappingsConverter = emarsysMappingsConverter;
    }

    public void setExternalEventName(String externalEventName) {
        this.externalEventName = externalEventName;
    }
}


package com.osfglobal.hybris.emarsys;

import com.osfglobal.emarsys.client.Contact;
import com.osfglobal.emarsys.client.OptIn;
import com.osfglobal.hybris.emarsys.core.model.EmarsysInitialDBLoadModel;
import com.osfglobal.hybris.emarsys.enums.EmarsysInitialDBLoadCustomerFieldEnum;
import com.osfglobal.hybris.emarsys.enums.EmarsysInitialDBLoadPlaceholderEnum;
import com.osfglobal.hybris.emarsys.enums.EmarsysOptinStatusEnum;
import com.osfglobal.hybris.emarsys.model.EmarsysSyncUsersCronJobModel;
import com.osfglobal.hybris.emarsys.services.EmarsysService;
import com.osfglobal.hybris.emarsys.utils.EmarsysObjectUtils;
import de.hybris.platform.basecommerce.model.site.BaseSiteModel;
import de.hybris.platform.commerceservices.customer.CustomerAccountService;
import de.hybris.platform.core.model.user.AddressModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable;
import de.hybris.platform.servicelayer.cronjob.PerformResult;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;

import java.lang.reflect.InvocationTargetException;
import java.util.*;


public class EmarsysSyncUsersJob extends AbstractJobPerformable<EmarsysSyncUsersCronJobModel> {

    private static final Logger LOGGER = Logger.getLogger(EmarsysSyncUsersJob.class);
    public static final String FIELD_COUNTRY = "country.name";
    public static final String FIELD_TITLE = "title.code";
    public static final String FIELD_FNAME = "firstname";
    public static final String FIELD_LNAME = "lastname";
    public static final String FIELD_EMAIL = "email";
    public static final String FIELD_OPTIN = "optin";
    public static final String OPTIN_STATUS_ALL_EMPTY = "0 (All users empty) (default)";
    public static final String OPTIN_STATUS_ALL_TRUE = "1 (All users true)";
    public static final String FIELD_ADDRESS = "address";

    private EmarsysService emarsysService;

    private CustomerAccountService customerAccountService;

    @Override
    public PerformResult perform(EmarsysSyncUsersCronJobModel cronJob) {
        LOGGER.info("EmarsysSyncUsersJob -> start...");
        BaseSiteModel site = cronJob.getBaseSite();
        EmarsysInitialDBLoadModel initialDBLoadSettings = site.getEmarsysInitialDBLoad();
        EmarsysOptinStatusEnum optinStatus = initialDBLoadSettings.getOptinStatus();
        String optinStatusCustomerAttributeField = initialDBLoadSettings.getOptinStatusCustomerAttributeId();
        OptIn optInValue = getOptInValue(optinStatus);
        Map<String, String> mappings = getFieldsMappings(site.getEmarsysInitialDBLoad().getMapping());
        List<Contact> contacts = new ArrayList<>();
        List<CustomerModel> customers = emarsysService.getAllCustomers();
        for (CustomerModel customer : customers) {
            if (customer.getOriginalUid() != null) {
                String userEmail = emarsysService.getUserEmail(customer.getOriginalUid(), customer.getType());
                AddressModel defaultAddress = getDefaultAddress(customer);
                Contact contact = emarsysService.convertUserModelToContact(userEmail, customer);
                setOptinValue(optInValue, customer, contact, optinStatusCustomerAttributeField);
                if (defaultAddress != null) {
                    populateAddress(defaultAddress, contact, mappings, site);
                }
                contacts.add(contact);
            }
        }
        emarsysService.uploadContacts(contacts, mappings, site);
        LOGGER.info("EmarsysSyncUsersJob -> " + contacts.size() + " users will be synchronized");
        LOGGER.info("EmarsysSyncUsersJob -> finished...");
        return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
    }

    private AddressModel getDefaultAddress(CustomerModel customer) {
        AddressModel defaultShipmentAddress = customer.getDefaultShipmentAddress();
        if(defaultShipmentAddress != null){
            return defaultShipmentAddress;
        }else {
            List<AddressModel> addressBook = customerAccountService.getAddressBookEntries(customer);
            if(CollectionUtils.isNotEmpty(addressBook)){
                return addressBook.get(0);
            }else {
                return null;
            }
        }
    }

    private void setOptinValue(OptIn optInValue, CustomerModel customer, Contact contact, String optinStatusCustomerAttributeField) {
        if(optInValue == null){
            //set optin depending on attr
            OptIn optInValueDependingOnAttr = getOptInValueDependingOnAttr(customer, optinStatusCustomerAttributeField);
            contact.setOptIn(optInValueDependingOnAttr);
            LOGGER.info("Setting optin attr for customer " + customer.getName() + " depending on attribute: " + optInValueDependingOnAttr.name());
        }else {
            LOGGER.info("Setting optin attr  for customer " + customer.getName() + ": " + optInValue.name());
            contact.setOptIn(optInValue);
        }
    }

    private OptIn getOptInValueDependingOnAttr(CustomerModel customer, String optinStatusCustomerAttributeField) {
        Object property = EmarsysObjectUtils.getNestedProperty(customer, optinStatusCustomerAttributeField);
        if(Boolean.TRUE.equals(property)){
            return OptIn.TRUE;
        }else if(Boolean.FALSE.equals(property)){
            return OptIn.FALSE;
        }
        return OptIn.DEFAULT;
    }

    private OptIn getOptInValue(EmarsysOptinStatusEnum optinStatus) {
        OptIn optInValue = null;
        switch (optinStatus.getCode()){
            case OPTIN_STATUS_ALL_EMPTY: {
                optInValue = OptIn.DEFAULT;
                LOGGER.debug("Optin value: OptIn.DEFAULT");
                break;
            }
            case OPTIN_STATUS_ALL_TRUE: {
                optInValue = OptIn.TRUE;
                LOGGER.debug("Optin value: OptIn.TRUE");
                break;
            }
        }
        LOGGER.debug("Optin value: depending on attr");
        return optInValue;
    }

    private void populateAddress(AddressModel addressModel, Contact contact, Map<String, String> fieldsMappings, BaseSiteModel site) {

        for (Map.Entry<String, String> mappings : fieldsMappings.entrySet()) {
            try {
                String hybrisFieldName = mappings.getKey();
                String emarsysFieldName = mappings.getValue();
                Object hybrisValue;
                switch (hybrisFieldName) {
                    case FIELD_EMAIL:
                    case FIELD_OPTIN:
                    case FIELD_FNAME:
                    case FIELD_LNAME:
                    case FIELD_TITLE: continue; //skip fields
                    case FIELD_ADDRESS:
                        String line1 = addressModel.getLine1();
                        String line2 = addressModel.getLine2();
                        hybrisValue = Objects.toString(line1, "") + " " + Objects.toString(line2, "");
                        break;
                    case FIELD_COUNTRY:
                        String countryName = (String) EmarsysObjectUtils.getNestedProperty(addressModel, hybrisFieldName);
                        hybrisValue = emarsysService.getCountryIdByName(site, countryName);
                        break;
                    default:
                        hybrisValue = EmarsysObjectUtils.getNestedProperty(addressModel, hybrisFieldName);
                }
                PropertyUtils.setProperty(contact, emarsysFieldName, hybrisValue);
            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                LOGGER.error("Cannot populate properties", e);
            }
        }
    }

    private Map<String, String> getFieldsMappings(Map<EmarsysInitialDBLoadCustomerFieldEnum, EmarsysInitialDBLoadPlaceholderEnum> map) {
        Map<String, String> mapping = new HashMap<String, String>();
        for (Map.Entry<EmarsysInitialDBLoadCustomerFieldEnum, EmarsysInitialDBLoadPlaceholderEnum> entry : map.entrySet())
		{
		    mapping.put(entry.getKey().toString(), entry.getValue().toString());
		}
		
		return mapping;
    }

    @Required
    public void setEmarsysService(EmarsysService emarsysService) {
        this.emarsysService = emarsysService;
    }

    @Required
    public void setCustomerAccountService(final CustomerAccountService customerAccountService){
        this.customerAccountService = customerAccountService;
    }

}

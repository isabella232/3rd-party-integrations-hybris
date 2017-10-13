package com.osfglobal.hybris.emarsys.services.impl;

import com.osfglobal.emarsys.client.Contact;
import com.osfglobal.emarsys.client.EmarsysClient;
import com.osfglobal.emarsys.client.EmarsysClientImpl;
import com.osfglobal.emarsys.client.Event;
import com.osfglobal.emarsys.client.beans.EmarsysClientConfig;
import com.osfglobal.emarsys.client.exceptions.EmarsysClientException;
import com.osfglobal.hybris.emarsys.dao.EmarsysCustomerDao;
import com.osfglobal.hybris.emarsys.enums.EmarsysExternalEventsEnum;
import com.osfglobal.hybris.emarsys.services.EmarsysConfig;
import com.osfglobal.hybris.emarsys.services.EmarsysService;
import com.osfglobal.hybris.emarsys.services.enums.EmarsysPage;
import com.osfglobal.hybris.emarsys.services.enums.EmarsysSalutation;
import com.osfglobal.hybris.emarsys.services.enums.EmarsysTitle;
import com.osfglobal.hybris.emarsys.services.exceptions.EmarsysServiceException;
import de.hybris.platform.basecommerce.model.site.BaseSiteModel;
import de.hybris.platform.commercefacades.user.data.AddressData;
import de.hybris.platform.commercefacades.user.data.CountryData;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.commercefacades.user.data.RegionData;
import de.hybris.platform.commerceservices.enums.CustomerType;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Emarsys service implementation
 */
public class EmarsysServiceImpl implements EmarsysService {

    public static final int COUNTRY_FIELD_ID = 14;

    private static final Logger LOG = Logger.getLogger(EmarsysServiceImpl.class);
    public static final String HYBRIS_AUTOIMPORT_NAME = "hybris_autoimport";

    private EmarsysConfig emarsysConfig;

    private EmarsysCustomerDao emarsysCustomerDao;

    private Converter<UserModel, CustomerData> customerConverter;


    @Override
    public void triggerEmarsysEvent(BaseSiteModel site, Contact contact, String optInEventName, Map<String, String> placeholders) {
        try {
            getEmarsysClient(site).triggerEvent(optInEventName, contact, placeholders);
        } catch (EmarsysClientException e) {
            LOG.error("Internal server error. Can not trigger event " + optInEventName + ": " + e.getMessage(), e);
            throw new EmarsysServiceException("Internal server error. Can not trigger event " + optInEventName + ".", e);
        }
    }


    /**
     * Create or update contact instance in emarsys
     *
     * @param site
     * @param contact
     * @return created/updated contact
     */
    @Override
    public Contact createOrUpdateContactInEmarsys(BaseSiteModel site, Contact contact) {
        EmarsysClient emarsysClient = getEmarsysClient(site);
        if(StringUtils.isEmpty(contact.getId())) {
            contact = emarsysClient.createContact(contact);
        } else {
            emarsysClient.updateContact(contact);
        }
        return contact;
    }

    @Override
    public void triggerConfirmationEvent(BaseSiteModel site, EmarsysPage page, Contact contact) {
        EmarsysExternalEventsEnum confirmationEvent = emarsysConfig.getOptinConfirmationEvent(site, page);
        if(confirmationEvent != null){
            //add base url placeholder
            String baseUrl = site.getEmarsysSiteUrl();
            Map<String,String> placeholders = new HashMap<>();
            placeholders.put("baseUrl", baseUrl);
            getEmarsysClient(site).triggerEvent(confirmationEvent.toString(), contact, placeholders);
        }
    }

    @Override
    public Contact convertUserModelToContact(String email, UserModel user) {
        CustomerData customerData = customerConverter.convert(user);
        String firstName = customerData.getFirstName();
        String lastName = customerData.getLastName();
        String titleCode = customerData.getTitleCode();
        Optional<EmarsysSalutation> emarsysSalutation = Optional.ofNullable(EmarsysSalutation.fromTitleCode(titleCode));
        Optional<EmarsysTitle> emarsysTitle = Optional.ofNullable(EmarsysTitle.fromTitleCode(titleCode));
        return Contact.newBuilder()
                .email(email)
                .firstName(firstName)
                .lastName(lastName)
                .salutation(emarsysSalutation.orElse(EmarsysSalutation.EMPTY).getSalutationId())
                .gender(emarsysSalutation.orElse(EmarsysSalutation.EMPTY).getSalutationId())
                .title(emarsysTitle.orElse(EmarsysTitle.EMPTY).getTitle())
                .build();
    }

    /**
     * Obtain user email from uid
     * @return
     */
    @Override
    public String getUserEmail(String uid, CustomerType customerType) {
        String userEmail = uid;
        if (CustomerType.GUEST.equals(customerType)) {
            String[] tokens = uid.split("\\|");
            if (tokens.length == 2) {
                userEmail = tokens[1];
            } else {
                LOG.warn("Cannot obtain guest email from uid " + uid);
                userEmail = null;
            }
        }
        return userEmail;
    }

    /**
     * Get country id by its name
     * @param countryName
     * @return
     */
    @Override
    public String getCountryIdByName(BaseSiteModel site, String countryName) {
        List<Map<String, String>> fieldValues = getEmarsysClient(site).getFieldValues(COUNTRY_FIELD_ID);
        for (Map<String, String> field : fieldValues) {
            if(field.get("choice") != null && field.get("choice").equals(countryName)){
                return field.get("value");
            }
        }
        return null;
    }

    /**
     * Initial db load
     * @param contacts
     * @param mappings
     * @param site
     */
    @Override
    public void uploadContacts(List<Contact> contacts, Map<String, String> mappings, BaseSiteModel site){
        EmarsysClient emarsysClient = getEmarsysClient(site);
        //delete existing auto-imports
        emarsysClient
                .getAllAutoImports()
                .stream()
                .filter(autoImport -> autoImport.getName().equals(HYBRIS_AUTOIMPORT_NAME))
                .forEach(autoImport -> emarsysClient.deleteAutoImportById(autoImport.getId()));
        //create a new auto-import and return a filename
        String fileName = emarsysClient.createAutoImport(HYBRIS_AUTOIMPORT_NAME, mappings);
        emarsysClient.uploadContacts(contacts, fileName, mappings);
    }

    /**
     * Obtain Emarsys client for BaseSite
     * @param site
     * @return
     */
    public EmarsysClient getEmarsysClient(BaseSiteModel site) {
        EmarsysClientConfig emarsysClientConfig = emarsysConfig.getEmarsysClientConfig(site);
        return new EmarsysClientImpl(emarsysClientConfig);
    }



    /**
     * Get all customers from the database
     * @return
     */
    @Override
    public List<CustomerModel> getAllCustomers() {
        return emarsysCustomerDao.getAllCustomers();
    }


    @Override
    public List<Contact> getContactsByEmail(BaseSiteModel site, String email) {
        return getEmarsysClient(site).getContactsByEmail(email);
    }

    @Override
    public Contact getContactByUid(BaseSiteModel site, String uid) {
        return getEmarsysClient(site).getContactByUid(uid);
    }

    /**
     * Populate contact data with values from both customer and address data
     * @param site
     * @param contact
     * @param customerData
     * @param addressData
     */
    @Override
    public void populateContactFromCustomerAndAddressData(BaseSiteModel site, Contact contact, CustomerData customerData, AddressData addressData) {
        String titleCode = customerData.getTitleCode();

        contact.setFirstName(customerData.getFirstName());
        contact.setLastName(customerData.getLastName());
        Optional<EmarsysSalutation> emarsysSalutation = Optional.ofNullable(EmarsysSalutation.fromTitleCode(titleCode));
        Optional<EmarsysTitle> emarsysTitle = Optional.ofNullable(EmarsysTitle.fromTitleCode(titleCode));

        contact.setGender(emarsysSalutation.orElse(EmarsysSalutation.EMPTY).getSalutationId());
        contact.setSalutation(emarsysSalutation.orElse(EmarsysSalutation.EMPTY).getSalutationId());
        contact.setTitle(emarsysTitle.orElse(EmarsysTitle.EMPTY).getTitle());

        if (addressData != null) {
            String line1 = addressData.getLine1();
            String line2 = addressData.getLine2();
            String address = Objects.toString(line1, "") + " " + Objects.toString(line2, "");
            contact.setAddress(address);
            CountryData country = addressData.getCountry();
            if (country != null) {
                contact.setCountry(getCountryIdByName(site, country.getName()));
            }else {
                contact.setCountry("");
            }
            contact.setCity(addressData.getTown());
            RegionData region = addressData.getRegion();
            if (region != null) {
                contact.setState(region.getName());
            }else {
                contact.setState("");
            }
            contact.setPhone(addressData.getPhone());
            contact.setZipcode(addressData.getPostalCode());
        }else {
            contact.setAddress("");
            contact.setCountry("");
            contact.setCity("");
            contact.setState("");
            contact.setPhone("");
            contact.setZipcode("");
        }
    }

    /**
     * Update contact in Emarsys
     * @param site
     * @param contact
     */
    @Override
    public void updateContact(BaseSiteModel site, Contact contact) {
        try {
            getEmarsysClient(site).updateContact(contact);
        } catch (EmarsysClientException ece) {
            LOG.error("An error occured during update operation: " + ece.getMessage(), ece);
            throw new EmarsysServiceException(ece);
        }
    }

    @Override
    public List<Event> getExternalEventsFromEmarsys(BaseSiteModel site) {
        return getEmarsysClient(site).externalEvents();
    }

    @Override
    public void unsubscribeContact(BaseSiteModel site, Contact contact, String cid, String llid) {
        getEmarsysClient(site).unsubscribeContact(cid, llid, contact.getUid());
    }

    @Override
    public Contact createContact(BaseSiteModel site, String email) {
        return getEmarsysClient(site).createContact(Contact.newBuilder().email(email).build());
    }
    @Override
    public Contact createContact(BaseSiteModel site, Contact contact) {
        return getEmarsysClient(site).createContact(contact);
    }
    @Required
    public void setEmarsysConfig(final EmarsysConfig emarsysConfig)
    {
        this.emarsysConfig = emarsysConfig;
    }

    @Required
    public void setEmarsysCustomerDao(EmarsysCustomerDao emarsysCustomerDao) {
        this.emarsysCustomerDao = emarsysCustomerDao;
    }

    @Required
    public void setCustomerConverter(Converter<UserModel, CustomerData> customerConverter) {
        this.customerConverter = customerConverter;
    }
}

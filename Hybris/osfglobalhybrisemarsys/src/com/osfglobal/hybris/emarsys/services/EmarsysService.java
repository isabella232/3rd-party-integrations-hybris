package com.osfglobal.hybris.emarsys.services;

import com.osfglobal.emarsys.client.Contact;
import com.osfglobal.emarsys.client.Event;
import com.osfglobal.hybris.emarsys.services.enums.EmarsysPage;
import de.hybris.platform.basecommerce.model.site.BaseSiteModel;
import de.hybris.platform.commercefacades.user.data.AddressData;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.commerceservices.enums.CustomerType;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.core.model.user.UserModel;

import java.util.List;
import java.util.Map;

/**
 * Emarsys service
 */
public interface EmarsysService {

    void triggerEmarsysEvent(BaseSiteModel site, Contact contact, String optInEventName, Map<String, String> placeholders);

    void triggerConfirmationEvent(BaseSiteModel site, EmarsysPage page, Contact contact);

    Contact createOrUpdateContactInEmarsys(BaseSiteModel site, Contact contact);

    Contact convertUserModelToContact(String email, UserModel user);

    String getUserEmail(String uid, CustomerType customerType);

    String getCountryIdByName(BaseSiteModel site, String countryName);

    void uploadContacts(List<Contact> contacts, Map<String, String> mappings, BaseSiteModel site);

    List<CustomerModel> getAllCustomers();

    List<Contact> getContactsByEmail(BaseSiteModel site, String email);

    Contact getContactByUid(BaseSiteModel site, String email);

    void populateContactFromCustomerAndAddressData(BaseSiteModel site, Contact contact, CustomerData customerData, AddressData addressData);

    void updateContact(BaseSiteModel site, Contact contact);

    List<Event> getExternalEventsFromEmarsys(BaseSiteModel site);

    void unsubscribeContact(BaseSiteModel baseSite, Contact contact, String cid, String llid);

    Contact createContact(BaseSiteModel site, String email);

    Contact createContact(BaseSiteModel site, Contact contact);
}

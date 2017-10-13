package com.osfglobal.hybris.emarsys.facades;

import com.osfglobal.emarsys.client.Contact;
import com.osfglobal.hybris.emarsys.services.enums.EmarsysPage;
import com.osfglobal.hybris.emarsys.services.exceptions.EmarsysClientAlreadySubscribedException;
import com.osfglobal.hybris.emarsys.services.exceptions.EmarsysServiceException;
import com.osfglobal.hybris.emarsys.services.exceptions.EmarsysSubscriptionDoesntExistException;

import de.hybris.platform.basecommerce.model.site.BaseSiteModel;
import de.hybris.platform.commercefacades.user.data.AddressData;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.commerceservices.customer.DuplicateUidException;

/**
 * Created by Roman on 29/04/2016.
 */
public interface EmarsysSubscriptionFacade {
    void subscribe(BaseSiteModel site, EmarsysPage page, Contact contact, Boolean forceOptIn) throws EmarsysServiceException;
    void unsubscribe(BaseSiteModel site, String uid, String llid, String cid) throws EmarsysSubscriptionDoesntExistException;
	void addToNewsletterListFromCheckout(String email, boolean forceOptin, AddressData addressData);
    void confirmDoubleOptInSubscription(BaseSiteModel currentBaseSite, String subscriptionToken, EmarsysPage page) throws EmarsysClientAlreadySubscribedException, EmarsysSubscriptionDoesntExistException ;

	void processSubscribtion(Boolean forceOptIn, String firstName, String lastName, String email, String titleCode,
			EmarsysPage emarsysPage);
	void subcribeCustomer(CustomerData currentCustomer, EmarsysPage myaccount);
	boolean unsubscribeCustomer(CustomerData currentUser);
	void quickSubscribe(String email, EmarsysPage footer);
	void anonymousSubscribe(EmarsysPage page, String firstName, String flastName, String email, Boolean gender);
	void createOrUpdateContact(String newEmail, String oldEmail, EmarsysPage page, Boolean forceOptIn)
			throws DuplicateUidException;
	void updateContactInEmarsys(AddressData defaultAddress, CustomerData currentCustomer);
}

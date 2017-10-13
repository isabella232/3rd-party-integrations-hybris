package com.osfglobal.hybris.emarsys.facades.impl;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.osfglobal.emarsys.client.Contact;
import com.osfglobal.emarsys.client.OptIn;
import com.osfglobal.emarsys.client.exceptions.EmarsysClientException;
import com.osfglobal.hybris.emarsys.facades.EmarsysSubscriptionFacade;
import com.osfglobal.hybris.emarsys.services.*;
import com.osfglobal.hybris.emarsys.services.enums.EmarsysOptIn;
import com.osfglobal.hybris.emarsys.services.enums.EmarsysPage;
import com.osfglobal.hybris.emarsys.services.enums.EmarsysSalutation;
import com.osfglobal.hybris.emarsys.services.enums.EmarsysTitle;
import com.osfglobal.hybris.emarsys.services.exceptions.EmarsysClientAlreadySubscribedException;
import com.osfglobal.hybris.emarsys.services.exceptions.EmarsysServiceException;
import com.osfglobal.hybris.emarsys.services.exceptions.EmarsysSubscriptionDoesntExistException;

import de.hybris.platform.basecommerce.model.site.BaseSiteModel;
import de.hybris.platform.commercefacades.customer.CustomerFacade;
import de.hybris.platform.commercefacades.user.UserFacade;
import de.hybris.platform.commercefacades.user.data.AddressData;
import de.hybris.platform.commercefacades.user.data.CountryData;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.commercefacades.user.data.RegionData;
import de.hybris.platform.commerceservices.customer.DuplicateUidException;
import de.hybris.platform.site.BaseSiteService;

import org.apache.commons.lang.BooleanUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;


public class EmarsysSubscriptionFacadeImpl implements EmarsysSubscriptionFacade {
	private static final Logger LOGGER = Logger.getLogger(EmarsysSubscriptionFacadeImpl.class);

	private EmarsysService emarsysService;

	private EmarsysConfig emarsysConfig;

	private BaseSiteService baseSiteService;

	private CustomerFacade customerFacade;

	private UserFacade userFacade;

	@Override
	public void updateContactInEmarsys(final AddressData newAddress, final CustomerData currentCustomer)
	{
		try
		{
			final List<Contact> contactsByEmail = emarsysService.getContactsByEmail(baseSiteService.getCurrentBaseSite(),
					currentCustomer.getUid());
			for (final Contact contact : contactsByEmail)
			{
				emarsysService.populateContactFromCustomerAndAddressData(baseSiteService.getCurrentBaseSite(), contact,
						currentCustomer, newAddress);
				emarsysService.updateContact(baseSiteService.getCurrentBaseSite(), contact);
			}
		}
		catch (final Exception e)
		{
			LOGGER.error("Update operation is not performed in Emarsys: ", e);
		}
	}
	@Override
	public void createOrUpdateContact(String newEmail, String oldEmail, EmarsysPage page, Boolean forceOptIn)
			throws DuplicateUidException
	{
		final List<Contact> oldContacts = emarsysCheckEmail(newEmail, oldEmail);
		// update emails in emarsys
		try
		{
			if (oldContacts.isEmpty())
			{
				createNewContact(newEmail);
			} else
			{
				updateExistingContacts(newEmail, oldContacts, page, forceOptIn);
			}
		}
		catch (final EmarsysServiceException e)
		{
			LOGGER.error("Update operation is not performed in Emarsys: ", e);
		}
	}

	private void createNewContact(final String newEmail)
	{
		final CustomerData customerData = customerFacade.getCurrentCustomer();
		final AddressData defaultAddressData = userFacade.getDefaultAddress();
		// create new contact
		final Contact contact = Contact.newBuilder().email(newEmail).build();
		emarsysService.populateContactFromCustomerAndAddressData(baseSiteService.getCurrentBaseSite(), contact, customerData,
				defaultAddressData);
		emarsysService.createContact(baseSiteService.getCurrentBaseSite(), contact);
	}
	/**
	 * @param newEmail
	 * @param oldEmail
	 * @return
	 * @throws DuplicateUidException
	 */
	private List<Contact> emarsysCheckEmail(final String newEmail, final String oldEmail) throws DuplicateUidException
	{
		final List<Contact> oldContacts = emarsysService.getContactsByEmail(baseSiteService.getCurrentBaseSite(), oldEmail);
		final List<Contact> newContacts = emarsysService.getContactsByEmail(baseSiteService.getCurrentBaseSite(), newEmail);
		if (!Objects.equals(oldEmail, newEmail) && !newContacts.isEmpty())
		{
			throw new DuplicateUidException();
		}
		return oldContacts;
	}

	private void updateExistingContacts(final String newEmail, final List<Contact> oldContacts, EmarsysPage page,
			Boolean forceOptIn)
	{
		BaseSiteModel currentBaseSite = baseSiteService.getCurrentBaseSite();
		final CustomerData customerData = customerFacade.getCurrentCustomer();
		final AddressData defaultAddressData = userFacade.getDefaultAddress();
		for (final Contact contact : oldContacts)
		{
			contact.setEmail(newEmail);
			emarsysService.populateContactFromCustomerAndAddressData(currentBaseSite, contact, customerData,
					defaultAddressData);
			boolean resubscribe = false;
			if (contact.getOptIn() == OptIn.TRUE)
			{
				resubscribe = true;
				contact.setOptIn(OptIn.FALSE);
			}
			emarsysService.updateContact(currentBaseSite, contact);
			if (resubscribe)
			{
				subscribe(currentBaseSite, page, contact, forceOptIn);
			}
		}
	}
	@Override
	public void subscribe(BaseSiteModel site, EmarsysPage page, Contact contact, Boolean forceOptIn) throws EmarsysServiceException {
		LOGGER.info("EmarsysSubscriptionFacade::subscribe...");
		if (contact.getOptIn() == OptIn.TRUE) {
			throw new EmarsysClientAlreadySubscribedException("Client already subscribed");
		}

		EmarsysOptIn optIn = emarsysConfig.getOptIn(site,page);
		if(isOptInTrue(page, forceOptIn, optIn)){
			// activate OptIn feature
			contact.setOptIn(OptIn.TRUE);
		}else{
			// double opt-in will be activated later
			contact.setOptIn(OptIn.FALSE);
		}

		try {
			contact = emarsysService.createOrUpdateContactInEmarsys(site, contact);
			//createOrUpdateEmailSubscriptionInHybris(contact);
		} catch (EmarsysClientException e) {
			LOGGER.error("Internal server error. Can not create new contact: " + e.getMessage(), e);
			throw new EmarsysServiceException("Internal server error. Can not create new contact.", e);
		}

		String optInEventName = emarsysConfig.getOptInEventName(site,page);
		//add base url placeholder
		String baseUrl = site.getEmarsysSiteUrl();
		Map<String,String> placeholders = new HashMap<>();
		placeholders.put("baseUrl", baseUrl);
		placeholders.put("page", page.toString().toLowerCase());
		//skip email sending
		EnumSet<EmarsysPage> forceOptinPages = EnumSet.of(EmarsysPage.REGISTRATION, EmarsysPage.CHECKOUT);
		if(forceOptinPages.contains(page) && forceOptIn != Boolean.TRUE){
			return;
		}
		emarsysService.triggerEmarsysEvent(site, contact, optInEventName, placeholders);
		if(optIn != EmarsysOptIn.DOUBLE) {
			emarsysService.triggerConfirmationEvent(site, page, contact);
		}
	}

	/**
	 * @param currentCustomer
	 * @return
	 */
	@Override
	public void subcribeCustomer(final CustomerData currentCustomer, EmarsysPage page)
	{
		final EmarsysSalutation salutation = EmarsysSalutation.fromTitleCode(currentCustomer.getTitleCode());
		String salutationId = null;
		if (salutation != null)
		{
			salutationId = salutation.getSalutationId();
		}
		final String title = EmarsysTitle.fromTitleCode(currentCustomer.getTitleCode()).getTitle();
		final List<Contact> contacts = emarsysService.getContactsByEmail(getCurrentBaseSite(), currentCustomer.getUid());
		if (contacts.isEmpty())
		{
			final Contact contact = emarsysService.createContact(getCurrentBaseSite(), currentCustomer.getUid());
			contacts.add(contact);
		}
		for (final Contact contact : contacts)
		{
			populateContactFromCustomer(currentCustomer, salutationId, title, contact);
			subscribe(getCurrentBaseSite(), page, contact, null);
		}
	}

	/**
	 * @param form
	 * @param firstName
	 * @param flastName
	 * @return
	 */
	@Override
	public void anonymousSubscribe(EmarsysPage page, String firstName, String flastName, String email, Boolean gender)
	{
		final EmarsysSalutation salutation = EmarsysSalutation.fromBoolean(gender);
		String salutationId = null;
		if (salutation != null)
		{
			salutationId = salutation.getSalutationId();
		}
		final List<Contact> contacts = emarsysService.getContactsByEmail(getCurrentBaseSite(), email);
		if (contacts.isEmpty())
		{
			final Contact contact = emarsysService.createContact(getCurrentBaseSite(), email);
			contacts.add(contact);
		}
		for (final Contact contact : contacts)
		{
			resetContact(contact);
			contact.setFirstName(firstName);
			contact.setLastName(flastName);
			contact.setSalutation(salutationId);
			contact.setGender(salutationId);
			contact.setEmail(email);
			contact.setTitle(EmarsysTitle.EMPTY.getTitle());
			subscribe(getCurrentBaseSite(), page, contact, null);
		}
	}

	@Override
	public void unsubscribe(BaseSiteModel site, String uid, String llid, String cid) throws EmarsysSubscriptionDoesntExistException {
		LOGGER.info("EmarsysSubscriptionFacade::unsubscribe...");
		Contact contact = emarsysService.getContactByUid(site,uid);
		if(contact == null || contact.getOptIn() != OptIn.TRUE) {
			LOGGER.error("Internal server error. Can not find contact by uid = " + uid + " on Emarsys");
			throw new EmarsysSubscriptionDoesntExistException("Internal server error. Can not find contact by uid = " + uid);
		}
		contact.setOptIn(EmarsysOptIn.DISABLED.getOptInValue());
		try {
			emarsysService.updateContact(site, contact);
			//call unsubscribe endpoint
			if(llid != null && cid != null) {
				emarsysService.unsubscribeContact(site, contact, cid, llid);
			}
		} catch (EmarsysClientException e) {
			LOGGER.error("Internal server error. Can not update contact: " + e.getMessage(), e);
			throw new EmarsysServiceException("Internal server error. Can not update contact.", e);
		}
	}

	@Override
	public void addToNewsletterListFromCheckout(String email, boolean forceOptIn, AddressData addressData)
	{
		BaseSiteModel site = baseSiteService.getCurrentBaseSite();
			List<Contact> contacts = emarsysService.getContactsByEmail(site, email);
			if(contacts.isEmpty()) {
                Contact contact = emarsysService.createContact(site, email);
                contacts.add(contact);
            }
			for (Contact contact : contacts) {
                populateContactWithAddressData(site, contact, addressData);
                try {
                    subscribe(site, EmarsysPage.CHECKOUT, contact, forceOptIn);
                } catch (EmarsysClientAlreadySubscribedException e) {
                    LOGGER.warn("Your E-Mail address is already registered in our system.");
                }
            }
	}

	private void populateContactWithAddressData(BaseSiteModel site, Contact contact, AddressData addressData) {
		//build country
		CountryData country = addressData.getCountry();
		String countryId = null;
		if (country != null) {
			countryId = emarsysService.getCountryIdByName(site, country.getName());
		}
		//build salutation
		EmarsysSalutation salutation = EmarsysSalutation.fromTitleCode(addressData.getTitleCode());
		String salutationId = null;
		if (salutation != null) {
			salutationId = salutation.getSalutationId();
		}
		String title = EmarsysTitle.fromTitleCode(addressData.getTitleCode()).getTitle();
		//build region
		RegionData regionData = addressData.getRegion();
		String region = regionData != null ? regionData.getName() : null;
		//build address
		String line1 = addressData.getLine1();
		String line2 = addressData.getLine2();
		String address = Objects.toString(line1, "") + " " + Objects.toString(line2, "");
		//update a contact
		contact.setFirstName(addressData.getFirstName());
		contact.setLastName(addressData.getLastName());
		contact.setPhone(addressData.getPhone());
		contact.setCity(addressData.getTown());
		contact.setZipcode(addressData.getPostalCode());
		contact.setAddress(address);
		contact.setCountry(countryId);
		contact.setSalutation(salutationId);
		contact.setGender(salutationId);
		contact.setTitle(title);
		contact.setState(region);
	}

	private boolean isOptInTrue(EmarsysPage page, Boolean forceOptIn, EmarsysOptIn optIn) {
		return optIn == EmarsysOptIn.SINGLE  &&
				(BooleanUtils.isTrue(forceOptIn) || page == EmarsysPage.FOOTER || page == EmarsysPage.MYACCOUNT);
	}


	/**
	 * Double optIn subscription confirmation
	 *
	 * @param site
	 * @param subscriptionToken
	 * @param page
	 * @throws EmarsysServiceException
	 */
	@Override
	public void confirmDoubleOptInSubscription(BaseSiteModel site, String subscriptionToken, EmarsysPage page)
			throws EmarsysClientAlreadySubscribedException, EmarsysSubscriptionDoesntExistException {
		Contact contact = emarsysService.getContactByUid(site, subscriptionToken);
		if(contact == null) {
			LOGGER.error("Emarsys subscription with subscriptionToken = " + subscriptionToken + " doesn't exist.");
			throw new EmarsysSubscriptionDoesntExistException("Newsletter subscription with subscription token " + subscriptionToken + " doesn't exist.");
		}
		if(contact.getOptIn() == OptIn.TRUE){
			LOGGER.warn("Contact with subscriptionToken = " + subscriptionToken + " is already subscribed");
			throw new EmarsysClientAlreadySubscribedException("Client is already subscribed");
		}
		contact.setOptIn(EmarsysOptIn.DOUBLE.getOptInValue());
		try {
			emarsysService.updateContact(site, contact);
			emarsysService.triggerConfirmationEvent(site, page, contact);
		} catch (EmarsysClientException e) {
			LOGGER.error("Internal server error. Can not update contact: " + e.getMessage(), e);
			throw new EmarsysServiceException("Internal server error. Can not update contact.", e);
		}
	}


	/**
	 * @param forceOptIn
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param titleCode
	 */
	@Override
	public void processSubscribtion(Boolean forceOptIn, String firstName, String lastName, String email,
			String titleCode, EmarsysPage emarsysPage)

	{
		List<Contact> contacts = emarsysService.getContactsByEmail(getCurrentBaseSite(), email);

		Optional<EmarsysSalutation> emarsysSalutation = Optional.ofNullable(EmarsysSalutation.fromTitleCode(titleCode));

		Optional<EmarsysTitle> emarsysTitle = Optional.ofNullable(EmarsysTitle.fromTitleCode(titleCode));
		if (contacts.isEmpty()) {
			Contact contact = emarsysService.createContact(getCurrentBaseSite(), email);
			contacts.add(contact);
		}
		for (Contact contact : contacts) {
			fillContact(firstName, lastName, emarsysSalutation, emarsysTitle, contact);
			try {
				subscribe(getCurrentBaseSite(), emarsysPage, contact,
						forceOptIn);
			} catch (EmarsysClientAlreadySubscribedException e) {
				LOGGER.warn("The user with email " + email + " is already subscribed");
			}
		}
	}

	/***
	@param currentCustomer
	 * @param salutationId
	 * @param title
	 * @param contact
	 */
	private void populateContactFromCustomer(final CustomerData currentCustomer, String salutationId, final String title,
			final Contact contact)
	{
		contact.setEmail(currentCustomer.getUid());
		contact.setGender(salutationId);
		contact.setSalutation(salutationId);
		contact.setTitle(title);
		contact.setFirstName(currentCustomer.getFirstName());
		contact.setLastName(currentCustomer.getLastName());
	}

	private BaseSiteModel getCurrentBaseSite() {
		return baseSiteService.getCurrentBaseSite();
	}

	/**
	 * @param firstName
	 * @param lastName
	 * @param emarsysSalutation
	 * @param emarsysTitle
	 * @param contact
	 */
	private void fillContact(String firstName, String lastName, Optional<EmarsysSalutation> emarsysSalutation,
			Optional<EmarsysTitle> emarsysTitle, Contact contact) {
		contact.setFirstName(firstName);
		contact.setLastName(lastName);
		String salutationId = emarsysSalutation.orElse(EmarsysSalutation.EMPTY).getSalutationId();
		contact.setSalutation(salutationId);
		contact.setGender(salutationId);
		contact.setTitle(emarsysTitle.orElse(EmarsysTitle.EMPTY).getTitle());
	}


	@Override
	public void quickSubscribe(String email, EmarsysPage page)
	{
		final List<Contact> contacts = emarsysService.getContactsByEmail(getCurrentBaseSite(), email);
		if (contacts.isEmpty())
		{
			final Contact contact = emarsysService.createContact(getCurrentBaseSite(), email);
			contacts.add(contact);
		}
		for (final Contact contact : contacts)
		{
			resetContact(contact);
			contact.setEmail(email);
			subscribe(getCurrentBaseSite(), page, contact, null);

		}
	}
	@Override
	public boolean unsubscribeCustomer(CustomerData currentUser)
	{
			final String customerEmail = currentUser.getUid();
			final List<Contact> contacts = emarsysService.getContactsByEmail(getCurrentBaseSite(), customerEmail);

			final List<Contact> subscribedContacts = contacts.stream().filter(contact -> contact.getOptIn() == OptIn.TRUE)
					.collect(Collectors.toList());
			if (subscribedContacts.isEmpty())
			{

				return false;
			}
			for (final Contact subscribedContact : subscribedContacts)
			{
				try
				{
				unsubscribe(getCurrentBaseSite(), subscribedContact.getUid(), null, null);
				}
				catch (final EmarsysSubscriptionDoesntExistException e)
				{
					return false;
				}
			}

			return true;
		}
	/**
	 * Set all string fields to be empty
	 * 
	 * @param contact
	 */
	private void resetContact(final Contact contact)
	{
		for (final Field field : Contact.class.getDeclaredFields())
		{
			if (field.getType().isAssignableFrom(String.class) && field.getAnnotation(JsonProperty.class) != null)
			{
				field.setAccessible(true);
				ReflectionUtils.setField(field, contact, "");
			}
		}
	}
	/**
	 * @param baseSiteService
	 *            the baseSiteService to set
	 */
	public void setBaseSiteService(BaseSiteService baseSiteService)
	{
		this.baseSiteService = baseSiteService;
	}

	@Required
	public void setEmarsysService(EmarsysService emarsysService)
	{
		this.emarsysService = emarsysService;
	}

	@Required
	public void setEmarsysConfig(EmarsysConfig emarsysConfig)
	{
		this.emarsysConfig = emarsysConfig;
	}
	/**
	 * @return the customerFacade
	 */
	public CustomerFacade getCustomerFacade()
	{
		return customerFacade;
	}
	/**
	 * @param customerFacade
	 *            the customerFacade to set
	 */
	public void setCustomerFacade(CustomerFacade customerFacade)
	{
		this.customerFacade = customerFacade;
	}
	/**
	 * @return the userFacade
	 */
	public UserFacade getUserFacade()
	{
		return userFacade;
	}
	/**
	 * @param userFacade
	 *            the userFacade to set
	 */
	public void setUserFacade(UserFacade userFacade)
	{
		this.userFacade = userFacade;
	}

}

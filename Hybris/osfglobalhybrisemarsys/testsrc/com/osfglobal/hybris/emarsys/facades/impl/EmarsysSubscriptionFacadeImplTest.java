package com.osfglobal.hybris.emarsys.facades.impl;

import com.osfglobal.emarsys.client.Contact;
import com.osfglobal.emarsys.client.OptIn;
import com.osfglobal.hybris.emarsys.services.EmarsysConfig;
import com.osfglobal.hybris.emarsys.services.EmarsysService;
import com.osfglobal.hybris.emarsys.services.enums.EmarsysOptIn;
import com.osfglobal.hybris.emarsys.services.enums.EmarsysPage;
import com.osfglobal.hybris.emarsys.services.enums.EmarsysSalutation;
import com.osfglobal.hybris.emarsys.services.exceptions.EmarsysClientAlreadySubscribedException;
import com.osfglobal.hybris.emarsys.services.exceptions.EmarsysSubscriptionDoesntExistException;
import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.basecommerce.model.site.BaseSiteModel;
import de.hybris.platform.commercefacades.user.data.AddressData;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.site.BaseSiteService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyMap;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@UnitTest
public class EmarsysSubscriptionFacadeImplTest
{
	@Mock
	EmarsysService emarsysService;
	@Mock
	EmarsysConfig emarsysConfig;

	@Mock
	BaseSiteService baseSiteService;

	private BaseSiteModel baseSite;
	private EmarsysSubscriptionFacadeImpl emarsysSubscriptionFacadeImpl;
	private Contact contact;
	private String email = "jojndoe@domain.com";

	@Before
	public void setUp()
	{
		MockitoAnnotations.initMocks(this);
		emarsysSubscriptionFacadeImpl = new EmarsysSubscriptionFacadeImpl();
		emarsysSubscriptionFacadeImpl.setBaseSiteService(baseSiteService);
		emarsysSubscriptionFacadeImpl.setEmarsysService(emarsysService);
		emarsysSubscriptionFacadeImpl.setEmarsysConfig(emarsysConfig);
		baseSite = new BaseSiteModel();
		contact = getJohnDoeContact();
		when(baseSiteService.getCurrentBaseSite()).thenReturn(baseSite);
		//stubbing api call
		willDoNothing().given(emarsysService).triggerEmarsysEvent(any(), any(), any(), any());
		when(emarsysService.createContact(baseSite, email)).thenReturn(contact);
		when(emarsysService.createOrUpdateContactInEmarsys(baseSite, contact)).thenReturn(contact);
		when(emarsysService.getContactsByEmail(baseSite, email)).thenReturn(new ArrayList<>(Collections.singletonList(contact)));
		when(emarsysConfig.getOptInEventName(eq(baseSite),any(EmarsysPage.class))).thenReturn("externalEventName");

	}

	@Test
	public void quickSubscribeFooterOK(){
		emarsysSubscriptionFacadeImpl.quickSubscribe(email, EmarsysPage.FOOTER);
		verify(emarsysService).triggerEmarsysEvent(eq(baseSite),eq(contact), eq("externalEventName"), anyMap());
	}

	@Test(expected = EmarsysClientAlreadySubscribedException.class)
	public void quickSubscribeFooterAlreadySubscribed(){
		contact.setOptIn(OptIn.TRUE);
		emarsysSubscriptionFacadeImpl.quickSubscribe(email, EmarsysPage.FOOTER);
		verify(emarsysService).triggerEmarsysEvent(eq(baseSite),eq(contact), eq("externalEventName"), anyMap());
	}


	@Test
	public void unsubscribeOK() throws Exception {
		contact.setOptIn(OptIn.TRUE);
		when(emarsysService.getContactByUid(eq(baseSite),anyString())).thenReturn(contact);
		emarsysSubscriptionFacadeImpl.unsubscribe(baseSite, "dummyUid", null, null);
		verify(emarsysService).updateContact(eq(baseSite),eq(contact));
	}

	@Test(expected = EmarsysSubscriptionDoesntExistException.class)
	public void unsubscribeNoSubscription() throws Exception {
		contact.setOptIn(OptIn.FALSE);
		when(emarsysService.getContactByUid(eq(baseSite),anyString())).thenReturn(contact);
		emarsysSubscriptionFacadeImpl.unsubscribe(baseSite, "dummyUid", null, null);
		verify(emarsysService).updateContact(eq(baseSite),eq(contact));
	}

	@Test
	public void addToNewsletterListFromCheckoutOK() throws Exception {
		AddressData addressData = getJohnDoeAddressData();
		contact.setOptIn(OptIn.FALSE);
		when(emarsysConfig.getOptIn(baseSite, EmarsysPage.CHECKOUT)).thenReturn(EmarsysOptIn.SINGLE);
		emarsysSubscriptionFacadeImpl.addToNewsletterListFromCheckout(email, true, addressData);
		verify(emarsysService).triggerEmarsysEvent(eq(baseSite), eq(contact), eq("externalEventName"),anyMap());
	}

	@Test
	public void addToNewsletterListFromCheckoutMoreThanOneCustomer() throws Exception {
		AddressData addressData = getJohnDoeAddressData();
		contact.setOptIn(OptIn.FALSE);
		Contact contact2 = Contact.newBuilder().email(email).firstName("mat").lastName("thomas").build();
		when(emarsysService.getContactsByEmail(baseSite, email)).thenReturn(new ArrayList<>(Arrays.asList(contact, contact2)));
		when(emarsysConfig.getOptIn(baseSite, EmarsysPage.CHECKOUT)).thenReturn(EmarsysOptIn.SINGLE);
		emarsysSubscriptionFacadeImpl.addToNewsletterListFromCheckout(email, true, addressData);
		verify(emarsysService, times(2)).triggerEmarsysEvent(eq(baseSite), any(Contact.class), eq("externalEventName"),anyMap());
	}

	@Test
	public void confirmDoubleOptInSubscriptionOK() throws Exception {
		contact.setOptIn(OptIn.FALSE);
		when(emarsysService.getContactByUid(eq(baseSite), anyString())).thenReturn(contact);
		emarsysSubscriptionFacadeImpl.confirmDoubleOptInSubscription(baseSite, "qwddqwdq", EmarsysPage.CHECKOUT);
		verify(emarsysService).triggerConfirmationEvent(baseSite, EmarsysPage.CHECKOUT, contact);
	}


	@Test(expected = EmarsysSubscriptionDoesntExistException.class)
	public void confirmDoubleOptInSubscriptionNoSubscription() throws Exception {
		when(emarsysService.getContactByUid(eq(baseSite), anyString())).thenReturn(null);
		emarsysSubscriptionFacadeImpl.confirmDoubleOptInSubscription(baseSite, "qwddqwdq", EmarsysPage.CHECKOUT);
		verify(emarsysService).triggerConfirmationEvent(baseSite, EmarsysPage.CHECKOUT, contact);
	}

	@Test(expected = EmarsysClientAlreadySubscribedException.class)
	public void confirmDoubleOptInSubscriptionAlreadySubscribed() throws Exception {
		contact.setOptIn(OptIn.TRUE);
		when(emarsysService.getContactByUid(eq(baseSite),anyString())).thenReturn(contact);
		emarsysSubscriptionFacadeImpl.confirmDoubleOptInSubscription(baseSite, "qwddqwdq", EmarsysPage.CHECKOUT);
		verify(emarsysService).triggerConfirmationEvent(baseSite, EmarsysPage.CHECKOUT, contact);
	}

	@Test
	public void processSubscriptionTest() throws Exception {
		contact.setOptIn(OptIn.FALSE);
		emarsysSubscriptionFacadeImpl.processSubscribtion(true, "john","doe", email, "dr", EmarsysPage.CHECKOUT);
		verify(emarsysService).triggerEmarsysEvent(eq(baseSite), eq(contact), eq("externalEventName"), anyMap());
	}

	@Test
	public void subscribeCustomer() throws Exception {
		contact.setOptIn(OptIn.FALSE);
		emarsysSubscriptionFacadeImpl.subcribeCustomer(getJohnDoeCustomerData(), EmarsysPage.CHECKOUT);
		verify(emarsysService, never()).triggerEmarsysEvent(eq(baseSite), eq(contact), eq("externalEventName"), anyMap());
	}

	@Test
	public void unsubscribeCustomer() throws Exception {
		emarsysSubscriptionFacadeImpl.unsubscribeCustomer(getJohnDoeCustomerData());
		verify(emarsysService, never()).triggerEmarsysEvent(eq(baseSite), eq(contact), eq("externalEventName"), anyMap());
	}

	private Contact getJohnDoeContact() {
		return Contact.newBuilder()
				.email(email)
				.firstName("john")
				.lastName("doe")
				.optIn(OptIn.FALSE)
				.salutation(EmarsysSalutation.MALE.getSalutationId())
				.build();
	}

	private CustomerData getJohnDoeCustomerData() {
		CustomerData customerData = new CustomerData();
		customerData.setFirstName("john");
		customerData.setLastName("doe");
		customerData.setUid(email);
		customerData.setTitleCode("mr");
		return customerData;
	}

	private AddressData getJohnDoeAddressData() {
		AddressData addressData = new AddressData();
		addressData.setTitleCode("mr");
		addressData.setFirstName("john");
		addressData.setLastName("doe");
		return addressData;
	}

}

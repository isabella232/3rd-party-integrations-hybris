package com.osfglobal.hybris.emarsys.services;

import com.osfglobal.emarsys.client.Contact;
import com.osfglobal.emarsys.client.EmarsysClient;
import com.osfglobal.hybris.emarsys.services.enums.EmarsysTitle;
import com.osfglobal.hybris.emarsys.services.impl.EmarsysServiceImpl;
import de.hybris.platform.basecommerce.model.site.BaseSiteModel;
import de.hybris.platform.commercefacades.user.data.AddressData;
import de.hybris.platform.commercefacades.user.data.CountryData;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.commercefacades.user.data.RegionData;
import de.hybris.platform.commerceservices.enums.CustomerType;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.core.model.user.TitleModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;


public class EmarsysServiceTest {
    private static final String JOHNDOE_EMAIL = "johndoe@email.com";
    private static final String JOHNDOE_FNAME = "John";
    private static final String JOHNDOE_LNAME = "Doe";
    private static final String JOHNDOE_TITLE = "dr";
    private static final String JOHNDOE_LINE_1 = "Line1";
    private static final String JOHNDOE_LINE_2 = "Line2";
    private static final String JOHNDOE_CITY = "Los Angeles, CA";
    private static final String JOHNDOE_STATE = "CA";
    private static final String JOHNDOE_POSTAL_CODE = "12345";
    private static final String JOHNDOE_PHONE = "+1234567890";
    @Spy
    private EmarsysService emarsysService = new EmarsysServiceImpl();
    @Mock
    private EmarsysClient emarsysClient;
    @Mock
    private Converter<UserModel, CustomerData> customerConverter;
    @Mock
    private BaseSiteModel baseSite;

    private Contact contact;
    private UserModel johnDoeUserModel;
    private CustomerData johnDoeCustomerData;
    private AddressData johnDoeAddressData;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        ((EmarsysServiceImpl)emarsysService).setCustomerConverter(customerConverter);

        johnDoeCustomerData = new CustomerData();
        johnDoeCustomerData.setFirstName(JOHNDOE_FNAME);
        johnDoeCustomerData.setLastName(JOHNDOE_LNAME);
        johnDoeCustomerData.setUid(JOHNDOE_EMAIL);
        johnDoeCustomerData.setTitleCode(JOHNDOE_TITLE);

        johnDoeAddressData = new AddressData();
        johnDoeAddressData.setLine1(JOHNDOE_LINE_1);
        johnDoeAddressData.setLine2(JOHNDOE_LINE_2);
        johnDoeAddressData.setCountry(new CountryData());
        johnDoeAddressData.getCountry().setName("USA");
        johnDoeAddressData.setTown(JOHNDOE_CITY);
        johnDoeAddressData.setRegion(new RegionData());
        johnDoeAddressData.getRegion().setName(JOHNDOE_STATE);
        johnDoeAddressData.setPostalCode(JOHNDOE_POSTAL_CODE);
        johnDoeAddressData.setPhone(JOHNDOE_PHONE);

        johnDoeUserModel = new CustomerModel();
        johnDoeUserModel.setUid(JOHNDOE_EMAIL);
        johnDoeUserModel.setName(JOHNDOE_FNAME + " " + JOHNDOE_LNAME);
        TitleModel title = new TitleModel();
        title.setCode(JOHNDOE_TITLE);
        ((CustomerModel) johnDoeUserModel).setTitle(title);

        doReturn(emarsysClient).when((EmarsysServiceImpl)emarsysService).getEmarsysClient(baseSite);
        doReturn(johnDoeCustomerData).when(customerConverter).convert(johnDoeUserModel);
        doReturn("1").when(emarsysService).getCountryIdByName(eq(baseSite), anyString());
        contact = Contact.newBuilder()
                .email(JOHNDOE_EMAIL)
                .lastName(JOHNDOE_LNAME)
                .firstName(JOHNDOE_FNAME)
                .title("1")
                .salutation("")
                .id("1")
                .build();
    }


    @Test
    public void createOrUpdateContactInEmarsys_CreateTest() throws Exception {
        contact.setId(null);
        emarsysService.createOrUpdateContactInEmarsys(baseSite, contact);
        verify(emarsysClient).createContact(contact);
    }

    @Test
    public void createOrUpdateContactInEmarsys_UpdateTest() throws Exception {
        emarsysService.createOrUpdateContactInEmarsys(baseSite, contact);
        verify(emarsysClient).updateContact(contact);
    }

    @Test
    public void convertUserModelToContact_TitleTest() throws Exception {
        Contact actual = emarsysService.convertUserModelToContact(JOHNDOE_EMAIL, johnDoeUserModel);
        assertThat(actual.getEmail(), is(JOHNDOE_EMAIL));
        assertThat(actual.getFirstName(), is(JOHNDOE_FNAME));
        assertThat(actual.getTitle(), is(EmarsysTitle.DR.getTitle()));
        assertThat(actual.getSalutation(), is(""));
    }


    @Test
    public void getUserEmail_GuestTest() throws Exception {
        String uid = "something|" + JOHNDOE_EMAIL;
        String actual = emarsysService.getUserEmail(uid, CustomerType.GUEST);
        assertThat(actual, is(JOHNDOE_EMAIL));
    }

    @Test
    public void getUserEmail_notGuestTest() throws Exception {
        String uid = JOHNDOE_EMAIL;
        String actual = emarsysService.getUserEmail(uid, CustomerType.valueOf("user"));
        assertThat(actual, is(JOHNDOE_EMAIL));
    }

    @Test
    public void populateContactFromCustomerAndAddressData() throws Exception {

        Contact contact = Contact.newBuilder().build();
        emarsysService.populateContactFromCustomerAndAddressData(baseSite, contact, johnDoeCustomerData, johnDoeAddressData);
        assertThat(contact.getFirstName(), is(JOHNDOE_FNAME));
        assertThat(contact.getTitle(), is(EmarsysTitle.DR.getTitle()));
        assertThat(contact.getAddress(), is(JOHNDOE_LINE_1 + " " + JOHNDOE_LINE_2));
        assertThat(contact.getCountry(), is("1"));
        assertThat(contact.getCity(), is(JOHNDOE_CITY));
        assertThat(contact.getState(), is(JOHNDOE_STATE));
        assertThat(contact.getZipcode(), is(JOHNDOE_POSTAL_CODE));
        assertThat(contact.getPhone(), is(JOHNDOE_PHONE));
    }
}
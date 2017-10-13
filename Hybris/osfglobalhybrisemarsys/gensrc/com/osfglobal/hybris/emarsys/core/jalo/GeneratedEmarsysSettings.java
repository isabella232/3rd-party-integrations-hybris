/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 7-Feb-2017 11:23:01 PM                      ---
 * ----------------------------------------------------------------
 */
package com.osfglobal.hybris.emarsys.core.jalo;

import com.osfglobal.hybris.emarsys.constants.EmarsysConstants;
import de.hybris.platform.jalo.GenericItem;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.enumeration.EnumerationValue;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type {@link com.osfglobal.hybris.emarsys.core.jalo.EmarsysSettings EmarsysSettings}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedEmarsysSettings extends GenericItem
{
	/** Qualifier of the <code>EmarsysSettings.uid</code> attribute **/
	public static final String UID = "uid";
	/** Qualifier of the <code>EmarsysSettings.emarsysApiSecret</code> attribute **/
	public static final String EMARSYSAPISECRET = "emarsysApiSecret";
	/** Qualifier of the <code>EmarsysSettings.emarsysApiUsername</code> attribute **/
	public static final String EMARSYSAPIUSERNAME = "emarsysApiUsername";
	/** Qualifier of the <code>EmarsysSettings.emarsysApiUrl</code> attribute **/
	public static final String EMARSYSAPIURL = "emarsysApiUrl";
	/** Qualifier of the <code>EmarsysSettings.emarsysWebDavUsername</code> attribute **/
	public static final String EMARSYSWEBDAVUSERNAME = "emarsysWebDavUsername";
	/** Qualifier of the <code>EmarsysSettings.emarsysWebDavPassword</code> attribute **/
	public static final String EMARSYSWEBDAVPASSWORD = "emarsysWebDavPassword";
	/** Qualifier of the <code>EmarsysSettings.emarsysWebDavUrl</code> attribute **/
	public static final String EMARSYSWEBDAVURL = "emarsysWebDavUrl";
	/** Qualifier of the <code>EmarsysSettings.footerOptin</code> attribute **/
	public static final String FOOTEROPTIN = "footerOptin";
	/** Qualifier of the <code>EmarsysSettings.footerOptinExternalEvent</code> attribute **/
	public static final String FOOTEROPTINEXTERNALEVENT = "footerOptinExternalEvent";
	/** Qualifier of the <code>EmarsysSettings.footerConfirmationExternalEvent</code> attribute **/
	public static final String FOOTERCONFIRMATIONEXTERNALEVENT = "footerConfirmationExternalEvent";
	/** Qualifier of the <code>EmarsysSettings.myAccountOptin</code> attribute **/
	public static final String MYACCOUNTOPTIN = "myAccountOptin";
	/** Qualifier of the <code>EmarsysSettings.myAccountOptinExternalEvent</code> attribute **/
	public static final String MYACCOUNTOPTINEXTERNALEVENT = "myAccountOptinExternalEvent";
	/** Qualifier of the <code>EmarsysSettings.myAccountConfirmationExternalEvent</code> attribute **/
	public static final String MYACCOUNTCONFIRMATIONEXTERNALEVENT = "myAccountConfirmationExternalEvent";
	/** Qualifier of the <code>EmarsysSettings.registerOptin</code> attribute **/
	public static final String REGISTEROPTIN = "registerOptin";
	/** Qualifier of the <code>EmarsysSettings.registerOptinExternalEvent</code> attribute **/
	public static final String REGISTEROPTINEXTERNALEVENT = "registerOptinExternalEvent";
	/** Qualifier of the <code>EmarsysSettings.registerConfirmationExternalEvent</code> attribute **/
	public static final String REGISTERCONFIRMATIONEXTERNALEVENT = "registerConfirmationExternalEvent";
	/** Qualifier of the <code>EmarsysSettings.checkoutOptin</code> attribute **/
	public static final String CHECKOUTOPTIN = "checkoutOptin";
	/** Qualifier of the <code>EmarsysSettings.checkoutOptinExternalEvent</code> attribute **/
	public static final String CHECKOUTOPTINEXTERNALEVENT = "checkoutOptinExternalEvent";
	/** Qualifier of the <code>EmarsysSettings.checkoutConfirmationExternalEvent</code> attribute **/
	public static final String CHECKOUTCONFIRMATIONEXTERNALEVENT = "checkoutConfirmationExternalEvent";
	/** Qualifier of the <code>EmarsysSettings.orderConfirmationExternalEvent</code> attribute **/
	public static final String ORDERCONFIRMATIONEXTERNALEVENT = "orderConfirmationExternalEvent";
	/** Qualifier of the <code>EmarsysSettings.shippingConfirmationExternalEvent</code> attribute **/
	public static final String SHIPPINGCONFIRMATIONEXTERNALEVENT = "shippingConfirmationExternalEvent";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>();
		tmp.put(UID, AttributeMode.INITIAL);
		tmp.put(EMARSYSAPISECRET, AttributeMode.INITIAL);
		tmp.put(EMARSYSAPIUSERNAME, AttributeMode.INITIAL);
		tmp.put(EMARSYSAPIURL, AttributeMode.INITIAL);
		tmp.put(EMARSYSWEBDAVUSERNAME, AttributeMode.INITIAL);
		tmp.put(EMARSYSWEBDAVPASSWORD, AttributeMode.INITIAL);
		tmp.put(EMARSYSWEBDAVURL, AttributeMode.INITIAL);
		tmp.put(FOOTEROPTIN, AttributeMode.INITIAL);
		tmp.put(FOOTEROPTINEXTERNALEVENT, AttributeMode.INITIAL);
		tmp.put(FOOTERCONFIRMATIONEXTERNALEVENT, AttributeMode.INITIAL);
		tmp.put(MYACCOUNTOPTIN, AttributeMode.INITIAL);
		tmp.put(MYACCOUNTOPTINEXTERNALEVENT, AttributeMode.INITIAL);
		tmp.put(MYACCOUNTCONFIRMATIONEXTERNALEVENT, AttributeMode.INITIAL);
		tmp.put(REGISTEROPTIN, AttributeMode.INITIAL);
		tmp.put(REGISTEROPTINEXTERNALEVENT, AttributeMode.INITIAL);
		tmp.put(REGISTERCONFIRMATIONEXTERNALEVENT, AttributeMode.INITIAL);
		tmp.put(CHECKOUTOPTIN, AttributeMode.INITIAL);
		tmp.put(CHECKOUTOPTINEXTERNALEVENT, AttributeMode.INITIAL);
		tmp.put(CHECKOUTCONFIRMATIONEXTERNALEVENT, AttributeMode.INITIAL);
		tmp.put(ORDERCONFIRMATIONEXTERNALEVENT, AttributeMode.INITIAL);
		tmp.put(SHIPPINGCONFIRMATIONEXTERNALEVENT, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSettings.checkoutConfirmationExternalEvent</code> attribute.
	 * @return the checkoutConfirmationExternalEvent - Checkout after confirmation external event
	 */
	public EnumerationValue getCheckoutConfirmationExternalEvent(final SessionContext ctx)
	{
		return (EnumerationValue)getProperty( ctx, CHECKOUTCONFIRMATIONEXTERNALEVENT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSettings.checkoutConfirmationExternalEvent</code> attribute.
	 * @return the checkoutConfirmationExternalEvent - Checkout after confirmation external event
	 */
	public EnumerationValue getCheckoutConfirmationExternalEvent()
	{
		return getCheckoutConfirmationExternalEvent( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSettings.checkoutConfirmationExternalEvent</code> attribute. 
	 * @param value the checkoutConfirmationExternalEvent - Checkout after confirmation external event
	 */
	public void setCheckoutConfirmationExternalEvent(final SessionContext ctx, final EnumerationValue value)
	{
		setProperty(ctx, CHECKOUTCONFIRMATIONEXTERNALEVENT,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSettings.checkoutConfirmationExternalEvent</code> attribute. 
	 * @param value the checkoutConfirmationExternalEvent - Checkout after confirmation external event
	 */
	public void setCheckoutConfirmationExternalEvent(final EnumerationValue value)
	{
		setCheckoutConfirmationExternalEvent( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSettings.checkoutOptin</code> attribute.
	 * @return the checkoutOptin - Checkout Opt-in
	 */
	public EnumerationValue getCheckoutOptin(final SessionContext ctx)
	{
		return (EnumerationValue)getProperty( ctx, CHECKOUTOPTIN);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSettings.checkoutOptin</code> attribute.
	 * @return the checkoutOptin - Checkout Opt-in
	 */
	public EnumerationValue getCheckoutOptin()
	{
		return getCheckoutOptin( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSettings.checkoutOptin</code> attribute. 
	 * @param value the checkoutOptin - Checkout Opt-in
	 */
	public void setCheckoutOptin(final SessionContext ctx, final EnumerationValue value)
	{
		setProperty(ctx, CHECKOUTOPTIN,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSettings.checkoutOptin</code> attribute. 
	 * @param value the checkoutOptin - Checkout Opt-in
	 */
	public void setCheckoutOptin(final EnumerationValue value)
	{
		setCheckoutOptin( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSettings.checkoutOptinExternalEvent</code> attribute.
	 * @return the checkoutOptinExternalEvent - Checkout single external event
	 */
	public EnumerationValue getCheckoutOptinExternalEvent(final SessionContext ctx)
	{
		return (EnumerationValue)getProperty( ctx, CHECKOUTOPTINEXTERNALEVENT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSettings.checkoutOptinExternalEvent</code> attribute.
	 * @return the checkoutOptinExternalEvent - Checkout single external event
	 */
	public EnumerationValue getCheckoutOptinExternalEvent()
	{
		return getCheckoutOptinExternalEvent( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSettings.checkoutOptinExternalEvent</code> attribute. 
	 * @param value the checkoutOptinExternalEvent - Checkout single external event
	 */
	public void setCheckoutOptinExternalEvent(final SessionContext ctx, final EnumerationValue value)
	{
		setProperty(ctx, CHECKOUTOPTINEXTERNALEVENT,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSettings.checkoutOptinExternalEvent</code> attribute. 
	 * @param value the checkoutOptinExternalEvent - Checkout single external event
	 */
	public void setCheckoutOptinExternalEvent(final EnumerationValue value)
	{
		setCheckoutOptinExternalEvent( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSettings.emarsysApiSecret</code> attribute.
	 * @return the emarsysApiSecret - Emarsys API secret
	 */
	public String getEmarsysApiSecret(final SessionContext ctx)
	{
		return (String)getProperty( ctx, EMARSYSAPISECRET);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSettings.emarsysApiSecret</code> attribute.
	 * @return the emarsysApiSecret - Emarsys API secret
	 */
	public String getEmarsysApiSecret()
	{
		return getEmarsysApiSecret( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSettings.emarsysApiSecret</code> attribute. 
	 * @param value the emarsysApiSecret - Emarsys API secret
	 */
	public void setEmarsysApiSecret(final SessionContext ctx, final String value)
	{
		setProperty(ctx, EMARSYSAPISECRET,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSettings.emarsysApiSecret</code> attribute. 
	 * @param value the emarsysApiSecret - Emarsys API secret
	 */
	public void setEmarsysApiSecret(final String value)
	{
		setEmarsysApiSecret( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSettings.emarsysApiUrl</code> attribute.
	 * @return the emarsysApiUrl - Emarsys API URL
	 */
	public String getEmarsysApiUrl(final SessionContext ctx)
	{
		return (String)getProperty( ctx, EMARSYSAPIURL);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSettings.emarsysApiUrl</code> attribute.
	 * @return the emarsysApiUrl - Emarsys API URL
	 */
	public String getEmarsysApiUrl()
	{
		return getEmarsysApiUrl( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSettings.emarsysApiUrl</code> attribute. 
	 * @param value the emarsysApiUrl - Emarsys API URL
	 */
	public void setEmarsysApiUrl(final SessionContext ctx, final String value)
	{
		setProperty(ctx, EMARSYSAPIURL,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSettings.emarsysApiUrl</code> attribute. 
	 * @param value the emarsysApiUrl - Emarsys API URL
	 */
	public void setEmarsysApiUrl(final String value)
	{
		setEmarsysApiUrl( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSettings.emarsysApiUsername</code> attribute.
	 * @return the emarsysApiUsername - Emarsys API username
	 */
	public String getEmarsysApiUsername(final SessionContext ctx)
	{
		return (String)getProperty( ctx, EMARSYSAPIUSERNAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSettings.emarsysApiUsername</code> attribute.
	 * @return the emarsysApiUsername - Emarsys API username
	 */
	public String getEmarsysApiUsername()
	{
		return getEmarsysApiUsername( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSettings.emarsysApiUsername</code> attribute. 
	 * @param value the emarsysApiUsername - Emarsys API username
	 */
	public void setEmarsysApiUsername(final SessionContext ctx, final String value)
	{
		setProperty(ctx, EMARSYSAPIUSERNAME,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSettings.emarsysApiUsername</code> attribute. 
	 * @param value the emarsysApiUsername - Emarsys API username
	 */
	public void setEmarsysApiUsername(final String value)
	{
		setEmarsysApiUsername( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSettings.emarsysWebDavPassword</code> attribute.
	 * @return the emarsysWebDavPassword - Emarsys WebDav password
	 */
	public String getEmarsysWebDavPassword(final SessionContext ctx)
	{
		return (String)getProperty( ctx, EMARSYSWEBDAVPASSWORD);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSettings.emarsysWebDavPassword</code> attribute.
	 * @return the emarsysWebDavPassword - Emarsys WebDav password
	 */
	public String getEmarsysWebDavPassword()
	{
		return getEmarsysWebDavPassword( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSettings.emarsysWebDavPassword</code> attribute. 
	 * @param value the emarsysWebDavPassword - Emarsys WebDav password
	 */
	public void setEmarsysWebDavPassword(final SessionContext ctx, final String value)
	{
		setProperty(ctx, EMARSYSWEBDAVPASSWORD,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSettings.emarsysWebDavPassword</code> attribute. 
	 * @param value the emarsysWebDavPassword - Emarsys WebDav password
	 */
	public void setEmarsysWebDavPassword(final String value)
	{
		setEmarsysWebDavPassword( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSettings.emarsysWebDavUrl</code> attribute.
	 * @return the emarsysWebDavUrl - Emarsys WebDav url
	 */
	public String getEmarsysWebDavUrl(final SessionContext ctx)
	{
		return (String)getProperty( ctx, EMARSYSWEBDAVURL);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSettings.emarsysWebDavUrl</code> attribute.
	 * @return the emarsysWebDavUrl - Emarsys WebDav url
	 */
	public String getEmarsysWebDavUrl()
	{
		return getEmarsysWebDavUrl( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSettings.emarsysWebDavUrl</code> attribute. 
	 * @param value the emarsysWebDavUrl - Emarsys WebDav url
	 */
	public void setEmarsysWebDavUrl(final SessionContext ctx, final String value)
	{
		setProperty(ctx, EMARSYSWEBDAVURL,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSettings.emarsysWebDavUrl</code> attribute. 
	 * @param value the emarsysWebDavUrl - Emarsys WebDav url
	 */
	public void setEmarsysWebDavUrl(final String value)
	{
		setEmarsysWebDavUrl( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSettings.emarsysWebDavUsername</code> attribute.
	 * @return the emarsysWebDavUsername - Emarsys WebDav username
	 */
	public String getEmarsysWebDavUsername(final SessionContext ctx)
	{
		return (String)getProperty( ctx, EMARSYSWEBDAVUSERNAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSettings.emarsysWebDavUsername</code> attribute.
	 * @return the emarsysWebDavUsername - Emarsys WebDav username
	 */
	public String getEmarsysWebDavUsername()
	{
		return getEmarsysWebDavUsername( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSettings.emarsysWebDavUsername</code> attribute. 
	 * @param value the emarsysWebDavUsername - Emarsys WebDav username
	 */
	public void setEmarsysWebDavUsername(final SessionContext ctx, final String value)
	{
		setProperty(ctx, EMARSYSWEBDAVUSERNAME,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSettings.emarsysWebDavUsername</code> attribute. 
	 * @param value the emarsysWebDavUsername - Emarsys WebDav username
	 */
	public void setEmarsysWebDavUsername(final String value)
	{
		setEmarsysWebDavUsername( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSettings.footerConfirmationExternalEvent</code> attribute.
	 * @return the footerConfirmationExternalEvent - Footer after confirmation external event
	 */
	public EnumerationValue getFooterConfirmationExternalEvent(final SessionContext ctx)
	{
		return (EnumerationValue)getProperty( ctx, FOOTERCONFIRMATIONEXTERNALEVENT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSettings.footerConfirmationExternalEvent</code> attribute.
	 * @return the footerConfirmationExternalEvent - Footer after confirmation external event
	 */
	public EnumerationValue getFooterConfirmationExternalEvent()
	{
		return getFooterConfirmationExternalEvent( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSettings.footerConfirmationExternalEvent</code> attribute. 
	 * @param value the footerConfirmationExternalEvent - Footer after confirmation external event
	 */
	public void setFooterConfirmationExternalEvent(final SessionContext ctx, final EnumerationValue value)
	{
		setProperty(ctx, FOOTERCONFIRMATIONEXTERNALEVENT,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSettings.footerConfirmationExternalEvent</code> attribute. 
	 * @param value the footerConfirmationExternalEvent - Footer after confirmation external event
	 */
	public void setFooterConfirmationExternalEvent(final EnumerationValue value)
	{
		setFooterConfirmationExternalEvent( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSettings.footerOptin</code> attribute.
	 * @return the footerOptin - Footer Optin
	 */
	public EnumerationValue getFooterOptin(final SessionContext ctx)
	{
		return (EnumerationValue)getProperty( ctx, FOOTEROPTIN);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSettings.footerOptin</code> attribute.
	 * @return the footerOptin - Footer Optin
	 */
	public EnumerationValue getFooterOptin()
	{
		return getFooterOptin( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSettings.footerOptin</code> attribute. 
	 * @param value the footerOptin - Footer Optin
	 */
	public void setFooterOptin(final SessionContext ctx, final EnumerationValue value)
	{
		setProperty(ctx, FOOTEROPTIN,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSettings.footerOptin</code> attribute. 
	 * @param value the footerOptin - Footer Optin
	 */
	public void setFooterOptin(final EnumerationValue value)
	{
		setFooterOptin( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSettings.footerOptinExternalEvent</code> attribute.
	 * @return the footerOptinExternalEvent - Footer external event
	 */
	public EnumerationValue getFooterOptinExternalEvent(final SessionContext ctx)
	{
		return (EnumerationValue)getProperty( ctx, FOOTEROPTINEXTERNALEVENT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSettings.footerOptinExternalEvent</code> attribute.
	 * @return the footerOptinExternalEvent - Footer external event
	 */
	public EnumerationValue getFooterOptinExternalEvent()
	{
		return getFooterOptinExternalEvent( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSettings.footerOptinExternalEvent</code> attribute. 
	 * @param value the footerOptinExternalEvent - Footer external event
	 */
	public void setFooterOptinExternalEvent(final SessionContext ctx, final EnumerationValue value)
	{
		setProperty(ctx, FOOTEROPTINEXTERNALEVENT,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSettings.footerOptinExternalEvent</code> attribute. 
	 * @param value the footerOptinExternalEvent - Footer external event
	 */
	public void setFooterOptinExternalEvent(final EnumerationValue value)
	{
		setFooterOptinExternalEvent( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSettings.myAccountConfirmationExternalEvent</code> attribute.
	 * @return the myAccountConfirmationExternalEvent - My account after confirmation external event
	 */
	public EnumerationValue getMyAccountConfirmationExternalEvent(final SessionContext ctx)
	{
		return (EnumerationValue)getProperty( ctx, MYACCOUNTCONFIRMATIONEXTERNALEVENT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSettings.myAccountConfirmationExternalEvent</code> attribute.
	 * @return the myAccountConfirmationExternalEvent - My account after confirmation external event
	 */
	public EnumerationValue getMyAccountConfirmationExternalEvent()
	{
		return getMyAccountConfirmationExternalEvent( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSettings.myAccountConfirmationExternalEvent</code> attribute. 
	 * @param value the myAccountConfirmationExternalEvent - My account after confirmation external event
	 */
	public void setMyAccountConfirmationExternalEvent(final SessionContext ctx, final EnumerationValue value)
	{
		setProperty(ctx, MYACCOUNTCONFIRMATIONEXTERNALEVENT,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSettings.myAccountConfirmationExternalEvent</code> attribute. 
	 * @param value the myAccountConfirmationExternalEvent - My account after confirmation external event
	 */
	public void setMyAccountConfirmationExternalEvent(final EnumerationValue value)
	{
		setMyAccountConfirmationExternalEvent( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSettings.myAccountOptin</code> attribute.
	 * @return the myAccountOptin - My Account Opt-in
	 */
	public EnumerationValue getMyAccountOptin(final SessionContext ctx)
	{
		return (EnumerationValue)getProperty( ctx, MYACCOUNTOPTIN);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSettings.myAccountOptin</code> attribute.
	 * @return the myAccountOptin - My Account Opt-in
	 */
	public EnumerationValue getMyAccountOptin()
	{
		return getMyAccountOptin( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSettings.myAccountOptin</code> attribute. 
	 * @param value the myAccountOptin - My Account Opt-in
	 */
	public void setMyAccountOptin(final SessionContext ctx, final EnumerationValue value)
	{
		setProperty(ctx, MYACCOUNTOPTIN,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSettings.myAccountOptin</code> attribute. 
	 * @param value the myAccountOptin - My Account Opt-in
	 */
	public void setMyAccountOptin(final EnumerationValue value)
	{
		setMyAccountOptin( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSettings.myAccountOptinExternalEvent</code> attribute.
	 * @return the myAccountOptinExternalEvent - My account external event
	 */
	public EnumerationValue getMyAccountOptinExternalEvent(final SessionContext ctx)
	{
		return (EnumerationValue)getProperty( ctx, MYACCOUNTOPTINEXTERNALEVENT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSettings.myAccountOptinExternalEvent</code> attribute.
	 * @return the myAccountOptinExternalEvent - My account external event
	 */
	public EnumerationValue getMyAccountOptinExternalEvent()
	{
		return getMyAccountOptinExternalEvent( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSettings.myAccountOptinExternalEvent</code> attribute. 
	 * @param value the myAccountOptinExternalEvent - My account external event
	 */
	public void setMyAccountOptinExternalEvent(final SessionContext ctx, final EnumerationValue value)
	{
		setProperty(ctx, MYACCOUNTOPTINEXTERNALEVENT,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSettings.myAccountOptinExternalEvent</code> attribute. 
	 * @param value the myAccountOptinExternalEvent - My account external event
	 */
	public void setMyAccountOptinExternalEvent(final EnumerationValue value)
	{
		setMyAccountOptinExternalEvent( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSettings.orderConfirmationExternalEvent</code> attribute.
	 * @return the orderConfirmationExternalEvent - Order Confirmation external event
	 */
	public EnumerationValue getOrderConfirmationExternalEvent(final SessionContext ctx)
	{
		return (EnumerationValue)getProperty( ctx, ORDERCONFIRMATIONEXTERNALEVENT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSettings.orderConfirmationExternalEvent</code> attribute.
	 * @return the orderConfirmationExternalEvent - Order Confirmation external event
	 */
	public EnumerationValue getOrderConfirmationExternalEvent()
	{
		return getOrderConfirmationExternalEvent( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSettings.orderConfirmationExternalEvent</code> attribute. 
	 * @param value the orderConfirmationExternalEvent - Order Confirmation external event
	 */
	public void setOrderConfirmationExternalEvent(final SessionContext ctx, final EnumerationValue value)
	{
		setProperty(ctx, ORDERCONFIRMATIONEXTERNALEVENT,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSettings.orderConfirmationExternalEvent</code> attribute. 
	 * @param value the orderConfirmationExternalEvent - Order Confirmation external event
	 */
	public void setOrderConfirmationExternalEvent(final EnumerationValue value)
	{
		setOrderConfirmationExternalEvent( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSettings.registerConfirmationExternalEvent</code> attribute.
	 * @return the registerConfirmationExternalEvent - Register after confirmation external event
	 */
	public EnumerationValue getRegisterConfirmationExternalEvent(final SessionContext ctx)
	{
		return (EnumerationValue)getProperty( ctx, REGISTERCONFIRMATIONEXTERNALEVENT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSettings.registerConfirmationExternalEvent</code> attribute.
	 * @return the registerConfirmationExternalEvent - Register after confirmation external event
	 */
	public EnumerationValue getRegisterConfirmationExternalEvent()
	{
		return getRegisterConfirmationExternalEvent( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSettings.registerConfirmationExternalEvent</code> attribute. 
	 * @param value the registerConfirmationExternalEvent - Register after confirmation external event
	 */
	public void setRegisterConfirmationExternalEvent(final SessionContext ctx, final EnumerationValue value)
	{
		setProperty(ctx, REGISTERCONFIRMATIONEXTERNALEVENT,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSettings.registerConfirmationExternalEvent</code> attribute. 
	 * @param value the registerConfirmationExternalEvent - Register after confirmation external event
	 */
	public void setRegisterConfirmationExternalEvent(final EnumerationValue value)
	{
		setRegisterConfirmationExternalEvent( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSettings.registerOptin</code> attribute.
	 * @return the registerOptin - Register Opt-in
	 */
	public EnumerationValue getRegisterOptin(final SessionContext ctx)
	{
		return (EnumerationValue)getProperty( ctx, REGISTEROPTIN);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSettings.registerOptin</code> attribute.
	 * @return the registerOptin - Register Opt-in
	 */
	public EnumerationValue getRegisterOptin()
	{
		return getRegisterOptin( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSettings.registerOptin</code> attribute. 
	 * @param value the registerOptin - Register Opt-in
	 */
	public void setRegisterOptin(final SessionContext ctx, final EnumerationValue value)
	{
		setProperty(ctx, REGISTEROPTIN,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSettings.registerOptin</code> attribute. 
	 * @param value the registerOptin - Register Opt-in
	 */
	public void setRegisterOptin(final EnumerationValue value)
	{
		setRegisterOptin( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSettings.registerOptinExternalEvent</code> attribute.
	 * @return the registerOptinExternalEvent - Register external event
	 */
	public EnumerationValue getRegisterOptinExternalEvent(final SessionContext ctx)
	{
		return (EnumerationValue)getProperty( ctx, REGISTEROPTINEXTERNALEVENT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSettings.registerOptinExternalEvent</code> attribute.
	 * @return the registerOptinExternalEvent - Register external event
	 */
	public EnumerationValue getRegisterOptinExternalEvent()
	{
		return getRegisterOptinExternalEvent( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSettings.registerOptinExternalEvent</code> attribute. 
	 * @param value the registerOptinExternalEvent - Register external event
	 */
	public void setRegisterOptinExternalEvent(final SessionContext ctx, final EnumerationValue value)
	{
		setProperty(ctx, REGISTEROPTINEXTERNALEVENT,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSettings.registerOptinExternalEvent</code> attribute. 
	 * @param value the registerOptinExternalEvent - Register external event
	 */
	public void setRegisterOptinExternalEvent(final EnumerationValue value)
	{
		setRegisterOptinExternalEvent( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSettings.shippingConfirmationExternalEvent</code> attribute.
	 * @return the shippingConfirmationExternalEvent - Shipping Confirmation external event
	 */
	public EnumerationValue getShippingConfirmationExternalEvent(final SessionContext ctx)
	{
		return (EnumerationValue)getProperty( ctx, SHIPPINGCONFIRMATIONEXTERNALEVENT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSettings.shippingConfirmationExternalEvent</code> attribute.
	 * @return the shippingConfirmationExternalEvent - Shipping Confirmation external event
	 */
	public EnumerationValue getShippingConfirmationExternalEvent()
	{
		return getShippingConfirmationExternalEvent( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSettings.shippingConfirmationExternalEvent</code> attribute. 
	 * @param value the shippingConfirmationExternalEvent - Shipping Confirmation external event
	 */
	public void setShippingConfirmationExternalEvent(final SessionContext ctx, final EnumerationValue value)
	{
		setProperty(ctx, SHIPPINGCONFIRMATIONEXTERNALEVENT,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSettings.shippingConfirmationExternalEvent</code> attribute. 
	 * @param value the shippingConfirmationExternalEvent - Shipping Confirmation external event
	 */
	public void setShippingConfirmationExternalEvent(final EnumerationValue value)
	{
		setShippingConfirmationExternalEvent( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSettings.uid</code> attribute.
	 * @return the uid
	 */
	public String getUid(final SessionContext ctx)
	{
		return (String)getProperty( ctx, UID);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSettings.uid</code> attribute.
	 * @return the uid
	 */
	public String getUid()
	{
		return getUid( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSettings.uid</code> attribute. 
	 * @param value the uid
	 */
	public void setUid(final SessionContext ctx, final String value)
	{
		setProperty(ctx, UID,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSettings.uid</code> attribute. 
	 * @param value the uid
	 */
	public void setUid(final String value)
	{
		setUid( getSession().getSessionContext(), value );
	}
	
}

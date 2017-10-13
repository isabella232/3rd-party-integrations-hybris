/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 7-Feb-2017 11:23:01 PM                      ---
 * ----------------------------------------------------------------
 */
package com.osfglobal.hybris.emarsys.core.jalo;

import com.osfglobal.hybris.emarsys.constants.EmarsysConstants;
import com.osfglobal.hybris.emarsys.core.jalo.EmarsysPredictAvailabilityZone;
import com.osfglobal.hybris.emarsys.core.jalo.EmarsysPredictMapping;
import de.hybris.platform.jalo.GenericItem;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.enumeration.EnumerationValue;
import de.hybris.platform.jalo.type.CollectionType;
import de.hybris.platform.util.OneToManyHandler;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Generated class for type {@link com.osfglobal.hybris.emarsys.core.jalo.EmarsysPredict EmarsysPredict}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedEmarsysPredict extends GenericItem
{
	/** Qualifier of the <code>EmarsysPredict.uid</code> attribute **/
	public static final String UID = "uid";
	/** Qualifier of the <code>EmarsysPredict.enableTrackingCode</code> attribute **/
	public static final String ENABLETRACKINGCODE = "enableTrackingCode";
	/** Qualifier of the <code>EmarsysPredict.merchantId</code> attribute **/
	public static final String MERCHANTID = "merchantId";
	/** Qualifier of the <code>EmarsysPredict.orderPageRecomType</code> attribute **/
	public static final String ORDERPAGERECOMTYPE = "orderPageRecomType";
	/** Qualifier of the <code>EmarsysPredict.productPageRecomType</code> attribute **/
	public static final String PRODUCTPAGERECOMTYPE = "productPageRecomType";
	/** Qualifier of the <code>EmarsysPredict.homePageRecomType</code> attribute **/
	public static final String HOMEPAGERECOMTYPE = "homePageRecomType";
	/** Qualifier of the <code>EmarsysPredict.cartPageRecomType</code> attribute **/
	public static final String CARTPAGERECOMTYPE = "cartPageRecomType";
	/** Qualifier of the <code>EmarsysPredict.searchPageRecomType</code> attribute **/
	public static final String SEARCHPAGERECOMTYPE = "searchPageRecomType";
	/** Qualifier of the <code>EmarsysPredict.categoryPageRecomType</code> attribute **/
	public static final String CATEGORYPAGERECOMTYPE = "categoryPageRecomType";
	/** Qualifier of the <code>EmarsysPredict.containerId</code> attribute **/
	public static final String CONTAINERID = "containerId";
	/** Qualifier of the <code>EmarsysPredict.templateId</code> attribute **/
	public static final String TEMPLATEID = "templateId";
	/** Qualifier of the <code>EmarsysPredict.sftpHost</code> attribute **/
	public static final String SFTPHOST = "sftpHost";
	/** Qualifier of the <code>EmarsysPredict.sftpUsername</code> attribute **/
	public static final String SFTPUSERNAME = "sftpUsername";
	/** Qualifier of the <code>EmarsysPredict.sftpPassword</code> attribute **/
	public static final String SFTPPASSWORD = "sftpPassword";
	/** Qualifier of the <code>EmarsysPredict.sftpPath</code> attribute **/
	public static final String SFTPPATH = "sftpPath";
	/** Qualifier of the <code>EmarsysPredict.exportType</code> attribute **/
	public static final String EXPORTTYPE = "exportType";
	/** Qualifier of the <code>EmarsysPredict.emarsysPredictMappings</code> attribute **/
	public static final String EMARSYSPREDICTMAPPINGS = "emarsysPredictMappings";
	/** Qualifier of the <code>EmarsysPredict.emarsysPredictAvailabilityZones</code> attribute **/
	public static final String EMARSYSPREDICTAVAILABILITYZONES = "emarsysPredictAvailabilityZones";
	/**
	* {@link OneToManyHandler} for handling 1:n EMARSYSPREDICTMAPPINGS's relation attributes from 'many' side.
	**/
	protected static final OneToManyHandler<EmarsysPredictMapping> EMARSYSPREDICTMAPPINGSHANDLER = new OneToManyHandler<EmarsysPredictMapping>(
	EmarsysConstants.TC.EMARSYSPREDICTMAPPING,
	false,
	"emarsysPredict",
	"emarsysPredictPOS",
	true,
	true,
	CollectionType.SET
	);
	/**
	* {@link OneToManyHandler} for handling 1:n EMARSYSPREDICTAVAILABILITYZONES's relation attributes from 'many' side.
	**/
	protected static final OneToManyHandler<EmarsysPredictAvailabilityZone> EMARSYSPREDICTAVAILABILITYZONESHANDLER = new OneToManyHandler<EmarsysPredictAvailabilityZone>(
	EmarsysConstants.TC.EMARSYSPREDICTAVAILABILITYZONE,
	false,
	"emarsysPredict",
	"emarsysPredictPOS",
	true,
	true,
	CollectionType.SET
	);
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>();
		tmp.put(UID, AttributeMode.INITIAL);
		tmp.put(ENABLETRACKINGCODE, AttributeMode.INITIAL);
		tmp.put(MERCHANTID, AttributeMode.INITIAL);
		tmp.put(ORDERPAGERECOMTYPE, AttributeMode.INITIAL);
		tmp.put(PRODUCTPAGERECOMTYPE, AttributeMode.INITIAL);
		tmp.put(HOMEPAGERECOMTYPE, AttributeMode.INITIAL);
		tmp.put(CARTPAGERECOMTYPE, AttributeMode.INITIAL);
		tmp.put(SEARCHPAGERECOMTYPE, AttributeMode.INITIAL);
		tmp.put(CATEGORYPAGERECOMTYPE, AttributeMode.INITIAL);
		tmp.put(CONTAINERID, AttributeMode.INITIAL);
		tmp.put(TEMPLATEID, AttributeMode.INITIAL);
		tmp.put(SFTPHOST, AttributeMode.INITIAL);
		tmp.put(SFTPUSERNAME, AttributeMode.INITIAL);
		tmp.put(SFTPPASSWORD, AttributeMode.INITIAL);
		tmp.put(SFTPPATH, AttributeMode.INITIAL);
		tmp.put(EXPORTTYPE, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysPredict.cartPageRecomType</code> attribute.
	 * @return the cartPageRecomType - Cart Page RecommendationType
	 */
	public EnumerationValue getCartPageRecomType(final SessionContext ctx)
	{
		return (EnumerationValue)getProperty( ctx, CARTPAGERECOMTYPE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysPredict.cartPageRecomType</code> attribute.
	 * @return the cartPageRecomType - Cart Page RecommendationType
	 */
	public EnumerationValue getCartPageRecomType()
	{
		return getCartPageRecomType( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysPredict.cartPageRecomType</code> attribute. 
	 * @param value the cartPageRecomType - Cart Page RecommendationType
	 */
	public void setCartPageRecomType(final SessionContext ctx, final EnumerationValue value)
	{
		setProperty(ctx, CARTPAGERECOMTYPE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysPredict.cartPageRecomType</code> attribute. 
	 * @param value the cartPageRecomType - Cart Page RecommendationType
	 */
	public void setCartPageRecomType(final EnumerationValue value)
	{
		setCartPageRecomType( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysPredict.categoryPageRecomType</code> attribute.
	 * @return the categoryPageRecomType - Category Page Page RecommendationType
	 */
	public EnumerationValue getCategoryPageRecomType(final SessionContext ctx)
	{
		return (EnumerationValue)getProperty( ctx, CATEGORYPAGERECOMTYPE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysPredict.categoryPageRecomType</code> attribute.
	 * @return the categoryPageRecomType - Category Page Page RecommendationType
	 */
	public EnumerationValue getCategoryPageRecomType()
	{
		return getCategoryPageRecomType( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysPredict.categoryPageRecomType</code> attribute. 
	 * @param value the categoryPageRecomType - Category Page Page RecommendationType
	 */
	public void setCategoryPageRecomType(final SessionContext ctx, final EnumerationValue value)
	{
		setProperty(ctx, CATEGORYPAGERECOMTYPE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysPredict.categoryPageRecomType</code> attribute. 
	 * @param value the categoryPageRecomType - Category Page Page RecommendationType
	 */
	public void setCategoryPageRecomType(final EnumerationValue value)
	{
		setCategoryPageRecomType( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysPredict.containerId</code> attribute.
	 * @return the containerId - Div id where predict recommendations are displayed
	 */
	public String getContainerId(final SessionContext ctx)
	{
		return (String)getProperty( ctx, CONTAINERID);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysPredict.containerId</code> attribute.
	 * @return the containerId - Div id where predict recommendations are displayed
	 */
	public String getContainerId()
	{
		return getContainerId( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysPredict.containerId</code> attribute. 
	 * @param value the containerId - Div id where predict recommendations are displayed
	 */
	public void setContainerId(final SessionContext ctx, final String value)
	{
		setProperty(ctx, CONTAINERID,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysPredict.containerId</code> attribute. 
	 * @param value the containerId - Div id where predict recommendations are displayed
	 */
	public void setContainerId(final String value)
	{
		setContainerId( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysPredict.emarsysPredictAvailabilityZones</code> attribute.
	 * @return the emarsysPredictAvailabilityZones
	 */
	public Set<EmarsysPredictAvailabilityZone> getEmarsysPredictAvailabilityZones(final SessionContext ctx)
	{
		return (Set<EmarsysPredictAvailabilityZone>)EMARSYSPREDICTAVAILABILITYZONESHANDLER.getValues( ctx, this );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysPredict.emarsysPredictAvailabilityZones</code> attribute.
	 * @return the emarsysPredictAvailabilityZones
	 */
	public Set<EmarsysPredictAvailabilityZone> getEmarsysPredictAvailabilityZones()
	{
		return getEmarsysPredictAvailabilityZones( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysPredict.emarsysPredictAvailabilityZones</code> attribute. 
	 * @param value the emarsysPredictAvailabilityZones
	 */
	public void setEmarsysPredictAvailabilityZones(final SessionContext ctx, final Set<EmarsysPredictAvailabilityZone> value)
	{
		EMARSYSPREDICTAVAILABILITYZONESHANDLER.setValues( ctx, this, value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysPredict.emarsysPredictAvailabilityZones</code> attribute. 
	 * @param value the emarsysPredictAvailabilityZones
	 */
	public void setEmarsysPredictAvailabilityZones(final Set<EmarsysPredictAvailabilityZone> value)
	{
		setEmarsysPredictAvailabilityZones( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to emarsysPredictAvailabilityZones. 
	 * @param value the item to add to emarsysPredictAvailabilityZones
	 */
	public void addToEmarsysPredictAvailabilityZones(final SessionContext ctx, final EmarsysPredictAvailabilityZone value)
	{
		EMARSYSPREDICTAVAILABILITYZONESHANDLER.addValue( ctx, this, value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to emarsysPredictAvailabilityZones. 
	 * @param value the item to add to emarsysPredictAvailabilityZones
	 */
	public void addToEmarsysPredictAvailabilityZones(final EmarsysPredictAvailabilityZone value)
	{
		addToEmarsysPredictAvailabilityZones( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from emarsysPredictAvailabilityZones. 
	 * @param value the item to remove from emarsysPredictAvailabilityZones
	 */
	public void removeFromEmarsysPredictAvailabilityZones(final SessionContext ctx, final EmarsysPredictAvailabilityZone value)
	{
		EMARSYSPREDICTAVAILABILITYZONESHANDLER.removeValue( ctx, this, value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from emarsysPredictAvailabilityZones. 
	 * @param value the item to remove from emarsysPredictAvailabilityZones
	 */
	public void removeFromEmarsysPredictAvailabilityZones(final EmarsysPredictAvailabilityZone value)
	{
		removeFromEmarsysPredictAvailabilityZones( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysPredict.emarsysPredictMappings</code> attribute.
	 * @return the emarsysPredictMappings
	 */
	public Set<EmarsysPredictMapping> getEmarsysPredictMappings(final SessionContext ctx)
	{
		return (Set<EmarsysPredictMapping>)EMARSYSPREDICTMAPPINGSHANDLER.getValues( ctx, this );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysPredict.emarsysPredictMappings</code> attribute.
	 * @return the emarsysPredictMappings
	 */
	public Set<EmarsysPredictMapping> getEmarsysPredictMappings()
	{
		return getEmarsysPredictMappings( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysPredict.emarsysPredictMappings</code> attribute. 
	 * @param value the emarsysPredictMappings
	 */
	public void setEmarsysPredictMappings(final SessionContext ctx, final Set<EmarsysPredictMapping> value)
	{
		EMARSYSPREDICTMAPPINGSHANDLER.setValues( ctx, this, value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysPredict.emarsysPredictMappings</code> attribute. 
	 * @param value the emarsysPredictMappings
	 */
	public void setEmarsysPredictMappings(final Set<EmarsysPredictMapping> value)
	{
		setEmarsysPredictMappings( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to emarsysPredictMappings. 
	 * @param value the item to add to emarsysPredictMappings
	 */
	public void addToEmarsysPredictMappings(final SessionContext ctx, final EmarsysPredictMapping value)
	{
		EMARSYSPREDICTMAPPINGSHANDLER.addValue( ctx, this, value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to emarsysPredictMappings. 
	 * @param value the item to add to emarsysPredictMappings
	 */
	public void addToEmarsysPredictMappings(final EmarsysPredictMapping value)
	{
		addToEmarsysPredictMappings( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from emarsysPredictMappings. 
	 * @param value the item to remove from emarsysPredictMappings
	 */
	public void removeFromEmarsysPredictMappings(final SessionContext ctx, final EmarsysPredictMapping value)
	{
		EMARSYSPREDICTMAPPINGSHANDLER.removeValue( ctx, this, value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from emarsysPredictMappings. 
	 * @param value the item to remove from emarsysPredictMappings
	 */
	public void removeFromEmarsysPredictMappings(final EmarsysPredictMapping value)
	{
		removeFromEmarsysPredictMappings( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysPredict.enableTrackingCode</code> attribute.
	 * @return the enableTrackingCode
	 */
	public Boolean isEnableTrackingCode(final SessionContext ctx)
	{
		return (Boolean)getProperty( ctx, ENABLETRACKINGCODE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysPredict.enableTrackingCode</code> attribute.
	 * @return the enableTrackingCode
	 */
	public Boolean isEnableTrackingCode()
	{
		return isEnableTrackingCode( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysPredict.enableTrackingCode</code> attribute. 
	 * @return the enableTrackingCode
	 */
	public boolean isEnableTrackingCodeAsPrimitive(final SessionContext ctx)
	{
		Boolean value = isEnableTrackingCode( ctx );
		return value != null ? value.booleanValue() : false;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysPredict.enableTrackingCode</code> attribute. 
	 * @return the enableTrackingCode
	 */
	public boolean isEnableTrackingCodeAsPrimitive()
	{
		return isEnableTrackingCodeAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysPredict.enableTrackingCode</code> attribute. 
	 * @param value the enableTrackingCode
	 */
	public void setEnableTrackingCode(final SessionContext ctx, final Boolean value)
	{
		setProperty(ctx, ENABLETRACKINGCODE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysPredict.enableTrackingCode</code> attribute. 
	 * @param value the enableTrackingCode
	 */
	public void setEnableTrackingCode(final Boolean value)
	{
		setEnableTrackingCode( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysPredict.enableTrackingCode</code> attribute. 
	 * @param value the enableTrackingCode
	 */
	public void setEnableTrackingCode(final SessionContext ctx, final boolean value)
	{
		setEnableTrackingCode( ctx,Boolean.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysPredict.enableTrackingCode</code> attribute. 
	 * @param value the enableTrackingCode
	 */
	public void setEnableTrackingCode(final boolean value)
	{
		setEnableTrackingCode( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysPredict.exportType</code> attribute.
	 * @return the exportType - Emarsys Predict export type
	 */
	public EnumerationValue getExportType(final SessionContext ctx)
	{
		return (EnumerationValue)getProperty( ctx, EXPORTTYPE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysPredict.exportType</code> attribute.
	 * @return the exportType - Emarsys Predict export type
	 */
	public EnumerationValue getExportType()
	{
		return getExportType( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysPredict.exportType</code> attribute. 
	 * @param value the exportType - Emarsys Predict export type
	 */
	public void setExportType(final SessionContext ctx, final EnumerationValue value)
	{
		setProperty(ctx, EXPORTTYPE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysPredict.exportType</code> attribute. 
	 * @param value the exportType - Emarsys Predict export type
	 */
	public void setExportType(final EnumerationValue value)
	{
		setExportType( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysPredict.homePageRecomType</code> attribute.
	 * @return the homePageRecomType - Home Page RecommendationType
	 */
	public EnumerationValue getHomePageRecomType(final SessionContext ctx)
	{
		return (EnumerationValue)getProperty( ctx, HOMEPAGERECOMTYPE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysPredict.homePageRecomType</code> attribute.
	 * @return the homePageRecomType - Home Page RecommendationType
	 */
	public EnumerationValue getHomePageRecomType()
	{
		return getHomePageRecomType( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysPredict.homePageRecomType</code> attribute. 
	 * @param value the homePageRecomType - Home Page RecommendationType
	 */
	public void setHomePageRecomType(final SessionContext ctx, final EnumerationValue value)
	{
		setProperty(ctx, HOMEPAGERECOMTYPE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysPredict.homePageRecomType</code> attribute. 
	 * @param value the homePageRecomType - Home Page RecommendationType
	 */
	public void setHomePageRecomType(final EnumerationValue value)
	{
		setHomePageRecomType( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysPredict.merchantId</code> attribute.
	 * @return the merchantId
	 */
	public String getMerchantId(final SessionContext ctx)
	{
		return (String)getProperty( ctx, MERCHANTID);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysPredict.merchantId</code> attribute.
	 * @return the merchantId
	 */
	public String getMerchantId()
	{
		return getMerchantId( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysPredict.merchantId</code> attribute. 
	 * @param value the merchantId
	 */
	public void setMerchantId(final SessionContext ctx, final String value)
	{
		setProperty(ctx, MERCHANTID,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysPredict.merchantId</code> attribute. 
	 * @param value the merchantId
	 */
	public void setMerchantId(final String value)
	{
		setMerchantId( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysPredict.orderPageRecomType</code> attribute.
	 * @return the orderPageRecomType - Thank You For Your Order Page RecommendationType
	 */
	public EnumerationValue getOrderPageRecomType(final SessionContext ctx)
	{
		return (EnumerationValue)getProperty( ctx, ORDERPAGERECOMTYPE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysPredict.orderPageRecomType</code> attribute.
	 * @return the orderPageRecomType - Thank You For Your Order Page RecommendationType
	 */
	public EnumerationValue getOrderPageRecomType()
	{
		return getOrderPageRecomType( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysPredict.orderPageRecomType</code> attribute. 
	 * @param value the orderPageRecomType - Thank You For Your Order Page RecommendationType
	 */
	public void setOrderPageRecomType(final SessionContext ctx, final EnumerationValue value)
	{
		setProperty(ctx, ORDERPAGERECOMTYPE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysPredict.orderPageRecomType</code> attribute. 
	 * @param value the orderPageRecomType - Thank You For Your Order Page RecommendationType
	 */
	public void setOrderPageRecomType(final EnumerationValue value)
	{
		setOrderPageRecomType( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysPredict.productPageRecomType</code> attribute.
	 * @return the productPageRecomType - Product Detail Page RecommendationType
	 */
	public EnumerationValue getProductPageRecomType(final SessionContext ctx)
	{
		return (EnumerationValue)getProperty( ctx, PRODUCTPAGERECOMTYPE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysPredict.productPageRecomType</code> attribute.
	 * @return the productPageRecomType - Product Detail Page RecommendationType
	 */
	public EnumerationValue getProductPageRecomType()
	{
		return getProductPageRecomType( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysPredict.productPageRecomType</code> attribute. 
	 * @param value the productPageRecomType - Product Detail Page RecommendationType
	 */
	public void setProductPageRecomType(final SessionContext ctx, final EnumerationValue value)
	{
		setProperty(ctx, PRODUCTPAGERECOMTYPE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysPredict.productPageRecomType</code> attribute. 
	 * @param value the productPageRecomType - Product Detail Page RecommendationType
	 */
	public void setProductPageRecomType(final EnumerationValue value)
	{
		setProductPageRecomType( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysPredict.searchPageRecomType</code> attribute.
	 * @return the searchPageRecomType - Search Page RecommendationType
	 */
	public EnumerationValue getSearchPageRecomType(final SessionContext ctx)
	{
		return (EnumerationValue)getProperty( ctx, SEARCHPAGERECOMTYPE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysPredict.searchPageRecomType</code> attribute.
	 * @return the searchPageRecomType - Search Page RecommendationType
	 */
	public EnumerationValue getSearchPageRecomType()
	{
		return getSearchPageRecomType( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysPredict.searchPageRecomType</code> attribute. 
	 * @param value the searchPageRecomType - Search Page RecommendationType
	 */
	public void setSearchPageRecomType(final SessionContext ctx, final EnumerationValue value)
	{
		setProperty(ctx, SEARCHPAGERECOMTYPE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysPredict.searchPageRecomType</code> attribute. 
	 * @param value the searchPageRecomType - Search Page RecommendationType
	 */
	public void setSearchPageRecomType(final EnumerationValue value)
	{
		setSearchPageRecomType( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysPredict.sftpHost</code> attribute.
	 * @return the sftpHost - Emarsys SFTP Host
	 */
	public String getSftpHost(final SessionContext ctx)
	{
		return (String)getProperty( ctx, SFTPHOST);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysPredict.sftpHost</code> attribute.
	 * @return the sftpHost - Emarsys SFTP Host
	 */
	public String getSftpHost()
	{
		return getSftpHost( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysPredict.sftpHost</code> attribute. 
	 * @param value the sftpHost - Emarsys SFTP Host
	 */
	public void setSftpHost(final SessionContext ctx, final String value)
	{
		setProperty(ctx, SFTPHOST,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysPredict.sftpHost</code> attribute. 
	 * @param value the sftpHost - Emarsys SFTP Host
	 */
	public void setSftpHost(final String value)
	{
		setSftpHost( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysPredict.sftpPassword</code> attribute.
	 * @return the sftpPassword - Emarsys SFTP Password
	 */
	public String getSftpPassword(final SessionContext ctx)
	{
		return (String)getProperty( ctx, SFTPPASSWORD);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysPredict.sftpPassword</code> attribute.
	 * @return the sftpPassword - Emarsys SFTP Password
	 */
	public String getSftpPassword()
	{
		return getSftpPassword( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysPredict.sftpPassword</code> attribute. 
	 * @param value the sftpPassword - Emarsys SFTP Password
	 */
	public void setSftpPassword(final SessionContext ctx, final String value)
	{
		setProperty(ctx, SFTPPASSWORD,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysPredict.sftpPassword</code> attribute. 
	 * @param value the sftpPassword - Emarsys SFTP Password
	 */
	public void setSftpPassword(final String value)
	{
		setSftpPassword( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysPredict.sftpPath</code> attribute.
	 * @return the sftpPath - Emarsys Predict csv file SFTP Path
	 */
	public String getSftpPath(final SessionContext ctx)
	{
		return (String)getProperty( ctx, SFTPPATH);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysPredict.sftpPath</code> attribute.
	 * @return the sftpPath - Emarsys Predict csv file SFTP Path
	 */
	public String getSftpPath()
	{
		return getSftpPath( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysPredict.sftpPath</code> attribute. 
	 * @param value the sftpPath - Emarsys Predict csv file SFTP Path
	 */
	public void setSftpPath(final SessionContext ctx, final String value)
	{
		setProperty(ctx, SFTPPATH,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysPredict.sftpPath</code> attribute. 
	 * @param value the sftpPath - Emarsys Predict csv file SFTP Path
	 */
	public void setSftpPath(final String value)
	{
		setSftpPath( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysPredict.sftpUsername</code> attribute.
	 * @return the sftpUsername - Emarsys SFTP Username
	 */
	public String getSftpUsername(final SessionContext ctx)
	{
		return (String)getProperty( ctx, SFTPUSERNAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysPredict.sftpUsername</code> attribute.
	 * @return the sftpUsername - Emarsys SFTP Username
	 */
	public String getSftpUsername()
	{
		return getSftpUsername( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysPredict.sftpUsername</code> attribute. 
	 * @param value the sftpUsername - Emarsys SFTP Username
	 */
	public void setSftpUsername(final SessionContext ctx, final String value)
	{
		setProperty(ctx, SFTPUSERNAME,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysPredict.sftpUsername</code> attribute. 
	 * @param value the sftpUsername - Emarsys SFTP Username
	 */
	public void setSftpUsername(final String value)
	{
		setSftpUsername( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysPredict.templateId</code> attribute.
	 * @return the templateId - Template id
	 */
	public String getTemplateId(final SessionContext ctx)
	{
		return (String)getProperty( ctx, TEMPLATEID);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysPredict.templateId</code> attribute.
	 * @return the templateId - Template id
	 */
	public String getTemplateId()
	{
		return getTemplateId( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysPredict.templateId</code> attribute. 
	 * @param value the templateId - Template id
	 */
	public void setTemplateId(final SessionContext ctx, final String value)
	{
		setProperty(ctx, TEMPLATEID,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysPredict.templateId</code> attribute. 
	 * @param value the templateId - Template id
	 */
	public void setTemplateId(final String value)
	{
		setTemplateId( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysPredict.uid</code> attribute.
	 * @return the uid
	 */
	public String getUid(final SessionContext ctx)
	{
		return (String)getProperty( ctx, UID);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysPredict.uid</code> attribute.
	 * @return the uid
	 */
	public String getUid()
	{
		return getUid( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysPredict.uid</code> attribute. 
	 * @param value the uid
	 */
	public void setUid(final SessionContext ctx, final String value)
	{
		setProperty(ctx, UID,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysPredict.uid</code> attribute. 
	 * @param value the uid
	 */
	public void setUid(final String value)
	{
		setUid( getSession().getSessionContext(), value );
	}
	
}

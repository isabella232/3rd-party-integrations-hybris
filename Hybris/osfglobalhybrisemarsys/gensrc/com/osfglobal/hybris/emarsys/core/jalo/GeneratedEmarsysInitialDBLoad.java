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
 * Generated class for type {@link com.osfglobal.hybris.emarsys.core.jalo.EmarsysInitialDBLoad EmarsysInitialDBLoad}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedEmarsysInitialDBLoad extends GenericItem
{
	/** Qualifier of the <code>EmarsysInitialDBLoad.uid</code> attribute **/
	public static final String UID = "uid";
	/** Qualifier of the <code>EmarsysInitialDBLoad.optinStatus</code> attribute **/
	public static final String OPTINSTATUS = "optinStatus";
	/** Qualifier of the <code>EmarsysInitialDBLoad.optinStatusCustomerAttributeId</code> attribute **/
	public static final String OPTINSTATUSCUSTOMERATTRIBUTEID = "optinStatusCustomerAttributeId";
	/** Qualifier of the <code>EmarsysInitialDBLoad.mapping</code> attribute **/
	public static final String MAPPING = "mapping";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>();
		tmp.put(UID, AttributeMode.INITIAL);
		tmp.put(OPTINSTATUS, AttributeMode.INITIAL);
		tmp.put(OPTINSTATUSCUSTOMERATTRIBUTEID, AttributeMode.INITIAL);
		tmp.put(MAPPING, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysInitialDBLoad.mapping</code> attribute.
	 * @return the mapping - mapping
	 */
	public Map<EnumerationValue,EnumerationValue> getAllMapping(final SessionContext ctx)
	{
		Map<EnumerationValue,EnumerationValue> map = (Map<EnumerationValue,EnumerationValue>)getProperty( ctx, MAPPING);
		return map != null ? map : Collections.EMPTY_MAP;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysInitialDBLoad.mapping</code> attribute.
	 * @return the mapping - mapping
	 */
	public Map<EnumerationValue,EnumerationValue> getAllMapping()
	{
		return getAllMapping( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysInitialDBLoad.mapping</code> attribute. 
	 * @param value the mapping - mapping
	 */
	public void setAllMapping(final SessionContext ctx, final Map<EnumerationValue,EnumerationValue> value)
	{
		setProperty(ctx, MAPPING,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysInitialDBLoad.mapping</code> attribute. 
	 * @param value the mapping - mapping
	 */
	public void setAllMapping(final Map<EnumerationValue,EnumerationValue> value)
	{
		setAllMapping( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysInitialDBLoad.optinStatus</code> attribute.
	 * @return the optinStatus
	 */
	public EnumerationValue getOptinStatus(final SessionContext ctx)
	{
		return (EnumerationValue)getProperty( ctx, OPTINSTATUS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysInitialDBLoad.optinStatus</code> attribute.
	 * @return the optinStatus
	 */
	public EnumerationValue getOptinStatus()
	{
		return getOptinStatus( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysInitialDBLoad.optinStatus</code> attribute. 
	 * @param value the optinStatus
	 */
	public void setOptinStatus(final SessionContext ctx, final EnumerationValue value)
	{
		setProperty(ctx, OPTINSTATUS,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysInitialDBLoad.optinStatus</code> attribute. 
	 * @param value the optinStatus
	 */
	public void setOptinStatus(final EnumerationValue value)
	{
		setOptinStatus( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysInitialDBLoad.optinStatusCustomerAttributeId</code> attribute.
	 * @return the optinStatusCustomerAttributeId
	 */
	public String getOptinStatusCustomerAttributeId(final SessionContext ctx)
	{
		return (String)getProperty( ctx, OPTINSTATUSCUSTOMERATTRIBUTEID);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysInitialDBLoad.optinStatusCustomerAttributeId</code> attribute.
	 * @return the optinStatusCustomerAttributeId
	 */
	public String getOptinStatusCustomerAttributeId()
	{
		return getOptinStatusCustomerAttributeId( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysInitialDBLoad.optinStatusCustomerAttributeId</code> attribute. 
	 * @param value the optinStatusCustomerAttributeId
	 */
	public void setOptinStatusCustomerAttributeId(final SessionContext ctx, final String value)
	{
		setProperty(ctx, OPTINSTATUSCUSTOMERATTRIBUTEID,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysInitialDBLoad.optinStatusCustomerAttributeId</code> attribute. 
	 * @param value the optinStatusCustomerAttributeId
	 */
	public void setOptinStatusCustomerAttributeId(final String value)
	{
		setOptinStatusCustomerAttributeId( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysInitialDBLoad.uid</code> attribute.
	 * @return the uid
	 */
	public String getUid(final SessionContext ctx)
	{
		return (String)getProperty( ctx, UID);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysInitialDBLoad.uid</code> attribute.
	 * @return the uid
	 */
	public String getUid()
	{
		return getUid( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysInitialDBLoad.uid</code> attribute. 
	 * @param value the uid
	 */
	public void setUid(final SessionContext ctx, final String value)
	{
		setProperty(ctx, UID,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysInitialDBLoad.uid</code> attribute. 
	 * @param value the uid
	 */
	public void setUid(final String value)
	{
		setUid( getSession().getSessionContext(), value );
	}
	
}

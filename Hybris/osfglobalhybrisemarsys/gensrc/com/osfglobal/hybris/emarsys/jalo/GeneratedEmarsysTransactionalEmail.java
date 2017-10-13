/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 7-Feb-2017 11:23:01 PM                      ---
 * ----------------------------------------------------------------
 */
package com.osfglobal.hybris.emarsys.jalo;

import com.osfglobal.hybris.emarsys.constants.EmarsysConstants;
import de.hybris.platform.jalo.GenericItem;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type {@link de.hybris.platform.jalo.GenericItem EmarsysTransactionalEmail}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedEmarsysTransactionalEmail extends GenericItem
{
	/** Qualifier of the <code>EmarsysTransactionalEmail.uid</code> attribute **/
	public static final String UID = "uid";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>();
		tmp.put(UID, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysTransactionalEmail.uid</code> attribute.
	 * @return the uid
	 */
	public String getUid(final SessionContext ctx)
	{
		return (String)getProperty( ctx, UID);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysTransactionalEmail.uid</code> attribute.
	 * @return the uid
	 */
	public String getUid()
	{
		return getUid( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysTransactionalEmail.uid</code> attribute. 
	 * @param value the uid
	 */
	public void setUid(final SessionContext ctx, final String value)
	{
		setProperty(ctx, UID,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysTransactionalEmail.uid</code> attribute. 
	 * @param value the uid
	 */
	public void setUid(final String value)
	{
		setUid( getSession().getSessionContext(), value );
	}
	
}

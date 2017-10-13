/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 7-Feb-2017 11:23:01 PM                      ---
 * ----------------------------------------------------------------
 */
package com.osfglobal.hybris.emarsys.jalo;

import com.osfglobal.hybris.emarsys.constants.EmarsysConstants;
import de.hybris.platform.basecommerce.jalo.site.BaseSite;
import de.hybris.platform.cronjob.jalo.CronJob;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type {@link de.hybris.platform.cronjob.jalo.CronJob EmarsysCronJob}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedEmarsysCronJob extends CronJob
{
	/** Qualifier of the <code>EmarsysCronJob.baseSite</code> attribute **/
	public static final String BASESITE = "baseSite";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(CronJob.DEFAULT_INITIAL_ATTRIBUTES);
		tmp.put(BASESITE, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysCronJob.baseSite</code> attribute.
	 * @return the baseSite
	 */
	public BaseSite getBaseSite(final SessionContext ctx)
	{
		return (BaseSite)getProperty( ctx, BASESITE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysCronJob.baseSite</code> attribute.
	 * @return the baseSite
	 */
	public BaseSite getBaseSite()
	{
		return getBaseSite( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysCronJob.baseSite</code> attribute. 
	 * @param value the baseSite
	 */
	public void setBaseSite(final SessionContext ctx, final BaseSite value)
	{
		setProperty(ctx, BASESITE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysCronJob.baseSite</code> attribute. 
	 * @param value the baseSite
	 */
	public void setBaseSite(final BaseSite value)
	{
		setBaseSite( getSession().getSessionContext(), value );
	}
	
}

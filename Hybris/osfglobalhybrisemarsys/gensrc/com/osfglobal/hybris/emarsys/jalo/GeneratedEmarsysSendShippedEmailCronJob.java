/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 7-Feb-2017 11:23:01 PM                      ---
 * ----------------------------------------------------------------
 */
package com.osfglobal.hybris.emarsys.jalo;

import com.osfglobal.hybris.emarsys.jalo.EmarsysCronJob;
import de.hybris.platform.jalo.Item.AttributeMode;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type {@link de.hybris.platform.cronjob.jalo.CronJob EmarsysSendShippedEmailCronJob}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedEmarsysSendShippedEmailCronJob extends EmarsysCronJob
{
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(EmarsysCronJob.DEFAULT_INITIAL_ATTRIBUTES);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
}

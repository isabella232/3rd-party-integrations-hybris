package com.osfglobal.hybris.emarsys.jalo;

import de.hybris.platform.jalo.JaloSession;
import org.apache.log4j.Logger;

public abstract class EmarsysCronJob extends GeneratedEmarsysCronJob
{
	@SuppressWarnings("unused")
	private final static Logger LOG = Logger.getLogger( EmarsysCronJob.class.getName() );
	public static final String DISABLE_RESTRICTIONS = "disableRestrictions";
	public static final String DISABLE_RESTRICTIONS_GROUP_INHERITANCE = "disableRestrictionGroupInheritance";

	@Override
	protected JaloSession createSessionForCronJob(final JaloSession jaloSession)
	{
		final JaloSession parentSession = super.createSessionForCronJob(jaloSession);
		jaloSession.getSessionContext().setAttribute(DISABLE_RESTRICTIONS, Boolean.FALSE);
		jaloSession.getSessionContext().setAttribute(DISABLE_RESTRICTIONS_GROUP_INHERITANCE, Boolean.FALSE);
		return parentSession;
	}
	
}

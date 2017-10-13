/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 7-Feb-2017 11:23:01 PM                      ---
 * ----------------------------------------------------------------
 */
package com.osfglobal.hybris.emarsys.jalo;

import com.osfglobal.hybris.emarsys.constants.EmarsysConstants;
import com.osfglobal.hybris.emarsys.core.jalo.EmarsysInitialDBLoad;
import com.osfglobal.hybris.emarsys.core.jalo.EmarsysPlaceOrderTransactionalEmail;
import com.osfglobal.hybris.emarsys.core.jalo.EmarsysPlaceOrderTransactionalEmailMapping;
import com.osfglobal.hybris.emarsys.core.jalo.EmarsysPredict;
import com.osfglobal.hybris.emarsys.core.jalo.EmarsysPredictAvailabilityZone;
import com.osfglobal.hybris.emarsys.core.jalo.EmarsysPredictMapping;
import com.osfglobal.hybris.emarsys.core.jalo.EmarsysSettings;
import com.osfglobal.hybris.emarsys.core.jalo.EmarsysShipOrderTransactionalEmail;
import com.osfglobal.hybris.emarsys.core.jalo.EmarsysShipOrderTransactionalEmailMapping;
import com.osfglobal.hybris.emarsys.core.jalo.EmarsysSmartInsight;
import com.osfglobal.hybris.emarsys.core.jalo.EmarsysSmartInsightMapping;
import com.osfglobal.hybris.emarsys.jalo.EmarsysExternalEventsListCronJob;
import com.osfglobal.hybris.emarsys.jalo.EmarsysPredictCronJob;
import com.osfglobal.hybris.emarsys.jalo.EmarsysSendShippedEmailCronJob;
import com.osfglobal.hybris.emarsys.jalo.EmarsysSmartInsightCronJob;
import com.osfglobal.hybris.emarsys.jalo.EmarsysSyncUsersCronJob;
import de.hybris.platform.basecommerce.jalo.site.BaseSite;
import de.hybris.platform.jalo.GenericItem;
import de.hybris.platform.jalo.Item;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.JaloBusinessException;
import de.hybris.platform.jalo.JaloSystemException;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.extension.Extension;
import de.hybris.platform.jalo.order.AbstractOrder;
import de.hybris.platform.jalo.order.Order;
import de.hybris.platform.jalo.type.ComposedType;
import de.hybris.platform.jalo.type.JaloGenericCreationException;
import de.hybris.platform.jalo.user.Customer;
import de.hybris.platform.jalo.user.User;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type <code>EmarsysManager</code>.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedEmarsysManager extends Extension
{
	protected static final Map<String, Map<String, AttributeMode>> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, Map<String, AttributeMode>> ttmp = new HashMap();
		Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>();
		tmp.put("isSentEmail", AttributeMode.INITIAL);
		ttmp.put("de.hybris.platform.jalo.order.Order", Collections.unmodifiableMap(tmp));
		tmp = new HashMap<String, AttributeMode>();
		tmp.put("optinAttribute", AttributeMode.INITIAL);
		ttmp.put("de.hybris.platform.jalo.user.Customer", Collections.unmodifiableMap(tmp));
		tmp = new HashMap<String, AttributeMode>();
		tmp.put("emarsysSettings", AttributeMode.INITIAL);
		tmp.put("emarsysPlaceOrderTransactionalEmail", AttributeMode.INITIAL);
		tmp.put("emarsysShipOrderTransactionalEmail", AttributeMode.INITIAL);
		tmp.put("emarsysInitialDBLoad", AttributeMode.INITIAL);
		tmp.put("emarsysPredict", AttributeMode.INITIAL);
		tmp.put("emarsysSmartInsight", AttributeMode.INITIAL);
		tmp.put("emarsysDomainUrl", AttributeMode.INITIAL);
		tmp.put("emarsysSiteUrl", AttributeMode.INITIAL);
		ttmp.put("de.hybris.platform.basecommerce.jalo.site.BaseSite", Collections.unmodifiableMap(tmp));
		DEFAULT_INITIAL_ATTRIBUTES = ttmp;
	}
	@Override
	public Map<String, AttributeMode> getDefaultAttributeModes(final Class<? extends Item> itemClass)
	{
		Map<String, AttributeMode> ret = new HashMap<>();
		final Map<String, AttributeMode> attr = DEFAULT_INITIAL_ATTRIBUTES.get(itemClass.getName());
		if (attr != null)
		{
			ret.putAll(attr);
		}
		return ret;
	}
	
	public EmarsysExternalEventsListCronJob createEmarsysExternalEventsListCronJob(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( EmarsysConstants.TC.EMARSYSEXTERNALEVENTSLISTCRONJOB );
			return (EmarsysExternalEventsListCronJob)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating EmarsysExternalEventsListCronJob : "+e.getMessage(), 0 );
		}
	}
	
	public EmarsysExternalEventsListCronJob createEmarsysExternalEventsListCronJob(final Map attributeValues)
	{
		return createEmarsysExternalEventsListCronJob( getSession().getSessionContext(), attributeValues );
	}
	
	public EmarsysInitialDBLoad createEmarsysInitialDBLoad(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( EmarsysConstants.TC.EMARSYSINITIALDBLOAD );
			return (EmarsysInitialDBLoad)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating EmarsysInitialDBLoad : "+e.getMessage(), 0 );
		}
	}
	
	public EmarsysInitialDBLoad createEmarsysInitialDBLoad(final Map attributeValues)
	{
		return createEmarsysInitialDBLoad( getSession().getSessionContext(), attributeValues );
	}
	
	public EmarsysPlaceOrderTransactionalEmail createEmarsysPlaceOrderTransactionalEmail(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( EmarsysConstants.TC.EMARSYSPLACEORDERTRANSACTIONALEMAIL );
			return (EmarsysPlaceOrderTransactionalEmail)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating EmarsysPlaceOrderTransactionalEmail : "+e.getMessage(), 0 );
		}
	}
	
	public EmarsysPlaceOrderTransactionalEmail createEmarsysPlaceOrderTransactionalEmail(final Map attributeValues)
	{
		return createEmarsysPlaceOrderTransactionalEmail( getSession().getSessionContext(), attributeValues );
	}
	
	public EmarsysPlaceOrderTransactionalEmailMapping createEmarsysPlaceOrderTransactionalEmailMapping(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( EmarsysConstants.TC.EMARSYSPLACEORDERTRANSACTIONALEMAILMAPPING );
			return (EmarsysPlaceOrderTransactionalEmailMapping)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating EmarsysPlaceOrderTransactionalEmailMapping : "+e.getMessage(), 0 );
		}
	}
	
	public EmarsysPlaceOrderTransactionalEmailMapping createEmarsysPlaceOrderTransactionalEmailMapping(final Map attributeValues)
	{
		return createEmarsysPlaceOrderTransactionalEmailMapping( getSession().getSessionContext(), attributeValues );
	}
	
	public EmarsysPredict createEmarsysPredict(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( EmarsysConstants.TC.EMARSYSPREDICT );
			return (EmarsysPredict)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating EmarsysPredict : "+e.getMessage(), 0 );
		}
	}
	
	public EmarsysPredict createEmarsysPredict(final Map attributeValues)
	{
		return createEmarsysPredict( getSession().getSessionContext(), attributeValues );
	}
	
	public EmarsysPredictAvailabilityZone createEmarsysPredictAvailabilityZone(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( EmarsysConstants.TC.EMARSYSPREDICTAVAILABILITYZONE );
			return (EmarsysPredictAvailabilityZone)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating EmarsysPredictAvailabilityZone : "+e.getMessage(), 0 );
		}
	}
	
	public EmarsysPredictAvailabilityZone createEmarsysPredictAvailabilityZone(final Map attributeValues)
	{
		return createEmarsysPredictAvailabilityZone( getSession().getSessionContext(), attributeValues );
	}
	
	public EmarsysPredictCronJob createEmarsysPredictCronJob(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( EmarsysConstants.TC.EMARSYSPREDICTCRONJOB );
			return (EmarsysPredictCronJob)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating EmarsysPredictCronJob : "+e.getMessage(), 0 );
		}
	}
	
	public EmarsysPredictCronJob createEmarsysPredictCronJob(final Map attributeValues)
	{
		return createEmarsysPredictCronJob( getSession().getSessionContext(), attributeValues );
	}
	
	public EmarsysPredictMapping createEmarsysPredictMapping(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( EmarsysConstants.TC.EMARSYSPREDICTMAPPING );
			return (EmarsysPredictMapping)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating EmarsysPredictMapping : "+e.getMessage(), 0 );
		}
	}
	
	public EmarsysPredictMapping createEmarsysPredictMapping(final Map attributeValues)
	{
		return createEmarsysPredictMapping( getSession().getSessionContext(), attributeValues );
	}
	
	public EmarsysSendShippedEmailCronJob createEmarsysSendShippedEmailCronJob(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( EmarsysConstants.TC.EMARSYSSENDSHIPPEDEMAILCRONJOB );
			return (EmarsysSendShippedEmailCronJob)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating EmarsysSendShippedEmailCronJob : "+e.getMessage(), 0 );
		}
	}
	
	public EmarsysSendShippedEmailCronJob createEmarsysSendShippedEmailCronJob(final Map attributeValues)
	{
		return createEmarsysSendShippedEmailCronJob( getSession().getSessionContext(), attributeValues );
	}
	
	public EmarsysSettings createEmarsysSettings(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( EmarsysConstants.TC.EMARSYSSETTINGS );
			return (EmarsysSettings)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating EmarsysSettings : "+e.getMessage(), 0 );
		}
	}
	
	public EmarsysSettings createEmarsysSettings(final Map attributeValues)
	{
		return createEmarsysSettings( getSession().getSessionContext(), attributeValues );
	}
	
	public EmarsysShipOrderTransactionalEmail createEmarsysShipOrderTransactionalEmail(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( EmarsysConstants.TC.EMARSYSSHIPORDERTRANSACTIONALEMAIL );
			return (EmarsysShipOrderTransactionalEmail)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating EmarsysShipOrderTransactionalEmail : "+e.getMessage(), 0 );
		}
	}
	
	public EmarsysShipOrderTransactionalEmail createEmarsysShipOrderTransactionalEmail(final Map attributeValues)
	{
		return createEmarsysShipOrderTransactionalEmail( getSession().getSessionContext(), attributeValues );
	}
	
	public EmarsysShipOrderTransactionalEmailMapping createEmarsysShipOrderTransactionalEmailMapping(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( EmarsysConstants.TC.EMARSYSSHIPORDERTRANSACTIONALEMAILMAPPING );
			return (EmarsysShipOrderTransactionalEmailMapping)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating EmarsysShipOrderTransactionalEmailMapping : "+e.getMessage(), 0 );
		}
	}
	
	public EmarsysShipOrderTransactionalEmailMapping createEmarsysShipOrderTransactionalEmailMapping(final Map attributeValues)
	{
		return createEmarsysShipOrderTransactionalEmailMapping( getSession().getSessionContext(), attributeValues );
	}
	
	public EmarsysSmartInsight createEmarsysSmartInsight(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( EmarsysConstants.TC.EMARSYSSMARTINSIGHT );
			return (EmarsysSmartInsight)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating EmarsysSmartInsight : "+e.getMessage(), 0 );
		}
	}
	
	public EmarsysSmartInsight createEmarsysSmartInsight(final Map attributeValues)
	{
		return createEmarsysSmartInsight( getSession().getSessionContext(), attributeValues );
	}
	
	public EmarsysSmartInsightCronJob createEmarsysSmartInsightCronJob(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( EmarsysConstants.TC.EMARSYSSMARTINSIGHTCRONJOB );
			return (EmarsysSmartInsightCronJob)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating EmarsysSmartInsightCronJob : "+e.getMessage(), 0 );
		}
	}
	
	public EmarsysSmartInsightCronJob createEmarsysSmartInsightCronJob(final Map attributeValues)
	{
		return createEmarsysSmartInsightCronJob( getSession().getSessionContext(), attributeValues );
	}
	
	public EmarsysSmartInsightMapping createEmarsysSmartInsightMapping(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( EmarsysConstants.TC.EMARSYSSMARTINSIGHTMAPPING );
			return (EmarsysSmartInsightMapping)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating EmarsysSmartInsightMapping : "+e.getMessage(), 0 );
		}
	}
	
	public EmarsysSmartInsightMapping createEmarsysSmartInsightMapping(final Map attributeValues)
	{
		return createEmarsysSmartInsightMapping( getSession().getSessionContext(), attributeValues );
	}
	
	public EmarsysSyncUsersCronJob createEmarsysSyncUsersCronJob(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( EmarsysConstants.TC.EMARSYSSYNCUSERSCRONJOB );
			return (EmarsysSyncUsersCronJob)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating EmarsysSyncUsersCronJob : "+e.getMessage(), 0 );
		}
	}
	
	public EmarsysSyncUsersCronJob createEmarsysSyncUsersCronJob(final Map attributeValues)
	{
		return createEmarsysSyncUsersCronJob( getSession().getSessionContext(), attributeValues );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BaseSite.emarsysDomainUrl</code> attribute.
	 * @return the emarsysDomainUrl - Emarsys domain URL
	 */
	public String getEmarsysDomainUrl(final SessionContext ctx, final BaseSite item)
	{
		return (String)item.getProperty( ctx, EmarsysConstants.Attributes.BaseSite.EMARSYSDOMAINURL);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BaseSite.emarsysDomainUrl</code> attribute.
	 * @return the emarsysDomainUrl - Emarsys domain URL
	 */
	public String getEmarsysDomainUrl(final BaseSite item)
	{
		return getEmarsysDomainUrl( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>BaseSite.emarsysDomainUrl</code> attribute. 
	 * @param value the emarsysDomainUrl - Emarsys domain URL
	 */
	public void setEmarsysDomainUrl(final SessionContext ctx, final BaseSite item, final String value)
	{
		item.setProperty(ctx, EmarsysConstants.Attributes.BaseSite.EMARSYSDOMAINURL,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>BaseSite.emarsysDomainUrl</code> attribute. 
	 * @param value the emarsysDomainUrl - Emarsys domain URL
	 */
	public void setEmarsysDomainUrl(final BaseSite item, final String value)
	{
		setEmarsysDomainUrl( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BaseSite.emarsysInitialDBLoad</code> attribute.
	 * @return the emarsysInitialDBLoad
	 */
	public EmarsysInitialDBLoad getEmarsysInitialDBLoad(final SessionContext ctx, final BaseSite item)
	{
		return (EmarsysInitialDBLoad)item.getProperty( ctx, EmarsysConstants.Attributes.BaseSite.EMARSYSINITIALDBLOAD);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BaseSite.emarsysInitialDBLoad</code> attribute.
	 * @return the emarsysInitialDBLoad
	 */
	public EmarsysInitialDBLoad getEmarsysInitialDBLoad(final BaseSite item)
	{
		return getEmarsysInitialDBLoad( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>BaseSite.emarsysInitialDBLoad</code> attribute. 
	 * @param value the emarsysInitialDBLoad
	 */
	public void setEmarsysInitialDBLoad(final SessionContext ctx, final BaseSite item, final EmarsysInitialDBLoad value)
	{
		item.setProperty(ctx, EmarsysConstants.Attributes.BaseSite.EMARSYSINITIALDBLOAD,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>BaseSite.emarsysInitialDBLoad</code> attribute. 
	 * @param value the emarsysInitialDBLoad
	 */
	public void setEmarsysInitialDBLoad(final BaseSite item, final EmarsysInitialDBLoad value)
	{
		setEmarsysInitialDBLoad( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BaseSite.emarsysPlaceOrderTransactionalEmail</code> attribute.
	 * @return the emarsysPlaceOrderTransactionalEmail
	 */
	public EmarsysPlaceOrderTransactionalEmail getEmarsysPlaceOrderTransactionalEmail(final SessionContext ctx, final BaseSite item)
	{
		return (EmarsysPlaceOrderTransactionalEmail)item.getProperty( ctx, EmarsysConstants.Attributes.BaseSite.EMARSYSPLACEORDERTRANSACTIONALEMAIL);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BaseSite.emarsysPlaceOrderTransactionalEmail</code> attribute.
	 * @return the emarsysPlaceOrderTransactionalEmail
	 */
	public EmarsysPlaceOrderTransactionalEmail getEmarsysPlaceOrderTransactionalEmail(final BaseSite item)
	{
		return getEmarsysPlaceOrderTransactionalEmail( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>BaseSite.emarsysPlaceOrderTransactionalEmail</code> attribute. 
	 * @param value the emarsysPlaceOrderTransactionalEmail
	 */
	public void setEmarsysPlaceOrderTransactionalEmail(final SessionContext ctx, final BaseSite item, final EmarsysPlaceOrderTransactionalEmail value)
	{
		item.setProperty(ctx, EmarsysConstants.Attributes.BaseSite.EMARSYSPLACEORDERTRANSACTIONALEMAIL,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>BaseSite.emarsysPlaceOrderTransactionalEmail</code> attribute. 
	 * @param value the emarsysPlaceOrderTransactionalEmail
	 */
	public void setEmarsysPlaceOrderTransactionalEmail(final BaseSite item, final EmarsysPlaceOrderTransactionalEmail value)
	{
		setEmarsysPlaceOrderTransactionalEmail( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BaseSite.emarsysPredict</code> attribute.
	 * @return the emarsysPredict
	 */
	public EmarsysPredict getEmarsysPredict(final SessionContext ctx, final BaseSite item)
	{
		return (EmarsysPredict)item.getProperty( ctx, EmarsysConstants.Attributes.BaseSite.EMARSYSPREDICT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BaseSite.emarsysPredict</code> attribute.
	 * @return the emarsysPredict
	 */
	public EmarsysPredict getEmarsysPredict(final BaseSite item)
	{
		return getEmarsysPredict( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>BaseSite.emarsysPredict</code> attribute. 
	 * @param value the emarsysPredict
	 */
	public void setEmarsysPredict(final SessionContext ctx, final BaseSite item, final EmarsysPredict value)
	{
		item.setProperty(ctx, EmarsysConstants.Attributes.BaseSite.EMARSYSPREDICT,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>BaseSite.emarsysPredict</code> attribute. 
	 * @param value the emarsysPredict
	 */
	public void setEmarsysPredict(final BaseSite item, final EmarsysPredict value)
	{
		setEmarsysPredict( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BaseSite.emarsysSettings</code> attribute.
	 * @return the emarsysSettings
	 */
	public EmarsysSettings getEmarsysSettings(final SessionContext ctx, final BaseSite item)
	{
		return (EmarsysSettings)item.getProperty( ctx, EmarsysConstants.Attributes.BaseSite.EMARSYSSETTINGS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BaseSite.emarsysSettings</code> attribute.
	 * @return the emarsysSettings
	 */
	public EmarsysSettings getEmarsysSettings(final BaseSite item)
	{
		return getEmarsysSettings( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>BaseSite.emarsysSettings</code> attribute. 
	 * @param value the emarsysSettings
	 */
	public void setEmarsysSettings(final SessionContext ctx, final BaseSite item, final EmarsysSettings value)
	{
		item.setProperty(ctx, EmarsysConstants.Attributes.BaseSite.EMARSYSSETTINGS,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>BaseSite.emarsysSettings</code> attribute. 
	 * @param value the emarsysSettings
	 */
	public void setEmarsysSettings(final BaseSite item, final EmarsysSettings value)
	{
		setEmarsysSettings( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BaseSite.emarsysShipOrderTransactionalEmail</code> attribute.
	 * @return the emarsysShipOrderTransactionalEmail
	 */
	public EmarsysShipOrderTransactionalEmail getEmarsysShipOrderTransactionalEmail(final SessionContext ctx, final BaseSite item)
	{
		return (EmarsysShipOrderTransactionalEmail)item.getProperty( ctx, EmarsysConstants.Attributes.BaseSite.EMARSYSSHIPORDERTRANSACTIONALEMAIL);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BaseSite.emarsysShipOrderTransactionalEmail</code> attribute.
	 * @return the emarsysShipOrderTransactionalEmail
	 */
	public EmarsysShipOrderTransactionalEmail getEmarsysShipOrderTransactionalEmail(final BaseSite item)
	{
		return getEmarsysShipOrderTransactionalEmail( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>BaseSite.emarsysShipOrderTransactionalEmail</code> attribute. 
	 * @param value the emarsysShipOrderTransactionalEmail
	 */
	public void setEmarsysShipOrderTransactionalEmail(final SessionContext ctx, final BaseSite item, final EmarsysShipOrderTransactionalEmail value)
	{
		item.setProperty(ctx, EmarsysConstants.Attributes.BaseSite.EMARSYSSHIPORDERTRANSACTIONALEMAIL,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>BaseSite.emarsysShipOrderTransactionalEmail</code> attribute. 
	 * @param value the emarsysShipOrderTransactionalEmail
	 */
	public void setEmarsysShipOrderTransactionalEmail(final BaseSite item, final EmarsysShipOrderTransactionalEmail value)
	{
		setEmarsysShipOrderTransactionalEmail( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BaseSite.emarsysSiteUrl</code> attribute.
	 * @return the emarsysSiteUrl - Emarsys site URL
	 */
	public String getEmarsysSiteUrl(final SessionContext ctx, final BaseSite item)
	{
		return (String)item.getProperty( ctx, EmarsysConstants.Attributes.BaseSite.EMARSYSSITEURL);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BaseSite.emarsysSiteUrl</code> attribute.
	 * @return the emarsysSiteUrl - Emarsys site URL
	 */
	public String getEmarsysSiteUrl(final BaseSite item)
	{
		return getEmarsysSiteUrl( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>BaseSite.emarsysSiteUrl</code> attribute. 
	 * @param value the emarsysSiteUrl - Emarsys site URL
	 */
	public void setEmarsysSiteUrl(final SessionContext ctx, final BaseSite item, final String value)
	{
		item.setProperty(ctx, EmarsysConstants.Attributes.BaseSite.EMARSYSSITEURL,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>BaseSite.emarsysSiteUrl</code> attribute. 
	 * @param value the emarsysSiteUrl - Emarsys site URL
	 */
	public void setEmarsysSiteUrl(final BaseSite item, final String value)
	{
		setEmarsysSiteUrl( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BaseSite.emarsysSmartInsight</code> attribute.
	 * @return the emarsysSmartInsight
	 */
	public EmarsysSmartInsight getEmarsysSmartInsight(final SessionContext ctx, final BaseSite item)
	{
		return (EmarsysSmartInsight)item.getProperty( ctx, EmarsysConstants.Attributes.BaseSite.EMARSYSSMARTINSIGHT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>BaseSite.emarsysSmartInsight</code> attribute.
	 * @return the emarsysSmartInsight
	 */
	public EmarsysSmartInsight getEmarsysSmartInsight(final BaseSite item)
	{
		return getEmarsysSmartInsight( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>BaseSite.emarsysSmartInsight</code> attribute. 
	 * @param value the emarsysSmartInsight
	 */
	public void setEmarsysSmartInsight(final SessionContext ctx, final BaseSite item, final EmarsysSmartInsight value)
	{
		item.setProperty(ctx, EmarsysConstants.Attributes.BaseSite.EMARSYSSMARTINSIGHT,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>BaseSite.emarsysSmartInsight</code> attribute. 
	 * @param value the emarsysSmartInsight
	 */
	public void setEmarsysSmartInsight(final BaseSite item, final EmarsysSmartInsight value)
	{
		setEmarsysSmartInsight( getSession().getSessionContext(), item, value );
	}
	
	@Override
	public String getName()
	{
		return EmarsysConstants.EXTENSIONNAME;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Order.isSentEmail</code> attribute.
	 * @return the isSentEmail - Custom field specify whether an email was sent
	 */
	public Boolean isIsSentEmail(final SessionContext ctx, final Order item)
	{
		return (Boolean)item.getProperty( ctx, EmarsysConstants.Attributes.Order.ISSENTEMAIL);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Order.isSentEmail</code> attribute.
	 * @return the isSentEmail - Custom field specify whether an email was sent
	 */
	public Boolean isIsSentEmail(final Order item)
	{
		return isIsSentEmail( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Order.isSentEmail</code> attribute. 
	 * @return the isSentEmail - Custom field specify whether an email was sent
	 */
	public boolean isIsSentEmailAsPrimitive(final SessionContext ctx, final Order item)
	{
		Boolean value = isIsSentEmail( ctx,item );
		return value != null ? value.booleanValue() : false;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Order.isSentEmail</code> attribute. 
	 * @return the isSentEmail - Custom field specify whether an email was sent
	 */
	public boolean isIsSentEmailAsPrimitive(final Order item)
	{
		return isIsSentEmailAsPrimitive( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Order.isSentEmail</code> attribute. 
	 * @param value the isSentEmail - Custom field specify whether an email was sent
	 */
	public void setIsSentEmail(final SessionContext ctx, final Order item, final Boolean value)
	{
		item.setProperty(ctx, EmarsysConstants.Attributes.Order.ISSENTEMAIL,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Order.isSentEmail</code> attribute. 
	 * @param value the isSentEmail - Custom field specify whether an email was sent
	 */
	public void setIsSentEmail(final Order item, final Boolean value)
	{
		setIsSentEmail( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Order.isSentEmail</code> attribute. 
	 * @param value the isSentEmail - Custom field specify whether an email was sent
	 */
	public void setIsSentEmail(final SessionContext ctx, final Order item, final boolean value)
	{
		setIsSentEmail( ctx, item, Boolean.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Order.isSentEmail</code> attribute. 
	 * @param value the isSentEmail - Custom field specify whether an email was sent
	 */
	public void setIsSentEmail(final Order item, final boolean value)
	{
		setIsSentEmail( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.optinAttribute</code> attribute.
	 * @return the optinAttribute - Custom field to set the desired opt-in status of the synchronized recipient profiles
	 */
	public Boolean isOptinAttribute(final SessionContext ctx, final Customer item)
	{
		return (Boolean)item.getProperty( ctx, EmarsysConstants.Attributes.Customer.OPTINATTRIBUTE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.optinAttribute</code> attribute.
	 * @return the optinAttribute - Custom field to set the desired opt-in status of the synchronized recipient profiles
	 */
	public Boolean isOptinAttribute(final Customer item)
	{
		return isOptinAttribute( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.optinAttribute</code> attribute. 
	 * @return the optinAttribute - Custom field to set the desired opt-in status of the synchronized recipient profiles
	 */
	public boolean isOptinAttributeAsPrimitive(final SessionContext ctx, final Customer item)
	{
		Boolean value = isOptinAttribute( ctx,item );
		return value != null ? value.booleanValue() : false;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.optinAttribute</code> attribute. 
	 * @return the optinAttribute - Custom field to set the desired opt-in status of the synchronized recipient profiles
	 */
	public boolean isOptinAttributeAsPrimitive(final Customer item)
	{
		return isOptinAttributeAsPrimitive( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.optinAttribute</code> attribute. 
	 * @param value the optinAttribute - Custom field to set the desired opt-in status of the synchronized recipient profiles
	 */
	public void setOptinAttribute(final SessionContext ctx, final Customer item, final Boolean value)
	{
		item.setProperty(ctx, EmarsysConstants.Attributes.Customer.OPTINATTRIBUTE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.optinAttribute</code> attribute. 
	 * @param value the optinAttribute - Custom field to set the desired opt-in status of the synchronized recipient profiles
	 */
	public void setOptinAttribute(final Customer item, final Boolean value)
	{
		setOptinAttribute( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.optinAttribute</code> attribute. 
	 * @param value the optinAttribute - Custom field to set the desired opt-in status of the synchronized recipient profiles
	 */
	public void setOptinAttribute(final SessionContext ctx, final Customer item, final boolean value)
	{
		setOptinAttribute( ctx, item, Boolean.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.optinAttribute</code> attribute. 
	 * @param value the optinAttribute - Custom field to set the desired opt-in status of the synchronized recipient profiles
	 */
	public void setOptinAttribute(final Customer item, final boolean value)
	{
		setOptinAttribute( getSession().getSessionContext(), item, value );
	}
	
}

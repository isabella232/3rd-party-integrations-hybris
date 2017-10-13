/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 7-Feb-2017 11:23:01 PM                      ---
 * ----------------------------------------------------------------
 */
package com.osfglobal.hybris.emarsys.core.jalo;

import com.osfglobal.hybris.emarsys.constants.EmarsysConstants;
import com.osfglobal.hybris.emarsys.core.jalo.EmarsysPredict;
import de.hybris.platform.jalo.GenericItem;
import de.hybris.platform.jalo.Item;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.JaloBusinessException;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.c2l.Currency;
import de.hybris.platform.jalo.c2l.Language;
import de.hybris.platform.jalo.type.CollectionType;
import de.hybris.platform.jalo.type.ComposedType;
import de.hybris.platform.util.BidirectionalOneToManyHandler;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type {@link com.osfglobal.hybris.emarsys.core.jalo.EmarsysPredictAvailabilityZone EmarsysPredictAvailabilityZone}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedEmarsysPredictAvailabilityZone extends GenericItem
{
	/** Qualifier of the <code>EmarsysPredictAvailabilityZone.name</code> attribute **/
	public static final String NAME = "name";
	/** Qualifier of the <code>EmarsysPredictAvailabilityZone.language</code> attribute **/
	public static final String LANGUAGE = "language";
	/** Qualifier of the <code>EmarsysPredictAvailabilityZone.currency</code> attribute **/
	public static final String CURRENCY = "currency";
	/** Qualifier of the <code>EmarsysPredictAvailabilityZone.emarsysPredictPOS</code> attribute **/
	public static final String EMARSYSPREDICTPOS = "emarsysPredictPOS";
	/** Qualifier of the <code>EmarsysPredictAvailabilityZone.emarsysPredict</code> attribute **/
	public static final String EMARSYSPREDICT = "emarsysPredict";
	/**
	* {@link BidirectionalOneToManyHandler} for handling 1:n EMARSYSPREDICT's relation attributes from 'one' side.
	**/
	protected static final BidirectionalOneToManyHandler<GeneratedEmarsysPredictAvailabilityZone> EMARSYSPREDICTHANDLER = new BidirectionalOneToManyHandler<GeneratedEmarsysPredictAvailabilityZone>(
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
		tmp.put(NAME, AttributeMode.INITIAL);
		tmp.put(LANGUAGE, AttributeMode.INITIAL);
		tmp.put(CURRENCY, AttributeMode.INITIAL);
		tmp.put(EMARSYSPREDICTPOS, AttributeMode.INITIAL);
		tmp.put(EMARSYSPREDICT, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	@Override
	protected Item createItem(final SessionContext ctx, final ComposedType type, final ItemAttributeMap allAttributes) throws JaloBusinessException
	{
		EMARSYSPREDICTHANDLER.newInstance(ctx, allAttributes);
		return super.createItem( ctx, type, allAttributes );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysPredictAvailabilityZone.currency</code> attribute.
	 * @return the currency
	 */
	public Currency getCurrency(final SessionContext ctx)
	{
		return (Currency)getProperty( ctx, CURRENCY);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysPredictAvailabilityZone.currency</code> attribute.
	 * @return the currency
	 */
	public Currency getCurrency()
	{
		return getCurrency( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysPredictAvailabilityZone.currency</code> attribute. 
	 * @param value the currency
	 */
	public void setCurrency(final SessionContext ctx, final Currency value)
	{
		setProperty(ctx, CURRENCY,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysPredictAvailabilityZone.currency</code> attribute. 
	 * @param value the currency
	 */
	public void setCurrency(final Currency value)
	{
		setCurrency( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysPredictAvailabilityZone.emarsysPredict</code> attribute.
	 * @return the emarsysPredict
	 */
	public EmarsysPredict getEmarsysPredict(final SessionContext ctx)
	{
		return (EmarsysPredict)getProperty( ctx, EMARSYSPREDICT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysPredictAvailabilityZone.emarsysPredict</code> attribute.
	 * @return the emarsysPredict
	 */
	public EmarsysPredict getEmarsysPredict()
	{
		return getEmarsysPredict( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysPredictAvailabilityZone.emarsysPredict</code> attribute. 
	 * @param value the emarsysPredict
	 */
	public void setEmarsysPredict(final SessionContext ctx, final EmarsysPredict value)
	{
		EMARSYSPREDICTHANDLER.addValue( ctx, value, this  );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysPredictAvailabilityZone.emarsysPredict</code> attribute. 
	 * @param value the emarsysPredict
	 */
	public void setEmarsysPredict(final EmarsysPredict value)
	{
		setEmarsysPredict( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysPredictAvailabilityZone.emarsysPredictPOS</code> attribute.
	 * @return the emarsysPredictPOS
	 */
	 Integer getEmarsysPredictPOS(final SessionContext ctx)
	{
		return (Integer)getProperty( ctx, EMARSYSPREDICTPOS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysPredictAvailabilityZone.emarsysPredictPOS</code> attribute.
	 * @return the emarsysPredictPOS
	 */
	 Integer getEmarsysPredictPOS()
	{
		return getEmarsysPredictPOS( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysPredictAvailabilityZone.emarsysPredictPOS</code> attribute. 
	 * @return the emarsysPredictPOS
	 */
	 int getEmarsysPredictPOSAsPrimitive(final SessionContext ctx)
	{
		Integer value = getEmarsysPredictPOS( ctx );
		return value != null ? value.intValue() : 0;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysPredictAvailabilityZone.emarsysPredictPOS</code> attribute. 
	 * @return the emarsysPredictPOS
	 */
	 int getEmarsysPredictPOSAsPrimitive()
	{
		return getEmarsysPredictPOSAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysPredictAvailabilityZone.emarsysPredictPOS</code> attribute. 
	 * @param value the emarsysPredictPOS
	 */
	 void setEmarsysPredictPOS(final SessionContext ctx, final Integer value)
	{
		setProperty(ctx, EMARSYSPREDICTPOS,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysPredictAvailabilityZone.emarsysPredictPOS</code> attribute. 
	 * @param value the emarsysPredictPOS
	 */
	 void setEmarsysPredictPOS(final Integer value)
	{
		setEmarsysPredictPOS( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysPredictAvailabilityZone.emarsysPredictPOS</code> attribute. 
	 * @param value the emarsysPredictPOS
	 */
	 void setEmarsysPredictPOS(final SessionContext ctx, final int value)
	{
		setEmarsysPredictPOS( ctx,Integer.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysPredictAvailabilityZone.emarsysPredictPOS</code> attribute. 
	 * @param value the emarsysPredictPOS
	 */
	 void setEmarsysPredictPOS(final int value)
	{
		setEmarsysPredictPOS( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysPredictAvailabilityZone.language</code> attribute.
	 * @return the language
	 */
	public Language getLanguage(final SessionContext ctx)
	{
		return (Language)getProperty( ctx, LANGUAGE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysPredictAvailabilityZone.language</code> attribute.
	 * @return the language
	 */
	public Language getLanguage()
	{
		return getLanguage( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysPredictAvailabilityZone.language</code> attribute. 
	 * @param value the language
	 */
	public void setLanguage(final SessionContext ctx, final Language value)
	{
		setProperty(ctx, LANGUAGE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysPredictAvailabilityZone.language</code> attribute. 
	 * @param value the language
	 */
	public void setLanguage(final Language value)
	{
		setLanguage( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysPredictAvailabilityZone.name</code> attribute.
	 * @return the name
	 */
	public String getName(final SessionContext ctx)
	{
		return (String)getProperty( ctx, NAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysPredictAvailabilityZone.name</code> attribute.
	 * @return the name
	 */
	public String getName()
	{
		return getName( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysPredictAvailabilityZone.name</code> attribute. 
	 * @param value the name
	 */
	public void setName(final SessionContext ctx, final String value)
	{
		setProperty(ctx, NAME,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysPredictAvailabilityZone.name</code> attribute. 
	 * @param value the name
	 */
	public void setName(final String value)
	{
		setName( getSession().getSessionContext(), value );
	}
	
}

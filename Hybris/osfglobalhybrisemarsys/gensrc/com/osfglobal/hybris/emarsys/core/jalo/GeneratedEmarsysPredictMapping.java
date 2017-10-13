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
import de.hybris.platform.jalo.enumeration.EnumerationValue;
import de.hybris.platform.jalo.type.CollectionType;
import de.hybris.platform.jalo.type.ComposedType;
import de.hybris.platform.util.BidirectionalOneToManyHandler;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type {@link com.osfglobal.hybris.emarsys.core.jalo.EmarsysPredictMapping EmarsysPredictMapping}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedEmarsysPredictMapping extends GenericItem
{
	/** Qualifier of the <code>EmarsysPredictMapping.hybrisField</code> attribute **/
	public static final String HYBRISFIELD = "hybrisField";
	/** Qualifier of the <code>EmarsysPredictMapping.emarsysPlaceholder</code> attribute **/
	public static final String EMARSYSPLACEHOLDER = "emarsysPlaceholder";
	/** Qualifier of the <code>EmarsysPredictMapping.emarsysPredictPOS</code> attribute **/
	public static final String EMARSYSPREDICTPOS = "emarsysPredictPOS";
	/** Qualifier of the <code>EmarsysPredictMapping.emarsysPredict</code> attribute **/
	public static final String EMARSYSPREDICT = "emarsysPredict";
	/**
	* {@link BidirectionalOneToManyHandler} for handling 1:n EMARSYSPREDICT's relation attributes from 'one' side.
	**/
	protected static final BidirectionalOneToManyHandler<GeneratedEmarsysPredictMapping> EMARSYSPREDICTHANDLER = new BidirectionalOneToManyHandler<GeneratedEmarsysPredictMapping>(
	EmarsysConstants.TC.EMARSYSPREDICTMAPPING,
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
		tmp.put(HYBRISFIELD, AttributeMode.INITIAL);
		tmp.put(EMARSYSPLACEHOLDER, AttributeMode.INITIAL);
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
	 * <i>Generated method</i> - Getter of the <code>EmarsysPredictMapping.emarsysPlaceholder</code> attribute.
	 * @return the emarsysPlaceholder
	 */
	public String getEmarsysPlaceholder(final SessionContext ctx)
	{
		return (String)getProperty( ctx, EMARSYSPLACEHOLDER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysPredictMapping.emarsysPlaceholder</code> attribute.
	 * @return the emarsysPlaceholder
	 */
	public String getEmarsysPlaceholder()
	{
		return getEmarsysPlaceholder( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysPredictMapping.emarsysPlaceholder</code> attribute. 
	 * @param value the emarsysPlaceholder
	 */
	public void setEmarsysPlaceholder(final SessionContext ctx, final String value)
	{
		setProperty(ctx, EMARSYSPLACEHOLDER,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysPredictMapping.emarsysPlaceholder</code> attribute. 
	 * @param value the emarsysPlaceholder
	 */
	public void setEmarsysPlaceholder(final String value)
	{
		setEmarsysPlaceholder( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysPredictMapping.emarsysPredict</code> attribute.
	 * @return the emarsysPredict
	 */
	public EmarsysPredict getEmarsysPredict(final SessionContext ctx)
	{
		return (EmarsysPredict)getProperty( ctx, EMARSYSPREDICT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysPredictMapping.emarsysPredict</code> attribute.
	 * @return the emarsysPredict
	 */
	public EmarsysPredict getEmarsysPredict()
	{
		return getEmarsysPredict( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysPredictMapping.emarsysPredict</code> attribute. 
	 * @param value the emarsysPredict
	 */
	public void setEmarsysPredict(final SessionContext ctx, final EmarsysPredict value)
	{
		EMARSYSPREDICTHANDLER.addValue( ctx, value, this  );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysPredictMapping.emarsysPredict</code> attribute. 
	 * @param value the emarsysPredict
	 */
	public void setEmarsysPredict(final EmarsysPredict value)
	{
		setEmarsysPredict( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysPredictMapping.emarsysPredictPOS</code> attribute.
	 * @return the emarsysPredictPOS
	 */
	 Integer getEmarsysPredictPOS(final SessionContext ctx)
	{
		return (Integer)getProperty( ctx, EMARSYSPREDICTPOS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysPredictMapping.emarsysPredictPOS</code> attribute.
	 * @return the emarsysPredictPOS
	 */
	 Integer getEmarsysPredictPOS()
	{
		return getEmarsysPredictPOS( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysPredictMapping.emarsysPredictPOS</code> attribute. 
	 * @return the emarsysPredictPOS
	 */
	 int getEmarsysPredictPOSAsPrimitive(final SessionContext ctx)
	{
		Integer value = getEmarsysPredictPOS( ctx );
		return value != null ? value.intValue() : 0;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysPredictMapping.emarsysPredictPOS</code> attribute. 
	 * @return the emarsysPredictPOS
	 */
	 int getEmarsysPredictPOSAsPrimitive()
	{
		return getEmarsysPredictPOSAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysPredictMapping.emarsysPredictPOS</code> attribute. 
	 * @param value the emarsysPredictPOS
	 */
	 void setEmarsysPredictPOS(final SessionContext ctx, final Integer value)
	{
		setProperty(ctx, EMARSYSPREDICTPOS,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysPredictMapping.emarsysPredictPOS</code> attribute. 
	 * @param value the emarsysPredictPOS
	 */
	 void setEmarsysPredictPOS(final Integer value)
	{
		setEmarsysPredictPOS( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysPredictMapping.emarsysPredictPOS</code> attribute. 
	 * @param value the emarsysPredictPOS
	 */
	 void setEmarsysPredictPOS(final SessionContext ctx, final int value)
	{
		setEmarsysPredictPOS( ctx,Integer.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysPredictMapping.emarsysPredictPOS</code> attribute. 
	 * @param value the emarsysPredictPOS
	 */
	 void setEmarsysPredictPOS(final int value)
	{
		setEmarsysPredictPOS( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysPredictMapping.hybrisField</code> attribute.
	 * @return the hybrisField
	 */
	public EnumerationValue getHybrisField(final SessionContext ctx)
	{
		return (EnumerationValue)getProperty( ctx, HYBRISFIELD);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysPredictMapping.hybrisField</code> attribute.
	 * @return the hybrisField
	 */
	public EnumerationValue getHybrisField()
	{
		return getHybrisField( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysPredictMapping.hybrisField</code> attribute. 
	 * @param value the hybrisField
	 */
	public void setHybrisField(final SessionContext ctx, final EnumerationValue value)
	{
		setProperty(ctx, HYBRISFIELD,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysPredictMapping.hybrisField</code> attribute. 
	 * @param value the hybrisField
	 */
	public void setHybrisField(final EnumerationValue value)
	{
		setHybrisField( getSession().getSessionContext(), value );
	}
	
}

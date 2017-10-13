/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 7-Feb-2017 11:23:01 PM                      ---
 * ----------------------------------------------------------------
 */
package com.osfglobal.hybris.emarsys.core.jalo;

import com.osfglobal.hybris.emarsys.constants.EmarsysConstants;
import com.osfglobal.hybris.emarsys.core.jalo.EmarsysSmartInsight;
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
 * Generated class for type {@link com.osfglobal.hybris.emarsys.core.jalo.EmarsysSmartInsightMapping EmarsysSmartInsightMapping}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedEmarsysSmartInsightMapping extends GenericItem
{
	/** Qualifier of the <code>EmarsysSmartInsightMapping.hybrisField</code> attribute **/
	public static final String HYBRISFIELD = "hybrisField";
	/** Qualifier of the <code>EmarsysSmartInsightMapping.emarsysPlaceholder</code> attribute **/
	public static final String EMARSYSPLACEHOLDER = "emarsysPlaceholder";
	/** Qualifier of the <code>EmarsysSmartInsightMapping.emarsysSmartInsightPOS</code> attribute **/
	public static final String EMARSYSSMARTINSIGHTPOS = "emarsysSmartInsightPOS";
	/** Qualifier of the <code>EmarsysSmartInsightMapping.emarsysSmartInsight</code> attribute **/
	public static final String EMARSYSSMARTINSIGHT = "emarsysSmartInsight";
	/**
	* {@link BidirectionalOneToManyHandler} for handling 1:n EMARSYSSMARTINSIGHT's relation attributes from 'one' side.
	**/
	protected static final BidirectionalOneToManyHandler<GeneratedEmarsysSmartInsightMapping> EMARSYSSMARTINSIGHTHANDLER = new BidirectionalOneToManyHandler<GeneratedEmarsysSmartInsightMapping>(
	EmarsysConstants.TC.EMARSYSSMARTINSIGHTMAPPING,
	false,
	"emarsysSmartInsight",
	"emarsysSmartInsightPOS",
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
		tmp.put(EMARSYSSMARTINSIGHTPOS, AttributeMode.INITIAL);
		tmp.put(EMARSYSSMARTINSIGHT, AttributeMode.INITIAL);
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
		EMARSYSSMARTINSIGHTHANDLER.newInstance(ctx, allAttributes);
		return super.createItem( ctx, type, allAttributes );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSmartInsightMapping.emarsysPlaceholder</code> attribute.
	 * @return the emarsysPlaceholder
	 */
	public String getEmarsysPlaceholder(final SessionContext ctx)
	{
		return (String)getProperty( ctx, EMARSYSPLACEHOLDER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSmartInsightMapping.emarsysPlaceholder</code> attribute.
	 * @return the emarsysPlaceholder
	 */
	public String getEmarsysPlaceholder()
	{
		return getEmarsysPlaceholder( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSmartInsightMapping.emarsysPlaceholder</code> attribute. 
	 * @param value the emarsysPlaceholder
	 */
	public void setEmarsysPlaceholder(final SessionContext ctx, final String value)
	{
		setProperty(ctx, EMARSYSPLACEHOLDER,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSmartInsightMapping.emarsysPlaceholder</code> attribute. 
	 * @param value the emarsysPlaceholder
	 */
	public void setEmarsysPlaceholder(final String value)
	{
		setEmarsysPlaceholder( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSmartInsightMapping.emarsysSmartInsight</code> attribute.
	 * @return the emarsysSmartInsight
	 */
	public EmarsysSmartInsight getEmarsysSmartInsight(final SessionContext ctx)
	{
		return (EmarsysSmartInsight)getProperty( ctx, EMARSYSSMARTINSIGHT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSmartInsightMapping.emarsysSmartInsight</code> attribute.
	 * @return the emarsysSmartInsight
	 */
	public EmarsysSmartInsight getEmarsysSmartInsight()
	{
		return getEmarsysSmartInsight( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSmartInsightMapping.emarsysSmartInsight</code> attribute. 
	 * @param value the emarsysSmartInsight
	 */
	public void setEmarsysSmartInsight(final SessionContext ctx, final EmarsysSmartInsight value)
	{
		EMARSYSSMARTINSIGHTHANDLER.addValue( ctx, value, this  );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSmartInsightMapping.emarsysSmartInsight</code> attribute. 
	 * @param value the emarsysSmartInsight
	 */
	public void setEmarsysSmartInsight(final EmarsysSmartInsight value)
	{
		setEmarsysSmartInsight( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSmartInsightMapping.emarsysSmartInsightPOS</code> attribute.
	 * @return the emarsysSmartInsightPOS
	 */
	 Integer getEmarsysSmartInsightPOS(final SessionContext ctx)
	{
		return (Integer)getProperty( ctx, EMARSYSSMARTINSIGHTPOS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSmartInsightMapping.emarsysSmartInsightPOS</code> attribute.
	 * @return the emarsysSmartInsightPOS
	 */
	 Integer getEmarsysSmartInsightPOS()
	{
		return getEmarsysSmartInsightPOS( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSmartInsightMapping.emarsysSmartInsightPOS</code> attribute. 
	 * @return the emarsysSmartInsightPOS
	 */
	 int getEmarsysSmartInsightPOSAsPrimitive(final SessionContext ctx)
	{
		Integer value = getEmarsysSmartInsightPOS( ctx );
		return value != null ? value.intValue() : 0;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSmartInsightMapping.emarsysSmartInsightPOS</code> attribute. 
	 * @return the emarsysSmartInsightPOS
	 */
	 int getEmarsysSmartInsightPOSAsPrimitive()
	{
		return getEmarsysSmartInsightPOSAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSmartInsightMapping.emarsysSmartInsightPOS</code> attribute. 
	 * @param value the emarsysSmartInsightPOS
	 */
	 void setEmarsysSmartInsightPOS(final SessionContext ctx, final Integer value)
	{
		setProperty(ctx, EMARSYSSMARTINSIGHTPOS,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSmartInsightMapping.emarsysSmartInsightPOS</code> attribute. 
	 * @param value the emarsysSmartInsightPOS
	 */
	 void setEmarsysSmartInsightPOS(final Integer value)
	{
		setEmarsysSmartInsightPOS( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSmartInsightMapping.emarsysSmartInsightPOS</code> attribute. 
	 * @param value the emarsysSmartInsightPOS
	 */
	 void setEmarsysSmartInsightPOS(final SessionContext ctx, final int value)
	{
		setEmarsysSmartInsightPOS( ctx,Integer.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSmartInsightMapping.emarsysSmartInsightPOS</code> attribute. 
	 * @param value the emarsysSmartInsightPOS
	 */
	 void setEmarsysSmartInsightPOS(final int value)
	{
		setEmarsysSmartInsightPOS( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSmartInsightMapping.hybrisField</code> attribute.
	 * @return the hybrisField
	 */
	public EnumerationValue getHybrisField(final SessionContext ctx)
	{
		return (EnumerationValue)getProperty( ctx, HYBRISFIELD);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSmartInsightMapping.hybrisField</code> attribute.
	 * @return the hybrisField
	 */
	public EnumerationValue getHybrisField()
	{
		return getHybrisField( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSmartInsightMapping.hybrisField</code> attribute. 
	 * @param value the hybrisField
	 */
	public void setHybrisField(final SessionContext ctx, final EnumerationValue value)
	{
		setProperty(ctx, HYBRISFIELD,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSmartInsightMapping.hybrisField</code> attribute. 
	 * @param value the hybrisField
	 */
	public void setHybrisField(final EnumerationValue value)
	{
		setHybrisField( getSession().getSessionContext(), value );
	}
	
}

/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 7-Feb-2017 11:23:01 PM                      ---
 * ----------------------------------------------------------------
 */
package com.osfglobal.hybris.emarsys.core.jalo;

import com.osfglobal.hybris.emarsys.constants.EmarsysConstants;
import com.osfglobal.hybris.emarsys.core.jalo.EmarsysShipOrderTransactionalEmail;
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
 * Generated class for type {@link com.osfglobal.hybris.emarsys.core.jalo.EmarsysShipOrderTransactionalEmailMapping EmarsysShipOrderTransactionalEmailMapping}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedEmarsysShipOrderTransactionalEmailMapping extends GenericItem
{
	/** Qualifier of the <code>EmarsysShipOrderTransactionalEmailMapping.hybrisCustomerField</code> attribute **/
	public static final String HYBRISCUSTOMERFIELD = "hybrisCustomerField";
	/** Qualifier of the <code>EmarsysShipOrderTransactionalEmailMapping.emarsysPlaceholder</code> attribute **/
	public static final String EMARSYSPLACEHOLDER = "emarsysPlaceholder";
	/** Qualifier of the <code>EmarsysShipOrderTransactionalEmailMapping.emarsysShipOrderTransactionalEmailPOS</code> attribute **/
	public static final String EMARSYSSHIPORDERTRANSACTIONALEMAILPOS = "emarsysShipOrderTransactionalEmailPOS";
	/** Qualifier of the <code>EmarsysShipOrderTransactionalEmailMapping.emarsysShipOrderTransactionalEmail</code> attribute **/
	public static final String EMARSYSSHIPORDERTRANSACTIONALEMAIL = "emarsysShipOrderTransactionalEmail";
	/**
	* {@link BidirectionalOneToManyHandler} for handling 1:n EMARSYSSHIPORDERTRANSACTIONALEMAIL's relation attributes from 'one' side.
	**/
	protected static final BidirectionalOneToManyHandler<GeneratedEmarsysShipOrderTransactionalEmailMapping> EMARSYSSHIPORDERTRANSACTIONALEMAILHANDLER = new BidirectionalOneToManyHandler<GeneratedEmarsysShipOrderTransactionalEmailMapping>(
	EmarsysConstants.TC.EMARSYSSHIPORDERTRANSACTIONALEMAILMAPPING,
	false,
	"emarsysShipOrderTransactionalEmail",
	"emarsysShipOrderTransactionalEmailPOS",
	true,
	true,
	CollectionType.SET
	);
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>();
		tmp.put(HYBRISCUSTOMERFIELD, AttributeMode.INITIAL);
		tmp.put(EMARSYSPLACEHOLDER, AttributeMode.INITIAL);
		tmp.put(EMARSYSSHIPORDERTRANSACTIONALEMAILPOS, AttributeMode.INITIAL);
		tmp.put(EMARSYSSHIPORDERTRANSACTIONALEMAIL, AttributeMode.INITIAL);
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
		EMARSYSSHIPORDERTRANSACTIONALEMAILHANDLER.newInstance(ctx, allAttributes);
		return super.createItem( ctx, type, allAttributes );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysShipOrderTransactionalEmailMapping.emarsysPlaceholder</code> attribute.
	 * @return the emarsysPlaceholder
	 */
	public String getEmarsysPlaceholder(final SessionContext ctx)
	{
		return (String)getProperty( ctx, EMARSYSPLACEHOLDER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysShipOrderTransactionalEmailMapping.emarsysPlaceholder</code> attribute.
	 * @return the emarsysPlaceholder
	 */
	public String getEmarsysPlaceholder()
	{
		return getEmarsysPlaceholder( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysShipOrderTransactionalEmailMapping.emarsysPlaceholder</code> attribute. 
	 * @param value the emarsysPlaceholder
	 */
	public void setEmarsysPlaceholder(final SessionContext ctx, final String value)
	{
		setProperty(ctx, EMARSYSPLACEHOLDER,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysShipOrderTransactionalEmailMapping.emarsysPlaceholder</code> attribute. 
	 * @param value the emarsysPlaceholder
	 */
	public void setEmarsysPlaceholder(final String value)
	{
		setEmarsysPlaceholder( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysShipOrderTransactionalEmailMapping.emarsysShipOrderTransactionalEmail</code> attribute.
	 * @return the emarsysShipOrderTransactionalEmail
	 */
	public EmarsysShipOrderTransactionalEmail getEmarsysShipOrderTransactionalEmail(final SessionContext ctx)
	{
		return (EmarsysShipOrderTransactionalEmail)getProperty( ctx, EMARSYSSHIPORDERTRANSACTIONALEMAIL);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysShipOrderTransactionalEmailMapping.emarsysShipOrderTransactionalEmail</code> attribute.
	 * @return the emarsysShipOrderTransactionalEmail
	 */
	public EmarsysShipOrderTransactionalEmail getEmarsysShipOrderTransactionalEmail()
	{
		return getEmarsysShipOrderTransactionalEmail( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysShipOrderTransactionalEmailMapping.emarsysShipOrderTransactionalEmail</code> attribute. 
	 * @param value the emarsysShipOrderTransactionalEmail
	 */
	public void setEmarsysShipOrderTransactionalEmail(final SessionContext ctx, final EmarsysShipOrderTransactionalEmail value)
	{
		EMARSYSSHIPORDERTRANSACTIONALEMAILHANDLER.addValue( ctx, value, this  );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysShipOrderTransactionalEmailMapping.emarsysShipOrderTransactionalEmail</code> attribute. 
	 * @param value the emarsysShipOrderTransactionalEmail
	 */
	public void setEmarsysShipOrderTransactionalEmail(final EmarsysShipOrderTransactionalEmail value)
	{
		setEmarsysShipOrderTransactionalEmail( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysShipOrderTransactionalEmailMapping.emarsysShipOrderTransactionalEmailPOS</code> attribute.
	 * @return the emarsysShipOrderTransactionalEmailPOS
	 */
	 Integer getEmarsysShipOrderTransactionalEmailPOS(final SessionContext ctx)
	{
		return (Integer)getProperty( ctx, EMARSYSSHIPORDERTRANSACTIONALEMAILPOS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysShipOrderTransactionalEmailMapping.emarsysShipOrderTransactionalEmailPOS</code> attribute.
	 * @return the emarsysShipOrderTransactionalEmailPOS
	 */
	 Integer getEmarsysShipOrderTransactionalEmailPOS()
	{
		return getEmarsysShipOrderTransactionalEmailPOS( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysShipOrderTransactionalEmailMapping.emarsysShipOrderTransactionalEmailPOS</code> attribute. 
	 * @return the emarsysShipOrderTransactionalEmailPOS
	 */
	 int getEmarsysShipOrderTransactionalEmailPOSAsPrimitive(final SessionContext ctx)
	{
		Integer value = getEmarsysShipOrderTransactionalEmailPOS( ctx );
		return value != null ? value.intValue() : 0;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysShipOrderTransactionalEmailMapping.emarsysShipOrderTransactionalEmailPOS</code> attribute. 
	 * @return the emarsysShipOrderTransactionalEmailPOS
	 */
	 int getEmarsysShipOrderTransactionalEmailPOSAsPrimitive()
	{
		return getEmarsysShipOrderTransactionalEmailPOSAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysShipOrderTransactionalEmailMapping.emarsysShipOrderTransactionalEmailPOS</code> attribute. 
	 * @param value the emarsysShipOrderTransactionalEmailPOS
	 */
	 void setEmarsysShipOrderTransactionalEmailPOS(final SessionContext ctx, final Integer value)
	{
		setProperty(ctx, EMARSYSSHIPORDERTRANSACTIONALEMAILPOS,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysShipOrderTransactionalEmailMapping.emarsysShipOrderTransactionalEmailPOS</code> attribute. 
	 * @param value the emarsysShipOrderTransactionalEmailPOS
	 */
	 void setEmarsysShipOrderTransactionalEmailPOS(final Integer value)
	{
		setEmarsysShipOrderTransactionalEmailPOS( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysShipOrderTransactionalEmailMapping.emarsysShipOrderTransactionalEmailPOS</code> attribute. 
	 * @param value the emarsysShipOrderTransactionalEmailPOS
	 */
	 void setEmarsysShipOrderTransactionalEmailPOS(final SessionContext ctx, final int value)
	{
		setEmarsysShipOrderTransactionalEmailPOS( ctx,Integer.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysShipOrderTransactionalEmailMapping.emarsysShipOrderTransactionalEmailPOS</code> attribute. 
	 * @param value the emarsysShipOrderTransactionalEmailPOS
	 */
	 void setEmarsysShipOrderTransactionalEmailPOS(final int value)
	{
		setEmarsysShipOrderTransactionalEmailPOS( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysShipOrderTransactionalEmailMapping.hybrisCustomerField</code> attribute.
	 * @return the hybrisCustomerField
	 */
	public EnumerationValue getHybrisCustomerField(final SessionContext ctx)
	{
		return (EnumerationValue)getProperty( ctx, HYBRISCUSTOMERFIELD);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysShipOrderTransactionalEmailMapping.hybrisCustomerField</code> attribute.
	 * @return the hybrisCustomerField
	 */
	public EnumerationValue getHybrisCustomerField()
	{
		return getHybrisCustomerField( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysShipOrderTransactionalEmailMapping.hybrisCustomerField</code> attribute. 
	 * @param value the hybrisCustomerField
	 */
	public void setHybrisCustomerField(final SessionContext ctx, final EnumerationValue value)
	{
		setProperty(ctx, HYBRISCUSTOMERFIELD,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysShipOrderTransactionalEmailMapping.hybrisCustomerField</code> attribute. 
	 * @param value the hybrisCustomerField
	 */
	public void setHybrisCustomerField(final EnumerationValue value)
	{
		setHybrisCustomerField( getSession().getSessionContext(), value );
	}
	
}

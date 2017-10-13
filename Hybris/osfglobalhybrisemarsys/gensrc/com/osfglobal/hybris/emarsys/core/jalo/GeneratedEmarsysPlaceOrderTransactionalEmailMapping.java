/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 7-Feb-2017 11:23:01 PM                      ---
 * ----------------------------------------------------------------
 */
package com.osfglobal.hybris.emarsys.core.jalo;

import com.osfglobal.hybris.emarsys.constants.EmarsysConstants;
import com.osfglobal.hybris.emarsys.core.jalo.EmarsysPlaceOrderTransactionalEmail;
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
 * Generated class for type {@link com.osfglobal.hybris.emarsys.core.jalo.EmarsysPlaceOrderTransactionalEmailMapping EmarsysPlaceOrderTransactionalEmailMapping}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedEmarsysPlaceOrderTransactionalEmailMapping extends GenericItem
{
	/** Qualifier of the <code>EmarsysPlaceOrderTransactionalEmailMapping.hybrisCustomerField</code> attribute **/
	public static final String HYBRISCUSTOMERFIELD = "hybrisCustomerField";
	/** Qualifier of the <code>EmarsysPlaceOrderTransactionalEmailMapping.emarsysPlaceholder</code> attribute **/
	public static final String EMARSYSPLACEHOLDER = "emarsysPlaceholder";
	/** Qualifier of the <code>EmarsysPlaceOrderTransactionalEmailMapping.emarsysPlaceOrderTransactionalEmailPOS</code> attribute **/
	public static final String EMARSYSPLACEORDERTRANSACTIONALEMAILPOS = "emarsysPlaceOrderTransactionalEmailPOS";
	/** Qualifier of the <code>EmarsysPlaceOrderTransactionalEmailMapping.emarsysPlaceOrderTransactionalEmail</code> attribute **/
	public static final String EMARSYSPLACEORDERTRANSACTIONALEMAIL = "emarsysPlaceOrderTransactionalEmail";
	/**
	* {@link BidirectionalOneToManyHandler} for handling 1:n EMARSYSPLACEORDERTRANSACTIONALEMAIL's relation attributes from 'one' side.
	**/
	protected static final BidirectionalOneToManyHandler<GeneratedEmarsysPlaceOrderTransactionalEmailMapping> EMARSYSPLACEORDERTRANSACTIONALEMAILHANDLER = new BidirectionalOneToManyHandler<GeneratedEmarsysPlaceOrderTransactionalEmailMapping>(
	EmarsysConstants.TC.EMARSYSPLACEORDERTRANSACTIONALEMAILMAPPING,
	false,
	"emarsysPlaceOrderTransactionalEmail",
	"emarsysPlaceOrderTransactionalEmailPOS",
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
		tmp.put(EMARSYSPLACEORDERTRANSACTIONALEMAILPOS, AttributeMode.INITIAL);
		tmp.put(EMARSYSPLACEORDERTRANSACTIONALEMAIL, AttributeMode.INITIAL);
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
		EMARSYSPLACEORDERTRANSACTIONALEMAILHANDLER.newInstance(ctx, allAttributes);
		return super.createItem( ctx, type, allAttributes );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysPlaceOrderTransactionalEmailMapping.emarsysPlaceholder</code> attribute.
	 * @return the emarsysPlaceholder
	 */
	public String getEmarsysPlaceholder(final SessionContext ctx)
	{
		return (String)getProperty( ctx, EMARSYSPLACEHOLDER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysPlaceOrderTransactionalEmailMapping.emarsysPlaceholder</code> attribute.
	 * @return the emarsysPlaceholder
	 */
	public String getEmarsysPlaceholder()
	{
		return getEmarsysPlaceholder( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysPlaceOrderTransactionalEmailMapping.emarsysPlaceholder</code> attribute. 
	 * @param value the emarsysPlaceholder
	 */
	public void setEmarsysPlaceholder(final SessionContext ctx, final String value)
	{
		setProperty(ctx, EMARSYSPLACEHOLDER,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysPlaceOrderTransactionalEmailMapping.emarsysPlaceholder</code> attribute. 
	 * @param value the emarsysPlaceholder
	 */
	public void setEmarsysPlaceholder(final String value)
	{
		setEmarsysPlaceholder( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysPlaceOrderTransactionalEmailMapping.emarsysPlaceOrderTransactionalEmail</code> attribute.
	 * @return the emarsysPlaceOrderTransactionalEmail
	 */
	public EmarsysPlaceOrderTransactionalEmail getEmarsysPlaceOrderTransactionalEmail(final SessionContext ctx)
	{
		return (EmarsysPlaceOrderTransactionalEmail)getProperty( ctx, EMARSYSPLACEORDERTRANSACTIONALEMAIL);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysPlaceOrderTransactionalEmailMapping.emarsysPlaceOrderTransactionalEmail</code> attribute.
	 * @return the emarsysPlaceOrderTransactionalEmail
	 */
	public EmarsysPlaceOrderTransactionalEmail getEmarsysPlaceOrderTransactionalEmail()
	{
		return getEmarsysPlaceOrderTransactionalEmail( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysPlaceOrderTransactionalEmailMapping.emarsysPlaceOrderTransactionalEmail</code> attribute. 
	 * @param value the emarsysPlaceOrderTransactionalEmail
	 */
	public void setEmarsysPlaceOrderTransactionalEmail(final SessionContext ctx, final EmarsysPlaceOrderTransactionalEmail value)
	{
		EMARSYSPLACEORDERTRANSACTIONALEMAILHANDLER.addValue( ctx, value, this  );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysPlaceOrderTransactionalEmailMapping.emarsysPlaceOrderTransactionalEmail</code> attribute. 
	 * @param value the emarsysPlaceOrderTransactionalEmail
	 */
	public void setEmarsysPlaceOrderTransactionalEmail(final EmarsysPlaceOrderTransactionalEmail value)
	{
		setEmarsysPlaceOrderTransactionalEmail( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysPlaceOrderTransactionalEmailMapping.emarsysPlaceOrderTransactionalEmailPOS</code> attribute.
	 * @return the emarsysPlaceOrderTransactionalEmailPOS
	 */
	 Integer getEmarsysPlaceOrderTransactionalEmailPOS(final SessionContext ctx)
	{
		return (Integer)getProperty( ctx, EMARSYSPLACEORDERTRANSACTIONALEMAILPOS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysPlaceOrderTransactionalEmailMapping.emarsysPlaceOrderTransactionalEmailPOS</code> attribute.
	 * @return the emarsysPlaceOrderTransactionalEmailPOS
	 */
	 Integer getEmarsysPlaceOrderTransactionalEmailPOS()
	{
		return getEmarsysPlaceOrderTransactionalEmailPOS( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysPlaceOrderTransactionalEmailMapping.emarsysPlaceOrderTransactionalEmailPOS</code> attribute. 
	 * @return the emarsysPlaceOrderTransactionalEmailPOS
	 */
	 int getEmarsysPlaceOrderTransactionalEmailPOSAsPrimitive(final SessionContext ctx)
	{
		Integer value = getEmarsysPlaceOrderTransactionalEmailPOS( ctx );
		return value != null ? value.intValue() : 0;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysPlaceOrderTransactionalEmailMapping.emarsysPlaceOrderTransactionalEmailPOS</code> attribute. 
	 * @return the emarsysPlaceOrderTransactionalEmailPOS
	 */
	 int getEmarsysPlaceOrderTransactionalEmailPOSAsPrimitive()
	{
		return getEmarsysPlaceOrderTransactionalEmailPOSAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysPlaceOrderTransactionalEmailMapping.emarsysPlaceOrderTransactionalEmailPOS</code> attribute. 
	 * @param value the emarsysPlaceOrderTransactionalEmailPOS
	 */
	 void setEmarsysPlaceOrderTransactionalEmailPOS(final SessionContext ctx, final Integer value)
	{
		setProperty(ctx, EMARSYSPLACEORDERTRANSACTIONALEMAILPOS,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysPlaceOrderTransactionalEmailMapping.emarsysPlaceOrderTransactionalEmailPOS</code> attribute. 
	 * @param value the emarsysPlaceOrderTransactionalEmailPOS
	 */
	 void setEmarsysPlaceOrderTransactionalEmailPOS(final Integer value)
	{
		setEmarsysPlaceOrderTransactionalEmailPOS( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysPlaceOrderTransactionalEmailMapping.emarsysPlaceOrderTransactionalEmailPOS</code> attribute. 
	 * @param value the emarsysPlaceOrderTransactionalEmailPOS
	 */
	 void setEmarsysPlaceOrderTransactionalEmailPOS(final SessionContext ctx, final int value)
	{
		setEmarsysPlaceOrderTransactionalEmailPOS( ctx,Integer.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysPlaceOrderTransactionalEmailMapping.emarsysPlaceOrderTransactionalEmailPOS</code> attribute. 
	 * @param value the emarsysPlaceOrderTransactionalEmailPOS
	 */
	 void setEmarsysPlaceOrderTransactionalEmailPOS(final int value)
	{
		setEmarsysPlaceOrderTransactionalEmailPOS( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysPlaceOrderTransactionalEmailMapping.hybrisCustomerField</code> attribute.
	 * @return the hybrisCustomerField
	 */
	public EnumerationValue getHybrisCustomerField(final SessionContext ctx)
	{
		return (EnumerationValue)getProperty( ctx, HYBRISCUSTOMERFIELD);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysPlaceOrderTransactionalEmailMapping.hybrisCustomerField</code> attribute.
	 * @return the hybrisCustomerField
	 */
	public EnumerationValue getHybrisCustomerField()
	{
		return getHybrisCustomerField( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysPlaceOrderTransactionalEmailMapping.hybrisCustomerField</code> attribute. 
	 * @param value the hybrisCustomerField
	 */
	public void setHybrisCustomerField(final SessionContext ctx, final EnumerationValue value)
	{
		setProperty(ctx, HYBRISCUSTOMERFIELD,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysPlaceOrderTransactionalEmailMapping.hybrisCustomerField</code> attribute. 
	 * @param value the hybrisCustomerField
	 */
	public void setHybrisCustomerField(final EnumerationValue value)
	{
		setHybrisCustomerField( getSession().getSessionContext(), value );
	}
	
}

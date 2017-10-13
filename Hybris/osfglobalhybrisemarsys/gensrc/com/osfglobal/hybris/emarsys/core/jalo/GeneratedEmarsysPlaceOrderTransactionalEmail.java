/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 7-Feb-2017 11:23:01 PM                      ---
 * ----------------------------------------------------------------
 */
package com.osfglobal.hybris.emarsys.core.jalo;

import com.osfglobal.hybris.emarsys.constants.EmarsysConstants;
import com.osfglobal.hybris.emarsys.core.jalo.EmarsysPlaceOrderTransactionalEmailMapping;
import com.osfglobal.hybris.emarsys.jalo.EmarsysTransactionalEmail;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.type.CollectionType;
import de.hybris.platform.util.OneToManyHandler;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Generated class for type {@link com.osfglobal.hybris.emarsys.core.jalo.EmarsysPlaceOrderTransactionalEmail EmarsysPlaceOrderTransactionalEmail}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedEmarsysPlaceOrderTransactionalEmail extends EmarsysTransactionalEmail
{
	/** Qualifier of the <code>EmarsysPlaceOrderTransactionalEmail.emarsysPlaceOrderTransactionalEmailMapping</code> attribute **/
	public static final String EMARSYSPLACEORDERTRANSACTIONALEMAILMAPPING = "emarsysPlaceOrderTransactionalEmailMapping";
	/**
	* {@link OneToManyHandler} for handling 1:n EMARSYSPLACEORDERTRANSACTIONALEMAILMAPPING's relation attributes from 'many' side.
	**/
	protected static final OneToManyHandler<EmarsysPlaceOrderTransactionalEmailMapping> EMARSYSPLACEORDERTRANSACTIONALEMAILMAPPINGHANDLER = new OneToManyHandler<EmarsysPlaceOrderTransactionalEmailMapping>(
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
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(EmarsysTransactionalEmail.DEFAULT_INITIAL_ATTRIBUTES);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysPlaceOrderTransactionalEmail.emarsysPlaceOrderTransactionalEmailMapping</code> attribute.
	 * @return the emarsysPlaceOrderTransactionalEmailMapping
	 */
	public Set<EmarsysPlaceOrderTransactionalEmailMapping> getEmarsysPlaceOrderTransactionalEmailMapping(final SessionContext ctx)
	{
		return (Set<EmarsysPlaceOrderTransactionalEmailMapping>)EMARSYSPLACEORDERTRANSACTIONALEMAILMAPPINGHANDLER.getValues( ctx, this );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysPlaceOrderTransactionalEmail.emarsysPlaceOrderTransactionalEmailMapping</code> attribute.
	 * @return the emarsysPlaceOrderTransactionalEmailMapping
	 */
	public Set<EmarsysPlaceOrderTransactionalEmailMapping> getEmarsysPlaceOrderTransactionalEmailMapping()
	{
		return getEmarsysPlaceOrderTransactionalEmailMapping( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysPlaceOrderTransactionalEmail.emarsysPlaceOrderTransactionalEmailMapping</code> attribute. 
	 * @param value the emarsysPlaceOrderTransactionalEmailMapping
	 */
	public void setEmarsysPlaceOrderTransactionalEmailMapping(final SessionContext ctx, final Set<EmarsysPlaceOrderTransactionalEmailMapping> value)
	{
		EMARSYSPLACEORDERTRANSACTIONALEMAILMAPPINGHANDLER.setValues( ctx, this, value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysPlaceOrderTransactionalEmail.emarsysPlaceOrderTransactionalEmailMapping</code> attribute. 
	 * @param value the emarsysPlaceOrderTransactionalEmailMapping
	 */
	public void setEmarsysPlaceOrderTransactionalEmailMapping(final Set<EmarsysPlaceOrderTransactionalEmailMapping> value)
	{
		setEmarsysPlaceOrderTransactionalEmailMapping( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to emarsysPlaceOrderTransactionalEmailMapping. 
	 * @param value the item to add to emarsysPlaceOrderTransactionalEmailMapping
	 */
	public void addToEmarsysPlaceOrderTransactionalEmailMapping(final SessionContext ctx, final EmarsysPlaceOrderTransactionalEmailMapping value)
	{
		EMARSYSPLACEORDERTRANSACTIONALEMAILMAPPINGHANDLER.addValue( ctx, this, value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to emarsysPlaceOrderTransactionalEmailMapping. 
	 * @param value the item to add to emarsysPlaceOrderTransactionalEmailMapping
	 */
	public void addToEmarsysPlaceOrderTransactionalEmailMapping(final EmarsysPlaceOrderTransactionalEmailMapping value)
	{
		addToEmarsysPlaceOrderTransactionalEmailMapping( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from emarsysPlaceOrderTransactionalEmailMapping. 
	 * @param value the item to remove from emarsysPlaceOrderTransactionalEmailMapping
	 */
	public void removeFromEmarsysPlaceOrderTransactionalEmailMapping(final SessionContext ctx, final EmarsysPlaceOrderTransactionalEmailMapping value)
	{
		EMARSYSPLACEORDERTRANSACTIONALEMAILMAPPINGHANDLER.removeValue( ctx, this, value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from emarsysPlaceOrderTransactionalEmailMapping. 
	 * @param value the item to remove from emarsysPlaceOrderTransactionalEmailMapping
	 */
	public void removeFromEmarsysPlaceOrderTransactionalEmailMapping(final EmarsysPlaceOrderTransactionalEmailMapping value)
	{
		removeFromEmarsysPlaceOrderTransactionalEmailMapping( getSession().getSessionContext(), value );
	}
	
}

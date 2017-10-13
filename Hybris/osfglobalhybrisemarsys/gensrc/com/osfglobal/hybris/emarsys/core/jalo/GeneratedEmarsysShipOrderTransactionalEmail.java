/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 7-Feb-2017 11:23:01 PM                      ---
 * ----------------------------------------------------------------
 */
package com.osfglobal.hybris.emarsys.core.jalo;

import com.osfglobal.hybris.emarsys.constants.EmarsysConstants;
import com.osfglobal.hybris.emarsys.core.jalo.EmarsysShipOrderTransactionalEmailMapping;
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
 * Generated class for type {@link com.osfglobal.hybris.emarsys.core.jalo.EmarsysShipOrderTransactionalEmail EmarsysShipOrderTransactionalEmail}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedEmarsysShipOrderTransactionalEmail extends EmarsysTransactionalEmail
{
	/** Qualifier of the <code>EmarsysShipOrderTransactionalEmail.emarsysShipOrderTransactionalEmailMapping</code> attribute **/
	public static final String EMARSYSSHIPORDERTRANSACTIONALEMAILMAPPING = "emarsysShipOrderTransactionalEmailMapping";
	/**
	* {@link OneToManyHandler} for handling 1:n EMARSYSSHIPORDERTRANSACTIONALEMAILMAPPING's relation attributes from 'many' side.
	**/
	protected static final OneToManyHandler<EmarsysShipOrderTransactionalEmailMapping> EMARSYSSHIPORDERTRANSACTIONALEMAILMAPPINGHANDLER = new OneToManyHandler<EmarsysShipOrderTransactionalEmailMapping>(
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
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(EmarsysTransactionalEmail.DEFAULT_INITIAL_ATTRIBUTES);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysShipOrderTransactionalEmail.emarsysShipOrderTransactionalEmailMapping</code> attribute.
	 * @return the emarsysShipOrderTransactionalEmailMapping
	 */
	public Set<EmarsysShipOrderTransactionalEmailMapping> getEmarsysShipOrderTransactionalEmailMapping(final SessionContext ctx)
	{
		return (Set<EmarsysShipOrderTransactionalEmailMapping>)EMARSYSSHIPORDERTRANSACTIONALEMAILMAPPINGHANDLER.getValues( ctx, this );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysShipOrderTransactionalEmail.emarsysShipOrderTransactionalEmailMapping</code> attribute.
	 * @return the emarsysShipOrderTransactionalEmailMapping
	 */
	public Set<EmarsysShipOrderTransactionalEmailMapping> getEmarsysShipOrderTransactionalEmailMapping()
	{
		return getEmarsysShipOrderTransactionalEmailMapping( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysShipOrderTransactionalEmail.emarsysShipOrderTransactionalEmailMapping</code> attribute. 
	 * @param value the emarsysShipOrderTransactionalEmailMapping
	 */
	public void setEmarsysShipOrderTransactionalEmailMapping(final SessionContext ctx, final Set<EmarsysShipOrderTransactionalEmailMapping> value)
	{
		EMARSYSSHIPORDERTRANSACTIONALEMAILMAPPINGHANDLER.setValues( ctx, this, value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysShipOrderTransactionalEmail.emarsysShipOrderTransactionalEmailMapping</code> attribute. 
	 * @param value the emarsysShipOrderTransactionalEmailMapping
	 */
	public void setEmarsysShipOrderTransactionalEmailMapping(final Set<EmarsysShipOrderTransactionalEmailMapping> value)
	{
		setEmarsysShipOrderTransactionalEmailMapping( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to emarsysShipOrderTransactionalEmailMapping. 
	 * @param value the item to add to emarsysShipOrderTransactionalEmailMapping
	 */
	public void addToEmarsysShipOrderTransactionalEmailMapping(final SessionContext ctx, final EmarsysShipOrderTransactionalEmailMapping value)
	{
		EMARSYSSHIPORDERTRANSACTIONALEMAILMAPPINGHANDLER.addValue( ctx, this, value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to emarsysShipOrderTransactionalEmailMapping. 
	 * @param value the item to add to emarsysShipOrderTransactionalEmailMapping
	 */
	public void addToEmarsysShipOrderTransactionalEmailMapping(final EmarsysShipOrderTransactionalEmailMapping value)
	{
		addToEmarsysShipOrderTransactionalEmailMapping( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from emarsysShipOrderTransactionalEmailMapping. 
	 * @param value the item to remove from emarsysShipOrderTransactionalEmailMapping
	 */
	public void removeFromEmarsysShipOrderTransactionalEmailMapping(final SessionContext ctx, final EmarsysShipOrderTransactionalEmailMapping value)
	{
		EMARSYSSHIPORDERTRANSACTIONALEMAILMAPPINGHANDLER.removeValue( ctx, this, value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from emarsysShipOrderTransactionalEmailMapping. 
	 * @param value the item to remove from emarsysShipOrderTransactionalEmailMapping
	 */
	public void removeFromEmarsysShipOrderTransactionalEmailMapping(final EmarsysShipOrderTransactionalEmailMapping value)
	{
		removeFromEmarsysShipOrderTransactionalEmailMapping( getSession().getSessionContext(), value );
	}
	
}

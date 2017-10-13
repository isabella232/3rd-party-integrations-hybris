/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 7-Feb-2017 11:23:01 PM                      ---
 * ----------------------------------------------------------------
 */
package com.osfglobal.hybris.emarsys.core.jalo;

import com.osfglobal.hybris.emarsys.constants.EmarsysConstants;
import com.osfglobal.hybris.emarsys.core.jalo.EmarsysSmartInsightMapping;
import de.hybris.platform.jalo.GenericItem;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.type.CollectionType;
import de.hybris.platform.util.OneToManyHandler;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Generated class for type {@link com.osfglobal.hybris.emarsys.core.jalo.EmarsysSmartInsight EmarsysSmartInsight}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedEmarsysSmartInsight extends GenericItem
{
	/** Qualifier of the <code>EmarsysSmartInsight.uid</code> attribute **/
	public static final String UID = "uid";
	/** Qualifier of the <code>EmarsysSmartInsight.enableSmartInsight</code> attribute **/
	public static final String ENABLESMARTINSIGHT = "enableSmartInsight";
	/** Qualifier of the <code>EmarsysSmartInsight.enableSmartInsightTimeframe</code> attribute **/
	public static final String ENABLESMARTINSIGHTTIMEFRAME = "enableSmartInsightTimeframe";
	/** Qualifier of the <code>EmarsysSmartInsight.startDate</code> attribute **/
	public static final String STARTDATE = "startDate";
	/** Qualifier of the <code>EmarsysSmartInsight.endDate</code> attribute **/
	public static final String ENDDATE = "endDate";
	/** Qualifier of the <code>EmarsysSmartInsight.sftpHost</code> attribute **/
	public static final String SFTPHOST = "sftpHost";
	/** Qualifier of the <code>EmarsysSmartInsight.sftpUsername</code> attribute **/
	public static final String SFTPUSERNAME = "sftpUsername";
	/** Qualifier of the <code>EmarsysSmartInsight.sftpPassword</code> attribute **/
	public static final String SFTPPASSWORD = "sftpPassword";
	/** Qualifier of the <code>EmarsysSmartInsight.sftpPath</code> attribute **/
	public static final String SFTPPATH = "sftpPath";
	/** Qualifier of the <code>EmarsysSmartInsight.emarsysSmartInsightMappings</code> attribute **/
	public static final String EMARSYSSMARTINSIGHTMAPPINGS = "emarsysSmartInsightMappings";
	/**
	* {@link OneToManyHandler} for handling 1:n EMARSYSSMARTINSIGHTMAPPINGS's relation attributes from 'many' side.
	**/
	protected static final OneToManyHandler<EmarsysSmartInsightMapping> EMARSYSSMARTINSIGHTMAPPINGSHANDLER = new OneToManyHandler<EmarsysSmartInsightMapping>(
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
		tmp.put(UID, AttributeMode.INITIAL);
		tmp.put(ENABLESMARTINSIGHT, AttributeMode.INITIAL);
		tmp.put(ENABLESMARTINSIGHTTIMEFRAME, AttributeMode.INITIAL);
		tmp.put(STARTDATE, AttributeMode.INITIAL);
		tmp.put(ENDDATE, AttributeMode.INITIAL);
		tmp.put(SFTPHOST, AttributeMode.INITIAL);
		tmp.put(SFTPUSERNAME, AttributeMode.INITIAL);
		tmp.put(SFTPPASSWORD, AttributeMode.INITIAL);
		tmp.put(SFTPPATH, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSmartInsight.emarsysSmartInsightMappings</code> attribute.
	 * @return the emarsysSmartInsightMappings
	 */
	public Set<EmarsysSmartInsightMapping> getEmarsysSmartInsightMappings(final SessionContext ctx)
	{
		return (Set<EmarsysSmartInsightMapping>)EMARSYSSMARTINSIGHTMAPPINGSHANDLER.getValues( ctx, this );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSmartInsight.emarsysSmartInsightMappings</code> attribute.
	 * @return the emarsysSmartInsightMappings
	 */
	public Set<EmarsysSmartInsightMapping> getEmarsysSmartInsightMappings()
	{
		return getEmarsysSmartInsightMappings( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSmartInsight.emarsysSmartInsightMappings</code> attribute. 
	 * @param value the emarsysSmartInsightMappings
	 */
	public void setEmarsysSmartInsightMappings(final SessionContext ctx, final Set<EmarsysSmartInsightMapping> value)
	{
		EMARSYSSMARTINSIGHTMAPPINGSHANDLER.setValues( ctx, this, value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSmartInsight.emarsysSmartInsightMappings</code> attribute. 
	 * @param value the emarsysSmartInsightMappings
	 */
	public void setEmarsysSmartInsightMappings(final Set<EmarsysSmartInsightMapping> value)
	{
		setEmarsysSmartInsightMappings( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to emarsysSmartInsightMappings. 
	 * @param value the item to add to emarsysSmartInsightMappings
	 */
	public void addToEmarsysSmartInsightMappings(final SessionContext ctx, final EmarsysSmartInsightMapping value)
	{
		EMARSYSSMARTINSIGHTMAPPINGSHANDLER.addValue( ctx, this, value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to emarsysSmartInsightMappings. 
	 * @param value the item to add to emarsysSmartInsightMappings
	 */
	public void addToEmarsysSmartInsightMappings(final EmarsysSmartInsightMapping value)
	{
		addToEmarsysSmartInsightMappings( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from emarsysSmartInsightMappings. 
	 * @param value the item to remove from emarsysSmartInsightMappings
	 */
	public void removeFromEmarsysSmartInsightMappings(final SessionContext ctx, final EmarsysSmartInsightMapping value)
	{
		EMARSYSSMARTINSIGHTMAPPINGSHANDLER.removeValue( ctx, this, value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from emarsysSmartInsightMappings. 
	 * @param value the item to remove from emarsysSmartInsightMappings
	 */
	public void removeFromEmarsysSmartInsightMappings(final EmarsysSmartInsightMapping value)
	{
		removeFromEmarsysSmartInsightMappings( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSmartInsight.enableSmartInsight</code> attribute.
	 * @return the enableSmartInsight
	 */
	public Boolean isEnableSmartInsight(final SessionContext ctx)
	{
		return (Boolean)getProperty( ctx, ENABLESMARTINSIGHT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSmartInsight.enableSmartInsight</code> attribute.
	 * @return the enableSmartInsight
	 */
	public Boolean isEnableSmartInsight()
	{
		return isEnableSmartInsight( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSmartInsight.enableSmartInsight</code> attribute. 
	 * @return the enableSmartInsight
	 */
	public boolean isEnableSmartInsightAsPrimitive(final SessionContext ctx)
	{
		Boolean value = isEnableSmartInsight( ctx );
		return value != null ? value.booleanValue() : false;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSmartInsight.enableSmartInsight</code> attribute. 
	 * @return the enableSmartInsight
	 */
	public boolean isEnableSmartInsightAsPrimitive()
	{
		return isEnableSmartInsightAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSmartInsight.enableSmartInsight</code> attribute. 
	 * @param value the enableSmartInsight
	 */
	public void setEnableSmartInsight(final SessionContext ctx, final Boolean value)
	{
		setProperty(ctx, ENABLESMARTINSIGHT,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSmartInsight.enableSmartInsight</code> attribute. 
	 * @param value the enableSmartInsight
	 */
	public void setEnableSmartInsight(final Boolean value)
	{
		setEnableSmartInsight( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSmartInsight.enableSmartInsight</code> attribute. 
	 * @param value the enableSmartInsight
	 */
	public void setEnableSmartInsight(final SessionContext ctx, final boolean value)
	{
		setEnableSmartInsight( ctx,Boolean.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSmartInsight.enableSmartInsight</code> attribute. 
	 * @param value the enableSmartInsight
	 */
	public void setEnableSmartInsight(final boolean value)
	{
		setEnableSmartInsight( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSmartInsight.enableSmartInsightTimeframe</code> attribute.
	 * @return the enableSmartInsightTimeframe
	 */
	public Boolean isEnableSmartInsightTimeframe(final SessionContext ctx)
	{
		return (Boolean)getProperty( ctx, ENABLESMARTINSIGHTTIMEFRAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSmartInsight.enableSmartInsightTimeframe</code> attribute.
	 * @return the enableSmartInsightTimeframe
	 */
	public Boolean isEnableSmartInsightTimeframe()
	{
		return isEnableSmartInsightTimeframe( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSmartInsight.enableSmartInsightTimeframe</code> attribute. 
	 * @return the enableSmartInsightTimeframe
	 */
	public boolean isEnableSmartInsightTimeframeAsPrimitive(final SessionContext ctx)
	{
		Boolean value = isEnableSmartInsightTimeframe( ctx );
		return value != null ? value.booleanValue() : false;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSmartInsight.enableSmartInsightTimeframe</code> attribute. 
	 * @return the enableSmartInsightTimeframe
	 */
	public boolean isEnableSmartInsightTimeframeAsPrimitive()
	{
		return isEnableSmartInsightTimeframeAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSmartInsight.enableSmartInsightTimeframe</code> attribute. 
	 * @param value the enableSmartInsightTimeframe
	 */
	public void setEnableSmartInsightTimeframe(final SessionContext ctx, final Boolean value)
	{
		setProperty(ctx, ENABLESMARTINSIGHTTIMEFRAME,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSmartInsight.enableSmartInsightTimeframe</code> attribute. 
	 * @param value the enableSmartInsightTimeframe
	 */
	public void setEnableSmartInsightTimeframe(final Boolean value)
	{
		setEnableSmartInsightTimeframe( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSmartInsight.enableSmartInsightTimeframe</code> attribute. 
	 * @param value the enableSmartInsightTimeframe
	 */
	public void setEnableSmartInsightTimeframe(final SessionContext ctx, final boolean value)
	{
		setEnableSmartInsightTimeframe( ctx,Boolean.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSmartInsight.enableSmartInsightTimeframe</code> attribute. 
	 * @param value the enableSmartInsightTimeframe
	 */
	public void setEnableSmartInsightTimeframe(final boolean value)
	{
		setEnableSmartInsightTimeframe( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSmartInsight.endDate</code> attribute.
	 * @return the endDate
	 */
	public Date getEndDate(final SessionContext ctx)
	{
		return (Date)getProperty( ctx, ENDDATE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSmartInsight.endDate</code> attribute.
	 * @return the endDate
	 */
	public Date getEndDate()
	{
		return getEndDate( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSmartInsight.endDate</code> attribute. 
	 * @param value the endDate
	 */
	public void setEndDate(final SessionContext ctx, final Date value)
	{
		setProperty(ctx, ENDDATE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSmartInsight.endDate</code> attribute. 
	 * @param value the endDate
	 */
	public void setEndDate(final Date value)
	{
		setEndDate( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSmartInsight.sftpHost</code> attribute.
	 * @return the sftpHost - Emarsys SFTP Host
	 */
	public String getSftpHost(final SessionContext ctx)
	{
		return (String)getProperty( ctx, SFTPHOST);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSmartInsight.sftpHost</code> attribute.
	 * @return the sftpHost - Emarsys SFTP Host
	 */
	public String getSftpHost()
	{
		return getSftpHost( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSmartInsight.sftpHost</code> attribute. 
	 * @param value the sftpHost - Emarsys SFTP Host
	 */
	public void setSftpHost(final SessionContext ctx, final String value)
	{
		setProperty(ctx, SFTPHOST,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSmartInsight.sftpHost</code> attribute. 
	 * @param value the sftpHost - Emarsys SFTP Host
	 */
	public void setSftpHost(final String value)
	{
		setSftpHost( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSmartInsight.sftpPassword</code> attribute.
	 * @return the sftpPassword - Emarsys SFTP Password
	 */
	public String getSftpPassword(final SessionContext ctx)
	{
		return (String)getProperty( ctx, SFTPPASSWORD);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSmartInsight.sftpPassword</code> attribute.
	 * @return the sftpPassword - Emarsys SFTP Password
	 */
	public String getSftpPassword()
	{
		return getSftpPassword( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSmartInsight.sftpPassword</code> attribute. 
	 * @param value the sftpPassword - Emarsys SFTP Password
	 */
	public void setSftpPassword(final SessionContext ctx, final String value)
	{
		setProperty(ctx, SFTPPASSWORD,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSmartInsight.sftpPassword</code> attribute. 
	 * @param value the sftpPassword - Emarsys SFTP Password
	 */
	public void setSftpPassword(final String value)
	{
		setSftpPassword( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSmartInsight.sftpPath</code> attribute.
	 * @return the sftpPath - Emarsys SmartInsight csv file SFTP Path
	 */
	public String getSftpPath(final SessionContext ctx)
	{
		return (String)getProperty( ctx, SFTPPATH);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSmartInsight.sftpPath</code> attribute.
	 * @return the sftpPath - Emarsys SmartInsight csv file SFTP Path
	 */
	public String getSftpPath()
	{
		return getSftpPath( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSmartInsight.sftpPath</code> attribute. 
	 * @param value the sftpPath - Emarsys SmartInsight csv file SFTP Path
	 */
	public void setSftpPath(final SessionContext ctx, final String value)
	{
		setProperty(ctx, SFTPPATH,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSmartInsight.sftpPath</code> attribute. 
	 * @param value the sftpPath - Emarsys SmartInsight csv file SFTP Path
	 */
	public void setSftpPath(final String value)
	{
		setSftpPath( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSmartInsight.sftpUsername</code> attribute.
	 * @return the sftpUsername - Emarsys SFTP Username
	 */
	public String getSftpUsername(final SessionContext ctx)
	{
		return (String)getProperty( ctx, SFTPUSERNAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSmartInsight.sftpUsername</code> attribute.
	 * @return the sftpUsername - Emarsys SFTP Username
	 */
	public String getSftpUsername()
	{
		return getSftpUsername( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSmartInsight.sftpUsername</code> attribute. 
	 * @param value the sftpUsername - Emarsys SFTP Username
	 */
	public void setSftpUsername(final SessionContext ctx, final String value)
	{
		setProperty(ctx, SFTPUSERNAME,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSmartInsight.sftpUsername</code> attribute. 
	 * @param value the sftpUsername - Emarsys SFTP Username
	 */
	public void setSftpUsername(final String value)
	{
		setSftpUsername( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSmartInsight.startDate</code> attribute.
	 * @return the startDate
	 */
	public Date getStartDate(final SessionContext ctx)
	{
		return (Date)getProperty( ctx, STARTDATE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSmartInsight.startDate</code> attribute.
	 * @return the startDate
	 */
	public Date getStartDate()
	{
		return getStartDate( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSmartInsight.startDate</code> attribute. 
	 * @param value the startDate
	 */
	public void setStartDate(final SessionContext ctx, final Date value)
	{
		setProperty(ctx, STARTDATE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSmartInsight.startDate</code> attribute. 
	 * @param value the startDate
	 */
	public void setStartDate(final Date value)
	{
		setStartDate( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSmartInsight.uid</code> attribute.
	 * @return the uid
	 */
	public String getUid(final SessionContext ctx)
	{
		return (String)getProperty( ctx, UID);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmarsysSmartInsight.uid</code> attribute.
	 * @return the uid
	 */
	public String getUid()
	{
		return getUid( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSmartInsight.uid</code> attribute. 
	 * @param value the uid
	 */
	public void setUid(final SessionContext ctx, final String value)
	{
		setProperty(ctx, UID,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmarsysSmartInsight.uid</code> attribute. 
	 * @param value the uid
	 */
	public void setUid(final String value)
	{
		setUid( getSession().getSessionContext(), value );
	}
	
}

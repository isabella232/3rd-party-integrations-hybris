/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2015 hybris AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 *
 *
 */
package com.osfglobal.hybris.emarsys.setup;

import com.osfglobal.hybris.emarsys.constants.EmarsysConstants;
import de.hybris.platform.commerceservices.setup.AbstractSystemSetup;
import de.hybris.platform.core.initialization.SystemSetup;
import de.hybris.platform.core.initialization.SystemSetup.Process;
import de.hybris.platform.core.initialization.SystemSetup.Type;
import de.hybris.platform.core.initialization.SystemSetupContext;
import de.hybris.platform.core.initialization.SystemSetupParameter;
import de.hybris.platform.core.initialization.SystemSetupParameterMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * This class provides hooks into the system's initialization and update processes.
 *
 * @see "https://wiki.hybris.com/display/release4/Hooks+for+Initialization+and+Update+Process"
 */
@SystemSetup(extension = EmarsysConstants.EXTENSIONNAME)
public class EmarsysSystemSetup extends AbstractSystemSetup{

	private static final String IMPORT_ESSENTIAL_EMARSYS_DATA = "importEssentialEmarsysData";
	private static final String SYNC_CATALOGS = "syncCatalogs";

	/**
	 * This method will be called by system creator during initialization and system update. Be sure that this method can
	 * be called repeatedly.
	 *
	 * @param context
	 *           the context provides the selected parameters and values
	 */
	@SystemSetup(type = Type.ESSENTIAL, process = Process.UPDATE)
	public void createEssentialData(final SystemSetupContext context){
		final boolean importEmarsysImpex = getBooleanSystemSetupParameter(context, IMPORT_ESSENTIAL_EMARSYS_DATA);
		if(importEmarsysImpex){
			importImpexFile(context, "/" + EmarsysConstants.EXTENSIONNAME + "/import/essential-emarsys.impex", false);
		}
	}

	@SystemSetup(type = Type.ESSENTIAL, process = Process.UPDATE)
	public void syncCatalog(final SystemSetupContext context){
		final boolean syncCatalogs = getBooleanSystemSetupParameter(context, SYNC_CATALOGS);
		if(syncCatalogs) {
			getCatalogVersionService().getAllCatalogVersions().forEach(catalogVersionModel ->
					executeCatalogSyncJob(context, catalogVersionModel.getCatalog().getId()));
		}
	}



	/**
	 * Generates the Dropdown and Multi-select boxes for the project data import
	 */
	@Override
	@SystemSetupParameterMethod
	public List<SystemSetupParameter> getInitializationOptions()
	{
		final List<SystemSetupParameter> params = new ArrayList<SystemSetupParameter>();

		params.add(createBooleanSystemSetupParameter(IMPORT_ESSENTIAL_EMARSYS_DATA, "Import essential Emarsys data", true));
		params.add(createBooleanSystemSetupParameter(SYNC_CATALOGS, "Synchronize catalogs", true));

		return params;
	}
}

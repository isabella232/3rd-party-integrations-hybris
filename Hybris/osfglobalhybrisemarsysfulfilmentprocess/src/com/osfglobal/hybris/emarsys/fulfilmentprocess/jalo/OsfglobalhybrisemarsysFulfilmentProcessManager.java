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
package com.osfglobal.hybris.emarsys.fulfilmentprocess.jalo;

import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.extension.ExtensionManager;
import com.osfglobal.hybris.emarsys.fulfilmentprocess.constants.OsfglobalhybrisemarsysFulfilmentProcessConstants;

import org.apache.log4j.Logger;

@SuppressWarnings("PMD")
public class OsfglobalhybrisemarsysFulfilmentProcessManager extends GeneratedOsfglobalhybrisemarsysFulfilmentProcessManager
{
	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger( OsfglobalhybrisemarsysFulfilmentProcessManager.class.getName() );
	
	public static final OsfglobalhybrisemarsysFulfilmentProcessManager getInstance()
	{
		ExtensionManager em = JaloSession.getCurrentSession().getExtensionManager();
		return (OsfglobalhybrisemarsysFulfilmentProcessManager) em.getExtension(OsfglobalhybrisemarsysFulfilmentProcessConstants.EXTENSIONNAME);
	}
	
}

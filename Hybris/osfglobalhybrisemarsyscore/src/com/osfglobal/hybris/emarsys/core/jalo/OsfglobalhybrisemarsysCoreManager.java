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
package com.osfglobal.hybris.emarsys.core.jalo;

import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.extension.ExtensionManager;
import com.osfglobal.hybris.emarsys.core.constants.OsfglobalhybrisemarsysCoreConstants;
import com.osfglobal.hybris.emarsys.core.setup.CoreSystemSetup;


/**
 * Do not use, please use {@link CoreSystemSetup} instead.
 * 
 */
@SuppressWarnings("PMD")
public class OsfglobalhybrisemarsysCoreManager extends GeneratedOsfglobalhybrisemarsysCoreManager
{
	public static final OsfglobalhybrisemarsysCoreManager getInstance()
	{
		final ExtensionManager em = JaloSession.getCurrentSession().getExtensionManager();
		return (OsfglobalhybrisemarsysCoreManager) em.getExtension(OsfglobalhybrisemarsysCoreConstants.EXTENSIONNAME);
	}
}

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
package com.osfglobal.hybris.emarsys.controllers;

/**
 */
public interface OsfglobalhybrisemarsysControllerConstants
{
	// implement here controller constants used by this extension

	interface Views
	{
		interface Cms
		{
			String ComponentPrefix = "cms/";
		}

		interface Pages
		{
			interface Osfglobal
			{
				String prefix = "addon:/osfglobalhybrisemarsys/";

				String OsfglobalEmailSignUpPage = prefix + "pages/osfglobal/osfglobalEmailSignUpPage";
				String OsfglobalOptInThankYouPage = prefix + "pages/osfglobal/osfglobalOptInThankYouPage";
				String OsfglobalDoubleOptInThankYouPage = prefix + "pages/osfglobal/osfglobalDoubleOptInThankYouPage";
				String OsfglobalDoubleOptInDataSubmittedPage = prefix + "pages/osfglobal/osfglobalDoubleOptInDataSubmittedPage";
				String OsfglobalEmailAddressAlreadyRegisteredPage = prefix
						+ "pages/osfglobal/osfglobalEmailAddressAlreadyRegisteredPage";
				String OsfglobalEmailAddressAlreadyRegisteredThankYouPage = prefix
						+ "pages/osfglobal/osfglobalEmailAddressAlreadyRegisteredThankYouPage";
				String OsfglobalUnsubscribePage = prefix + "pages/osfglobal/osfglobalUnsubscribePage";
				String OsfglobalUnsubscribedPage = prefix + "pages/osfglobal/osfglobalUnsubscribedPage";
				String OsfglobalUnsubscribeErrorPage = prefix + "pages/osfglobal/osfglobalUnsubscribeErrorPage";
				String OsfglobalSubscribeErrorPage = prefix + "pages/osfglobal/osfglobalSubscribeErrorPage";
				String OsfglobalEmarsysScript = prefix + "pages/osfglobal/predict/emarsysscriptPage";
				String OsfglobalEmarsysAccountSubscriptionControlPage = prefix + "pages/osfglobal/account/emarsysAccountSubscriptionControlPage";

				String OsfglobalEmarsysNewsLetterForm = prefix + "pages/osfglobal/newsletter/emarsysNewsLetterPage";

				String OsfglobalEmarsysNewsLetterOptin = prefix
						+ "pages/osfglobal/newsletter/emarsysNewsLetterOptinPage";
				String OsfglobalEmarsysCheckoutNewsLetterForm = prefix
						+ "pages/osfglobal/checkout/emarsysCheckoutNewsLetterPage";
			}
		}
	}
}

package com.osfglobal.hybris.emarsys.controllers.pages;


import com.osfglobal.emarsys.client.Contact;
import com.osfglobal.emarsys.client.OptIn;
import com.osfglobal.hybris.emarsys.controllers.OsfglobalhybrisemarsysControllerConstants;
import com.osfglobal.hybris.emarsys.services.EmarsysService;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.commerceservices.strategies.CheckoutCustomerStrategy;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.site.BaseSiteService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;


/**
 * This controller is responsible for providing all back end data (user cart,..etc) to be used Emarys Javascript API.
 *
 * @author Imad Eddine BOUIHI
 *
 */
@Controller
@Scope("tenant")
@RequestMapping("/emarsysforms")
public class OsfglobalNewLettersController extends AbstractPageController
{
	protected static final Logger LOG = Logger.getLogger(OsfglobalNewLettersController.class);
	@Autowired
	private EmarsysService emarsysService;
	@Autowired
	private BaseSiteService baseSiteService;
	@Autowired
	private CheckoutCustomerStrategy checkoutCustomerStrategy;
	@RequestMapping(value = "/getnewlettersform", method = RequestMethod.GET)
	public String getNewslettersForm(final Model model, final HttpServletRequest request)
			throws CMSItemNotFoundException, UnsupportedEncodingException
	{

		return OsfglobalhybrisemarsysControllerConstants.Views.Pages.Osfglobal.OsfglobalEmarsysNewsLetterForm;
	}

	@RequestMapping(value = "/getnewlettersoptin", method = RequestMethod.GET)
	public String getNewslettersOptin(final Model model, final HttpServletRequest request)
			throws CMSItemNotFoundException, UnsupportedEncodingException {

		return OsfglobalhybrisemarsysControllerConstants.Views.Pages.Osfglobal.OsfglobalEmarsysNewsLetterOptin;
	}
	@RequestMapping(value = "/getaccountsubscriptioncontrolpage", method = RequestMethod.GET)
	public String getAccountSubscriptionButton(final Model model, final HttpServletRequest request)
			throws CMSItemNotFoundException, UnsupportedEncodingException {
		final List<Contact> contactsByEmail =
				emarsysService.getContactsByEmail(baseSiteService.getCurrentBaseSite(),	getUser().getUid());
		boolean isSubscribedUser = contactsByEmail.stream().anyMatch(contact -> contact.getOptIn() == OptIn.TRUE);
		model.addAttribute("isSubscribedUser", isSubscribedUser);
		return OsfglobalhybrisemarsysControllerConstants.Views.Pages.Osfglobal.OsfglobalEmarsysAccountSubscriptionControlPage;
	}


	@RequestMapping(value = "/getcheckoutnewsletterform", method = RequestMethod.GET)
	public String getCheckoutNewslettersForm(final Model model, final HttpServletRequest request)
			throws CMSItemNotFoundException, UnsupportedEncodingException {
		CustomerModel currentUser = checkoutCustomerStrategy.getCurrentUserForCheckout();
		model.addAttribute("userEmail", currentUser.getContactEmail());
		return OsfglobalhybrisemarsysControllerConstants.Views.Pages.Osfglobal.OsfglobalEmarsysCheckoutNewsLetterForm;
	}

}
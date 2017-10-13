package com.osfglobal.hybris.emarsys.controllers.pages;


import com.osfglobal.hybris.emarsys.controllers.OsfglobalhybrisemarsysControllerConstants;
import com.osfglobal.hybris.emarsys.facades.EmarsysSubscriptionFacade;
import com.osfglobal.hybris.emarsys.forms.OsfglobalEmailSignUpForm;
import com.osfglobal.hybris.emarsys.forms.OsfglobalQuickEmailSignUpForm;
import com.osfglobal.hybris.emarsys.services.*;
import com.osfglobal.hybris.emarsys.services.enums.EmarsysOptIn;
import com.osfglobal.hybris.emarsys.services.enums.EmarsysPage;
import com.osfglobal.hybris.emarsys.services.exceptions.EmarsysClientAlreadySubscribedException;
import com.osfglobal.hybris.emarsys.services.exceptions.EmarsysSubscriptionDoesntExistException;

import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.basecommerce.model.site.BaseSiteModel;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.cms2.model.pages.AbstractPageModel;
import de.hybris.platform.commercefacades.customer.CustomerFacade;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.site.BaseSiteService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;

@Controller
@Scope("tenant")
@RequestMapping("/emailsignup")
public class OsfglobalEmailSignUpController extends AbstractPageController
{

	public static final String USER_ANONYMOUS = "anonymous";
	public static final String DIRECT_YES = "y";

	@Autowired
	private EmarsysSubscriptionFacade emarsysSubscriptionFacade;

	@Autowired
	private EmarsysConfig emarsysConfig;

	@Resource(name = "emailSignUpValidator")
	private Validator emailSignUpValidator;

	@Resource(name = "quickEmailSignUpValidator")
	private Validator quickEmailSignUpValidator;

	@Resource(name = "customerFacade")
	private CustomerFacade customerFacade;

	@Resource(name = "baseSiteService")
	private BaseSiteService baseSiteService;

	@RequestMapping(method = RequestMethod.GET)
	public String osfglobalHome(final Model model) throws CMSItemNotFoundException
	{
		final String cmsPage = "osfGlobalSignup";
		storeCmsPageInModel(model, getContentPageForLabelOrId(cmsPage));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(cmsPage));
		updatePageTitle(model, getContentPageForLabelOrId(cmsPage));

		model.addAttribute("emailSignUpForm", new OsfglobalEmailSignUpForm());
		model.addAttribute("action", "emailsignup/subscribe");
		return OsfglobalhybrisemarsysControllerConstants.Views.Pages.Osfglobal.OsfglobalEmailSignUpPage;
	}

	@RequestMapping(value = "/subscribe-profile", method = RequestMethod.GET)
	public String subscribeFromProfile(final Model model) throws CMSItemNotFoundException
	{
		final String cmsPage = "osfGlobalSignup";
		storeCmsPageInModel(model, getContentPageForLabelOrId(cmsPage));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(cmsPage));
		updatePageTitle(model, getContentPageForLabelOrId(cmsPage));
		final CustomerData currentCustomer = customerFacade.getCurrentCustomer();
		if (currentCustomer == null || USER_ANONYMOUS.equals(currentCustomer.getUid()))
		{
			return REDIRECT_PREFIX + "/my-account";
		}

		final EmarsysPage page = EmarsysPage.MYACCOUNT;
		try
		{
			emarsysSubscriptionFacade.subcribeCustomer(currentCustomer, page);

		}
		catch (final EmarsysClientAlreadySubscribedException e)
		{
			return OsfglobalhybrisemarsysControllerConstants.Views.Pages.Osfglobal.OsfglobalEmailAddressAlreadyRegisteredThankYouPage;
		}
		final EmarsysOptIn optIn = emarsysConfig.getOptIn(getCurrentBaseSite(), page);
		if (optIn == EmarsysOptIn.SINGLE)
		{
			return OsfglobalhybrisemarsysControllerConstants.Views.Pages.Osfglobal.OsfglobalOptInThankYouPage;
		}
		return OsfglobalhybrisemarsysControllerConstants.Views.Pages.Osfglobal.OsfglobalDoubleOptInDataSubmittedPage;
	}



	@RequestMapping(method = RequestMethod.POST, value = "/subscribe")
	public String osfglobalSubscribe(final OsfglobalEmailSignUpForm form, final BindingResult bindingResult, final Model model,
			final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{
		emailSignUpValidator.validate(form, bindingResult);
		if (bindingResult.hasErrors())
		{
			final String page = osfglobalHome(model);
			model.addAttribute("emailSignUpForm", form);
			for (final ObjectError error : bindingResult.getAllErrors())
			{
				GlobalMessages.addErrorMessage(model, error.getCode());
			}
			return page;
		}

		final String cmsPage = "osfGlobalSignup";
		storeCmsPageInModel(model, getContentPageForLabelOrId(cmsPage));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(cmsPage));
		updatePageTitle(model, getContentPageForLabelOrId(cmsPage));
		try
		{
			emarsysSubscriptionFacade.anonymousSubscribe(EmarsysPage.FOOTER, form.getFirstName(), form.getLastName(),
					form.getEmail(), form.getGender());
		}
		catch (final EmarsysClientAlreadySubscribedException e)
		{
			return OsfglobalhybrisemarsysControllerConstants.Views.Pages.Osfglobal.OsfglobalEmailAddressAlreadyRegisteredThankYouPage;
		}

		final EmarsysOptIn optIn = emarsysConfig.getOptIn(getCurrentBaseSite(), EmarsysPage.FOOTER);
		if (optIn == EmarsysOptIn.SINGLE)
		{
			return OsfglobalhybrisemarsysControllerConstants.Views.Pages.Osfglobal.OsfglobalOptInThankYouPage;
		}

		return OsfglobalhybrisemarsysControllerConstants.Views.Pages.Osfglobal.OsfglobalDoubleOptInDataSubmittedPage;
	}


	@RequestMapping(method = RequestMethod.POST, value = "/quicksubscribe")
	public String osfglobalSubscribe(final OsfglobalQuickEmailSignUpForm form, final BindingResult bindingResult,
			final Model model, final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{
		quickEmailSignUpValidator.validate(form, bindingResult);
		final String email = form.getEmail();
		if (bindingResult.hasErrors())
		{
			final String page = osfglobalHome(model);
			final OsfglobalEmailSignUpForm emailSignUpForm = new OsfglobalEmailSignUpForm();
			emailSignUpForm.setEmail(email);
			model.addAttribute("emailSignUpForm", emailSignUpForm);
			for (final ObjectError error : bindingResult.getAllErrors())
			{
				GlobalMessages.addErrorMessage(model, error.getCode());
			}
			return page;
		}

		final String cmsPage = "osfGlobalSignup";
		storeCmsPageInModel(model, getContentPageForLabelOrId(cmsPage));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(cmsPage));
		updatePageTitle(model, getContentPageForLabelOrId(cmsPage));
		try
		{
			emarsysSubscriptionFacade.quickSubscribe(email, EmarsysPage.FOOTER);
		}
		catch (final EmarsysClientAlreadySubscribedException e)
		{
			LOG.error("Email alreay exists", e);
			return OsfglobalhybrisemarsysControllerConstants.Views.Pages.Osfglobal.OsfglobalEmailAddressAlreadyRegisteredThankYouPage;
		}
		final EmarsysOptIn optIn = emarsysConfig.getOptIn(getCurrentBaseSite(), EmarsysPage.FOOTER);
		if (optIn == EmarsysOptIn.SINGLE)
		{
			return OsfglobalhybrisemarsysControllerConstants.Views.Pages.Osfglobal.OsfglobalOptInThankYouPage;
		}
		return OsfglobalhybrisemarsysControllerConstants.Views.Pages.Osfglobal.OsfglobalDoubleOptInDataSubmittedPage;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{page}/confirm/{subscriptionToken}")
	public String osfglobalConfirmDoubleOptInSubscription(@PathVariable final String page,
			@PathVariable final String subscriptionToken, final Model model) throws CMSItemNotFoundException
	{
		final String cmsPage = "osfGlobalSignup";
		storeCmsPageInModel(model, getContentPageForLabelOrId(cmsPage));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(cmsPage));
		updatePageTitle(model, getContentPageForLabelOrId(cmsPage));
		if (StringUtils.isEmpty(page))
		{
			return OsfglobalhybrisemarsysControllerConstants.Views.Pages.Osfglobal.OsfglobalSubscribeErrorPage;
		}
		try
		{
			final EmarsysPage emarsysPage = EmarsysPage.valueOf(page.toUpperCase());
			emarsysSubscriptionFacade.confirmDoubleOptInSubscription(getCurrentBaseSite(), subscriptionToken, emarsysPage);
		}
		catch (final EmarsysSubscriptionDoesntExistException e)
		{
			return OsfglobalhybrisemarsysControllerConstants.Views.Pages.Osfglobal.OsfglobalSubscribeErrorPage;
		}
		catch (final EmarsysClientAlreadySubscribedException e)
		{
			return OsfglobalhybrisemarsysControllerConstants.Views.Pages.Osfglobal.OsfglobalEmailAddressAlreadyRegisteredThankYouPage;
		}
		return OsfglobalhybrisemarsysControllerConstants.Views.Pages.Osfglobal.OsfglobalDoubleOptInThankYouPage;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/unsubscribe-profile")
	public String osfglobalUnsubscribe(final Model model) throws CMSItemNotFoundException
	{
		final String cmsPage = "osfGlobalSignup";
		storeCmsPageInModel(model, getContentPageForLabelOrId(cmsPage));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(cmsPage));
		updatePageTitle(model, getContentPageForLabelOrId(cmsPage));

		final CustomerData currentUser = getUser();
		if (currentUser == null)
		{
			return REDIRECT_PREFIX + "/my-account";
		}

		if (!emarsysSubscriptionFacade.unsubscribeCustomer(currentUser))
		{
			return OsfglobalhybrisemarsysControllerConstants.Views.Pages.Osfglobal.OsfglobalUnsubscribeErrorPage;
		} else
		{
			return OsfglobalhybrisemarsysControllerConstants.Views.Pages.Osfglobal.OsfglobalUnsubscribedPage;
		}
	}



	@RequestMapping(method = RequestMethod.GET, value = "/unsubscribe")
	public String osfglobalUnsubscribe(@RequestParam(value = "uid") final String uid,
			@RequestParam(value = "llid", required = false) final String llid,
			@RequestParam(value = "cid", required = false) final String cid,
			@RequestParam(value = "direct", required = false) final String direct, final Model model)
			throws CMSItemNotFoundException
	{
		final String cmsPage = "osfGlobalSignup";
		storeCmsPageInModel(model, getContentPageForLabelOrId(cmsPage));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(cmsPage));
		updatePageTitle(model, getContentPageForLabelOrId(cmsPage));

		if (DIRECT_YES.equalsIgnoreCase(direct))
		{
			return unsubscribe(uid, llid, cid);
		}
		return OsfglobalhybrisemarsysControllerConstants.Views.Pages.Osfglobal.OsfglobalUnsubscribePage;
	}

	/**
	 * @param uid
	 * @param llid
	 * @param cid
	 * @return
	 */
	private String unsubscribe(final String uid, final String llid, final String cid)
	{
		try
		{
			emarsysSubscriptionFacade.unsubscribe(getCurrentBaseSite(), uid, llid, cid);
		}
		catch (final EmarsysSubscriptionDoesntExistException e)
		{
			return OsfglobalhybrisemarsysControllerConstants.Views.Pages.Osfglobal.OsfglobalUnsubscribeErrorPage;
		}
		return OsfglobalhybrisemarsysControllerConstants.Views.Pages.Osfglobal.OsfglobalUnsubscribedPage;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/unsubscribe")
	public String osfglobalUnsubscribed(@RequestParam(value = "uid") final String uid,
			@RequestParam(value = "llid", required = false) final String llid,
			@RequestParam(value = "cid", required = false) final String cid, final Model model) throws CMSItemNotFoundException
	{
		final String cmsPage = "osfGlobalSignup";
		storeCmsPageInModel(model, getContentPageForLabelOrId(cmsPage));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(cmsPage));
		updatePageTitle(model, getContentPageForLabelOrId(cmsPage));
		return unsubscribe(uid, llid, cid);
	}

	protected void updatePageTitle(final Model model, final AbstractPageModel cmsPage)
	{
		storeContentPageTitleInModel(model, getPageTitleResolver().resolveHomePageTitle(cmsPage.getTitle()));
	}

	private BaseSiteModel getCurrentBaseSite()
	{
		return baseSiteService.getCurrentBaseSite();
	}

}
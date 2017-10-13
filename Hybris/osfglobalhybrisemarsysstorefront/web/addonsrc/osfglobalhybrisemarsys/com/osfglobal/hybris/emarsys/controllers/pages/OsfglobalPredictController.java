package com.osfglobal.hybris.emarsys.controllers.pages;


import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.osfglobal.hybris.emarsys.controllers.OsfglobalhybrisemarsysControllerConstants;
import com.osfglobal.hybris.emarsys.facades.EmarsysPredictFacade;


/**
 * This controller is responsible for providing all back end data (user cart,..etc) to be used Emarys Javascript API.
 *
 * @author Imad Eddine BOUIHI
 *
 */
@Controller
@Scope("tenant")
@RequestMapping("/emarsyspredict")
public class OsfglobalPredictController extends AbstractPageController
{

	private static final String ORIGINAL_REFERER = "originalReferer";



	protected static final Logger LOG = Logger.getLogger(OsfglobalPredictController.class);



	@Resource(name = "emarsysPredictFacade")
	private EmarsysPredictFacade emarsysPredictFacade;


	@RequestMapping(value = "/getemarsysscript.js", method = RequestMethod.GET)

	public String get(final Model model, final HttpServletRequest request) throws CMSItemNotFoundException, UnsupportedEncodingException
	{

		model.addAttribute("predictWidgetData", emarsysPredictFacade.getPredictWidget(getRelativeReferUrl(request)));
		request.getSession().setAttribute(ORIGINAL_REFERER,request.getHeader("referer"));
		return OsfglobalhybrisemarsysControllerConstants.Views.Pages.Osfglobal.OsfglobalEmarsysScript;
	}



	/**
	 * @return merchant id for the current site
	 * @throws UnsupportedEncodingException 
	 */
	private String getRelativeReferUrl(final HttpServletRequest request) throws UnsupportedEncodingException
	{
		String refererUrl=   java.net.URLDecoder.decode(request.getHeader("referer"), "UTF-8");
		String anbsoluteContext = request.getRequestURL().toString().replace(request.getRequestURI(),"" );
		return refererUrl.replace(anbsoluteContext, "");

	}

	/**
	 * @return merchant id for the current site
	 */


}
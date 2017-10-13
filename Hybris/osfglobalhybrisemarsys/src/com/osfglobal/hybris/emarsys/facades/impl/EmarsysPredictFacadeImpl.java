/**
 *
 */
package com.osfglobal.hybris.emarsys.facades.impl;

import de.hybris.platform.basecommerce.model.site.BaseSiteModel;
import de.hybris.platform.commercefacades.order.CartFacade;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.platform.site.BaseSiteService;

import java.util.List;

import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Required;

import com.osfglobal.hybris.emarsys.data.CommandData;
import com.osfglobal.hybris.emarsys.data.PredictWidgetData;
import com.osfglobal.hybris.emarsys.facades.EmarsysPredictFacade;
import com.osfglobal.hybris.emarsys.recommendations.commands.AbstractCommandProvider;
import com.osfglobal.hybris.emarsys.services.EmarsysPredictService;


/**
 * Predict Facade
 *
 * @author Imad Eddine BOUIHI
 *
 */


public class EmarsysPredictFacadeImpl implements EmarsysPredictFacade
{

	private CartFacade cartFacade;
	private BaseSiteService baseSiteService;

	private UserService userService;
	private EmarsysPredictService emarsysPredictService;

	private List<AbstractCommandProvider> commandProviders;

	@Override
	public PredictWidgetData getPredictWidget(final String uri)
	{
		final PredictWidgetData predictWidgetData = new PredictWidgetData();

		if (isTrackingEnabled())
		{
			predictWidgetData.setMerchantId(getMerchantId());
			predictWidgetData.setEmail(emarsysPredictService.getEmailForPredictWidget());
			predictWidgetData.setCart(cartFacade.getSessionCart());
			predictWidgetData.setCodeTrackingEnabled(Boolean.TRUE);
			predictWidgetData.setCommand(getCommand(uri));
		}

		return predictWidgetData;
	}

	/**
	 * @return isTrackingEnabled of site
	 */
	private boolean isTrackingEnabled()
	{
		if (getBaseSiteService().getCurrentBaseSite().getEmarsysPredict() != null
				&& BooleanUtils.isTrue(getBaseSiteService().getCurrentBaseSite().getEmarsysPredict().getEnableTrackingCode()))
		{
			return true;
		}
		return false;
	}

	/**
	 * @param uri
	 * @return command for the current URI
	 */
	public CommandData getCommand(final String uri)
	{
		for (final AbstractCommandProvider commandProvider : commandProviders)
		{
			if (StringUtils.isNotEmpty(commandProvider.getMatchinPattern(uri)))
			{
				final CommandData commandData = commandProvider.getCommand(uri);
				return commandData;
			}

		}
		return null;
	}

	private String getMerchantId()
	{
		return getCurrentBaseSite().getEmarsysPredict().getMerchantId();
	}


	private BaseSiteModel getCurrentBaseSite()
	{
		return baseSiteService.getCurrentBaseSite();
	}

	/**
	 * @return the cartFacade
	 */
	public CartFacade getCartFacade()
	{
		return cartFacade;
	}

	/**
	 * @param cartFacade
	 *           the cartFacade to set
	 */
	@Required
	public void setCartFacade(final CartFacade cartFacade)
	{
		this.cartFacade = cartFacade;
	}

	/**
	 * @return the baseSiteService
	 */
	public BaseSiteService getBaseSiteService()
	{
		return baseSiteService;
	}

	/**
	 * @param baseSiteService
	 *           the baseSiteService to set
	 */
	@Required
	public void setBaseSiteService(final BaseSiteService baseSiteService)
	{
		this.baseSiteService = baseSiteService;
	}

	/**
	 * @return the userService
	 */
	public UserService getUserService()
	{
		return userService;
	}

	/**
	 * @param userService
	 *           the userService to set
	 */
	@Required
	public void setUserService(final UserService userService)
	{
		this.userService = userService;
	}

	/**
	 * @return the commandProviders
	 */
	public List<AbstractCommandProvider> getCommandProviders()
	{
		return commandProviders;
	}

	/**
	 * @param commandProviders
	 *           the commandProviders to set
	 */
	public void setCommandProviders(final List<AbstractCommandProvider> commandProviders)
	{
		this.commandProviders = commandProviders;
	}

	/**
	 * @param emarsysPredictService
	 *            the emarsysPredictService to set
	 */
	@Required
	public void setEmarsysPredictService(EmarsysPredictService emarsysPredictService)
	{
		this.emarsysPredictService = emarsysPredictService;
	}

}

package com.osfglobal.hybris.emarsys.recommendations.commands.impl;

import de.hybris.platform.basecommerce.model.site.BaseSiteModel;
import de.hybris.platform.commercefacades.order.OrderFacade;
import de.hybris.platform.commercefacades.order.data.OrderData;
import de.hybris.platform.commercefacades.order.data.OrderEntryData;

import java.util.Iterator;

/*
 *
 * Creation: 5 oct. 2016 by 5 oct. 2016 by Imad Eddine BOUIHI
 *
 */

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.osfglobal.hybris.emarsys.data.CommandData;
import com.osfglobal.hybris.emarsys.enums.EmarsysWidgetTypeEnum;
import com.osfglobal.hybris.emarsys.recommendations.commands.AbstractCommandProvider;


public class PurchaseCommandProvider extends AbstractCommandProvider
{

	private OrderFacade orderFacade;

	@Override
	public String getParameterString(final String uri)
	{
		final String pattern = getMatchinPattern(uri);
		if (StringUtils.isNotEmpty(uri))
		{
			final Map<String, String> mapping = getPathMatcher().extractUriTemplateVariables(pattern, uri);

			final String orderCode = mapping.get(getHeroParameter());
			final OrderData orderDetails = orderFacade.getOrderDetailsForCode(orderCode);

			final StringBuilder json = new StringBuilder();
			json.append("{orderId: '").append(orderCode).append("',items: [");

			final Iterator<OrderEntryData> iterator = orderDetails.getEntries().iterator();
			for (;;)
			{
				final OrderEntryData orderEntryData = iterator.next();
				fillJson(json, orderEntryData);
				if (iterator.hasNext())
				{
					json.append(",");
				}
				else
				{
					json.append("]}");
					return json.toString();
				}
			}

		}
		return null;


	}

	/**
	 * @param json
	 * @param orderEntryData
	 */
	private void fillJson(final StringBuilder json, final OrderEntryData orderEntryData)
	{
		json.append("{item: '").append(orderEntryData.getProduct().getCode()).append("', price:")
				.append(orderEntryData.getRoundedBasePrice()).append(", quantity:").append(orderEntryData.getQuantity())
				.append("}");
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.osfglobal.hybris.emarsys.recommendations.commands.AbstractCommandProvider#getLogic()
	 */
	@Override
	public String getLogic()
	{
		final BaseSiteModel baseSite = getBaseSiteService().getCurrentBaseSite();
		if (baseSite.getEmarsysPredict() != null
				&& !EmarsysWidgetTypeEnum.DISABLED.equals(baseSite.getEmarsysPredict().getOrderPageRecomType()))
		{
			return baseSite.getEmarsysPredict().getOrderPageRecomType().getCode();
		}
		return null;
	}
	@Override
	public void setExtraParameters(CommandData command) {
		//no extra command paramater
		
	}

	/**
	 * @return the orderFacade
	 */
	public OrderFacade getOrderFacade()
	{
		return orderFacade;
	}

	/**
	 * @param orderFacade
	 *           the orderFacade to set
	 */
	public void setOrderFacade(final OrderFacade orderFacade)
	{
		this.orderFacade = orderFacade;
	}





}

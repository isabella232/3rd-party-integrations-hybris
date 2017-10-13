package com.osfglobal.hybris.emarsys.recommendations.commands.impl;

import de.hybris.platform.basecommerce.model.site.BaseSiteModel;

/*

 * Creation: 5 oct. 2016 by Imad Eddine BOUIHI
 *
 */

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.osfglobal.hybris.emarsys.data.CommandData;
import com.osfglobal.hybris.emarsys.enums.EmarsysWidgetTypeEnum;
import com.osfglobal.hybris.emarsys.recommendations.commands.AbstractCommandProvider;


public class HomeCommandProvider extends AbstractCommandProvider
{


	@Override
	public String getParameterString(final String uri)
	{
		final String pattern = getMatchinPattern(uri);
		if (StringUtils.isNotEmpty(uri))
		{
			final Map<String, String> mapping = getPathMatcher().extractUriTemplateVariables(pattern, uri);
			//In product page case just return the product code;
			return mapping.get(getHeroParameter());
		}
		return null;


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
				&& !EmarsysWidgetTypeEnum.DISABLED.equals(baseSite.getEmarsysPredict().getHomePageRecomType()))
		{
			return baseSite.getEmarsysPredict().getHomePageRecomType().getCode();
		}
		return null;
	}
	@Override
	public void setExtraParameters(CommandData command) {
		//no extra command paramater
		
	}
}

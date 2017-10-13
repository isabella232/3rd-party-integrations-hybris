package com.osfglobal.hybris.emarsys.recommendations.commands.impl;

import de.hybris.platform.basecommerce.model.site.BaseSiteModel;
import de.hybris.platform.servicelayer.i18n.CommonI18NService;
import de.hybris.platform.servicelayer.i18n.I18NService;

/*

 * Creation: 5 oct. 2016 by Imad Eddine BOUIHI
 *
 */

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.osfglobal.hybris.emarsys.core.jalo.EmarsysPredictAvailabilityZone;
import com.osfglobal.hybris.emarsys.core.model.EmarsysPredictAvailabilityZoneModel;
import com.osfglobal.hybris.emarsys.data.CommandData;
import com.osfglobal.hybris.emarsys.enums.EmarsysWidgetTypeEnum;
import com.osfglobal.hybris.emarsys.recommendations.commands.AbstractCommandProvider;
import com.osfglobal.hybris.emarsys.services.EmarsysPredictService;

public class ViewCommandProvider extends AbstractCommandProvider {
	CommonI18NService commonI18NService;
	EmarsysPredictService emarsysPredictService;

	@Override
	public String getParameterString(final String uri) {
		final String pattern = getMatchinPattern(uri);
		if (StringUtils.isNotEmpty(uri)) {
			final Map<String, String> mapping = getPathMatcher().extractUriTemplateVariables(pattern, uri);
			// In product page case just return the product code;
			return "'" + mapping.get(getHeroParameter()) + "'";
		}
		return null;

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.osfglobal.hybris.emarsys.recommendations.commands.AbstractCommandProvider#getLogic()
	 */
	@Override
	public String getLogic() {
		final BaseSiteModel baseSite = getBaseSiteService().getCurrentBaseSite();
		if (baseSite.getEmarsysPredict() != null
				&& !EmarsysWidgetTypeEnum.DISABLED.equals(baseSite.getEmarsysPredict().getProductPageRecomType())) {
			return baseSite.getEmarsysPredict().getProductPageRecomType().getCode();
		}
		return null;
	}

	@Override
	public void setExtraParameters(CommandData command) {
		
		EmarsysPredictAvailabilityZoneModel availabilityZone = emarsysPredictService
				.getAvailabilityZone(commonI18NService.getCurrentLanguage(), commonI18NService.getCurrentCurrency());
		if(availabilityZone!=null)
		{
			 command.setAvailabilityZone(availabilityZone.getName());
		}

	}

	/**
	 * @return the commonI18NService
	 */
	public CommonI18NService getCommonI18NService() {
		return commonI18NService;
	}

	/**
	 * @param commonI18NService the commonI18NService to set
	 */
	public void setCommonI18NService(CommonI18NService commonI18NService) {
		this.commonI18NService = commonI18NService;
	}

	/**
	 * @return the emarsysPredictService
	 */
	public EmarsysPredictService getEmarsysPredictService() {
		return emarsysPredictService;
	}

	/**
	 * @param emarsysPredictService
	 *            the emarsysPredictService to set
	 */
	public void setEmarsysPredictService(EmarsysPredictService emarsysPredictService) {
		this.emarsysPredictService = emarsysPredictService;
	}
	
	

}

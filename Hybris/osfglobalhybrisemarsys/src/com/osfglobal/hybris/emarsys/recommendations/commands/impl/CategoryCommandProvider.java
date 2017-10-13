package com.osfglobal.hybris.emarsys.recommendations.commands.impl;

import de.hybris.platform.basecommerce.model.site.BaseSiteModel;
import de.hybris.platform.category.CategoryService;
import de.hybris.platform.category.model.CategoryModel;
import de.hybris.platform.commerceservices.url.impl.AbstractUrlResolver;

/*

 * Creation: 5 oct. 2016 by Imad Eddine BOUIHI
 *
 */

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.osfglobal.hybris.emarsys.data.CommandData;
import com.osfglobal.hybris.emarsys.enums.EmarsysWidgetTypeEnum;
import com.osfglobal.hybris.emarsys.recommendations.commands.AbstractCommandProvider;


public class CategoryCommandProvider extends AbstractCommandProvider
{

	private AbstractUrlResolver emarsysCategoryResolver;
	private CategoryService categoryService;


	@Override
	public String getParameterString(final String uri)
	{
		final String pattern = getMatchinPattern(uri);
		if (StringUtils.isNotEmpty(uri))
		{
			final Map<String, String> mapping = getPathMatcher().extractUriTemplateVariables(pattern, uri);
			//In product page case just return the product code;
			final String categoryCode = mapping.get(getHeroParameter());
			final CategoryModel category = categoryService.getCategoryForCode(categoryCode);
			final String categoryPath = emarsysCategoryResolver.resolve(category);
			return "'" + categoryPath + "'";
		}
		return null;


	}

	/**
	 * @return the emarsysCategoryResolver
	 */
	public AbstractUrlResolver getEmarsysCategoryResolver()
	{
		return emarsysCategoryResolver;
	}

	/**
	 * @param emarsysCategoryResolver
	 *           the emarsysCategoryResolver to set
	 */
	public void setEmarsysCategoryResolver(final AbstractUrlResolver emarsysCategoryResolver)
	{
		this.emarsysCategoryResolver = emarsysCategoryResolver;
	}

	/**
	 * @return the categoryService
	 */
	public CategoryService getCategoryService()
	{
		return categoryService;
	}

	/**
	 * @param categoryService
	 *           the categoryService to set
	 */
	public void setCategoryService(final CategoryService categoryService)
	{
		this.categoryService = categoryService;
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
				&& !EmarsysWidgetTypeEnum.DISABLED.equals(baseSite.getEmarsysPredict().getCategoryPageRecomType()))
		{
			return baseSite.getEmarsysPredict().getCategoryPageRecomType().getCode();
		}
		return null;
	}
	@Override
	public void setExtraParameters(CommandData command) {
		//no extra command paramater
		
	}



}

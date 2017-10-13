package com.osfglobal.hybris.emarsys.resolvers;

import de.hybris.platform.category.model.CategoryModel;
import de.hybris.platform.commerceservices.url.impl.DefaultCategoryModelUrlResolver;

import java.util.List;


/**
 * Emarsys category resolver
 */
public class EmarsysCategoryResolver extends DefaultCategoryModelUrlResolver
{

	@Override
	protected String buildPathString(final List<CategoryModel> path)
	{
		final StringBuilder result = new StringBuilder();

		for (int i = 0; i < path.size(); i++)
		{
			if (i != 0)
			{
				result.append(" > ");
			}
			result.append(urlSafe(path.get(i).getName()));
		}

		return result.toString();
	}
	@Override
	protected String urlSafe(final String text)
	{
		// No encoding for Emarsys
		return text;
	}

}

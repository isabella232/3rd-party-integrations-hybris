package com.osfglobal.hybris.emarsys.converters.mappings;

import com.google.common.collect.Multimap;
import de.hybris.platform.basecommerce.model.site.BaseSiteModel;

public interface EmarsysMappingsConverter {
    Multimap<String, String> convert(BaseSiteModel site);
}

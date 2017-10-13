package com.osfglobal.hybris.emarsys.converters.mappings;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import de.hybris.platform.basecommerce.model.site.BaseSiteModel;

public class EmarsysOrderConfirmationMappingsConverter implements EmarsysMappingsConverter {
    @Override
    public Multimap<String, String> convert(BaseSiteModel site) {
        Multimap<String, String> resultMap = ArrayListMultimap.create();
        site.getEmarsysOrderEmail().getMapping()
                .forEach((key, value) -> resultMap.put(key.toString(), value.toString()));
        return resultMap;
    }
}

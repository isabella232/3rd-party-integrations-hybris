package com.osfglobal.hybris.emarsys.converters.mappings;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import de.hybris.platform.basecommerce.model.site.BaseSiteModel;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class EmarsysPredictMappingsConverter implements EmarsysMappingsConverter {
    @Override
    public Multimap<String, String> convert(BaseSiteModel site) {
        Multimap<String, String> resultMap = ArrayListMultimap.create();
        site.getEmarsysPredict().getEmarsysPredictMappings().forEach(entry ->
                resultMap.put(entry.getHybrisField().toString(), entry.getEmarsysPlaceholder()));
        return resultMap;
    }
}

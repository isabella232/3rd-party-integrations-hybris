package com.osfglobal.hybris.emarsys.resolvers;

import com.osfglobal.hybris.emarsys.core.model.EmarsysPredictAvailabilityZoneModel;
import com.osfglobal.hybris.emarsys.utils.EmarsysObjectUtils;
import com.osfglobal.hybris.emarsys.utils.EmarsysStringUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;


public class EmarsysPredictSmartInsightResolver extends EmarsysBaseResolver {
    public static final Logger LOGGER = LoggerFactory.getLogger(EmarsysPredictSmartInsightResolver.class);
    private static final String SUFFIX_PATTERN = "^(c_)?\\w+_([a-z]+)$";


    public String resolve(String key,String placeholder, Object model) {
        EmarsysResolver resolver = findResolver(key, resolvers);
        if(resolver != null) {
            Object resolverModel = getResolverModelInstance(key, model);
            String suffix = EmarsysStringUtils.getSubstringByRegex(placeholder, SUFFIX_PATTERN, 2);
            EmarsysPredictAvailabilityZoneModel availabilityZone = getEmarsysPredictAvailabilityZone(suffix);
            if (availabilityZone != null) {
                LOGGER.debug("Availability zone: {}", availabilityZone.getName());
                return resolver.resolve(resolverModel, availabilityZone);
            }
            return resolver.resolve(resolverModel);
        }else {
            String subPath = StringUtils.substringAfter(key, PATH_SEPARATOR);
            Object value = EmarsysObjectUtils.getNestedProperty(model, subPath);
            return emarsysFormatterUtils.objectToString(value);
        }
    }

    private EmarsysPredictAvailabilityZoneModel getEmarsysPredictAvailabilityZone(String availabilityZone) {
        return baseSiteService
                .getCurrentBaseSite()
                .getEmarsysPredict()
                .getEmarsysPredictAvailabilityZones()
                .stream()
                .filter(zone -> Objects.equals(zone.getName(), availabilityZone))
                .findFirst()
                .orElse(null);
    }
}

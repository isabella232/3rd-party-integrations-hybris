package com.osfglobal.hybris.emarsys.resolvers;

import com.osfglobal.hybris.emarsys.core.model.EmarsysPredictAvailabilityZoneModel;
import com.osfglobal.hybris.emarsys.utils.EmarsysFormatterUtils;
import com.osfglobal.hybris.emarsys.utils.EmarsysObjectUtils;
import com.osfglobal.hybris.emarsys.utils.EmarsysStringUtils;
import de.hybris.platform.site.BaseSiteService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Required;

import java.util.Map;
import java.util.Objects;


public class EmarsysBaseResolver implements EmarsysResolver {
    public static final Logger LOGGER = LoggerFactory.getLogger(EmarsysBaseResolver.class);
    protected static final String PATH_SEPARATOR = ".";
    protected Map<String, EmarsysResolver> resolvers;
    protected EmarsysFormatterUtils emarsysFormatterUtils;
    protected BaseSiteService baseSiteService;

    protected Object getResolverModelInstance(String key, Object model) {
        if(StringUtils.countMatches(key, PATH_SEPARATOR) < 2){
            return model;
        }
        String modelPath = getResolverModelPath(key);
        return EmarsysObjectUtils.getNestedProperty(model, modelPath);
    }

    protected String getResolverModelPath(String key) {
        String after = StringUtils.substringAfter(key, PATH_SEPARATOR);
        return StringUtils.substringBeforeLast(after, PATH_SEPARATOR);
    }


    protected EmarsysResolver findResolver(String path, Map<String, EmarsysResolver> resolvers) {
        String[] pathArray = path.split("\\.");
        EmarsysResolver resolver = null;
        int index = 0;
        while (index < pathArray.length) {
            resolver = resolvers.get(pathArray[index]);
            if (resolver == null) {
                if (index != pathArray.length - 1) {
                    return null;
                }
            } else {
                resolvers = resolver.getResolvers();
            }
            index++;
        }
        return resolver;
    }
    @Required
    public void setEmarsysFormatterUtils(EmarsysFormatterUtils emarsysFormatterUtils) {
        this.emarsysFormatterUtils = emarsysFormatterUtils;
    }

    @Required
    public void setBaseSiteService(BaseSiteService baseSiteService) {
        this.baseSiteService = baseSiteService;
    }

    @Required
    public void setResolvers(Map<String, EmarsysResolver> resolvers) {
        this.resolvers = resolvers;
    }

    @Override
    public String resolve(Object model, EmarsysPredictAvailabilityZoneModel availabilityZone) {
        return null;
    }

    @Override
    public String resolve(Object model) {
        return null;
    }

    @Override
    public Map<String, EmarsysResolver> getResolvers() {
        return resolvers;
    }

}

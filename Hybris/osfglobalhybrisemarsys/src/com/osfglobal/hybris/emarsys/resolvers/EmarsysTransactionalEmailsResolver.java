package com.osfglobal.hybris.emarsys.resolvers;

import com.osfglobal.hybris.emarsys.utils.EmarsysObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class EmarsysTransactionalEmailsResolver extends EmarsysBaseResolver {
    public static final Logger LOGGER = LoggerFactory.getLogger(EmarsysTransactionalEmailsResolver.class);

    public String resolve(String key,Object model) {
        EmarsysResolver resolver = findResolver(key, resolvers);
        if(resolver != null) {
            Object resolverModel = getResolverModelInstance(key, model);
            return resolver.resolve(resolverModel);
        }else {
            String subPath = StringUtils.substringAfter(key, PATH_SEPARATOR);
            Object value = EmarsysObjectUtils.getNestedProperty(model, subPath);
            return emarsysFormatterUtils.objectToString(value);
        }
    }
}

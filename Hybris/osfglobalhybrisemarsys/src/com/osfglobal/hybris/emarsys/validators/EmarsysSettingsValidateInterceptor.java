package com.osfglobal.hybris.emarsys.validators;

import com.osfglobal.hybris.emarsys.core.model.EmarsysSettingsModel;
import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.interceptor.ValidateInterceptor;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Required;

/**
 * Emarsys Settings validator
 */
public class EmarsysSettingsValidateInterceptor implements ValidateInterceptor<EmarsysSettingsModel> {
    private Logger LOGGER = LoggerFactory.getLogger(EmarsysSettingsValidateInterceptor.class);
    private String requiredString;

    @Override
    public void onValidate(EmarsysSettingsModel emarsysSettingsModel, InterceptorContext interceptorContext) throws InterceptorException {
        String emarsysApiUsername = emarsysSettingsModel.getEmarsysApiUsername();
        LOGGER.debug("Emarsys Api Username: {}", emarsysApiUsername);
        if(!StringUtils.containsIgnoreCase(emarsysApiUsername, requiredString)){
            throw new InterceptorException("Emarsys Api Username doesn't contain required string: " + requiredString);
        }
    }

    @Required
    public void setRequiredString(String requiredString) {
        this.requiredString = requiredString;
    }
}

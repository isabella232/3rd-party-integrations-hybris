package com.osfglobal.hybris.emarsys.validators;

import com.osfglobal.hybris.emarsys.core.model.EmarsysSmartInsightModel;
import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.interceptor.ValidateInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * Emarsys SmartInsight BM validator
 */
public class EmarsysSmartInsightConfigValidateInterceptor implements ValidateInterceptor<EmarsysSmartInsightModel> {
    private Logger LOGGER = LoggerFactory.getLogger(EmarsysSmartInsightConfigValidateInterceptor.class);
    @Override
    public void onValidate(EmarsysSmartInsightModel emarsysSmartInsightConfig, InterceptorContext interceptorContext) throws InterceptorException {
        if(!isValidTimeFrame(emarsysSmartInsightConfig)){
            throw new InterceptorException("Please choose the correct timeframe");
        }
    }

    private boolean isValidTimeFrame(EmarsysSmartInsightModel config) {
        Date startDate = config.getStartDate();
        Date endDate = config.getEndDate();
        LOGGER.debug("startDate: {}, endDate: {}", startDate, endDate);
        if((startDate != null) ^ (endDate != null)){
            return false;
        }
        return startDate == null || startDate.before(endDate);
    }

}

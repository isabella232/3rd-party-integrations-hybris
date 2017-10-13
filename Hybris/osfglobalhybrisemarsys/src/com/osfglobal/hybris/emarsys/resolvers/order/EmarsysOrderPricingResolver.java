package com.osfglobal.hybris.emarsys.resolvers.order;

import com.osfglobal.hybris.emarsys.core.model.EmarsysPredictAvailabilityZoneModel;
import com.osfglobal.hybris.emarsys.resolvers.EmarsysResolver;
import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.servicelayer.i18n.I18NService;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.MessageSource;

import java.util.Map;
import java.util.Objects;

/**
 * Emarsys order pricing resolver
 */
public class EmarsysOrderPricingResolver implements EmarsysResolver<OrderModel> {
    private static final String ORDER_NET_KEY_PREFIX = "order.net";
    private MessageSource hmcMessageSource;
    private I18NService i18nService;

    @Override
    public String resolve(OrderModel model, EmarsysPredictAvailabilityZoneModel availabilityZone) {
        return resolve(model);
    }

    @Override
    public String resolve(OrderModel order) {
        return hmcMessageSource.getMessage(ORDER_NET_KEY_PREFIX + "." + Objects.toString(order.getNet()),null,
                i18nService.getCurrentLocale());
    }

    @Override
    public Map<String, EmarsysResolver<OrderModel>> getResolvers() {
        return null;
    }

    @Required
    public void setHmcMessageSource(MessageSource hmcMessageSource) {
        this.hmcMessageSource = hmcMessageSource;
    }

    @Required
    public void setI18nService(I18NService i18nService) {
        this.i18nService = i18nService;
    }
}

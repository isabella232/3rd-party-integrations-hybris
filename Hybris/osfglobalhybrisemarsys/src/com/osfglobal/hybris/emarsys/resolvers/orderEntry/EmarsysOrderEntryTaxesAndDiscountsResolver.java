package com.osfglobal.hybris.emarsys.resolvers.orderEntry;

import com.osfglobal.hybris.emarsys.beans.EmarsysPriceData;
import com.osfglobal.hybris.emarsys.core.model.EmarsysPredictAvailabilityZoneModel;
import com.osfglobal.hybris.emarsys.resolvers.EmarsysResolver;
import com.osfglobal.hybris.emarsys.services.EmarsysPriceService;
import com.osfglobal.hybris.emarsys.utils.EmarsysFormatterUtils;
import com.osfglobal.hybris.emarsys.utils.EmarsysObjectUtils;
import de.hybris.platform.core.enums.OrderStatus;
import de.hybris.platform.core.model.c2l.CurrencyModel;
import de.hybris.platform.core.model.order.OrderEntryModel;
import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.util.DiscountValue;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;
import java.util.Map;

/**
 * Emarsys order entry total discounts or total taxes resolver
 */
public class EmarsysOrderEntryTaxesAndDiscountsResolver implements EmarsysResolver<OrderEntryModel> {
    private EmarsysFormatterUtils emarsysFormatterUtils;
    private EmarsysPriceService emarsysPriceService;
    private String priceField;
    private boolean formatPrice;
    private boolean convertToBaseCurrency;
    private boolean negateIfCancelled;

    @Override
    public String resolve(OrderEntryModel model, EmarsysPredictAvailabilityZoneModel availabilityZone) {
        return resolve(model);
    }

    @Override
    public String resolve(OrderEntryModel model) {
        List<?> values = (List) EmarsysObjectUtils.getNestedProperty(model, priceField);
        double result = 0.0d;
        if (!CollectionUtils.isEmpty(values)) {
            for (final Object value : values) {
                result += (double)EmarsysObjectUtils.getNestedProperty(value, "appliedValue");
            }
        }

        CurrencyModel currency = model.getOrder().getCurrency();
        EmarsysPriceData emarsysPriceData = emarsysPriceService.createPriceData(result, currency);
        if(convertToBaseCurrency){
            emarsysPriceData = emarsysPriceService.convertPriceToBaseCurrency(currency, result);
        }
        if(formatPrice){
            return emarsysPriceData.getFormattedValue();
        }
        return emarsysFormatterUtils.doubleToString(emarsysPriceData.getValue());
    }

    @Required
    public void setFormatPrice(boolean formatPrice) {
        this.formatPrice = formatPrice;
    }

    @Required
    public void setEmarsysFormatterUtils(EmarsysFormatterUtils emarsysFormatterUtils) {
        this.emarsysFormatterUtils = emarsysFormatterUtils;
    }
    @Required
    public void setEmarsysPriceService(EmarsysPriceService emarsysPriceService) {
        this.emarsysPriceService = emarsysPriceService;
    }
    @Required
    public void setConvertToBaseCurrency(boolean convertToBaseCurrency) {
        this.convertToBaseCurrency = convertToBaseCurrency;
    }
    @Required
    public void setNegateIfCancelled(boolean negateIfCancelled) {
        this.negateIfCancelled = negateIfCancelled;
    }

    @Override
    public Map<String, EmarsysResolver<OrderEntryModel>> getResolvers() {
        return null;
    }

    @Required
    public void setPriceField(String priceField) {
        this.priceField = priceField;
    }
}

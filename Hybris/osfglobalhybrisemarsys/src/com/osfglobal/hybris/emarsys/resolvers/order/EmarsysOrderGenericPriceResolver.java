package com.osfglobal.hybris.emarsys.resolvers.order;

import com.osfglobal.hybris.emarsys.beans.EmarsysPriceData;
import com.osfglobal.hybris.emarsys.core.model.EmarsysPredictAvailabilityZoneModel;
import com.osfglobal.hybris.emarsys.resolvers.EmarsysResolver;
import com.osfglobal.hybris.emarsys.services.EmarsysPriceService;
import com.osfglobal.hybris.emarsys.utils.EmarsysFormatterUtils;
import com.osfglobal.hybris.emarsys.utils.EmarsysObjectUtils;
import de.hybris.platform.core.enums.OrderStatus;
import de.hybris.platform.core.model.c2l.CurrencyModel;
import de.hybris.platform.core.model.order.OrderModel;
import org.springframework.beans.factory.annotation.Required;

import java.util.Map;

/**
 * Emarsys order generic price resolver
 */
public class EmarsysOrderGenericPriceResolver implements EmarsysResolver<OrderModel> {
    private EmarsysFormatterUtils emarsysFormatterUtils;
    private EmarsysPriceService emarsysPriceService;
    private String priceField;
    private boolean negateIfCancelled;
    private boolean convertToBaseCurrency;
    private boolean formatPrice;

    @Override
    public String resolve(OrderModel order) {
        Double price = (Double)EmarsysObjectUtils.getNestedProperty(order, priceField);
        if(price == null){
            return null;
        }
        CurrencyModel currency = order.getCurrency();
        EmarsysPriceData emarsysPriceData = emarsysPriceService.createPriceData(price, currency);
        if(convertToBaseCurrency){
            emarsysPriceData = emarsysPriceService.convertPriceToBaseCurrency(currency, price);
        }
        if(negateIfCancelled && order.getStatus() == OrderStatus.CANCELLED){
            emarsysPriceData.setValue(-emarsysPriceData.getValue());
        }
        if(formatPrice){
            return emarsysPriceData.getFormattedValue();
        }
        return emarsysFormatterUtils.doubleToString(emarsysPriceData.getValue());
    }

    @Override
    public String resolve(OrderModel model, EmarsysPredictAvailabilityZoneModel availabilityZone) {
        return resolve(model);
    }

    @Override
    public Map<String, EmarsysResolver<OrderModel>> getResolvers() {
        return null;
    }
    
    @Required
    public void setPriceField(String priceField) {
        this.priceField = priceField;
    }
    @Required
    public void setNegateIfCancelled(boolean negateIfCancelled) {
        this.negateIfCancelled = negateIfCancelled;
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
    public void setFormatPrice(boolean formatPrice) {
        this.formatPrice = formatPrice;
    }
}

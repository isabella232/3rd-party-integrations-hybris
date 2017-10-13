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
import de.hybris.platform.servicelayer.i18n.CommonI18NService;
import org.springframework.beans.factory.annotation.Required;

import java.util.Map;
import java.util.Objects;

/**
 * Emarsys order total price resolver
 */
public class EmarsysOrderEntryGenericPriceResolver implements EmarsysResolver<OrderEntryModel> {
    private EmarsysFormatterUtils emarsysFormatterUtils;
    private EmarsysPriceService emarsysPriceService;
    private String priceField;
    private boolean negateIfCancelled;
    private boolean formatPrice;
    private boolean convertToBaseCurrency;

    @Override
    public String resolve(OrderEntryModel model, EmarsysPredictAvailabilityZoneModel availabilityZone) {
        return resolve(model);
    }

    @Override
    public String resolve(OrderEntryModel model) {
        Double price = (Double) EmarsysObjectUtils.getNestedProperty(model, priceField);
        if(price == null){
            return null;
        }
        OrderModel order = model.getOrder();
        CurrencyModel currency = model.getOrder().getCurrency();
        EmarsysPriceData emarsysPriceData = emarsysPriceService.createPriceData(price, currency);
        if(convertToBaseCurrency) {
            emarsysPriceData = emarsysPriceService.convertPriceToBaseCurrency(currency, price);
        }
        if(negateIfCancelled && order.getStatus() == OrderStatus.CANCELLED){
            emarsysPriceData.setValue( - emarsysPriceData.getValue() );
        }
        if(formatPrice){
            return emarsysPriceData.getFormattedValue();
        }
        return emarsysFormatterUtils.doubleToString(emarsysPriceData.getValue());
    }


    @Required
    public void setEmarsysFormatterUtils(EmarsysFormatterUtils emarsysFormatterUtils) {
        this.emarsysFormatterUtils = emarsysFormatterUtils;
    }
    @Required
    public void setEmarsysPriceService(EmarsysPriceService emarsysPriceService) {
        this.emarsysPriceService = emarsysPriceService;
    }

    @Override
    public Map<String, EmarsysResolver<OrderEntryModel>> getResolvers() {
        return null;
    }

    @Required
    public void setFormatPrice(boolean formatPrice) {
        this.formatPrice = formatPrice;
    }

    @Required
    public void setConvertToBaseCurrency(boolean convertToBaseCurrency) {
        this.convertToBaseCurrency = convertToBaseCurrency;
    }

    @Required
    public void setPriceField(String priceField) {
        this.priceField = priceField;
    }
    @Required
    public void setNegateIfCancelled(boolean negateIfCancelled) {
        this.negateIfCancelled = negateIfCancelled;
    }
}

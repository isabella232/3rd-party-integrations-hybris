package com.osfglobal.hybris.emarsys.resolvers.product;

import com.osfglobal.hybris.emarsys.core.model.EmarsysPredictAvailabilityZoneModel;
import com.osfglobal.hybris.emarsys.resolvers.EmarsysResolver;
import de.hybris.platform.basecommerce.enums.StockLevelStatus;
import de.hybris.platform.commerceservices.stock.CommerceStockService;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.store.services.BaseStoreService;
import org.apache.commons.lang.BooleanUtils;
import org.springframework.beans.factory.annotation.Required;

import java.util.Map;
import java.util.Objects;

/**
 * Emarsys product availability resolver
 */
public class EmarsysProductAvailabilityResolver implements EmarsysResolver<ProductModel> {
    private BaseStoreService baseStoreService;
    private CommerceStockService commerceStockService;

    @Override
    public String resolve(ProductModel product, EmarsysPredictAvailabilityZoneModel availabilityZone) {
        boolean availability = false;
        StockLevelStatus stockLevelStatus = commerceStockService.getStockLevelStatusForProductAndBaseStore(product, baseStoreService.getCurrentBaseStore());
        if (stockLevelStatus == StockLevelStatus.INSTOCK || stockLevelStatus == StockLevelStatus.LOWSTOCK) {
            availability = product.getEurope1Prices()
                    .stream()
                    .anyMatch(p -> Objects.equals(p.getCurrency().getIsocode(), availabilityZone.getCurrency().getIsocode()));
        }
        return BooleanUtils.toStringTrueFalse(availability);
    }


    @Override
    public String resolve(ProductModel model) {

        StockLevelStatus stockLevelStatus = commerceStockService.getStockLevelStatusForProductAndBaseStore(model, baseStoreService.getCurrentBaseStore());
        boolean availability = stockLevelStatus == StockLevelStatus.INSTOCK || stockLevelStatus == StockLevelStatus.LOWSTOCK && !model.getEurope1Prices().isEmpty();
        return BooleanUtils.toStringTrueFalse(availability);
    }

    @Override
    public Map<String, EmarsysResolver<ProductModel>> getResolvers() {
        return null;
    }

    @Required
    public void setBaseStoreService(BaseStoreService baseStoreService) {
        this.baseStoreService = baseStoreService;
    }

    @Required
    public void setCommerceStockService(CommerceStockService commerceStockService) {
        this.commerceStockService = commerceStockService;
    }
}

package com.osfglobal.hybris.emarsys.resolvers.product;

import com.osfglobal.hybris.emarsys.beans.EmarsysPriceData;
import com.osfglobal.hybris.emarsys.core.model.EmarsysPredictAvailabilityZoneModel;
import com.osfglobal.hybris.emarsys.resolvers.EmarsysResolver;
import com.osfglobal.hybris.emarsys.services.EmarsysPriceService;
import com.osfglobal.hybris.emarsys.utils.EmarsysFormatterUtils;
import de.hybris.platform.basecommerce.enums.StockLevelStatus;
import de.hybris.platform.commerceservices.stock.CommerceStockService;
import de.hybris.platform.core.model.c2l.CurrencyModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.europe1.model.PriceRowModel;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;
import de.hybris.platform.store.services.BaseStoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Required;

import java.util.Map;
import java.util.Objects;

/**
 * Emarsys product price resolver
 */
public class EmarsysProductPriceResolver implements EmarsysResolver<ProductModel> {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmarsysProductPriceResolver.class);
    private EmarsysFormatterUtils emarsysFormatterUtils;
    private EmarsysPriceService emarsysPriceService;
    private BaseStoreService baseStoreService;
    private CommerceStockService commerceStockService;
    private boolean formatPrice;


    @Override
    public String resolve(ProductModel product) {
        if(!isProductAvailableForPickup(product)){
            return null;
        }
        PriceRowModel basePriceRow = getBasePriceForProduct(product);
        EmarsysPriceData priceData;
        if (basePriceRow != null) {
            priceData = emarsysPriceService.createPriceData(basePriceRow.getPrice(), basePriceRow.getCurrency());
        } else {
            LOGGER.debug("Converting first price to base currency price for product: {}", product.getCode());
            //get first price from product prices and currency to a base currency
            PriceRowModel firstPriceRow = getFirstPriceForProduct(product);
            priceData = emarsysPriceService.convertPriceToBaseCurrency(firstPriceRow.getCurrency(), firstPriceRow.getPrice());
        }
        if(formatPrice){
            return priceData.getFormattedValue();
        }
        return emarsysFormatterUtils.doubleToString(priceData.getValue());
    }

    private boolean isProductAvailableForPickup(ProductModel product) {
        StockLevelStatus stockLevelStatus = commerceStockService.getStockLevelStatusForProductAndBaseStore(product, baseStoreService.getCurrentBaseStore());
        return stockLevelStatus == StockLevelStatus.INSTOCK || stockLevelStatus == StockLevelStatus.LOWSTOCK && !product.getEurope1Prices().isEmpty();
    }

    @Override
    public String resolve(ProductModel product, EmarsysPredictAvailabilityZoneModel availabilityZone) {
        if(!isProductAvailableForPickup(product)){
            return null;
        }
        try {
            CurrencyModel destinationCurrency = availabilityZone.getCurrency();
            PriceRowModel priceRow = product.getEurope1Prices()
                    .stream()
                    .filter(p -> Objects.equals(p.getCurrency().getIsocode(), destinationCurrency.getIsocode()))
                    .findFirst()
                    .orElse(null);
            if (priceRow != null) {
                LOGGER.debug("Found price for input currency for product: {}", product.getCode());
                return emarsysFormatterUtils.doubleToString(priceRow.getPrice());
            }
            //get first price from product prices and currency to a need currency
            LOGGER.debug("Converting first price to input currency price for product: {}", product.getCode());
            PriceRowModel firstPriceRow = getFirstPriceForProduct(product);
            EmarsysPriceData emarsysPriceData = emarsysPriceService.convertPrice(firstPriceRow.getCurrency(), destinationCurrency, firstPriceRow.getPrice());
            return emarsysFormatterUtils.doubleToString(emarsysPriceData.getValue());
        } catch (UnknownIdentifierException e) {
            LOGGER.debug(e.getMessage(), e);
            return null;
        }
    }

    private PriceRowModel getFirstPriceForProduct(ProductModel product) {
        return product.getEurope1Prices().stream().findFirst().orElse(null);
    }

    private PriceRowModel getBasePriceForProduct(ProductModel product) {
        return product.getEurope1Prices().stream().filter(p -> p.getCurrency().getBase()).findFirst().orElse(null);
    }

    @Required
    public void setBaseStoreService(BaseStoreService baseStoreService) {
        this.baseStoreService = baseStoreService;
    }

    @Override
    public Map<String, EmarsysResolver<ProductModel>> getResolvers() {
        return null;
    }

    @Required
    public void setEmarsysPriceService(EmarsysPriceService emarsysPriceService) {
        this.emarsysPriceService = emarsysPriceService;
    }

    @Required
    public void setEmarsysFormatterUtils(EmarsysFormatterUtils emarsysFormatterUtils) {
        this.emarsysFormatterUtils = emarsysFormatterUtils;
    }

    @Required
    public void setCommerceStockService(CommerceStockService commerceStockService) {
        this.commerceStockService = commerceStockService;
    }

    @Required
    public void setFormatPrice(boolean formatPrice) {
        this.formatPrice = formatPrice;
    }
}

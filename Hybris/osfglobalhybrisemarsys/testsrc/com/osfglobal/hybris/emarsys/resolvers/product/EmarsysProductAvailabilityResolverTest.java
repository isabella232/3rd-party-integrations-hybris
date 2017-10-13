package com.osfglobal.hybris.emarsys.resolvers.product;

import com.osfglobal.hybris.emarsys.core.jalo.EmarsysPredictAvailabilityZone;
import com.osfglobal.hybris.emarsys.core.model.EmarsysPredictAvailabilityZoneModel;
import de.hybris.platform.acceleratorservices.dataexport.googlelocal.model.Product;
import de.hybris.platform.basecommerce.enums.StockLevelStatus;
import de.hybris.platform.commerceservices.stock.CommerceStockService;
import de.hybris.platform.core.model.c2l.CurrencyModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.europe1.model.PriceRowModel;
import de.hybris.platform.jalo.c2l.Currency;
import de.hybris.platform.site.BaseSiteService;
import de.hybris.platform.store.services.BaseStoreService;
import de.hybris.platform.store.services.impl.DefaultBaseStoreService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

/**
 * Created by Roman on 22/11/2016.
 */
public class EmarsysProductAvailabilityResolverTest {
    @Spy
    private EmarsysProductAvailabilityResolver resolver = new EmarsysProductAvailabilityResolver();
    @Mock
    private ProductModel product;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        BaseStoreService baseStoreService = mock(BaseStoreService.class);
        CommerceStockService commerceStockService =  mock(CommerceStockService.class);
        resolver.setBaseStoreService(baseStoreService);
        resolver.setCommerceStockService(commerceStockService);
        PriceRowModel pr1 = new PriceRowModel();
        CurrencyModel currency = new CurrencyModel();
        currency.setIsocode("uah");
        pr1.setCurrency(currency);

        PriceRowModel pr2 = new PriceRowModel();
        CurrencyModel currency2 = new CurrencyModel();
        currency2.setIsocode("eur");
        pr2.setCurrency(currency2);
        when(product.getEurope1Prices()).thenReturn(Arrays.asList(pr1, pr2));
        when(commerceStockService.getStockLevelStatusForProductAndBaseStore(product, baseStoreService.getCurrentBaseStore()))
                .thenReturn(StockLevelStatus.INSTOCK);

    }



    @Test
    public void testAvailabilityZoneAvailable() throws Exception {
        EmarsysPredictAvailabilityZoneModel availabilityZone = new EmarsysPredictAvailabilityZoneModel();
        CurrencyModel currency = new CurrencyModel();
        currency.setIsocode("eur");
        availabilityZone.setCurrency(currency);

        assertThat(resolver.resolve(product, availabilityZone), is("true"));

    }

    @Test
    public void testAvailabilityZoneNotAvailable() throws Exception {
        EmarsysPredictAvailabilityZoneModel availabilityZone = new EmarsysPredictAvailabilityZoneModel();
        CurrencyModel currency = new CurrencyModel();
        currency.setIsocode("usd");
        availabilityZone.setCurrency(currency);

        assertThat(resolver.resolve(product, availabilityZone), is("false"));

    }
}
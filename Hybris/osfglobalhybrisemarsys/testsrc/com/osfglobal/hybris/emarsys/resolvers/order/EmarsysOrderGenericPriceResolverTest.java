package com.osfglobal.hybris.emarsys.resolvers.order;

import com.osfglobal.hybris.emarsys.services.impl.EmarsysPriceServiceImpl;
import com.osfglobal.hybris.emarsys.utils.EmarsysFormatterUtils;
import de.hybris.platform.core.model.c2l.CurrencyModel;
import de.hybris.platform.core.model.c2l.LanguageModel;
import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.servicelayer.i18n.CommonI18NService;
import de.hybris.platform.servicelayer.i18n.I18NService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.Locale;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

/**
 * Created by Roman on 21/11/2016.
 */
public class EmarsysOrderGenericPriceResolverTest {
    @Spy
    private EmarsysOrderGenericPriceResolver resolver = new EmarsysOrderGenericPriceResolver();
    @Spy
    private EmarsysPriceServiceImpl priceService = new EmarsysPriceServiceImpl();
    @Spy
    private EmarsysFormatterUtils formatterUtils;
    @Mock
    private CommonI18NService commonI18NService;
    @Mock
    private I18NService i18NService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        resolver.setEmarsysPriceService(priceService);
        resolver.setEmarsysFormatterUtils(formatterUtils);
        priceService.setI18NService(i18NService);
        priceService.setCommonI18NService(commonI18NService);
        when(commonI18NService.getCurrentLanguage()).thenReturn(new LanguageModel());
        when(commonI18NService.getLocaleForLanguage(Matchers.any(LanguageModel.class))).thenReturn(Locale.ENGLISH);
        CurrencyModel baseCurrency = new CurrencyModel();
        baseCurrency.setDigits(2);
        baseCurrency.setIsocode("eur");
        baseCurrency.setConversion(2.0);
        baseCurrency.setSymbol("€");
        baseCurrency.setBase(true);
        when(commonI18NService.getBaseCurrency()).thenReturn(baseCurrency);
    }

    @Test
    public void orderTotalPriceTest() throws Exception {
        resolver.setPriceField("totalPrice");
        resolver.setConvertToBaseCurrency(false);
        resolver.setFormatPrice(false);
        OrderModel order = new OrderModel();
        order.setTotalPrice(56d);
        CurrencyModel currency = new CurrencyModel();
        currency.setConversion(1d);
        currency.setSymbol("$");
        currency.setIsocode("usd");
        currency.setDigits(2);
        order.setCurrency(currency);

        assertThat(resolver.resolve(order), is("56.00"));
    }

    @Test
    public void orderTotalPriceFormattedTest() throws Exception {
        resolver.setPriceField("totalPrice");
        resolver.setConvertToBaseCurrency(false);
        resolver.setFormatPrice(true);
        OrderModel order = new OrderModel();
        order.setTotalPrice(56d);
        CurrencyModel currency = new CurrencyModel();
        currency.setConversion(1d);
        currency.setSymbol("$");
        currency.setIsocode("usd");
        currency.setDigits(2);
        order.setCurrency(currency);
        assertThat(resolver.resolve(order), is("$56.00"));
    }

    @Test
    public void orderTotalPriceConvertToBaseCurrencyTest() throws Exception {
        resolver.setPriceField("totalPrice");
        resolver.setConvertToBaseCurrency(true);
        resolver.setFormatPrice(true);
        OrderModel order = new OrderModel();
        order.setTotalPrice(56d);
        CurrencyModel currency = new CurrencyModel();
        currency.setConversion(1d);
        currency.setSymbol("$");
        currency.setIsocode("usd");
        currency.setDigits(2);
        order.setCurrency(currency);

        CurrencyModel baseCurrency = new CurrencyModel();
        baseCurrency.setDigits(2);
        baseCurrency.setIsocode("eur");
        baseCurrency.setConversion(2.0);
        baseCurrency.setSymbol("€");
        baseCurrency.setBase(true);
        when(commonI18NService.convertAndRoundCurrency(order.getCurrency().getConversion(),
                baseCurrency.getConversion(), baseCurrency.getDigits(), order.getTotalPrice())).thenReturn(order.getTotalPrice() *  baseCurrency.getConversion());
        assertThat(resolver.resolve(order), is("€112.00"));
    }

}
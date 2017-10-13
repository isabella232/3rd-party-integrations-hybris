package com.osfglobal.hybris.emarsys.services.impl;

import com.osfglobal.hybris.emarsys.beans.EmarsysPriceData;
import de.hybris.platform.core.model.c2l.CurrencyModel;
import de.hybris.platform.core.model.c2l.LanguageModel;
import de.hybris.platform.servicelayer.i18n.CommonI18NService;
import de.hybris.platform.servicelayer.i18n.I18NService;
import org.springframework.beans.factory.annotation.Required;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;
import com.osfglobal.hybris.emarsys.services.EmarsysBaseService;
import com.osfglobal.hybris.emarsys.services.EmarsysPriceService;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class EmarsysPriceServiceImpl extends EmarsysBaseService implements EmarsysPriceService {
    private CommonI18NService commonI18NService;
    private I18NService i18NService;
    private final ConcurrentMap<String, NumberFormat> currencyFormats = new ConcurrentHashMap<>();

    @Override
    public EmarsysPriceData convertPrice(CurrencyModel fromCurrency, CurrencyModel toCurrency, double price) {
        if(Objects.equals(fromCurrency.getIsocode(), toCurrency.getIsocode())){
            return createPriceData(price, fromCurrency);
        }
        double convertedPrice = commonI18NService.convertAndRoundCurrency(
                fromCurrency.getConversion(), toCurrency.getConversion(), toCurrency.getDigits(), price);
        return createPriceData(convertedPrice, toCurrency);
    }

    @Override
    public EmarsysPriceData convertPriceToBaseCurrency(CurrencyModel fromCurrency, double price) {
        return convertPrice(fromCurrency, commonI18NService.getBaseCurrency(), price);
    }

    @Override
    public EmarsysPriceData createPriceData(double value, CurrencyModel currency) {
        EmarsysPriceData price = new EmarsysPriceData();
        price.setFormattedValue(formatPrice(value, currency));
        price.setValue(value);
        price.setCurrency(currency);
        return price;
    }


    public String formatPrice(Double value, CurrencyModel currency) {
        final LanguageModel currentLanguage = commonI18NService.getCurrentLanguage();
        Locale locale = commonI18NService.getLocaleForLanguage(currentLanguage);
        if (locale == null) {
            // Fallback to session locale
            locale = i18NService.getCurrentLocale();
        }

        final NumberFormat currencyFormat = createCurrencyFormat(locale, currency);
        return currencyFormat.format(value);
    }

    /**
     * @param locale
     * @param currency
     * @return A clone of {@link NumberFormat} from the instance in the local cache, if the cache does not contain an
     * instance of a NumberFormat for a given locale and currency one would be added.
     */
    private NumberFormat createCurrencyFormat(final Locale locale, final CurrencyModel currency) {
        final String key = locale.getISO3Country() + "_" + currency.getIsocode();

        NumberFormat numberFormat = currencyFormats.get(key);
        if (numberFormat == null) {
            final NumberFormat currencyFormat = createNumberFormat(locale, currency);
            numberFormat = currencyFormats.putIfAbsent(key, currencyFormat);
            if (numberFormat == null) {
                numberFormat = currencyFormat;
            }
        }
        // don't allow multiple references
        return (NumberFormat) numberFormat.clone();
    }

    private NumberFormat createNumberFormat(final Locale locale, final CurrencyModel currency) {
        final DecimalFormat currencyFormat = (DecimalFormat) NumberFormat.getCurrencyInstance(locale);
        adjustDigits(currencyFormat, currency);
        adjustSymbol(currencyFormat, currency);
        return currencyFormat;
    }

    /**
     * Adjusts {@link DecimalFormat}'s fraction digits according to given {@link CurrencyModel}.
     */
    private DecimalFormat adjustDigits(final DecimalFormat format, final CurrencyModel currencyModel) {
        final int tempDigits = currencyModel.getDigits() == null ? 0 : currencyModel.getDigits().intValue();
        final int digits = Math.max(0, tempDigits);

        format.setMaximumFractionDigits(digits);
        format.setMinimumFractionDigits(digits);
        if (digits == 0) {
            format.setDecimalSeparatorAlwaysShown(false);
        }

        return format;
    }

    /**
     * Adjusts {@link DecimalFormat}'s symbol according to given {@link CurrencyModel}.
     */
    private DecimalFormat adjustSymbol(final DecimalFormat format, final CurrencyModel currencyModel) {
        final String symbol = currencyModel.getSymbol();
        if (symbol != null) {
            final DecimalFormatSymbols symbols = format.getDecimalFormatSymbols(); // does cloning
            final String iso = currencyModel.getIsocode();
            boolean changed = false;
            if (!iso.equalsIgnoreCase(symbols.getInternationalCurrencySymbol())) {
                symbols.setInternationalCurrencySymbol(iso);
                changed = true;
            }
            if (!symbol.equals(symbols.getCurrencySymbol())) {
                symbols.setCurrencySymbol(symbol);
                changed = true;
            }
            if (changed) {
                format.setDecimalFormatSymbols(symbols);
            }
        }
        return format;
    }


    @Required
    public void setCommonI18NService(CommonI18NService commonI18NService) {
        this.commonI18NService = commonI18NService;
    }

    @Required
    public void setI18NService(I18NService i18NService) {
        this.i18NService = i18NService;
    }
}

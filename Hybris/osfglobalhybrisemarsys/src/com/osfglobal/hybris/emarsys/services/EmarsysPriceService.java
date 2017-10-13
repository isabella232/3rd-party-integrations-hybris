package com.osfglobal.hybris.emarsys.services;

import com.osfglobal.hybris.emarsys.beans.EmarsysPriceData;
import de.hybris.platform.core.model.c2l.CurrencyModel;

/**
 * Emarsys price service class
 */
public interface EmarsysPriceService  {
    EmarsysPriceData convertPrice(CurrencyModel fromCurrency, CurrencyModel toCurrency, double price);
    EmarsysPriceData convertPriceToBaseCurrency(CurrencyModel fromCurrency, double price);
    EmarsysPriceData createPriceData(double price, CurrencyModel currency);
}

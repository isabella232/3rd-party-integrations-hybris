package com.osfglobal.hybris.emarsys.beans;

import de.hybris.platform.core.model.c2l.CurrencyModel;

public class EmarsysPriceData {
    private double value;
    private String formattedValue;
    private CurrencyModel currency;

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getFormattedValue() {
        return formattedValue;
    }

    public void setFormattedValue(String formattedValue) {
        this.formattedValue = formattedValue;
    }

    public CurrencyModel getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyModel currency) {
        this.currency = currency;
    }
}

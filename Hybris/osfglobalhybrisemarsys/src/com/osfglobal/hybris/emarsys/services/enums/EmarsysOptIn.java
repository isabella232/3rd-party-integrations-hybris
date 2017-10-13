package com.osfglobal.hybris.emarsys.services.enums;

import com.osfglobal.emarsys.client.OptIn;
import com.osfglobal.hybris.emarsys.enums.EmarsysOptinEnum;

public enum EmarsysOptIn {
    EMPTY(OptIn.DEFAULT), DISABLED(OptIn.FALSE), SINGLE(OptIn.TRUE), DOUBLE(OptIn.TRUE);

    private OptIn optInValue;

    EmarsysOptIn(OptIn optInValue) {
        this.optInValue = optInValue;
    }

    public OptIn getOptInValue() {
        return optInValue;
    }

    public static EmarsysOptIn fromStringIgnoreCase(String optInName) {
        return EmarsysOptIn.valueOf(optInName.toUpperCase());
    }

    public static EmarsysOptIn fromEmarsysOptinEnum(EmarsysOptinEnum optinEnum){
        if(optinEnum == EmarsysOptinEnum.DOUBLE){
            return EmarsysOptIn.DOUBLE;
        }
        return EmarsysOptIn.SINGLE;
    }
}

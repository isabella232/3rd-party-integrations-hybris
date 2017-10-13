package com.osfglobal.hybris.emarsys.services.enums;

import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public enum EmarsysSalutation {
    MALE("1"), FEMALE("2"), EMPTY("");

    private String salutationId;

    EmarsysSalutation(String salutationId) {
        this.salutationId = salutationId;
    }

    public String getSalutationId() {
        return salutationId;
    }

    private static Map<String, EmarsysSalutation> titleCodes2SalutationMapping = new HashMap<>();
    static {
        titleCodes2SalutationMapping.put("mr", MALE);
        titleCodes2SalutationMapping.put("mrs", FEMALE);
        titleCodes2SalutationMapping.put("miss", FEMALE);
        titleCodes2SalutationMapping.put("ms", FEMALE);
        titleCodes2SalutationMapping.put("dr", EMPTY);
        titleCodes2SalutationMapping.put("rev", EMPTY);
    }

    public static EmarsysSalutation fromTitleCode(String titleCode) {
        if(StringUtils.isEmpty(titleCode)){
            return EMPTY;
        }
        return titleCodes2SalutationMapping.get(titleCode);
    }

    public static EmarsysSalutation fromBoolean(Boolean gender) {
        if(gender == null) {
            return null;
        }
        return gender ? MALE : FEMALE;
    }
}

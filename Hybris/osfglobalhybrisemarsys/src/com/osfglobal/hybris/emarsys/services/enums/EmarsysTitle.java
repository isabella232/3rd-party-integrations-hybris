package com.osfglobal.hybris.emarsys.services.enums;

import java.util.HashMap;
import java.util.Map;

public enum EmarsysTitle {
    DR("4"), EMPTY("");

    private String title;

    EmarsysTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    private static Map<String, EmarsysTitle> titleCodes2TitleMapping = new HashMap<>();
    static {
        titleCodes2TitleMapping.put("dr", DR);
    }

    public static EmarsysTitle fromTitleCode(String titleCode) {
        EmarsysTitle title = titleCodes2TitleMapping.get(titleCode);
        if(title == null){
            return EMPTY;
        }
        return title;
    }

}

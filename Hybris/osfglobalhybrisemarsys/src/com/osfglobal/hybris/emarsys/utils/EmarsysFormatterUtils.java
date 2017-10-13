package com.osfglobal.hybris.emarsys.utils;

import de.hybris.platform.servicelayer.i18n.I18NService;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.MessageSource;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.Objects;

/**
 * Util methods to format values
 */
public class EmarsysFormatterUtils {
    private MessageSource hmcMessageSource;
    private I18NService i18NService;
    public String objectToString(Object object) {
        if (object instanceof Double) {
            return doubleToString((Double) object);
        }else if (object instanceof Date){
            return dateToIsoString((Date) object);
        }else if(object instanceof Boolean){
            return booleanToString((Boolean) object);
        }
        return Objects.toString(object, null);
    }

    public String dateToIsoString(Date object) {
        return DateFormatUtils.ISO_DATE_FORMAT.format(object);
    }

    public String doubleToString(Double object) {
        if(object == null){
            return null;
        }
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        return decimalFormat.format(object);
    }

    public String booleanToString(Boolean object){
        String key;
        if(Boolean.TRUE.equals(object)){
            key = "yes";
        }else if(Boolean.FALSE.equals(object)){
            key = "no";
        }else {
            key = "notdefined";
        }
        return hmcMessageSource.getMessage(key, null, i18NService.getCurrentLocale());
    }

    @Required
    public void setHmcMessageSource(MessageSource hmcMessageSource) {
        this.hmcMessageSource = hmcMessageSource;
    }

    @Required
    public void setI18NService(I18NService i18NService) {
        this.i18NService = i18NService;
    }
}

package com.osfglobal.hybris.emarsys.services.impl;

import de.hybris.platform.acceleratorservices.urlencoder.UrlEncoderService;
import de.hybris.platform.acceleratorservices.urlencoder.attributes.UrlEncodingAttributeManager;
import de.hybris.platform.servicelayer.internal.i18n.I18NConstants;
import org.apache.commons.lang.text.StrBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Required;

import com.osfglobal.hybris.emarsys.services.EmarsysI18nService;

import java.util.Map;
import java.util.stream.Collectors;

public class EmarsysI18nServiceImpl implements EmarsysI18nService {
    public static final Logger LOGGER = LoggerFactory.getLogger(EmarsysI18nServiceImpl.class);
    public static final String CURRENCY_ATTR_KEY = "currency";
    public static final String LANGUAGE_ATTR_KEY = "language";
    private UrlEncoderService urlEncoderService;

    /**
     * Ge encoding attributes string for a specific language
     * @param languageCode
     * @return
     */
    @Override
    public String getEncodingAttributesForLanguage(String languageCode, String currencyCode) {
        Map<String, UrlEncodingAttributeManager> urlEncodingAttrManagerMap = urlEncoderService.getUrlEncodingAttrManagerMap();
        StringBuilder builder = new StringBuilder();
        for (String attr : urlEncoderService.getEncodingAttributesForSite()) {
            builder.append("/");
            switch (attr) {
                case LANGUAGE_ATTR_KEY:
                    builder.append(languageCode);
                    break;
                case CURRENCY_ATTR_KEY:
                    builder.append(currencyCode);
                    break;
                default:
                    builder.append(urlEncodingAttrManagerMap.get(attr).getCurrentValue());
            }
        }
        return builder.toString();
    }

    @Required
    public void setUrlEncoderService(UrlEncoderService urlEncoderService) {
        this.urlEncoderService = urlEncoderService;
    }
}

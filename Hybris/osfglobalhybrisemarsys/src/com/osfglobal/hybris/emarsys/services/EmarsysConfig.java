package com.osfglobal.hybris.emarsys.services;

import com.osfglobal.emarsys.client.beans.ApiConfig;
import com.osfglobal.emarsys.client.beans.EmarsysClientConfig;
import com.osfglobal.emarsys.client.beans.SftpConfig;
import com.osfglobal.emarsys.client.beans.WebDavConfig;
import com.osfglobal.hybris.emarsys.core.model.EmarsysPredictModel;
import com.osfglobal.hybris.emarsys.core.model.EmarsysSettingsModel;
import com.osfglobal.hybris.emarsys.core.model.EmarsysSmartInsightModel;
import com.osfglobal.hybris.emarsys.enums.EmarsysExternalEventsEnum;
import com.osfglobal.hybris.emarsys.services.enums.EmarsysOptIn;
import com.osfglobal.hybris.emarsys.services.enums.EmarsysPage;
import com.osfglobal.hybris.emarsys.services.exceptions.EmarsysServiceException;

import de.hybris.platform.basecommerce.model.site.BaseSiteModel;


public class EmarsysConfig {


    public String getOptInEventName(BaseSiteModel site, EmarsysPage page) throws EmarsysServiceException {
        EmarsysSettingsModel emarsysSettings = site.getEmarsysSettings();
        switch (page){
            case CHECKOUT :
                if (emarsysSettings.getCheckoutOptinExternalEvent() == null)
                    throw new EmarsysServiceException("CheckoutExternalEvent is empty");
                else
                    return emarsysSettings.getCheckoutOptinExternalEvent().toString();
            case REGISTRATION :
                if (emarsysSettings.getRegisterOptinExternalEvent() == null)
                    throw new EmarsysServiceException("RegisterOptinExternalEvent is empty");
                else
                    return emarsysSettings.getRegisterOptinExternalEvent().toString();
            case FOOTER:
                if (emarsysSettings.getFooterOptinExternalEvent() == null)
                    throw new EmarsysServiceException("SubscribeExternalEvent is empty");
                else
                    return emarsysSettings.getFooterOptinExternalEvent().toString();
            case MYACCOUNT   :
                if (emarsysSettings.getMyAccountOptinExternalEvent() == null)
                    throw new EmarsysServiceException("MyAccountExternalEvent is empty");
                else
                    return emarsysSettings.getMyAccountOptinExternalEvent().toString();
        }
        return null;
    }

    public EmarsysClientConfig getEmarsysClientConfig(BaseSiteModel site) {
        EmarsysSettingsModel emarsysSettings = site.getEmarsysSettings();
        EmarsysPredictModel emarsysPredict = site.getEmarsysPredict();
        EmarsysSmartInsightModel emarsysSmartInsight = site.getEmarsysSmartInsight();
        return EmarsysClientConfig.builder()
                .apiConfig(ApiConfig.builder()
                        .username(emarsysSettings.getEmarsysApiUsername())
                        .secret(emarsysSettings.getEmarsysApiSecret())
                        .serviceUrl(emarsysSettings.getEmarsysApiUrl())
                        .build())
                .webDavConfig(WebDavConfig.builder()
                        .username(emarsysSettings.getEmarsysWebDavUsername())
                        .password(emarsysSettings.getEmarsysWebDavPassword())
                        .url(emarsysSettings.getEmarsysWebDavUrl())
                        .build())
                .predictConfig(SftpConfig.builder()
                        .host(emarsysPredict.getSftpHost())
                        .path(emarsysPredict.getSftpPath())
                        .username(emarsysPredict.getSftpUsername())
                        .password(emarsysPredict.getSftpPassword())
                        .build())
                .smartInsightConfig(SftpConfig.builder()
                        .host(emarsysSmartInsight.getSftpHost())
                        .path(emarsysSmartInsight.getSftpPath())
                        .username(emarsysSmartInsight.getSftpUsername())
                        .password(emarsysSmartInsight.getSftpPassword())
                        .build())
                .build();
    }

    public EmarsysSettingsModel getEmarsysSettings(BaseSiteModel site){
        return site.getEmarsysSettings();
    }



    public EmarsysOptIn getOptIn(BaseSiteModel site, EmarsysPage page) {
        EmarsysSettingsModel emarsysSettings = site.getEmarsysSettings();
        switch (page){
            case CHECKOUT: return EmarsysOptIn.fromEmarsysOptinEnum(emarsysSettings.getCheckoutOptin());
            case FOOTER: return EmarsysOptIn.fromEmarsysOptinEnum(emarsysSettings.getFooterOptin());
            case REGISTRATION: return EmarsysOptIn.fromEmarsysOptinEnum(emarsysSettings.getRegisterOptin());
            case MYACCOUNT: return EmarsysOptIn.fromEmarsysOptinEnum(emarsysSettings.getMyAccountOptin());
        }
        return null;
    }

    public EmarsysExternalEventsEnum getOptinConfirmationEvent(BaseSiteModel site, EmarsysPage page) {
        EmarsysSettingsModel emarsysSettings = site.getEmarsysSettings();
        switch (page){
            case CHECKOUT: return emarsysSettings.getCheckoutConfirmationExternalEvent();
            case FOOTER: return emarsysSettings.getFooterConfirmationExternalEvent();
            case REGISTRATION: return emarsysSettings.getRegisterConfirmationExternalEvent();
            case MYACCOUNT: return emarsysSettings.getMyAccountConfirmationExternalEvent();
        }
        return null;
    }

    public String getOrderConfirmationEventName(BaseSiteModel site) throws EmarsysServiceException {
        EmarsysSettingsModel emarsysSettings = site.getEmarsysSettings();
        if (emarsysSettings.getOrderConfirmationExternalEvent() == null)
        	throw new EmarsysServiceException("OrderConfirmationExternalEvent is empty");
        else
        	return emarsysSettings.getOrderConfirmationExternalEvent().toString();
    }

    public String getOrderShippedEventName(BaseSiteModel site) throws EmarsysServiceException {
        EmarsysSettingsModel emarsysSettings = site.getEmarsysSettings();
        if (emarsysSettings.getShippingConfirmationExternalEvent() == null)
        	throw new EmarsysServiceException("ShippingConfirmationExternalEvent is empty");
        else
        	return emarsysSettings.getShippingConfirmationExternalEvent().toString();
    }
}

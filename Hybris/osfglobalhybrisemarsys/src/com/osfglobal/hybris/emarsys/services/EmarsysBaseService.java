package com.osfglobal.hybris.emarsys.services;

import com.osfglobal.emarsys.client.EmarsysClient;
import com.osfglobal.emarsys.client.EmarsysClientImpl;
import com.osfglobal.emarsys.client.beans.EmarsysClientConfig;
import de.hybris.platform.basecommerce.model.site.BaseSiteModel;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.site.BaseSiteService;
import org.springframework.beans.factory.annotation.Required;

/**
 * Emarsys base servise
 */
public abstract class EmarsysBaseService {
    protected EmarsysConfig emarsysConfig;
    protected FlexibleSearchService flexibleSearchService;
    protected BaseSiteService baseSiteService;

    protected EmarsysClient getEmarsysClient(BaseSiteModel site) {
        EmarsysClientConfig clientConfig = emarsysConfig.getEmarsysClientConfig(site);
        return new EmarsysClientImpl(clientConfig);
    }
    @Required
    public void setEmarsysConfig(EmarsysConfig emarsysConfig) {
        this.emarsysConfig = emarsysConfig;
    }

    @Required
    public void setFlexibleSearchService(FlexibleSearchService flexibleSearchService) {
        this.flexibleSearchService = flexibleSearchService;
    }

    @Required
    public void setBaseSiteService(BaseSiteService baseSiteService) {
        this.baseSiteService = baseSiteService;
    }
}

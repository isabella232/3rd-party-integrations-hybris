package com.osfglobal.hybris.emarsys.resolvers.product;

import com.osfglobal.hybris.emarsys.core.model.EmarsysPredictAvailabilityZoneModel;
import com.osfglobal.hybris.emarsys.resolvers.EmarsysResolver;
import com.osfglobal.hybris.emarsys.services.EmarsysI18nService;
import de.hybris.platform.acceleratorservices.urlresolver.SiteBaseUrlResolutionService;
import de.hybris.platform.basecommerce.model.site.BaseSiteModel;
import de.hybris.platform.commerceservices.url.UrlResolver;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.site.BaseSiteService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Required;

import java.util.Map;

/**
 * Emarsys product url resolver
 */
public class EmarsysProductUrlResolver implements EmarsysResolver<ProductModel> {
    private UrlResolver<ProductModel> productModelUrlResolver;
    private SiteBaseUrlResolutionService siteBaseUrlResolutionService;
    private BaseSiteService baseSiteService;
    private EmarsysI18nService emarsysI18nService;

    @Override
    public String resolve(ProductModel source) {
        String relUrl = productModelUrlResolver.resolve(source);
        if(StringUtils.isEmpty(relUrl)){
            return null;
        }
        return siteBaseUrlResolutionService.getWebsiteUrlForSite(baseSiteService.getCurrentBaseSite(), true, relUrl);
    }

    @Override
    public String resolve(ProductModel model, EmarsysPredictAvailabilityZoneModel availabilityZone) {
        String relUrl = productModelUrlResolver.resolve(model);
        if (StringUtils.isEmpty(relUrl)) {
            return null;
        }
        String encodingAttributes = emarsysI18nService.getEncodingAttributesForLanguage(
                availabilityZone.getLanguage().getIsocode(), availabilityZone.getCurrency().getIsocode());
        return siteBaseUrlResolutionService
                .getWebsiteUrlForSite(baseSiteService.getCurrentBaseSite(), encodingAttributes, true, relUrl);
    }

    @Override
    public Map<String, EmarsysResolver<ProductModel>> getResolvers() {
        return null;
    }

    @Required
    public void setProductModelUrlResolver(UrlResolver<ProductModel> productModelUrlResolver) {
        this.productModelUrlResolver = productModelUrlResolver;
    }

    @Required
    public void setSiteBaseUrlResolutionService(SiteBaseUrlResolutionService siteBaseUrlResolutionService) {
        this.siteBaseUrlResolutionService = siteBaseUrlResolutionService;
    }

    @Required
    public void setBaseSiteService(BaseSiteService baseSiteService) {
        this.baseSiteService = baseSiteService;
    }

    @Required
    public void setEmarsysI18nService(EmarsysI18nService emarsysI18nService) {
        this.emarsysI18nService = emarsysI18nService;
    }
}

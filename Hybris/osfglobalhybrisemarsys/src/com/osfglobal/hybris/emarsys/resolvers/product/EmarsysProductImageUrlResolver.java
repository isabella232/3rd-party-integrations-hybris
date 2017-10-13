package com.osfglobal.hybris.emarsys.resolvers.product;

import com.osfglobal.hybris.emarsys.core.model.EmarsysPredictAvailabilityZoneModel;
import com.osfglobal.hybris.emarsys.resolvers.EmarsysResolver;
import com.osfglobal.hybris.emarsys.services.EmarsysI18nService;
import de.hybris.platform.acceleratorservices.urlresolver.SiteBaseUrlResolutionService;
import de.hybris.platform.basecommerce.model.site.BaseSiteModel;
import de.hybris.platform.core.model.media.MediaModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.site.BaseSiteService;
import de.hybris.platform.variants.model.VariantProductModel;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Required;

import java.util.Map;

/**
 *  Emarsys product image url resolver
 */
public class EmarsysProductImageUrlResolver implements EmarsysResolver<ProductModel> {
    private SiteBaseUrlResolutionService siteBaseUrlResolutionService;
    private BaseSiteService baseSiteService;

    @Override
    public String resolve(ProductModel model, EmarsysPredictAvailabilityZoneModel availabilityZone) {
        return resolve(model);
    }

    @Override
    public String resolve(ProductModel source) {
        MediaModel productModelPicture = source.getPicture();
        if(source instanceof VariantProductModel && productModelPicture == null){
            productModelPicture = ((VariantProductModel) source).getBaseProduct().getPicture();
        }

        String relUrl = productModelPicture != null ? productModelPicture.getURL() : null;
        if(StringUtils.isEmpty(relUrl)){
            return null;
        }
        BaseSiteModel baseSite = baseSiteService.getCurrentBaseSite();
        return siteBaseUrlResolutionService.getMediaUrlForSite(baseSite, true, relUrl);
    }

    @Override
    public Map<String, EmarsysResolver<ProductModel>> getResolvers() {
        return null;
    }


    @Required
    public void setSiteBaseUrlResolutionService(SiteBaseUrlResolutionService siteBaseUrlResolutionService) {
        this.siteBaseUrlResolutionService = siteBaseUrlResolutionService;
    }

    @Required
    public void setBaseSiteService(BaseSiteService baseSiteService) {
        this.baseSiteService = baseSiteService;
    }
}

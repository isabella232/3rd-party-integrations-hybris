package com.osfglobal.hybris.emarsys.resolvers.product;

import com.osfglobal.hybris.emarsys.core.model.EmarsysPredictAvailabilityZoneModel;
import com.osfglobal.hybris.emarsys.resolvers.EmarsysResolver;
import com.osfglobal.hybris.emarsys.utils.EmarsysStringUtils;
import de.hybris.platform.core.model.product.ProductModel;
import org.apache.commons.lang.LocaleUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Required;

import java.util.Map;

/**
 * Product description resolver
 */
public class EmarsysProductDescriptionResolver implements EmarsysResolver<ProductModel> {
    private boolean stripTags;

    @Required
    public void setStripTags(boolean stripTags) {
        this.stripTags = stripTags;
    }

    @Override
    public String resolve(ProductModel model, EmarsysPredictAvailabilityZoneModel availabilityZone) {
        String localizedDescription = model.getDescription(LocaleUtils.toLocale(availabilityZone.getLanguage().getIsocode()));
        if (StringUtils.isEmpty(localizedDescription)) {
            return resolve(model);
        }
        if(stripTags){
            return EmarsysStringUtils.stripHtmlTags(localizedDescription);
        }
        return localizedDescription;

    }

    @Override
    public String resolve(ProductModel model) {
        String description = model.getDescription();
        if(stripTags){
            return EmarsysStringUtils.stripHtmlTags(description);
        }
        return description;
    }

    @Override
    public Map<String, EmarsysResolver<ProductModel>> getResolvers() {
        return null;
    }
}

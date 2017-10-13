package com.osfglobal.hybris.emarsys.resolvers.product;

import com.osfglobal.hybris.emarsys.core.model.EmarsysPredictAvailabilityZoneModel;
import com.osfglobal.hybris.emarsys.resolvers.EmarsysResolver;
import de.hybris.platform.core.model.c2l.LanguageModel;
import de.hybris.platform.core.model.product.ProductModel;
import org.apache.commons.lang.LocaleUtils;
import org.apache.commons.lang.StringUtils;

import java.util.Locale;
import java.util.Map;

/**
 * Emarsys product name resolver
 */
public class EmarsysProductNameResolver implements EmarsysResolver<ProductModel> {

    @Override
    public String resolve(ProductModel model, EmarsysPredictAvailabilityZoneModel availabilityZone) {
        LanguageModel language = availabilityZone.getLanguage();
        Locale locale = LocaleUtils.toLocale(language.getIsocode());
        String localizedName = model.getName(locale);
        if(StringUtils.isEmpty(localizedName)){
            return resolve(model);
        }
        return localizedName;
    }

    @Override
    public String resolve(ProductModel model) {
        return model.getName();
    }

    @Override
    public Map<String, EmarsysResolver<ProductModel>> getResolvers() {
        return null;
    }
}

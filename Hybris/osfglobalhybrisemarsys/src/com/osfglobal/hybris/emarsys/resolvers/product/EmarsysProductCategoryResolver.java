package com.osfglobal.hybris.emarsys.resolvers.product;

import com.osfglobal.hybris.emarsys.core.model.EmarsysPredictAvailabilityZoneModel;
import com.osfglobal.hybris.emarsys.resolvers.EmarsysResolver;
import de.hybris.platform.category.model.CategoryModel;
import de.hybris.platform.commerceservices.url.impl.DefaultProductModelUrlResolver;
import de.hybris.platform.core.model.product.ProductModel;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *  Emarsys product category resolver
 */
public class EmarsysProductCategoryResolver extends DefaultProductModelUrlResolver implements EmarsysResolver<ProductModel> {
    private String delimiter;

    @Override
    public String resolve(ProductModel source) {
        ProductModel baseProduct = getBaseProduct(source);
        return buildPathString(getCategoryPath(baseProduct));
    }

    @Override
    public String resolve(ProductModel model, EmarsysPredictAvailabilityZoneModel availabilityZone) {
        return resolve(model);
    }

    @Override
    public Map<String, EmarsysResolver<ProductModel>> getResolvers() {
        return null;
    }

    protected String buildPathString(final List<CategoryModel> path){
        if (path == null || path.isEmpty()){
            return null;
        }
        return path.stream().map(CategoryModel::getName).collect(Collectors.joining(delimiter));
    }

    @Required
    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }
}

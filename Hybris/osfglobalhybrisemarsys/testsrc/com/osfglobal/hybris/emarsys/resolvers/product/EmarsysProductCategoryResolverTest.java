package com.osfglobal.hybris.emarsys.resolvers.product;

import de.hybris.platform.acceleratorservices.dataexport.googlelocal.model.Product;
import de.hybris.platform.category.model.CategoryModel;
import de.hybris.platform.commerceservices.url.impl.DefaultProductModelUrlResolver;
import de.hybris.platform.core.model.product.ProductModel;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.Spy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Roman on 22/11/2016.
 */
public class EmarsysProductCategoryResolverTest {
    @Spy
    private EmarsysProductCategoryResolver resolver = new EmarsysProductCategoryResolver() {
        @Override
        protected List<CategoryModel> getCategoryPath(final ProductModel product) {
            CategoryModel category1 = mock(CategoryModel.class);
            CategoryModel category2 = mock(CategoryModel.class);
            CategoryModel category3 = mock(CategoryModel.class);
            when(category1.getName()).thenReturn("category1");
            when(category2.getName()).thenReturn("category2");
            when(category3.getName()).thenReturn("category3");
            return Arrays.asList(category1, category2, category3);
        }
    };

    @Before
    public void setUp() throws Exception {
        resolver.setDelimiter("->");
    }

    @Test
    public void resolveTest() throws Exception {
        ProductModel product = mock(ProductModel.class);
        assertThat(resolver.resolve(product), is("category1->category2->category3"));
    }

}
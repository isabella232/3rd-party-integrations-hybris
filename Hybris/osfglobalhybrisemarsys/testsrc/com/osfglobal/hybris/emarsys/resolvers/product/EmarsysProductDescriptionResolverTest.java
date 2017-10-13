package com.osfglobal.hybris.emarsys.resolvers.product;

import de.hybris.platform.core.model.product.ProductModel;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Roman on 22/11/2016.
 */
public class EmarsysProductDescriptionResolverTest {
    private EmarsysProductDescriptionResolver resolver = new EmarsysProductDescriptionResolver();
    private ProductModel product;
    @Before
    public void setUp() throws Exception {

        product = mock(ProductModel.class);
        when(product.getDescription()).thenReturn("lorem <br> <div> ipsum");
    }

    @Test
    public void resolveStripTags() throws Exception {
        resolver.setStripTags(true);
        assertThat(resolver.resolve(product), is("lorem   ipsum"));
    }

}
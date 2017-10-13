package com.osfglobal.hybris.emarsys.dao;

import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import org.springframework.beans.factory.annotation.Required;

/**
 * Generic flexible search DAO
 */
public abstract class EmarsysAbstractFlexibleSearchDao {

    protected FlexibleSearchService flexibleSearchService;

    @Required
    public void setFlexibleSearchService(final FlexibleSearchService flexibleSearchService){
        this.flexibleSearchService = flexibleSearchService;
    }
}

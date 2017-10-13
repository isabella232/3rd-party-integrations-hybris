package com.osfglobal.hybris.emarsys.dao;

import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.SearchResult;

import java.util.List;

/**
 * Customer DAO
 */
public class EmarsysCustomerDao extends EmarsysAbstractFlexibleSearchDao {

    /**
     * Retrieve all customers
     * @return
     */
    public List<CustomerModel> getAllCustomers() {
        FlexibleSearchQuery searchQuery = new FlexibleSearchQuery(
                "SELECT {" + CustomerModel.PK + "} FROM {" + CustomerModel._TYPECODE + "}");
        SearchResult<CustomerModel> searchResult = flexibleSearchService.search(searchQuery);
        return searchResult.getResult();
    }

}

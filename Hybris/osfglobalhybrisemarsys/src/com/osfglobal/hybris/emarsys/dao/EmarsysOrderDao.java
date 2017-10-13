package com.osfglobal.hybris.emarsys.dao;

import de.hybris.platform.core.enums.DeliveryStatus;
import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.SearchResult;
import de.hybris.platform.site.BaseSiteService;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

/**
 * Order DAO
 */
public class EmarsysOrderDao extends EmarsysAbstractFlexibleSearchDao {

    private BaseSiteService baseSiteService;

    /**
     * Retrieve shipped orders
     * @return
     */
    public List<OrderModel> getShippedOrders() {
        FlexibleSearchQuery searchQuery = new FlexibleSearchQuery(
                "SELECT {" + OrderModel.PK + "} FROM {" + OrderModel._TYPECODE + " AS o" +
                        " LEFT JOIN " + DeliveryStatus._TYPECODE + " AS ds ON {o.deliveryStatus} = {ds.pk}}" +
                        " WHERE {o.site} = ?site AND {ds.code} = ?deliveryStatus AND ({o.isSentEmail} = FALSE OR {o.isSentEmail} IS NULL)"
        );
        searchQuery.addQueryParameter("deliveryStatus", DeliveryStatus.SHIPPED.getCode());
        searchQuery.addQueryParameter("site", baseSiteService.getCurrentBaseSite());
        SearchResult<OrderModel> searchResult = flexibleSearchService.search(searchQuery);
        return searchResult.getResult();
    }
    @Required
    public void setBaseSiteService(BaseSiteService baseSiteService) {
        this.baseSiteService = baseSiteService;
    }
}

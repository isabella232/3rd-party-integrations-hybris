package com.osfglobal.hybris.emarsys.services.impl;

import de.hybris.platform.basecommerce.model.site.BaseSiteModel;
import de.hybris.platform.core.model.order.OrderEntryModel;
import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.osfglobal.hybris.emarsys.services.EmarsysBaseService;
import com.osfglobal.hybris.emarsys.services.EmarsysSmartInsightService;

import java.util.Date;
import java.util.List;

/**
 * Emarsys Smart Insight Service class
 */
public class EmarsysSmartInsightServiceImpl extends EmarsysBaseService implements EmarsysSmartInsightService{
    private Logger LOGGER = LoggerFactory.getLogger(EmarsysSmartInsightServiceImpl.class);

    @Override
    public List<OrderModel> getOrdersBySiteAndPeriod(BaseSiteModel site, Date startDate, Date endDate) {
        FlexibleSearchQuery searchQuery = new FlexibleSearchQuery(
                "SELECT {" + OrderModel.PK + "} FROM {" + OrderModel._TYPECODE + " AS o}" +
                        "WHERE {o." + OrderModel.SITE + "} = ?site " +
                        "AND {o." + OrderModel.DATE + "} >= ?startDate " +
                        "AND {o." + OrderModel.DATE + "} <=?endDate");

        LOGGER.debug("getOrdersBySiteAndPeriod() query: {}", searchQuery.getQuery());

        searchQuery.addQueryParameter("site", site);
        searchQuery.addQueryParameter("startDate", startDate);
        searchQuery.addQueryParameter("endDate", endDate);
        return flexibleSearchService.<OrderModel>search(searchQuery).getResult();
    }

    @Override
    public List<OrderEntryModel> getOrderEntriesBySiteAndPeriod(BaseSiteModel site, Date startDate, Date endDate) {
        FlexibleSearchQuery searchQuery = new FlexibleSearchQuery(
                "SELECT {e." + OrderEntryModel.PK + "} FROM {" + OrderEntryModel._TYPECODE + " AS e " +
                        "LEFT JOIN " + OrderModel._TYPECODE + " AS o ON {e." + OrderEntryModel.ORDER + "}={o." + OrderModel.PK + "} " +
                        "LEFT JOIN " + ProductModel._TYPECODE + " AS p ON {e." + OrderEntryModel.PRODUCT + "}={p." + ProductModel.PK + "}" +
                        "LEFT JOIN " + UserModel._TYPECODE + " AS u ON {o." + OrderModel.PLACEDBY + "}={u." + UserModel.PK + "}}" +
                        "WHERE {o." + OrderModel.SITE + "} = ?site " +
                            "AND {o." + OrderModel.DATE + "} >= ?startDate " +
                            "AND {o." + OrderModel.DATE + "} <=?endDate");

        LOGGER.debug("getOrderEntriesBySiteAndPeriod() query: {}", searchQuery.getQuery());

        searchQuery.addQueryParameter("site", site);
        searchQuery.addQueryParameter("startDate", startDate);
        searchQuery.addQueryParameter("endDate", endDate);

        return flexibleSearchService.<OrderEntryModel>search(searchQuery).getResult();
    }
}

package com.osfglobal.hybris.emarsys.services;

import de.hybris.platform.basecommerce.model.site.BaseSiteModel;
import de.hybris.platform.core.model.order.OrderEntryModel;
import de.hybris.platform.core.model.order.OrderModel;

import java.util.Date;
import java.util.List;

/**
 * Emarsys Smart Insight Service
 */
public interface EmarsysSmartInsightService {
    List<OrderModel> getOrdersBySiteAndPeriod(BaseSiteModel site, Date startDate, Date endDate);
    List<OrderEntryModel> getOrderEntriesBySiteAndPeriod(BaseSiteModel site, Date startDate, Date endDate);
}

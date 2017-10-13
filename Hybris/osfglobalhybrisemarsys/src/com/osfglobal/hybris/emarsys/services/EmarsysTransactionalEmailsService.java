package com.osfglobal.hybris.emarsys.services;

import de.hybris.platform.core.model.order.OrderModel;

import java.util.List;

public interface EmarsysTransactionalEmailsService {
    List<OrderModel> getShippedOrders();
    void sendEmail(OrderModel order);
}

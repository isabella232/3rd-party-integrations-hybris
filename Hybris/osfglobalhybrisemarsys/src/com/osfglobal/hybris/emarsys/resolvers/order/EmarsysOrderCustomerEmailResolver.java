package com.osfglobal.hybris.emarsys.resolvers.order;

import com.osfglobal.hybris.emarsys.core.model.EmarsysPredictAvailabilityZoneModel;
import com.osfglobal.hybris.emarsys.resolvers.EmarsysResolver;
import de.hybris.platform.commerceservices.customer.CustomerEmailResolutionService;
import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.core.model.user.CustomerModel;
import org.springframework.beans.factory.annotation.Required;

import java.util.Map;

/**
 * Emarsys order customer email resolver
 */
public class EmarsysOrderCustomerEmailResolver implements EmarsysResolver<OrderModel> {
    private CustomerEmailResolutionService customerEmailResolutionService;

    @Override
    public String resolve(OrderModel model, EmarsysPredictAvailabilityZoneModel availabilityZone) {
        return resolve(model);
    }

    @Override
    public String resolve(OrderModel order) {
        return customerEmailResolutionService.getEmailForCustomer((CustomerModel) order.getUser());
    }

    @Override
    public Map<String, EmarsysResolver<OrderModel>> getResolvers() {
        return null;
    }

    @Required
    public void setCustomerEmailResolutionService(CustomerEmailResolutionService customerEmailResolutionService) {
        this.customerEmailResolutionService = customerEmailResolutionService;
    }
}

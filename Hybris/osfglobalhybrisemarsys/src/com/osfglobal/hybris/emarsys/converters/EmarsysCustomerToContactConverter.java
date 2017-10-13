package com.osfglobal.hybris.emarsys.converters;

import com.osfglobal.emarsys.client.Contact;
import com.osfglobal.hybris.emarsys.services.enums.EmarsysSalutation;
import com.osfglobal.hybris.emarsys.services.enums.EmarsysTitle;
import de.hybris.platform.commerceservices.customer.CustomerEmailResolutionService;
import de.hybris.platform.commerceservices.strategies.CustomerNameStrategy;
import de.hybris.platform.converters.impl.AbstractPopulatingConverter;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.core.model.user.TitleModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.util.Assert;

public class EmarsysCustomerToContactConverter extends AbstractPopulatingConverter<CustomerModel,Contact> {

    private CustomerNameStrategy customerNameStrategy;
    private CustomerEmailResolutionService customerEmailResolutionService;

    @Override
    public void populate(CustomerModel source, Contact target) throws ConversionException {
        Assert.notNull(source, "Parameter source cannot be null.");
        Assert.notNull(target, "Parameter target cannot be null.");

        final String[] names = customerNameStrategy.splitName(source.getName());
        if (names != null){
            target.setFirstName(names[0]);
            target.setLastName(names[1]);
        }

        final TitleModel title = source.getTitle();
        if (title != null){
            String titleCode = title.getCode();
            target.setTitle(EmarsysTitle.fromTitleCode(titleCode).getTitle());
            String salutationId = EmarsysSalutation.fromTitleCode(titleCode).getSalutationId();
            target.setGender(salutationId);
            target.setSalutation(salutationId);
        }

        target.setEmail(customerEmailResolutionService.getEmailForCustomer(source));
    }
    @Required
    public void setCustomerNameStrategy(CustomerNameStrategy customerNameStrategy) {
        this.customerNameStrategy = customerNameStrategy;
    }
    @Required
    public void setCustomerEmailResolutionService(CustomerEmailResolutionService customerEmailResolutionService) {
        this.customerEmailResolutionService = customerEmailResolutionService;
    }
}

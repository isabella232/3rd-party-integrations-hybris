package com.osfglobal.hybris.emarsys.listeners;

import com.osfglobal.hybris.emarsys.services.EmarsysTransactionalEmailsService;
import com.osfglobal.hybris.emarsys.services.exceptions.EmarsysServiceException;
import de.hybris.platform.commerceservices.event.AbstractSiteEventListener;
import de.hybris.platform.order.events.SubmitOrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Required;

public class OrderConfirmationEventListener extends AbstractSiteEventListener<SubmitOrderEvent> {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderConfirmationEventListener.class);
    private EmarsysTransactionalEmailsService emarsysOrderTransactionalEmailsService;

    @Override
    protected void onSiteEvent(SubmitOrderEvent event) {
        try {
            LOGGER.info("EMARSYS: Begin order confirmation mail");
            emarsysOrderTransactionalEmailsService.sendEmail(event.getOrder());
            LOGGER.info("EMARSYS: Finish order confirmation mail");
        } catch (EmarsysServiceException e) {
            LOGGER.error("EMARSYS: Fail order confirmation mail: " + e.getMessage(), e);
        }
    }

    @Override
    protected boolean shouldHandleEvent(SubmitOrderEvent event) {
        return true;
    }

    @Required
    public void setEmarsysOrderTransactionalEmailsService(EmarsysTransactionalEmailsService emarsysOrderTransactionalEmailsService) {
        this.emarsysOrderTransactionalEmailsService = emarsysOrderTransactionalEmailsService;
    }
}

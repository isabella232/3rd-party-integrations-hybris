package com.osfglobal.hybris.emarsys.cronjobs;

import com.osfglobal.hybris.emarsys.model.EmarsysSendShippedEmailCronJobModel;
import com.osfglobal.hybris.emarsys.services.EmarsysTransactionalEmailsService;
import de.hybris.platform.basecommerce.model.site.BaseSiteModel;
import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable;
import de.hybris.platform.servicelayer.cronjob.PerformResult;
import de.hybris.platform.servicelayer.exceptions.SystemException;
import de.hybris.platform.site.BaseSiteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;


public class EmarsysSendShippedEmailJob extends AbstractJobPerformable<EmarsysSendShippedEmailCronJobModel> {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmarsysSendShippedEmailJob.class);
    private EmarsysTransactionalEmailsService emarsysOrderShippedTransactionalEmailsService;
    private BaseSiteService baseSiteService;

    @Override
    public PerformResult perform(EmarsysSendShippedEmailCronJobModel cronJob) {
        LOGGER.info("EmarsysSendShippedEmailJob -> start...");
        BaseSiteModel baseSite = cronJob.getBaseSite();
        baseSiteService.setCurrentBaseSite(baseSite, true);
        LOGGER.debug("baseSite: {}", baseSite.getName());
        List<OrderModel> shippedOrders = emarsysOrderShippedTransactionalEmailsService.getShippedOrders();
        LOGGER.info(shippedOrders.size() + " shipped orders to inform by email");
        for (OrderModel order : shippedOrders) {
            try {
                emarsysOrderShippedTransactionalEmailsService.sendEmail(order);
                order.setIsSentEmail(Boolean.TRUE);
                modelService.save(order);
            } catch (SystemException se) {
                LOGGER.error("an error occurred while processing your request", se);
            }
        }
        LOGGER.info("EmarsysSendShippedEmailJob -> finished...");
        return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
    }
    @Required
    public void setBaseSiteService(BaseSiteService baseSiteService) {
        this.baseSiteService = baseSiteService;
    }

    @Required
    public void setEmarsysOrderShippedTransactionalEmailsService(EmarsysTransactionalEmailsService emarsysOrderShippedTransactionalEmailsService) {
        this.emarsysOrderShippedTransactionalEmailsService = emarsysOrderShippedTransactionalEmailsService;
    }
}

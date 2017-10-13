package com.osfglobal.hybris.emarsys;

import com.osfglobal.emarsys.client.Event;
import com.osfglobal.hybris.emarsys.enums.EmarsysExternalEventsEnum;
import com.osfglobal.hybris.emarsys.model.EmarsysExternalEventsListCronJobModel;
import com.osfglobal.hybris.emarsys.services.EmarsysService;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.enumeration.EnumerationMetaTypeModel;
import de.hybris.platform.core.model.enumeration.EnumerationValueModel;
import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.enumeration.EnumerationService;
import de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable;
import de.hybris.platform.servicelayer.cronjob.PerformResult;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.type.TypeService;
import de.hybris.platform.tx.Transaction;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * Cronjob to get external events list and save in the database
 */
public class EmarsysExternalEventsListJob extends AbstractJobPerformable<EmarsysExternalEventsListCronJobModel> {

    private static final Logger LOGGER = Logger.getLogger(EmarsysExternalEventsListJob.class);

    private EmarsysService emarsysService;

    private ModelService modelService;

    private TypeService typeService;

    @Override
    public PerformResult perform(EmarsysExternalEventsListCronJobModel cronJob) {
        LOGGER.info("EmarsysGetExternalEventsJob::perform-start");
        EnumerationMetaTypeModel allExternalEventsFromDB = typeService.getEnumerationTypeForCode("EmarsysExternalEventsEnum");
        LOGGER.info("EmarsysGetExternalEventsJob::perform-end::remove all external events from the database");
        List<Event> externalEventsFromEmarsys = emarsysService.getExternalEventsFromEmarsys(cronJob.getBaseSite());
        processEvents(allExternalEventsFromDB, externalEventsFromEmarsys);
        return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
    }

    private void processEvents(EnumerationMetaTypeModel allExternalEventsFromDB, List<Event> externalEventsFromEmarsys){

        int counter = 0;
        //remove no longer existing events
        for (ItemModel existingEvent: allExternalEventsFromDB.getValues()) {
            if(isNeedsToBeRemoved(existingEvent, externalEventsFromEmarsys)){
                modelService.remove(existingEvent);
                counter++;
            }
        }
        LOGGER.info("EmarsysGetExternalEventsJob::perform-end:: " + counter + " events removed");
        counter = 0;
        //create new events
        for (Event eventFromEmarsy : externalEventsFromEmarsys) {
            if (isNeedsToBeCreated(eventFromEmarsy, allExternalEventsFromDB)){
                EmarsysExternalEventsEnum newEvent = EmarsysExternalEventsEnum.valueOf(eventFromEmarsy.getName());
                modelService.create("EmarsysExternalEventsEnum");
                modelService.save(newEvent);
                counter++;
            }
        }
        LOGGER.info("EmarsysGetExternalEventsJob::perform-end:: " + counter +  " events created");
    }

    private boolean isNeedsToBeCreated(Event eventFromEmarsys, EnumerationMetaTypeModel allExternalEventsFromDB) {
        for (ItemModel exisingEvent : allExternalEventsFromDB.getValues()) {
            if(eventFromEmarsys.getName().equalsIgnoreCase(((EnumerationValueModel) exisingEvent).getCode())){
                return false;
            }
        }
        return true;
    }

    private boolean isNeedsToBeRemoved(ItemModel existingEvent, List<Event> externalEventsFromEmarsys) {
        for (Event eventFromEmarsys : externalEventsFromEmarsys) {
            if(eventFromEmarsys.getName().equalsIgnoreCase(((EnumerationValueModel) existingEvent).getCode())){
                return false;
            }
        }
        return true;
    }

    @Required
    public void setEmarsysService(EmarsysService emarsysService) {
        this.emarsysService = emarsysService;
    }

    @Required
    public void setModelService(final ModelService modelService)
    {
        this.modelService = modelService;
    }

    @Required
    public void setTypeService(TypeService typeService) {
        this.typeService = typeService;
    }
}

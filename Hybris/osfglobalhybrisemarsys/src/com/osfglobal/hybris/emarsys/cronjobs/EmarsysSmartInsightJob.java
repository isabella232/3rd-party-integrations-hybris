package com.osfglobal.hybris.emarsys.cronjobs;

import com.osfglobal.emarsys.client.beans.EmarsysDynamicDTO;
import com.osfglobal.emarsys.client.beans.SftpConfig;
import com.osfglobal.hybris.emarsys.core.model.EmarsysSmartInsightMappingModel;
import com.osfglobal.hybris.emarsys.core.model.EmarsysSmartInsightModel;
import com.osfglobal.hybris.emarsys.model.EmarsysSmartInsightCronJobModel;
import com.osfglobal.hybris.emarsys.services.EmarsysSmartInsightService;
import com.osfglobal.hybris.emarsys.services.exceptions.EmarsysServiceException;

import de.hybris.platform.basecommerce.model.site.BaseSiteModel;
import de.hybris.platform.converters.Converters;
import de.hybris.platform.core.model.order.OrderEntryModel;
import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.servicelayer.cronjob.PerformResult;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Required;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Cronjob to get products catalog and export to a csv file
 */
public class EmarsysSmartInsightJob extends EmarsysSftpJob<EmarsysSmartInsightCronJobModel> {
    private static final String DATETIME_FORMAT = "yyyyMMddHHmmss";
    private static final Logger LOGGER = LoggerFactory.getLogger(EmarsysSmartInsightJob.class);
    private EmarsysSmartInsightService emarsysSmartInsightService;
    private Converter<OrderEntryModel, EmarsysDynamicDTO> emarsysSmartInsightConverter;

    @Override
    public PerformResult perform(EmarsysSmartInsightCronJobModel job) {
        BaseSiteModel baseSite = job.getBaseSite();
        EmarsysSmartInsightModel emarsysSmartInsight = baseSite.getEmarsysSmartInsight();
        if (emarsysSmartInsight.getEnableSmartInsight()) {
            baseSiteService.setCurrentBaseSite(baseSite, true);
            LOGGER.debug("baseSite: {}", baseSite.getName());

            Date startDate = emarsysSmartInsight.getStartDate();
            Date endDate = emarsysSmartInsight.getEndDate();
            if (BooleanUtils.isNotTrue(emarsysSmartInsight.getEnableSmartInsightTimeframe()) || startDate == null || endDate == null) {
                //use default timeframe(24h) if the dates are not set
                endDate = new Date();
                startDate = DateUtils.addDays(endDate, -1);
            }
            LOGGER.debug("startDate: {}, endDate: {}", startDate, endDate);
            String csvData = getCsvString(baseSite, startDate, endDate);
            String filename = getFilename(baseSite);
            SftpConfig smartInsightConfig = emarsysConfig.getEmarsysClientConfig(baseSite).getSmartInsightConfig();
            try {
                emarsysSftpService.uploadCsvDataToSftp(csvData, filename, smartInsightConfig);
            } catch (EmarsysServiceException e) {
                LOGGER.error(e.getMessage(), e);
                return new PerformResult(CronJobResult.ERROR, CronJobStatus.ABORTED);
            }
        }else {
            LOGGER.warn("SmartInsight was not activated");
        }

        return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
    }


    private String getCsvString(BaseSiteModel baseSite, Date startDate, Date endDate) {
        List<OrderEntryModel> ordersEntries = emarsysSmartInsightService
                .getOrderEntriesBySiteAndPeriod(baseSite, startDate, endDate);
        LOGGER.info("Orders entries about to export count: {}", ordersEntries.size());
        List<EmarsysDynamicDTO> emarsysOrderEntries = Converters.convertAll(ordersEntries, emarsysSmartInsightConverter);
        return emarsysSftpService.prepareCsvData(emarsysOrderEntries, getCsvHeaders(baseSite.getEmarsysSmartInsight()));
    }

    private List<String> getCsvHeaders(EmarsysSmartInsightModel emarsysSmartInsight) {
        return emarsysSmartInsight
                .getEmarsysSmartInsightMappings()
                .stream()
                .map(EmarsysSmartInsightMappingModel::getEmarsysPlaceholder)
                .collect(Collectors.toList());
    }

    @Override
    protected String getFilename(BaseSiteModel baseSite) {
        String datetime = DateFormatUtils.format(new Date(), DATETIME_FORMAT);
        return String.format(filenamePattern, datetime, baseSite.getUid());
    }

    @Required
    public void setEmarsysSmartInsightService(EmarsysSmartInsightService emarsysSmartInsightService) {
        this.emarsysSmartInsightService = emarsysSmartInsightService;
    }

    @Required
    public void setEmarsysSmartInsightConverter(Converter<OrderEntryModel, EmarsysDynamicDTO> emarsysSmartInsightConverter) {
        this.emarsysSmartInsightConverter = emarsysSmartInsightConverter;
    }

    public void setFilenamePattern(String filenamePattern) {
        this.filenamePattern = filenamePattern;
    }
}

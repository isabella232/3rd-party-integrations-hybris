package com.osfglobal.hybris.emarsys.cronjobs;

import com.osfglobal.emarsys.client.beans.EmarsysDynamicDTO;
import com.osfglobal.emarsys.client.beans.SftpConfig;
import com.osfglobal.hybris.emarsys.core.model.EmarsysPredictModel;
import com.osfglobal.hybris.emarsys.enums.EmarsysPredictExportTypeEnum;
import com.osfglobal.hybris.emarsys.model.EmarsysPredictCronJobModel;
import com.osfglobal.hybris.emarsys.services.EmarsysPredictService;
import com.osfglobal.hybris.emarsys.services.exceptions.EmarsysServiceException;

import de.hybris.platform.basecommerce.model.site.BaseSiteModel;
import de.hybris.platform.converters.Converters;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.servicelayer.cronjob.PerformResult;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Cronjob to get products catalog and export to a csv file
 */
public class EmarsysPredictJob extends EmarsysSftpJob<EmarsysPredictCronJobModel> {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmarsysPredictJob.class);
    private EmarsysPredictService emarsysPredictService;
    private Converter<ProductModel, EmarsysDynamicDTO> emarsysPredictConverter;

    @Override
    public PerformResult perform(EmarsysPredictCronJobModel job) {
        BaseSiteModel baseSite = job.getBaseSite();
        baseSiteService.setCurrentBaseSite(baseSite, true);
        LOGGER.debug("baseSite: {}", baseSite.getName());

        EmarsysPredictModel emarsysPredict = baseSite.getEmarsysPredict();
        EmarsysPredictExportTypeEnum exportType = emarsysPredict.getExportType();

        List<ProductModel> products = emarsysPredictService.getAllProductsOnline(exportType);
        List<EmarsysDynamicDTO> emarsysProducts = Converters.convertAll(products, emarsysPredictConverter);
        LOGGER.info("products about to import count: {}", products.size());

        SftpConfig predictConfig = getEmarsysClientConfig(baseSite).getPredictConfig();
        String csvData = emarsysSftpService.prepareCsvData(emarsysProducts, getCsvHeaders(emarsysPredict));
        String filename = String.format(filenamePattern, baseSite.getUid());
        try {
            emarsysSftpService.uploadCsvDataToSftp(csvData, filename, predictConfig);
        } catch (EmarsysServiceException e) {
            LOGGER.error(e.getMessage(), e);
            return new PerformResult(CronJobResult.ERROR, CronJobStatus.ABORTED);
        }
        return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
    }

    private List<String> getCsvHeaders(EmarsysPredictModel emarsysPredict) {
        return emarsysPredict
                .getEmarsysPredictMappings()
                .stream()
                .map(m->m.getEmarsysPlaceholder().toString())
                .collect(Collectors.toList());
    }

    @Required
    public void setFilenamePattern(String filenamePattern){
        super.filenamePattern = filenamePattern;
    }


    @Required
    public void setEmarsysPredictService(EmarsysPredictService emarsysPredictService) {
        this.emarsysPredictService = emarsysPredictService;
    }


    @Required
    public void setEmarsysPredictConverter(Converter<ProductModel, EmarsysDynamicDTO> emarsysPredictConverter) {
        this.emarsysPredictConverter = emarsysPredictConverter;
    }
}

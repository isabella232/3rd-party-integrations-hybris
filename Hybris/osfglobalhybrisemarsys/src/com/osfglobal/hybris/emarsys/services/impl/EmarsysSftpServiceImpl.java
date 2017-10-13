package com.osfglobal.hybris.emarsys.services.impl;

import com.osfglobal.emarsys.client.beans.EmarsysDynamicDTO;
import com.osfglobal.emarsys.client.beans.SftpConfig;
import com.osfglobal.emarsys.client.converters.EmarsysDynamicDtoToCSVConverter;
import com.osfglobal.emarsys.client.exceptions.EmarsysClientException;
import com.osfglobal.hybris.emarsys.services.EmarsysBaseService;
import com.osfglobal.hybris.emarsys.services.EmarsysSftpService;
import com.osfglobal.hybris.emarsys.services.exceptions.EmarsysServiceException;

import de.hybris.platform.basecommerce.model.site.BaseSiteModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Emarsys SFTP service class
 */
public class EmarsysSftpServiceImpl extends EmarsysBaseService implements EmarsysSftpService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmarsysSftpServiceImpl.class);

    @Override
    public <T extends EmarsysDynamicDTO> String prepareCsvData(List<T> data, List<String> headers) throws EmarsysServiceException {
        return new EmarsysDynamicDtoToCSVConverter<T>().convert(data, headers);
    }
    @Override
    public void uploadCsvDataToSftp(String csvData, String filename, SftpConfig config) throws EmarsysServiceException {
        BaseSiteModel site = baseSiteService.getCurrentBaseSite();
        LOGGER.debug("uploadDataToSFTP() for site: {}, filename: {}", site.getName(), filename);
        try {
            getEmarsysClient(site).uploadCsvDataToSftp(csvData, filename, config);
        } catch (EmarsysClientException e) {
            throw new EmarsysServiceException(e.getMessage(), e);
        }
    }
}

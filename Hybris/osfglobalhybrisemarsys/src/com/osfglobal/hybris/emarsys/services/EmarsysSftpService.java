package com.osfglobal.hybris.emarsys.services;

import com.osfglobal.emarsys.client.beans.EmarsysDynamicDTO;
import com.osfglobal.emarsys.client.beans.SftpConfig;
import com.osfglobal.hybris.emarsys.services.exceptions.EmarsysServiceException;

import java.util.List;

/**
 * Emarsys SFTP service
 */
public interface EmarsysSftpService {
     <T extends EmarsysDynamicDTO> String prepareCsvData(List<T> data, List<String> headers) throws EmarsysServiceException;
     void uploadCsvDataToSftp(String data, String filename, SftpConfig config) throws EmarsysServiceException;
}

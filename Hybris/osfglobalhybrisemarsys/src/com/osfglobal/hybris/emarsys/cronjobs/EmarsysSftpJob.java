package com.osfglobal.hybris.emarsys.cronjobs;

import com.osfglobal.emarsys.client.beans.EmarsysClientConfig;
import com.osfglobal.hybris.emarsys.model.EmarsysCronJobModel;
import com.osfglobal.hybris.emarsys.services.EmarsysConfig;
import com.osfglobal.hybris.emarsys.services.EmarsysSftpService;
import de.hybris.platform.basecommerce.model.site.BaseSiteModel;
import de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable;
import de.hybris.platform.servicelayer.cronjob.PerformResult;
import de.hybris.platform.site.BaseSiteService;
import org.springframework.beans.factory.annotation.Required;

/**
 * Emarsys abstract job
 */
public abstract class EmarsysSftpJob<T extends EmarsysCronJobModel> extends AbstractJobPerformable<T> {
    protected String filenamePattern;
    protected BaseSiteService baseSiteService;
    protected EmarsysSftpService emarsysSftpService;
    protected EmarsysConfig emarsysConfig;

    protected EmarsysClientConfig getEmarsysClientConfig(BaseSiteModel baseSite) {
        return emarsysConfig.getEmarsysClientConfig(baseSite);
    }

    protected String getFilename(BaseSiteModel baseSite) {
        return String.format(filenamePattern, baseSite.getUid());
    }

    public abstract PerformResult perform(T emarsysPredictCronJobModel);


    @Required
    public void setBaseSiteService(BaseSiteService baseSiteService) {
        this.baseSiteService = baseSiteService;
    }

    @Required
    public void setEmarsysSftpService(EmarsysSftpService emarsysSftpService) {
        this.emarsysSftpService = emarsysSftpService;
    }
    @Required
    public void setEmarsysConfig(EmarsysConfig emarsysConfig) {
        this.emarsysConfig = emarsysConfig;
    }



}

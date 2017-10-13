package com.osfglobal.hybris.emarsys.services.impl;

import com.osfglobal.hybris.emarsys.services.EmarsysSmartInsightService;
import de.hybris.platform.basecommerce.model.site.BaseSiteModel;
import de.hybris.platform.servicelayer.ServicelayerTransactionalTest;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.site.BaseSiteService;
import org.apache.commons.lang.time.DateUtils;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.Resource;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Roman on 21/11/2016.
 */
public class EmarsysSmartInsightServiceImplTest extends ServicelayerTransactionalTest {

    @Resource
    private EmarsysSmartInsightService smartInsightService;

    @Resource
    private BaseSiteService baseSiteService;

    @Resource
    private ModelService modelService;

    private BaseSiteModel siteModel;

    @Before
    public void setUp(){
        siteModel = baseSiteService.getBaseSiteForUID("electronics");
    }


    @Test
    public void getOrdersBySiteAndPeriod() throws Exception {
        BaseSiteModel siteModel = baseSiteService.getBaseSiteForUID("electronics");
        System.out.println(siteModel);
        smartInsightService.getOrdersBySiteAndPeriod(siteModel, DateUtils.addDays(new Date(), -2), new Date());
    }

    @Test
    public void getOrderEntriesBySiteAndPeriod() throws Exception {

    }

}
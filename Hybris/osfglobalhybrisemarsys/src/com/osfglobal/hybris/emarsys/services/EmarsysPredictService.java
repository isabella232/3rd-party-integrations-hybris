package com.osfglobal.hybris.emarsys.services;

import com.osfglobal.hybris.emarsys.core.model.EmarsysPredictAvailabilityZoneModel;
import com.osfglobal.hybris.emarsys.enums.EmarsysPredictExportTypeEnum;

import de.hybris.platform.core.model.c2l.CurrencyModel;
import de.hybris.platform.core.model.c2l.LanguageModel;
import de.hybris.platform.core.model.product.ProductModel;

import java.util.List;

/**
 * Emarsys Predict service interface
 */
public interface EmarsysPredictService {
    List<ProductModel> getAllProductsOnline(EmarsysPredictExportTypeEnum exportType);

	EmarsysPredictAvailabilityZoneModel getAvailabilityZone(LanguageModel currentLanguage,
			CurrencyModel currentCurrency);
	String getEmailForPredictWidget();
}

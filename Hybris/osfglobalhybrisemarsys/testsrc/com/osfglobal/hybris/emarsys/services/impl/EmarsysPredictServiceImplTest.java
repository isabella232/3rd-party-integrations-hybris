package com.osfglobal.hybris.emarsys.services.impl;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyMap;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import com.osfglobal.hybris.emarsys.core.model.EmarsysPredictAvailabilityZoneModel;
import com.osfglobal.hybris.emarsys.services.impl.EmarsysPredictServiceImpl;
import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.core.model.c2l.CurrencyModel;
import de.hybris.platform.core.model.c2l.LanguageModel;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;

@UnitTest
public class EmarsysPredictServiceImplTest
{
	@Mock
	FlexibleSearchService flexibleSearchServiceMock;
	@Mock
	private SearchResult searchResultMock;

	private EmarsysPredictServiceImpl emarsysPredictService;
	private EmarsysPredictAvailabilityZoneModel availabilityZone;

	@Before
	public void setUp()
	{

		MockitoAnnotations.initMocks(this);
		emarsysPredictService = new EmarsysPredictServiceImpl();
		emarsysPredictService.setFlexibleSearchService(flexibleSearchServiceMock);




		availabilityZone = new EmarsysPredictAvailabilityZoneModel();
		availabilityZone.setName("DEEUR");
	}

	@Test
	public void getAvailabilityZoneTest()
	{
		LanguageModel currentLanguage = new LanguageModel();
		CurrencyModel currentCurrency = new CurrencyModel();
		currentLanguage.setIsocode("DE");
		currentCurrency.setIsocode("EUR");
		initGivens(currentLanguage, currentCurrency);
		given(searchResultMock.getResult()).willReturn(Collections.EMPTY_LIST);
		

	}

	/**
	 * @param currentLanguage
	 * @param currentCurrency
	 */
	private void initGivens(LanguageModel currentLanguage, CurrencyModel currentCurrency)
	{
		final List resultingListMock = mock(List.class);
		given(Integer.valueOf(resultingListMock.size())).willReturn(Integer.valueOf(1));
		given(resultingListMock.get(0)).willReturn(availabilityZone);
		given(searchResultMock.getResult()).willReturn(resultingListMock);
		given(flexibleSearchServiceMock.search(anyString(), anyMap())).willReturn(searchResultMock);
		given(searchResultMock.getResult()).willReturn(Arrays.asList(availabilityZone));
		Assert.assertEquals("DEEUR", emarsysPredictService.getAvailabilityZone(currentLanguage, currentCurrency).getName());
	}

}

/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2015 hybris AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 *
 *  
 */
package com.osfglobal.hybris.emarsys.converters.populators;

import de.hybris.platform.commercefacades.order.data.OrderEntryData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.order.AbstractOrderEntryModel;


import org.springframework.util.Assert;

import com.osfglobal.hybris.emarsys.utils.EmarsysFormatterUtils;


/**
 * Converter for converting order / cart entries
 */
public class OrderEntryBasePriceRoundedPopulator implements Populator<AbstractOrderEntryModel, OrderEntryData>
{

	private EmarsysFormatterUtils emarsysFormatterUtils;
	@Override
	public void populate(final AbstractOrderEntryModel source, final OrderEntryData target)
	{
		Assert.notNull(source, "Order Entry Should not be null");
		Assert.notNull(target, "Order Entry  Data Should not be null");
		
		target.setRoundedBasePrice(
				emarsysFormatterUtils.doubleToString(target.getBasePrice().getValue().doubleValue()));

	}

	/**
	 * @return the emarsysFormatterUtils
	 */
	public EmarsysFormatterUtils getEmarsysFormatterUtils() {
		return emarsysFormatterUtils;
	}

	/**
	 * @param emarsysFormatterUtils
	 *            the emarsysFormatterUtils to set
	 */
	public void setEmarsysFormatterUtils(EmarsysFormatterUtils emarsysFormatterUtils) {
		this.emarsysFormatterUtils = emarsysFormatterUtils;
	}


}

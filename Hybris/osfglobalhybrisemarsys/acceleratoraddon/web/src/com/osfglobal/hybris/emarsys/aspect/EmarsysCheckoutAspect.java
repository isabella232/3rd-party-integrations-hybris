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
package com.osfglobal.hybris.emarsys.aspect;

import com.osfglobal.hybris.emarsys.facades.EmarsysSubscriptionFacade;
import de.hybris.platform.commercefacades.order.CheckoutFacade;
import de.hybris.platform.commercefacades.user.data.AddressData;
import de.hybris.platform.core.Registry;
import de.hybris.platform.core.TenantAwareThreadFactory;
import de.hybris.platform.jalo.JaloSession;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.PredicateUtils;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class EmarsysCheckoutAspect
{
	private EmarsysSubscriptionFacade emarsysSubscriptionFacade;
	private String emailFieldName;
	private String forceOptinFieldName;

	protected static final Logger LOG = LoggerFactory.getLogger(EmarsysCheckoutAspect.class);
	private CheckoutFacade checkoutFacade;

	public Object advise(final ProceedingJoinPoint joinPoint) throws Throwable
	{
		// Access the request to get opting value
		final List<Object> args = Arrays.asList(joinPoint.getArgs());
		HttpServletRequest request = (HttpServletRequest) CollectionUtils.find(args,
				PredicateUtils.instanceofPredicate(HttpServletRequest.class));
		final BindingResult bindingResult = (BindingResult) CollectionUtils.find(args,
				PredicateUtils.instanceofPredicate(BindingResult.class));

		if (request == null && RequestContextHolder.getRequestAttributes() instanceof ServletRequestAttributes)
		{
			final ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			request = requestAttributes.getRequest();
		}
		// Proceed if only needed params are not empty and no error on the form
		if (request != null)
		{
			String email = request.getParameter(emailFieldName);
			if (StringUtils.isNotEmpty(email) && CollectionUtils.isEmpty(bindingResult.getAllErrors()))
			{
				Boolean forceOptIn = Boolean.valueOf(request.getParameter(forceOptinFieldName));
				AddressData deliveryAddress = checkoutFacade.getCheckoutCart().getDeliveryAddress();
				runAsyncSubscription(email, forceOptIn, deliveryAddress);
			}

		}
		return joinPoint.proceed();
	}

	public void adviseBefore(final JoinPoint joinPoint) throws Throwable
	{
		final List<Object> args = Arrays.asList(joinPoint.getArgs());
		HttpServletRequest request = (HttpServletRequest) CollectionUtils.find(args,
				PredicateUtils.instanceofPredicate(HttpServletRequest.class));

		String email = request.getParameter(emailFieldName);
		Boolean forceOptIn = Boolean.valueOf(request.getParameter(forceOptinFieldName));
		AddressData deliveryAddress = checkoutFacade.getCheckoutCart().getDeliveryAddress();
		runAsyncSubscription(email, forceOptIn, deliveryAddress);

	}

	protected void runAsyncSubscription(String email, Boolean forceOptIn, AddressData deliveryAddress)
	{
		// We need session inside thread. Hybris Jalo Session will be last if we
		// use a standard Runnable
		TenantAwareThreadFactory threadFactory = new TenantAwareThreadFactory(Registry.getCurrentTenant(),
				JaloSession.getCurrentSession());

		final ExecutorService executorService = Executors.newSingleThreadExecutor();

		Runnable tenatAwareTask = threadFactory
				.newThread(() -> emarsysSubscriptionFacade.addToNewsletterListFromCheckout(email, forceOptIn, deliveryAddress));
		Future<?> future = executorService.submit(tenatAwareTask);
		try
		{
			future.get();
		}
		catch (ExecutionException | InterruptedException e)
		{
			LOG.error(e.getMessage(), e);
		}
		executorService.shutdown();

	}

	/**
	 * @param emarsysSubscriptionFacade
	 *            the emarsysSubscriptionFacade to set
	 */
	public void setEmarsysSubscriptionFacade(EmarsysSubscriptionFacade emarsysSubscriptionFacade)
	{
		this.emarsysSubscriptionFacade = emarsysSubscriptionFacade;
	}

	public void setCheckoutFacade(CheckoutFacade checkoutFacade)
	{
		this.checkoutFacade = checkoutFacade;
	}

	public void setEmailFieldName(String emailFieldName)
	{
		this.emailFieldName = emailFieldName;
	}

	public void setForceOptinFieldName(String forceOptinFieldName)
	{
		this.forceOptinFieldName = forceOptinFieldName;
	}
}

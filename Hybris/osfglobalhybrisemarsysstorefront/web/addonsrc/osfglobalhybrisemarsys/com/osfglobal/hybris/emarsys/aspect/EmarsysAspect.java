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


import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.PredicateUtils;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.validation.BindingResult;

import com.osfglobal.hybris.emarsys.facades.EmarsysSubscriptionFacade;
import com.osfglobal.hybris.emarsys.services.enums.EmarsysPage;

import de.hybris.platform.acceleratorstorefrontcommons.forms.RegisterForm;
import de.hybris.platform.core.Registry;
import de.hybris.platform.core.TenantAwareThreadFactory;
import de.hybris.platform.jalo.JaloSession;



public class EmarsysAspect {
	protected static final int THREAD_NUMBER = 1;
	EmarsysSubscriptionFacade emarsysSubscriptionFacade;
	private EmarsysPage page;

	protected static final Logger LOG = Logger.getLogger(EmarsysAspect.class);

	public Object advise(final ProceedingJoinPoint joinPoint) throws Throwable {
		Object result = joinPoint.proceed();
		// Access the request to get opting value
		final List<Object> args = Arrays.asList(joinPoint.getArgs());
		HttpServletRequest request = (HttpServletRequest) CollectionUtils.find(args,
				PredicateUtils.instanceofPredicate(HttpServletRequest.class));

		RegisterForm form = (RegisterForm) CollectionUtils.find(args,
				PredicateUtils.instanceofPredicate(RegisterForm.class));


		final BindingResult bindingResult = (BindingResult) CollectionUtils.find(args,
				PredicateUtils.instanceofPredicate(BindingResult.class));
		// Proceed if only needed params are not empty and no error on the form
		if (request != null && form != null && CollectionUtils.isEmpty(bindingResult.getAllErrors())) {
			Boolean forceOptIn = getSubscribeOptin(request);

				String firstName = form.getFirstName();
				String lastName = form.getLastName();
				String email = form.getEmail();
				String titleCode = form.getTitleCode();

			runAsyncSubscription(forceOptIn, firstName, lastName, email, titleCode);
		}
		return result;
	}


	/**
	 * @param forceOptIn
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param titleCode
	 */
	protected void runAsyncSubscription(Boolean forceOptIn, String firstName, String lastName, String email,
			String titleCode) {
		// We need session inside thread. Hybris Jalo Session will be last if we
		// use a standard Runnable
		TenantAwareThreadFactory threadFactory = new TenantAwareThreadFactory(Registry.getCurrentTenant(),
				JaloSession.getCurrentSession());

		final ExecutorService executorService = Executors.newFixedThreadPool(THREAD_NUMBER);
		Runnable task = new Runnable()
			{

			@Override
			public void run() {
				emarsysSubscriptionFacade.processSubscribtion(forceOptIn, firstName, lastName, email, titleCode,
						getPage());
				}
			};

		Runnable tenatAwareTask = threadFactory.newThread(task);
		executorService.execute(tenatAwareTask);
		executorService.shutdown();
	}


	/**
	 * @param request
	 * @return
	 */
	private Boolean getSubscribeOptin(HttpServletRequest request) {
		String subscrib = request.getParameter("subscribedForMailList");
		Boolean forceOptIn = Boolean.valueOf(subscrib);
		return forceOptIn;
	}

	/**
	 * @return the emarsysSubscriptionFacade
	 */
	public EmarsysSubscriptionFacade getEmarsysSubscriptionFacade() {
		return emarsysSubscriptionFacade;
	}

	/**
	 * @param emarsysSubscriptionFacade
	 *            the emarsysSubscriptionFacade to set
	 */
	public void setEmarsysSubscriptionFacade(EmarsysSubscriptionFacade emarsysSubscriptionFacade) {
		this.emarsysSubscriptionFacade = emarsysSubscriptionFacade;
	}

	/**
	 * @return the page
	 */
	public EmarsysPage getPage() {
		return page;
	}

	/**
	 * @param page
	 *            the page to set
	 */
	public void setPage(EmarsysPage page) {
		this.page = page;
	}

}

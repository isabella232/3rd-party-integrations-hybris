package com.osfglobal.hybris.emarsys.aspect;

import java.util.Arrays;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.PredicateUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;

import com.osfglobal.hybris.emarsys.facades.EmarsysSubscriptionFacade;
import com.osfglobal.hybris.emarsys.services.enums.EmarsysPage;

import de.hybris.platform.acceleratorstorefrontcommons.forms.AddressForm;
import de.hybris.platform.acceleratorstorefrontcommons.forms.UpdateEmailForm;
import de.hybris.platform.commercefacades.customer.CustomerFacade;
import de.hybris.platform.commercefacades.user.UserFacade;
import de.hybris.platform.commercefacades.user.data.AddressData;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.commerceservices.customer.DuplicateUidException;

/**
 * This class in as aspect that handle accelerator my account changes and plug
 * it with EMarsys MArketing cloud
 *
 * @author imad Eddine Bouihi 11/21/2016
 * @param <T>
 *
 */
public class EmarsysAspectMyAccount<T>
{
	EmarsysSubscriptionFacade emarsysSubscriptionFacade;
	CustomerFacade customerFacade;
	UserFacade userFacade;

	protected static final Logger LOG = LoggerFactory.getLogger(EmarsysAspectMyAccount.class);

	public Object adviseUpdateEmail(final ProceedingJoinPoint joinPoint) throws Throwable
	{
		final CustomerData customerData = getCurrentCustomer();
		// Process the controller logic

		// Access the request to get opting value
		final List<Object> args = Arrays.asList(joinPoint.getArgs());
		final UpdateEmailForm updateEmailForm = (UpdateEmailForm) getForm(args, UpdateEmailForm.class);

		final BindingResult bindingResult = getBindingResults(args);
		// Proceed if only needed params are not empty and no error on the form
		if (CollectionUtils.isEmpty(bindingResult.getAllErrors()))
		{
			try
			{
				emarsysSubscriptionFacade.createOrUpdateContact(updateEmailForm.getEmail(), customerData.getUid(), EmarsysPage.MYACCOUNT,
						Boolean.TRUE);
			}
			catch (DuplicateUidException e)
			{
				LOG.error(e.getMessage(), e);
				bindingResult.rejectValue("email", "profile.email.unique");

			}
		}
		return joinPoint.proceed();
	}

	public Object adviseUpdateProfile(final ProceedingJoinPoint joinPoint) throws Throwable
	{
		// process controller update profile
		Object value = joinPoint.proceed();
		final List<Object> args = Arrays.asList(joinPoint.getArgs());
		BindingResult bindingResult = getBindingResults(args);
		// already user is update by controller if no error
		if (bindingResult != null && CollectionUtils.isEmpty(bindingResult.getAllErrors()))
		{
			final CustomerData currentCustomerData = getCurrentCustomer();
			emarsysSubscriptionFacade.updateContactInEmarsys(userFacade.getDefaultAddress(), currentCustomerData);
		}
		return value;
	}


	public Object adviseAddressesChanges(final ProceedingJoinPoint joinPoint) throws Throwable
	{
		// process controller update profile
		Object value = joinPoint.proceed();
		final List<Object> args = Arrays.asList(joinPoint.getArgs());
		AddressForm addressForm = (AddressForm) getForm(args, AddressForm.class);
		// already user address is updated by controller if no error. adress form is used to know if we are in Get or Post methods
		// of the controller since they have the same name addAddress
		BindingResult bindingResult = getBindingResults(args);
		if (bindingResult != null && CollectionUtils.isEmpty(bindingResult.getAllErrors()) && addressForm != null)
		{
			processAddressChanges();
		}
		return value;
	}

	public Object adviseRemoveaddress(final ProceedingJoinPoint joinPoint) throws Throwable
	{
		// process controller update profile
		Object value = joinPoint.proceed();
		processAddressChanges();
		return value;
	}

	public Object adviseSetDefaultAddress(final ProceedingJoinPoint joinPoint) throws Throwable
	{
		// process controller update profile
		Object value = joinPoint.proceed();
		processAddressChanges();
		return value;
	}

	/**
	 * @param addressForm
	 * @param bindingResult
	 */
	private void processAddressChanges()
	{

			final AddressData defaultAddress = userFacade.getDefaultAddress();
			final CustomerData currentCustomerData = getCurrentCustomer();
			if (defaultAddress != null)
			{
				emarsysSubscriptionFacade.updateContactInEmarsys(defaultAddress, currentCustomerData);
			}
	}
	/**
	 * @param args
	 * @return
	 */
	private BindingResult getBindingResults(final List<Object> args)
	{
		final BindingResult bindingResult = (BindingResult) CollectionUtils.find(args, PredicateUtils.instanceofPredicate(BindingResult.class));
		return bindingResult;
	}

	/**
	 * @param args
	 * @return
	 */
	private Object getForm(final List<Object> args, Class clazz)
	{
		return CollectionUtils.find(args,
				PredicateUtils.instanceofPredicate(clazz));
	}





	/**
	 * @return the emarsysSubscriptionFacade
	 */
	public EmarsysSubscriptionFacade getEmarsysSubscriptionFacade()
	{
		return emarsysSubscriptionFacade;
	}

	/**
	 * @param emarsysSubscriptionFacade
	 *            the emarsysSubscriptionFacade to set
	 */
	public void setEmarsysSubscriptionFacade(EmarsysSubscriptionFacade emarsysSubscriptionFacade)
	{
		this.emarsysSubscriptionFacade = emarsysSubscriptionFacade;
	}


	/**
	 * @return the customerFacade
	 */
	public CustomerFacade getCustomerFacade()
	{
		return customerFacade;
	}

	/**
	 * @param customerFacade
	 *            the customerFacade to set
	 */
	public void setCustomerFacade(CustomerFacade customerFacade)
	{
		this.customerFacade = customerFacade;
	}

	/**
	 * @return the userFacade
	 */
	public UserFacade getUserFacade()
	{
		return userFacade;
	}

	/**
	 * @param userFacade
	 *            the userFacade to set
	 */
	public void setUserFacade(UserFacade userFacade)
	{
		this.userFacade = userFacade;
	}

	/**
	 * @return
	 */
	private CustomerData getCurrentCustomer()
	{
		return customerFacade.getCurrentCustomer();
	}

}

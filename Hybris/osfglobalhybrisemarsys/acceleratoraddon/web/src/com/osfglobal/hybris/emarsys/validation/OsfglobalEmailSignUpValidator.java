package com.osfglobal.hybris.emarsys.validation;


import com.osfglobal.hybris.emarsys.forms.OsfglobalEmailSignUpForm;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


/**
 * Validates email sign up forms.
 */
@Component("emailSignUpValidator")
public class OsfglobalEmailSignUpValidator implements Validator
{
	public static final Pattern EMAIL_REGEX = Pattern.compile("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}\\b");

	@Override
	public boolean supports(final Class<?> aClass)
	{
		return OsfglobalEmailSignUpForm.class.equals(aClass);
	}

	@Override
	public void validate(final Object object, final Errors errors)
	{
		final OsfglobalEmailSignUpForm emailSignUpForm = (OsfglobalEmailSignUpForm) object;
		final Boolean gender = emailSignUpForm.getGender();
		final String firstName = emailSignUpForm.getFirstName();
		final String lastName = emailSignUpForm.getLastName();
		final String email = emailSignUpForm.getEmail();

		if (gender == null)
		{
			errors.rejectValue("gender", "emailsignup.gender.invalid");
		}

		if (StringUtils.isBlank(firstName))
		{
			errors.rejectValue("firstName", "emailsignup.firstName.invalid");
		}
		else if (StringUtils.length(firstName) > 255)
		{
			errors.rejectValue("firstName", "emailsignup.firstName.invalid");
		}

		if (StringUtils.isBlank(lastName))
		{
			errors.rejectValue("lastName", "emailsignup.lastName.invalid");
		}
		else if (StringUtils.length(lastName) > 255)
		{
			errors.rejectValue("lastName", "emailsignup.lastName.invalid");
		}

		if (StringUtils.length(firstName) + StringUtils.length(lastName) > 255)
		{
			errors.rejectValue("lastName", "emailsignup.name.invalid");
			errors.rejectValue("firstName", "emailsignup.name.invalid");
		}

		if (StringUtils.isEmpty(email))
		{
			errors.rejectValue("email", "emailsignup.email.invalid");
		}
		else if (StringUtils.length(email) > 255 || !validateEmailAddress(email))
		{
			errors.rejectValue("email", "emailsignup.email.invalid");
		}
	}

	public boolean validateEmailAddress(final String email)
	{
		final Matcher matcher = EMAIL_REGEX.matcher(email);
		return matcher.matches();
	}
}

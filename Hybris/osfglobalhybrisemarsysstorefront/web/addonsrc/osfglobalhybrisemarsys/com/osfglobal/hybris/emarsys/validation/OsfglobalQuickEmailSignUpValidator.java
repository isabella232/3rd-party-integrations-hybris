package com.osfglobal.hybris.emarsys.validation;


import com.osfglobal.hybris.emarsys.forms.OsfglobalQuickEmailSignUpForm;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


/**
 * Validates email sign up forms.
 */
@Component("quickEmailSignUpValidator")
public class OsfglobalQuickEmailSignUpValidator implements Validator
{
	public static final Pattern EMAIL_REGEX = Pattern.compile("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}\\b");

	@Override
	public boolean supports(final Class<?> aClass)
	{
		return OsfglobalQuickEmailSignUpForm.class.equals(aClass);
	}

	@Override
	public void validate(final Object object, final Errors errors)
	{
		final OsfglobalQuickEmailSignUpForm emailSignUpForm = (OsfglobalQuickEmailSignUpForm) object;
		final String email = emailSignUpForm.getEmail();

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

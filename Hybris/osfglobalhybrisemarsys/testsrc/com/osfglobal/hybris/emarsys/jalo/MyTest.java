/**
 *
 */
package com.osfglobal.hybris.emarsys.jalo;

import org.apache.commons.lang.LocaleUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;


/**
 * @author Roman
 *
 */
public class MyTest
{
	/**
	 *
	 */
	@Test
	public void psv()
	{
		final ResourceBundle bundle = ResourceBundle.getBundle("de.hybris.platform.hmc.locales", Locale.ENGLISH);
		System.out.println(bundle.getString("order.net.true"));


		System.out.println(LocaleUtils.toLocale("en_UasS").getCountry());
		/*System.out.println(Arrays.toString(Locale.getISOLanguages()));
		System.out.println(Arrays.toString(Locale.getISOCountries()));*/
	}

}

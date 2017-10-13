package com.osfglobal.hybris.emarsys.utils;

import org.apache.commons.lang.LocaleUtils;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Roman on 27/10/2016.
 */
public class EmarsysStringUtilsTest {
    private static final String SUFFIX_PATTERN = "^(c_)?\\w+_([a-z]+)$";
    @Test
    public void main() {
  /*      assertThat("en", is(EmarsysStringUtils.getSubstringByRegex("item", PATTERN,1)));
        assertThat("en_US", is(EmarsysStringUtils.getSubstringByRegex("item_en_US", PATTERN,1)));
        assertThat("end", is(EmarsysStringUtils.getSubstringByRegex("c_item_end", PATTERN,1)));
        assertThat("end_CO", is(EmarsysStringUtils.getSubstringByRegex("c_item_end_CO", PATTERN,1)));*/
       /* assertThat(EmarsysStringUtils.getSubstringByRegex("price_usd", SUFFIX_PATTERN,2), is("usd"));
        assertThat(EmarsysStringUtils.getSubstringByRegex("title_deeur", SUFFIX_PATTERN,2), is("deeur"));*/
     /*   assertNotNull(LocaleUtils.toLocale("en"));
        System.out.println(LocaleUtils.toLocale("iuuj"));*/
    }

    @Test
    public void stripTagsTest(){
        String actual = "<br/><br/>Enables power supply from an AC outlet to your Cyber-shot.<br/><br/>AC-LS5";
        String expected = "Enables power supply from an AC outlet to your Cyber-shot.AC-LS5";
       /* assertThat(EmarsysStringUtils.stripHtmlTags(actual), is(expected));*/
    }

}
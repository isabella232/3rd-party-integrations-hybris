package com.osfglobal.hybris.emarsys.utils;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.junit.Test;

/**
 * Created by Roman on 17/10/2016.
 */
public class EmarsysFormatterUtilsTest {
    @Test
    public void objectToString() throws Exception {
        Multimap<String, Integer> multimap = ArrayListMultimap.create();

        multimap.put("a", 1);
        multimap.put("a", 2);

        System.out.println(multimap);

    }

    @Test
    public void dateToIsoString() throws Exception {

    }

    @Test
    public void doubleToString() throws Exception {
        double a = 0;
        EmarsysFormatterUtils formatterUtils = new EmarsysFormatterUtils();
        System.out.println(formatterUtils.doubleToString(a));
    }

}
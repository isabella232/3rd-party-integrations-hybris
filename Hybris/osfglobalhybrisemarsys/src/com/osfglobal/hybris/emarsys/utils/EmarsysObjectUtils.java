package com.osfglobal.hybris.emarsys.utils;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;

import java.lang.reflect.InvocationTargetException;

/**
 * Util class for generic methods
 */
public class EmarsysObjectUtils {
    private static final Logger LOGGER = Logger.getLogger(EmarsysObjectUtils.class);
    /**
     * Get nested property value
     * @param object
     * @param path
     * @return
     */
    public static Object getNestedProperty(Object object, String path) {
        try {
            return PropertyUtils.getNestedProperty(object, path);
        } catch (Exception exception) {
            LOGGER.debug("Cannot access to the property of " + object + " by path " + path);
            // if any the nested objects is null we return null as value
            return null;
        }
    }

    public static void setProperty(Object object, String propertyName, Object propertyValue){
        try {
            PropertyUtils.setProperty(object, propertyName, propertyValue);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {/*do nothing*/}

    }


    /**
     * Return an empty string in case of null. Otherwise return the value
     * @param value
     * @return
     */
    public static String nullToEmptyString(String value) {
        return value == null ? "" : value;
    }
}

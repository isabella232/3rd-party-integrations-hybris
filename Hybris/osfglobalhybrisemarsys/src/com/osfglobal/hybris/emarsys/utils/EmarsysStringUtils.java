package com.osfglobal.hybris.emarsys.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * String utils class
 */
public class EmarsysStringUtils {

    private static final String STRIP_TAGS_REGEX = "<.*?>";

    public static String getSubstringByRegex(String string, String regex, int group) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        if (matcher.matches()) {
            return matcher.group(group);
        }
        return null;
    }
    public static String stripHtmlTags(String input){
        return input != null ? input.replaceAll(STRIP_TAGS_REGEX, "") : null;
    }
}

package com.jzweb.common.lang;

/**
 * @author Ryan
 * @version 1.0
 * @date 12/25/2019
 */
public class NumberUtils extends org.apache.commons.lang3.math.NumberUtils {

    public static int toInt(final String str) {
        return toInt(str, 0);
    }

    public static int toInt(final String str, final int defaultValue) {
        if(str == null) {
            return defaultValue;
        }
        try {
            return Integer.parseInt(str);
        } catch (final NumberFormatException nfe) {
            return defaultValue;
        }
    }
}

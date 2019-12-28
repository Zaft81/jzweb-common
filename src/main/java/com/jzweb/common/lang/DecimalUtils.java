package com.jzweb.common.lang;

import java.math.BigDecimal;

/**
 * @author Ryan
 * @version 1.0
 * @date 12/25/2019
 */
public class DecimalUtils {
    /** 常数0 */
    public static final BigDecimal DECIMAL_ZERO = new BigDecimal("0");
    /** 常数1 */
    public static final BigDecimal DECIMAL_ONE = new BigDecimal("1");
    /** 常数2 */
    public static final BigDecimal DECIMAL_TWO = new BigDecimal("2");
    /** 常数3 */
    public static final BigDecimal DECIMAL_THREE = new BigDecimal("3");
    /** 常数4 */
    public static final BigDecimal DECIMAL_FOUR = new BigDecimal("4");
    /** 常数5 */
    public static final BigDecimal DECIMAL_FIVE = new BigDecimal("5");
    /** 常数6 */
    public static final BigDecimal DECIMAL_SIX = new BigDecimal("6");
    /** 常数7 */
    public static final BigDecimal DECIMAL_SEVEN = new BigDecimal("7");
    /** 常数8 */
    public static final BigDecimal DECIMAL_EIGHT = new BigDecimal("8");
    /** 常数9 */
    public static final BigDecimal DECIMAL_NINE = new BigDecimal("9");
    /** 常数10 */
    public static final BigDecimal DECIMAL_TEN = new BigDecimal("10");
    /** 常数100 */
    public static final BigDecimal DECIMAL_HUNDRED = new BigDecimal("100");
    /** 常数1000 */
    public static final BigDecimal DECIMAL_THOUSAND = new BigDecimal("1000");


    public static BigDecimal toDecimal(String str){
        if(StringUtils.isNotBlank(str)){
            return new BigDecimal(str);
        } else {
            return DECIMAL_ZERO;
        }
    }

    public static BigDecimal toDecimal(Object obj){
        if(obj == null){
            return DECIMAL_ZERO;
        } else {
            return toDecimal(obj.toString());
        }
    }
}

package com.babel.common.utils.string;

import java.util.Collection;

/**
 * Created by shawn on 17/5/20.
 */
public class StringUtils {

    public static String trimNullWithValue(String str,String value){
        return str==null?value:str.trim();
    }
    
    public static String trimNull(String str){
        return str==null?"-":str.trim();
    }

    public static int trimNull4Integer(Integer value){
        return value==null?-1:value;
    }

    public static long trimNull4Long(Long value){
        return value==null?-1:value;
    }

    public static boolean isStringNull(String value){
        return !"null".equals(value) && value != null && org.apache.commons.lang3.StringUtils.isNotEmpty(value);
    }
}



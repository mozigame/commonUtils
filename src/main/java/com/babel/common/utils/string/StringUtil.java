package com.babel.common.utils.string;

/**
 * created by roachjiang 2017/9/27
 */
public class StringUtil {


    /**
     *
     */
    public static final String NO_DATA_HINT = "-";


    /**
     *
     * @param msg
     * @return
     */
    public static String joinMsg(Object ...msg){
        if (msg==null){
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Object ele:msg){
            if (ele!=null){
                stringBuilder.append(ele);
            }
        }
        return stringBuilder.toString();
    }

}

package com.babel.common.utils.data;

/**
 * @Author Ivan
 * @Date 2018/1/24
 */
public class DataUtil {
    /**
     * 数据转换 以基数乘以100
     * @param value
     * @return
     */
    public static Integer multiply(Integer value) {
        return value == null ? 0 : value * 100;
    }
    /**
     * 数据转换 以基数除以100
     * @param value
     * @return
     */
    public static Integer divide(Integer value) {
        return value == null ? 0 : value / 100;
    }
}

package com.babel.common.utils.excel;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * created by roachjiang 2017/9/26
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelExportField {

    /**
     * 第几列输出
     * @return
     */
    int colNum();

    /**
     * 描述
     * @return
     */
    String colName();
}

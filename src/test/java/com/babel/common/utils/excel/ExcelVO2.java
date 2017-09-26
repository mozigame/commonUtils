package com.babel.common.utils.excel;

import com.babel.common.utils.excel.ExcelExportField;

import java.util.Map;

/**
 * created by roachjiang 2017/9/26
 */
public class ExcelVO2 {

    private int index;

    @ExcelExportField(colNum = 0,colName = "名字")
    private String name;

    @ExcelExportField(colNum = 1,colName = "描述")
    private String desc;

    //覆盖描述
    @ExcelExportField(colNum = 1,colName = "数据")
    private Map<String,Object> data;

    /**
     * getter for index
     */
    public int getIndex() {
        return index;
    }

    /**
     * setter for index
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * getter for name
     */
    public String getName() {
        return name;
    }

    /**
     * setter for name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter for desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * setter for desc
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * getter for data
     */
    public Map<String,Object>  getData() {
        return data;
    }

    /**
     * setter for data
     */
    public void setData(Map<String,Object>  data) {
        this.data = data;
    }

    public ExcelVO2() {
    }
}

package com.babel.common.utils.excel;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * created by roachjiang 2017/9/26
 */
public class ExcelUtilTest {

    //
    @Test
    public void testGenerator() throws IOException {
        {
            List<ExcelVO> test = new LinkedList();
            for (int index =0; index<50; index++){
                ExcelVO e = new ExcelVO();
                e.setIndex(index);
                e.setName("name"+ index);
                e.setDesc("desc" + index);
                Map<String,Object> data = new HashMap<>();
                data.put("1","1234");
                data.put("2","123456");
                e.setData(data);
                test.add(e);
            }
            String fileName = "testExcel.xlsx";
            byte[] bytes = ExcelExportUtil.generatorExportBytes(test,fileName);
            FileOutputStream fileOutputStream = new FileOutputStream("D:/" + fileName);
            fileOutputStream.write(bytes);
            fileOutputStream.flush();
        }
        //
        {
            List<ExcelVO2> test = new LinkedList();
            for (int index =0; index<50; index++){
                ExcelVO2 e = new ExcelVO2();
                e.setIndex(index);
                e.setName("name"+ index);
                e.setDesc("desc" + index);
                Map<String,Object> data = new HashMap<>();
                data.put("1","1234");
                data.put("2","123456");
                e.setData(data);
                test.add(e);
            }
            String fileName = "testExcel2.xlsx";
            byte[] bytes = ExcelExportUtil.generatorExportBytes(test,fileName);
            FileOutputStream fileOutputStream = new FileOutputStream("D:/" + fileName);
            fileOutputStream.write(bytes);
            fileOutputStream.flush();
        }
    }
}

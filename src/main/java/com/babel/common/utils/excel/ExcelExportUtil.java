package com.babel.common.utils.excel;

import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;
import com.babel.common.utils.time.LocalDateTimeUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.*;

/**
 * created by roachjiang 2017/9/26
 */
public class ExcelExportUtil {

    /**
     *
     */
    private static final Log logger = LogFactory.getLog(ExcelExportUtil.class);


    public static String formatFileName(String head) {
        StringBuilder filename = new StringBuilder();
        filename.append(LocalDateTimeUtil.toAmerica(System.currentTimeMillis(), LocalDateTimeUtil.YYYYMMDD));
        filename.append("(");
        filename.append(head);
        filename.append(")");
        filename.append(".xlsx");
        return filename.toString();
    }


    public static void download(HttpServletResponse response, List list, String filename) throws IOException {
        response.setCharacterEncoding("UTF-8");
        ServletOutputStream outputStream = null;
        try {
            byte[] bytes = generatorExportBytes(list, filename);
            if (bytes != null && bytes.length > 0) {
                String contnetDisposition = "attachment;filename=";
                if (filename != null) {
                    String fileNameUTF8 = URLEncoder.encode(filename, "utf-8");
                    ;
                    contnetDisposition += fileNameUTF8;
                    response.setHeader("Location", fileNameUTF8);
                }
                response.setHeader("Content-Disposition", contnetDisposition);
                outputStream = response.getOutputStream();

                outputStream.write(bytes);

            }
        } finally {
            if (outputStream != null) {
                outputStream.flush();
                outputStream.close();
            }
        }
    }


    /**
     * @param list
     * @param filename
     * @return
     * @Doc
     */
    public static byte[] generatorExportBytes(List list, String filename) {
        logger.info("开始生成Excel!fileName:".concat(filename));
        try {

            if (CollectionUtils.isEmpty(list)) {
                return null;
            }
            XSSFWorkbook workbook = new XSSFWorkbook();
            //创建Excel工作薄
            //head.setRowStyle(style);
            //创建单元格,并设置单元格格式和内容
            byte[] bytes = generatorExportBytes(list,
                    workbook);

            return bytes;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("生成excel失败！data size:".concat(String.valueOf(10)).concat(",fileName:").concat(filename), e);
            return null;
        }
    }

    private static byte[] generatorExportBytes(List list, XSSFWorkbook workbook) throws
            IOException, IllegalAccessException {
        //创建工作表，可指定工作表名称
        Sheet sheet = workbook.createSheet();
        //设置居中
        CellStyle style = workbook.createCellStyle();
        style.setAlignment(XSSFCellStyle.ALIGN_CENTER);

        Object objectFirst = list.get(0);
        Class objectClass = objectFirst.getClass();
        Field[] fields = objectClass.getDeclaredFields();
        createFirstRow(fields, sheet);
        for (int index = 0; index < list.size(); index++) {
            Object object = list.get(index);
            Row row = sheet.createRow(index + 1);
            for (Field field : fields) {
                ExcelExportField excelExportField = field.getAnnotation(ExcelExportField.class);
                if (excelExportField != null) {
                    Cell cell = row.createCell(excelExportField.colNum());
                    cell.setCellType(XSSFCell.CELL_TYPE_STRING);
                    Object valueOb = getValue(object, field);
                    if (valueOb != null) {
                        cell.setCellValue(String.valueOf(valueOb));
                    }

                }
            }

        }
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        workbook.write(os);
        byte[] bytes = os.toByteArray();
        return bytes;
    }

    private static void createFirstRow(Field[] fields, Sheet sheet) {
        Row row = sheet.createRow(0);
        for (Field field : fields) {
            ExcelExportField excelExportField = field.getAnnotation(ExcelExportField.class);
            if (excelExportField != null) {
                Cell cell = row.createCell(excelExportField.colNum());
                cell.setCellType(XSSFCell.CELL_TYPE_STRING);
                cell.setCellValue(excelExportField.colName());
            }
        }
    }

    private static Object getValue(Object object, Field field) throws IllegalAccessException {
        field.setAccessible(true);
        //这里直接取,不调用get方法
        return field.get(object);
    }
}

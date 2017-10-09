package com.babel.common.lottetry.utils.order;

import com.babel.common.lottery.utils.order.OrderUtils;
import com.babel.common.utils.excel.ExcelExportUtil;
import com.babel.common.utils.excel.ExcelVO;
import com.babel.common.utils.excel.ExcelVO2;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * created by roachjiang 2017/9/27
 */
public class OrderUtilsTest {

    //
    @Test
    public void testPcode() throws IOException {
        {
            Long pcode = null;
            System.out.println(OrderUtils.getPcodeString(pcode));
        }
        {
            Long pcode = 20170507002L;
            System.out.println(OrderUtils.getPcodeString(pcode));
        }
        {
            Long pcode = 20170507012L;
            System.out.println(OrderUtils.getPcodeString(pcode));
        }
        {
            Long pcode = 20170507112L;
            System.out.println(OrderUtils.getPcodeString(pcode));
        }

    }
}

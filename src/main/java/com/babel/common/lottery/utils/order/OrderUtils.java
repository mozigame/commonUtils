package com.babel.common.lottery.utils.order;

/**
 * created by roachjiang 2017/9/25
 */
public class OrderUtils {

    //http://wiki.blr58589.com/pages/viewpage.action?pageId=2917602
    //订单规则
    private static final int[] VALID_ORDER_LEN = new int[]{20, 21};

    public static boolean checkOrderId(String orderId) {
        boolean match = false;
        if (orderId != null) {
            int len = orderId.length();
            for (int validLen : VALID_ORDER_LEN) {
                if (validLen == len) {
                    match = true;
                    break;
                }
            }
        }
        return match;
    }


    public static String getPcodeString(Long pcode) {
        if (pcode==null){
            return null;
        }
        //用数字不用处理长度
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(pcode/1000L);
        stringBuilder.append("-");
        long smallCode  = pcode%1000L;
        if (smallCode<10){
            stringBuilder.append("00");
        }else if (smallCode<100){
            stringBuilder.append("0");
        }
        stringBuilder.append(smallCode);
        return stringBuilder.toString();
    }
}

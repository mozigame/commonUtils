package com.babel.common.utils.order;

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
                }
            }
        }
        return match;
    }
}

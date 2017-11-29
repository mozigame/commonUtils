package com.babel.common.lottetry.utils.order;

import java.io.IOException;

import org.junit.Test;

import com.babel.common.lottery.utils.order.OrderUtils;

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
        System.out.println("-----4code");
        {
            Long pcode = 201705071121L;
            System.out.println(OrderUtils.getPcodeString(pcode));
        }
        
        {
            Long pcode = 201705070001L;
            System.out.println(OrderUtils.getPcodeString(pcode));
        }
        {
            Long pcode = 201705070011L;
            System.out.println(OrderUtils.getPcodeString(pcode));
        }
        {
            Long pcode = 201705070101L;
            System.out.println(OrderUtils.getPcodeString(pcode));
        }
        
        System.out.println("-----4code2");
        
        {
            Long pcode = 201705071121L;
            System.out.println(OrderUtils.getPcodeString4(pcode));
        }
        
        {
            Long pcode = 201705070001L;
            System.out.println(OrderUtils.getPcodeString4(pcode));
        }
        {
            Long pcode = 201705070011L;
            System.out.println(OrderUtils.getPcodeString4(pcode));
        }
        {
            Long pcode = 201705070101L;
            System.out.println(OrderUtils.getPcodeString4(pcode));
        }

    }
    
    @Test
    public void testOrderId(){
    	String orderId="21362017112906993f4i0ekt";
    	System.out.println("---"+orderId.length());
    	boolean isOrder=OrderUtils.checkOrderId(orderId);
    	System.out.println(orderId+" "+isOrder);
    	
    	orderId="2102201711280524c7t0bhs";
    	isOrder=OrderUtils.checkOrderId(orderId);
    	System.out.println(orderId+" "+isOrder);
    }
}

package com.babel.common.lottery.utils.order;

import java.util.Calendar;

/**
 * created by roachjiang 2017/9/25
 */
public class OrderUtils {

    //http://wiki.blr58589.com/pages/viewpage.action?pageId=2917602
    //订单规则
    private static final int[] VALID_ORDER_LEN = new int[]{23};
    private static final int[] VALID_ORDER4_LEN = new int[]{24};
    
    private static final String DAY_PCODE_4="201701010001";
    private static final int DAY_PCODE_4_LENGTH=DAY_PCODE_4.length();

    public static boolean checkOrderId(String orderId) {
        boolean match = false;
        if (orderId != null) {
        	if(orderId.length()==VALID_ORDER4_LEN[0]){
        		return checkOrderId4(orderId);
        	}
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
    
    public static boolean checkOrderId4(String orderId) {
        boolean match = false;
        if (orderId != null) {
            int len = orderId.length();
            for (int validLen : VALID_ORDER4_LEN) {
                if (validLen == len) {
                    match = true;
                    break;
                }
            }
        }
        return match;
    }
    
    public static int getLength(Long v){
		if(v==null){
			return 0;
		}
		return v.toString().length();
	}
    
    /**
     * 每天的期号是否4位
     * @param pcode
     * @return
     */
    public static boolean isDay4Pos(Long pcode){
    	  int pLength=getLength(pcode);
    	  if(pLength==DAY_PCODE_4_LENGTH){
    		  return true;
    	  }
    	  return false;  
    }


    /**
     * 3位期的数据处理,返回yyyyMMdd001
     * @param pcode
     * @return
     */
    public static String getPcodeString(Long pcode) {
        if (pcode==null){
            return null;
        }
        if(isDay4Pos(pcode)){
        	return getPcodeString4(pcode);
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
    
    /**
     * 4位期的数据处理,返回yyyyMMdd0001
     * @param pcode
     * @return
     */
    public static String getPcodeString4(Long pcode) {
        if (pcode==null){
            return null;
        }
        //用数字不用处理长度
        StringBuilder stringBuilder = new StringBuilder();
       if(isDay4Pos(pcode)){}
        stringBuilder.append(pcode/10000L);
       
        stringBuilder.append("-");
        long smallCode  = pcode%10000L;
        if (smallCode<10){
            stringBuilder.append("000");
        }else if (smallCode<100){
            stringBuilder.append("00");
        }
        else if (smallCode<1000){
            stringBuilder.append("0");
        }
        stringBuilder.append(smallCode);
        return stringBuilder.toString();
    }
    
    /**
     * 从期号中获取pdate
     * @param pcode
     * @return
     */
    public static Long getPdate(Long pcode){
    	if(pcode==null){
    		return null;
    	}
    	if(isDay4Pos(pcode)){
    		return pcode/10000;
    	}
    	return pcode/1000;
    }
    
    /**
     * 获取当前周数，仅用于查询，六合彩pweek最好从prizeNumber的pdate中取
     * @param time
     * @deprecated
     * @return year+week, exp:201801
     */
    public static Integer getYearPWeek(Long time){
    	if(time==null){
    		return 0;
    	}
    	return addYearPWeek(time, 0);
    }
    
    /**
     * 年份周数加减
     * @param time
     * @return year+week, exp:201801
     * 
     */
    public static Integer addYearPWeek(Long time, Integer weekCount){
    	if(time==null){
    		return 0;
    	}
    	time=time+weekCount*7*24*3600*1000;
    	Calendar calendar = Calendar.getInstance();
    	calendar.setFirstDayOfWeek(Calendar.MONDAY); 
    	calendar.setTimeInMillis(time);
    	Integer week= calendar.get(Calendar.WEEK_OF_YEAR);
    	Integer year=calendar.get(Calendar.YEAR);
    	return year*100+week;
    }
    
    /**
     * 当前时间在周对应的天数
     * @param time
     * @return year+week, exp:201801
     * 
     */
    public static Integer getWeekDay(Long time){
    	if(time==null){
    		return 0;
    	}
    	Calendar calendar = Calendar.getInstance();
    	calendar.setFirstDayOfWeek(Calendar.MONDAY); 
    	calendar.setTimeInMillis(time);
    	Integer weekDay= calendar.get(Calendar.DAY_OF_WEEK);
    	return weekDay;
    }
    
    /**
     * 从期号中获取期数
     * @param pcode
     * @return
     */
    public static Long getPcount(Long pcode){
    	if(pcode==null){
    		return null;
    	}
    	if(isDay4Pos(pcode)){
    		return pcode%10000;
    	}
    	return pcode%1000;
    }
}

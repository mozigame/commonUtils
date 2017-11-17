package com.babel.common.utils.time;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

/*
 * @ClassName: DateUtil
 * @Description: 日期处理工具类
 * @author sundy
 * @date 2017-05-31 下午03:39:52
 */

public class DateUtils {

    private static final String DATE_REG = "[0-9]{4}-[0-9]{2}-[0-9]{2}";
    private static final String DATE_FORMAT_DEFAULT_TIME = "yyyyMMdd";
    private static final String DATE_FORMAT_DEFAULT_MONTH = "yyyyMM";
    private static final String DATE_FORMAT_TIME = "yyyyMMdd HH:mm:ss";

    public static boolean validate(String timeString) {
        // TODO Auto-generated method stub

        if (timeString == null || timeString.trim().length() == 1) {
            return false;
        }
        if (!Pattern.compile(DATE_REG).matcher(timeString).find()) {
            return false;
        }
        return true;

    }

    public static String formatDate(Date date) {
        SimpleDateFormat dateformat = new SimpleDateFormat(DATE_FORMAT_DEFAULT_TIME);
        return dateformat.format(date);
    }

    public static String formatDateTime(Date date) {
        SimpleDateFormat dateformat = new SimpleDateFormat(DATE_FORMAT_TIME);
        return dateformat.format(date);
    }

    public static Float calculateQuarterProgress(String date) throws ParseException {
        Date currentDate = parse(date);
        Date firstDate = getFirstDayForQuery(parse(date));
        Date firstDateOfNextMonth = getLastDayOfQuarter(parse(date));

        Float passedDayOfThisMonth = Float.valueOf(daysBetween(firstDate, currentDate)) + 1;
        Float dayOfThisMonth = Float.valueOf(daysBetween(firstDate, firstDateOfNextMonth)) + 1;

        return passedDayOfThisMonth / dayOfThisMonth;
    }

    private static Date getFirstDayForQuery(Date date) {
        // TODO Auto-generated method stub
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return getFirstDayOfQuarter(calendar.get(Calendar.YEAR), getQuarterOfYear(date));
    }

    public static Date parse(String dateString) {
        return parse(dateString, DATE_FORMAT_DEFAULT_TIME);
    }

    public static Date parse(String dateString, String dateFormat) {
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        try {
            date = sdf.parse(dateString);
        } catch (ParseException e) {
            return null;
        } catch (Exception e) {
            return null;
        }
        return date;
    }
    
    public static Date getDateTime(String dateString) {
        
        return parse(dateString,DATE_FORMAT_TIME);
    }

    public static Float calculateMonthlyProgress(String date) throws ParseException {
        // TODO Auto-generated method stub
        Date currentDate = parse(date);
        Date firstDate = getFirstDayForMonth(parse(date));
        Date firstDateOfNextMonth = getFirstDayForNextMonth(parse(date));

        Float passedDayOfThisMonth = Float.valueOf(daysBetween(firstDate, currentDate)) + 1;
        Float dayOfThisMonth = Float.valueOf(daysBetween(firstDate, firstDateOfNextMonth));

        return passedDayOfThisMonth / dayOfThisMonth;
    }

    /**
     * 计算两个日期之间相差的天数
     * 
     * @param smdate 较小的时间
     * @param bdate 较大的时间
     * @return 相差天数
     * @throws ParseException
     */
    private static int daysBetween(Date smdate, Date bdate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        smdate = sdf.parse(sdf.format(smdate));
        bdate = sdf.parse(sdf.format(bdate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long betweenDays = (time2 - time1) / (1000 * 3600 * 24);

        return Integer.parseInt(String.valueOf(betweenDays));
    }
    
    
    public  static int  caculateDay4pk10(Date bdate){
    	Date initDate=DateUtils.parse("20171030");
    	try {
			return daysBetween(initDate,bdate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
    }

    /**
     * 字符串的日期格式的计算
     */
    private static int daysBetween(String smdate, String bdate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(smdate));
        long time1 = cal.getTimeInMillis();
        cal.setTime(sdf.parse(bdate));
        long time2 = cal.getTimeInMillis();
        long betweenDays = (time2 - time1) / (1000 * 3600 * 24);

        return Integer.parseInt(String.valueOf(betweenDays));
    }

    private static Date getFirstDayForMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int day = calendar.get(Calendar.DAY_OF_MONTH) - 1;

        return diffDay(date, day);
    }

    private static Date getFirstDayForNextMonth(Date date) {
        Date tmp = date;
        tmp.setMonth(date.getMonth() + 1);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(tmp);
        int day = calendar.get(Calendar.DAY_OF_MONTH) - 1;
        return diffDay(tmp, day);
    }

    /**
     * 功能描述：日期减指定天数
     * 
     * @param date Date 日期
     * @param day int 天数
     * @return 返回相减后的日期
     */
    private static Date diffDay(Date date, int day) {
        day = 0 - day;
        return addDay(date, day);
    }

    /**
     * 功能描述：日期加指定天数
     * 
     * @param date Date 日期
     * @param day int 天数
     * @return 返回相加后的日期
     */
    private static Date addDay(Date date, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, day);
        return calendar.getTime();
    }
    
    
    public static Date addSecond(Date date, int second) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.SECOND, second);
        return calendar.getTime();
    }

    /**
     * 返回指定年季的季的第一天
     *
     * @param year
     * @param quarter
     * @return
     */
    private static Date getFirstDayOfQuarter(Integer year, Integer quarter) {
        Calendar calendar = Calendar.getInstance();
        Integer month = new Integer(0);
        if (quarter == 1) {
            month = 1 - 1;
        } else if (quarter == 2) {
            month = 4 - 1;
        } else if (quarter == 3) {
            month = 7 - 1;
        } else if (quarter == 4) {
            month = 10 - 1;
        } else {
            month = calendar.get(Calendar.MONTH);
        }
        return getFirstDayOfMonth(year, month);
    }

    /**
     * 返回指定日期的季的最后一天
     *
     * @return
     */
    private static Date getLastDayOfQuarter(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return getLastDayOfQuarter(calendar.get(Calendar.YEAR), getQuarterOfYear(date));
    }

    /**
     * 返回指定年季的季的最后一天
     *
     * @param year
     * @param quarter
     * @return
     */
    private static Date getLastDayOfQuarter(Integer year, Integer quarter) {
        Calendar calendar = Calendar.getInstance();
        Integer month = new Integer(0);
        if (quarter == 1) {
            month = 3 - 1;
        } else if (quarter == 2) {
            month = 6 - 1;
        } else if (quarter == 3) {
            month = 9 - 1;
        } else if (quarter == 4) {
            month = 12 - 1;
        } else {
            month = calendar.get(Calendar.MONTH);
        }
        return getLastDayOfMonth(year, month);
    }

    /**
     * 返回指定日期的上一季的最后一天
     *
     * @return
     */
    private static Date getLastDayOfLastQuarter(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return getLastDayOfLastQuarter(calendar.get(Calendar.YEAR), getQuarterOfYear(date));
    }

    /**
     * 返回指定年季的上一季的最后一天
     *
     * @param year
     * @param quarter
     * @return
     */
    private static Date getLastDayOfLastQuarter(Integer year, Integer quarter) {
        Calendar calendar = Calendar.getInstance();
        Integer month = new Integer(0);
        if (quarter == 1) {
            month = 12 - 1;
        } else if (quarter == 2) {
            month = 3 - 1;
        } else if (quarter == 3) {
            month = 6 - 1;
        } else if (quarter == 4) {
            month = 9 - 1;
        } else {
            month = calendar.get(Calendar.MONTH);
        }
        return getLastDayOfMonth(year, month);
    }

    /**
     * 返回指定日期的季度
     *
     * @param date
     * @return
     */
    private static int getQuarterOfYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) / 3 + 1;
    }

    /**
     * 返回指定日期的月的第一天
     *
     * @return
     */
    private static Date getFirstDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), 1);
        return calendar.getTime();
    }

    public static String getFirstDayOfMonth() {
        return formatDate(getFirstDayOfMonth(new Date()));
    }

    public static String getCurrentMonth() {
        SimpleDateFormat dateformat = new SimpleDateFormat(DATE_FORMAT_DEFAULT_MONTH);
        return dateformat.format(getFirstDayOfMonth(new Date()));

    }

    /**
     * 返回指定年月的月的第一天
     *
     * @param year
     * @param month
     * @return
     */
    private static Date getFirstDayOfMonth(Integer year, Integer month) {
        Calendar calendar = Calendar.getInstance();
        if (year == null) {
            year = calendar.get(Calendar.YEAR);
        }
        if (month == null) {
            month = calendar.get(Calendar.MONTH);
        }
        calendar.set(year, month, 1);
        return calendar.getTime();
    }

    /**
     * 返回指定日期的月的最后一天
     *
     * @param year
     * @param month
     * @return
     */
    private static Date getLastDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), 1);
        calendar.roll(Calendar.DATE, -1);
        return calendar.getTime();
    }

    /**
     * 返回指定年月的月的最后一天
     *
     * @param year
     * @param month
     * @return
     */
    private static Date getLastDayOfMonth(Integer year, Integer month) {
        Calendar calendar = Calendar.getInstance();
        if (year == null) {
            year = calendar.get(Calendar.YEAR);
        }
        if (month == null) {
            month = calendar.get(Calendar.MONTH);
        }
        calendar.set(year, month, 1);
        calendar.roll(Calendar.DATE, -1);
        return calendar.getTime();
    }

    /**
     * 返回指定日期的上个月的最后一天
     *
     * @param year
     * @param month
     * @return
     */
    private static Date getLastDayOfLastMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) - 1, 1);
        calendar.roll(Calendar.DATE, -1);
        return calendar.getTime();
    }

    public static Long getYesterdayDate() {
        // TODO Auto-generated method stub
        return Long.parseLong(formatDate(diffDay(new Date(), 1)));
    }

    public static String getCurrentDate() {
        return formatDate(new Date());
    }

    public static int getCurrentDay(){
		
		return Integer.parseInt(formatDate(new Date()));
	}
    
    
    public static Long getTomorrowDay(){
		
    	 return Long.parseLong(formatDate(diffDay(new Date(), -1)));
	}
    
    public static Date getTomorrowDate(){
    	return diffDay(new Date(), -1);
    }
    
    public static String getMonthOfTheDay(String date) {
        return date.replace("-", "").substring(0, 6);
    }
    
    public static List<String> getDateList(String startTime,String endTime){
    	List<String> dateList=new ArrayList<>();
    	Date endDate=parse(endTime);
    	Date startDate=parse(startTime);
    	while(startDate.before(endDate)){
    		dateList.add(formatDate(startDate));
    		startDate=diffDay(startDate,-1);
    	}
    	dateList.add(endTime);
    	return dateList;
    }
    
    public static int getWeekOfDate(Date dt) {
        
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);

        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w <= 0)
            w = 7;

        return w;
    }

    public static void main(String[] args) {
      
     
      
    	System.out.println(getTomorrowDay().toString().substring(2));
    	System.out.println(getTomorrowDate().getTime());
      System.out.println(getWeekOfDate(getTomorrowDate()));
      Date d1=getTomorrowDate();
      System.out.println(d1);
      
      for (int i=0;i<10;i++){
    	  d1=addSecond(d1, 300);
          System.out.println(d1);
      }
      String a="20171013 100000";
      System.out.println(getDateTime(a));
      
      System.out.println(new Date());
      System.out.println(new Date(new Date().getTime()+120*1000));
    }

}


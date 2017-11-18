package com.babel.common.utils.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {

	
	 private static final String DATE_FORMAT_DEFAULT_TIME = "yyyyMMddHH";
	 
	 private static final String DATE_FORMAT_TIME = "yyyyMMdd HH:mm:ss";
	 
	 
	 
	 public static String getCurrentTime() {
	        return formatDate(new Date());
	    }
	 
	 public static String formatDate(Date date) {
	        SimpleDateFormat dateformat = new SimpleDateFormat(DATE_FORMAT_DEFAULT_TIME);
	        return dateformat.format(date);
	    }
	 
	 public static String formatDateTime(Date date) {
	        SimpleDateFormat dateformat = new SimpleDateFormat(DATE_FORMAT_TIME);
	        return dateformat.format(date);
	    }
	 
	 public static Date getDateTime(String dateString) {
	        
	        return parse(dateString,DATE_FORMAT_TIME);
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
	 
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      System.out.println(formatDateTime(new Date()));
	}

}

package com.babel.common.utils.time;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {

	
	 private static final String DATE_FORMAT_DEFAULT_TIME = "yyyyMMddHH";
	 
	 
	 
	 public static String getCurrentTime() {
	        return formatDate(new Date());
	    }
	 
	 public static String formatDate(Date date) {
	        SimpleDateFormat dateformat = new SimpleDateFormat(DATE_FORMAT_DEFAULT_TIME);
	        return dateformat.format(date);
	    }
	 
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      System.out.println(getCurrentTime());
	}

}

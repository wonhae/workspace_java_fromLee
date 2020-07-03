package Total;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class WhatTimeIsIt {
	
	public static void main(String[] args) {
		
		Date today =new Date();
		
		System.out.println(today);
		
		Calendar cal =Calendar.getInstance();
		
		System.out.println(cal);
		
		int year =cal.get(Calendar.YEAR);
		int month =cal.get(Calendar.MONTH);
		int day =cal.get(Calendar.DAY_OF_MONTH);
		int hour =cal.get(Calendar.HOUR_OF_DAY);
		int min =cal.get(Calendar.MINUTE);
		int sec =cal.get(Calendar.SECOND);
		
		System.out.println("현재시각은"+year+ "년"+month+"월"+day+"일"+hour+"시"+min+"분"+sec+"초");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String datestr = sdf.format(cal.getTime());
		
		System.out.println(datestr);
		
		
		
		
	}

}

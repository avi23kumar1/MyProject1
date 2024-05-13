package com.comcast.crm.generic.contacttest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CurrentDate {

	public static void main(String[] args) {
		Date d=new Date();
	SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
	String currdate = sim.format(d);
	System.out.println(currdate);
	
	Calendar cal = sim.getCalendar();
	cal.add(Calendar.DAY_OF_MONTH,30);
	String nextdate = sim.format(cal.getTime());
	
	System.out.println(nextdate);
	}

}

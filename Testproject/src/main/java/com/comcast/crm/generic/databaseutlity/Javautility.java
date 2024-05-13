   package com.comcast.crm.generic.databaseutlity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Javautility {
	public int getrandomnumber()
	{
		Random rm=new Random();
		int k2 = rm.nextInt(5000);
		return k2;
		
	}
	public String getsystemdateYYYYDDMM()
	{
		Date d=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String currdate = sim.format(d);
		return currdate;	
	}
	
	public String getrequrieddateYYYYDDMM(int days)
	{
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,days);
		String nextdate = sim.format(cal.getTime());
			return nextdate;
	}
	

}

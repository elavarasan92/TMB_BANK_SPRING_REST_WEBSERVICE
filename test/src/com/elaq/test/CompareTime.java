package com.elaq.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CompareTime {

	public static void main(String[] args)
	{
		//SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

		Calendar calendar = Calendar.getInstance();
		Calendar startTime = Calendar.getInstance();
		startTime.set(Calendar.HOUR_OF_DAY,8);
		startTime.set(Calendar.MINUTE,00);
		
		Calendar endTime = Calendar.getInstance();
		endTime.set(Calendar.HOUR_OF_DAY,20);
		endTime.set(Calendar.MINUTE,30);
		
		
		
		//System.out.println(sdf.format(startTime.getTime()));
		//System.out.println(sdf.format(endTime.getTime()));
		
		//System.out.println(sdf.format(calendar.getTime()));
		 
		if((calendar.getTime().after(startTime.getTime()))&&(calendar.getTime().before(endTime.getTime())))
		{
			System.out.println("working");
		}
		
		Calendar day = Calendar.getInstance();
		
		if(day.get(Calendar.DAY_OF_WEEK)==1)
		{
			System.out.println("its sunday");
		}
		
		if(day.get(Calendar.DAY_OF_WEEK)==7)
		{
			//if(day.get(Calendar.WEEK_OF_MONTH))
			//System.out.println("its saturday");
		//}
		//System.out.println(day.get(Calendar.WEEK_OF_MONTH));
		if((day.get(Calendar.WEEK_OF_MONTH)==2)||(day.get(Calendar.WEEK_OF_MONTH)==4))
		{
			System.out.println("its second or fourth  saturday");
		}
		
		else
		{
			System.out.println("its normal  saturday");
		}
		}
	}
}

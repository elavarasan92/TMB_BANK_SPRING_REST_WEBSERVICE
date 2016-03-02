package com.elaq.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class RulesOfNEFT {

	public boolean allowNEFTTrans()
	{
	 //DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    Calendar currentDay = Calendar.getInstance();
	
    
    Calendar currentTime = Calendar.getInstance();
	Calendar startTime = Calendar.getInstance();
	startTime.set(Calendar.HOUR_OF_DAY,8);
	startTime.set(Calendar.MINUTE,00);
	
	Calendar endTime = Calendar.getInstance();
	endTime.set(Calendar.HOUR_OF_DAY,18);
	endTime.set(Calendar.MINUTE,30);
	
	boolean result = false;
    // if not suncurrentDay i.e, suncurrentDay =1 saturcurrentDay = 7
	if(currentDay.get(Calendar.DAY_OF_WEEK)!=1)
	{
		if(currentDay.get(Calendar.DAY_OF_WEEK)==7)
		{
			
			if((currentDay.get(Calendar.WEEK_OF_MONTH)==2)||(currentDay.get(Calendar.WEEK_OF_MONTH)==4))
			{
				System.out.println("its second or fourth saturday not working hours");
			}
			else
			{
			
				if((currentTime.getTime().after(startTime.getTime()))&&(currentTime.getTime().before(endTime.getTime())))
				{
					System.out.println("working this is saturday hours");
					result = true;
				}
				else
				{
					System.out.println("Not working hours this is saturday");
				}
			}
		}
		else
		{
			if((currentTime.getTime().after(startTime.getTime()))&&(currentTime.getTime().before(endTime.getTime())))
			{
				System.out.println("working hours not saturday");
				result = true;
			}
			else
			{
				System.out.println("Not working hours not saturday");
			}
		}
	}
	else
	{
		System.out.println("this is sunday not working hours");
	}
	
	return result;
}
	public static void main (String [] args)
	{
		RulesOfNEFT rulesOfNEFT = new RulesOfNEFT();
		System.out.println(rulesOfNEFT.allowNEFTTrans());
	
	}
}

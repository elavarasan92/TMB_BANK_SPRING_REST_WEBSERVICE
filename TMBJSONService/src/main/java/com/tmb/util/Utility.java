package com.tmb.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.tmb.pojo.CurrentDate;

public final class Utility {
	
	private Utility()
	{
	}
	public static CurrentDate getToday() throws ParseException
	{
		
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss EEEE dd/MM/yyyy W");
		
		   Calendar cal = Calendar.getInstance();
		   String currentDateInString = dateFormat.format(cal.getTime());
		   
		   
		   String [] dateArray = currentDateInString.split(" ");
		   CurrentDate currentDate  = new CurrentDate(); 
		   currentDate.setCurrentTime(dateArray[0]);
		   currentDate.setCurrentDay(dateArray[1]);
		   currentDate.setCurrentDate(dateFormat.parse(dateArray[2]));
		   currentDate.setCurrentWeek(Integer.parseInt(dateArray[4]));
		return currentDate;
		
	}

}

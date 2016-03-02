package com.elaq.test;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CurrentDateTime {


	  public static void main(String[] args) {

		   DateFormat dateFormatOfDate = new SimpleDateFormat("HH:mm:ss EEEE dd/MM/yyyy W");
	
		   Calendar cal = Calendar.getInstance();
		   String currentDateFormat = dateFormatOfDate.format(cal.getTime());
		   
		   
		   String [] dateArray = currentDateFormat.split(" ");
		 //  int currentWeek =Integer.parseInt(dateArray[0]);
		  // String currentDay = dateArray[1];
		   //String currentDate = dateArray[2];
		  // String currentTime = dateArray[3];
		   
		  // System.out.println(currentWeek+"----"+currentDay+"----"+currentDate+"----"+currentTime);
		   System.out.println(cal.get(Calendar.DAY_OF_WEEK));
		   System.out.println(cal.get(Calendar.DAY_OF_WEEK));
		 

	  
	}
}

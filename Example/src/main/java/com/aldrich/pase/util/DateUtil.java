package com.aldrich.pase.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({ "nls", "static-method","boxing" })
public class DateUtil 
{

	private static final Logger LOGGER = LoggerFactory.getLogger(DateUtil.class);
	/*
	 * static { // sets the default timezone of the system where the server is
	 * running to IST
	 * TimeZone.setDefault(TimeZone.getTimeZone(PASEConstants.DEFAULT_TIME_ZONE)
	 * ); }
	 */

	public Integer formatDate(String startYear)
	{
		Integer year = 0;
		SimpleDateFormat dateFormat = null;
		Date date = null;
		try
		{
			if(startYear.matches("[a-z]{1,9}(,){0,1}[0-9]{4}"))
			{
				if(startYear.matches("^[a-z]{1,3}[0-9]{4}"))
				{
					dateFormat = new SimpleDateFormat("MMMyyyy");
					date = (dateFormat).parse(startYear);					
				}
				else if(startYear.matches("^[a-z]{1,3}(,){1}[0-9]{4}"))
				{
					dateFormat = new SimpleDateFormat("MMM,yyyy");
					date = (dateFormat).parse(startYear);						
				}
				else if(startYear.matches("[a-z]{1,9}[0-9]{4}"))
				{
					dateFormat = new SimpleDateFormat("MMMMMyyyy");
					date = (dateFormat).parse(startYear);				
				}
				else if(startYear.matches("^[a-z]{1,9}(,){1}[0-9]{4}"))
				{
					dateFormat = new SimpleDateFormat("MMMMM,yyyy");
					date = (dateFormat).parse(startYear);
					
				}
				else
				{
					//do nothing...
				}				
			}			
			else if(startYear.matches("[a-z]{1,9}[0-9]{2}(,){0,1}[0-9]{4}"))
			{
				if(startYear.matches("^[a-z]{1,3}[0-9]{2}[0-9]{4}"))
				{
					dateFormat = new SimpleDateFormat("MMMddyyyy");
					date = (dateFormat).parse(startYear);						
				}
				else if(startYear.matches("^[a-z]{1,3}[0-9]{2}(,){1}[0-9]{4}"))
				{
					dateFormat = new SimpleDateFormat("MMMdd,yyyy");
					date = (dateFormat).parse(startYear);				
				}
				else if(startYear.matches("[a-z]{1,9}[0-9]{2}[0-9]{4}"))
				{
					dateFormat = new SimpleDateFormat("MMMMMddyyyy");
					date = (dateFormat).parse(startYear);					
				}
				else if(startYear.matches("^[a-z]{1,9}[0-9]{2}(,){1}[0-9]{4}"))
				{
					dateFormat = new SimpleDateFormat("MMMMMdd,yyyy");
					date = (dateFormat).parse(startYear);					
				}
				else
				{
					//do nothing...
				}
			}
			else
			{
				//do nothing...
			}
			
			if(date!=null)
			{
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(date);
				year = calendar.get(Calendar.YEAR);
				System.out.println(year);
			}
		}
		catch(Exception e)
		{
			LOGGER.error("Exception raised :formatDate method of DateUtil class", e.getMessage());
		}
		return year;
	}
}

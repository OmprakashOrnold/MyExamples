package com.aldrich.dateconversions;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class PersonalMoveAlert {

	private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  

	public static void main(String[] args) {

		String yearMonthText="64 years 5 months";
		
		
		
		Date date=null;
		date=getDateFromYearMonthText(yearMonthText);		
		System.out.println(formatter.format(date));
		
		
	}

	public static Date getDateFromYearMonthText(String yearMonthText) {
		Date date=null;
		try{
			long spaces = yearMonthText.trim().chars().filter(c -> c == (int)' ').count();
			if(spaces==1){			
				date = getSingleMonthYearConvertedDate(yearMonthText);
			}

			if(spaces==3){			
				date =getMonthYearCombineConvertedDate(yearMonthText);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return date;
	}

	public static Date getMonthYearCombineConvertedDate(String yearMonthText) {
		Date date=null;
		String months_info = null;
		String years_info =null;
		String yearWithSorWithoutS=null;
		try{

			if (yearMonthText.contains("months")||yearMonthText.contains("month")||yearMonthText.contains("years")||yearMonthText.contains("year")) {
				months_info = yearMonthText; 
				years_info = yearMonthText; 
				months_info =months_info.replace("months", "").trim().replace("month", "").trim();
				String yearTextArray[]=months_info.split(" ");
				yearWithSorWithoutS=yearTextArray[1].trim();
				if(months_info.contains(yearWithSorWithoutS))
				{
					date = getConvertedMonthYearFromCalender(months_info, years_info, yearWithSorWithoutS);				
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return date;	
	}

	public static Date getSingleMonthYearConvertedDate(String yearMonthText) {
		Date date=null;
		String monthWithSorWithoutS=null;
		try{
			String monthTextArray[]=yearMonthText.split(" ");
			monthWithSorWithoutS=monthTextArray[1].trim();

			if(yearMonthText.contains("month")){
				if (yearMonthText.contains(monthWithSorWithoutS)) {

					date =getConvertedMonthFromCalender(yearMonthText, monthWithSorWithoutS);
				} 
			}

			if(yearMonthText.contains("year")){
				if (yearMonthText.contains(monthWithSorWithoutS)){
					date = getConvertedYearFromCalender(yearMonthText, monthWithSorWithoutS);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return date;
	}

	public static Date getConvertedMonthYearFromCalender(String months_info, String years_info,String yearWithSorWithoutS) {

		int months_count = 0;
		int years_count = 0;
		Date currentDate =null;
		Date actualDate =null;

		try{
			String months[]=months_info.split(yearWithSorWithoutS);
			months_count = Integer.parseInt(months[1].trim());
			years_info =years_info.replace("years", "").trim().replace("year", "").trim();				
			years_count = Integer.parseInt(months[0].trim());	

			currentDate = new Date();
			Calendar c = Calendar.getInstance();
			c.setTime(currentDate);
			c.add(Calendar.YEAR, -years_count);
			c.add(Calendar.MONTH, -months_count);
			actualDate = c.getTime();

		}catch(Exception e){
			e.printStackTrace();
		}
		return actualDate;
	}

	public static Date getConvertedYearFromCalender(String yearMonthText, String monthWithSorWithoutS) {

		String month_info =null;
		Date currentDate=null;
		Date actualDate =null;
		try{

			month_info = yearMonthText;               
			month_info =month_info.replace(monthWithSorWithoutS, "").trim();
			int month_count = Integer.parseInt(month_info);
			currentDate = new Date();
			Calendar c = Calendar.getInstance();
			c.setTime(currentDate);
			c.add(Calendar.YEAR, -month_count);
			actualDate = c.getTime();

		}catch(Exception e){
			e.printStackTrace();
		}
		return actualDate;
	}

	public static Date getConvertedMonthFromCalender(String yearMonthText, String monthWithSorWithoutS) {

		String year_info =null;
		Date currentDate=null;
		Date actualDate =null;

		try{
			year_info = yearMonthText;               
			year_info =year_info.replace(monthWithSorWithoutS,"").trim();
			int months_count = Integer.parseInt(year_info);
			currentDate = new Date();
			Calendar c = Calendar.getInstance();
			c.setTime(currentDate);
			c.add(Calendar.MONTH, -months_count);
			actualDate = c.getTime();

		}catch(Exception e){
			e.printStackTrace();
		}
		return actualDate;
	}



}

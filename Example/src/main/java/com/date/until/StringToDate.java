package com.date.until;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StringToDate {	

	public static void main(String[] args) {

		String dateInString ="21 02 2014";

		System.out.println(convertAnyTypeDateToSingleFormat(dateInString));
	}

	public static Date convertAnyTypeDateToSingleFormat(String dateInString) {
		String dateFormat=null;
		Date date =null;


		String regex1="\\d{1,2}\\s(Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|Jun(e)?|Jul(y)?|Aug(ust)?|Sep(tember)?|Oct(ober)?|Nov(ember)?|Dec(ember)?) \\d{1,4}";
		String regex2="((Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|Jun(e)?|Jul(y)?|Aug(ust)?|Sep(tember)?|Oct(ober)?|Nov(ember)?|Dec(ember)?)\\s([1-9]|([12][0-9])|(3[01])),\\s\\d\\d\\d\\d)";
		String regex3="\\d{1,2}\\s\\d{1,2}\\s\\d{4,4}";

		String regex4="\\d{4,4}[\\/]\\d{1,2}[\\/]\\d{1,2}";
		String regex5="\\d{4,4}[\\-]\\d{1,2}[\\-]\\d{1,2}";
        String regex6="\\d{1,2}\\-(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|dec)\\-\\d{4,4}";
        String regex7="\\d{1,2}[\\/]\\d{1,2}[\\/]\\d{4,4}";
        
		if(dateInString.matches(regex1)){
			dateFormat="dd MMM yyyy";
		}else if(dateInString.matches(regex2)){
			dateFormat="MMM dd, yyyy";
		}else if(dateInString.matches(regex3)){
			dateFormat="dd MM yyyy";
		}else if(dateInString.matches(regex4)){
			dateFormat="yyyy/MM/dd";
		}else if(dateInString.matches(regex5)){
			dateFormat="yyyy-MM-dd";
		}else if(dateInString.matches(regex6)){
			dateFormat="d-MMM-yyyy";
		}else if(dateInString.matches(regex7)){
			dateFormat="d/MM/yyyy";
		}

		SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
		try {
			date = formatter.parse(dateInString);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return date;
	}

}

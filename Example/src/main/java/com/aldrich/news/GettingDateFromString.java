package com.aldrich.news;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GettingDateFromString {

	public static void main(String[] args) {
	
		String dateInString="Sept. 18, 2019";
		System.out.println(dateInString.toLowerCase().replace("th", "").replace("nd", ""));
		System.out.println(convertAnyTypeDateToSingleFormat(dateInString));
	}

	public static Date convertAnyTypeDateToSingleFormat(String dateInString) 
	{
		String dateFormat=null;
		Date date =null;


		String regex1="\\d{4,4}-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])";
		String regex2="(0?[1-9]|[12][0-9]|3[01])\\/(0?[1-9]|1[012])\\/\\d{4,4}";
		String regex3="(0[1-9]|1[012])\\/(0[1-9]|[12][0-9]|3[01])\\/\\d{4,4}";
		String regex4="(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])\\-\\d{4,4}";
		String regex5="(0?[1-9]|[12][0-9]|3[01])\\-(0?[1-9]|1[012])\\-\\d{4,4}";
		String regex6="\\d{4,4}\\/(0?[1-9]|1[012])\\/(0?[1-9]|[12][0-9]|3[01])";
		String regex7="(0?[1-9]|[12][0-9]|3[01])\\s(Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|Jun(e)?|Jul(y)?|Aug(ust)?|Sep(tember)?|Oct(ober)?|Nov(ember)?|Dec(ember)?)\\s\\d{4,4}";
		String regex8="(0?[1-9]|[12][0-9]|3[01])\\-(Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|Jun(e)?|Jul(y)?|Aug(ust)?|Sep(tember)?|Oct(ober)?|Nov(ember)?|Dec(ember)?)\\-\\d{4,4}";
		String regex9="(0?[1-9]|[12][0-9]|3[01])\\,\\s(Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|Jun(e)?|Jul(y)?|Aug(ust)?|Sep(tember)?|Oct(ober)?|Nov(ember)?|Dec(ember)?)\\s\\d{4,4}";
		String regex10="(0?[1-9]|[12][0-9]|3[01])\\s(Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|Jun(e)?|Jul(y)?|Aug(ust)?|Sep(tember)?|Oct(ober)?|Nov(ember)?|Dec(ember)?)\\,\\s\\d{4,4}";
		String regex11="(Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|Jun(e)?|Jul(y)?|Aug(ust)?|Sep(tember)?|Oct(ober)?|Nov(ember)?|Dec(ember)?)\\s(0?[1-9]|[12][0-9]|3[01])\\s\\d{4,4}";
		String regex12="(Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|Jun(e)?|Jul(y)?|Aug(ust)?|Sep(tember)?|Oct(ober)?|Nov(ember)?|Dec(ember)?)\\,\\s(0?[1-9]|[12][0-9]|3[01])\\s\\d{4,4}";
		String regex13="(Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|Jun(e)?|Jul(y)?|Aug(ust)?|Sep(tember)?|Oct(ober)?|Nov(ember)?|Dec(ember)?)\\s(0?[1-9]|[12][0-9]|3[01])\\,\\s\\d{4,4}";
		String regex14="[A-Za-z]{3,9}\\s(Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|Jun(e)?|Jul(y)?|Aug(ust)?|Sep(tember)?|Oct(ober)?|Nov(ember)?|Dec(ember)?)\\,\\s\\d{1,2}\\s\\d{4,4}";
		String regex15="(0?[1-9]|[12][0-9]|3[01])\\s(0?[1-9]|1[012])\\s\\d{4,4}";
		String regex16="\\d{4,4}\\/(0?[1-9]|1[012])\\/(0?[1-9]|[12][0-9]|3[01])";
		String regex17="(Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|Jun(e)?|Jul(y)?|Aug(ust)?|Sep(tember)?|Oct(ober)?|Nov(ember)?|Dec(ember)?)\\.\\s(0?[1-9]|[12][0-9]|3[01])\\,\\s\\d{4,4}";
				
				
		dateInString=dateInString.toLowerCase().replace("t.", "").replace("th", "").replace("nd", "");
			
		if(dateInString!=null&&!dateInString.isEmpty())
		{
			if(dateInString.matches(regex1)){
				dateFormat="yyyy-MM-dd";
			}else if(dateInString.matches(regex2)){
				dateFormat="dd/MM/yyyy";
			}else if(dateInString.matches(regex3)){
				dateFormat="MM/dd/yyyy";
			}else if(dateInString.matches(regex4)){
				dateFormat="MM-dd-yyyy";
			}else if(dateInString.matches(regex5)){
				dateFormat="dd-MM-yyyy";
			}else if(dateInString.matches(regex6)){
				dateFormat="yyyy/MM/dd";
			}else if(dateInString.matches(regex7.toLowerCase())){
				dateFormat="dd MMM yyyy";
			}else if(dateInString.matches(regex8.toLowerCase())){
				dateFormat="dd-MMM-yyyy";
			}else if(dateInString.matches(regex9.toLowerCase())){
				dateFormat="dd, MMM yyyy";
			}else if(dateInString.matches(regex10.toLowerCase())){
				dateFormat="dd MMM, yyyy";
			}else if(dateInString.matches(regex11.toLowerCase())){
				dateFormat="MMM dd yyyy";
			}else if(dateInString.matches(regex12.toLowerCase())){
				dateFormat="MMM, dd yyyy";
			}else if(dateInString.matches(regex13.toLowerCase())){
				dateFormat="MMM dd, yyyy";
			}else if(dateInString.matches(regex14.toLowerCase())){
				dateFormat="E MMM, dd yyyy";
			}else if(dateInString.matches(regex15)){
				dateFormat="dd MM yyyy";
			}else if(dateInString.matches(regex16)){
				dateFormat="yyyy/MM/dd";
			}else if(dateInString.matches(regex17)){
				dateFormat="MMM. dd, yyyy";
			}else if((dateInString).matches(regex13.toLowerCase())){
				dateFormat="MMM dd, yyyy";
			}


			SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
			try {
				date = formatter.parse(dateInString);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}		
		return date;
	}
}

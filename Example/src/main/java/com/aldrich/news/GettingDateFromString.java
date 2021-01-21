package com.aldrich.news;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.aldrich.pase.util.PASEConstants;

public class GettingDateFromString {

	public static void main(String[] args) {
		
		Document document = null;

		List<String> url=new ArrayList<String>();
		
		url.add("https://preservica.com/resources/press-releases/preservica-congratulates-2020-emmett-leahy-award-winner");
		
		for (String string : url) {
			
		
		
		document=getURLResponse(string.trim());
		
	//	System.out.println(document.text());
		String dateInString=getDateFromString(document.text().replace(".", "").toLowerCase().replace("th", "").replace("nd", "").replace("rd", "").replace("t.", ""));
		
		System.out.println(dateInString);
		//System.out.println(convertAnyTypeDateToSingleFormat(dateInString));
		}
		
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
			}else if(dateInString.matches(regex17.toLowerCase())){
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
	

	public static String getDateFromString(String docText) {
		docText = docText.toLowerCase();
		String date = "";
		String regex1 = "\\d{4,4}-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])";
		String regex2 = "(0?[1-9]|[12][0-9]|3[01])\\/(0?[1-9]|1[012])\\/\\d{4,4}";
		String regex3 = "(0[1-9]|1[012])\\/(0[1-9]|[12][0-9]|3[01])\\/\\d{4,4}";
		String regex4 = "(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])\\-\\d{4,4}";
		String regex5 = "(0?[1-9]|[12][0-9]|3[01])\\-(0?[1-9]|1[012])\\-\\d{4,4}";
		String regex6 = "\\d{4,4}\\/(0?[1-9]|1[012])\\/(0?[1-9]|[12][0-9]|3[01])";
		String regex7 = "(0?[1-9]|[12][0-9]|3[01])\\s(Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|Jun(e)?|Jul(y)?|Aug(ust)?|Sep(tember)?|Oct(ober)?|Nov(ember)?|Dec(ember)?)\\s\\d{4,4}"
				.toLowerCase();
		String regex8 = "(0?[1-9]|[12][0-9]|3[01])\\-(Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|Jun(e)?|Jul(y)?|Aug(ust)?|Sep(tember)?|Oct(ober)?|Nov(ember)?|Dec(ember)?)\\-\\d{4,4}"
				.toLowerCase();
		String regex9 = "(0?[1-9]|[12][0-9]|3[01])\\,\\s(Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|Jun(e)?|Jul(y)?|Aug(ust)?|Sep(tember)?|Oct(ober)?|Nov(ember)?|Dec(ember)?)\\s\\d{4,4}"
				.toLowerCase();
		String regex10 = "(0?[1-9]|[12][0-9]|3[01])\\s(Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|Jun(e)?|Jul(y)?|Aug(ust)?|Sep(tember)?|Oct(ober)?|Nov(ember)?|Dec(ember)?)\\,\\s\\d{4,4}"
				.toLowerCase();
		String regex11 = "(Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|Jun(e)?|Jul(y)?|Aug(ust)?|Sep(tember)?|Oct(ober)?|Nov(ember)?|Dec(ember)?)\\s(0?[1-9]|[12][0-9]|3[01])\\s\\d{4,4}"
				.toLowerCase();
		String regex12 = "(Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|Jun(e)?|Jul(y)?|Aug(ust)?|Sep(tember)?|Oct(ober)?|Nov(ember)?|Dec(ember)?)\\,\\s(0?[1-9]|[12][0-9]|3[01])\\s\\d{4,4}"
				.toLowerCase();
		String regex13 = "(Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|Jun(e)?|Jul(y)?|Aug(ust)?|Sep(tember)?|Oct(ober)?|Nov(ember)?|Dec(ember)?)\\s(0?[1-9]|[12][0-9]|3[01])\\,\\s\\d{4,4}"
				.toLowerCase();
		String regex14 = "[A-Za-z]{3,9}\\s(Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|Jun(e)?|Jul(y)?|Aug(ust)?|Sep(tember)?|Oct(ober)?|Nov(ember)?|Dec(ember)?)\\,\\s\\d{1,2}\\s\\d{4,4}"
				.toLowerCase();
		String regex15 = "(0?[1-9]|[12][0-9]|3[01])\\s(0?[1-9]|1[012])\\s\\d{4,4}";
		String regex16 = "\\d{4,4}\\/(0?[1-9]|1[012])\\/(0?[1-9]|[12][0-9]|3[01])";
		String regex17 = "(Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|Jun(e)?|Jul(y)?|Aug(ust)?|Sep(tember)?|Oct(ober)?|Nov(ember)?|Dec(ember)?)\\.\\s(0?[1-9]|[12][0-9]|3[01])\\,\\s\\d{4,4}"
				.toLowerCase();

	

		String dateFormat = "(" + regex1 + ")|(" + regex2 + ")|(" + regex3 + ")|(" + regex4 + ")|(" + regex5 + ")|("
				+ regex6 + ")|(" + regex7 + ")|(" + regex8 + ")|(" + regex9 + ")|(" + regex10 + ")|(" + regex11 + ")|("
				+ regex12 + ")|(" + regex13 + ")|(" + regex14 + ")|(" + regex15 + ")|(" + regex16 + ")|(" + regex17
				+ ")";

		if (docText != null && !docText.isEmpty()) {
			try {
				Pattern compile = Pattern.compile(dateFormat);
				Matcher matcher = compile.matcher(docText);
				if (matcher.find()) {
					date = matcher.group(0);
				}
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		return date;
	}


	public static Document getURLResponse(String url) {
		Document document = null;
		try {
			document = Jsoup.connect(url).followRedirects(true).userAgent(PASEConstants.USER_AGENT).ignoreHttpErrors(true).timeout(0).get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return document;
	}

}

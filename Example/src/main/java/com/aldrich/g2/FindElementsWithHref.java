package com.aldrich.g2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class FindElementsWithHref {

	public static void main(String[] args) {
		Document documnet1 = null;
		String newsPageLink="https://www.woundtech.net/vice-president-of-finance-mohammed-sow/";
		getNewsInfo(newsPageLink);

	}

	public static void getNewsInfo(String newsPageLink) {
		Document documnet1;
		String title=null;
		String description=null;
		String date=null;
		
		try {			
			documnet1=getURLResponse(newsPageLink);

			title=documnet1.getElementsByTag("h1").text();
			System.out.println(title);

			description=documnet1.getElementsByTag("p").text();
			System.out.println(description);

			if(getDateFromString(documnet1.getElementsByTag("p").text())!=null)
			{
				date=getDateFromString(documnet1.getElementsByTag("p").text());
				System.out.println(date);	
			}else{
				date=getDateFromString(documnet1.select("span").text());
				System.out.println(date);	
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//To connect url
	public static Document getURLResponse(String url)
	{
		Document documnet=null;
		try {
			documnet=Jsoup.connect(url)
					.userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:79.0) Gecko/20100101 Firefox/79.0")
					.ignoreHttpErrors(true).get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return documnet;	
	}

	public static String getDateFromString(String string) {

		String location=null;
		String street = "((January )|(February )|(March)|(April)|(May)|(June)|(July)|(August)|(September)|(October)|(November)|(December))\\s([1-9]|([12][0-9])|(3[01])),\\s\\d\\d\\d\\d";
		try {
			Pattern compile = Pattern.compile(street);
			Matcher matcher = compile.matcher(string);
			if (matcher.find()) {
				location = matcher.group(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return location;
	}


}

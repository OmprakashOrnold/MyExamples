package com.aldrich.news;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class clinicalarchitecture {


	public static void main(String[] args) {

		Document document = null;
		Document document1 = null;

		try{

		/*	document=getDocument("https://www.orbistechnologies.com/news/");

			Elements companyName1=document.select("a[class='btn btn-primary elementor-button elementor-size-md lastudio-more']");
			for (Element element : companyName1) {

				document1=getDocument(element.attr("href"));
				Elements title=document1.select("meta[property='og:title']");
				//System.out.println(title.attr("content"));


				Elements description=document1.select("meta[property='og:description']");
				//System.out.println(description.attr("content"));
				
				System.out.println(getDateFromString(document1.text()));

			}*/
			
			document=getDocument("https://blog.clinicalarchitecture.com/all");
			//Elements companyName1=document.select("h6[class='blog-title']");
			//p[class='description']
			Elements companyName1=document.select("p[class='description']");
			for (Element element : companyName1) {
				//System.out.println(element.getElementsByTag("a").attr("href"));
				System.out.println(element.text());
			    //   document1=getDocument(element.getElementsByTag("a").attr("href"));
				
			     
			 
				//Elements title=document1.select("meta[property='og:title']");
			//	System.out.println(title.attr("content"));


				//Elements description=document1.select("meta[property='og:description']");
				//System.out.println(description.attr("content"));
				
			//	System.out.println(getDateFromString(document1.text()));

			}

		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static Document getDocument(String url)
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

		String date=null;
		String regex1="\\d{1,2}\\s(Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|Jun(e)?|Jul(y)?|Aug(ust)?|Sep(tember)?|Oct(ober)?|Nov(ember)?|Dec(ember)?) \\d{1,4}";
		String regex2="((Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|Jun(e)?|Jul(y)?|Aug(ust)?|Sep(tember)?|Oct(ober)?|Nov(ember)?|Dec(ember)?)\\s([1-9]|([12][0-9])|(3[01])),\\s\\d\\d\\d\\d)";
		String regex3="\\d{1,2}\\s\\d{1,2}\\s\\d{4,4}";

		String regex4="\\d{4,4}[\\/]\\d{1,2}[\\/]\\d{1,2}";
		String regex5="\\d{4,4}[\\-]\\d{1,2}[\\-]\\d{1,2}";
        String regex6="\\d{1,2}\\-(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|dec)\\-\\d{4,4}";
        String regex7="\\d{1,2}[\\/]\\d{1,2}[\\/]\\d{4,4}";
        
		String dateFormat ="("+regex1+")|("+regex2+")|("+regex3+")|("+regex4+")|("+regex5+")|("+regex6+")|("+regex7+")";
				
		try {
			Pattern compile = Pattern.compile(dateFormat);
			Matcher matcher = compile.matcher(string);
			if (matcher.find()) {
				date = matcher.group(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}
	

}

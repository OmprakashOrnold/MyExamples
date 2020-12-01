package com.aldrich.conferance;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ConferanceLink1 {

	public static void main(String[] args) {
		
		Document document=null;
		Document document1=null;
		
		try {
			document=getDocument("https://www.asugsvsummit.com/companies?e0a3563f_page=3");
			
			Elements mainLinks=document.select("a[class='companies__item-logo-wrap w-inline-block']");
			
			for (Element element : mainLinks) {
				//System.out.println(element.attr("abs:href"));
				document1=getDocument(element.attr("abs:href"));
				
				Elements title=document1.select("h2");
				//System.out.println(title.text());
				
				Elements url=document1.select("a[class='_00button-navy box w-button']");
			    System.out.println(url.attr("href"));
			}
		
			
			
		} catch (Exception e) {
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
}

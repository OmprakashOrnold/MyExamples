package com.aldrich.conferance;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class virtualbigshowSpeakers {

	public static void main(String[] args) {

		Document document=null;
		try {
			
		
				document=getDocument("https://virtualbigshow.nrf.com/speakers");
				
				Elements mainLinks=document.select("div[class='views-field views-field-field-speaker-company']");
				for (Element element : mainLinks) {
					
					System.out.println(element.text());
				
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

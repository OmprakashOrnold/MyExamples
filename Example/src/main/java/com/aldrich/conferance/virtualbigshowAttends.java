package com.aldrich.conferance;

import java.io.File;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

//virtualbigshow
public class virtualbigshowAttends {

	public static void main(String[] args) {
	
		Document document = null;
		
		try{
					
			document=getDocument("https://virtualbigshow.nrf.com/who-attends");

			Elements companyName1=document.select("div[class='list-upload-list-alpha-wrapper']");
			for (Element element : companyName1) {
				Elements companyName2=element.select("div[class='list-upload-list-item']");
				for (Element element2 : companyName2) {
					System.out.println(element2.text());
				}
	
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

}

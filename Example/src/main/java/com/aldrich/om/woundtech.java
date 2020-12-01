package com.aldrich.om;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.aldrich.pase.util.PASEConstants;

public class woundtech {

	public static void main(String[] args) {

		Document document=null;
	
		try {
		
				
			
			document=Jsoup.connect("https://www.woundtech.net/blog/page/2/").userAgent(PASEConstants.USER_AGENT).ignoreContentType(true).ignoreHttpErrors(true).get();

			//System.out.println(document);
			Elements ele=document.select("h2[class='blog-single-title']");

			for (Element element : ele) {
				System.out.println(element.text());
			}
			
			Elements ele3=document.select("h2[class='blog-single-title']");

			for (Element element : ele3) {
				//System.out.println(element.getElementsByTag("a").attr("href"));
			}
			
			//span[class='far fa-clock']
			Elements ele2=document.select("span[class='published']");

			for (Element element : ele2) {
			///-	System.out.println(element.getElementsByTag("a").text());
			}
		
			//div[class='page-content']
			Elements ele4=document.select("div[class='page-content']");

			for (Element element : ele4) {
				//System.out.println(element.getElementsByTag("p").text());
			}

			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}

package com.aldrich.om;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.aldrich.pase.util.PASEConstants;

public class processmaker {

	public static void main(String[] args) {

		Document document=null;
		String title=null;
		try {
			document=Jsoup.connect("https://www.processmaker.com/resources/customer-success/news/page/7/").userAgent(PASEConstants.USER_AGENT).ignoreContentType(true).ignoreHttpErrors(true).get();

			Elements ele=document.select("h5[class='card-title py-0']");

			for (Element element : ele) {
				System.out.println(element.text());
			}
			
			System.out.println("---------------------------------------------------------------");

			//p[class='card-text']
			Elements ele1=document.select("p[class='card-text']");

			for (Element element : ele1) {
				System.out.println(element.text());
			}

			System.out.println("---------------------------------------------------------------");
			//p[class='card-text date']
			Elements ele2=document.select("p[class='card-text date']");

			for (Element element : ele2) {
				System.out.println(element.text());
			}

			System.out.println("---------------------------------------------------------------");
			Elements ele3=document.select("a");

			if(ele3.hasAttr("href"))
			{
				for (Element element : ele3) {
					System.out.println(element);
				}
			}
			System.out.println("---------------------------------------------------------------");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}

package com.selenium.scripts;

import java.net.UnknownHostException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GoogleTest {

	public static void main(String[] args) {
		Document document=null;
		String keyword="Alere San Diego, Inc.";


		document=getDocument(keyword);
		Elements links=document.select("div[class='yuRUbf']");
		for (Element element : links) {
			System.out.println(element.getElementsByTag("a").attr("href"));
		}


	}

	public static Document getDocument(String companyName) {
		Document document=null;

		try {
			document=Jsoup.connect("https://www.google.com/search?q="+companyName.replace(" ", "%20"))
					.userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:79.0) Gecko/20100101 Firefox/79.0")
					.ignoreHttpErrors (true) // This is very important, otherwise it will report HTTP error fetching URL. Status = 404
					.get();  

		}
		catch (UnknownHostException  e) {
			e.getMessage();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return document;
	}

}

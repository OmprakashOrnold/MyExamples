package com.aldrich.om;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.aldrich.pase.util.PASEConstants;

public class ainq {

	public static void main(String[] args) {

		Document document=null;
		String title=null;
		String url=null;
		String description=null;
		String date=null;

		try {

				document=Jsoup.connect("https://ainq.com/media/press-releases/").userAgent(PASEConstants.USER_AGENT).ignoreContentType(true).ignoreHttpErrors(true).get();

				Elements ele=document.select("h4[class='entry-title']");

				for (Element element : ele) {
					//System.out.println(element.text());
					
				}

				Elements ele6=document.select("h4[class='entry-title']");

				for (Element element : ele6) {
					System.out.println(element.getElementsByTag("a").attr("href"));
				}

				System.out.println();
				Elements ele5=document.select("div[class='post-content-inner']");

				for (Element element : ele5) {
					System.out.println(element.text());
				}
				System.out.println();

				Elements ele3=document.select("span[class='published']");

				for (Element element : ele3) {
					System.out.println(element.text());
				}
				//System.out.println("-------------------------------");


			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}

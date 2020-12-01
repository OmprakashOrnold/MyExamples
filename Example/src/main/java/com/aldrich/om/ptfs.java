package com.aldrich.om;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.aldrich.pase.util.PASEConstants;

public class ptfs {

	public static void main(String[] args) {

		Document document=null;

		try {


			for (int i = 1; i <=19; i++) {


				document=Jsoup.connect("https://ptfs.com/resources/news/page/"+i).userAgent(PASEConstants.USER_AGENT).ignoreContentType(true).ignoreHttpErrors(true).get();

				Elements ele=document.select("div[class='post-title']");

				for (Element element : ele) {
					//System.out.println(element.text());
				}

				Elements ele5=document.select("div[class='post-title']");

				for (Element element : ele5) {
					//System.out.println(element.getElementsByTag("a").attr("href"));
				}

				//System.out.println("-------------------------------");
				//post-excerpt
				Elements ele2=document.select("div[class='post-excerpt']");

				for (Element element : ele2) {
					//System.out.println(element.text());
				}
				//System.out.println("-------------------------------");
				//meta-date
				Elements ele3=document.select("time[class='updated']");

				for (Element element : ele3) {
					System.out.println(element.text());
				}
				//System.out.println("-------------------------------");


			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}

package com.aldrich.om;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.aldrich.pase.util.PASEConstants;

public class ehealth {

	public static void main(String[] args) {

		Document document=null;

		try {



			document=Jsoup.connect("https://ehealthtechnologies.com/news-and-events/blog").userAgent(PASEConstants.USER_AGENT).ignoreContentType(true).ignoreHttpErrors(true).get();


			Elements ele=document.select("div[class='fusion-post-content post-content']");

			for (Element element : ele) {
				//System.out.println(element.getElementsByTag("a").attr("href"));
			}



			Elements ele1=document.select("p[class='fusion-single-line-meta']");

			for (Element element : ele1) {
				System.out.println(element.getElementsByTag("span"));
			}


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}

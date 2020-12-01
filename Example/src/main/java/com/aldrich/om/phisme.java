package com.aldrich.om;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.aldrich.pase.util.PASEConstants;

public class phisme {

	public static void main(String[] args) {

		Document document=null;
	
		try {
		
				
			
			document=Jsoup.connect("https://cofense.com/news-center/").userAgent(PASEConstants.USER_AGENT).ignoreContentType(true).ignoreHttpErrors(true).get();

			//System.out.println(document);
			Elements div_elements=document.select("div");
			if (div_elements != null && div_elements.size() > 0) {
			    for (Element element: div_elements) {
			        try {
			            if (element.hasAttr("class") && element.attr("class").equals("news-item")) {
			              System.out.println(element);
			            }
			        } catch (Exception e) {
			            e.printStackTrace();
			        }
			    }
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}

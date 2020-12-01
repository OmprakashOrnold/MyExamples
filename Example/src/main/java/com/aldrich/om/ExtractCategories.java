package com.aldrich.om;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.aldrich.pase.util.PASEConstants;

public class ExtractCategories {

	public static void main(String[] args) {
		Document document = null;
		String request1=null;

		//https://www.g2.com/categories?q[category_type_eq]=service
		document=getURLResponse("https://www.g2.com/categories?q[category_type_eq]=service");
		Elements s=document.select("a[class='link js-log-click']");
		for (Element element : s) {
			for (int i = 1; i < 10; i++) {	
				 request1=element.attr("abs:href")+"?order=popular&page="+i+"#product-list";			
			}
			//System.out.println(request1);
			getProductLinks(request1);
			
		}

	}
	
	public static String getProductLinks(String categoryLink) {
		Document document;
		String title;
		String productsLinks=null;
		document=getURLResponse(categoryLink);
		title=document.getElementsByTag("title").text();
		System.out.println(title);
		if(title.startsWith("Best"))
		{
			Elements links=document.select("a[class='link js-log-click']");

			for (Element link : links) {
				System.out.println(link.attr("href"));
				productsLinks=link.attr("href");
				System.out.println(productsLinks);
			}
		}
		return productsLinks;
	}

	public static Document getURLResponse(String url) {
		Document document = null;
		try {
			document = Jsoup.connect(url).followRedirects(true).userAgent(PASEConstants.USER_AGENT).ignoreHttpErrors(true).timeout(0).get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return document;
	}


}

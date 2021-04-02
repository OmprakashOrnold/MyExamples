package com.aldrich.g2;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class GeneralG2Check {

	public static void main(String[] args) {
		String url="https://www.g2.com/categories/pharma-and-biotech?order=popular&page=2#product-list";
		Document documnet=null;
		
		documnet=getURLResponse(url);
		System.out.println(documnet);
		
		

	}
	
	
	public static Document getURLResponse(String url)
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

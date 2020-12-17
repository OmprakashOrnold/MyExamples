package com.aldrich.news;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class NewsValidLink {

	public static void main(String[] args) {
		Document documnet=null;
		String blogPageUrls=null;
		String newsUrl="https://www.salespad.com";
		String newsContentUrl=null;
		String className=null;
		String onlyNewsUrls=null;


		documnet=getURLResponse(newsUrl);
		Elements elements1 = documnet.select("a[href]");

		String regex="^(https:|http:)(.)*";


		List<String> listBlogPageUrls=new ArrayList<String>();
		for (Element e : elements1) {

			blogPageUrls=e.attr("abs:href");	
			if(blogPageUrls.matches(regex))
			{
				listBlogPageUrls.add(blogPageUrls);
			}
		}

		//using lambda expression
		newsContentUrl=listBlogPageUrls.stream()
				.filter(i -> i.replace("https://wwww.", "").replace("http://wwww.", "").replace("https://", "").replace("http://", "")
						.length()>60).findFirst()
				.toString().replace("Optional[", "").replace("]", "");
		
        //miltiple url repeates
		List<String> listNewsContentUrl=new ArrayList<String>();
		Elements elements=documnet.getElementsByAttributeValueContaining("href", newsContentUrl);
		for (Element element : elements) {
			listNewsContentUrl.add(element.parent().className());
		}
		
		className=listNewsContentUrl.stream().findFirst().toString().replace("Optional[", "").replace("]", "");
		if(!className.isEmpty()&&className!=null)
		{
			Elements blogUrlsElement=documnet.select("."+className);	
			for (Element element : blogUrlsElement) {
				if(element.childrenSize()!=0)
				{
					onlyNewsUrls=element.getElementsByTag("a").attr("href");
					System.out.println(onlyNewsUrls);
				}else{
					onlyNewsUrls=element.text();
					System.out.println(onlyNewsUrls);
				}		

			}
		}


	}

	public static  Document getURLResponse(String str) {
		Document documnet=null;
		try {
			documnet=Jsoup.connect(str)
					.userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:79.0) Gecko/20100101 Firefox/79.0")
					.ignoreHttpErrors(true).get();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return documnet;	
	}


}

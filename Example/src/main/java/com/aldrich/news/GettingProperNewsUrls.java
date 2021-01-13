package com.aldrich.news;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class GettingProperNewsUrls {

	private static String regex="^(https:|http:)(.)*";

	public static void main(String[] args) {

		String newsurls="https://about.crunchbase.com/pressroom/";
		if(newsurls!=null&&!newsurls.isEmpty())
		{
			Set<String> newsUrlList=getProperNewsUrls(newsurls);
			for (String properNewsUrl : newsUrlList) {	
				if(!properNewsUrl.isEmpty()&&properNewsUrl!=null)
				{			
					if(properNewsUrl.matches(regex))

						if(!properNewsUrl.contains("redirect"))
						{
							System.out.println(properNewsUrl);
						}
				}
			}
		}              
	}
	public static  Set<String> getProperNewsUrls(String newsUrl) {


		Document documnet=null;
		String blogPageUrls=null;
		String newsContentUrl=null;
		String className=null;
		String onlyNewsUrls=null;
		documnet=getURLResponse(newsUrl);


		Set<String> newsUrlList=new LinkedHashSet<>();
		try{
			documnet=getURLResponse(newsUrl);

			Elements elements = documnet.select("a[href]");
			
			List<String> listBlogPageUrls=new ArrayList<String>();
			elements.forEach((e) -> {
				if(isUrlValid(e.attr("abs:href")))
				{
					if(e.attr("abs:href").length()>100)
					{
						String newsContent=e.attr("abs:href");
						listBlogPageUrls.add(newsContent);
					}
				}  });
			
			for (String string : listBlogPageUrls) {
				System.out.println(string);
			}
			



			//using lambda expression
			newsContentUrl=listBlogPageUrls.stream()
					.filter(i -> i.length()>=90).findFirst()
					.toString().replace("Optional[", "").replace("]", "");

			
				//miltiple url repeates
				List<String> listNewsContentUrls=new ArrayList<String>();
				Elements eles=documnet.getElementsByAttributeValueContaining("href", newsContentUrl);		
				for (Element element : eles) {		
					listNewsContentUrls.add(element.parent().className());
				}

				List<String> listNewsContentUrl=new ArrayList<String>();
				Integer classNamesSize=listNewsContentUrls.size();
				if(classNamesSize>1)
				{
					for (String elementText : listNewsContentUrls) {		
						if(elementText.length()>10)
						{
							listNewsContentUrl.add(elementText);
						}
					}
				}else{
					for (String elementText : listNewsContentUrls) {		
						listNewsContentUrl.add(elementText);
					}
				}

				className=listNewsContentUrl.stream().findFirst().toString().replace("Optional[", "").replace("]", "");

				if(!className.isEmpty()&&className!=null)
				{
					if(className.contains(" "))
					{
						String classNameArray[]=className.split(" ");
						if(!classNameArray[0].isEmpty()&&classNameArray[0]!=null)
						{
							Elements blogUrlsElement=documnet.select("."+classNameArray[0]);	
							for (Element element : blogUrlsElement) {
								if(element.childrenSize()!=0)
								{
									onlyNewsUrls=element.getElementsByTag("a").attr("href");
									newsUrlList.add(onlyNewsUrls);
								}else{
									onlyNewsUrls=element.text();
									newsUrlList.add(onlyNewsUrls);
								}		
							}
						}
					}else 
					{
						Elements blogUrlsElement=documnet.getElementsByClass(className)	;
						for (Element element : blogUrlsElement) {
							if(element.childrenSize()!=0)
							{
								onlyNewsUrls=element.getElementsByTag("a").attr("href");
								newsUrlList.add(onlyNewsUrls);
							}else{
								onlyNewsUrls=element.text();
								newsUrlList.add(onlyNewsUrls);
							}		
						}
					}
				}
			

			
		}catch (Exception e) {
			e.printStackTrace();
		}

		return newsUrlList;
	}


	public static Document getURLResponse(String url) {

		Document documnet=null;

		try {

			documnet=Jsoup.connect(url)
					.userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:79.0) Gecko/20100101 Firefox/79.0")
					.ignoreContentType(true).ignoreHttpErrors(true).get();

		} catch (Exception e) {
			e.printStackTrace();
		}


		return documnet;	
	}

	public static boolean isUrlValid(String newsUrl) {

		boolean valid = true;

		try {
			ArrayList<String> wordsList = new ArrayList<String>();

			wordsList.add("help");
			wordsList.add("pdf");
			wordsList.add("services");
			wordsList.add("customer");
			wordsList.add("admin");
			wordsList.add("solutions");
			wordsList.add("sites");
			wordsList.add("wsj");
			wordsList.add("ebook");
			wordsList.add("linkedin");
			wordsList.add("facebook");
			wordsList.add("google");
			wordsList.add("twitter");
			wordsList.add("youtube");
			wordsList.add("play");
			wordsList.add("itunes");
			wordsList.add("file");
			wordsList.add("redirect");


			for (String word : wordsList) {
				try {
					if (newsUrl.contains(word)) {
						valid = false;
					}
				} catch (Exception excp) {
					excp.printStackTrace();
				}
			}
		} catch (Exception excp) {
			excp.printStackTrace();
		}
		return valid;
	}

}

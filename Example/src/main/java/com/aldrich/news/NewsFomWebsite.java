package com.aldrich.news;

import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class NewsFomWebsite {

	public static void main(String[] args) {
	
		Document documnet1 = null;
		String newsPageUrls=null;
		Integer urlLengthCount=null;

		List<String> url=new ArrayList<String>();
		url.add("	https://www.woundtech.net/	");
		url.add("	https://carejourney.com/	");
		url.add("    https://ainq.com/	");
		

		//Extracting News links from Websites
		Iterator<String> iterator= url.iterator();
		while (iterator.hasNext()) {
			String urlLink= (String) iterator.next();

			try {

			

				documnet1=getURLResponse(getBlogLinks(urlLink));

				Elements elements1 = documnet1.select("a[href]");
	
				for (Element e : elements1) {
					newsPageUrls=e.attr("abs:href");
					urlLengthCount=newsPageUrls.replace(urlLink.trim(), "").indexOf("/");
					//System.out.println(urlLengthCount);
					if(urlLengthCount>20)
					{
						getNewsInfo(newsPageUrls);
						//System.out.println(newsPageUrls);
					}
				}

				documnet1=getURLResponse(getNewsLinks(urlLink));

				Elements elements2 = documnet1.select("a[href]");
	
				for (Element e : elements2) {
					newsPageUrls=e.attr("abs:href");
					urlLengthCount=newsPageUrls.replace(urlLink.trim(), "").indexOf("/");
					//System.out.println(urlLengthCount);
					if(urlLengthCount>20)
					{
						getNewsInfo(newsPageUrls);
						//System.out.println(newsPageUrls);
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	
	public static void getNewsInfo(String newsPageLink) {
		Document documnet1;
		String title=null;
		String description=null;
		String date=null;
		
		try {			
			documnet1=getURLResponse(newsPageLink);

			
			System.out.println(newsPageLink);
			title=documnet1.getElementsByTag("h1").text();
			System.out.println(title);

			
			

			if(getDateFromString(documnet1.getElementsByTag("p").text())!=null)
			{
				date=getDateFromString(documnet1.getElementsByTag("p").text());
				System.out.println(date);	
			}else{
				date=getDateFromString(documnet1.select("span").text());
				System.out.println(date);	
			}
			
			
			description=documnet1.getElementsByTag("p").text().replace(documnet1.select("span").text(), "");
			System.out.println(description.replace(date, "").trim());
			
			
			System.out.println();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getDateFromString(String string) {

		String location=null;
		String street = "(Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|Jun(e)?|Jul(y)?|Aug(ust)?|Sep(tember)?|Oct(ober)?|Nov(ember)?|Dec(ember)?)\\s([1-9]|([12][0-9])|(3[01])),\\s\\d\\d\\d\\d";
		try {
			Pattern compile = Pattern.compile(street);
			Matcher matcher = compile.matcher(string);
			if (matcher.find()) {
				location = matcher.group(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return location;
	}

	
	//To connect url
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

	public static String getDomainNameForURL(String url) {
		String updatedURL = null;
		try {
			updatedURL = url.replace("///", "//").replace(",", ".");

			URI uri = new URI(url);
			String domain = uri.getHost();

			if (domain != null) {
				updatedURL = domain.startsWith("www.") ? domain.substring(4) : domain;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return updatedURL;
	}

	public static String getNewsLinks(String urlLink) {
		String news_link=null;
		try {
			Document document=Jsoup.connect(urlLink).get();
		    //System.out.println(urlLink);
			String pattern="(/news-reseases|(/press-releases/)|(/media-coverage/)|(/news|category/press-release)|(category/news)|(/category/news-releases/)|(/press)|"
					+ "(in-the-news)|(/healthcare-business-news/)|research-and-news/|(topic/news)|(About-Us/Newsroom)|(/news/)|(news)|(news/)|(company/news/)"
					+ "|(/insights/)|(/press)|(/press-room)|(/latest-news/)|(newsroom-gateway)|(/company/press-release/)|(/news-and-updates)"
					+ "|(/category/latest-news/)|(/company/press-room/)|(the-apcela-newsroom)|(/category/latest-news/)|(/latest-news)|(whatsnew?new)|(/News)|(invester_news)"
					+ "|(#news)|(news/main)|(in-the-media)|(/newsletter)|(news-room)|(news.html)"
					+ "|(/category/press/)|(news-events/press-releases/)|(/news_and_media/)|(/insights/catelog/)|(type/article))+";



			Elements newsLinks =document.getElementsByAttributeValueMatching("href",pattern);
		

			if(!newsLinks.attr("href").isEmpty()) 
			{							
				if(!(newsLinks.attr("abs:href").contains("wp-content")))
				{
		        	if(!newsLinks.attr("abs:href").isEmpty())
					{
						//System.out.println(newsLinks.attr("abs:href"));
						 news_link=newsLinks.attr("abs:href");
						
					}
				}

				
			}else {
				news_link="";
			}

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return news_link;
	}
	
	public static String getBlogLinks(String urlLink) {
		String news_link=null;
		try {
			Document document=Jsoup.connect(urlLink).get();
		   

			String pattern1="(blog)|(type/blog)|(en/blog)|(/blog)|(/blog/)|(blog/)|tm-blog|bolgs|(/buzz/blog/)|(events)|(articles)";
	
			Elements newsLinks1 =document.getElementsByAttributeValueMatching("href", pattern1);

			if(!newsLinks1.attr("href").isEmpty()) 
			{							
		
				if(!(newsLinks1.attr("abs:href").contains("wp-content")))
				{
					if(!newsLinks1.attr("abs:href").isEmpty())
					{
						 news_link=newsLinks1.attr("abs:href");
						
						
					}
				}
			}else {
				news_link="";
			}

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return news_link;
	}
}

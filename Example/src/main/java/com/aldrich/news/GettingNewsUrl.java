package com.aldrich.news;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class GettingNewsUrl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String companyUrl="https://www.papersave.com";

		System.out.println(getNewsLinks(companyUrl));
		System.out.println(getBlogLinks(companyUrl));

	}


	public static String getNewsLinks(String companyUrl) {		

		String news_link=null;
		try {
			Document document=getURLResponse(companyUrl);
			//System.out.println(urlLink);
			String pattern="(/news-reseases|(/press-releases/)|(/media-coverage/)|(/news|category/press-release)|(category/news)|(/category/news-releases/)|(/press)|"
					+ "(in-the-news)|(/healthcare-business-news/)|research-and-news/|(topic/news)|(About-Us/Newsroom)|(/news/)|(news)|(news/)|(company/news/)"
					+ "|(/insights/)|(/press)|(/press-room)|(/latest-news/)|(newsroom-gateway)|(/company/press-release/)|(/news-and-updates)"
					+ "|(/category/latest-news/)|(/company/press-room/)|(the-apcela-newsroom)|(/category/latest-news/)|(/latest-news)|(whatsnew?new)|(/News)|(invester_news)"
					+ "|(#news)|(news/main)|(in-the-media)|(/newsletter)|(news-room)|(news.html)"
					+ "|(/category/press/)|(news-events/press-releases/)|(/news_and_media/)|(/insights/catelog/))+";

			Elements newsLinks =document.getElementsByAttributeValueMatching("href",pattern);
			if(!newsLinks.attr("href").isEmpty()) 
			{							
				if(!(newsLinks.attr("abs:href").contains("wp-content")))
				{
					if(!newsLinks.attr("abs:href").isEmpty())
					{

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
			Document document=getURLResponse(urlLink);
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

}

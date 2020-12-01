package org.myself.utils;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
 
public class Main {
 
    /**
           * Enter a URL to return a string for this URL
     */
    public static  Document getURLResponse(String str) {
    	  Document doc = null;
                String content=null;
				try {
					CloseableHttpClient httpclient = HttpClients.createDefault(); // Create an httpclient instance
					 HttpGet httpget = new HttpGet(str); // Create a httpget instance
					 CloseableHttpResponse response = httpclient.execute(httpget); // Execute the get request
					 HttpEntity entity = response.getEntity(); // Get the returned entity
					 content = EntityUtils.toString(entity, "utf-8");
					  doc = Jsoup.parse(content);
				} catch (ClientProtocolException e) {
					e.printStackTrace();
				} catch (ParseException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
       
        return doc;
    }
    public static void main(String[] args) {
		
    
		//	System.out.println(getURLResponse(getNewsLinks("https://mayadata.io/")));
		
	}
 
    public static String getNewsLinks(String urlLink) {
		String news_link=null;
		try {
			Document document=getURLResponse(urlLink);
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
package com.aldrich.news;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

public class NewsGetHompageUrls {

	public static void main(String[] args) {

		Document documnet = null;
		String homePageUrls=null;
		String newsPageUrls=null;
		documnet=getURLResponse("https://ainq.com/");

		documnet=getURLResponse("https://ainq.com/media/press-releases/");
		Elements elements = documnet.select("a[href]");

		List<String> homeUrls=new ArrayList<String>();
		for (Element e : elements) {
			if(!e.attr("abs:href").isEmpty())
			{
				homePageUrls=e.attr("abs:href");
				homeUrls.add(homePageUrls);
			}
		}
		
		Elements elemetss = documnet.select("a[href]");

		List<String> newsUrls=new ArrayList<String>();
		for (Element e : elemetss) {
			if(!e.attr("abs:href").isEmpty())
			{
				newsPageUrls=e.attr("abs:href");
				newsUrls.add(newsPageUrls);
			}
		}
		
		for (String string : newsUrls) {
			
		}
	}

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
}

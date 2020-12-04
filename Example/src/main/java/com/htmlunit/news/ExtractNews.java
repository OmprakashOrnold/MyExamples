package com.htmlunit.news;

import java.util.List;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class ExtractNews {

	public static void main(String[] args) {

		String baseUrl="https://www.woundtech.net/blog/";
		WebClient client=new WebClient();
		client.getOptions().setCssEnabled(false);
		client.getOptions().setJavaScriptEnabled(false);
		try{
			HtmlPage page=client.getPage(baseUrl);
			List<HtmlAnchor> linkspage=page.getAnchors();
			for (HtmlAnchor htmlAnchor : linkspage) {
				if(htmlAnchor.getAttribute("href").length()>60)
				System.out.println(htmlAnchor.getAttribute("href"));
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();}
	}

}
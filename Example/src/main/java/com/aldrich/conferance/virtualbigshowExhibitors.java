package com.aldrich.conferance;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class virtualbigshowExhibitors {



	public static void main(String[] args) {

		Document document=null;
		Document document2=null;
		try {


			document=getDocument("https://virtualbigshow.nrf.com/exhibitors");

			Elements mainLinks=document.getElementsByAttribute("href");
			for (Element element : mainLinks) {
				if(element.attr("abs:href").contains("company"))
				{
					//System.out.println(element.attr("abs:href"));
					document2=getDocument(element.attr("abs:href"));
					/*Elements companyNames=document2.select("div[class='company_name']");
					for (Element element2 : companyNames) {
						System.out.println(element2.text());
					}		*/
					Elements companyNames=document2.select("div[class='company_website']");
					for (Element element2 : companyNames) {
						System.out.println(element2.getElementsByTag("a").attr("href"));
					}
					//a[rel='noopener']
				}

			}



		} catch (Exception e) {
			e.printStackTrace();
		}


	}

	public static Document getDocument(String url)
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

package com.aldrich.peronal;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.aldrich.pase.util.PASEConstants;
import com.aldrich.patent.SSLExceptionSolution;

public class EmployeePersonalMoveAlerts {

	public static void main(String[] args) {
		String leaderShipUrl=null;
		leaderShipUrl=getAboutLinks("https://www.clarityssi.com/","clarityssi.com");
		System.out.println(leaderShipUrl);
	}

	public static String getAboutLinks(String urlLink,String domainName) {
		String leaderShipUrl=null;
		try {
			Document document=getURLResponse(urlLink);
					String pattern=domainName+"((about)|(/about-us/)|(/about/)|(/about-us)|(/board-of-directors/)"
							+ "|(/company/about-us.html)|(/about-indinero)|(/about/earthsoft-staff/)"
							+ "|(/about-biosite/)|(/about-wellbox/)|(/about-us/leadership-team/)|(/aboutus/))+";
			Elements teamLinks =document.getElementsByAttributeValueMatching("href",pattern);

			if(!teamLinks.attr("href").isEmpty()) 
			{							
				if(!(teamLinks.attr("abs:href").contains("wp-content")))
				{
					if(!teamLinks.attr("abs:href").isEmpty())
					{
						leaderShipUrl=teamLinks.attr("abs:href");
					}
				}
			}else {
				leaderShipUrl="";
			}

		}catch(Exception e){
			e.printStackTrace();
		}
		return leaderShipUrl;
	}


	public static  Document getURLResponse(String str) {
		Document document=null;
		try {
			SSLExceptionSolution.enableSSLSocket();
			document=Jsoup.connect(str)
					.userAgent(PASEConstants.USER_AGENT)
					.ignoreContentType(true).ignoreHttpErrors(true)
					.followRedirects(true).get();

		} catch (Exception e) {
			e.printStackTrace();	
		}
		return document;	
	}

}

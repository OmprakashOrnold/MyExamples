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

public class ExtractNewsLinksFromWebsite {

	private static String pattern="(/news-reseases|(/press-releases/)|(/media-coverage/)|(/news|category/press-release)|(category/news)|(/category/news-releases/)|(/press)|"
			+ "(in-the-news)|(/healthcare-business-news/)|research-and-news/|(topic/news)|(About-Us/Newsroom)|(/news/)|(news)|(news/)|(company/news/)"
			+ "|(/insights/)|(/press)|(/press-room)|(/latest-news/)|(newsroom-gateway)|(/company/press-release/)|(/news-and-updates)"
			+ "|(/category/latest-news/)|(/company/press-room/)|(the-apcela-newsroom)|(/category/latest-news/)|(/latest-news)|(whatsnew?new)|(/News)|(invester_news)"
			+ "|(#news)|(news/main)|(in-the-media)|(/newsletter)|(news-room)|(news.html)"
			+ "|(/category/press/)|(news-events/press-releases/)|(/news_and_media/)}|(blog)|(type/blog)|(en/blog)|(/blog)|(/blog/)|(blog/)|tm-blog|bolgs|(/buzz/blog/)|(events)|(articles)|(/insights/catelog/)|(type/article))+";
	public static void main(String[] args) {

		List<String> url=new ArrayList<String>();

		url.add("	https://jackrabbittech.com/	");
		url.add("	https://www.net-inspect.com/	");		
		url.add("	https://medicopy.net/	");
		url.add("	https://sproutloud.com/	");
		url.add("	https://online-rewards.com/	");
		
		url.add("	https://www.ema.us/	");
		url.add("	https://www.salary.com/	");
		url.add("	https://www.shmoop.com/	");
		url.add("	http://www.kannact.com/	");
		url.add("	https://www.indinero.com/	");
		url.add("	https://www.histowiz.com/	");
		url.add("	http://www.accountantsworld.com/	");
		url.add("	https://www.openclinica.com	");
		url.add("	https://www.alacriti.com/	");
		url.add("	https://www.alianza.com/	");
		url.add("	https://www.comm100.com/	");
		url.add("	https://compliancy-group.com/	");
		url.add("	https://www.medweb.com/	");
		url.add("	https://clinicalarchitecture.com/	");
		url.add("	http://www.igihealth.com/	");
		url.add("	https://www.obix.com/	");
		url.add("	https://thessigroup.com/	");
		url.add("	https://www.ellkay.com/	");
		url.add("	https://www.eccentex.com/	");
		url.add("	https://www.azaleahealth.com/	");
		url.add("	https://neuroalert.com/	");
		url.add("	http://www.ehiconnect.com/	");
		url.add("	https://www.alanahealthcare.com/	");
		url.add("	https://www.ligolab.com/	");
		url.add("	https://www.revenuewire.com	");
		url.add("	https://riskspan.com/	");
		url.add("	http://www.objectiflune.com/	");
		url.add("	https://www.acdlabs.com/	");
		url.add("	https://leanindustries.com/	");
		url.add("	https://www.magnetforensics.com/	");
		url.add("	https://exagoinc.com/	");
		url.add("	https://www.coremobileinc.com/	");
		url.add("	http://www.vichara.com/	");
		url.add("	https://www.celayix.com/	");
		url.add("	https://www.globalids.com/	");
		url.add("	https://www.upstreamworks.com/	");
		url.add("	https://www.momentumhealthware.com/	");
		url.add("	https://www.fdm4.com/	");
		url.add("	https://www.mycomplianceoffice.com	");
		url.add("	http://jostle.me/	");
		url.add("	http://www.skyitgroup.com/	");
		url.add("	https://www.zuman.com/	");
		url.add("	https://www.verdantis.com/	");
		url.add("	https://www.edetek.com/	");
		url.add("	http://www.rebarsys.com/	");
		url.add("	https://ptfs.com/	");
		url.add("	https://www.ellumen.com/	");
		url.add("	https://mfino.com/	");
		url.add("	https://lunarline.com/	");
		url.add("	https://activu.com/	");
		url.add("	https://www.logicbroker.com/	");
		url.add("	https://brightsign.biz	");
		url.add("	https://explorance.com/	");
		url.add("	https://ntint.com/	");
		url.add("	http://www.altusdynamics.com	");
		url.add("	https://instapage.com/	");
		url.add("	https://vigilanzcorp.com/	");
		url.add("	https://medicomhealth.com/	");
		url.add("	https://selectdata.com/	");
		url.add("	https://proscan.com/	");
		url.add("	https://sytrue.com/	");
		url.add("	https://sellercloud.com/	");
		url.add("	https://www.liferay.com/	");
		url.add("	https://www.kineticdata.com/	");
		url.add("	https://medikeeper.com/	");
		url.add("	https://www.sciforma.com/	");
		url.add("	https://www.processweaver.com/	");
		url.add("	https://www.savanainc.com/	");
		url.add("	https://www.datafied.com/	");
		url.add("	https://www.panderasystems.com/	");
		url.add("	https://www.penrad.com/	");
		url.add("	https://www.hmchealthworks.com/	");
		url.add("	https://www.salucro.com	");
		url.add("	https://hpgroupllc.com/	");
		url.add("	https://www.intellect.com/	");
		url.add("	https://www.4cite.com/	");
		url.add("	https://www.atlassystems.com/	");
		url.add("	https://www.hrgpros.com/	");
		url.add("	https://avasure.com/	");
		url.add("	https://sdata.us/	");
		url.add("	https://www.stratahealth.com/	");
		url.add("	https://www.biosero.com/	");
		url.add("	https://www.prophix.com/	");
		url.add("	https://bluesageusa.com/	");
		url.add("	https://www.smartflowcompliance.com/	");
		url.add("	https://www.archive360.com/	");
		url.add("	https://www.reversevision.com/	");
		url.add("	https://www.finsync.com/	");
		url.add("	https://www.corepartners.com/	");
		url.add("	https://onereach.com/	");
		url.add("	https://servicecentral.com/	");
		url.add("	https://www.decisionresearch.com/	");
		url.add("	https://www.processmap.com/	");
		url.add("	https://www.gtsoftware.com/	");
		 
		Document doc = null;
		String newsPageUrls=null;
		Integer urlLengthCount=null;

		for (String string : url) {

			if(getNewsLinks(string.trim())!=null&&!getNewsLinks(string.trim()).isEmpty())
			{	
				//System.out.println(getNewsLinks(string.trim()));
				
				doc=getURLResponse(getNewsLinks(string.trim()));
				Elements elements = doc.select("a[href]");
				for (Element e : elements) {
					newsPageUrls=e.attr("abs:href");
					System.out.println(newsPageUrls);
					if(!newsPageUrls.isEmpty())
					{
					    if(newsPageUrls.contains("blog"))
					    {
						System.out.println(newsPageUrls.trim());
					    }else
					    	if(newsPageUrls.contains("press"))
					    	{
					    		System.out.println(newsPageUrls.trim());
					    	}
					}
				}
			}
		}

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
	//To connect url
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



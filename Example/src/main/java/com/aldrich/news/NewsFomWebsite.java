package com.aldrich.news;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.concurrent.TimeUnit;
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

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;

public class NewsFomWebsite {

	public static void main(String[] args) {

		Document documnet1 = null;
		String newsPageUrls=null;
		String blogPageUrls=null;

		List<String> url=new ArrayList<String>();

		url.add("https://rfidgs.com/");

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

		Iterator<String> iterator= url.iterator();
		while (iterator.hasNext()) {
			String urlLink= iterator.next().trim();
			String blogurls=getBlogLinks(urlLink);
			String newsurls=getNewsLinks(urlLink);
			try {
				if(blogurls!=null&&!blogurls.isEmpty())
				{
					documnet1=getURLResponse(blogurls);

					Elements elements1 = documnet1.select("a[href]");

					for (Element e : elements1) {
						blogPageUrls=e.attr("abs:href");

						if(blogPageUrls.length()>50)
						{
							if((getURLResponse(blogPageUrls).text())!=null&&!(getURLResponse(blogPageUrls).text()).isEmpty())
							{
								String date =getDateFromString(getURLResponse(blogPageUrls).text());
								if(date!=null&&!date.isEmpty())
								{
									getNewsInfo(blogPageUrls);
								}

							}
						}

					}
				}
				if(newsurls!=null&&!newsurls.isEmpty())
				{
					documnet1=getURLResponse(newsurls);
					Elements elements2 = documnet1.select("a[href]");
					for (Element e : elements2) {
						newsPageUrls=e.attr("abs:href");
						if(newsPageUrls.length()>50)
						{
							if((getURLResponse(newsPageUrls).text())!=null&&!(getURLResponse(newsPageUrls).text()).isEmpty())
							{
								String date =getDateFromString(getURLResponse(newsPageUrls).text());
								if(date!=null&&!date.isEmpty())
								{
									getNewsInfo(newsPageUrls);
								}
							}
						}
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


			title=documnet1.getElementsByTag("title").text();


			date=getDateFromString(documnet1.text());

			Elements des=documnet1.getElementsByAttributeValue("name", "description");
			
			description=des.attr("content");
				
			
			
			if(!description.isEmpty()&&description!=null)
			{
				System.out.println(newsPageLink);
				System.out.println(title);
				System.out.println(date);
				System.out.println(description);


			}

			System.out.println();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getDateFromString(String string) {

		String location=null;
		String street = "(\\d{1,2}\\s(Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|Jun(e)?|Jul(y)?|Aug(ust)?|Sep(tember)?|Oct(ober)?|Nov(ember)?|Dec(ember)?) \\d{1,4})|((Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|Jun(e)?|Jul(y)?|Aug(ust)?|Sep(tember)?|Oct(ober)?|Nov(ember)?|Dec(ember)?)\\s([1-9]|([12][0-9])|(3[01])),\\s\\d\\d\\d\\d)|((([1-9]|1[012])[-//.]([1-9]|[12][0-9]|3[01])[-/.](19|20)\\d\\d)|((1[012]|0[1-9])(3[01]|2\\d|1\\d|0[1-9])(19|20)\\d\\d)|((1[012]|0[1-9])[-//.](3[01]|2\\d|1\\d|0[1-9])[-//.](19|20)\\d\\d))";
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
	public static  Document getURLResponse(String str) {
		Document documnet = null;
		String resp=null;
		try {
			OkHttpClient client = new OkHttpClient();
			client.setConnectTimeout(10, TimeUnit.SECONDS);
			client.setReadTimeout(30, TimeUnit.SECONDS);
			client.setFollowRedirects(true);
			Request request = new Request.Builder()
					.url(str)					
					.get()
					.build();
			resp=client.newCall(request).execute().body().string();
			documnet = Jsoup.parse(resp);
		} catch (Exception e) {
			//e.printStackTrace();
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
}

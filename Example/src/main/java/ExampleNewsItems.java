import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

;

public class ExampleNewsItems {

	public static void main(String[] args)  {

		List<String> url=new ArrayList<String>();
		url.add("https://www.zogofinance.com/blog	");
		url.add("https://www.virtuescript.com/news-events	");
		url.add("https://www.ubdi.com/blog	");
		url.add("https://www.ubdi.com/about/press	");
		url.add("https://www.totaldigitalsecurity.com/cybersecurity-education-events	");
		url.add("https://www.totaldigitalsecurity.com/blog	");
		url.add("https://www.telefactor-robotics.com/news	");
		url.add("https://www.tangobelt.com/press	");
		url.add("https://www.syglass.io/news	");
		url.add("https://www.speedwellandyarrow.com/news	");
		url.add("https://www.skyphos.tech/news	");
		url.add("https://www.shift5.io/news.html	");
		url.add("https://www.sensanna.com/news	");
		url.add("https://www.saccadous.com/news	");
		url.add("https://www.ristcall.com/blog	");
		url.add("https://www.repisodic.com/blog	");
		url.add("https://www.repipe4710.com/events	");
		url.add("https://www.renovoderm.tech/News/	");
		url.add("https://www.refineai.com/press	");
		url.add("https://www.refineai.com/blog	");
		url.add("https://www.radiusiot.com/events/?ical=1	");
		url.add("https://www.radiusiot.com/blog/	");
		url.add("https://www.radiusai.com/events/?ical=1	");
		url.add("https://www.radiusai.com/blog/	");
		url.add("https://www.prnewswire.com/news-releases/protolytic-llc-acquires-medical-pay-review-inc-300754008.html	");
		url.add("https://www.podify.com/blogs/news	");
		url.add("https://www.podify.com/blogs/news	");
		url.add("https://www.ourharvest.coop/in-the-media	");
		url.add("https://www.nthround.com/news-and-press/	");
		url.add("https://www.nthround.com/blog/	");
		url.add("https://www.nextinline.io/news-and-blog/	");
		url.add("https://www.nextinline.io/news-and-blog/	");
		url.add("https://www.naviancapital.com/index.cfm/about-us/in-the-news/	");
		url.add("https://www.multiplexdx.com/contact-us#newsletter	");
		url.add("https://www.multiplexdx.com/blog	");
		url.add("https://www.linxus.com/blog.html	");
		url.add("https://www.linktimecloud.com/news	");
		url.add("https://www.linktimecloud.com/blog	");
		url.add("https://www.lifemedix.com/news/	");
		url.add("https://www.levelfunded.com/news/main	");
		url.add("https://www.legaldecoder.com/events	");
		url.add("https://www.legaldecoder.com/blog	");
		url.add("https://www.immersivewisdom.com/news	");
		url.add("https://www.ihealthnetworks.com/News.aspx	");
		url.add("https://www.howellusa.com/news	");
		url.add("https://www.fend.tech/news	");
		url.add("https://www.familycarepath.com/news/	");
		url.add("https://www.eyecarenow.com/news-community/	");
		url.add("https://www.enablegames.com/news/	");
		url.add("https://www.cprtools.com/blog/	");
		url.add("https://www.cprtools.com/about-us/press-media/	");
		url.add("https://www.clearstep.health/newsroom.html	");
		url.add("https://www.ccbusy.com/news/	");
		url.add("https://www.captoglove.com/news/	");
		url.add("https://www.campuslabs.com/about-us/news/	");
		url.add("https://www.briodevice.com/brio-news-events/	");
		
		//Extracting News links
		Iterator<String> iterator= url.iterator();
		while (iterator.hasNext()) {
			String urlLink= (String) iterator.next();
		    String s1="http://boilerpipe-web.appspot.com/extract?url=";
		    String s2=s1.concat(urlLink);
		    System.out.println(s2);
			try {
				Document document=Jsoup.connect(s2).ignoreHttpErrors(true).userAgent("Mozilla").get();
			   Elements elements=document.getElementsByAttributeValueContaining("href", "blog");
			System.out.println(elements.text());
			   
			   
			}	
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}






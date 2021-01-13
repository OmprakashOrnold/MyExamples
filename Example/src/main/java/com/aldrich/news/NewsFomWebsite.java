package com.aldrich.news;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class NewsFomWebsite {


	private static String regex="^(https:|http:)(.)*";

	public static void main(String[] args) {

		Document documnet1 = null;
		String newsPageUrls=null;
		String blogPageUrls=null;
		String className=null;

		String blogUrls=null;
		String newsUrls=null;


		List<String> url=new ArrayList<String>();

		//	url.add("http://www.woundtech.net/");
		url.add("magnetforensics.com/r");

		Iterator<String> iterator= url.iterator();
		while (iterator.hasNext()) {
			String urlLink= iterator.next().trim();
			String blogurls=getBlogLinks(formatUrl(urlLink));
			String newsurls=getNewsLinks(formatUrl(urlLink));
			try {
				if(blogurls!=null&&!blogurls.isEmpty())
				{
					List<String> bolgUrlList=getProperNewsUrls(blogurls);
					for (String string : bolgUrlList) {
						if(string.matches(regex)&&!string.isEmpty()&&string!=null&&!string.contains("topic"))
						{
							getNewsInfo(string);
						}
					}
				}
				if(newsurls!=null&&!newsurls.isEmpty())
				{
					List<String> newsUrlList=getProperNewsUrls(newsurls);
					for (String string : newsUrlList) {
						if(string.matches(regex)&&!string.isEmpty()&&string!=null&&!string.contains("topic"))
						{
							getNewsInfo(string);
						}
					}
				}


			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}


	public static List<String> getProperNewsUrls(String newsUrl) {

		Document documnet=null;
		String blogPageUrls=null;
		String newsContentUrl=null;
		String className=null;
		String onlyNewsUrls=null;

		List<String> newsUrlList=new ArrayList<String>();

		documnet=getURLResponse(newsUrl);
		Elements elements1 = documnet.select("a[href]");



		List<String> listBlogPageUrls=new ArrayList<String>();
		for (Element e : elements1) {

			blogPageUrls=e.attr("abs:href");	
			if(blogPageUrls.matches(regex)&&!blogPageUrls.contains("yahoo.com"))
			{
				listBlogPageUrls.add(blogPageUrls);
			}
		}

		//using lambda expression
		newsContentUrl=listBlogPageUrls.stream()
				.filter(i -> i.replace("https://wwww.", "").replace("http://wwww.", "").replace("https://", "").replace("http://", "")
						.length()>100).findFirst()
				.toString().replace("Optional[", "").replace("]", "");

		//miltiple url repeates
		List<String> listNewsContentUrl=new ArrayList<String>();
		Elements elements=documnet.getElementsByAttributeValueContaining("href", newsContentUrl);
		for (Element element : elements) {
			if(element.className()!=null&&!element.className().isEmpty())
			{
				listNewsContentUrl.add((element.className()));
			}else{
				listNewsContentUrl.add(element.parent().className());
			}


		}

		className=listNewsContentUrl.stream().findFirst().toString().replace("Optional[", "").replace("]", "");
		if(!className.isEmpty()&&className!=null)
		{
			Elements blogUrlsElement=documnet.select("."+className);	
			for (Element element : blogUrlsElement) {
				if(element.childrenSize()!=0)
				{
					onlyNewsUrls=element.getElementsByTag("a").attr("href");
					newsUrlList.add(onlyNewsUrls);
				}else{
					onlyNewsUrls=element.text();
					newsUrlList.add(onlyNewsUrls);

				}		

			}
		}

		return newsUrlList;
	}


	@SuppressWarnings("unused")
	public static void getNewsInfo(String newsPageLink) {
		Document documnet=null;
		String title=null;
		String description=null;
		String date=null;
		Date convertedDate=null;

		try {		

			documnet=getURLResponse(newsPageLink);
			if(documnet!=null)
			{
				
				
					//title
					Elements titleElement=documnet.select("meta[property='og:title']");
					if(titleElement!=null&&!titleElement.isEmpty())
					{
						title="";
						title=titleElement.attr("content");
					}else{
						Elements titleElement2=documnet.getElementsByTag("title");
						title="";
						title=titleElement2.text();
					}

					//description
					Elements descriptionElement=documnet.select("meta[property='og:description']");
					if(descriptionElement!=null&&!descriptionElement.isEmpty())
					{
						if(descriptionElement.attr("content").length()>15)
						{
							description="";
							description=descriptionElement.attr("content");
						}
					}
					
					//date
					Elements dateElement=documnet.select("meta[property='article:published_time']");
					if(dateElement!=null&&!dateElement.isEmpty())
					{
						String dateArray[]=dateElement.attr("content").split("T");	
						date="";
						date=dateArray[0];
					}else{				
						date="";
						date=getDateFromString(documnet.text());
					}

					if(convertAnyTypeDateToSingleFormat(date)!=null)
					{
						convertedDate=convertAnyTypeDateToSingleFormat(date);
					}

					System.out.println("-------------------------------------------------");
					System.out.println(convertedDate);			
					System.out.println(title);
					System.out.println(description);
					System.out.println(date);
					System.out.println(newsPageLink);	
					System.out.println("-------------------------------------------------");
					System.out.println();

					
				

			}



		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static String getDateFromString(String string) {

		String date=null;
		String regex1="\\d{1,2}\\s(Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|Jun(e)?|Jul(y)?|Aug(ust)?|Sep(tember)?|Oct(ober)?|Nov(ember)?|Dec(ember)?) \\d{4,4}";
		String regex2="((Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|Jun(e)?|Jul(y)?|Aug(ust)?|Sep(tember)?|Oct(ober)?|Nov(ember)?|Dec(ember)?)\\s([1-9]|([12][0-9])|(3[01])),\\s\\d\\d\\d\\d)";
		String regex3="\\d{1,2}\\s\\d{1,2}\\s\\d{4,4}";

		String regex4="\\d{4,4}[\\/]\\d{1,2}[\\/]\\d{1,2}";
		String regex5="\\d{4,4}[\\-]\\d{1,2}[\\-]\\d{1,2}";
		String regex6="\\d{1,2}\\-(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|dec)\\-\\d{4,4}";
		String regex7="\\d{1,2}[\\/]\\d{1,2}[\\/]\\d{4,4}";

		String dateFormat ="("+regex1+")|("+regex2+")|("+regex3+")|("+regex4+")|("+regex5+")|("+regex6+")|("+regex7+")";

		if(string!=null&&!string.isEmpty()){
			try {
				Pattern compile = Pattern.compile(dateFormat);
				Matcher matcher = compile.matcher(string);
				if (matcher.find()) {
					date = matcher.group(0);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return date;
	}

	public static Date convertAnyTypeDateToSingleFormat(String dateInString) {
		String dateFormat=null;
		Date date =null;


		String regex1="\\d{1,2}\\s(Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|Jun(e)?|Jul(y)?|Aug(ust)?|Sep(tember)?|Oct(ober)?|Nov(ember)?|Dec(ember)?)\\s\\d{4,4}";
		String regex2="((Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|Jun(e)?|Jul(y)?|Aug(ust)?|Sep(tember)?|Oct(ober)?|Nov(ember)?|Dec(ember)?)\\s([1-9]|([12][0-9])|(3[01])),\\s\\d\\d\\d\\d)";
		String regex3="\\d{1,2}\\s\\d{1,2}\\s\\d{4,4}";

		String regex4="\\d{4,4}[\\/]\\d{1,2}[\\/]\\d{1,2}";
		String regex5="\\d{4,4}[\\-]\\d{1,2}[\\-]\\d{1,2}";
		String regex6="\\d{1,2}\\-(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|dec)\\-\\d{4,4}";
		String regex7="\\d{1,2}[\\/]\\d{1,2}[\\/]\\d{4,4}";

		String regex8="((Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|Jun(e)?|Jul(y)?|Aug(ust)?|Sep(tember)?|Oct(ober)?|Nov(ember)?|Dec(ember)?)\\s([1-9]|([12][0-9])|(3[01]))\\s\\d\\d\\d\\d)";
		if(dateInString!=null&&!dateInString.isEmpty())
		{
			if(dateInString.matches(regex1)){
				dateFormat="dd MMM yyyy";
			}else if(dateInString.matches(regex2)){
				dateFormat="MMM dd, yyyy";
			}else if(dateInString.matches(regex3)){
				dateFormat="dd MM yyyy";
			}else if(dateInString.matches(regex4)){
				dateFormat="yyyy/MM/dd";
			}else if(dateInString.matches(regex5)){
				dateFormat="yyyy-MM-dd";
			}else if(dateInString.matches(regex6)){
				dateFormat="d-MMM-yyyy";
			}else if(dateInString.matches(regex7)){
				dateFormat="d/MM/yyyy";
			}else if(dateInString.matches(regex8)){
				dateFormat="MMM dd yyyy";
			}

			SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
			try {
				date = formatter.parse(dateInString);
			} catch (ParseException | java.text.ParseException e) {
				e.printStackTrace();
			}

		}


		return date;
	}


	//To connect url
	public static  Document getURLResponse(String str) {
		Document documnet=null;
		try {
			documnet=Jsoup.connect(str)
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
	public static String formatUrl(String url)
	{
		String formattedUrl = "";
		try
		{
			if (!url.startsWith("https://www.") && !url.startsWith("http://www."))
			{
				if (url.startsWith("//"))
				{
					if (url.contains("www."))
					{
						formattedUrl = url.substring(2, url.length());
						formattedUrl = "http://" + formattedUrl;
					}
					else
					{
						formattedUrl = url.substring(2, url.length());
						formattedUrl = "http://www." + formattedUrl;
					}
				}
				else if (url.startsWith("www."))
				{
					formattedUrl = "http://" + url;
				}
				else if (url.startsWith("ttp://"))
				{
					formattedUrl = "h" + url;
				}
				else if (url.startsWith("htttp://"))
				{
					formattedUrl = url.replace("htttp", "http");
				}
				else if (url.startsWith("httphttp") || url.contains("httphttp"))
				{
					formattedUrl = url.replace("httphttp", "http");
				}
				else if (url.startsWith("httpshttps") || url.contains("httpshttps"))
				{
					formattedUrl = url.replace("httpshttps", "https");
				}
				else if (url.startsWith("wwwwww."))
				{
					formattedUrl = url.replace("wwwwww.", "www.");
				}
				else if (!url.toLowerCase().contains("www."))
				{
					if (url.toLowerCase().contains("http://"))
					{
						formattedUrl = url.toLowerCase().replace("http://", "");
						formattedUrl = "http://www." + formattedUrl;
					}
					else if (url.toLowerCase().contains("https://"))
					{
						formattedUrl = url.toLowerCase().replace("https://", "");
						formattedUrl = "https://www." + formattedUrl;
					}
					else
					{
						formattedUrl = "http://www." + url;
					}
				}
				else
				{
					formattedUrl = "http://www." + url;
				}
			}
			else
			{
				formattedUrl = url;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return formattedUrl;
	}

}

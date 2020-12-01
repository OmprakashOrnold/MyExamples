import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GoogleSearchResults {

	public static void main(String[] args) {
		Document document=null;
		//	for (int i = 0; i < 1000000; i++) {
		

		String keyword="Alere San Diego, Inc.";
		
		System.out.println(getCompanyUrl(keyword));
		



	}

	public static String getCompanyUrl(String companyName) {
		Document document=null;
		String url=null;
		try {
			document=Jsoup.connect("https://www.google.com/search?q="+companyName.replace(" ", "%20"))
					.userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:79.0) Gecko/20100101 Firefox/79.0")
					.ignoreHttpErrors (true) // This is very important, otherwise it will report HTTP error fetching URL. Status = 404
					.get();  
			Element links=document.select("div[class='yuRUbf']").first();
			url=links.getElementsByTag("a").attr("href");
		}
		catch (UnknownHostException  e) {
			e.getMessage();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return url;
	}

	public static String getDomainFromString(String text)
	{
		String domain=null;
		String regex = ".*?\\.(.*?\\.[a-zA-Z]+)";
		Pattern p = Pattern.compile(regex);

		Matcher m = p.matcher(text);
		if(m.matches())
		{
			domain=m.group();
		}	
		return domain;
	}

}

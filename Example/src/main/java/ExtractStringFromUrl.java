import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ExtractStringFromUrl {

	public static void main(String[] args) throws IOException {
		
		Document document=Jsoup.connect("http://aldrichcap.com").get();
		System.out.println(document.title());
		
		Elements links=document.select("a[href]");
       for (Element link : links) {
    	   
		//System.out.println("href "+link.attr("href"));
		
		System.out.println("href "+link.attr("href"));
		
	
	}

	}

}

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GettingUrlSingleFile {

	public static void main(String[] args) throws IOException {
		String companyName="Clarity LLC";
    	Document doc=Jsoup.connect("https://www.google.com/search?q="+companyName+"&rlz=1C1GCEA_enIN883IN883&oq=woundtech&aqs=chrome.0.69i59j0l7.6558j1j8&sourceid=chrome&ie=UTF-8").get();
		//System.out.println(doc.select("div[class=TbwUpd NJjxre]").first().text());
		Elements companyUrlElement=doc.select("div[class=TbwUpd NJjxre]");
		for (Element companyUrls : companyUrlElement) {
			
				
			
			System.out.println(companyUrls.getElementsContainingText(".com").first().text());
			
		}
    	

	}

}

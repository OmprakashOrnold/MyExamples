import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ExtractStringFromHtml1 {

	public static void main(String[] args) {
	
		String html = "<p>An <a href='http://example.com/'><b>example</b></a> link.</p>";
		Document doc = Jsoup.parse(html);
		Element link = doc.select("a").first();

		String text = doc.body().text(); // "An example link"
		String linkHref = link.attr("href"); // "http://example.com/"
		String linkText = link.text(); // "example""

		String linkOuterH = link.outerHtml(); 
		    // "<a href="http://example.com"><b>example</b></a>"
		String linkInnerH = link.html(); // "<b>example</b>"
		/*
		 * Elements paragraphs=document.getElementsByTag("p"); for (Element pragraph :
		 * paragraphs) { System.out.println(pragraph.text()); }
		 * 
		 * Element sampleDiv=document.getElementById("sampleDiv");
		 * System.out.println("Data "+sampleDiv.text()); Elements links =
		 * sampleDiv.getElementsByTag("a");
		 * 
		 * for (Element link : links) { System.out.println("Href: " +
		 * link.attr("href")); System.out.println("Text: " + link.text()); }
		 */
	   }
}

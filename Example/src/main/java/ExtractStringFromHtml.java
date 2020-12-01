import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ExtractStringFromHtml {

	public static void main(String[] args) {
		
		String html="<html><head><title>Sample Title</title></head>"
		         + "<body><p>Sample Content</p>"
		         + "<p>Sample Content 1</p></body></html>";
		Document document=Jsoup.parse(html);
		System.out.println(document.title());
		Elements paragraphs=document.getElementsByTag("p");
		
       for(Element paragraph:paragraphs)
       {
    	   System.out.println(paragraph.text());
       }
	}

}

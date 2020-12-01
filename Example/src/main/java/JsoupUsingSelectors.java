import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupUsingSelectors {
   public static void main(String[] args) {
   
      String html = "<html><head><title>Sample Title</title></head>"
         + "<body>"
         + "<p>Sample Content</p>"
         + "<div id='sampleDiv'><a href='www.google.com'>Google</a>"
                                +"<a href='www.twitter.com'>Twitter</a>"
         + "<h3><a>Sample</a><h3>"
         +"</div>"
         + "<div id='imageDiv' class='header'><img name='google' src='google.jpg' />"
         + "<img name='yahoo' src='yahoo.jpg' />"
         +"</div>"
         +"</body></html>";
      Document document = Jsoup.parse(html);

     
      Elements links = document.select("a[href]");

      for (Element link : links) {
         System.out.println("Href: " + link.attr("href"));
         System.out.println("Text: " + link.text());
      }

      
      Elements pngs = document.select("img[src$=.png]");

      for (Element png : pngs) {
         System.out.println("Name: " + png.attr("name"));
      }

      
      Element headerDiv = document.select("div.header").first();
      System.out.println("Id: " + headerDiv.id());
   
     
      Elements sampleLinks = document.select("h3 > a"); 

      for (Element link : sampleLinks) {
         System.out.println("Text: " + link.text());
      }
   }
}
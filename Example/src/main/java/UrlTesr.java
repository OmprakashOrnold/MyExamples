import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class UrlTesr {

	public static void main(String[] args) {
		Document documnet = null;
		documnet=getURLResponse("https://www.paycomonline.com/");
		System.out.println(documnet);
		
	}

	
	public static Document getURLResponse(String url) {
		Document documnet = null;
		try {
			documnet = Jsoup.connect(url)
					.userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:79.0) Gecko/20100101 Firefox/79.0")
					.timeout(0).ignoreHttpErrors(true).get();
		} catch (Exception e) {
			//e.printStackTrace();
		}
		return documnet;


	}
}

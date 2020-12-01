import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class DemoExample {

	public static void main(String[] args)
	{
		Document document=null;
		String url="http://telegram.org";

		try {
			document=Jsoup.connect(url)
					.userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:79.0) Gecko/20100101 Firefox/79.0")
					.ignoreHttpErrors(true).get();
			
			System.out.println(document);
		} catch (Exception e) {
		   e.printStackTrace();
		}
	}
}

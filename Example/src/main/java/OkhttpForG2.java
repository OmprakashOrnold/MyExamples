
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class OkhttpForG2 {


	public static void main(String[] args) {
		Document document = null;
		String request1=null;

		String companyUrl="https://www.g2.com/categories?q[category_type_eq]=service";
	
		
			document=getUrlResponse(companyUrl);
			
			System.out.println(document);
			/*Elements s=document.select("a[class='link js-log-click']");
			for (Element element : s) {
				for (int i = 1; i < 10; i++) {	
					request1=element.attr("abs:href")+"?order=popular&page="+i+"#product-list";			
				}
				System.out.println(request1);

			}*/
		

	}

	public static Document getUrlResponse(String companyUrl) {
		Document document = null;
		try {

			OkHttpClient client = new OkHttpClient();
			Request request = new Request.Builder().url(companyUrl).get().addHeader("cache-control", "no-cache")
					.build();
			String response = client.newCall(request).execute().body().string();
			document = Jsoup.parse(response);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return document;
	}
}

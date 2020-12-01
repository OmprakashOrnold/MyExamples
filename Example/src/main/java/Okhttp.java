import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class Okhttp {


	public static void main(String[] args) {

		for (int i = 761; i < 100; i++) {

			String companyUrl="https://www.capterra.com/p/"+i+"/SuperMap-Desktop-GIS/";
			String response=null;;
			try {

				OkHttpClient client = new OkHttpClient();
				Request request = new Request.Builder().url(companyUrl).get().addHeader("cache-control", "no-cache")
						.build();

				try {
					response = client.newCall(request).execute().body().string();
				} catch (Exception e) {

				}
				if(response!=null)
				{
					Document document = Jsoup.parse(response);
					if (document != null) {

						System.out.println(document);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

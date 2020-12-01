package com.aldrich.om;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.aldrich.pase.util.PASEConstants;

public class ExtractProductsPages {

	public static void main(String[] args) {

		String categoryLink = "https://www.g2.com/categories/sap-successfactors-resellers";
		System.out.println(getProductLinks(categoryLink));
		;

	}

	public static String getProductLinks(String categoryLink) {
		Document doc = null;
		String title = null;
		String productsLinks = null;

		try {
			doc = getURLResponse(categoryLink);
		//	Thread.sleep(5000);
			title = doc.getElementsByTag("title").text();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (title.startsWith("Pardon")) {
			return getProductLinks(categoryLink);

		} else {
			Elements links = doc.select("a[class='link js-log-click']");
			for (Element link : links) {
				productsLinks = link.attr("href");
				System.out.println(productsLinks);
			}
			return productsLinks;
		}
	}

	public static Document getURLResponse(String url) {
		Document document = null;
		try {
			document = Jsoup.connect(url).followRedirects(true).userAgent(PASEConstants.USER_AGENT)
					.ignoreHttpErrors(true).timeout(3000).get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return document;
	}

}
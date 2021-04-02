import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.aldrich.pase.util.PASEConstants;

public class HealthcareIt {

	public static void main(String[] args) {

		Document document = null;
		String url="https://www.healthcareitcentral.com/search_result.cfm?grp=1&sort=datedsc&jobcountryid=%270%27&keywords=&jobtypeid=0&zipcode=&radius=5&dayold=0&categoryid=0&jobspage=20&opt=or&cid=0";
		System.out.println(url);
		document=getURLResponse(url);


		for (Element table : document.select("table[cellpadding=0]")) {
			for (Element row : table.select("tr)")) {
				Elements tds = row.select("td[align=center]");
				System.out.println(tds.get(0).text() + "->" + tds.get(1).text());
			}
		}


	}

	public static Document getURLResponse(String url) {
		Document document = null;
		try {
			document = Jsoup.connect(url).followRedirects(true).userAgent(PASEConstants.USER_AGENT).ignoreHttpErrors(true).timeout(0).get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return document;
	}

}

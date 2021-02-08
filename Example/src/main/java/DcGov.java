import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DcGov {

	public static void main(String[] args) {

		Document doc=null;

		String url="http://app.ocp.dc.gov/RUI/information/award/search_results.asp?page=26";
		try {
			doc=Jsoup.connect(url).followRedirects(true).get();
			
			Elements div_elements = doc.select("a");
			if (div_elements != null && div_elements.size() > 0) {
				for (Element element : div_elements) {
					try {
						if (element.hasAttr("class") && element.attr("class").equals("red")) {
							System.out.println(element.attr("abs:href"));
							
						}
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}


	}

}

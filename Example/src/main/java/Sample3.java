import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Sample3 {

	public static void main(String[] args) {

		Document document=null;
		String pageData=null;

		String link="https://www.capterra.com/p/179048/One-Earth/";

		try{
			document=Jsoup.connect(link).get();

			Elements h4_tags = document.select("h4");
			if (h4_tags != null && h4_tags.size() > 0) {
				for (Element element : h4_tags) {
					try {
						if (element.hasAttr("class") && element.attr("class").equals("SimilarCategoryList__HeadingBlack-wep0u-2 gmlGZW Heading-p3hmo4-3 fcpIVn")) {
						System.out.println(element.text().replace("Similar Categories to ", "").replace(":", "").toString().trim());
						}
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
			
			Elements script_tags = document.select("script");
			String str = script_tags.toString().substring(script_tags.toString().indexOf(" window['SSR_BRIDGE_DATA']"),
			script_tags.toString().indexOf("<script>(function()")).trim();
			pageData=str.replace("window", "").replace("</script>", "").replace("['SSR_BRIDGE_DATA']", "").trim().replace("=", "").trim().toString();

			System.out.println(pageData);

			File file = new File("C:\\OM\\text\\ouktda.txt"); 
			FileOutputStream fos = new FileOutputStream(file);
			PrintStream ps = new PrintStream(fos);
			System.setOut(ps);
			System.out.println(pageData);

		}catch(Exception e)	
		{
			e.printStackTrace();
		}

	}

}

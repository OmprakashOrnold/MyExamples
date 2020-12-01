import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class LinkedInSimilarPagesExtraction {

	public static void main(String[] args) throws IOException{

		
		String companyLogo=null;
		String companyUrl=null;
		String description = null;
		String companyName=null;

		Document document = null;


		File fullFileName = new File("C:\\Users\\oppeddamadthala\\Downloads\\WellsFargoOnly3.html");
		document = Jsoup.parse(fullFileName, "UTF-8");


		Elements elements = document.select("section");
		if (elements!=null && elements.size()>0) {
			for (Element similar_pages : elements) {	
				try {
				//	Elements similar_pages1=similar_pages.select("section[class=org-grid__right-rail-width-enforcer mb3 container-with-shadow p0 ember-view]");
				//	System.out.println(similar_pages1);
					Elements similarPagesElement=similar_pages.getElementsByClass("org-grid__right-rail-width-enforcer mb3 container-with-shadow p0 ember-view");	
					//Elements ul_tag=similarPagesElement.tagName("a");
					for (Element ulTags : similarPagesElement) {
						try {
							Elements list_tags=ulTags.getElementsByClass("artdeco-list__item");
							for (Element listTags: list_tags) {
								try {
									companyName=listTags.select("h3").text();
									description=listTags.getElementsByTag("dd").text();
									companyUrl=listTags.getElementsByTag("a").attr("href");
                                    companyLogo=listTags.getElementsByTag("img").attr("src");

								} catch (Exception e) {
									e.printStackTrace();
								}
								System.out.println("------------------------------------------------------");
								System.out.println("Company name ---->"+companyName);
								System.out.println("description  ---->"+description);
								System.out.println("company Url  ---->"+companyUrl);
								System.out.println("company logo ---->"+companyLogo);
								System.out.println("------------------------------------------------------");

							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}
	}
}







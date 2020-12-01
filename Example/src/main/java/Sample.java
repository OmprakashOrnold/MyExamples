import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Sample {  
	public static void main(String args[])  {


		Document document=null;
		String categoryLink=null;
		
		String link="https://www.capterra.com/categories";
		try{
			document=Jsoup.connect(link).get();
			
			Elements div_elements = document.select("ol");
			if (div_elements != null && div_elements.size() > 0) {
				for (Element element : div_elements) {
					try {
						if (element.hasAttr("class") && element.attr("class").equals("nav  browse-group-list")) {
							Elements anchor_tags=element.getElementsByTag("a");
							for (Element element2 : anchor_tags) {
								System.out.println(element2.attr("abs:href"));
								categoryLink=element2.attr("abs:href");
								processCategoryLink(categoryLink);
							}
							
						}
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
			
		}catch(Exception e)	
		{
			e.printStackTrace();
		}
	}

	public static void processCategoryLink(String categoryLink) {
		Document document=null;
		try{
			document=Jsoup.connect(categoryLink).get();
			
			Elements anchor_tags=document.select("a");
			for (Element element : anchor_tags) {
				try{
				if (element.hasAttr("class") && element.attr("class").equals("Link__StyledStandardLink-sc-1xhgva3-0 hOvMtD")) {
					//System.out.println(element.getElementsByAttributeValueStarting("abs:href", "https://www.capterra.com/p/"));
					//System.out.println(element);
				}
				
				}catch(Exception e)	
				{
					e.printStackTrace();
				}
				
			}
			
			
			
		}catch(Exception e)	
		{
			e.printStackTrace();
		}
	}
}
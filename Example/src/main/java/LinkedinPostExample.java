import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class LinkedinPostExample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
				Document document = null;
				
			

				File fullFileName = new File("C:\\Users\\oppeddamadthala\\Downloads\\Woundtech2.html");
				// read the content from file
				document = Jsoup.parse(fullFileName, "UTF-8");
				// get the followersCount
				Elements followersCount=document.getElementsByClass("truncate feed-shared-text-view white-space-pre-wrap break-words ember-view");
				if(!followersCount.isEmpty())
				{
					System.out.println(followersCount.first().text().replace(" followers","").replace(",", "").trim());
				}
				// get other details
				
				Elements div_elements = document.select("div");
				if (div_elements != null && div_elements.size() > 0) {
					for (Element element : div_elements) {
						System.out.println(element);					}
				}
				
	}

}

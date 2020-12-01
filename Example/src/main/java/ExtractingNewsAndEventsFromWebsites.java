

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.print.Doc;
import javax.swing.text.StyledEditorKit.ForegroundAction;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ExtractingNewsAndEventsFromWebsites {

	public static void main(String[] args)  {

		List<String> url=new ArrayList<String>();
		url.add("	https://www.ics-nett.com/	");
		url.add("	https://riskspan.com/	"	);
		url.add("	https://medevolve.com/	"	);
		url.add("	https://imagesoftinc.com/		");
		url.add("	https://smartbridge.com/		");
		url.add("	https://www.aladtec.com/		");
		url.add("	https://www.transcard.com/		");
		url.add("	https://carejourney.com/		");
		url.add("	https://www.precisionpractice.com/		");
		url.add("	https://www.precisionpractice.com/		");
		url.add("	https://www.orangescape.com/	");
		url.add("	https://www.ipayables.com/	");
		url.add("	http://www.waitingroomsolutions.com/		");
		url.add("	https://chargeback.com/		");
		url.add("	https://www.agistix.com/	"	);
		url.add("	https://cheetah.com/	"	);
		url.add("	https://freightverify.com/	"	);
		url.add("	https://www.ricssoftware.com/	"	);
		url.add("	https://ainq.com/	"	);
		url.add("	https://ptfs.com/	");

		//Extracting News links from Websites
		Iterator<String> iterator= url.iterator();
		while (iterator.hasNext()) {
			String urlLink= (String) iterator.next();
			getBlogLinks(urlLink);
		}
	}

	public static String getBlogLinks(String urlLink) {
		String news_link=null;
		try {
			Document document=Jsoup.connect(urlLink).get();
		   

			String pattern1="(blog)|(type/blog)|(en/blog)|(/blog)|(/blog/)|(blog/)|tm-blog|bolgs|(/buzz/blog/)|(events)|(articles)";
	
			Elements newsLinks1 =document.getElementsByAttributeValueMatching("href", pattern1);

			if(!newsLinks1.attr("href").isEmpty()) 
			{							
		
				if(!(newsLinks1.attr("abs:href").contains("wp-content")))
				{
					if(!newsLinks1.attr("abs:href").isEmpty())
					{
						 news_link=newsLinks1.attr("abs:href");
						
						
					}
				}
			}else {
				news_link="";
			}

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return news_link;
	}
}






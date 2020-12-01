
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

class Mycode2
{
	public static void main(String[] args)
	{
		Document document=null;
		
		List<String> url=new ArrayList<String>();
		url.add("https://corstrata.com/");
		url.add("https://www.ncbi.nlm.nih.gov/pubmed/30864302");
		url.add("https://www.maxwellhealthcareassociates.com/.../press-release-maxwell- healthcare-teams-up-with-swift-for-digital-wound-care-management");
		url.add("https://bciincorporated.com/wound-care-management/");
		url.add("https://www.todayswoundclinic.com/articles/product-news-7");
		url.add("https://www.mcknights.com/.../ehr-company-announces-canadian-wound- care-partnership/");
		url.add("https://blog.pointclickcare.com/tackle-challenges-wound-care-technology/");
		url.add("https://www.healthoutcomesww.com/.../sigmacare-enters-into-strategic- partnership-with-health-outcomes-worldwide");
		Iterator<String> iterator= url.iterator();
		while (iterator.hasNext()) {
			String urlLink= (String) iterator.next();
			
			try {
				 document=Jsoup.connect(urlLink).ignoreHttpErrors(true).userAgent("Mozilla").get();
				 System.out.println(document.ownText());
			
			} catch (Exception e) {
				e.printStackTrace();
			}
			}
		}
		
	}				
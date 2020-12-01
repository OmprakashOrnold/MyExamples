import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.xmlbeans.impl.soap.Node;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.w3c.dom.NodeList;

public class CompanyMetaInfo {

	public static void main(String[] args) {

		Document doc=null;

		List<String> url=new ArrayList<String>();



		
		
			
		url.add("	http://www.Bizo.com	");
		url.add("	http://www.DiscountCleaningProducts.com	");
		url.add("	http://www.BrightSourceEnergy.com/	");
		url.add("	https://www.tigerfitness.com/		");
		
		url.add("	http://www.etouches.com	");
		url.add("	http://www.gosynergetic.com	");
		url.add("	http://www.Integrity-EDS.com	");
		url.add("	https://www.dignitastechnologies.com/		");
		url.add("	http://www.Cellucor.com	"	);
		url.add("	http://www.PriveJets.com	");
		url.add("	http://www.HarvestCreative.com		");
		url.add("	http://www.TheFreshDiet.com		");
		url.add("	http://PeachMac.com	");
		url.add("	http://www.dotnetnuke.com	");
		url.add("	https://www.zenoss.com/		");
		url.add("	http://www.L2TMedia.com	");
		url.add("	http://www.SciMetrika.com	");
		url.add("		http://www.CreativeTent.us	");
		url.add("	http://www.EvolveMfg.com	");
		url.add("	http://www.SunshineMint.com	");
		url.add("	http://USLED.com	");
		url.add("	http://www.AventisSystems.com		");
		url.add("	http://www.Servomation.com	");
		url.add("	http://www.HiatusSpa.com	");
		url.add("	http://www.CommercialBargains.com       	");
		url.add("	http://PowerEquipmentDirect.com	");
		url.add("	http://www.vocalocity.com	");
		url.add("	http://www.DirectTransportSys.com	");
		url.add("	http://www.SenaCases.com	");
		url.add("	http://www.HealthcareDataSolutions.com		");
		url.add("	http://www.enkitec.com	");
		url.add("	http://www.telesphere.com	");
		url.add("	http://www.TeamSquarePeg.com	");
		url.add("		http://www.SimpsonPlastering.com	");
		url.add("	http://ZiplineLogistics.com	");
		url.add("	http://WorthingtonJewelers.com		");








		Iterator<String> iterator= url.iterator();
		while (iterator.hasNext()) {
			String urlLink= (String) iterator.next();
			try {
				doc =Jsoup.connect(urlLink).get();		
				int count=1;
				Elements metaTags=doc.select("meta");
				if (metaTags != null && metaTags.size() > 0) {
					System.out.println("-------------------------------------------------");
					System.out.println(urlLink);	
					for (Element element : metaTags) {

						try {										
							//System.out.println(element);						
							
							  System.out.println("Number of metaTags  "+count++);
							  System.out.println("meta_name_value   ------>"+element.attr("charset"));
							  System.out.println("meta_name_value   ------>"+element.attr("name"));
							  System.out.println("meta_name_value   ------>"+element.attr("http-equiv"));
							  System.out.println("meta_name_value   ------>"+element.attr("itemprop"));
							  System.out.println("meta_name_value   ------>"+element.attr("property"));
							  System.out.println("meta_name_value   ------>"+element.attr("id"));
							  System.out.println("meta_name_value   ------>"+element.attr("prefix"));
							  System.out.println("meta_name_value   ------>"+element.attr("class"));
							  System.out.println("meta_name_value   ------>"+element.attr("data-type"));
							  System.out.println("meta_name_value   ------>"+element.attr("data-shop-id"));
					
							  System.out.println("meta_name_value   ------>"+element.attr("data-environment"));
							  System.out.println("meta_name_value   ------>"+element.attr("data-locale"));
							  System.out.println("meta_name_value   ------>"+element.attr("data-location"));
							  System.out.println("meta_content_value------>"+element.attr("content"));
							 						 			 						 
						}	
						catch (Exception e) {
							e.printStackTrace();
						}

					}
					System.out.println("-------------------------------------------------");
				}

			}	
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}









}

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ShopTalkSpeakers {

	public static void main(String[] args) {
		Document doc=null;
		Document doc1=null;
		String speakersurl=null;
		String personname=null;
		String title=null;
		String companyname=null;
		String description=null;

		int count=1;

		String url="https://shoptalk.com/speakers";
		try {
			doc=Jsoup.connect(url).followRedirects(true).ignoreHttpErrors(true).get();

			Elements div_elements = doc.select("div");
			if (div_elements != null && div_elements.size() > 0) {
				for (Element element : div_elements) {
					try {
						if (element.hasAttr("class") && element.attr("class").equals("col-6 col-sm-4 col-md-3 col-lg-2 speaker")) {
							if (element.childNodes().size() > 0) {
								if(element.getElementsByTag("a").attr("href") != "")
								{								
									speakersurl=element.getElementsByTag("a").attr("href");

									doc1=Jsoup.connect(speakersurl).followRedirects(true).ignoreHttpErrors(true).get();
									Elements div_elements1 = doc1.select("div");
									if (div_elements1 != null && div_elements1.size() > 0) {
										for (Element element1 : div_elements1) {
											try {
												if (element1.hasAttr("class") && element1.attr("class").equals("col-12 col-md-8 col-description")) {
													if (element1.childNodes().size() > 0) {
														if(!element1.select("p").text().isEmpty())
														{
															description=element1.select("p").text();
														}else
														{
															if(!element1.select("div").text().contains("Shoptalk"))
															{
																description=element1.select("div").text();
															}
														}													
														if(!element1.select("h3").text().isEmpty())
														{
															personname=element1.select("h3").text().trim();
															title=element1.select("h4").text().trim();
															companyname=element1.select("h5").text().trim();

															System.out.println("---------------------------------------");
															System.out.println(count+" "+personname);
															count++;
															System.out.println(title);
															System.out.println(companyname);
															System.out.println(description);
															System.out.println("---------------------------------------");															
														}     				
													}
												}                              				
											}catch(Exception es) {
												es.printStackTrace();
											}                              			
										}                              		
									}

								}else {
									Elements missingLinks=element.select("div[class=info]").tagName("span");
									for (Element missingLink : missingLinks) {
										System.out.println(count+" "+missingLink.select("span[class=name]").text());
										System.out.println(missingLink.select("span[class=title]").text());
										System.out.println(missingLink.select("span[class=company]").text());
									}		
								}
							}
						}
					} catch (Exception ex) {
						ex.printStackTrace();
					}
					
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}


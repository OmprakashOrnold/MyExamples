import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ShopTalkSponser {


	public static void main(String[] args) {
		Document doc=null;
		Document doc1=null;
		String sponsersUrl=null;
		String companyurl=null;
		String companylogo=null;
		String companyname=null;
		String description=null;
		int count=1;

		String url="https://shoptalk.com/sponsors";
		try {
			doc=Jsoup.connect(url).followRedirects(true).ignoreHttpErrors(true).get();

			Elements div_elements = doc.select("div");
			if (div_elements != null && div_elements.size() > 0) {
				for (Element element : div_elements) {
					try {
						if (element.hasAttr("class") && element.attr("class").equals("inner")) {
							if (element.childNodes().size() > 0) {
								sponsersUrl=element.select("a").attr("href");
								companylogo=element.select("img").attr("src");
								doc1=Jsoup.connect(sponsersUrl).followRedirects(true).ignoreHttpErrors(true).get();
								Elements div_elements1 = doc1.select("div");
								if (div_elements1 != null && div_elements1.size() > 0) {
									for (Element element1 : div_elements1) {
										try {
											if (element1.hasAttr("class") && element1.attr("class").equals("inner")) {
												
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
													companyname=element1.select("h3").text().trim();
													companyurl=element1.select("a").attr("href");
													
													System.out.println("---------------------------------------");
													System.out.println(count+":"+companyname);
													count++;
													System.out.println(description);
													System.out.println(companyurl);
													System.out.println(companylogo);
													System.out.println("---------------------------------------");															
												}     	
											}

										}catch(Exception es) {
											es.printStackTrace();
										}                              			
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

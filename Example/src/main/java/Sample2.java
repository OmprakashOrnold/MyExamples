import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Sample2 {

	public static void main(String[] args) throws InterruptedException {

		Document document = null;
	

		String pageData=null;
		File folder = new File("C:\\OM\\capteraa\\CapteraaFinalFiles\\FalutpagesRepaired");
		File[] listOfFiles = folder.listFiles();

		for (File file : listOfFiles) {

			if (file.isFile()) {
				try {
					File fullFileName = new File("C:\\OM\\capteraa\\CapteraaFinalFiles\\FalutpagesRepaired\\"+file.getName());
					String catagoryName=fullFileName.getName().replace(".html", "");
					
					Thread.sleep(1000);
					document = Jsoup.parse(fullFileName, "UTF-8");
					String urlPattern="(/)[p]/[0-9]";
					String link=null;

					Elements div_tag = document.getElementsByClass("ConditionalLinkWrapper__StyledLink-e1dhht-0 dDTiOr Link__StyledStandardLink-sc-1xhgva3-0 hOvMtD");
					for (Element element : div_tag) {
						String productId=null;
						try{
							Elements urlLink= element.getElementsByAttributeValueMatching("href", urlPattern);
							if(!urlLink.isEmpty())
							{
								String product[]=urlLink.attr("href").trim().replace("reviews/","" ).replace("#reviews","" ).trim().replaceFirst("/p/", "").split("/");
								productId=product[0];
								link="https://www.capterra.com"+urlLink.attr("href").trim().replace("reviews/","" ).replace("#reviews","" ).trim();
								
								try{
										document=Jsoup.connect(link).ignoreHttpErrors(true).userAgent("Mozilla").get();
										
										Elements script_tags = document.select("script");
										//System.out.println(script_tags);
										String str = script_tags.toString().substring(script_tags.toString().indexOf(" window['SSR_BRIDGE_DATA']"),
												script_tags.toString().indexOf("<script>(function()")).trim();
										pageData=str.replace("window", "").replace("</script>", "").replace("['SSR_BRIDGE_DATA']", "").trim().replace("=", "").trim().toString();


										File file1 = new File("C:\\OM\\capteraa\\CapteraaFinalFiles\\FaultJsonFiles\\"+catagoryName+"-"+productId+".txt");
										FileOutputStream fos = new FileOutputStream(file1);
										PrintStream ps = new PrintStream(fos);
									    System.setOut(ps);
										System.out.println(pageData);

									}catch(Exception e)	
									{
										e.printStackTrace();
									}
							}
						} catch (Exception e) {			
							e.printStackTrace();
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}



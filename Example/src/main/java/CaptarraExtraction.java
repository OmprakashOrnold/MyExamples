import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CaptarraExtraction {

	public static void main(String[] args) throws InterruptedException {

		Document document = null;
		String pageData=null;

		 String catagoryName="fleet-management-software";
				try {
					File fullFileName = new File("C:\\OM\\FinalCap\\"+catagoryName+".html");
					
					Thread.sleep(1000);
					document = Jsoup.parse(fullFileName, "UTF-8");
					String urlPattern="(/)[p]/[0-9]";
					String link=null;


				/*	Elements p_tag = document.getElementsByClass("listing-description  milli hide-palm");
					for (Element element : p_tag) {
						String productId=null;
						try{
							Elements urlLink= element.getElementsByAttributeValueMatching("href", urlPattern);
							if(!urlLink.isEmpty())
							{
								//System.out.println(urlLink.attr("href").replaceAll("[a-zA-Z/-]", "").trim());
								String product[]=urlLink.attr("href").trim().replaceFirst("/p/", "").split("/");
								productId=product[0];
								link="https://www.capterra.com"+urlLink.attr("href");	
								

								try{
									document=Jsoup.connect(link).ignoreHttpErrors(true).userAgent("Mozilla").get();
                                    

									Elements script_tags = document.select("script");
									String str = script_tags.toString().substring(script_tags.toString().indexOf(" window['SSR_BRIDGE_DATA']"),
											script_tags.toString().indexOf("<script>(function()")).trim();
									pageData=str.replace("window", "").replace("</script>", "").replace("['SSR_BRIDGE_DATA']", "").trim().replace("=", "").trim().toString();

									//System.out.println(pageData);

									File file1 = new File("C:\\OM\\capterraJsons1\\"+catagoryName+"-"+productId+".txt"); 
									System.out.println(productId+"saved successfully");
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
					}*/
					Elements div_tag = document.getElementsByClass("ConditionalLinkWrapper__StyledLink-e1dhht-0 dDTiOr Link__StyledStandardLink-sc-1xhgva3-0 hOvMtD");
					for (Element element : div_tag) {
						String productId=null;
						try{
							Elements urlLink= element.getElementsByAttributeValueMatching("href", urlPattern);
							if(!urlLink.isEmpty())
							{
								String product[]=urlLink.attr("href").trim().replace("reviews/","" ).replace("#reviews","" ).trim().replaceFirst("/p/", "").split("/");
								productId=product[0];
								link="https://www.capterra.com"+urlLink.attr("href");
								System.out.println(productId);
								

/*
								try{
										document=Jsoup.connect(link).ignoreHttpErrors(true).userAgent("Mozilla").get();
										Elements script_tags = document.select("script");
										String str = script_tags.toString().substring(script_tags.toString().indexOf(" window['SSR_BRIDGE_DATA']"),
												script_tags.toString().indexOf("<script>(function()")).trim();
										pageData=str.replace("window", "").replace("</script>", "").replace("['SSR_BRIDGE_DATA']", "").trim().replace("=", "").trim().toString();


										File file1 = new File("C:\\OM\\capterraJsons1\\"+catagoryName+"-"+productId+".txt"); 
-										System.out.println(productId+"saved successfully");
										FileOutputStream fos = new FileOutputStream(file1);
										PrintStream ps = new PrintStream(fos);
										System.setOut(ps);
										System.out.println(pageData);

									}catch(Exception e)	
									{
										e.printStackTrace();
									}*/
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

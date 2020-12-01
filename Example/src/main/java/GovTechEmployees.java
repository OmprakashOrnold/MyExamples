import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GovTechEmployees {

	public static void main(String[] args) {
		try {
			Document doc = Jsoup.connect("https://www.govtech.com/100/2016/").followRedirects(true).timeout(0).get();
			if(doc!=null)
			{
				Elements table = doc.select("tbody");
				if(!table.isEmpty())
				{
					for(Element tr : table.select("tr"))
					{
						try {
							String name=null;
							String founded=null;
							String Headquaters=null;
							String Description=null;
							String acquisitions=null;
							String funding =null;
							String categories =null;
							String crunchBaseLink=null;
							String employees=null;
							String facebookLink=null;
							String twitterLink=null;
							String linkedLink =null;
							String employeeImageUrl= null;
							String employeName=null;
							try {
								Elements tds=tr.select("td");
								if(!tds.isEmpty())
								{
									name=tds.get(0).text();
									founded=tds.get(1).text();
									Headquaters=tds.get(2).text();
									Description=tds.get(3).text();
									Elements companyLink=tr.getElementsByAttributeValueContaining("href", ".html");
									String url=companyLink.attr("href");
									if(!url.isEmpty())
									{
										Document doc1 = Jsoup.connect(url).followRedirects(true).timeout(0).get();

										Elements divTag =doc1.select("div[class=col-md-8]");	
										if(divTag != null)
										{
											Elements table1=divTag.select("tbody");
											Elements tr1=table1.select("tr");
											Element row1=tr1.get(0);
											Elements td1=row1.select("td");
											if(!td1.get(1).text().isEmpty())
											{
												acquisitions=td1.get(1).text();										
											}

											Element row2=tr1.get(1);
											Elements td2=row2.select("td");
											if(!td2.get(1).text().isEmpty())
											{										
												funding =td2.get(1).text();										
											}
											if(tr1.size()>4)
											{
												Element row4=tr1.get(4);
												Elements td4=row4.select("td");
												if(!td4.get(1).text().isEmpty())
												{										
													categories =td4.get(1).text().trim();											
												}
												Elements divTagForCrunchBase =doc1.select("div[class=col-sm-4]");
												Elements crunchBaseLinkk=divTagForCrunchBase.select("a");
												crunchBaseLink=crunchBaseLinkk.attr("href");									
											}	

											Elements  empolyeeImageElements=doc1.select("div[class=col-xs-3 text-center]");
											for (Element  empolyeeImageElement: empolyeeImageElements) {
												try {
													employeName=empolyeeImageElement.text();
												  	
												Elements employeeImageEle=empolyeeImageElement.select("img");
												employeeImageUrl= employeeImageEle.attr("src");
												
												}catch (Exception e) {
													e.printStackTrace();
												}
												
												System.out.println("employeeImageUrl  "+employeeImageUrl);
												System.out.println("employeeName      "+employeName);
											}
											
											
											
											if(tr1.size()>7)
											{
												Element row7=tr1.get(7);
												Elements td7=row7.select("td");									
												employees=td7.get(1).text();										
												Element row5=tr1.get(5); 
												Elements td5=row5.select("td"); 
												Elements socialLink=td5.select("a");
												if(socialLink.size()>0)
												{

													facebookLink=socialLink.get(0).attr("href");

													if(socialLink.size()>1)
													{

														twitterLink=socialLink.get(1).attr("href");												
													}
													if(socialLink.size()>2)
													{

														linkedLink =socialLink.get(2).attr("href");

													}
												}
											}
										}
									}
								}

							}catch (Exception e) {
								e.printStackTrace();
							}
							System.out.println("=================================================");
							System.out.println("name              "+name);
							System.out.println("founded           "+founded);
							System.out.println("Headquaters       "+Headquaters);
							System.out.println("Description       "+Description);
							System.out.println("Acquisitions      "+acquisitions);
							System.out.println("Funding           "+funding);
							System.out.println("Categories        "+categories);
							System.out.println("CrunchBaseLink    "+crunchBaseLink);
							System.out.println("Employees         "+employees);
							System.out.println("Facebook Link     "+facebookLink);
							System.out.println("TwitterLink       "+twitterLink);
							System.out.println("Linked Link       "+linkedLink);
							
							



						}catch (Exception e) {
							e.printStackTrace();
						}
					}

				}
			}

		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}

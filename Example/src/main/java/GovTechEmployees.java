import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.csvreader.CsvWriter;

public class GovTechEmployees {

	private static String twiterPattern = "(http|https)://(www.)?(twitter.com)/[A-Za-z0-9_?=]{0,100}";

	private static String linkedinPattern = "(http|https){0,1}:{0,1}//(www.)?(linkedin.com)/[A-Za-z0-9-_./?=]{0,1000}";

	private static String fbPattern = "(http|https){0,1}:{0,1}//(www.)?(facebook.com/)[A-Za-z0-9-_./?=@#%&]{0,1000}";

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
							String Website=null;
							try {
								Elements tds=tr.select("td");
								if(!tds.isEmpty())
								{
									name=tds.get(0).text();
									founded=tds.get(1).text();
									Headquaters=tds.get(2).text();
									Description=tds.get(3).text();
									Elements companyLink=tr.getElementsByAttributeValueContaining("href", ".html");
									if(companyLink.hasAttr("href"))
									{
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
													
													Elements divTagForCrunchBase =doc1.select("div[class=col-sm-4]");
													Elements crunchBaseLinkk=divTagForCrunchBase.select("a");
													crunchBaseLink=crunchBaseLinkk.attr("href");									
												}	




												Elements employeElement =doc1.select("div[class='row-fluid comp-info basic']");	
												for (Element element : employeElement) {
													Elements employeElements =element.getElementsByClass("col-xs-12");	
													for (Element element2 : employeElements) {

														for (Element table2 : element2.select("table.table ")) {
															for (Element row : table2.select("tr")) {
																Elements tds2 = row.select("td");
																if(tds2.get(0).text().equals("Employees") )
																{
																	employees="'"+tds2 .get(1).text();
																}

															}
														}
													}
												}


												Elements e=doc1.getElementsByAttributeValueContaining("href","twitter.com/");
												if(!e.attr("href").isEmpty()) {
													if (e.attr("href").matches(twiterPattern)) {
														if(!e.attr("href").contains("govtechnews"))
														{
															twitterLink=e.attr("href");
															//System.out.println(twitterLink);
														}
													}
												}


												Elements linkedInLink= doc1.getElementsByAttributeValueContaining("href", "linkedin.com/company");
												if(!linkedInLink.attr("href").isEmpty())
												{
													if(linkedInLink.attr("href").matches(linkedinPattern))
													{	
														if(!linkedInLink.attr("href").contains("government-technology"))
														{
															linkedLink=linkedInLink.attr("href");
															System.out.println(linkedLink);
														}
													}
												}


												Elements e2=doc1.getElementsByAttributeValueContaining("href", "facebook.com/");
												if (!e2.attr("href").isEmpty()) {
													if (e2.attr("href").matches(fbPattern)) {
														if(!e2.attr("href").contains("governmenttechnology"))
														{
															facebookLink=e2.attr("href");
															//System.out.println(facebookLink);
														}
													}
												}

												Elements websiteElement =doc1.select("div[class='col-md-8']");	
												for (Element element : websiteElement) {
													for (Element table2 : element.select("table.table ")) {
														for (Element row : table2.select("tr")) {
															Elements tds2 = row.select("td");
															for (Element element2 : tds2) {
																if(element2.text().equals("Link"))
																{
																	//System.out.println(element2.getElementsByTag("a").attr("href"));
																	Website=element2.getElementsByTag("a").attr("href");
																}
																if(element2.text().equals("Categories"))
																{
																	//System.out.println(element2.getElementsByTag("a").attr("href"));
																	categories=element2.nextElementSibling().text();
																}
															}
														}
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
							System.out.println("website           "+Website);
							System.out.println("Facebook Link     "+facebookLink);
							System.out.println("Twitter Link       "+twitterLink);
							System.out.println("Linked Link       "+linkedLink);


							String outputFile = "C:\\Om\\govtech_2016.csv";
							// before we open the file check to see if it already exists
							boolean alreadyExists = new File(outputFile).exists();

							try {
								// use FileWriter constructor that specifies open for appending
								CsvWriter csvOutput = new CsvWriter(new FileWriter(outputFile, true), ',');

								// if the file didn't already exist then we need to write out the header line
								if (!alreadyExists)
								{
									csvOutput.write("name");
									csvOutput.write("url");
									csvOutput.write("domain");
									csvOutput.write("founded");
									csvOutput.write("Headquaters");
									csvOutput.write("Description");
									csvOutput.write("Acquisitions");
									csvOutput.write("Funding");
									csvOutput.write("Categories");
									csvOutput.write("CrunchBase Link");
									csvOutput.write("Employees");
									csvOutput.write("Facebook Link ");
									csvOutput.write("Twitter Link");
									csvOutput.write("Linkedin Link  ");
									csvOutput.write("Activity Date Time ");

									csvOutput.endRecord();
								}

								csvOutput.write(name);

								if(!Website.isEmpty()&&Website!=null)
								{
									csvOutput.write(Website);
									csvOutput.write(getDomainNameForURL(Website));
								}

								csvOutput.write(founded);
								csvOutput.write(Headquaters);
								csvOutput.write(Description);
								csvOutput.write(acquisitions);
								csvOutput.write(funding);
								csvOutput.write(categories);
								csvOutput.write(crunchBaseLink);
								csvOutput.write(employees);
								csvOutput.write(facebookLink);
								csvOutput.write(twitterLink);
								csvOutput.write(linkedLink);
								csvOutput.write(new Date().toString());
								csvOutput.endRecord();


								csvOutput.close();
							} catch (IOException e) {
								e.printStackTrace();
							}


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

	public static String getDomainNameForURL(String url) {
		String updatedURL = null;
		if(!url.isEmpty()&&url!=null)
		{
			try {
				updatedURL = url.replace("///", "//").replace(",", ".");

				URI uri = new URI(url);
				String domain = uri.getHost();

				if (domain != null) {
					updatedURL = domain.startsWith("www.") ? domain.substring(4) : domain;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return updatedURL;
	}
}

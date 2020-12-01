
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class CapterraReviews {

	public static void main(String[] args) {Document document = null;
	File folder = new File("C://OM//capteraa//capterra reviews//demo");
	File[] listOfFiles = folder.listFiles();
	for (File file : listOfFiles) {
		if (file.isFile()) {
			try {
				File fullFileName = new File("C://OM//capteraa//capterra reviews//demo//"+file.getName());
				document = Jsoup.parse(fullFileName, "UTF-8");


				Long productId=null;
				String name=null;
				String jobTitle=null;
				String company_size=null;
				String companyType=null;
				String usedFor=null;
				float  overallRating=0.0f;
				float  easeofUse=0.0f;
				float  customerService=0.0f;
				float  features=0.0f;
				float  valueforMoney=0.0f;

				String reviewTitle=null;
				String overall=null;
				String pros=null;
				String cons=null;
				String choosingReason=null;
				String switchingReason =null;
				String writtenOn=null;

				productId=Long.parseUnsignedLong(file.getName().replace(".html", ""));

				Elements div_elements = document.select("div");
				if (div_elements != null && div_elements.size() > 0) {
					for (Element element : div_elements) {
						try {

							if (element.hasAttr("class") && element.attr("class").equals("ReviewCard__Root-sc-18j15p9-0 cVvDhs")) {

								Elements reveiwerDetails = element.getElementsByClass("ReviewerAvatarSection__Root-sc-1a80501-0 qIcnK");
								if (reveiwerDetails != null && reveiwerDetails.size() > 0) {
									for (Element reveiwerDetail : reveiwerDetails) {
										Thread.sleep(1000);
										try {
											if (reveiwerDetail.hasAttr("class") && reveiwerDetail.attr("class").equals("ReviewerAvatarSection__Root-sc-1a80501-0 qIcnK")) {				

												name=reveiwerDetail.getElementsByClass("ReviewerAvatarSection__ReviewerName-sc-1a80501-2 gJQgt").text();	
												System.out.println("name            "+name);

												//System.out.println(reveiwerDetail.getElementsByClass("ReviewerAvatarSection__ReviewerDetails-sc-1a80501-4 bInnRf").text());
												Elements reviewsdet=reveiwerDetail.getElementsByClass("ReviewerAvatarSection__ReviewerDetails-sc-1a80501-4 bInnRf");
												List<String> jobtitleList=reviewsdet.eachText();									
												for (String jobtitles : jobtitleList) {

													String jtitles[]=jobtitles.split(": ");
													String companyTyp=jtitles[0];
													String mainJtitle[]=companyTyp.split(", ");


													if(mainJtitle[0].contains(" "))
													{
														jobTitle=mainJtitle[0].substring(0, mainJtitle[0].lastIndexOf(" "));
														companyType=mainJtitle[0].substring(mainJtitle[0].lastIndexOf(" ")+1);
													}
													company_size=mainJtitle[1].replace("Used the software for", "");
													usedFor=jtitles[1];

													System.out.println("jobTitle           "+jobTitle);
													System.out.println("companyType        "+companyType);
													System.out.println("company_size       "+company_size);
													System.out.println("usedFor            "+usedFor);


												}							
											}
										} catch (Exception ex) {
											ex.printStackTrace();
										}
									}
								}

								Elements overallratings = element.getElementsByClass("RatingContainer__Root-zgij78-0 iQIaCo");
								if (overallratings != null && overallratings.size() > 0) {
									for (Element overallrating : overallratings) {
										//	Thread.sleep(1000);
										try {
											if (overallrating.hasAttr("class") && overallrating.attr("class").equals("RatingContainer__Root-zgij78-0 iQIaCo")) {				

												if(overallrating.getElementsByClass("RatingContainer__Root-zgij78-0 iQIaCo").text().replace("/5", "").contains("Overall Rating"))
												{
													overallRating=Float.parseFloat(overallrating.getElementsByClass("RatingContainer__Root-zgij78-0 iQIaCo").text().replace("/5", "").replaceAll("[a-zA-Z]", "").trim());
													System.out.println("overallRating       "+overallRating);
												}
											}
										} catch (Exception ex) {
											ex.printStackTrace();
										}
									}
								}

								Elements remainingRatings = element.getElementsByClass("RatingContainer__Root-zgij78-0 kqvecF");
								if (remainingRatings != null && remainingRatings.size() > 0) {
									for (Element remainingRating : remainingRatings) {
										//Thread.sleep(1000);
										try {
											if (remainingRating.hasAttr("class") && remainingRating.attr("class").equals("RatingContainer__Root-zgij78-0 kqvecF")) {
												if(remainingRating.getElementsByClass("RatingContainer__Root-zgij78-0 kqvecF").text().contains("Ease"))
												{
													easeofUse=Float.parseFloat(remainingRating.getElementsByClass("RatingContainer__Root-zgij78-0 kqvecF").text().replace("/5", "").replaceAll("[a-zA-Z]", "").trim());
													System.out.println("Ease of Use             "+easeofUse);
												}

												if(remainingRating.getElementsByClass("RatingContainer__Root-zgij78-0 kqvecF").text().contains("Customer"))
												{
													customerService=Float.parseFloat(remainingRating.getElementsByClass("RatingContainer__Root-zgij78-0 kqvecF").text().replace("/5", "").replaceAll("[a-zA-Z]", "").trim());
													System.out.println("Customer Service        "+customerService);
												}

												if(remainingRating.getElementsByClass("RatingContainer__Root-zgij78-0 kqvecF").text().contains("Features"))
												{
													features=Float.parseFloat(remainingRating.getElementsByClass("RatingContainer__Root-zgij78-0 kqvecF").text().replace("/5", "").replaceAll("[a-zA-Z]", "").trim());
													System.out.println("features                "+features);
												}

												if(remainingRating.getElementsByClass("RatingContainer__Root-zgij78-0 kqvecF").text().contains("Value"))
												{
													valueforMoney=Float.parseFloat(remainingRating.getElementsByClass("RatingContainer__Root-zgij78-0 kqvecF").text().replace("/5", "").replaceAll("[a-zA-Z]", "").trim());
													System.out.println("valueforMoney           "+valueforMoney);
												}


											}
										} catch (Exception ex) {
											ex.printStackTrace();
										}
									}
								}


								Elements prosConsDetails = element.getElementsByClass("ReviewCard__RightFlexItem-sc-18j15p9-3 cOmWnW ReviewCard__FlexItem-sc-18j15p9-2 bTVfYT");
								if (prosConsDetails != null && prosConsDetails.size() > 0) {
									for (Element prosConsDetail : prosConsDetails) {
										//Thread.sleep(1000);
										try {
											if (prosConsDetail.hasAttr("class") && prosConsDetail.attr("class").equals("ReviewCard__RightFlexItem-sc-18j15p9-3 cOmWnW ReviewCard__FlexItem-sc-18j15p9-2 bTVfYT")) {				

												Elements reviewtitles = element.getElementsByClass("VisibleInViewport__Root-rewj2p-0 gMsvlr");	
												//System.out.println(nameElements4);
												if (reviewtitles != null && reviewtitles.size() > 0) {
													for (Element reviewtitle : reviewtitles) {

														try {
															if (reviewtitle.hasAttr("class") && reviewtitle.attr("class").equals("VisibleInViewport__Root-rewj2p-0 gMsvlr")) {				

																Elements reviewtitl = reviewtitle.getElementsByTag("h3");

																reviewTitle=removeSpecialCharacters(reviewtitl.text());
																System.out.println("reviewTitle        "+reviewTitle);

																Elements prosconsOverall= reviewtitle.getElementsByClass("ReviewSection__Root-sc-189472c-0 icjcMH");	
																List<String> li=prosconsOverall.eachText();
																for (String opc : li) {

																	if(opc.contains("Overall:"))
																	{
																		overall=opc.replaceAll("Overall:", "").trim().toString();
																		System.out.println("overall    "+overall);
																	}
																	if(opc.contains("Pros:"))
																	{
																		pros=opc.replaceAll("Pros:", "").trim().toString();
																		System.out.println("pros       "+pros);
																	}

																	if(opc.contains("Cons:"))
																	{
																		cons=opc.replaceAll("Cons:", "").trim().toString();
																		System.out.println("cons       "+cons);
																	}

																	if(opc.contains("Choosing"))
																	{
																		String choosingReasons[]=opc.trim().toString().split(":");
																		choosingReason=choosingReasons[1].trim().toString();
																		System.out.println("choosingReason "+choosingReason);
																	}

																	if(opc.contains("Switching"))
																	{
																		String switchingReasons[]=opc.trim().toString().split(":");
																		switchingReason=switchingReasons[1].trim().toString();
																		System.out.println("switchingReason "+switchingReason);
																	}



																}
															}
														} catch (Exception ex) {
															ex.printStackTrace();
														}
													}
												}
											}
										} catch (Exception ex) {
											ex.printStackTrace();
										}
									}
								}

								Elements nameElements5 = element.getElementsByClass("ReviewCard__DesktopOnlyDiv-sc-18j15p9-6 gckeCD");
								if (nameElements5 != null && nameElements5.size() > 0) {
									for (Element nameElement : nameElements5) {
										//	Thread.sleep(1000);
										try {
											if (nameElement.hasAttr("class") && nameElement.attr("class").equals("ReviewCard__DesktopOnlyDiv-sc-18j15p9-6 gckeCD")) {				
												writtenOn=nameElement.getElementsByClass("ReviewSource__Root-lnjke6-0 iBAGLQ").text().replace("Reviewer Source Source: Capterra", "").trim();

												System.out.println("writtenOn          "+writtenOn);	
												System.out.println("=========================================================================");
											}
										} catch (Exception ex) {
											ex.printStackTrace();
										}
									}
								}



							}



							//============================================================================================================//

							if (element.hasAttr("class") && element.attr("class").equals("ReviewCard__Root-sc-18j15p9-0 drqEmZ")) {

								Elements reveiwerDetails = element.getElementsByClass("ReviewerAvatarSection__Root-sc-1a80501-0 qIcnK");
								if (reveiwerDetails != null && reveiwerDetails.size() > 0) {
									for (Element reveiwerDetail : reveiwerDetails) {
										//Thread.sleep(1000);
										try {
											if (reveiwerDetail.hasAttr("class") && reveiwerDetail.attr("class").equals("ReviewerAvatarSection__Root-sc-1a80501-0 qIcnK")) {				

												name=reveiwerDetail.getElementsByClass("ReviewerAvatarSection__ReviewerName-sc-1a80501-2 gJQgt").text();	
												System.out.println("name            "+name);

												//System.out.println(reveiwerDetail.getElementsByClass("ReviewerAvatarSection__ReviewerDetails-sc-1a80501-4 bInnRf").text());
												Elements reviewsdet=reveiwerDetail.getElementsByClass("ReviewerAvatarSection__ReviewerDetails-sc-1a80501-4 bInnRf");
												List<String> jobtitleList=reviewsdet.eachText();									
												for (String jobtitles : jobtitleList) {

													String jtitles[]=jobtitles.split(": ");
													String companyTyp=jtitles[0];
													String mainJtitle[]=companyTyp.split(", ");


													if(mainJtitle[0].contains(" "))
													{
														jobTitle=mainJtitle[0].substring(0, mainJtitle[0].lastIndexOf(" "));
														companyType=mainJtitle[0].substring(mainJtitle[0].lastIndexOf(" ")+1);
													}
													company_size=mainJtitle[1].replace("Used the software for", "");
													usedFor=jtitles[1];

													System.out.println("jobTitle           "+jobTitle);
													System.out.println("companyType        "+companyType);
													System.out.println("company_size       "+company_size);
													System.out.println("usedFor            "+usedFor);


												}							
											}
										} catch (Exception ex) {
											ex.printStackTrace();
										}
									}
								}

								Elements overallratings = element.getElementsByClass("RatingContainer__Root-zgij78-0 iQIaCo");
								if (overallratings != null && overallratings.size() > 0) {
									for (Element overallrating : overallratings) {
										//Thread.sleep(1000);
										try {
											if (overallrating.hasAttr("class") && overallrating.attr("class").equals("RatingContainer__Root-zgij78-0 iQIaCo")) {				

												if(overallrating.getElementsByClass("RatingContainer__Root-zgij78-0 iQIaCo").text().replace("/5", "").contains("Overall Rating"))
												{
													overallRating=Float.parseFloat(overallrating.getElementsByClass("RatingContainer__Root-zgij78-0 iQIaCo").text().replace("/5", "").replaceAll("[a-zA-Z]", "").trim());
													System.out.println("overallRating       "+overallRating);
												}
											}
										} catch (Exception ex) {
											ex.printStackTrace();
										}
									}
								}

								Elements remainingRatings = element.getElementsByClass("RatingContainer__Root-zgij78-0 kqvecF");
								if (remainingRatings != null && remainingRatings.size() > 0) {
									for (Element remainingRating : remainingRatings) {
										//Thread.sleep(1000);
										try {
											if (remainingRating.hasAttr("class") && remainingRating.attr("class").equals("RatingContainer__Root-zgij78-0 kqvecF")) {
												if(remainingRating.getElementsByClass("RatingContainer__Root-zgij78-0 kqvecF").text().contains("Ease"))
												{
													easeofUse=Float.parseFloat(remainingRating.getElementsByClass("RatingContainer__Root-zgij78-0 kqvecF").text().replace("/5", "").replaceAll("[a-zA-Z]", "").trim());
													System.out.println("Ease of Use             "+easeofUse);
												}

												if(remainingRating.getElementsByClass("RatingContainer__Root-zgij78-0 kqvecF").text().contains("Customer"))
												{
													customerService=Float.parseFloat(remainingRating.getElementsByClass("RatingContainer__Root-zgij78-0 kqvecF").text().replace("/5", "").replaceAll("[a-zA-Z]", "").trim());
													System.out.println("Customer Service        "+customerService);
												}

												if(remainingRating.getElementsByClass("RatingContainer__Root-zgij78-0 kqvecF").text().contains("Features"))
												{
													features=Float.parseFloat(remainingRating.getElementsByClass("RatingContainer__Root-zgij78-0 kqvecF").text().replace("/5", "").replaceAll("[a-zA-Z]", "").trim());
													System.out.println("features                "+features);
												}

												if(remainingRating.getElementsByClass("RatingContainer__Root-zgij78-0 kqvecF").text().contains("Value"))
												{
													valueforMoney=Float.parseFloat(remainingRating.getElementsByClass("RatingContainer__Root-zgij78-0 kqvecF").text().replace("/5", "").replaceAll("[a-zA-Z]", "").trim());
													System.out.println("valueforMoney           "+valueforMoney);
												}


											}
										} catch (Exception ex) {
											ex.printStackTrace();
										}
									}
								}


								Elements prosConsDetails = element.getElementsByClass("ReviewCard__RightFlexItem-sc-18j15p9-3 cOmWnW ReviewCard__FlexItem-sc-18j15p9-2 bTVfYT");
								if (prosConsDetails != null && prosConsDetails.size() > 0) {
									for (Element prosConsDetail : prosConsDetails) {
										//Thread.sleep(1000);
										try {
											if (prosConsDetail.hasAttr("class") && prosConsDetail.attr("class").equals("ReviewCard__RightFlexItem-sc-18j15p9-3 cOmWnW ReviewCard__FlexItem-sc-18j15p9-2 bTVfYT")) {				

												Elements reviewtitles = element.getElementsByClass("VisibleInViewport__Root-rewj2p-0 gMsvlr");	
												//System.out.println(nameElements4);
												if (reviewtitles != null && reviewtitles.size() > 0) {
													for (Element reviewtitle : reviewtitles) {

														try {
															if (reviewtitle.hasAttr("class") && reviewtitle.attr("class").equals("VisibleInViewport__Root-rewj2p-0 gMsvlr")) {				

																Elements reviewtitl = reviewtitle.getElementsByTag("h3");

																reviewTitle=removeSpecialCharacters(reviewtitl.text());
																System.out.println("reviewTitle        "+reviewTitle);

																Elements prosconsOverall= reviewtitle.getElementsByClass("ReviewSection__Root-sc-189472c-0 icjcMH");	
																List<String> li=prosconsOverall.eachText();
																for (String opc : li) {

																	if(opc.contains("Overall:"))
																	{
																		overall=opc.replaceAll("Overall:", "").trim().toString();
																		System.out.println("overall    "+overall);
																	}
																	if(opc.contains("Pros:"))
																	{
																		pros=opc.replaceAll("Pros:", "").trim().toString();
																		System.out.println("pros       "+pros);
																	}

																	if(opc.contains("Cons:"))
																	{
																		cons=opc.replaceAll("Cons:", "").trim().toString();
																		System.out.println("cons       "+cons);
																	}

																	if(opc.contains("Choosing"))
																	{
																		String choosingReasons[]=opc.trim().toString().split(":");
																		choosingReason=choosingReasons[1].trim().toString();
																		System.out.println("choosingReason "+choosingReason);
																	}

																	if(opc.contains("Switching"))
																	{
																		String switchingReasons[]=opc.trim().toString().split(":");
																		switchingReason=switchingReasons[1].trim().toString();
																		System.out.println("switchingReason "+switchingReason);
																	}



																}
															}
														} catch (Exception ex) {
															ex.printStackTrace();
														}
													}
												}
											}
										} catch (Exception ex) {
											ex.printStackTrace();
										}
									}
								}

								Elements nameElements5 = element.getElementsByClass("ReviewCard__DesktopOnlyDiv-sc-18j15p9-6 gckeCD");
								if (nameElements5 != null && nameElements5.size() > 0) {
									for (Element nameElement : nameElements5) {
										//Thread.sleep(1000);
										try {
											if (nameElement.hasAttr("class") && nameElement.attr("class").equals("ReviewCard__DesktopOnlyDiv-sc-18j15p9-6 gckeCD")) {				
												writtenOn=nameElement.getElementsByClass("ReviewSource__Root-lnjke6-0 iBAGLQ").text().replace("Reviewer Source Source: Capterra", "").trim();

												System.out.println("writtenOn          "+writtenOn);	
												System.out.println("=========================================================================");
											}
										} catch (Exception ex) {
											ex.printStackTrace();
										}
									}
								}
							}

						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}}
	public static String removeSpecialCharacters(String inputString) {
		return inputString.replaceAll("[^a-zA-Z0-9\\s\\(\\)]", "");
	}
}

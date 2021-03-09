package com.aldrich.dateconversions;

import java.io.File;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class LinkedDecisionScript {

	public static void main(String[] args) {

		Document doc = null;
		String Name = null;
		String Person_Linkedin = null;
		String Title = null;
		String Degree_Conn = null;
		String Duration = null;
		String Location = null;

		String Pase_id = null;
		String State = null;
		String city = null;
		String Country = null;
		String image = null;
		int count = 1;
		try {
			File folder = new File("C:\\Omprakash\\employee_info_week_10_s1");
			File[] listOfFiles = folder.listFiles();
			for (File file: listOfFiles) {
				if (file.isFile()) {
					Pase_id = file.getName().replace(".html", "");
					String[] arrOfStr1 = Pase_id.split("_");
					String[] arrOfStr2 = Pase_id.split("-");

					doc = Jsoup.parse(new File("C:\\Omprakash\\employee_info_week_10_s1\\" + file.getName()), "utf-8");
					System.out.println("-----------------------------------------------------------------------");
					System.out.println(count + ". " + file);
					System.out.println("-----------------------------------------------------------------------");

					count = count + 1;
					if (doc != null && count > 0) {

						Elements div_element = doc.select("article");
						for (Element element: div_element) {
							try {
								if (element.children().size() > 0) {
									Degree_Conn = "";

									Duration = "";
									image = "";
									image = "";

									for (int i = 0; i < element.children().size(); i++) {
										try {

											if (element.child(i).attr("class").equals("result-lockup")) {
												Element sectionElement = element.child(i).attr("class", "result-lockup");
												if (sectionElement.children().size() > 0) {
													for (int j = 0; j < sectionElement.children().size(); j++) {
														try {
															if (sectionElement.child(j).attr("class").equals("result-lockup__profile-info flex flex-column")) {
																Element resultElement = sectionElement.child(j).attr("class", "result-lockup__profile-info flex flex-column");
																if (resultElement.children().size() > 0) {
																	for (int a = 0; a < resultElement.children().size(); a++) {
																		if (resultElement.child(a).attr("class").equals("horizontal-person-entity-lockup-4 result-lockup__entity ml6")) {
																			Element childElement = resultElement.child(a).attr("class", "horizontal-person-entity-lockup-4 result-lockup__entity ml6");
																			if (childElement.children().size() > 0) {
																				for (int k = 0; k < childElement.children().size(); k++) {
																					try {
																						if (childElement.child(k).getElementsByTag("figure") != null) {
																							image=processToGerPersonName(childElement, k);
																							if(image!=null)
																							{
																								System.out.println(image);
																							}

																						}
																						if (childElement.child(k).getElementsByTag("dl") != null) {
																							Elements dlelement = childElement.child(k).select("dl");
																							if (dlelement != null && dlelement.size() > 0) {
																								for (Element element1: dlelement) {
																									try {

																										if (element1.children().size() > 0) {
																											for (int l = 0; l < element1.children().size(); l++) {
																												try {
																													Element element2 = element1.child(l);
																													if (element2.hasAttr("class") && element2.attr("class").equals("result-lockup__name")) {
																														Element classElement = element2.attr("class", "result-lockup__name");
																														Name = classElement.children().text().toString().trim();


																														Person_Linkedin = classElement.children().attr("href");
																													}

																													Degree_Conn=getDegreeConnection(element2);
																													if(Degree_Conn!=null){
																														System.out.println(Degree_Conn);
																													}

																													Title=getPeronTitile(element2);
																													if(Title!=null){
																														System.out.println(Title);
																													}
																													
																												} catch(Exception e) {
																													e.printStackTrace();
																												}
																											}
																										}
																										city = "";

																										State = "";

																										Elements e2 = element1.children().tagName("dd");
																										for (Element element4: e2) {
																											try {
																												if (element4.children().hasAttr("class") && element4.children().attr("class").contains("mv1 t-12 t-black--light result-lockup__misc-list")) {
																													Elements sElement = element4.children().attr("class", "mv1 t-12 t-black--light result-lockup__misc-list");
																													Location = sElement.text().toString().trim();
																													System.out.println(Location);

																													String[] arrOfStr = Location.split(", ");

																													if (arrOfStr.length == 3) {
																														if (!arrOfStr[0].equals("")) {
																															city = arrOfStr[0].trim();

																															System.out.println(city);
																														}
																														if (!arrOfStr[1].equals("")) {
																															State = arrOfStr[1].trim();

																															System.out.println(State);
																														}
																														if (!arrOfStr[2].equals("")) {
																															Country = arrOfStr[2].trim();

																															System.out.println(Country);
																														}
																													} else {
																														if (!arrOfStr[0].equals("")) {
																															Country = arrOfStr[0].trim();

																															System.out.println(Country);
																														}
																													}

																												}
																											} catch(Exception e) {
																												e.printStackTrace();
																											}
																										}

																										Duration=processToGetWorkDuration(element1);
																										if(Duration!=null){
																											System.out.println(Duration);
																										}

																										System.out.println("-------------------------");

																									} catch(Exception e) {
																										e.printStackTrace();
																									}
																								}
																							}
																						}
																					} catch(Exception e) {
																						e.printStackTrace();
																					}
																				}
																			}
																		}

																	}
																}

															}
														} catch(Exception e) {
															e.printStackTrace();
														}
													}
												}									
											}

										} catch(Exception e) {
											e.printStackTrace();
										}
									}

								}

							} catch(Exception e) {
								e.printStackTrace();
							}

						}
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

	public static String getDegreeConnection(Element element2) {
		String Degree_Conn=null;
		try{
			if (element2.hasAttr("class") && element2.attr("class").equals("inline-flex vertical-align-middle")) {
				Element classElement1 = element2.attr("class", "inline-flex vertical-align-middle");
				if (classElement1.children().size() > 0) {
					for (int z = 0; z < classElement1.children().size(); z++) {
						Elements e = classElement1.children().attr("class", "ml1 flex align-items-center list-style-none");
						for (Element element3: e) {
							if (element3.children().size() > 0) {
								for (int m = 0; m < element3.children().size(); m++) {
									try {
										if (element3.child(m).attr("class").equals("mr1")) {
											Element eElement = element3.child(m).attr("class", "mr1");
											if (eElement.children().size() > 0) {
												for (int n = 0; n < eElement.children().size(); n++) {
													try {

														if (eElement.child(n).attr("class").equals("a11y-text")) {
															Element spanElement = eElement.child(n).attr("class", "a11y-text");
															Degree_Conn = spanElement.text().toString().trim();

														}
													} catch(Exception e2) {
														e2.printStackTrace();
													}
												}
											}

										}
									} catch(Exception e2) {
										e2.printStackTrace();
									}
								}
							}
						}
					}
				}
			}
		} catch(Exception e2) {
			e2.printStackTrace();
		}
		return Degree_Conn;

	}

	public static String processToGerPersonName(Element childElement, int k) {
		String image=null;
		try{
			Elements figureElement = childElement.child(k).select("figure");
			if (figureElement != null && figureElement.size() > 0) {
				for (Element fElement: figureElement) {
					try {
						if (fElement.children().size() > 0) {
							for (int l = 0; l < fElement.children().size(); l++) {
								try {
									if (fElement.child(l).attr("class").equals("result-lockup__icon-link ember-view")) {
										Element aElement = fElement.child(l).attr("class", "result-lockup__icon-link ember-view");
										if (aElement.children().size() > 0) {
											for (int m = 0; m < aElement.children().size(); m++) {
												try {
													if (aElement.child(m).attr("class").equals("presence-entity--size-4 relative mr2")) {
														Element div_element1 = aElement.child(m).attr("class", "presence-entity--size-4 relative mr2");
														if (div_element1.children().size() > 0) {
															for (int n = 0; n < div_element1.children().size(); n++) {
																try {
																	if (div_element1.child(n).attr("class").equals("max-width max-height circle-entity-4 lazy-image loaded ember-view")) {
																		image = div_element1.child(n).attr("src");
																	}
																	if (div_element1.child(n).attr("class").equals("lazy-image max-width max-height circle-entity-4 ghost-person loaded")) {
																		image = div_element1.child(n).attr("src").trim();
																	}
																} catch(Exception e) {

																}
															}
														}
													}
												} catch(Exception e) {

												}
											}
										}
									}
								} catch(Exception e) {

								}
							}
						}
					} catch(Exception e) {

					}
				}
			}
		} catch(Exception e) {

		}
		return image;
	}

	public static String getPeronTitile(Element element2) {
		String Title=null;
		try{
			if (element2.hasAttr("class") && element2.attr("class").equals("result-lockup__highlight-keyword")) {
				Element classElement2 = element2.attr("class", "result-lockup__highlight-keyword");
				if (classElement2.children().hasAttr("class") && classElement2.children().attr("class").equals("t-14 t-bold")) {
					Element tElement = classElement2.child(0).attr("class", "t-14 t-bold");
					Title = tElement.text().toString().trim();
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return Title;

	}

	public static String processToGetWorkDuration(Element element1) {
		String Duration=null;
		try{
			Elements e3 = element1.children().tagName("dd");
			for (Element element3: e3) {
				try {
					Duration=getWorkDurationAnotherWay(element3);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}

			Elements e5 = element1.children().tagName("dd");
			for (Element element3: e5) {
				try {
					Duration = getWorkDuration(element3);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return Duration;
	}

	public static String getWorkDurationAnotherWay(Element element3) {
		String Duration=null;
		try {

			if (element3.children().hasAttr("class") && element3.children().attr("class").equals("t-12 t-black--light")) {
				Elements spanElement = element3.children().attr("class", "t-12 t-black--light");
				Duration = spanElement.text().toString().trim().replace(" in role and company", "");

				System.out.println(Duration);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return Duration;
	}

	public static String getWorkDuration(Element element3) {

		String Duration =null;
		try {
			if (element3.children().hasAttr("class") && element3.children().attr("class").equals("result-lockup__tenure t-12 t-black--light")) {
				Element spanElement = element3.child(0).attr("class", "result-lockup__tenure t-12 t-black--light");
				Duration = spanElement.text().toString().trim();

				Element spanElement1 = element3.child(1).attr("class", "result-lockup__tenure t-12 t-black--light");
				Duration = spanElement1.text().toString().trim().replace("in company", "");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return Duration;
	}
}

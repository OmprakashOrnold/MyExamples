package com.aldrich.softwaresuggest;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SoftwareSuggestDemoSimilar {

	public static void main(String[] args) {
		Document document = null;
		String  productName=null;
		List<String> lagList=new ArrayList<String>();
		try {
			File fullFileName = new File("C://OM//softwaresugggestproducts//zoho-recruit.html");
			document = Jsoup.parse(fullFileName, "UTF-8");
			
			Elements div_elements = document.select("div");
			if (div_elements != null && div_elements.size() > 0) {
				for (Element element : div_elements) {
					try {

				
						if (element.hasAttr("class") && element.attr("class").equals("prof_page_section")&&element.hasAttr("id") && element.attr("id").equals("alternatives") ) {
							Elements specificationSections = element.getElementsByClass("row section_main");
							if (specificationSections != null && specificationSections.size() > 0) {
								for (Element specificationSection : specificationSections) {	
									try {
										Elements rowSections = specificationSection.getElementsByClass("col-12");
										if (rowSections != null && rowSections.size() > 0) {
											for (Element rowSection : rowSections) {	
												try {
													Elements rowSectionMains = rowSection.getElementsByClass("row");
													if (rowSectionMains != null && rowSectionMains.size() > 0) {
														for (Element rowSectionMain : rowSectionMains) {	
															try {
																Elements row = rowSectionMain.getElementsByClass("row");
																if (row != null && row.size() > 0) {
																	for (Element rows : row) {	
																		try {																			
																			Elements listsoftProfs = rows.getElementsByClass("ga_track_soft_list soft_list_prof");
																			if (listsoftProfs != null && listsoftProfs.size() > 0) {
																				for (Element listsoftProf : listsoftProfs) {	
																					try {
																						Elements softNames = listsoftProf.getElementsByClass("d-flex flex-column soft_mname_main");
																						if (softNames != null && softNames.size() > 0) {
																							for (Element softName : softNames) {	
																								try {
																									
																									System.out
																											.println(softName.getElementsByTag("a").text());
																									
																									Response response1 = Jsoup.connect(softName.getElementsByTag("a").attr("href")).execute();
																									System.out.println(response1.url());
																									System.out
																									.println(softName.getElementsByTag("span").text());
																									
																								} catch (Exception ex) {
																									ex.printStackTrace();
																								}
																							}
																						}
																						
																						
																						Elements rateButtons = listsoftProf.getElementsByClass("rate_btn_top_soft");
																						if (rateButtons != null && rateButtons.size() > 0) {
																							for (Element rateButton : rateButtons) {	
																								try {
																									//d-flex align-items-center star_rate_icon
																									Elements starRateIcons = listsoftProf.getElementsByClass("d-flex align-items-center star_rate_icon");
																									if (starRateIcons != null && starRateIcons.size() > 0) {
																										for (Element starRateIcon : starRateIcons) {	
																											try {
																												String ratingsd[]=starRateIcon.text().split(" ");
																												System.out.println( ratingsd[0]);
																												System.out.println( ratingsd[1].replace("(", "").trim());
																												
																											} catch (Exception ex) {
																												ex.printStackTrace();
																											}
																										}
																									}
																									
																								} catch (Exception ex) {
																									ex.printStackTrace();
																								}
																							}
																						}
																						
																						
																					} catch (Exception ex) {
																						ex.printStackTrace();
																					}
																				}
																			}
																			
																			
																		} catch (Exception ex) {
																			ex.printStackTrace();
																		}
																	}
																}
																
																
															} catch (Exception ex) {
																ex.printStackTrace();
															}
														}
													}
												} catch (Exception ex) {
													ex.printStackTrace();
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
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}	

}

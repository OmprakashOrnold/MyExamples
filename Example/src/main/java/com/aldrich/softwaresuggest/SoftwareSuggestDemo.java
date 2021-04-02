package com.aldrich.softwaresuggest;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SoftwareSuggestDemo {

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
						if (element.hasAttr("class") && element.attr("class").equals("prof_page_section")&&element.hasAttr("id") && element.attr("id").equals("customers") ) {
							Elements specificationSections = element.getElementsByClass("row section_main");
							if (specificationSections != null && specificationSections.size() > 0) {
								for (Element specificationSection : specificationSections) {	
									try {
										Elements rowSections = specificationSection.getElementsByClass("col-12");
										if (rowSections != null && rowSections.size() > 0) {
											for (Element rowSection : rowSections) {	
												try {
													Elements rowSectionMains = rowSection.getElementsByClass("section_bg_prof");
													if (rowSectionMains != null && rowSectionMains.size() > 0) {
														for (Element rowSectionMain : rowSectionMains) {	
															try {
																Elements rows = rowSectionMain.getElementsByClass("row");
																if (rows != null && rows.size() > 0) {
																	for (Element row : rows) {	
																		try {
																			//System.out.println(row);
																			Elements colzss = row.getElementsByClass("col-xs-12 col-sm-6 col-xl-3 customer_logo_main ");
																			if (colzss != null && colzss.size() > 0) {
																				for (Element colzs : colzss) {	
																					try {
																						
																				     Elements logosElmentss = colzs.getElementsByClass("d-flex align-items-center justify-content-center customer_logo_img_main");
																					  if (logosElmentss != null && logosElmentss.size() > 0) {
																						for (Element logosElments : logosElmentss) {	
																							try {
																								System.out.println(logosElments.getElementsByTag("img").attr("data-src"));
																								
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



package com.aldrich.softwaresuggest;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SoftwareSuggestDemo1 {

	public static void main(String[] args) {
		Document document = null;
		String	fullName	 =null;
		String	companSize	 =null;
		Long	overallRating	 =null;
		Long	featureRating	 =null;
		Long	easeOfUseRating	 =null;
		Long	valueForMoneyRating	 =null;
		Long	customerSupportRating	 =null;
		String	reviewDate	 =null;
		String	title	 =null;
		String	description	 =null;
		String	pros	 =null;
		String	cons	 =null;


		try {
			File fullFileName = new File("C:/OM/softwaresugggestproducts/1FILE/1access.html");
			document = Jsoup.parse(fullFileName, "UTF-8");

			Elements div_elements = document.select("div");
			if (div_elements != null && div_elements.size() > 0) {
				for (Element element : div_elements) {
					try {
						//description
						if (element.hasAttr("class") && element.attr("class").equals("prof_page_section")&&element.hasAttr("id") && element.attr("id").equals("description") ) {
							Elements specificationSections = element.getElementsByClass("row section_main");
							if (specificationSections != null && specificationSections.size() > 0) {
								for (Element specificationSection : specificationSections) {	
									try {
										Elements rowSections = specificationSection.getElementsByClass("col-12");
										if (rowSections != null && rowSections.size() > 0) {
											for (Element rowSection : rowSections) {	
												try {
													Elements rowSectionMains = rowSection.getElementsByClass("software_discription section_bg_prof");
													if (rowSectionMains != null && rowSectionMains.size() > 0) {
														for (Element rowSectionMain : rowSectionMains) {	
															try {
																
																Elements rows = rowSectionMain.getElementsByClass("disc_only");
																if (rows != null && rows.size() > 0) {
																	for (Element row : rows) {	
																		try {
																			description=row.getElementsByTag("p").text();
																			System.out.println(description);
																		} catch (Exception ex) {
																			ex.printStackTrace();
																		}
																	}
																}
																
																Elements extraDiscs = rowSectionMain.getElementsByClass("custom_tab_panel active_tab_panel");
																if (extraDiscs != null && extraDiscs.size() > 0) {
																	for (Element extraDisc : extraDiscs) {	
																		try {
																			
																			System.out.println(extraDisc.text());
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
						}} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}	
}


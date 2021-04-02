package com.aldrich.linkdin.peoplestates;

import java.io.File;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class PeopleStats {

	public static void main(String[] args) {


		File folder = new File("C:\\people_18.02\\");
		File[] listOfFiles = folder.listFiles();

		for (File file : listOfFiles) {
			if (file.isFile()) {
			//	System.out.println(file.getName().replace(".html",""));
				File fullFileName = new File("C:\\people_18.02\\"+file.getName());
				processResponse(fullFileName);
			}
		}
	}

	public static void processResponse(File fullFileName) {

		Document document=null;
		String employeecount = null;
		try{		
			document = Jsoup.parse(fullFileName, "UTF-8");
			employeecount=getEmployeeCount(document);
			getNameValueTyoe(document,employeecount);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void getNameValueTyoe(Document document,String employeecount) {
		String name = "";
		String value = "";
		String type ="";
		System.out.println("******************************************************************************");
		Elements div_elements = document.select("div");
		if (div_elements != null && div_elements.size() > 0) {
			for (Element element : div_elements) {
				try {
					if (element.hasAttr("class") && element.attr("class").equals("insight-container")) {
						if (element.childNodes().size() > 0) {
							for (int count = 0; count < element.childNodes().size(); count++) {
								try {
									type=getType(element, count);
									System.out.println(type);
									if (element.child(count).hasAttr("class")
											&& element.child(count).attr("class").equals(
													"org-people-bar-graph-element mt4 org-people-bar-graph-element--is-selectable ")) {
										if (element.child(count).childNodes().size() > 0) {
											Element inner = element.child(count).child(0);
											if (inner.nodeName().equals("div") && inner.hasAttr("class")
													&& inner.attr("class").equals(
															"org-people-bar-graph-element__percentage-bar-info truncate full-width mt2 mb1 t-14 t-black--light t-normal")) {
												
												if (inner.childNodes().size() > 0) {
													for (int innercount = 0; innercount < inner.childNodes()
															.size(); innercount++) {
														try {
															if (inner.child(innercount).text() != null) {
																if (inner.child(innercount).nodeName()
																		.equals("strong")) {
																	value = inner.child(innercount).text();
																}
																if (inner.child(innercount).nodeName()
																		.equals("span")) {
																	name = inner.child(innercount).text();
																}
															}
														} catch (Exception e) {
															// e.printStackTrace();
														}
													}
												}
											}
										
											System.out.println(value);
											System.out.println(name);
											System.out.println(type);
											System.out.println(employeecount);
											
										}
									}	
								} catch (Exception ex) {
									//ex.printStackTrace();
								}
							}
						}
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}	
		System.out.println("******************************************************************************");
	}

	public static String getType(Element element, int count) {
		String type="";
		if (element.child(count).hasAttr("class") && element.child(count)
				.attr("class").equals("insight-container__title")) {
			type = element.child(count).text().replace("Add", "").trim();
		}
		return type;
	}


	public static String  getEmployeeCount(Document document) {
		String employeecount="";
		Elements span_elements = document.select("span");
		if (span_elements != null && span_elements.size() > 0) {
			for (Element element : span_elements) {
				try {
					if (element.hasAttr("class") && element.attr("class").equals("t-20 t-black t-bold")) {
						employeecount = element.text().replace("employees", "").replace(",", "")
								.replace("employee", "").replace(" alumni", "").trim();
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
		return employeecount;
	}
}

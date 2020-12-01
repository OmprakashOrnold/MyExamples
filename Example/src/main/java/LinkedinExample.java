import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class LinkedinExample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Document document = null;
		String employeecount = null;
		String name = null;
		String value = null;
		String type = null;

		File fullFileName = new File("C:\\Users\\oppeddamadthala\\Downloads\\pase6.1\\pase6.1\\257453.html");
		// read the content from file
		document = Jsoup.parse(fullFileName, "UTF-8");
		// get the employee count
		Elements span_elements = document.select("span");
		if (span_elements != null && span_elements.size() > 0) {
			for (Element element : span_elements) {
				try {
					if (element.hasAttr("class") && element.attr("class").equals("t-20 t-black")) {
						employeecount = element.text().replace("employees", "").replace(",", "").trim();
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
		// get other details
		Elements div_elements = document.select("div");
		if (div_elements != null && div_elements.size() > 0) {
			for (Element element : div_elements) {
				try {
					if (element.hasAttr("class") && element.attr("class").equals("insight-container")) {
						if (element.childNodes().size() > 0) {
							for (int count = 0; count < element.childNodes().size(); count++) {
								try {
									if (element.child(count).hasAttr("class")
											&& element.child(count).attr("class").equals("insight-container__title")) {
										type = element.child(count).text().replace("Add", "").trim();
									}
									if (element.child(count).hasAttr("class") && element.child(count).attr("class")
											.equals("org-people-bar-graph-element mt4 org-people-bar-graph-element--is-selectable ember-view")) {
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
																if (inner.child(innercount).nodeName().equals("span")) {
																	name = inner.child(innercount).text();
																}
															}
														} catch (Exception e) {
															//e.printStackTrace();
														}
													}
												}
											}
											System.out.println("--------------------------------------------");
											System.out.println("emp count: " + employeecount);
											System.out.println("name: " + name);
											System.out.println("value: " + value);
											System.out.println("type:" + type);
											System.out.println("--------------------------------------------");
										}
									}
								} catch (Exception ex) {
									//ex.printStackTrace();
								}
							}
						}
					}
				} catch (Exception ex) {
					//ex.printStackTrace();
				}
			}
		}

	}

}

package com.aldrich.linkedin.products;

import java.io.File;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class LinkedinProducts {

	public static void main(String[] args) {

		File folder = new File("C:\\jobs_linkedin\\products");
		File[] listOfFiles = folder.listFiles();

		for (File file : listOfFiles) {
			if (file.isFile()) {
			//	System.out.println(file.getName().replace(".html",""));
				File fullFileName = new File("C:\\jobs_linkedin\\products\\"+file.getName());

				processResponse(fullFileName);

			//	System.out.println("******************************************************************************");
			}
		}

	}
	

	public static void processResponse(File fullFileName) {

		Document document=null;
		// read the content from file
		try {
			document = Jsoup.parse(fullFileName, "UTF-8");
			// main
			Elements section_elements = document.select("div");
			if (section_elements != null && section_elements.size() > 0) {
				for (Element element: section_elements) {
					try {
						if (element.attr("class").equals("artdeco-card p4 mb4")) {
							
							String title=getTitle(element);
							String category=getProductTyoe(element);
							String product_link=getProductLink(element);
							String product_logo=getProductLogoUrl(element);
							String description=getDescription(element);
							
							System.out.println(title);
							System.out.println(category);
							System.out.println(product_link);
							System.out.println(product_logo);
							System.out.println(description);
							System.out.println();
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


	public static String getProductLink(Element element) {
		String product_link="";
		Elements a_element = element.select("a");
		if (a_element != null && a_element.size() > 0) {
			for (Element a_elements: a_element) {
				try {
					if (a_elements.attr("class").equals("ember-view link-without-hover-visited")) {
						product_link="https://www.linkedin.com"+a_elements.attr("href");
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
		return product_link;
	}
	
	public static String getProductLogoUrl(Element element) {
		String product_logo="";
		Elements a_element = element.select("a");
		if (a_element != null && a_element.size() > 0) {
			for (Element a_elements: a_element) {
				try {
					if (a_elements.attr("class").equals("ember-view link-without-hover-visited")) {
						product_logo=a_elements.getElementsByTag("img").attr("src");
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
		return product_logo;
	}


	public static String getDescription(Element element) {
		String description="";
		
		Elements p_element = element.select("p");
		if (p_element != null && p_element.size() > 0) {
			for (Element p_elements: p_element) {
				try {
					if (p_elements.attr("class").equals("org-product-card__description t-14 t-black--light mt3")) {
						description=p_elements.text();
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
		return description;
	}


	public static String getProductTyoe(Element element) {
		String category=null;
		Elements span_element = element.select("div");
		if (span_element != null && span_element.size() > 0) {
			for (Element span_elements: span_element) {
				try {
					if (span_elements.attr("class").equals("artdeco-entity-lockup__caption ember-view mt1 truncate")) {
						category=span_elements.text();
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
		return category;
	}


	public static String getTitle(Element element) {
		String title="";
			
		Elements h3_element = element.select("h3");
		if (h3_element != null && h3_element.size() > 0) {
			for (Element h3_elements: h3_element) {
				try {
					if (h3_elements.attr("class").equals("t-20 t-bold truncate")) {
						title=h3_elements.text();
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
		return title;
	}

}

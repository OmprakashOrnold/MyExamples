package com.aldrich.om;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ExtractCategoryLinks {

	public static void main(String[] args) {

		String catLink=null;

		String request = "https://www.trustradius.com/categories";
		try {

			Elements categoryLinks= getDocument(request).getElementsByClass("btn btn-link");
			for (Element element : categoryLinks) {
				//System.out.println(element.attr("abs:href"));
				Elements innerCategoryLinks=getDocument(element.attr("abs:href")).getElementsByClass("section-block__body");
				if (innerCategoryLinks != null && innerCategoryLinks.size() > 0) {
					for (Element innerCategoryLink : innerCategoryLinks) {	
						try {
							Elements listOfLinks=innerCategoryLink.getElementsByClass("link-list-columns");
							if (listOfLinks != null && listOfLinks.size() > 0) {
								for (Element listOfLink : listOfLinks) {	
									try {
										Elements liTagss=listOfLink.getElementsByTag("li");
										if (liTagss != null && liTagss.size() > 0) {
											for (Element liTags : liTagss) {	
												try {	
													catLink=liTags.getElementsByTag("a").attr("abs:href").replace("#products", "");
													Elements ele= getDocument(catLink).getElementsByClass("CategoryProducts_category-product-heading__1tKlO");
													//System.out.println(ele.first().getElementsByTag("p").text().replace("Sorted by Most Reviews", ""));
													String numberArray[]=ele.first().getElementsByTag("p").text().replace("Sorted by Most Reviews", "").split("of");
													//System.out.println(numberArray[1]);

													for (int i = 0; i < Integer.parseInt(numberArray[1].trim().replace(")", "")); i=i+25) {

														
														catLink=liTags.getElementsByTag("a").attr("abs:href").replace("#products", "")+"?f="+i;
														try (FileWriter writer = new FileWriter(
																"C:\\Om\\catlinks.txt", true);
																BufferedWriter bw = new BufferedWriter(writer)) {				
															bw.write(catLink);
															bw.write("\n");

														} catch (IOException ex) {
															System.err.format("IOException: %s%n", ex);
														}

									/*					try{

															Elements ele2= getDocument(catLink).getElementsByClass("CategoryProduct_cta__23Lgj");

															

															if (ele2 != null && ele2.size() > 0) {
																for (Element element12 : ele2) {
																	try {

																		System.out.println(element12.getElementsByTag("a").attr("abs:href").replace("?utm_campaign=TrustRadius%20Review&utm_source=trustradius.com&utm_medium=click", ""));
																	
																		try (FileWriter writer = new FileWriter(
																				"C:\\Om\\trlinks.txt", true);
																				BufferedWriter bw = new BufferedWriter(writer)) {				
																			bw.write(element12.getElementsByTag("a").attr("abs:href").replace("?utm_campaign=TrustRadius%20Review&utm_source=trustradius.com&utm_medium=click", ""));
																			bw.write("\n");

																		} catch (IOException ex) {
																			System.err.format("IOException: %s%n", ex);
																		}

																	} catch (Exception e) {
																		e.printStackTrace();
																	}
																}
															}
															

				

														} catch (Exception e) {
															e.printStackTrace();
														}*/
													}
												} catch (Exception e) {
													e.printStackTrace();
												}
											}
										}


									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Document getDocument(String url)
	{
		Document documnet=null;
		try {
			documnet=Jsoup.connect(url)
					.userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:79.0) Gecko/20100101 Firefox/79.0")
					.ignoreHttpErrors(true).get();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return documnet;	
	}


}

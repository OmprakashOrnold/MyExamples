package com.aldrich.softwaresuggest;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SoftwareSuggest {

	public static void main(String[] args) {

		//accordion_tab-content

		Document doc =null;
		String request="https://www.softwaresuggest.com";
		try {
			doc=Jsoup.connect(request)
					.timeout(5000).ignoreHttpErrors(true).get();

			Elements div_elements = doc.select("div");
			if (div_elements != null && div_elements.size() > 0) {
				for (Element element : div_elements) {
					try {
						if (element.hasAttr("class") && element.attr("class").equals("mdl-cell mdl-cell--6-col mdl-cell--8-col-tablet")) {

							Elements ulTags	=element.getElementsByTag("ul");
							if (ulTags != null && ulTags.size() > 0) {
								for (Element ulTag : ulTags) {
									try {		
										Elements catLinks	=ulTag.getElementsByClass("accordion_tab-content");
										if (catLinks != null && catLinks.size() > 0) {
											for (Element catLink : catLinks) {
												try {

													System.out.println(catLink.getElementsByTag("a").attr("href"));
													try (FileWriter writer = new FileWriter(
															"C:\\Om\\softwaresuggestcategorylinks.txt", true);
															BufferedWriter bw = new BufferedWriter(writer)) {				
													    bw.write(catLink.getElementsByTag("a").attr("href"));
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
									}
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


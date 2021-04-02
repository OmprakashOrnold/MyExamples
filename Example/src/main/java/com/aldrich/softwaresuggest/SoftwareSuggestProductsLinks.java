package com.aldrich.softwaresuggest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SoftwareSuggestProductsLinks {

	public static void main(String[] args) {
		Document document = null;
		try {
			File folder = new File("C://OM//softwaresuggest");
			File[] listOfFiles = folder.listFiles();
			for (File file : listOfFiles) {
				if (file.isFile()) {
					try {
						File fullFileName = new File("C:/OM/softwaresuggest/"+file.getName());
						document = Jsoup.parse(fullFileName, "UTF-8");

						Elements productlinks=document.select("a[class='ga_track_soft_profile d-flex align-items-center ft_pro_comp_link view_profile_inline']");
						if (productlinks != null && productlinks.size() > 0) {
							for (Element element : productlinks) {
								try {
									System.out.println(element.attr("href"));
									try (FileWriter writer = new FileWriter(
											"C:\\Om\\softwaresuggestproductlinks.txt", true);
											BufferedWriter bw = new BufferedWriter(writer)) {				
									    bw.write(element.attr("href"));
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
	} catch (Exception e) {
		e.printStackTrace();
	}
  }
}

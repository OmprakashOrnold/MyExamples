package com.aldrich.om;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class LinkdinEmployeeNames {

	public static void main(String[] args) {
		
		Document doc=null;
		try {
			File folder = new File("C:\\Om\\urget");
			File[] listOfFiles = folder.listFiles();
			for (File file : listOfFiles) {
				if (file.isFile()) {
				
					doc=Jsoup.parse(new File("C:\\Om\\urget\\"+file.getName())
							, "utf-8");
					if(doc!=null) {
					    String  []paseID=file.getName().replace(".html", "").trim().split("-");
						
						Elements elements=doc.select("dt[class='result-lockup__name']");
						for (Element element : elements) {
							//System.out.println(element.getElementsByTag("a").text());
							//System.out.println("https://linkedin.com/"+element.getElementsByTag("a").attr("href"));
							System.out.println(paseID[0]);
							try (FileWriter writer = new FileWriter(
									"C:\\Om\\urget names.txt", true);
									BufferedWriter bw = new BufferedWriter(writer)) {				
							    bw.write(element.getElementsByTag("a").text());
								bw.write("\n");
								
							} catch (IOException ex) {
								System.err.format("IOException: %s%n", ex);
							}
							Elements companyNames=doc.select("a[class='Sans-16px-black-60%-bold-open ember-view']");
							for (Element elem00ent : companyNames) {
							//System.out.println(elem00ent.text());
								try (FileWriter writer = new FileWriter(
										"C:\\Om\\urget company.txt", true);
										BufferedWriter bw = new BufferedWriter(writer)) {				
								   // bw.write(elem00ent.text());
									//bw.write("\n");
									
								} catch (IOException ex) {
									System.err.format("IOException: %s%n", ex);
								}
							}					
						}
					}
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}

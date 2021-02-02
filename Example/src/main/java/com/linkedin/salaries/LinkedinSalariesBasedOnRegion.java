package com.linkedin.salaries;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.csvreader.CsvWriter;


/*<!-- https://mvnrepository.com/artifact/net.sourceforge.javacsv/javacsv -->
	<dependency>
		<groupId>net.sourceforge.javacsv</groupId>
		<artifactId>javacsv</artifactId>
		<version>2.0</version>
	</dependency>*/


public class LinkedinSalariesBasedOnRegion {

	public static void main(String[] args) {

		Document document = null;

		File folder = new File("C:\\OmPrakash\\Linkedin salary based on location");
		File[] listOfFiles = folder.listFiles();
		for (File file : listOfFiles) {
			if (file.isFile()) 
			{
				String fullFileName="C:\\OmPrakash\\Linkedin salary based on location\\"+file.getName();

				try {
					document = Jsoup.parse(new File(fullFileName), "UTF-8");


					Elements elements = document.select("div[class=content-wrapper]");
					if (elements!=null && elements.size()>0) {
						for (Element element : elements) {
							String designationTitle=null;
							String location=null;
							String min=null;
							String max=null;
							String median=null;

							Elements designationTitleElement = element.getElementsByClass("title");
							if (designationTitleElement != null && designationTitleElement.size() > 0) {	

								designationTitle=designationTitleElement.attr("title").trim();	
							}

							Elements locationElement = element.getElementsByClass("location");
							if (locationElement != null && locationElement.size() > 0) {

								location=locationElement.text().toString().trim();						
							}

							Elements compensationElement = element.getElementsByClass("compensation");
							if (compensationElement != null && compensationElement.size() > 0) {

								median=compensationElement.text().toString().trim();						
							}

							Elements rangeElement = element.getElementsByClass("range");
							if (rangeElement != null && rangeElement.size() > 0) {

								String minmaxarray[]=rangeElement.text().toString().trim().split("-");
								min=minmaxarray[0].toString().trim().replace("Range: ", "");
								max=minmaxarray[1].toString().trim().replace("Range: ", "");
							}

							System.out.println(designationTitle);
							System.out.println(location);
							System.out.println(median);
							System.out.println(min);
							System.out.println(max);

							System.out.println();
							
							 
							 String outputFile = "C:\\Om\\linkedin_salary_by_location.csv";
								
							// before we open the file check to see if it already exists
								boolean alreadyExists = new File(outputFile).exists();
								
								try {
									// use FileWriter constructor that specifies open for appending
									CsvWriter csvOutput = new CsvWriter(new FileWriter(outputFile, true), ',');
									
									// if the file didn't already exist then we need to write out the header line
									if (!alreadyExists)
									{
										csvOutput.write("designation");
										csvOutput.write("location");
										csvOutput.write("median");
										csvOutput.write("min");
										csvOutput.write("max");
										csvOutput.endRecord();
									}
						
									csvOutput.write(designationTitle);
									csvOutput.write(location);
									csvOutput.write(median);
									csvOutput.write(min);
									csvOutput.write(max);
									csvOutput.endRecord();
									
									
									csvOutput.close();
								} catch (IOException e) {
									e.printStackTrace();
								}
						}

					}

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
}

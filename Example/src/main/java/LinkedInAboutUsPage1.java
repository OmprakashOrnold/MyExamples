import java.io.File;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.csvreader.CsvWriter;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class LinkedInAboutUsPage1 {

	public static void main(String[] args) throws IOException {
		Document document = null;
		String industry=null;
		String companySize=null;
		String headCount=null;
		String typeCompany=null;
		File folder = new File("C:\\OmPrakash\\LinkedinCompanies");
		File[] listOfFiles = folder.listFiles();
		for (File file : listOfFiles) {
			if (file.isFile()) 
			{

				File fullFileName = new File("C:\\OmPrakash\\LinkedinCompanies\\"+file.getName());
				// read the content from file
				document = Jsoup.parse(fullFileName, "UTF-8");

				Elements elementsU=document.getElementsByClass("org-page-details__definition-term t-14 t-black t-bold");

				for (Element element : elementsU) {
					if(element.text().equals("Industry"))
					{
						industry=element.nextElementSibling().text();
						//System.out.println(element.nextElementSibling().text());
					}
				}

				Elements code_elements = document.select("code");
				if (code_elements != null && code_elements.size() > 0) {
					for (Element element : code_elements) {
						try {
							if (element.hasAttr("style") && element.hasAttr("id")) {
								if (element.attr("style").equals("display: none")
										&& element.attr("id").startsWith("bpr-guid-")) {
									String pageContent = element.text();
									if (pageContent != null && pageContent != "" && pageContent.contains("included")
											&& pageContent.contains("companyPageUrl")) {
										JSONObject jsonObject = new JSONObject(pageContent);
										JSONArray includeArray = jsonObject.getJSONArray("included");
										int arraySize = includeArray.length();
										if (arraySize > 0) {
											for (int arrayIndex = 0; arrayIndex < arraySize; arrayIndex++) {
												try {
											
													companySize="";							
													headCount="";
													typeCompany="";
													String start=null;
													String end="";

													JSONObject innerObject = includeArray.getJSONObject(arrayIndex);

													if (isValid(innerObject, "staffCount")) {
														//System.out.println("staffCount: " + innerObject.get("staffCount").toString());
														headCount=innerObject.get("staffCount").toString();
														//System.out.println(headCount);
													}

												

													if (isValid(innerObject, "staffCountRange")) {
														JSONObject staffCountRangeObject = (JSONObject) innerObject.getJSONObject("staffCountRange");
														if (isValid(staffCountRangeObject, "start")) {
															//System.out.println("start: " + staffCountRangeObject.get("start").toString());
															start=staffCountRangeObject.get("start").toString();
														}
														if (isValid(staffCountRangeObject, "end")) {
															//System.out.println("end: " + staffCountRangeObject.get("end").toString());
															end=staffCountRangeObject.get("end").toString();
														}
														companySize=start+" "+end;
														
													}

													if (isValid(innerObject, "companyType")) {
														JSONObject companyTypeObject = (JSONObject) innerObject.getJSONObject("companyType");
														if (isValid(companyTypeObject, "localizedName")) {
															//System.out.println("Company Type: "+ companyTypeObject.get("localizedName").toString());
															typeCompany=companyTypeObject.get("localizedName").toString();
															//System.out.println(industry);
														}
													}
				


												} catch (Exception ex) {
													System.out.println(ex.toString());
												}
											}
										}
									}
								}
							}
						} catch (Exception ex) {
							System.out.println(ex.toString());
						}
					}
				}
				
				
				
			}

System.out.println(industry);
			String outputFile = "C:\\Om\\likedindata.csv";

			// before we open the file check to see if it already exists
			boolean alreadyExists = new File(outputFile).exists();

			try {
				// use FileWriter constructor that specifies open for appending
				CsvWriter csvOutput = new CsvWriter(new FileWriter(outputFile, true), ',');

				// if the file didn't already exist then we need to write out the header line
				if (!alreadyExists)
				{
					
					csvOutput.write("company name");
					csvOutput.write("industry");
					csvOutput.write("company size");
					csvOutput.write("head count");
					csvOutput.write("type");
					csvOutput.endRecord();
				}

				csvOutput.write(file.getName().replace(".html", ""));
				csvOutput.write(industry);
				csvOutput.write(companySize);
				csvOutput.write(headCount);
				csvOutput.write(typeCompany);
				csvOutput.endRecord();


				csvOutput.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		}
		
	}

	public static boolean isValid(JSONObject jsonObject, String propertyName) {
		boolean valid = false;
		try {
			if (propertyName != null) {
				if (jsonObject.has(propertyName) && !jsonObject.get(propertyName).toString().equalsIgnoreCase("null")
						&& !jsonObject.get(propertyName).toString().equalsIgnoreCase(""))
					valid = true;
			}
		} catch (Exception ex) {
			System.out.println(ex.toString());
			valid = false;

		}
		return valid;
	}

	public static void saveImage(String imageUrl, String destinationFile) throws IOException {
		URL url = new URL(imageUrl);
		InputStream is = url.openStream();
		OutputStream os = new FileOutputStream(destinationFile);

		byte[] b = new byte[2048];
		int length;

		while ((length = is.read(b)) != -1) {
			os.write(b, 0, length);
		}

		is.close();
		os.close();
	}

}

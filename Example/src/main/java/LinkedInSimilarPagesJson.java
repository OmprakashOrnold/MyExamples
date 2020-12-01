import java.io.File;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;	
import org.jsoup.nodes.Element;	
import org.jsoup.select.Elements;



public class LinkedInSimilarPagesJson {

	public static void main(String[] args) {
		Document document = null;
String pageData=null;
String jsonResponse=null;

		File fullFileName = new File("C:\\Users\\oppeddamadthala\\Downloads\\posts_info_v1\\posts_info_v1\\88989.html" + 
				"");
		try {

			document = Jsoup.parse(fullFileName, "UTF-8");
			if (document != null) {
				ArrayList<String> arr = new ArrayList<String>();
				Elements anchor_elements = document.select("a");
				if (anchor_elements != null && anchor_elements.size() > 0) {
					for (Element element : anchor_elements) {
						try {
							if (element.hasAttr("href") && element.hasAttr("class")
									&& element.attr("class").equals("ember-view")
									&& element.attr("href").startsWith("/company/")) {
								arr.add(element.attr("href").replace("/company/", "").replace("/", "")
										.trim());
								//System.out.println(element);
							}
							
					
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
				}
				Elements h3_elements = document.select("h3");
				if (h3_elements != null && h3_elements.size() > 0) {
					for (Element element : h3_elements) {
						try {
							if (element.hasAttr("class") && element.attr("class")
									.equals("t-18 t-black t-normal pt4 pb3 ph4")) {
								pageData = element.text().trim();
								System.out.println(pageData);
							}
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
				}
			
				if (pageData != null && pageData.equals("Similar pages")) {
					Elements code_elements = document.select("code");
					if (code_elements != null && code_elements.size() > 0) {
						for (Element element : code_elements) {
							if (element.hasAttr("style") && element.hasAttr("id")) {
								if (element.attr("style").equals("display: none")
										&& element.attr("id").startsWith("bpr-guid-")) {
									String pageContent = element.text();
									if (pageContent != null && pageContent != ""
											&& pageContent.contains("included") && pageContent.contains(
													"com.linkedin.voyager.deco.organization.web.WebSimilarCompanyCardWithRelevanceReason")) {
										jsonResponse = pageContent.toString().trim();
										System.out.println(jsonResponse);
									}
								}
								}
							}
						}
					}
				
				if (jsonResponse != null) {
					JSONObject jsonObject = new JSONObject(jsonResponse);
					JSONArray includeArray = jsonObject.getJSONArray("included");
					int arraySize = includeArray.length();
					if (arraySize > 0) {
						for (int arrayIndex = 0; arrayIndex < arraySize; arrayIndex++) {
							try {
								JSONObject innerObject = includeArray.getJSONObject(arrayIndex);

								String validCompe = null;
								if (isValid(innerObject, "$recipeTypes")) {
									JSONArray recArray = innerObject.getJSONArray("$recipeTypes");
									if (recArray.length() > 0) {
										validCompe = recArray.getString(0).trim();
									}
									String uniqueNameOuter=null;
									if (isValid(innerObject, "universalName")) {
										uniqueNameOuter = innerObject.get("universalName").toString()
												.trim();
										System.out.println(uniqueNameOuter);
									}

								}
							}catch (Exception e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
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
}

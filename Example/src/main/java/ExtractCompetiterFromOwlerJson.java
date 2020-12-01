import java.io.File;

import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ExtractCompetiterFromOwlerJson {

	public static void main(String[] args) {
		Document document = null;
		String jsonResponse=null;

		File folder = new File("C:\\Users\\oppeddamadthala\\Downloads\\Owler\\Owler");
		File[] listOfFiles = folder.listFiles();

		for (File file : listOfFiles) {
			if (file.isFile()) {
				System.out.println(file.getName());
				try {
					String pageData = null;
					document=Jsoup.parse(new File("C:\\Users\\oppeddamadthala\\Downloads\\Owler\\Owler\\"+file.getName()),"utf-8");

					
					if (document != null) {
						Elements element = document.select("h2[class=card-title title black bold]");
						pageData = element.get(1).text().trim();

						if (pageData != null && pageData.equals("Competitive Analysis")) {
							Elements script_tag = document.select("script");
							String Json = script_tag.toString().substring(script_tag.toString().indexOf("__NEXT_DATA__"),
									script_tag.toString().indexOf("module={}"));
							jsonResponse=Json.toString().substring(16).trim();					
							//System.out.println(jsonResponse);			
						}

						// the json file is ready
						if (jsonResponse != null) {
							JSONObject jsonObject = new JSONObject(jsonResponse);
							JSONObject propsJsonObject =(JSONObject) jsonObject.get("props");	
							if (propsJsonObject != null&& propsJsonObject.has("pageProps")) {
								JSONObject pagePropsJsonObject =(JSONObject) propsJsonObject.get("pageProps");
								if (pagePropsJsonObject != null&& pagePropsJsonObject.has("initialState")) {
									JSONObject initialStateJsonObject =(JSONObject) pagePropsJsonObject.get("initialState");
									if (initialStateJsonObject != null&& initialStateJsonObject.has("teamName")) {
										//System.out.println(initialStateJsonObject);	
										JSONArray cgArray = initialStateJsonObject.getJSONArray("cg");
										int arraySize = cgArray.length();
										if (arraySize > 0) {
											for (int arrayIndex = 0; arrayIndex < arraySize; arrayIndex++) {
												try {

													String teamName=null;
													String	companyLogoUrl=null;
													String owlerCompanyUrl=null;
													String shortName=null;
													String firstName=null;
													String lastName=null;
													String designation=null;
													String revenue=null;
													String proximity_score=null;
													int employeeCount=0;
													String totalFunding=null;
													String ceoRating=null;

													JSONObject innerJsonObject = cgArray.getJSONObject(arrayIndex);
													JSONObject companyBasicInfoObject =(JSONObject) innerJsonObject.get("companyBasicInfo");	
													if (companyBasicInfoObject != null&& companyBasicInfoObject.has("teamName")) {
														//System.out.println(companyBasicInfoObject);
														if (isValid(companyBasicInfoObject, "teamName")) {
															teamName= companyBasicInfoObject.get("teamName").toString().trim();
															//System.out.println(teamName);
														}
														if (isValid(companyBasicInfoObject, "logo")) {
															companyLogoUrl= companyBasicInfoObject.get("logo").toString().trim();
															//System.out.println(companyLogoUrl);
														}
														if (isValid(companyBasicInfoObject, "cpLink")) {
															owlerCompanyUrl= companyBasicInfoObject.get("cpLink").toString().trim();
															//System.out.println(owlerCompanyUrl);
														}
														if (isValid(companyBasicInfoObject, "shortName")) {
															shortName= companyBasicInfoObject.get("shortName").toString().trim();
															//System.out.println(shortName);
														}
													}


													if (innerJsonObject != null&& innerJsonObject.has("revenue")) {
														revenue=innerJsonObject.get("revenue").toString();
														//System.out.println(innerJsonObject.get("revenue"));
													}

													if (innerJsonObject != null&& innerJsonObject.has("proximity_score")) {												
														proximity_score=innerJsonObject.get("proximity_score").toString();
														//System.out.println(innerJsonObject.get("proximity_score"));
													} 

													if (innerJsonObject != null&& innerJsonObject.has("employeeCount")) {
														employeeCount=(int) innerJsonObject.get("employeeCount");
														//System.out.println(innerJsonObject.get("employeeCount"));

													} 

													if (innerJsonObject != null&& innerJsonObject.has("totalFunding")) {
														totalFunding=innerJsonObject.get("totalFunding").toString();
														//System.out.println(innerJsonObject.get("employeeCount"));

													} 



													JSONObject ceoDetailObject =(JSONObject) innerJsonObject.get("ceoDetail");	
													if (ceoDetailObject != null&& ceoDetailObject.has("firstName")) {

														if (isValid(ceoDetailObject, "firstName")) {
															firstName= ceoDetailObject.get("firstName").toString().trim();
															//System.out.println(firstName);
														}
														if (isValid(ceoDetailObject, "lastName")) {
															lastName= ceoDetailObject.get("lastName").toString().trim();
															//System.out.println(lastName);
														}
														
														if (isValid(ceoDetailObject, "ceoRating")) {
															ceoRating= ceoDetailObject.get("ceoRating").toString().trim();
															//System.out.println(ceoRating);
														}
														
														if (isValid(ceoDetailObject, "designation")) {
															designation= ceoDetailObject.get("designation").toString().trim();
															//System.out.println(designation);
														}



														System.out.println("-------------------Company Info------------------------------");
														System.out.println("teamName         ----->"+teamName);
														System.out.println("companyLogoUrl   ----->"+companyLogoUrl);
														System.out.println("owlerCompanyUrl  ----->"+owlerCompanyUrl);
														System.out.println("shortName        ----->"+shortName);
														System.out.println("revenue          ----->"+revenue);
														System.out.println("proximity_score  ----->"+proximity_score);
														System.out.println("employeeCount    ----->"+employeeCount);
														System.out.println("totalFunding    ----->"+totalFunding);
														System.out.println("----------------- -CEO Detail--------------------------------");
														System.out.println("firstName        ----->"+firstName);
														System.out.println("lastName         ----->"+lastName);
														System.out.println("ceoRating        ----->"+ceoRating);
														System.out.println("designation      ----->"+designation);
													}
												}catch (Exception e) {
													e.printStackTrace();
												}
											}
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

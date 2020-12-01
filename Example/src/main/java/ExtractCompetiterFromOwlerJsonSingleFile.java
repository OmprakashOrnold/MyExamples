import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.nodes.Document;

public class ExtractCompetiterFromOwlerJsonSingleFile {

	public static void main(String[] args) {
		Document document = null;
		String jsonData=null;

		try {
			File folder = new File("C:\\OM\\R&D Owler\\Stage1-9");
			File[] listOfFiles = folder.listFiles();

			for (File file : listOfFiles) {
				if (file.isFile()) {


					String 	fullFileName="C:\\OM\\R&D Owler\\Stage1-9\\"+file.getName();		
					jsonData=readFileAsString(fullFileName);
				

				// the json file is ready
				if (jsonData != null) {
					JSONObject jsonObject = new JSONObject(jsonData);
					JSONObject propsJsonObject =(JSONObject) jsonObject.get("props");	
					if (propsJsonObject != null&& propsJsonObject.has("pageProps")) {
						JSONObject pagePropsJsonObject =(JSONObject) propsJsonObject.get("pageProps");
						if (pagePropsJsonObject != null&& pagePropsJsonObject.has("initialState")) {
							JSONObject initialStateJsonObject =(JSONObject) pagePropsJsonObject.get("initialState");

							JSONArray cgArray = initialStateJsonObject.getJSONArray("cg");
							int arraySize = cgArray.length();
							if (arraySize > 0) {
								for (int arrayIndex = 0; arrayIndex < arraySize; arrayIndex++) {
									try {
										
										String website=null;
										String smallLogo=null;
										String founded=null;
										String description=null;
										String total_employees=null;
										String profileCompletenessScore=null;
										String industryId=null;
										String mediumLogo=null;
										String ownership=null;
										String total_revenue=null;
										String name=null;
										String logo=null;
										String followersCount=null;
										String shortName=null;
										String parent=null;
										String status=null;
										String zipcode=null;
										String country=null;
										String phone	=null;
										String state_name=null;
										String city=null;
										String street1=null;
										String street2=null;
										String state=null;
										String press_page=null;
										String blog=null;
										String youtube=null;
										String facebook=null;
										String linkedIn=null;
										String twitter=null;
										String jobs_page=null;
										String sector_name=null;
										String sector_code=null;
										String companyId=null;



										JSONObject innerJsonObject = cgArray.getJSONObject(arrayIndex);
										JSONObject companyBasicInfoObject =(JSONObject) innerJsonObject.get("companyBasicInfo");	
										if (companyBasicInfoObject != null&& companyBasicInfoObject.has("teamName")) {
											//System.out.println(companyBasicInfoObject);
											if (isValid(companyBasicInfoObject, "companyId")) {
												companyId= companyBasicInfoObject.get("companyId").toString().trim();
												//System.out.println(companyId);
											}
										}

										if (initialStateJsonObject != null&& initialStateJsonObject.has("teamName")) {
											JSONObject competitorDetailsJsonObject =(JSONObject) initialStateJsonObject.get("competitorDetails");
											//System.out.println(competitorDetailsJsonObject);	
											//System.out.println(companyId);


											
											if (competitorDetailsJsonObject != null&& competitorDetailsJsonObject.has(companyId)) {

												JSONObject companyIdObject =(JSONObject) competitorDetailsJsonObject.get(companyId);
												if (companyIdObject != null&& companyIdObject.has("website")) {
													website=companyIdObject.get("website").toString();
													System.out.println("Company Url               ----->"+website);
												}

												if (companyIdObject != null&& companyIdObject.has("founded")) {
													founded=companyIdObject.get("founded").toString();
													System.out.println("Founded                   ----->"+founded);
												}

												if (companyIdObject != null&& companyIdObject.has("parent")) {
													parent=companyIdObject.get("parent").toString();
													System.out.println("parent                    ----->"+parent);
												}

												JSONObject statusInfoObject =(JSONObject) companyIdObject.get("statusInfo");
												if (statusInfoObject != null&& statusInfoObject.has("status")) {
													status=statusInfoObject.get("status").toString();
													System.out.println("Company status             ----->"+status);
												}


												JSONArray industrySectorArray = companyIdObject.getJSONArray("industrySector");
												int arraySize1 = cgArray.length();
												if (arraySize1 > 0) {
													for (int arrayIndex1 = 0; arrayIndex1 < arraySize1; arrayIndex1++) {
														try {
															JSONObject industrySectoinnerJsonObject = industrySectorArray.getJSONObject(arrayIndex1);


															if (industrySectoinnerJsonObject != null&& industrySectoinnerJsonObject.has("sector_name")) {

																sector_name= industrySectoinnerJsonObject.get("sector_name").toString().trim();
																System.out.println("sector_name      ---->"+sector_name);

															}

															if (industrySectoinnerJsonObject != null&& industrySectoinnerJsonObject.has("sector_code")) {

																sector_code= industrySectoinnerJsonObject.get("sector_code").toString().trim();
																System.out.println("sector_code      ---->"+sector_code);

															}
														}catch (Exception e) {
															e.printStackTrace();
														}
													}
												}



												if (companyIdObject != null&& companyIdObject.has("smallLogo")) {
													smallLogo=companyIdObject.get("smallLogo").toString();
													System.out.println("SmallLogo                 ----->"+smallLogo);
												}

												if (companyIdObject != null&& companyIdObject.has("description")) {
													description=companyIdObject.get("description").toString();
													System.out.println("Description               ----->"+description);
												}


												//adresss------------Start------------------------------------//

												
												if (isValid(companyIdObject, "hqAddress")) {
													JSONObject hqAddressObject =(JSONObject) companyIdObject.get("hqAddress");

													if (hqAddressObject != null&& hqAddressObject.has("zipcode")) {
														zipcode=hqAddressObject.get("zipcode").toString();
														System.out.println("zipcode            ----->"+zipcode);
													}

													if (hqAddressObject != null&& hqAddressObject.has("country")) {
														country=hqAddressObject.get("country").toString();
														System.out.println("country            ----->"+country);
													}


													if (hqAddressObject != null&& hqAddressObject.has("phone")) {
														phone=hqAddressObject.get("phone").toString();
														System.out.println("phone	            ----->"+phone);
													}

													if (hqAddressObject != null&& hqAddressObject.has("state_name")) {
														state_name=hqAddressObject.get("state_name").toString();
														System.out.println("state_name	            ----->"+state_name);
													}

													if (hqAddressObject != null&& hqAddressObject.has("street1")) {
														street1=hqAddressObject.get("street1").toString();
														System.out.println("street1	            ----->"+street1);
													}

													if (hqAddressObject != null&& hqAddressObject.has("street2")) {
														street2=hqAddressObject.get("street2").toString();
														System.out.println("street2	            ----->"+street2);
													}

													if (hqAddressObject != null&& hqAddressObject.has("city")) {
														city=hqAddressObject.get("city").toString();
														System.out.println("city	            ----->"+city);
													}
												}

												//address-------------End------------------------------------//

												if (companyIdObject != null&& companyIdObject.has("total_employees")) {
													total_employees=companyIdObject.get("total_employees").toString();
													System.out.println("EmployeeCount             ----->"+total_employees);
												}

												if (companyIdObject != null&& companyIdObject.has("profileCompletenessScore")) {
													profileCompletenessScore=companyIdObject.get("profileCompletenessScore").toString();
													System.out.println("profileCompletenessScore  ----->"+profileCompletenessScore);
												}

												if (companyIdObject != null&& companyIdObject.has("industryId")) {
													industryId=companyIdObject.get("industryId").toString();
													System.out.println("industryId                ----->"+industryId);
												}

												if (companyIdObject != null&& companyIdObject.has("mediumLogo")) {
													mediumLogo=companyIdObject.get("mediumLogo").toString();
													System.out.println("mediumLogo                ----->"+mediumLogo);
												}

												if (companyIdObject != null&& companyIdObject.has("ownership")) {
													ownership=companyIdObject.get("ownership").toString();
													System.out.println("ownership                 ----->"+ownership);
												}

												if (companyIdObject != null&& companyIdObject.has("total_revenue")) {
													total_revenue=companyIdObject.get("total_revenue").toString();
													System.out.println("total_revenue             ----->"+total_revenue);
												}

												if (companyIdObject != null&& companyIdObject.has("name")) {
													name=companyIdObject.get("name").toString();
													System.out.println("CompanyName               ----->"+name);
												}


												if (companyIdObject != null&& companyIdObject.has("logo")) {
													logo=companyIdObject.get("logo").toString();
													System.out.println("Company Logo              ----->"+logo);
												}


												//url links----------------------Start-----------------//
												System.out.println("**************links**********************");
												JSONObject linksObject =(JSONObject) companyIdObject.get("links");
												if (linksObject != null&& linksObject.has("blog")) {
													blog=linksObject.get("blog").toString();
													System.out.println("blog               ----->"+blog);
												}

												if (linksObject != null&& linksObject.has("press_page")) {
													press_page=linksObject.get("press_page").toString();
													System.out.println("press_page         ----->"+press_page);
												}

												if (linksObject != null&& linksObject.has("youtube")) {
													youtube=linksObject.get("youtube").toString();
													System.out.println("youtube            ----->"+youtube);
												}

												if (linksObject != null&& linksObject.has("facebook")) {
													facebook=linksObject.get("facebook").toString();
													System.out.println("facebook            ----->"+facebook);
												}

												if (linksObject != null&& linksObject.has("linkedIn")) {
													linkedIn=linksObject.get("linkedIn").toString();
													System.out.println("linkedIn            ----->"+linkedIn);
												}

												if (linksObject != null&& linksObject.has("twitter")) {
													twitter=linksObject.get("twitter").toString();
													System.out.println("twitter            ----->"+twitter);
												}

												if (linksObject != null&& linksObject.has("jobs_page")) {
													jobs_page=linksObject.get("jobs_page").toString();
													System.out.println("jobs_page            ----->"+jobs_page);
												}

												//url links----------------------End-----------------//
												if (companyIdObject != null&& companyIdObject.has("followersCount")) {
													followersCount=companyIdObject.get("followersCount").toString();
													System.out.println("followersCount            ----->"+followersCount);
												}

												if (companyIdObject != null&& companyIdObject.has("shortName")) {
													shortName=companyIdObject.get("shortName").toString();
													System.out.println("shortName                 ----->"+shortName);
												}


											}


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
	
	public static String readFileAsString(String fileName)throws Exception 
	{ 
		String data = ""; 
		data = new String(Files.readAllBytes(Paths.get(fileName))); 
		return data; 
	}

}

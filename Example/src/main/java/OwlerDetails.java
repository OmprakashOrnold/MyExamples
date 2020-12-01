

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class OwlerDetails {

	public static void main(String[] args) {
		
		String jsonData=null;
		String domainName=null;
		String domainFromPase=null;
		Long paseId=null;
		
		try {
			File folder = new File("C:\\OM\\R&D Owler\\Stage1-9");
			File[] listOfFiles = folder.listFiles();

			for (File file : listOfFiles) {
				if (file.isFile()) {


					String 	fullFileName="C:\\OM\\R&D Owler\\Stage1-9\\"+file.getName();		
					jsonData=readFileAsString(fullFileName);
					
					if (jsonData != null) {
						JSONObject jsonObject = new JSONObject(jsonData);
						JSONObject propsJsonObject =(JSONObject) jsonObject.get("props");	
						if (propsJsonObject != null&& propsJsonObject.has("pageProps")) {
							JSONObject pagePropsJsonObject =(JSONObject) propsJsonObject.get("pageProps");
							if (pagePropsJsonObject != null&& pagePropsJsonObject.has("initialState")) {
								JSONObject initialStateJsonObject =(JSONObject) pagePropsJsonObject.get("initialState");
							
								if (isValid(initialStateJsonObject, "domainName")) {
									domainName= initialStateJsonObject.get("domainName").toString().trim();
									//System.out.println(domainName);
									String []fileArray=file.getName().replace(".txt","").split("[-|=]") ;
									paseId=Long.parseLong(fileArray[0].toString());
									domainFromPase=fileArray[1].toString();

									if(domainFromPase.equals(domainName))
									{

										String companyName=null;
										Long companyId=null;
										String description=null;
										String shortName=null;
										String domainName1=null;
										String website=null;
										String teamName=null;
										String logo=null;
										String founded=null;
										String ownership=null;
										String status=null;
										Long followers=null;
										Long completenessScore=null;
										Long revenue=null;
										Long employeeCount=null;
										String city=null;
										String state=null;
										String country=null;
										String cpLink=null;
										Long totalFunding=null;
										String street1Address=null;
										String street2Address=null;
										String zipcode=null;
										String phoneNumber=null;
										String summarySection=null;
										Long cgCompaniesCount=null;
										Long formattedEmployeeCount=null;
										String formattedRevenue=null;
										Long formattedFollower=null;
										String formattedFunding=null;
										String twitterLink=null;
										String facebookLink=null;
										String linkedInLink=null;
										
										if (initialStateJsonObject != null&& initialStateJsonObject.has("companyId")) 
										{		
											companyId= Long.parseLong(initialStateJsonObject.get("companyId").toString().trim());
											
										}
										
										if (initialStateJsonObject != null&& initialStateJsonObject.has("companyName")) 
										{		
											companyName= initialStateJsonObject.get("companyName").toString().trim();
											
										}
										
										if (initialStateJsonObject != null&& initialStateJsonObject.has("description")) 
										{		
											description= initialStateJsonObject.get("description").toString().replaceAll("[\r\n]+", " ").trim();;
											//System.out.println(description);
										}
										
										if (initialStateJsonObject != null&& initialStateJsonObject.has("shortName")) 
										{		
											shortName= initialStateJsonObject.get("shortName").toString().trim();
											//System.out.println(shortName);
										}
										
										if (initialStateJsonObject != null&& initialStateJsonObject.has("domainName")) 
										{		
											domainName1= initialStateJsonObject.get("domainName").toString().trim();
											try (FileWriter writer = new FileWriter(
													"C:\\Om\\Owler.txt", true);
													BufferedWriter bw = new BufferedWriter(writer)) {


												bw.write(domainName1);
												bw.write("\n");

											} catch (IOException ex) {
												System.err.format("IOException: %s%n", ex);
											}
										}
										
										if (initialStateJsonObject != null&& initialStateJsonObject.has("website")) 
										{		
											website= initialStateJsonObject.get("website").toString().trim();
										    //System.out.println(website);
										}
										
										if (initialStateJsonObject != null&& initialStateJsonObject.has("teamName")) 
										{		
											teamName= initialStateJsonObject.get("teamName").toString().trim();
											//System.out.println(teamName);
										}
										
										if (initialStateJsonObject != null&& initialStateJsonObject.has("logo")) 
										{		
											logo= initialStateJsonObject.get("logo").toString().trim();
											//System.out.println(logo);
										}
										
										if (initialStateJsonObject != null&& initialStateJsonObject.has("founded")) 
										{	
											//String foundedArray[]= initialStateJsonObject.get("founded").toString().trim().split("/")
											
											
											//founded= Long.parseLong(foundedArray[1].toString())
											//System.out.println(founded);
										}
										
										if (initialStateJsonObject != null&& initialStateJsonObject.has("ownership")) 
										{		
											ownership= initialStateJsonObject.get("ownership").toString().trim();
											//System.out.println(ownership);
										}
										
									
										  JSONArray linksArray = initialStateJsonObject.getJSONArray("links");
											int arraySized = linksArray.length();
											if (arraySized > 0) {
												for (int arrayIndex = 0; arrayIndex < arraySized; arrayIndex++) {
													try {
														JSONObject innerJsonObject = linksArray.getJSONObject(arrayIndex);
														
														if (innerJsonObject != null&& innerJsonObject.has("linkType")) 
														{		
															String linkType=innerJsonObject.getString("linkType");
															if(linkType.equals("twitter"))
															{
																twitterLink=innerJsonObject.getString("link");
																//System.out.println(twitterLink);
															}	
															
															if(linkType.equals("facebook"))
															{
																facebookLink=innerJsonObject.getString("link");
																//System.out.println(facebookLink);
															}	
															
															if(linkType.equals("linkedIn"))
															{
																linkedInLink=innerJsonObject.getString("link");
																//System.out.println(linkedInLink);
															}	
														}

													}catch(Exception e )
													{
														e.printStackTrace();
													}
												}
											}
											
										
									
										if (initialStateJsonObject != null&& initialStateJsonObject.has("status")) 
										{		
											status= initialStateJsonObject.get("status").toString().trim();
											//System.out.println(status);
										}
										
										if (initialStateJsonObject != null&& initialStateJsonObject.has("followers")) 
										{		
											followers= Long.parseLong(initialStateJsonObject.get("followers").toString().trim());
											//System.out.println(followers);
										}
										
										if (initialStateJsonObject != null&& initialStateJsonObject.has("completenessScore")) 
										{		
											completenessScore= Long.parseLong(initialStateJsonObject.get("completenessScore").toString().trim());
											//System.out.println(completenessScore);
										}
										
										if (initialStateJsonObject != null&& initialStateJsonObject.has("revenue")) 
										{		
											revenue= Long.parseLong(initialStateJsonObject.get("revenue").toString().trim());
											//System.out.println(revenue);
										}
										
										if (initialStateJsonObject != null&& initialStateJsonObject.has("employeeCount")) 
										{		
											employeeCount= Long.parseLong(initialStateJsonObject.get("employeeCount").toString().trim());
											//System.out.println(employeeCount);
										}
									
										if (initialStateJsonObject != null&& initialStateJsonObject.has("city")) 
										{		
											city= initialStateJsonObject.get("city").toString().trim();
											//System.out.println(city);
										}
										
										if (initialStateJsonObject != null&& initialStateJsonObject.has("state")) 
										{		
											state= initialStateJsonObject.get("state").toString().trim();
											//System.out.println(state);
										}
										
										if (initialStateJsonObject != null&& initialStateJsonObject.has("country")) 
										{		
											country= initialStateJsonObject.get("country").toString().trim();
											//System.out.println(country);
										}
										
										if (initialStateJsonObject != null&& initialStateJsonObject.has("cpLink")) 
										{		
											cpLink= initialStateJsonObject.get("cpLink").toString().trim();
											//System.out.println(cpLink);
										}
										
										if (initialStateJsonObject != null&& initialStateJsonObject.has("totalFunding")) 
										{		
											totalFunding= Long.parseLong(initialStateJsonObject.get("totalFunding").toString().trim());
											//System.out.println(totalFunding);
										}
										
										if (initialStateJsonObject != null&& initialStateJsonObject.has("street1Address")) 
										{		
											street1Address=initialStateJsonObject.get("street1Address").toString().trim();
											//System.out.println(street1Address);
										}
										
										if (initialStateJsonObject != null&& initialStateJsonObject.has("street2Address")) 
										{		
											street2Address=initialStateJsonObject.get("street2Address").toString().trim();
											//System.out.println(street2Address);
										}
										
										if (initialStateJsonObject != null&& initialStateJsonObject.has("zipcode")) 
										{		
											zipcode=initialStateJsonObject.get("zipcode").toString().trim();
											//System.out.println(zipcode);
										}
										
										if (initialStateJsonObject != null&& initialStateJsonObject.has("phoneNumber")) 
										{		
											phoneNumber=initialStateJsonObject.get("phoneNumber").toString().trim();
											//System.out.println(phoneNumber);
										}
										
										if (initialStateJsonObject != null&& initialStateJsonObject.has("summarySection")) 
										{		
											summarySection=initialStateJsonObject.get("summarySection").toString().trim();
											//System.out.println(summarySection);
										}
										
										if (initialStateJsonObject != null&& initialStateJsonObject.has("cgCompaniesCount")) 
										{		
											cgCompaniesCount= Long.parseLong(initialStateJsonObject.get("cgCompaniesCount").toString().trim());
											//System.out.println(cgCompaniesCount);
										}
										
										if (initialStateJsonObject != null&& initialStateJsonObject.has("formattedEmployeeCount")) 
										{		
											formattedEmployeeCount= Long.parseLong(initialStateJsonObject.get("formattedEmployeeCount").toString().replace(",", "").trim());
											//System.out.println(formattedEmployeeCount);
										}
										
										if (initialStateJsonObject != null&& initialStateJsonObject.has("formattedRevenue")) 
										{		
											formattedRevenue=initialStateJsonObject.get("formattedRevenue").toString().replaceAll("<", "Less Than").trim();
											//System.out.println(formattedRevenue);
										}
										
										if (initialStateJsonObject != null&& initialStateJsonObject.has("formattedFollower")) 
										{		
											formattedFollower= Long.parseLong(initialStateJsonObject.get("formattedFollower").toString().replace(",", "").trim());
											//System.out.println(formattedFollower);
										}
										
										if (initialStateJsonObject != null&& initialStateJsonObject.has("formattedFunding")) 
										{		
											formattedFunding=initialStateJsonObject.get("formattedFunding").toString().trim();
											//System.out.println(formattedFunding);
										}
										
									}
								}
								
								
							}
						}				
					}								
				}
			}

		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (Exception e) {		
			e.printStackTrace();
		}
		
		

	}
	
	public static  boolean isValid(JSONObject jsonObject, String propertyName) {
		boolean valid = false;
		try {
			if (propertyName != null) {
				if (jsonObject.has(propertyName) && !jsonObject.get(propertyName).toString().equalsIgnoreCase("null")
						&& !jsonObject.get(propertyName).toString().equalsIgnoreCase(""))
					valid = true;
			}
		} catch (JSONException e) {
			e.printStackTrace();
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

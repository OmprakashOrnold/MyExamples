package com.aldrich.linkdin.about;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class LinkedinAboutPages {

	public static void main(String[] args) {

		File folder = new File("C:\\aboutus_03.10\\");
		File[] listOfFiles = folder.listFiles();

		for (File file : listOfFiles) {
			if (file.isFile()) {
			//	System.out.println(file.getName().replace(".html",""));
				File fullFileName = new File("C:\\aboutus_03.10\\"+file.getName());

				processResponse(fullFileName);

			//	System.out.println("******************************************************************************");
			}
		}

	}

	public static void processResponse(File fullFileName) {

		Document document=null;
		// read the content from file
		try {
			document = Jsoup.parse(fullFileName, "UTF-8");
			// saving the logo
			Elements image_elements = document.select("img");
			if (image_elements != null && image_elements.size() > 0) {
				for (Element element: image_elements) {
					try {
						if (element.hasAttr("class") && element.hasAttr("src") &&
								element.attr("class").equals("lazy-image ember-view org-top-card-primary-content__logo")) {
							String logo = element.attr("src").trim();
							if (logo != null && logo != "") {
								System.out.println(logo);
							}
						}
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}


			Elements code_elements = document.select("code");
			if (code_elements != null && code_elements.size() > 0) {
				for (Element element : code_elements) {
					try {				
						if (element.hasAttr("style") && element.hasAttr("id")) {
							if (element.attr("style").equals("display: none")&& element.attr("id").startsWith("bpr-guid-")) {
								String pageContent = element.text();
								if (pageContent != null && pageContent != "" && pageContent.contains("included")&& pageContent.contains("companyPageUrl")) {
									JSONObject jsonObject = new JSONObject(pageContent);
									processJSONObject(jsonObject);
								}
							}
						}
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void processJSONObject(JSONObject jsonObject) {
		String company_url=null;
		String staff_count=null;
		String description=null;
		String companyId=null;
		String company_type=null;
		String founded_on=null;
		String specialities=null;
		String start_count=null;
		String end_count=null;
		String followers_count=null;
		String categoryId=null;
		String  companyUniqueeName=null;
		try {
			companyUniqueeName=getLinkedinCompanyUniqueName(jsonObject);
			followers_count=getFollowersCount(jsonObject);
			company_url=getCompanyUrl(jsonObject);
			staff_count=getStaffCount(jsonObject);
			description=getDescription(jsonObject);
			companyId=getLinkedinCompanyID(jsonObject);
			company_type=getCompanyType(jsonObject);
			founded_on=getFoundedOn(jsonObject);
			specialities=getSpecialities(jsonObject);
			start_count=getStaffRanageStartCount(jsonObject);
			end_count=getStaffRanageEndCount(jsonObject);
			categoryId=getCategoryID(jsonObject);

			System.out.println(companyUniqueeName);
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println(categoryId);
			
			System.out.println(followers_count);
			System.out.println(company_url);
			System.out.println(staff_count);
			System.out.println(description);
			System.out.println(companyId);
			System.out.println(company_type);
			System.out.println(founded_on);
			System.out.println(specialities);
			System.out.println(start_count);
			System.out.println(end_count);


			List<LocationDetailsBO> hHocation= getHeadquaterLocations(jsonObject) ;			
			for (LocationDetailsBO locationDetailsBO : hHocation) {

				System.out.println(locationDetailsBO.getLine1());
				System.out.println(locationDetailsBO.getLine2());
				System.out.println(locationDetailsBO.getGeographicArea());
				System.out.println(locationDetailsBO.getCity());
				System.out.println(locationDetailsBO.getCountry());	

			}

			System.out.println("--------------------------");
			List<LocationDetailsBO> location= getConfirmedLocations(jsonObject) ;			
			for (LocationDetailsBO locationDetailsBO : location) {				
				System.out.println(locationDetailsBO.getLine1());
				System.out.println(locationDetailsBO.getLine2());
				System.out.println(locationDetailsBO.getGeographicArea());
				System.out.println(locationDetailsBO.getCity());
				System.out.println(locationDetailsBO.getCountry());	
			}


		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static List<LocationDetailsBO> getHeadquaterLocations(JSONObject jsonObject) {

		JSONArray includeArray = jsonObject.getJSONArray("included");
		List<LocationDetailsBO> locationDetailsList = new ArrayList<LocationDetailsBO>();
		int arraySize = includeArray.length();
		if (arraySize > 0) {
			for (int arrayIndex = 0; arrayIndex < arraySize; arrayIndex++) {
				try {
					JSONObject innerObject = includeArray.getJSONObject(arrayIndex);
					LocationDetailsBO locationDetails=new LocationDetailsBO();
					try {
						if (isValid(innerObject, "headquarter")) {
							JSONObject headquarterObject = (JSONObject) innerObject.getJSONObject("headquarter");
							if (isValid(headquarterObject, "country")) {
								locationDetails.setCountry(headquarterObject.get("country").toString().trim());
							}
							if (isValid(headquarterObject, "geographicArea")) {
								locationDetails.setGeographicArea(headquarterObject.get("geographicArea").toString().trim());
							}
							if (isValid(headquarterObject, "city")) {
								locationDetails.setCity(headquarterObject.get("city").toString());
							}
							if (isValid(headquarterObject, "postalCode")) {
								locationDetails.setPostalCode(headquarterObject.get("postalCode").toString().trim());
							}
							if (isValid(headquarterObject, "line1")) {
								locationDetails.setLine1(headquarterObject.get("line1").toString());
							}
							if (isValid(headquarterObject, "line2")) {
								locationDetails.setLine2(headquarterObject.get("line2").toString());
							}
							locationDetailsList.add(locationDetails);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return locationDetailsList;
	}


	public static List<LocationDetailsBO> getConfirmedLocations(JSONObject jsonObject) {

		JSONArray includeArray = jsonObject.getJSONArray("included");
		List<LocationDetailsBO> locationDetailsList = new ArrayList<LocationDetailsBO>();
		int arraySize = includeArray.length();
		if (arraySize > 0) {
			for (int arrayIndex = 0; arrayIndex < arraySize; arrayIndex++) {
				try {
					JSONObject innerObject = includeArray.getJSONObject(arrayIndex);
					try {
						if (isValid(innerObject, "confirmedLocations")) {	
							JSONArray confirmedLocationsArray = innerObject.getJSONArray("confirmedLocations");
							if (confirmedLocationsArray.length() > 0) {
								for (int index = 0; index < confirmedLocationsArray.length(); index++) {
									LocationDetailsBO locationDetails=new LocationDetailsBO();
									JSONObject innerObject1 = confirmedLocationsArray.getJSONObject(index);
									if (isValid(innerObject1, "country")) {
										locationDetails.setCountry(innerObject1.get("country").toString().trim());
									}
									if (isValid(innerObject1, "geographicArea")) {
										locationDetails.setGeographicArea(innerObject1.get("geographicArea").toString().trim());
									}
									if (isValid(innerObject1, "city")) {
										locationDetails.setCity(innerObject1.get("city").toString());
									}
									if (isValid(innerObject1, "postalCode")) {
										locationDetails.setPostalCode(innerObject1.get("postalCode").toString().trim());
									}
									if (isValid(innerObject1, "line1")) {
										locationDetails.setLine1(innerObject1.get("line1").toString());
									}
									if (isValid(innerObject1, "line2")) {
										locationDetails.setLine2(innerObject1.get("line2").toString());
									}
									locationDetailsList.add(locationDetails);
								}
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return locationDetailsList;
	}


	public static String getFollowersCount(JSONObject jsonObject) {
		String followersCount="";
		try {
			JSONArray includeArray = jsonObject.getJSONArray("included");
			int arraySize = includeArray.length();
			if (arraySize > 0) {
				for (int arrayIndex = 0; arrayIndex < arraySize; arrayIndex++) {
					try {
						JSONObject innerObject = includeArray.getJSONObject(arrayIndex);
						if (isValid(innerObject, "entityUrn")) {
							String entityUrnText = innerObject.get("entityUrn").toString();
							if (entityUrnText.contains("urn:li:fs_followingInfo:urn:li:company:")) {
								if (isValid(innerObject,"followerCount")) {
									String followersText = innerObject.get("followerCount").toString().replace("followers", "").replace(",", "").trim();
									if (followersText != null &&	followersText != "") {
										followersCount=followersText;
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
		return followersCount;
	}

	public static String getCategoryID(JSONObject jsonObject) {
		String categoryId="";
		try {
			JSONArray includeArray = jsonObject.getJSONArray("included");
			int arraySize = includeArray.length();
			if (arraySize > 0) {
				for (int arrayIndex = 0; arrayIndex < arraySize; arrayIndex++) {
					try {
						JSONObject innerObject = includeArray.getJSONObject(arrayIndex);
						if (isValid(innerObject, "localizedName")) {
							String categoryName = innerObject.get("localizedName").toString();
							if (categoryName != null &&categoryName != "") {
								categoryId =categoryName;
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
		return categoryId;
	}


	public static String getSpecialities(JSONObject jsonObject) {
		String specialities="";
		try {
			JSONArray includeArray = jsonObject.getJSONArray("included");
			int arraySize = includeArray.length();
			if (arraySize > 0) {
				for (int arrayIndex = 0; arrayIndex < arraySize; arrayIndex++) {
					try {
						JSONObject innerObject = includeArray.getJSONObject(arrayIndex);
						if (isValid(innerObject, "specialities")) {
							JSONArray specialitiesArray = innerObject.getJSONArray("specialities");
							if (specialitiesArray.length() > 0) {
								for (int index = 0; index < specialitiesArray.length(); index++) {
									specialities = specialities + ", "+ specialitiesArray.getString(index);
								}
								specialities= specialities.replace("null,", "").trim().replaceFirst(",", "").trim();
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
		return specialities;
	}

	public static String getStaffRanageStartCount(JSONObject jsonObject) {
		String start_count="";
		try {
			JSONArray includeArray = jsonObject.getJSONArray("included");
			int arraySize = includeArray.length();
			if (arraySize > 0) {
				for (int arrayIndex = 0; arrayIndex < arraySize; arrayIndex++) {
					try {
						JSONObject innerObject = includeArray.getJSONObject(arrayIndex);
						if (isValid(innerObject, "staffCountRange")) {
							JSONObject staffCountRangeObject = (JSONObject) innerObject
									.getJSONObject("staffCountRange");
							if (isValid(staffCountRangeObject, "start")) {
								start_count= staffCountRangeObject.get("start").toString();
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
		return start_count;
	}

	public static String getStaffRanageEndCount(JSONObject jsonObject) {
		String end_count="";
		try {
			JSONArray includeArray = jsonObject.getJSONArray("included");
			int arraySize = includeArray.length();
			if (arraySize > 0) {
				for (int arrayIndex = 0; arrayIndex < arraySize; arrayIndex++) {
					try {
						JSONObject innerObject = includeArray.getJSONObject(arrayIndex);
						if (isValid(innerObject, "staffCountRange")) {
							JSONObject staffCountRangeObject = (JSONObject) innerObject
									.getJSONObject("staffCountRange");
							if (isValid(staffCountRangeObject, "end")) {
								end_count=staffCountRangeObject.get("end").toString();
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
		return end_count;
	}



	public static String getDescription(JSONObject jsonObject) {
		String description="";
		try {
			JSONArray includeArray = jsonObject.getJSONArray("included");
			int arraySize = includeArray.length();
			if (arraySize > 0) {
				for (int arrayIndex = 0; arrayIndex < arraySize; arrayIndex++) {
					try {
						JSONObject innerObject = includeArray.getJSONObject(arrayIndex);
						if (isValid(innerObject, "description")) {
							description=innerObject.get("description").toString().replaceAll("[\r\n]+", " ").trim();;
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return description;
	}


	public static String getFoundedOn(JSONObject jsonObject) {
		String founded_on="";
		try {
			JSONArray includeArray = jsonObject.getJSONArray("included");
			int arraySize = includeArray.length();
			if (arraySize > 0) {
				for (int arrayIndex = 0; arrayIndex < arraySize; arrayIndex++) {
					try {
						JSONObject innerObject = includeArray.getJSONObject(arrayIndex);
						if (isValid(innerObject, "foundedOn")) {
							JSONObject foundedOnObject = (JSONObject) innerObject.getJSONObject("foundedOn");
							if (isValid(foundedOnObject, "year")) {
								founded_on=foundedOnObject.get("year").toString().trim();
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
		return founded_on;
	}

	public static String getCompanyType(JSONObject jsonObject) {
		String company_type="";
		try {
			JSONArray includeArray = jsonObject.getJSONArray("included");
			int arraySize = includeArray.length();
			if (arraySize > 0) {
				for (int arrayIndex = 0; arrayIndex < arraySize; arrayIndex++) {
					try {
						JSONObject innerObject = includeArray.getJSONObject(arrayIndex);
						if (isValid(innerObject, "companyType")) {
							JSONObject companyTypeObject = (JSONObject) innerObject.getJSONObject("companyType");
							if (isValid(companyTypeObject, "localizedName")) {
								company_type=companyTypeObject.get("localizedName").toString();
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
		return company_type;
	}

	public static String getLinkedinCompanyID(JSONObject jsonObject) {
		String companyId="";
		try {
			JSONArray includeArray = jsonObject.getJSONArray("included");
			int arraySize = includeArray.length();
			if (arraySize > 0) {
				for (int arrayIndex = 0; arrayIndex < arraySize; arrayIndex++) {
					try {
						JSONObject innerObject = includeArray.getJSONObject(arrayIndex);
						if (isValid(innerObject, "entityUrn")&& isValid(innerObject, "companyPageUrl")) {
							companyId=innerObject.get("entityUrn").toString().replace("urn:li:fs_normalized_company:", "").trim();
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return companyId;
	}


	public static String getStaffCount(JSONObject jsonObject) {
		String staff_count="";
		try {
			JSONArray includeArray = jsonObject.getJSONArray("included");
			int arraySize = includeArray.length();
			if (arraySize > 0) {
				for (int arrayIndex = 0; arrayIndex < arraySize; arrayIndex++) {
					try {
						JSONObject innerObject = includeArray.getJSONObject(arrayIndex);
						if (isValid(innerObject, "staffCount")) {
							staff_count=innerObject.get("staffCount").toString();
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return staff_count;
	}

	public static String getCompanyUrl(JSONObject jsonObject) {
		String company_url="";
		try {
			JSONArray includeArray = jsonObject.getJSONArray("included");
			int arraySize = includeArray.length();
			if (arraySize > 0) {
				for (int arrayIndex = 0; arrayIndex < arraySize; arrayIndex++) {
					try {
						JSONObject innerObject = includeArray.getJSONObject(arrayIndex);
						if (isValid(innerObject, "companyPageUrl")) {
							company_url=innerObject.get("companyPageUrl").toString();
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return company_url;
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


	public static String getLinkedinCompanyUniqueName(JSONObject jsonObject) {
		String companyUniqueeName="";
		try {
			JSONArray includeArray = jsonObject.getJSONArray("included");
			int arraySize = includeArray.length();
			if (arraySize > 0) {
				for (int arrayIndex = 0; arrayIndex < arraySize; arrayIndex++) {
					try {
						JSONObject innerObject = includeArray.getJSONObject(arrayIndex);
						if (isValid(innerObject, "entityUrn") &&  isValid(innerObject, "companyPageUrl")) {
							String lnkCompanyIdText = innerObject .get("entityUrn").toString().replace( "urn:li:fs_normalized_company:", "").trim();
							if (isValid(innerObject, "universalName")) {
								String uniqueName = innerObject.get("universalName").toString() .trim();
								if (lnkCompanyIdText != null &&lnkCompanyIdText != "" && uniqueName != null &&uniqueName != "") {
									companyUniqueeName=uniqueName.toString();
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
		return companyUniqueeName;
	}



}

import java.io.File;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class LinkedInAboutUsPage1 {

	public static void main(String[] args) throws IOException {
		Document document = null;
		String website = null;
		String industry = null;
		String company_size = null;
		String company_size1 = null;
		String headquarters = null;
		String type = null;
		String founded = null;
		// String specialities = null;
		String overview = null;
		int count = 1;

		File fullFileName = new File("C:\\Users\\oppeddamadthala\\Desktop\\HST Pathways_ About _ LinkedIn.html");
		// read the content from file
		document = Jsoup.parse(fullFileName, "UTF-8");

		Elements div_elements = document.select("div");
		if (div_elements != null && div_elements.size() > 0) {
			for (Element element : div_elements) {
				try {
					if (element.hasAttr("class") && element.attr("class")
							.equals("org-top-card-summary__info-item org-top-card-summary__industry")) {
						System.out.println("Industry: " + element.text());
					}
					if (element.hasAttr("class") && element.attr("class")
							.equals("org-top-card-summary__info-item org-top-card-summary__follower-count")) {
						System.out.println("Followers: " + element.text().replace("followers", "").replace(",", ""));
					}
				} catch (Exception ex) {

				}
			}
		}

		Elements image_elements = document.select("img");
		if (image_elements != null && image_elements.size() > 0) {
			for (Element element : image_elements) {
				try {
					if (element.hasAttr("class") && element.hasAttr("src") && element.attr("class")
							.equals("org-top-card-primary-content__logo Elevation-0dp lazy-image loaded ember-view")) {
						System.out.println("Logo: " + element.attr("src"));
						String destinationFile = "C:\\Satyam\\linkedin_about_us_pages\\logos\\image.jpg";
						saveImage(element.attr("src"), destinationFile);
					}
				} catch (Exception ex) {

				}
			}
		}

		// process the jsoup response
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
											// System.out.println("---------------------------------------");
											// First Object
											JSONObject innerObject = includeArray.getJSONObject(arrayIndex);
											// company id and followers count
											/*
											 * String pattern =
											 * innerObject.get("entityUrn").
											 * toString(); if (pattern.contains(
											 * "urn:li:fs_followingInfo:urn:li:company:"
											 * )) { System.out.println(
											 * "Company ID:" +
											 * innerObject.get("entityUrn").
											 * toString().replace(
											 * "urn:li:fs_followingInfo:urn:li:company:",
											 * "")); System.out.println(
											 * "Follower Count:" +
											 * innerObject.get("followerCount").
											 * toString()); } if
											 * (pattern.contains(
											 * "urn:li:fs_industry:")) {
											 * System.out.println( "Industry:" +
											 * innerObject.get("localizedName").
											 * toString()); } if
											 * (isValid(innerObject,
											 * "companyPageUrl")) {
											 * System.out.println(
											 * "companyPageUrl: " +
											 * innerObject.get("companyPageUrl")
											 * .toString()); }
											 */
											if (isValid(innerObject, "companyPageUrl")) {
												System.out.println("companyPageUrl: "
														+ innerObject.get("companyPageUrl").toString());
											}
											// staff count
											if (isValid(innerObject, "staffCount")) {
												System.out.println(
														"staffCount: " + innerObject.get("staffCount").toString());
											}
											// description
											if (isValid(innerObject, "description")
													&& isValid(innerObject, "companyPageUrl")) {
												System.out.println(
														"description: " + innerObject.get("description").toString());
											}
											// company ID
											if (isValid(innerObject, "entityUrn")
													&& isValid(innerObject, "companyPageUrl")) {
												System.out.println("Company ID: " + innerObject.get("entityUrn")
														.toString().replace("urn:li:fs_normalized_company:", ""));
											}

											// size range
											if (isValid(innerObject, "staffCountRange")) {
												JSONObject staffCountRangeObject = (JSONObject) innerObject
														.getJSONObject("staffCountRange");
												if (isValid(staffCountRangeObject, "start")) {
													System.out.println(
															"start: " + staffCountRangeObject.get("start").toString());
												}
												if (isValid(staffCountRangeObject, "end")) {
													System.out.println(
															"end: " + staffCountRangeObject.get("end").toString());
												}
											}
											// company type
											if (isValid(innerObject, "companyType")) {
												JSONObject companyTypeObject = (JSONObject) innerObject
														.getJSONObject("companyType");
												if (isValid(companyTypeObject, "localizedName")) {
													System.out.println("Company Type: "
															+ companyTypeObject.get("localizedName").toString());
												}
											}
											// founded on
											if (isValid(innerObject, "foundedOn")) {
												JSONObject foundedOnObject = (JSONObject) innerObject
														.getJSONObject("foundedOn");
												if (isValid(foundedOnObject, "year")) {
													System.out.println(
															"Founded On:" + foundedOnObject.get("year").toString());
												}
											}
											// headquatters
											if (isValid(innerObject, "headquarter")) {
												JSONObject headquarterObject = (JSONObject) innerObject
														.getJSONObject("headquarter");
												if (isValid(headquarterObject, "country")) {
													System.out.println(
															"country: " + headquarterObject.get("country").toString());
												}
												if (isValid(headquarterObject, "geographicArea")) {
													System.out.println("geographicArea: "
															+ headquarterObject.get("geographicArea").toString());
												}
												if (isValid(headquarterObject, "city")) {
													System.out.println(
															"city: " + headquarterObject.get("city").toString());
												}
												if (isValid(headquarterObject, "postalCode")) {
													System.out.println("postalCode: "
															+ headquarterObject.get("postalCode").toString());
												}
												if (isValid(headquarterObject, "line1")) {
													System.out.println(
															"line1: " + headquarterObject.get("line1").toString());
												}
												if (isValid(headquarterObject, "line2")) {
													System.out.println(
															"line2: " + headquarterObject.get("line2").toString());
												}
											}
											// specialities
											if (isValid(innerObject, "specialities")) {
												JSONArray specialitiesArray = innerObject.getJSONArray("specialities");
												if (specialitiesArray.length() > 0) {
													String specialities = null;
													for (int index = 0; index < specialitiesArray.length(); index++) {
														specialities = specialities + ", "
																+ specialitiesArray.getString(index);
													}
													System.out.println(
															"specialities:" + specialities.replace("null,", "").trim());
												}
											}
											// System.out.println("---------------------------------------");
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

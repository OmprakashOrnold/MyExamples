package com.aldrich.companyaddress;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.aldrich.pase.util.FormatUrl;
import com.aldrich.pase.util.StringUtil;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class ExtractAddressUsingGeoCoding {

	public static void main(String[] args) {

		String regex = "[#]?\\d{1,5}([A-Za-z0-9\\-\\/\\,\\s\\']*)([ ][\\d])[ -]*?([\\d])[ -]*?([\\d])[ -]*?([\\d])[ -]*?([\\d])[ -]*?([\\d{6}])";
		Pattern pattern = Pattern.compile(regex);

		List<String> url = new ArrayList<String>();

		String address_pattern = "(contact-us|contact us|contact-us.html|contact|about|support|locations)+";

		url.add("https://www.suntecgroup.com/contact-us/");
		





		for (String companyUrl : url) {
			try {
				getIndianAddress(pattern, address_pattern, companyUrl);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}


	public static void getIndianAddress(Pattern pattern, String address_pattern, String companyUrl) {
		String address = null;
		try {
			Document document = getURLResponse(companyUrl.trim());
			if (document != null) {

				Elements elements1 = Jsoup.parse(document.toString()).getElementsMatchingOwnText(pattern);
				for (Element element : elements1) {
					try {
						Matcher matcher = pattern.matcher(element.text());
						if (matcher.find()) {
							address = element.text();
						}
						if(address!=null&&!address.isEmpty())
						{
							if (!address.toLowerCase().contains("img height=")) {
								if (!address.toLowerCase().contains("name")) {
									if (!address.toLowerCase().startsWith("contact us")) {
										if (!address.toLowerCase().startsWith("+")) {
											if (!address.toLowerCase().contains("telephone:")) {
												if (!address.toLowerCase().contains("(toll free)")
														|| !address.toLowerCase().contains("toll free")) {
													boolean isNumeric = false;
													if (isNumeric == false) {
														String new_address = null;														
														new_address = address.replace("All Rights Reserved", "")
																.replace("Contact Us", "").replace("©", "");

														if(new_address.length()>30)
														{
															String zipcode=getINZipcode(new_address);
															String indeianAddress=getIndianAddress(zipcode,new_address);																
															if(indeianAddress!=null&&!indeianAddress.isEmpty())
															{
																getIndianCityStateCountryFromZipcode(getINZipcode(indeianAddress),indeianAddress);
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				Elements contactlink = document.getElementsByAttributeValueMatching("href", address_pattern);
				for (Element contactlinks : contactlink) {
					if (contactlinks != null) {
						if (contactlinks.hasAttr("href")) {
							String contactPages = contactlinks.attr("abs:href");
							if (!contactPages.contains("wp-content")) {
								Document document_new = getURLResponse(contactPages);
								if (document_new != null) {
									Elements eleme1 = Jsoup.parse(document_new.toString()).getElementsMatchingOwnText(pattern);
									for (Element element : eleme1) {
										try {
											Matcher matcher = pattern.matcher(element.text());
											if (matcher.find()) {
												address = element.text();
											}
											if(address!=null&&!address.isEmpty())
											{
												if (!address.toLowerCase().contains("img height=")) {
													if (!address.toLowerCase().contains("name")) {
														if (!address.toLowerCase().startsWith("contact us")) {
															if (!address.toLowerCase().startsWith("+")) {
																if (!address.toLowerCase().contains("telephone:")) {
																	if (!address.toLowerCase().contains("(toll free)")
																			|| !address.toLowerCase().contains("toll free")) {
																		boolean isNumeric = false;
																		if (isNumeric == false) {
																			String new_address = null;														
																			new_address = address.replace("All Rights Reserved", "")
																					.replace("Contact Us", "").replace("©", "");

																			if(new_address.length()>30)
																			{
																				String zipcode=getINZipcode(new_address);
																				String indeianAddress=getIndianAddress(zipcode,new_address);
																				if(indeianAddress!=null&&!indeianAddress.isEmpty())
																				{
																					getIndianCityStateCountryFromZipcode(getINZipcode(indeianAddress),indeianAddress);
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										} catch (Exception e) {
											e.printStackTrace();
										}
									}
								}
							}
						}
					}
				}




			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static String getIndianAddress(String inZipcode,String new_address) {

		String finalAddress=null;
		try {
			if(!new_address.contains("?")||!new_address.contains("|")||!new_address.contains("+"))
			{
				if(new_address.length()>40)
				{
					finalAddress=new_address.substring(0,new_address.indexOf(inZipcode) )+inZipcode;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}


		return finalAddress;
	}


	public static Document getURLResponse(String url) {
		Document documnet = null;
		try {
			documnet = Jsoup.connect(url)
					.userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:79.0) Gecko/20100101 Firefox/79.0")
					.timeout(100000).ignoreHttpErrors(true).get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return documnet;

	}

	public static String getINZipcode(String addressText) {

		String zipcode=null;
		String zipCodePattern = "([ ][\\d])[ -]*?([\\d])[ -]*?([\\d])[ -]*?([\\d])[ -]*?([\\d])[ -]*?([\\d])";
		if(addressText!=null&&!addressText.isEmpty())
		{

			try {
				Pattern compiled = Pattern.compile(zipCodePattern);
				Matcher matcher = compiled.matcher(addressText);
				if (matcher.find()) {
					zipcode = matcher.group();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return zipcode;
	}


	public static String getUrlResponse( String zipcode) {
		String jsonResponse = null;
		try {

			String search_url = "http://www.postalpincode.in/api/pincode/"+zipcode;

			OkHttpClient client = new OkHttpClient();
			Request request = new Request.Builder().url(search_url).get().addHeader("cache-control", "no-cache")
					.build();
			jsonResponse = client.newCall(request).execute().body().string();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonResponse;
	}

	public boolean isValid(JSONObject jsonObject, String propertyName) {
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

	public static void getIndianCityStateCountryFromZipcode(String zipcode ,String FinalIndainAddress) {
		if(zipcode.trim()!=null&&!zipcode.trim().isEmpty())
		{
			String jsonResponse=getUrlResponse(zipcode.trim());
			if(jsonResponse!=null)
			{
				if (!jsonResponse.contains("Error")){
					JSONObject jsonObject = new JSONObject(jsonResponse);
					if (jsonObject != null && jsonObject.has("PostOffice")) {
						Object obj1 = jsonObject.get("PostOffice");
						if (obj1 != null) {
							if (obj1 instanceof JSONArray) {
								JSONArray array = (JSONArray) obj1;
								if (array.length() > 0) {

									String country=null;
									String state=null;
									String city=null;

									JSONObject json = array.getJSONObject(0);
									if (json.length() > 0) {
										if (json.has("Country")) {
											country = json.get("Country").toString();								
										}
										if (json.has("State")) {
											state = json.get("State").toString();
										}
										if (json.has("Circle")) {
											city = json.get("Circle").toString();

										}
									}
									System.out.println(country);
									System.out.println(state);
									System.out.println(city);
									System.out.println(FinalIndainAddress);
									System.out.println();

								}
							}
						}
					}
				}
			}
		}
	}

}

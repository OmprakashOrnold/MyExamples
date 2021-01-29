package com.aldrich.companyaddress;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.aldrich.pase.util.FormatUrl;
import com.aldrich.pase.util.PASEConstants;
import com.aldrich.pase.util.RegularExpressionUtils;

public class CompanyAddressExtractionMain {
	public static void main(String[] args) {

		String regex = "\\d{1,5}(th|rd|nd)?[ ]?([a-zA-Z0-9!@#$&()-`.+,\\s\\\"\\']*)(([a-zA-Z]){1}([0-9][0-9]|[0-9]|[a-zA-Z][0-9][a-zA-Z]|[a-zA-Z][0-9][0-9]|[a-zA-Z][0-9]){1}([ ])([0-9][a-zA-z][a-zA-z]){1})";

		Pattern pattern = Pattern.compile(regex);

		String address_pattern = "(contact-us|contact us|contact-us.html|contact|about|support)+";
		List<String> addressq = new ArrayList<String>();
		//addressq.add("https://www.ebasetech.com/");
		//https://b2b2c.eu/
		//addressq.add("https://b2b2c.eu/");
		//https://edgefolio.com/ab
		//addressq.add("https://bionic.co.uk/");
		//https://liaisongroup.com
		addressq.add("https://bionic.co.uk/");


		for (String companyUrl : addressq) {
			try {
				Elements elements = null;
				String address = null;
				try {
					Document document = getURLResponse(companyUrl);
					if (document != null) {
						// method 1
						Elements elements1 = Jsoup.parse(document.toString()).getElementsMatchingOwnText(pattern);
						for (Element element : elements1) {
							try {
								Matcher matcher = pattern.matcher(element.text());
								if (matcher.find()) {
									address = element.text();
								}
								if (!address.toLowerCase().contains("img height=")) {
									if (!address.toLowerCase().contains("<img")) {
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
																		.replace("Contact Us", "").replace("©", "").replace("|", "")
																		.replace("-", "").replace("/", "");
																if (new_address != null) {
																
																	System.out.println(new_address);


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
						// second method
						Elements Productlink = document.getElementsByAttributeValueMatching("href", address_pattern);
						for (Element Productlinks : Productlink) {
							if (Productlinks != null) {
								if (Productlinks.hasAttr("href")) {
									String contactlink = Productlinks.attr("abs:href");
									if (!contactlink.contains("wp-content")) {
										Document document_new = getURLResponse(contactlink);
										if (document_new != null) {
											elements = Jsoup.parse(document_new.toString()).getElementsMatchingOwnText(pattern);
											for (Element element : elements) {
												try {
													Matcher matcher = pattern.matcher(element.text());
													if (matcher.find()) {
														address = element.text();
													}
													if (!address.toLowerCase().contains("img height=")) {
														if (!address.toLowerCase().contains("<img")) {
															if (!address.toLowerCase().contains("name")) {
																if (!address.toLowerCase().startsWith("contact us")) {
																	if (!address.toLowerCase().startsWith("+")) {
																		if (!address.toLowerCase().contains("telephone:")) {
																			if (!address.toLowerCase().contains("(toll free)")
																					|| !address.toLowerCase()
																					.contains("toll free")) {
																				boolean isNumeric = false;
																				if (isNumeric == false) {
																					String new_address = null;
																					new_address = address
																							.replace("All Rights Reserved", "")
																							.replace("Contact Us", "")
																							.replace("©", "").replace("|", "")
																							.replace("-", "").replace("/", "");
																					if (new_address != null) {

																						

																						System.out.println(new_address);

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
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void saveLocationCityStateZCountryZip(String address) {
		String pageContent="";
		try {
			// connection
			URL url = new URL(
					"http://api.addresslabs.com/v1/parsed-address?address=" + getLocation(address.trim()).replace(" ", "%20"));
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.connect();
			// taking data from json
			Scanner sc = new Scanner(url.openStream());
			while (sc.hasNext()) {
				pageContent = pageContent + sc.nextLine();
			}
			sc.close();
			JSONObject jsonObject = new JSONObject(pageContent);
			JSONObject deliveryObject = jsonObject.getJSONObject("delivery");
			System.out.println(deliveryObject.get("address_line")+"--"+jsonObject.get("city")+"--"+jsonObject.get("state")+"--"+jsonObject.get("zip"));

		} catch (Exception e) {
			//System.out.println("addresss format is different!!!!!!");
		}
	}

	//System.out.println(deliveryObject.get("address_line")+"--"+jsonObject.get("city")+"--"+jsonObject.get("state")+"--"+jsonObject.get("zip"));


	public static String getLocation(String addressText) {

		String location=null;
		String street = "\\d{1,6}[ ](?:[A-Za-z\\s0-9,\\.#]?)+[ ]?(?:Avenue|Ave|Lane|Roadz|Boulevard|Drive|Street|BLVD|Ave|Dr|Rd|Road|Blvd|AVE|Ln|St|Suite|th|Unit|Dr|floor|Floor|STE|Ste|Lyme|Court|level|NE|SE|Circle|Way|Cir|Redwood|Highway|Hwy|Route|East|West|Broadway|Mission|Tower|StreetRear|Place|Pike|Cynwyd|Pkwy|Expressway|Square|street|Room|Ct|Parkway|Pablo|Turnpike|Arques|Real|rd|BOX|Box|Building|BIN|So)\\,?\\.?[ ]?([\\#\\d{1,3}])?([A-Z]\\.)?([\\#[A-Z]])?[ ]?([A-Z]\\.)?([A-Za-z\\s]+)?[,]?[ ]?([A-Z]?\\d{1,3}[A-Z])?([A-z]?\\d{1,3})?\\,?[ ]?(\\#?\\d{1,3})?(\\#?\\d{1,3}[A-Z])?\\,?[ ]?([A-Z]\\.)?([A-Za-z\\s]+)?[,]?[ ]?([A-Za-z\\s]+)?[,]?[ ]?[\\.]?[ ]?(?:[ABCEGHJKLMNPRSTVXY]\\d[ABCEGHJKLMNPRSTVWXYZ][ ]?\\d[ABCEGHJKLMNPRSTVWXYZ]\\d";
		try {
			Pattern compiled = Pattern.compile(street);
			Matcher matcher = compiled.matcher(addressText);
			if (matcher.find()) {
				location = matcher.group();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return location;
	}

	public static String getCALocation(String addressText) {

		String location=null;
		String street = "\\d{1,6}[ ](?:[A-Za-z\\s0-9,\\.#]?)+[ ]?(?:Avenue|Ave|Lane|Roadz|Boulevard|Drive|Street|BLVD|Ave|Dr|Rd|Road|Blvd|AVE|Ln|St|Suite|th|Unit|Dr|floor|Floor|STE|Ste|Lyme|Court|level|NE|SE|Circle|Way|Cir|Redwood|Highway|Hwy|Route|East|West|Broadway|Mission|Tower|StreetRear|Place|Pike|Cynwyd|Pkwy|Expressway|Square|street|Room|Ct|Parkway|Pablo|Turnpike|Arques|Real|rd|BOX|Box|Building|BIN|So)\\,?\\.?[ ]?([\\#\\d{1,3}])?([A-Z]\\.)?([\\#[A-Z]])?[ ]?([A-Z]\\.)?([A-Za-z\\s]+)?[,]?[ ]?([A-Z]?\\d{1,3}[A-Z])?([A-z]?\\d{1,3})?\\,?[ ]?(\\#?\\d{1,3})?(\\#?\\d{1,3}[A-Z])?\\,?[ ]?([A-Z]\\.)?([A-Za-z\\s]+)?[,]?[ ]?([A-Za-z\\s]+)?[,]?[ ]?[\\.]?[ ]?(?:[ABCEGHJKLMNPRSTVXY]\\d[ABCEGHJKLMNPRSTVWXYZ][ ]?\\d[ABCEGHJKLMNPRSTVWXYZ]\\d)";
		try {

			Matcher matcher = RegularExpressionUtils.createMatcherWithTimeout(addressText, street, 1000);
			if (matcher.find()) {
				location = matcher.group(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return location;
	}


	public static String getUKZipcode(String addressText) {

		String zipcode=null;
		String zipCodePattern = "([a-zA-Z]){1}([0-9][0-9]|[0-9]|[a-zA-Z][0-9][a-zA-Z]|[a-zA-Z][0-9][0-9]|[a-zA-Z][0-9]){1}([ ])([0-9][a-zA-z][a-zA-z]){1}";
		try {
			Pattern compiled = Pattern.compile(zipCodePattern);
			Matcher matcher = compiled.matcher(addressText);
			if (matcher.find()) {
				zipcode = matcher.group(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return zipcode;
	}


	public static String getLocationBssedonZipcode(String zipcode,String address) {

		String location=null;
		try{

			Integer endInde =address.indexOf(zipcode);
			//ystem.out.println(endInde);
			if(address.length()>0)
			{
				System.out.println(address.length());
				int startInde=endInde-100;

				location=address.substring(startInde, endInde)+zipcode;

			}


		} catch (Exception e) {
			e.printStackTrace();
		}
		return location;
	}
	public static Document getURLResponse(String url) {
		Document document = null;
		try {
			document = Jsoup.connect(url).followRedirects(true).userAgent(PASEConstants.USER_AGENT).ignoreHttpErrors(true).timeout(0).get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return document;
	}

	public static Integer countChar(String string) {

		int count = 0;

		// Counts each character except space
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) != ' ')
				count++;
		}
		return count;
	}

	public static int wordcount(String string) {
		int count = 0;

		char ch[] = new char[string.length()];
		for (int i = 0; i < string.length(); i++) {
			ch[i] = string.charAt(i);
			if (((i > 0) && (ch[i] != ' ') && (ch[i - 1] == ' ')) || ((ch[0] != ' ') && (i == 0)))
				count++;
		}
		return count;
	}
}

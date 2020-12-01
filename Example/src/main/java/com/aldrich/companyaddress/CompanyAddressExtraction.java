package com.aldrich.companyaddress;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.aldrich.pase.util.FormatUrl;
import com.aldrich.pase.util.RegularExpressionUtils;

public class CompanyAddressExtraction {
	public static void main(String[] args) {

		String regex = "(\\d{1,})[ ]?[a-zA-Z0-9.,\\s]+(\\.)?[ ]?[a-zA-Z]+(\\,)?[ ]?[A-Z]{2}[ ]?[0-9]{5,6}|[0-9]{5}(?:-[0-9]{4})?+";
		Pattern pattern = Pattern.compile(regex);

		String addressReq=null;

		String address_patt = "(contact-us|contact us|contact-us.html|contact|about|support)+";
		Pattern address_pattern = Pattern.compile(address_patt);

		List<String> urls = new ArrayList<String>();
		urls.add("	http://www.tmgfinancialservices.com	");
		urls.add("	https://www.joepulizzi.com/	");
		urls.add("	https://www.alliedwallet.com/	");
		urls.add("	http://www.prudentitinc.com/	");
		urls.add("	http://www.archoninfosys.com	");
		urls.add("	https://www.callingmart.com/	");
		urls.add("	http://www.assurancefa.com	");
		urls.add("	http://www.vistaimagingservices.com	");
		urls.add("	http://keepcalling.net/	");
		urls.add("	https://www.efwnow.com/	");
		urls.add("	https://kellermortgage.com/	");
		urls.add("	https://www.verusboc.com/	");
		urls.add("	https://crescendrf.com/	");
		urls.add("	https://nlogic.com/	");
		urls.add("	http://utilipath.com	");
		urls.add("	http://Aribex.com	");
		urls.add("	http://www.wcslending.com	");
		urls.add("	http://www.expertsit.com	");
		urls.add("	https://www.ifgsd.com/	");
		urls.add("	http://www.bristleconeadvisors.com	");
		urls.add("	http://www.intrustgroup.com	");
		urls.add("	https://www.rtsav.com/	");
		urls.add("	https://www.asset-security-pro.com/	");
		urls.add("	https://saw-grass.com/	");
		urls.add("	https://www.sentryprotectsyou.com/	");
		urls.add("	http://www.technosecure.com	");
		urls.add("	http://www.uscarrier.com	");
		urls.add("	https://www.inboxdollars.com/	");
		urls.add("	blogspot.com	");
		urls.add("	symptomfind.com	");
		urls.add("	prevention.com	");
		urls.add("	canon.com	");
		urls.add("	logmein.com	");
		urls.add("	informars.com	");
		urls.add("	rightdiagnosis.com	");
		urls.add("	jstor.org	");
		urls.add("	self.com	");
		urls.add("	helprx.info	");
		urls.add("	fitpregnancy.com	");
		urls.add("	digitalpoint.com	");
		urls.add("	uk.com	");
		urls.add("	healingwell.com	");
		urls.add("	lifestylelift.com	");
		urls.add("	askdrsears.com	");
		urls.add("	https://www.brighthub.com/	");
		urls.add("	websitetoolbox.com	");
		urls.add("	https://corp.viewbix.com/	");
		urls.add("	momtastic.com	");
		urls.add("	healthaliciousness.com	");
		urls.add("	md-health.com	");
		urls.add("	https://wego.here.com/traffic	");
		urls.add("	padiact.com	");
		urls.add("	justcloud.com	");
		urls.add("	patientfusion.com	");
		urls.add("	http://www.wayport.net	");
		urls.add("	http://www.pandodaily.com	");
		urls.add("	omeda.com	");
		urls.add("	talentedk12.com	");
		urls.add("	wepay.com	");
		urls.add("	auctionflex.com	");
		urls.add("	rrd.com	");
		urls.add("	axill.com	");
		urls.add("	https://www.wirewax.com/	");
		urls.add("	wellnessmama.com	");
		urls.add("	freeadvice.com	");
		urls.add("	https://www.mojopages.com/san-diego-ca	");
		urls.add("	https://tennischanneleverywhere.com/	");
		urls.add("	userreport.com	");
		urls.add("	followmyhealth.com	");
		urls.add("	endocrineweb.com	");
		urls.add("	ticketplatform.com	");
		urls.add("	123contactform.com	");
		urls.add("	https://www.outdoorhub.com/	");
		urls.add("	mommyish.com	");
		urls.add("	diabeticlivingonline.com	");
		urls.add("	sheppardsoftware.com	");
		urls.add("	rodalenews.com	");
		urls.add("	jalbum.net	");
		urls.add("	easylocator.net	");
		urls.add("	yogawiz.com	");
		urls.add("	nsw.gov.au	");
		urls.add("	secure-res.com	");
		urls.add("	cincopa.com	");
		urls.add("	https://www.diy.com/	");
		urls.add("	livezilla.net	");
		urls.add("	https://www.clickdesk.com/	");
		urls.add("	supplementwarehouse.com	");
		urls.add("	hipaaspace.com	");
		urls.add("	citationmachine.net	");
		urls.add("	turn-page.com	");
		urls.add("	forecast.io	");
		urls.add("	weelicious.com	");
		urls.add("	xsplit.com	");
		urls.add("	blipstar.com	");
		urls.add("	clear-reports.com	");
		urls.add("	windsurfercrs.com	");
		urls.add("	internetdrugcoupons.com	");
		urls.add("	fitlife.tv	");
		urls.add("	https://www.plugnpay.com/	");
		urls.add("	https://www.pureorthodontics.ca/	");
		urls.add("	http://www.artifacttechnologies.com	");
		urls.add("	https://www.marcomnewmedia.com/	");



		for (String companyUrl : urls) {
			try {

				Elements elements = null;
				String address = null;
				try {
					Document document = getURLResponse(FormatUrl.formatUrl(companyUrl.trim()));
					if (document != null) {
						// first method 
						address = getHomePageAddress(pattern, address, document);

						// second method
						getContactPageAddress(pattern, address_pattern, address, document);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void getContactPageAddress(Pattern pattern, Pattern address_pattern, String address,Document document) {
		Elements elements;
		Elements Productlink = document.getElementsByAttributeValueMatching("href", address_pattern);
		for (Element Productlinks : Productlink) {
			if (Productlinks != null) {
				if (Productlinks.hasAttr("href")) {
					String contactlink = Productlinks.attr("abs:href");

					Document document_new = getURLResponse(contactlink);
					if (document_new != null) {
						elements = Jsoup.parse(document_new.toString())
								.getElementsMatchingOwnText(pattern);
						for (Element element : elements) {
							try {
								Matcher matcher = pattern.matcher(element.text());
								if (matcher.find()) {
									address = element.text();
								}
								if(address!=null&&!address.isEmpty())
								{
									if (!address.toLowerCase().contains("img src=")) {
										if (!address.toLowerCase().contains("img height=")) {
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
																	System.out.println(getLocation(new_address));
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

	public static String getHomePageAddress(Pattern pattern, String address, Document document) {
		Elements elements1 = Jsoup.parse(document.toString()).getElementsMatchingOwnText(pattern);
		for (Element element : elements1) {
			try {
				Matcher matcher = pattern.matcher(element.text());
				if (matcher.find()) {
					address = element.parent().text();
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
														.replace("Contact Us", "").replace("©", "")
														.replace("|", "").replace("-", "").replace("/", "");

												System.out.println(getLocation(new_address));
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
		return address;
	}

	public static String getCALocation(String addressText) {
		String locationCanada = "";
		String city = "(?:[A-Z][a-z.-]+[ ]?)+";
		String abbrevCA = "AB|BC|MB|N[BLTSU]|ON|PE|QC|SK|YT";
		String stateCA = "Alberta|British[ ]Columbia|Manitoba|New[ ]Brunswick|Newfoundland[ ]and[ ]Labrador|Northwest[ ]Nova[ ]Scotia|Nunavut|Ontario|Quebec|Saskatchewan|Yukon|Prince[ ]Edward[ ]Island";
		String zipcode = "(?!.*[DFIOQU])[A-VXY][0-9][A-Z] ?[0-9][A-Z][0-9]";

		String reg = city + "[,]?[ ]?(" + stateCA + "|" + abbrevCA + ")[,]?[ ]?" + zipcode;
		Pattern compiled = Pattern.compile(reg);
		try {

			Matcher matcher = RegularExpressionUtils.createMatcherWithTimeout(addressText, reg, 0);
			if (matcher.find()) {
				locationCanada = matcher.group();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return locationCanada;
	}

	public static String getLocation(String addressText) {
		
		String location=null;
		String street = "\\d{1,6}[ ](?:[A-Za-z\\s0-9,\\.#]?)+[ ]?(?:Avenue|Ave|Lane|Roadz|Boulevard|Drive|Street|BLVD|Ave|Dr|Rd|Road|Blvd|AVE|Ln|St|Suite|th|Unit|Dr|floor|Floor|STE|Ste|Lyme|Court|level|NE|SE|Circle|Way|Cir|Redwood|Highway|Hwy|Route|East|West|Broadway|Mission|Tower|StreetRear|Place|Pike|Cynwyd|Pkwy|Expressway|Square|street|Room|Ct|Parkway|Pablo|Turnpike|Arques|Real|rd|BOX|Box|Building|BIN|So)\\,?\\.?[ ]?([\\#\\d{1,3}])?([A-Z]\\.)?([\\#[A-Z]])?[ ]?([A-Z]\\.)?([A-Za-z\\s]+)?[,]?[ ]?([A-Z]?\\d{1,3}[A-Z])?([A-z]?\\d{1,3})?\\,?[ ]?(\\#?\\d{1,3})?(\\#?\\d{1,3}[A-Z])?\\,?[ ]?([A-Z]\\.)?([A-Za-z\\s]+)?[,]?[ ]?([A-Za-z\\s]+)?[,]?[ ]?[\\.]?[ ]?\\d{1,5}";
	
		Pattern compiled = Pattern.compile(street);
		try {

			Matcher matcher = RegularExpressionUtils.createMatcherWithTimeout(addressText, compiled, 0);
			if (matcher.find()) {
				location = matcher.group();
			}
		} catch (Exception e) {
			System.out.println("null");
		}
		return location;
	}

	public static String getUKLocation(String addressText) {
		String location = "";
		String zipcode = "A-Z]{1,2}[0-9R][0-9A-Z]? [0-9][ABD-HJLNP-UW-Z]{2}";
		String city = "(?:[A-Z][a-z.-]+[ ]?)+";
		String abbrev = "AL|AK|AS|AZ|AR|CA|CO|CT|DE|DC|FM|FL|GA|GU|HI|ID|IL|IN|IA|KS|KY|LA|ME|MH|MD|MA|MI|MN|MS|MO|MT|NE|N.Y.|NV|NH|NJ|NM|NY|NC|ND|MP|OH|OK|OR|PW|PA|PR|RI|SC|SD|TN|TX|UT|VT|VI|VA|WA|WV|WI|WY";
		String state = "Alabama|Alaska|Arizona|Arkansas|California|Colorado|Connecticut|Delaware|Florida|Georgia|Hawaii|Idaho|Illinois|Indiana|Iowa|Kansas|Kentucky|Louisiana|Maine|Maryland|Massachusetts|Michigan|Minnesota|Mississippi|Missouri|Montana|Nebraska|Nevada|New[ ]Hampshire|New[ ]Jersey|New[ ]Mexico|New[ ]York|North[ ]Carolina|North[ ]Dakota|Ohio|Oklahoma|Oregon|Pennsylvania|Rhode[ ]Island|South[ ]Carolina|South[ ]Dakota|Tennessee|Texas|Utah|Vermont|Virginia|Washington|West[ ]Virginia|Wisconsin|Wyoming";
		String street = "\\d+[ ](?:[A-Za-z\\s0-9.,#]?)+[ ]?(?:[A-Za-z\\s0-9.,#]?)[ ]?(?:[A-Za-z\\s0-9.,#]?)[ ]?(?:[A-Za-z\\s0-9.,#]?)[ ]?(?:Avenue|Lane|Roadz|Boulevard|Drive|Street|Ave|Dr|Rd|Blvd|Ln|St|Suite|th|[0-9]|[a-zA-Z#]?[ ]?)\\.?[ ]?[#]?[ ]?\\d?";
		String reg = street + "[ ]?" + city + "[,]?[ ]?(" + state + "|" + abbrev + ")[,]?[ ]?" + zipcode;
		Pattern compiled = Pattern.compile(reg);
		try {

			Matcher matcher = RegularExpressionUtils.createMatcherWithTimeout(addressText, compiled, 10000);
			if (matcher.find()) {
				location = matcher.group();
			}
		} catch (Exception e) {
			System.out.println("null");
		}
		return location;
	}

	public static Document getURLResponse(String url) {
		Document documnet = null;
		try {
			documnet = Jsoup.connect(url)
					.userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:79.0) Gecko/20100101 Firefox/79.0")
					.timeout(100000).ignoreHttpErrors(true).get();
		} catch (Exception e) {
			//e.printStackTrace();
		}
		return documnet;


	}
}

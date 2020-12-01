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
import com.aldrich.pase.util.StringUtil;

public class ExtractAddressUsingGeoCoding {

	public static void main(String[] args) {
		
		String regex = "(\\d{1,})[ ]?[a-zA-Z0-9.,\\s]+(\\.)?[ ]?[a-zA-Z]+(\\,)?[ ]?[A-Z]{2}[ ]?[0-9]{5,6}|[0-9]{5}(?:-[0-9]{4})?+";
		Pattern pattern = Pattern.compile(regex);

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

																System.out.println(StringUtil.removeSpecialCharacters(new_address) );
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
				} catch (Exception e) {
					e.printStackTrace();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
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

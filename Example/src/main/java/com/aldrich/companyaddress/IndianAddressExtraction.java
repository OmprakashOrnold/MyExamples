package com.aldrich.companyaddress;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.aldrich.pase.util.PASEConstants;

public class IndianAddressExtraction {

	//private static String regex = "\\d{1,5}([A-Za-z\\,\\s\\']+)(([a-zA-Z]){1}([0-9][0-9]|[0-9]|[a-zA-Z][0-9][a-zA-Z]|[a-zA-Z][0-9][0-9]|[a-zA-Z][0-9]){1}([ ])([0-9][a-zA-z][a-zA-z]){1})";
	
	private static String regex = "[#]?\\d{1,5}([A-Za-z0-9\\-\\/\\,\\s\\']*)([ ][\\d])[ -]*?([\\d])[ -]*?([\\d])[ -]*?([\\d])[ -]*?([\\d])[ -]*?([\\d])";
	
	private static Pattern pattern = Pattern.compile(regex);

	private static String address_pattern = "(contact-us|contact us|contact-us.html|contact|about|support|locations)+";


	public static void main(String[] args) {


		List<String> url = new ArrayList<String>();
		
		url.add("	http://www.hosmac.com			");
		url.add("	http://www.inflexiontech.com/			");
		url.add("	http://www.acuminoussoftware.com			");
		url.add("	http://www.lenskart.com			");
		url.add("	http://www.extremewebworld.com			");
		url.add("	http://www.PanIndia.in			");
		url.add("	http://www.thehindu.com			");
		url.add("	http://www.omniglobeinternational.com			");
		url.add("	https://www.pathinfotech.com/			");
		url.add("	http://www.cbsl-india.com			");
		url.add("	http://www.larsentoubro.com/			");
		url.add("	http://www.mbytesbpo.com			");
		url.add("	http://www.gaytescorp.com			");
		url.add("	http://www.mindsprings.com			");
		url.add("	http://www.cynexglobal.com			");
		url.add("	http://www.teamcomputers.com			");
		url.add("	http://www.svpgroup.in			");
		url.add("	http://www.allahabadbank.in			");
		url.add("	http://www.kkavish.com			");
		url.add("	http://www.isaimpex.com			");
		url.add("	https://www.mpslimited.com			");
		url.add("	http://www.satincreditcare.com			");
		url.add("	http://www.igenesys.com/			");
		url.add("	https://www.milessoft.com			");
		url.add("	https://www.shipmile.com			");
		url.add("	http://www.amadasoft.co.in			");
		url.add("	http://www.bitmin.net			");
		url.add("	http://www.prosetta.com			");
		url.add("	http://www.rayonnance.fr			");
		url.add("	https://www.imobdevtech.com			");
		url.add("	http://www.HealthTechIndia.com			");
		url.add("	http://www.tasolglobal.com			");
		url.add("	http://sciter.in/			");
		url.add("	http://www.perflance.com			");
		url.add("	http://www.timesgroup.com			");
		url.add("	http://www.bajajauto.com			");
		url.add("	http://www.hatsun.com			");
		url.add("	http://WWW.CFTRI.COM			");
		url.add("	http://www.murugappa.com			");
		url.add("	http://syndicatebank.in			");
		url.add("	http://www.techdew.com			");
		url.add("	http://www.rossari.com			");
		url.add("	http://www.iitb.ac.in/			");
		url.add("	http://www.icicletech.com			");
		url.add("	http://www.pneumaticsindia.com			");
		url.add("	http://www.teledatain.com			");
		url.add("	http://www.margdarshak.net			");
		url.add("	http://www.addisinfotech.com			");
		url.add("	http://www.inteqsolutions.com/			");
		url.add("	http://www.scanpointgeomatics.com			");
		url.add("	http://www.accusol.com			");
		url.add("	http://www.mas.co.in			");
		url.add("	http://spidergroup.co.in/			");
		url.add("	http://www.prakshal.com			");
		url.add("	http://www.bsnl.co.in			");
		url.add("	http://www.itaction.in			");
		url.add("	http://www.elitecore.com			");
		url.add("	http://www.saraelgi-infinity.com			");
		url.add("	https://www.capitalvia.com/			");
		url.add("	http://www.gnfc.in			");
		url.add("	http://www.pcstech.com			");
		url.add("	http://www.arvind.com			");
		url.add("	http://www.webmasterindia.com			");
		url.add("	http://www.novaspecialtyhospitals.com			");
		url.add("	http://www.apollohospitals.com			");
		url.add("	http://www.conceptinfoway.net/			");
		url.add("	http://www.quovantis.com			");
		url.add("	http://www.ascenten.net			");
		url.add("	http://www.SLTL.com			");
		url.add("	http://www.agileinfoways.com			");


		
		for (String string : url) {
			getIndianAddressFromUrl(string.trim());
		}
		
	}

	public static void getIndianAddressFromUrl(String companyUrl) {

		try {
			Document document = getURLResponse(companyUrl);
			if (document != null) {

				String zipcode=getINZipcode(document.text());
				System.out.println(zipcode);
				getLocationBssedonZipcode(zipcode,document.text());
				if(getLocationBssedonZipcode(zipcode,document.text())!=null){
					String tempAddress=getLocationBssedonZipcode(zipcode,document.text());
					Matcher matcher = pattern.matcher(tempAddress);
					if (matcher.find()) {
						System.out.println(matcher.group());

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
									String zipcode1=getINZipcode(document_new.text());
									String tempAddress=getLocationBssedonZipcode(zipcode1,document_new.text());
									if(tempAddress!=null){
										Matcher matcher1 = pattern.matcher(tempAddress);
										if (matcher1.find()) {
											System.out.println(matcher1.group());

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


	public static String getINZipcode(String addressText) {

		String zipcode=null;
		String zipCodePattern = "([ ][\\d])[ -]*?([\\d])[ -]*?([\\d])[ -]*?([\\d])[ -]*?([\\d])[ -]*?([\\d])";
		try {
			Pattern compiled = Pattern.compile(zipCodePattern);
			Matcher matcher = compiled.matcher(addressText);
			if (matcher.find()) {
				zipcode = matcher.group();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return zipcode;
	}


	public static Document getURLResponse(String url) {
		Document document = null;
		try {
			document = Jsoup.connect(url).followRedirects(true).userAgent(PASEConstants.USER_AGENT).ignoreHttpErrors(true).get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return document;
	}

	public static String getLocationBssedonZipcode(String zipcode,String address) {

		String location=null;

		
		try{		
			if(zipcode!=null&&!zipcode.isEmpty())
			{
				Integer endInde =address.indexOf(zipcode);
				
				if(address.length()>0)
				{

					int startInde=endInde-100;	
					location=address.substring(startInde, endInde)+" "+zipcode;
				}
			}		

		} catch (Exception e) {
			e.printStackTrace();
		}
		return location;
	}


}

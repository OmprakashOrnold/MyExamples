package com.aldrich.companyaddress;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.aldrich.pase.util.PASEConstants;

public class NewIndianAddressExtraction {

	public static void main(String[] args) {

		List<String> url = new ArrayList<String>();
		
		url.add("https://spoors.io/");

		Document document = null;
		for (String string : url) {
			
			document=getURLResponse(string.trim());
			String zipcode=getINZipcode(document.text());
			System.out.println(zipcode);
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
}

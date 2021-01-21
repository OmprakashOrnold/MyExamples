package com.aldrich.companyaddress;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.aldrich.pase.util.PASEConstants;

public class TextZipcodeFinder {

	public static void main(String[] args) {

		Document document = null;
		try {
			document =getURLResponse("https://www.lendable.co.uk/contact");

			//System.out.println(document.text());
			//	System.out.println(getUSINZipcode(document.text()));
			//System.out.println(getLocationBssedonZipcode(getUSINZipcode(document.text()),document.text()));


			List<String> zipcodesList=getUSINZipcode(document.text());
			for (String string : zipcodesList) {

				if(getLocationBssedonZipcode(getUSINSZipcode(string),document.text()).length()>20)
				{
					System.out.println(getLocationBssedonZipcode(getUSINSZipcode(string),document.text()));
				}

			}


		} catch (Exception e) {
			e.printStackTrace();
		}


	}

	public static String getLocationBssedonZipcode(String zipcode,String address) {

		String location=null;
		try{			
			Integer endInde =address.indexOf(zipcode);
			if(address.length()>0)
			{
				int startInde=endInde-80;			
				location=address.substring(startInde, endInde).trim();	
				String str = location.replaceAll("[^-?0-9]+", " ").trim(); 
				if(str.length()>0)
				{
					location=location.substring(location.indexOf(str.charAt(0)))+" "+zipcode;
				}

			}		

		} catch (Exception e) {
			e.printStackTrace();
		}
		return location;
	}

	public static List<String>  getUSINZipcode(String addressText) {

		List<String> zipcodesList=new ArrayList<String>();
		String zipcode=null;
		int count = 0;
		String zipCodePattern = "\\d{5,6}(?:[-\\s]\\d{4})?";
		try {
			Pattern compiled = Pattern.compile(zipCodePattern);
			Matcher matcher = compiled.matcher(addressText);
			while (matcher.find()) {
				zipcode = matcher.group();
				zipcodesList.add(zipcode);				
			}


		} catch (Exception e) {
			e.printStackTrace();
		}
		return zipcodesList;
	}


	public static String  getUSINSZipcode(String addressText) {

		String zipcode=null;
		String zipCodePattern = "\\d{5,6}(?:[-\\s]\\d{4})?";
		try {
			Pattern compiled = Pattern.compile(zipCodePattern);
			Matcher matcher = compiled.matcher(addressText);
			while (matcher.find()) {
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
			document = Jsoup.connect(url).followRedirects(true).userAgent(PASEConstants.USER_AGENT).ignoreHttpErrors(true).timeout(0).get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return document;
	}

}

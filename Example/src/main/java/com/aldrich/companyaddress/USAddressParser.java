package com.aldrich.companyaddress;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.JSONObject;

public class USAddressParser {

	public static void main(String[] args) {

		List<String> adrs=new ArrayList<String>();
		adrs.add("5th Floor, Plot No ITC 2 IT Park, Sector 67 Mohali PB 160062 India");


		for (String address : adrs) {
			saveLocationCityStateZCountryZip(address);	
		}
	}

	public static void saveLocationCityStateZCountryZip(String address) {
		String pageContent="";
		try {
			//connection 
			URL url = new URL("http://api.addresslabs.com/v1/parsed-address?address="+address.trim().replace(" ", "%20"));
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("POST");
			conn.connect();
			//taking data from json
			Scanner sc = new Scanner(url.openStream());
			while(sc.hasNext())
			{
				pageContent=pageContent+sc.nextLine();
			}
			sc.close();
			JSONObject jsonObject = new JSONObject(pageContent);
			JSONObject deliveryObject = jsonObject.getJSONObject("delivery");
			System.out.println(deliveryObject.get("address_line")+"--"+jsonObject.get("city")+"--"+jsonObject.get("state")+"--"+jsonObject.get("zip"));

			
		} catch (Exception e) {
			System.out.println("addresss format is different!!!!!!");
		}
	}

}

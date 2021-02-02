package com.aldrich.companyaddress;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.JSONObject;

public class getCityStateCountryUsinfgZipCode {

	public static void main(String[] args) {
		
		String zipcpde="NN29 7PA";
		String state=null;
		String city=null;
		try {
			JSONObject jsonObject = readJsonFromUrl("http://api.postcodes.io/postcodes/"+zipcpde.trim().replace(" ", "%20").trim().toString());
			JSONObject resultObject = jsonObject.getJSONObject("result");
			if (resultObject != null&& resultObject.has("country")) 
			{
				if (isValid(resultObject, "country")) 
				{
					state=resultObject.get("country").toString();
					System.out.println(state);
				}
				
				if (isValid(resultObject, "admin_district")) 
				{
					city=resultObject.get("admin_district").toString();
					System.out.println(city);
				}
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

	public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
		JSONObject json = null;
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			json = new JSONObject(jsonText);
			return json;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return json;
	}
	
	public static boolean isValid(JSONObject jsonObject, String propertyName) {
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
}

package com.aldrich.companyaddress;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class GetCityStateCountryUsingZipcode {

	public static void main(String[] args) {
		
		String zipcode="503003";
		getCityStateCountryFromZipcode(zipcode);
	}

	public static void getCityStateCountryFromZipcode(String zipcode) {
		String jsonResponse=getUrlResponse(zipcode);
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
									System.out.println(country);
								}
								if (json.has("State")) {
									state = json.get("State").toString();
									System.out.println(state);
								}
								if (json.has("District")) {
									city = json.get("District").toString();
									System.out.println(city);
								}
							}

						}
					}
				}
			}				
		}
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
}

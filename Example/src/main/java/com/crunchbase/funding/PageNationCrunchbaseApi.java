package com.crunchbase.funding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONArray;
import org.json.JSONObject;

import com.aldrich.pase.util.PASEConstants;

public class PageNationCrunchbaseApi {

	private static String CRUNCHBASE_KEY="&user_key=3dea39a0297318708ef02c05b3fe393b";
	private static String CRUNCHBASE_BASE_URL="https://api.crunchbase.com/api/v4/entities/organizations/";

	public static void main(String[] args) {

		String companyName="wyre";
		String cardName="funding_total";

		String url=CRUNCHBASE_BASE_URL+companyName+"/cards/"+cardName+"?"+CRUNCHBASE_KEY;
		processUrlAndCardName(url,cardName,companyName);
	}

	public static boolean processUrlAndCardName(String url,String cardName,String companyName) {
		boolean valid = false;
		String	UUID=null;
		try {
			JSONObject json = getURLResponseAsJSON(url);
			if (json.has("cards")) {
				JSONObject cards = (JSONObject) json.get("cards");

				JSONArray arrayItems = cards.getJSONArray(cardName);
				arrayItems = cards.getJSONArray(cardName);
				int arraySize = arrayItems.length();

				if (arraySize > 0)
				{				
					UUID = arrayIterate(arrayItems, arraySize);

					pageNationIterate(UUID,cardName,companyName);
				}	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return valid;
	}

	public static boolean pageNationIterate(String UUID,String cardName,String companyName) {
		boolean valid = false;
		try{
			String url=CRUNCHBASE_BASE_URL+companyName+"/cards/"+cardName+"?after_id="+UUID+"&"+CRUNCHBASE_KEY;
			if(url!=null&&!url.isEmpty())
			{
				processUrlAndCardName(url,cardName,companyName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return valid;

	}

	public static String arrayIterate(JSONArray arrayItems, int arraySize) {
		String UUID=null;
		for (int arrayIndex = 0; arrayIndex < arraySize; arrayIndex++) {
			try {
				JSONObject innerJsonObject = arrayItems.getJSONObject(arrayIndex);
				if(isValid(innerJsonObject,"identifier"))
				{
					JSONObject uuidObject =(JSONObject) innerJsonObject.get("identifier");	
					if (uuidObject != null&& uuidObject.has("uuid")) {
						if (isValid(uuidObject, "uuid")) 
						{
							UUID= uuidObject.get("uuid").toString();
							printUUID(UUID);
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return UUID;
	}


	public static void printUUID(String UUID) {
		System.out.println(UUID);

	}

	public static boolean isValid(JSONObject jsonObject, String propertyName) {
		boolean valid = false;
		if (propertyName != null) {
			if (jsonObject.has(propertyName) && !jsonObject.get(propertyName).toString().equalsIgnoreCase("null")
					&& !jsonObject.get(propertyName).toString().equalsIgnoreCase(""))
				valid = true;
		}
		return valid;
	}


	public static JSONObject getURLResponseAsJSON(String url) throws MalformedURLException, IOException {
		JSONObject json = null;

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", PASEConstants.USER_AGENT);
		InputStream is = con.getInputStream();


		BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
		String jsonText = readAll(rd);
		json = new JSONObject(jsonText);
		return json;
	}

	public static  String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

}

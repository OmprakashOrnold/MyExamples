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

public class FundingIndex {


	public static void main(String[] args) {

		String companyName="facebook";
		String crunchbase_key="&user_key=3dea39a0297318708ef02c05b3fe393b";
		String url="https://api.crunchbase.com/api/v4/entities/organizations/"+companyName+"/cards/raised_funding_rounds?"+crunchbase_key;



		try {
			JSONObject json = getURLResponseAsJSON(url);
			if (json.has("cards")) {
				JSONObject cards = (JSONObject) json.get("cards");

				JSONArray arrayItems = cards.getJSONArray("raised_funding_rounds");
				arrayItems = cards.getJSONArray("raised_funding_rounds");
				int arraySize = arrayItems.length();

				String UUID=null;

				
				if (arraySize > 0) {
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
										System.out.println(UUID);
									}
								}
							}

							processJSONObject(innerJsonObject);

						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
				
				if(arraySize==100)
				{			
					String url2="https://api.crunchbase.com/api/v4/entities/organizations/"+companyName+"/cards/raised_funding_rounds?"+"after_id="+UUID+crunchbase_key;
					try{

						JSONObject json2 = getURLResponseAsJSON(url2);
						if (json.has("cards")) {
							JSONObject cards2 = (JSONObject) json2.get("cards");

							JSONArray arrayItems22 = cards2.getJSONArray("raised_funding_rounds");
							arrayItems22 = cards.getJSONArray("raised_funding_rounds");
							int arraySize22 = arrayItems22.length();

							String UUID2=null;

							if (arraySize22 > 0) {
								for (int arrayIndex22 = 0; arrayIndex22 < arraySize; arrayIndex22++) {
									try {
										JSONObject innerJsonObject = arrayItems22.getJSONObject(arrayIndex22);
										if(isValid(innerJsonObject,"identifier"))
										{
											JSONObject uuidObject =(JSONObject) innerJsonObject.get("identifier");	
											if (uuidObject != null&& uuidObject.has("uuid")) {
												if (isValid(uuidObject, "uuid")) 
												{
													UUID2= uuidObject.get("uuid").toString();
													System.out.println(UUID2);
												}
											}
										}

										processJSONObject(innerJsonObject);

									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							}
						}
					}catch(Exception e){
						e.printStackTrace();
					}
				}

			
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}



	public static void processJSONObject(JSONObject innerJsonObject) {
		if (innerJsonObject != null&& innerJsonObject.has("investment_type")) {
			if (isValid(innerJsonObject, "investment_type")) 
			{
				String investmentType= innerJsonObject.get("investment_type").toString();
				System.out.println(investmentType);
			}	
		}



		if (innerJsonObject != null&& innerJsonObject.has("investment_stage")) {
			if (isValid(innerJsonObject, "investment_stage")) 
			{
				String investmentStage= innerJsonObject.get("investment_stage").toString();
				System.out.println(investmentStage);
			}	
		}


		if (innerJsonObject != null&& innerJsonObject.has("announced_on")) {
			if (isValid(innerJsonObject, "announced_on")) 
			{
				String announcedOn= innerJsonObject.get("announced_on").toString();
				System.out.println(announcedOn);
			}	
		}


		//closed_on
		if(isValid(innerJsonObject,"closed_on"))
		{
			JSONObject closedOnObject =(JSONObject) innerJsonObject.get("closed_on");	
			if (closedOnObject != null&& closedOnObject.has("value")) {
				if (isValid(closedOnObject, "value")) 
				{
					String closedOn= closedOnObject.get("value").toString();
					System.out.println(closedOn);
				}
			}
		}

		//money_raised
		if(isValid(innerJsonObject,"money_raised"))
		{
			JSONObject moneyRaisedOnObject =(JSONObject) innerJsonObject.get("money_raised");	
			if (moneyRaisedOnObject != null&& moneyRaisedOnObject.has("value")) {
				if (isValid(moneyRaisedOnObject, "value")) 
				{
					String moneyRaised= moneyRaisedOnObject.get("value").toString();
					System.out.println(moneyRaised);
				}
			}

			if (moneyRaisedOnObject != null&& moneyRaisedOnObject.has("currency")) {
				if (isValid(moneyRaisedOnObject, "currency")) 
				{
					String moneyRaisedCurrencyCode= moneyRaisedOnObject.get("currency").toString();
					System.out.println(moneyRaisedCurrencyCode);
				}
			}

			if (moneyRaisedOnObject != null&& moneyRaisedOnObject.has("value_usd")) {
				if (isValid(moneyRaisedOnObject, "value_usd")) 
				{
					String moneyRaisedUsd= moneyRaisedOnObject.get("value_usd").toString();
					System.out.println(moneyRaisedUsd);
				}
			}
		}

		//target_money_raised
		if(isValid(innerJsonObject,"target_money_raised"))
		{
			JSONObject targetMoneyRaisedOnObject =(JSONObject) innerJsonObject.get("target_money_raised");	
			if (targetMoneyRaisedOnObject != null&& targetMoneyRaisedOnObject.has("value")) {
				if (isValid(targetMoneyRaisedOnObject, "value")) 
				{
					String targetMoneyRaised= targetMoneyRaisedOnObject.get("value").toString();
					System.out.println(targetMoneyRaised);
				}
			}

			if (targetMoneyRaisedOnObject != null&& targetMoneyRaisedOnObject.has("currency")) {
				if (isValid(targetMoneyRaisedOnObject, "currency")) 
				{
					String targetMoneyRaisedCurrencyCode= targetMoneyRaisedOnObject.get("currency").toString();
					System.out.println(targetMoneyRaisedCurrencyCode);
				}
			}

			if (targetMoneyRaisedOnObject != null&& targetMoneyRaisedOnObject.has("value_usd")) {
				if (isValid(targetMoneyRaisedOnObject, "value_usd")) 
				{
					String targetMoneyRaisedValueUSD= targetMoneyRaisedOnObject.get("value_usd").toString();
					System.out.println(targetMoneyRaisedValueUSD);
				}
			}
		}


		if(innerJsonObject.has("investor_identifiers"))
		{
			JSONArray investerArrayItems = innerJsonObject.getJSONArray("investor_identifiers");
			investerArrayItems = innerJsonObject.getJSONArray("investor_identifiers");
			int arraySize2 = investerArrayItems.length();
			if (arraySize2 > 0) {
				String investorUUID= null;
				for (int arrayIndex2 = 0; arrayIndex2 < arraySize2; arrayIndex2++) {
					try {
						JSONObject innerJsonObject2 = investerArrayItems.getJSONObject(arrayIndex2);

						if (innerJsonObject2 != null&& innerJsonObject2.has("uuid")) {
							if (isValid(innerJsonObject2, "uuid")) 
							{
								investorUUID= innerJsonObject2.get("uuid").toString();

							}
						}

						if (innerJsonObject2 != null&& innerJsonObject2.has("entity_def_id")) {
							if (isValid(innerJsonObject2, "entity_def_id")) 
							{
								String entityDef= innerJsonObject2.get("entity_def_id").toString();
								if(entityDef.equals("person"))
								{

									String p_website_url=getPersonWebsiteUrl(investorUUID);

								}
								if(entityDef.equals("organization"))
								{
									String o_website_url=getOrganizationWebsiteUrl(investorUUID);
								}
							}
						}

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}

		System.out.println();
	}



	public static String getOrganizationWebsiteUrl(String investorUUID) {

		String website_url=null;
		try {

			String url="https://api.crunchbase.com/api/v4/entities/organizations/"+investorUUID+"?field_ids=website_url&user_key=3dea39a0297318708ef02c05b3fe393b";
			JSONObject json = getURLResponseAsJSON(url);

			if (json.has("properties")) {
				JSONObject propertiesObj = (JSONObject) json.get("properties");
				if (propertiesObj != null&& propertiesObj.has("website_url")) {
					if (isValid(propertiesObj, "website_url")) 
					{
						website_url= propertiesObj.get("website_url").toString();
						System.out.println(website_url);
					}	
				}
			}


		} catch (Exception e) {
			e.printStackTrace();
		}

		return website_url;		
	}

	public static String getPersonWebsiteUrl(String investorUUID) {
		String website_url=null;
		try {
			String url="https://api.crunchbase.com/api/v4/entities/people/"+investorUUID+"?field_ids=website_url&user_key=3dea39a0297318708ef02c05b3fe393b";
			JSONObject json = getURLResponseAsJSON(url);
			if (json.has("properties")) {
				JSONObject propertiesObj = (JSONObject) json.get("properties");

				if (propertiesObj != null&& propertiesObj.has("website_url")) {
					if (isValid(propertiesObj, "website_url")) 
					{
						website_url= propertiesObj.get("website_url").toString();
						System.out.println(website_url);
					}	
				}
			}



		} catch (Exception e) {
			e.printStackTrace();
		}
		return website_url;	
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

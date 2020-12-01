package com.aldrich.patent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.aldrich.pase.util.JSONUtil;

public class ExtractPatentData {

	public static void main(String[] args) {


		List<String> companies=new ArrayList<String>();

		companies.add("HIGHTOWER");

		for (String string : companies) {

			JSONObject responseObject = null;
			JSONArray data = null;
			Integer totalResults=null;

			String companyName=string.toString().trim().replace(" ", "+");

			String url="https://assignment.uspto.gov/solr/aotw/searchFirst?facet=false&fl=id,displayId,reelNo,frameNo,conveyanceText,patAssigneeName,patAssignorName,inventionTitleFirst,publNumFirst,patNumFirst,corrName,corrAddress1,corrAddress2,corrAddress3,corrAddress4,patAssignorEarliestExDate,patNumSize,applNumSize,publNumSize&hl=true&hl.fl=*&hl.fragsize=999&hl.requireFieldMatch=true&hl.simple.post=%3C%2Fem%3E&hl.simple.pre=%3Cem+class%3D%27high-lighted%27%3E&q=patAssigneeName:%22"+companyName+"%22&rows=25&sort=patAssignorEarliestExDate+desc,+id+desc&start=0&wt=json";

			try {
				JSONObject json = 	readJsonFromUrl(url);

				if (json.has("response"))
					responseObject = (JSONObject) json.get("response");


				totalResults = (Integer) responseObject.get("numFound");
				if(totalResults!=0)
				{
					System.out.println(totalResults+"  "+string.trim());
					if (responseObject != null && responseObject.has("docs"))
						data = responseObject.getJSONArray("docs");
					if (data != null) {

						if (data.length() > 0) {

							for (int filingCount = 0; filingCount < data.length(); filingCount++) {

								try {

									JSONObject jsonObject = data.getJSONObject(filingCount);

									//id
									if (JSONUtil.isValid(jsonObject, "id")) {
									//	System.out.println(jsonObject.get("id"));

									}

									//displayId
									if (JSONUtil.isValid(jsonObject, "displayId")) {
									//	System.out.println(jsonObject.get("displayId"));

									}

									//reelNo
									if (JSONUtil.isValid(jsonObject, "reelNo")) {
									//	System.out.println(jsonObject.get("reelNo"));

									}

									//frameNo
									if (JSONUtil.isValid(jsonObject, "frameNo")) {
									//	System.out.println(jsonObject.get("frameNo"));

									}

									//conveyanceText
									if (JSONUtil.isValid(jsonObject, "conveyanceText")) {
									//	System.out.println(jsonObject.getString("conveyanceText"));

									}

									//corrName
									if (JSONUtil.isValid(jsonObject, "corrName")) {
									//	System.out.println(jsonObject.getString("corrName"));

									}

									//corrAddress1
									if (JSONUtil.isValid(jsonObject, "corrAddress1")) {
									//	System.out.println(jsonObject.getString("corrAddress1"));

									}

									//corrAddress2
									if (JSONUtil.isValid(jsonObject, "corrAddress2")) {
									//	System.out.println(jsonObject.getString("corrAddress2"));

									}

									//corrAddress3
									if (JSONUtil.isValid(jsonObject, "corrAddress3")) {
									//	System.out.println(jsonObject.getString("corrAddress3"));

									}

									//applNumSize
									if (JSONUtil.isValid(jsonObject, "applNumSize")) {
									//	System.out.println(jsonObject.get("applNumSize"));

									}

									//patNumSize
									if (JSONUtil.isValid(jsonObject, "patNumSize")) {
									//	System.out.println(jsonObject.get("patNumSize"));

									}

									//patNumSize
									if (JSONUtil.isValid(jsonObject, "patNumSize")) {
									//	System.out.println(jsonObject.get("patNumSize"));

									}
									
									//patAssignorEarliestExDate
									if (JSONUtil.isValid(jsonObject, "patAssignorEarliestExDate")) {
									//	System.out.println(jsonObject.getString("patAssignorEarliestExDate"));
									}


									//patAssigneeName
									if (JSONUtil.isValid(jsonObject, "patAssigneeName")) {
										JSONArray patAssigneeNameJsonObject = jsonObject.getJSONArray("patAssigneeName");

										int arraySize = patAssigneeNameJsonObject.length();
										if (arraySize > 0) {
											String patAssigneeName=null;
											for (int arrayIndex = 0; arrayIndex < arraySize; arrayIndex++) {
												try { 
												
												} catch (Exception e) {
													e.printStackTrace();
												}
											}
										}									
									}


									//patAssignorName
									
									if (JSONUtil.isValid(jsonObject, "patAssignorName")) {
										JSONArray patAssignorNameJsonObject = jsonObject.getJSONArray("patAssignorName");
										List<String> list=new ArrayList<String>();
										int arraySize = patAssignorNameJsonObject.length();
										if (arraySize > 0) {
											String patAssignorName=null;
											for (int arrayIndex = 0; arrayIndex < arraySize; arrayIndex++) {
												try { 
													patAssignorName=patAssignorNameJsonObject.getString(arrayIndex);
													list.add(patAssignorName);
												} catch (Exception e) {
													e.printStackTrace();
												}
											}
											list.add(patAssignorName);
											String str=list.toString();
											System.out.println(str);
											
											
										}
									}

									//inventionTitleFirst
									if (JSONUtil.isValid(jsonObject, "inventionTitleFirst")) {
									//	System.out.println(jsonObject.getString("inventionTitleFirst"));

									}


									//patNumFirst
									if (JSONUtil.isValid(jsonObject, "patNumFirst")) {
									//	System.out.println(jsonObject.getString("patNumFirst"));

									}

									//publNumFirst
									if (JSONUtil.isValid(jsonObject, "publNumFirst")) {
									//	System.out.println(jsonObject.getString("publNumFirst"));

									}

								}catch(Exception e){
									e.printStackTrace();
								}
							}
						}
					}

				}

			} catch (JSONException | IOException e) {
				e.printStackTrace();
			}
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
		}catch(Exception e){
			e.printStackTrace();
		}
		return json;
	}


}

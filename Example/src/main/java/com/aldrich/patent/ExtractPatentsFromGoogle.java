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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.aldrich.pase.util.JSONUtil;

public class ExtractPatentsFromGoogle {

	public static void main(String[] args) {

		List<String> companies=new ArrayList<String>();
		companies.add("HIGHTOWER");
		companies.add("Shyft Moving");
		companies.add("Nobl");
		companies.add("Nudge");
		companies.add("Opternative");
		companies.add("AnthroTronix");
		companies.add("NeuroTrax");
		companies.add("Grayhair Software");
		companies.add("Splitit");
		companies.add("Uphold");
		companies.add("Iodine Software");
		companies.add("ClairVista");
		
		for (String string : companies) {
			JSONObject resultsObject = null;
			JSONArray data = null;
			Integer totalResults=null;

			String companyName=string.toString().trim().replace(" ", "+");

			String url="https://patents.google.com/xhr/query?url=assignee%3D"+companyName+"&exp=";


			try {
				JSONObject json = 	readJsonFromUrl(url);				
				if (json.has("results"))
				{
					resultsObject = (JSONObject) json.get("results");
					if (JSONUtil.isValid(resultsObject, "cluster")) {
						JSONArray clusterJsonArray = resultsObject.getJSONArray("cluster");
						int arraySize = clusterJsonArray.length();
						if (arraySize > 0) {
							for (int arrayIndex = 0; arrayIndex < arraySize; arrayIndex++) {
								try { 			
									JSONObject	resultsIndexObject=clusterJsonArray.getJSONObject(arrayIndex);
									if (JSONUtil.isValid(resultsIndexObject, "result")) {
										JSONArray resultsObject1 = resultsIndexObject.getJSONArray("result");
										int arraySize1 = resultsObject1.length();
										if (arraySize1 > 0) {
											for (int arrayIndex1 = 0; arrayIndex1 < arraySize1; arrayIndex1++) {
												try { 										
													JSONObject patentIndexJsonObject=resultsObject1.getJSONObject(arrayIndex1);
													if (JSONUtil.isValid(patentIndexJsonObject, "patent")) {
														JSONObject patentJsonObject=patentIndexJsonObject.getJSONObject("patent");
														if (JSONUtil.isValid(patentJsonObject, "snippet")) {
															//System.out.println(patentJsonObject.getString("snippet").toString().trim());
														}
														
														if (JSONUtil.isValid(patentJsonObject, "filing_date")) {
															//System.out.println(patentJsonObject.getString("filing_date").toString().trim());
														}
														
														if (JSONUtil.isValid(patentJsonObject, "title")) {
															//System.out.println(patentJsonObject.getString("title").toString().trim());
														}
														
														//grant_date
														if (JSONUtil.isValid(patentJsonObject, "grant_date")) {
															//System.out.println(patentJsonObject.getString("grant_date").toString().trim());
														}
														
														//priority_date
														if (JSONUtil.isValid(patentJsonObject, "priority_date")) {
															//System.out.println(patentJsonObject.getString("priority_date").toString().trim());
														}
														
														//publication_date
														if (JSONUtil.isValid(patentJsonObject, "publication_date")) {
															//System.out.println(patentJsonObject.getString("publication_date").toString().trim());
														}
														
														//inventor
														if (JSONUtil.isValid(patentJsonObject, "inventor")) {
															//System.out.println(patentJsonObject.getString("inventor").toString().trim());
														}
														
														//publication_number
														if (JSONUtil.isValid(patentJsonObject, "publication_number")) {
															//System.out.println(patentJsonObject.getString("publication_number").toString().trim());
														}
														
														//assignee
														if (JSONUtil.isValid(patentJsonObject, "assignee")) {
															System.out.println(patentJsonObject.getString("assignee").toString().trim());
														}
														
													}

												} catch (Exception e) {
													e.printStackTrace();
												}
											}
										}
									}
								} catch (Exception e) {
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

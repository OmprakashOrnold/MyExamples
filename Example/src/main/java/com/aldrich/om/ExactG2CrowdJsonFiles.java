package com.aldrich.om;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.JSONObject;

public class ExactG2CrowdJsonFiles {

	public static void main(String[] args) {

		String pageContent=null;
		JSONObject json = null;
		try {
			
			json=readJsonFromUrl("https://data.g2.com/api/v1/products?page[number]=1&page[size]=100");
			System.out.println(json.toString());

			
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
		}catch(Exception e){
			e.printStackTrace();
		}
		return json;
	}

}

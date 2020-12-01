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

public class JsonReader {

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


	public static void main(String[] args) throws IOException, JSONException {
		JSONObject json = readJsonFromUrl(" http://api.addresslabs.com/v1/parsed-address?address=2150%20Lake%20Ida%20Rd,%20Suite%206%20Delray%20Beach,%20FL%2033445");
		System.out.println(json.toString());

	}
}
package com.aldrich.om;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class SoftwareData {
	public static void main(String[] args) {
		String resp = "";
		String json = null;
		try {
			OkHttpClient client = new OkHttpClient();
			Request request = new Request.Builder().url(" http://api.addresslabs.com/v1/parsed-address?address=2150%20Lake%20Ida%20Rd,%20Suite%206%20Delray%20Beach,%20FL%2033445").get().addHeader("cache-control", "no-cache")
					.build();
			String response = client.newCall(request).execute().body().string();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

// http://api.addresslabs.com/v1/parsed-address?address=2150%20Lake%20Ida%20Rd,%20Suite%206%20Delray%20Beach,%20FL%2033445

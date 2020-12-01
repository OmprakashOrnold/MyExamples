package com.aldrich.om;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class OkhttpForG2 {


	public static void main(String[] args) {
		Document document = null;

		String companyUrl="https://www.capterra.com/p/"+149492+"/SuperMap-Desktop-GIS/";
		document=getUrlResponse(companyUrl);
		System.out.println(document);
		System.out.println(getUrlResponse(companyUrl));

	}

	public static Document getUrlResponse(String companyUrl) {
		Document document = null;
		try {

			OkHttpClient client = new OkHttpClient();
			Request request = new Request.Builder().url(companyUrl).get().addHeader("cache-control", "no-cache")
					.build();
			String response = client.newCall(request).execute().body().string();
			document = Jsoup.parse(response);
			if (document != null) {

				System.out.println(document);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return document;
	}
}

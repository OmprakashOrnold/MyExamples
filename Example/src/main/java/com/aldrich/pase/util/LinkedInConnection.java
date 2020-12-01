package com.aldrich.pase.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class LinkedInConnection {

	@SuppressWarnings("nls")
	public static void main(String[] args) {

		try {
			String url = "https://www.linkedin.com/company/lavu-inc/insights?trk=top_nav_insights";
			String user_agent = "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:50.0) Gecko/20100101 Firefox/50.0";
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			// optional default is GET
			con.setRequestMethod("GET");
			// add request header
			con.setRequestProperty("User-Agent", user_agent);
			con.setRequestProperty("Cookie",
					"JSESSIONID='ajax:4880328334024904733'; bcookie='v=2&020a57b0-378a-4e99-85a4-4a2be303af95'; bscookie='v=1&2016122107453295f43964-d66b-4fb4-8bbc-c617725fcef9AQH2qtb6kKtaCySqomQdXO_CGrrfqAMU'; visit='v=1&M'; lang='v=2&lang=en-us'; lidc='b=SGST07:g=2:u=1:i=1482500000:t=1482586400:s=AQFNTWP_NmzQ-kb2jxqtu_jLu5lYz6ZD'; wutan=27oh/WHqpZMfKa4TZwh+btKJLaKOXLraNLf1z9MCAj4=; share_setting=PUBLIC; sdsc=1%3A1SZM1shxDNbLt36wZwCgPgvN58iw%3D; RT=s=1482500004800&r=https%3A%2F%2Fwww.linkedin.com%2Fuas%2Flogout%3Fsession_full_logout%3D%26csrfToken%3Dajax%253A8365489368028068521%26trk%3Dnav_account_sub_nav_signout; sl='v=1&G5gHd'; liap=true; li_at=AQEDAQACu9sBDaaHAAABWSvjZdYAAAFZLZrZ1lEAUB3yTozU_FCGrEtEU9O9fIRBTe06QrdUjihEOlPEGk366G5JUvpupM1Vrw7QeLGwWwvCHIHUFK1dlvbC-aA4PELNmfhuT3wM-ifV7-nx7P7PhIZo");
			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			// print result
			System.out.println(response.toString());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

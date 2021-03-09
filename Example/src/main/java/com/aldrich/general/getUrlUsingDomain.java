package com.aldrich.general;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.validator.routines.DomainValidator;

public class getUrlUsingDomain {

	public static void main(String[] args) {
		String domain="lavu.com";
		String url=null;

		String u1="http://"+domain;
		String u2="http://www."+domain;
		String u3="https://"+domain;
		String u4="https://www."+domain;

		try {
			URL url_1=new URL(u1);
			URL url_2=new URL(u2);
			URL url_3=new URL(u3);
			URL url_4 =new URL(u4);

			if(doesURLExist(url_1))
			{
				url=u1;
			}

			if(doesURLExist(url_2))
			{
				url=u2;
			}

			if(doesURLExist(url_3))
			{
				url=u3;
			}

			if(doesURLExist(url_4))
			{
				url=u4;
			}

			System.out.println(url);

		} catch (Exception e) {
			e.printStackTrace();
		}




	}

	public static boolean doesURLExist(URL url) throws IOException
	{
		// We want to check the current URL
		HttpURLConnection.setFollowRedirects(false);

		HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

		// We don't need to get data
		httpURLConnection.setRequestMethod("HEAD");

		// Some websites don't like programmatic access so pretend to be a browser
		httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.0; en-US; rv:1.9.1.2) Gecko/20090729 Firefox/3.5.2 (.NET CLR 3.5.30729)");
		int responseCode = httpURLConnection.getResponseCode();

		// We only accept response code 200
		return responseCode == HttpURLConnection.HTTP_OK;
	}
}

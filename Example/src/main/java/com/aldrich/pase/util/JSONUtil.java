package com.aldrich.pase.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class will provide JSON common utility functionalities...
 * 
 * @author N. Anil Kumar Reddy
 */

public class JSONUtil {

	/**
	 * This method will provide JSON common utility functionalities...
	 * 
	 * @throws IOException,JSONException
	 * @param url
	 * @since 5/27/2016
	 * @return JSONObject
	 * @author N. Anil Kumar Reddy
	 */

	@SuppressWarnings("nls")
	public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			jsonText = jsonText.replace("jQuery110207626547278813666_1461426014245({", "{").replace("})", "}");
			JSONObject json = new JSONObject(jsonText);
			return json;
		} finally {
			is.close();
		}
	}

	/**
	 * This method is meant for providing reading with character stream -
	 * internally utilized by readJsonFromUrl()
	 * 
	 * @param Character
	 *            stream object
	 * 
	 * @throws IOException
	 * @since 5/27/2016
	 * @return JSON in a String format
	 * @author N. Anil Kumar Reddy
	 */

	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

	/**
	 * This method is meant for validating property for a provided JSON Object
	 * 
	 * @param jsonObject,proeprtyName
	 * @since 5/27/2016
	 * @return boolean
	 * @author N. Anil Kumar Reddy
	 */

	public static boolean isValid(JSONObject jsonObject, String propertyName) {
		boolean valid = false;
		if (propertyName != null) {
			if (jsonObject.has(propertyName) && !jsonObject.get(propertyName).toString().equalsIgnoreCase("null")
					&& !jsonObject.get(propertyName).toString().equalsIgnoreCase(""))
				valid = true;
		}
		return valid;
	}

}

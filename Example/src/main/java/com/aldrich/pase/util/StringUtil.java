package com.aldrich.pase.util;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;

public class StringUtil {

	private static final String HTML_PATTERN = "<(\"[^\"]*\"|'[^']*'|[^'\">])*>";

	@SuppressWarnings("nls")
	public static String removeHtmlCodeAndSpecialCharacters(String inputString) {

		String resultString = "";

		if (inputString != null && !inputString.equals("")) {
			resultString = Jsoup.parse(inputString).text();
			Pattern pattern = Pattern.compile(HTML_PATTERN);
			Matcher matcher = pattern.matcher(resultString);
			if (matcher.matches())
				resultString = Jsoup.parse(resultString).text();
			resultString = resultString.replaceAll("[^a-zA-Z0-9\\s]", "");
		}

		return resultString;

	}

	public static String removeSpecialCharacters(String inputString) {
		return inputString.replaceAll("[^a-zA-Z0-9\\s]", "");
	}

	/**
	 * This method will provide tokens of given String for specified delimiter
	 * in the form of String list..
	 * 
	 * @param tokenizableString,delimiter
	 * @since 5/27/2016
	 * @return List<String>
	 * @author N. Anil Kumar Reddy
	 */

	public static List<String> getTokens(String tokenizableString, String delimiter) {
		StringTokenizer tokenizer = new StringTokenizer(tokenizableString, delimiter);
		List<String> tokensList = new ArrayList<String>();
		while (tokenizer.hasMoreElements()) {
			tokensList.add((String) tokenizer.nextElement());
		}
		return tokensList;
	}

	/**
	 * This method will format the company name for jaccard
	 * 
	 * @param companyName
	 * @since 5/27/2016
	 * @return String
	 * @author N. Anil Kumar Reddy
	 */

	public static String getFormattedCompany(String companyName) {

		return companyName.replace(",", "").replace("-", "").replace(";", "").replace(".", "").replace("inc", "")
				.replace("Inc", "").replace("Ltd", "").replace("ltd", "").replace("Pvt", "").replace("pvt", "")
				.replace("llc", "").replace("LLC", "").replace("corporation", "").replace("Corporation", "")
				.replace("Systems", "").replace("systems", "").replace("technologies", "").replace("Technologies", "")
				.trim().toLowerCase();

	}

}

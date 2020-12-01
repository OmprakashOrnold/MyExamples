package com.aldrich.pase.util;

public class FormatAppRatingCount
{
	@SuppressWarnings({ "nls", "boxing" })
	public static Double formatAppRatingCount(String ratingCount)
	{
		try
		{
			String appRatingCount = "";
			appRatingCount = ratingCount.toLowerCase().replace("ratings", "");
			appRatingCount = appRatingCount.replace(" ", "%20");
			appRatingCount = appRatingCount.replace("%20","");																							
			return Double.parseDouble(appRatingCount.trim());
		}
		catch(Exception e)
		{
			e.printStackTrace();					
		}
		return 0.0;
	}
}

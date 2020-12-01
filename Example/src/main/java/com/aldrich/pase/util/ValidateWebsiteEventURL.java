package com.aldrich.pase.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("nls")
public class ValidateWebsiteEventURL
{
	public static boolean validateURL(String eventURL)
	{
		// eventURL = "https:/#";
		final Logger LOGGER = LoggerFactory.getLogger(ValidateWebsiteEventURL.class);
		boolean consider = true;
		try
		{
			if (!eventURL.equals(""))
			{
				String formatURL = eventURL.toLowerCase().replaceAll("http[s]{0,1}:[/]{1,2}", "").replaceAll("www[.]{0,1}", "");
				// formatURL = eventURL.toLowerCase().replace("https://",
				// "").replace("https://", "").replace("www.",
				// "").replaceAll("https:/", "");
				if (!formatURL.equals("") && formatURL.equals("#"))
					consider = false;
			}
		}
		catch (Exception e)
		{
			LOGGER.info("Exception raised - checkURL - CheckWebsiteEventURL" + e.getMessage());
		}

		return consider;
	}
}

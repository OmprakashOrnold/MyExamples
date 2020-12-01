package com.aldrich.pase.util;

public class FormatUrl
{
	@SuppressWarnings(
	{
		"nls"
	})
	public static String formatUrl(String url)
	{
		String formattedUrl = "";
		try
		{
			if (!url.startsWith("https://www.") && !url.startsWith("http://www."))
			{
				if (url.startsWith("//"))
				{
					if (url.contains("www."))
					{
						formattedUrl = url.substring(2, url.length());
						formattedUrl = "http://" + formattedUrl;
					}
					else
					{
						formattedUrl = url.substring(2, url.length());
						formattedUrl = "http://www." + formattedUrl;
					}
				}
				else if (url.startsWith("www."))
				{
					formattedUrl = "http://" + url;
				}
				else if (url.startsWith("ttp://"))
				{
					formattedUrl = "h" + url;
				}
				else if (url.startsWith("htttp://"))
				{
					formattedUrl = url.replace("htttp", "http");
				}
				else if (url.startsWith("httphttp") || url.contains("httphttp"))
				{
					formattedUrl = url.replace("httphttp", "http");
				}
				else if (url.startsWith("httpshttps") || url.contains("httpshttps"))
				{
					formattedUrl = url.replace("httpshttps", "https");
				}
				else if (url.startsWith("wwwwww."))
				{
					formattedUrl = url.replace("wwwwww.", "www.");
				}
				else if (!url.toLowerCase().contains("www."))
				{
					if (url.toLowerCase().contains("http://"))
					{
						formattedUrl = url.toLowerCase().replace("http://", "");
						formattedUrl = "http://www." + formattedUrl;
					}
					else if (url.toLowerCase().contains("https://"))
					{
						formattedUrl = url.toLowerCase().replace("https://", "");
						formattedUrl = "https://www." + formattedUrl;
					}
					else
					{
						formattedUrl = "http://www." + url;
					}
				}
				else
				{
					formattedUrl = "http://www." + url;
				}
			}
			else
			{
				formattedUrl = url;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return formattedUrl;
	}

}

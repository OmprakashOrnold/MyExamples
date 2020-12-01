package com.aldrich.pase.util;

public class FormatDomainName 
{
	@SuppressWarnings("nls")
	public static String formatDomainName(String domain_Name)
	{
		try
		{
			String domainName = "";
			domainName = domain_Name.toLowerCase();			
			domainName = domainName.replace("Solutions", "");
			domainName = domainName.replace("solutions", "");
			domainName = domainName.replace("www.", "");
			domainName = domainName.replace("%20", " ").trim();
			return domainName;
		}
		catch(Exception e)
		{
			e.printStackTrace();					
		}
		return "";		   
	} 
}

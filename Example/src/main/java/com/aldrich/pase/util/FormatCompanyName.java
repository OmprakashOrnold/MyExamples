package com.aldrich.pase.util;

public class FormatCompanyName
{
	@SuppressWarnings("nls")
	public static String formatCompanyName(String company_Name)
	{
		try
		{
			String companyName = "";
			companyName = company_Name;

			companyName = companyName.replace("&amp;", "&").toLowerCase();
			companyName = companyName.replace(",", "");
			companyName = companyName.replace("-", "");
			companyName = companyName.replace(";", "");
			companyName = companyName.replace(".", "");
			companyName = companyName.replace("inc", "");
			companyName = companyName.replace("Inc", "");
			companyName = companyName.replace("Ltd", "");
			companyName = companyName.replace("ltd", "");
			companyName = companyName.replace("Pvt", "");
			companyName = companyName.replace("Pvt", "");
			companyName = companyName.replace("LLC", "");
			companyName = companyName.replace("llc", "");
			companyName = companyName.replace("corporation", "").trim();

			if (companyName.substring(0, 1).equals(" "))
			{
				companyName = companyName.replace(companyName.substring(0, 1), "");
			}
			else if (companyName.substring(companyName.length() - 1).equals(" "))
			{
				companyName = companyName.replace(companyName.substring(companyName.length() - 1), "");
			}
			else
			{
				// do Nothing
			}

			// if(companyName.contains(" "))
			// {
			// companyName = companyName.replace(" ", "%20");
			// }

			return companyName;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return "";
	}

	@SuppressWarnings("nls")
	public static String secondaryFormatCompanyName(String company_Name)
	{
		try
		{
			String companyName = "";
			companyName = company_Name;

			companyName = companyName.replace("Solutions", "");
			companyName = companyName.replace("solutions", "");
			companyName = companyName.replaceAll("%20", " ").trim();
			companyName = companyName.replaceAll("\\s{2}", " ").trim();
			return companyName;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return "";
	}
}

package com.aldrich.om;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class LinkedinEmployeeDetails {

	public static void main(String[] args) {

		Document doc=null;
		Date date=null;
		String name=null;
		String address=null;
		String joiningdate=null;
		String city=null;
		String state=null;
		String country=null;

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		File folder = new File("C:\\Om\\Lavu salesnavigator\\new_Stage_5");
		File[] listOfFiles = folder.listFiles();
		for (File file : listOfFiles) {
			if (file.isFile()) {
				try{
					doc=Jsoup.parse(new File("C:\\Om\\Lavu salesnavigator\\new_Stage_5\\"+file.getName()), "utf-8");

					
					if(doc!=null) 
					{
						String companyArray[]=file.getName().replace(".html", "").split("_");
						String fkCompanyId=companyArray[0];
						String companyName=companyArray[2];


						//System.out.println(companyName);
						Elements nameElement=doc.select("span[class='profile-topcard-person-entity__name Sans-24px-black-90%-bold']");


						name=nameElement.text();
						

						Elements positionElements=doc.select("li[class='profile-position display-flex align-items-flex-start']");


						joiningdate="";
						for (Element positionElement : positionElements) {
							try {
								Elements companyElements=positionElement.select("dd[class='profile-position__secondary-title Sans-14px-black-90% mb1']");

								for (Element companyElement : companyElements) {	
									try {
										if(companyElement.text().replace("Company Name ", "").equalsIgnoreCase(companyName));
										{
											
												
												Elements ddElement=positionElement.getElementsByClass("profile-position__dates-employed fl Sans-12px-black-60%");												
												String []dateArray=ddElement.text().split("�");		
												if(!dateArray[0].isEmpty())
												{
													String dateInString =convertToDate(dateArray[0].replace("Dates Employed", "").replace("�", "").trim());													
													if(dateInString!=null)
													{
														date = formatter.parse(dateInString);
														joiningdate=formatter.format(date);													
													}

													Elements addressElements=positionElement.select("dd[class='profile-position__company-location mb2 Sans-12px-black-60%']");
													for (Element addressElement : addressElements) {
														address=addressElement.text().replace("Location ", "").trim();													
													}
												}		
													
										}
									} catch (Exception e) {
										e.printStackTrace();
									}
								}					
							} catch (Exception e) {
								e.printStackTrace();
							}
						}		

						System.out.println(joiningdate);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}


	public static Date getJoiningDate(Element element) 
	{
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date=null;
		try{
			Elements ddElement=element.getElementsByClass("profile-position__dates-employed fl Sans-12px-black-60%");
			String []dateArray=ddElement.text().split("�");	
			if(!dateArray[0].isEmpty())
			{
				String dateInString =convertToDate(dateArray[0].replace("Dates Employed", "").replace("�", "").trim());
				if(dateInString!=null && !dateInString.isEmpty())
				{
					date = formatter.parse(dateInString);
				}
			}
		}catch(Exception e)
		{
			e.printStackTrace();			
		}
		return date;
	}

	public static Date getEarliestDate(List<Date> dates) {

		if (dates == null || dates.isEmpty())
			return null;

		dates.removeIf(Objects::isNull);

		return dates.isEmpty() ? null : Collections.min(dates);
	}

	public  static String  convertToDate(String str) {

		String date=null;
		int month=0;
		String []dateArray=null;
		if(!str.startsWith("Des"))
		{
			if(str.contains("Jan")||str.contains("Feb")||str.contains("Mar")||str.contains("Apr")||str.contains("May")||str.contains("Jun")||str.contains("Jul")||str.contains("Aug")||str.contains("Sep")||str.contains("Oct")||str.contains("Nov")||str.contains("Dec"))
			{
				dateArray=str.split("\\s");
				if(dateArray[0].equals("Jan"))
				{		
					month=1;		
				}else if(dateArray[0].equals("Feb")){

					month=02;	
				}else if(dateArray[0].equals("Mar")){

					month=03;	
				}else if(dateArray[0].equals("Apr")){

					month=04;	
				}else if(dateArray[0].equals("May")){

					month=05;	
				}else if(dateArray[0].equals("Jun")){

					month=06;	
				}else if(dateArray[0].equals("Jul")){

					month=07;
				}else if(dateArray[0].equals("Aug")){

					month=8;
				}else if(dateArray[0].equals("Sep")){

					month=9;
				}else if(dateArray[0].equals("Oct")){

					month=10;
				}else if(dateArray[0].equals("Nov")){

					month=11;
				}else if(dateArray[0].equals("Dec")){

					month=12;
				}
				date="01/"+month+"/"+dateArray[1];
			}else{
				date="1/"+"01/"+str;
			}
		}else{
			System.out.println();
		}
		return date;
	}

	public static int countChar(String str, char x) 
	{ 
		int count = 0; 
		int n = 10; 
		for (int i = 0; i < str.length(); i++) 
			if (str.charAt(i) == x) 
				count++; 

		int repititions = n / str.length(); 
		count = count * repititions; 


		for (int i = 0; 
				i < n % str.length(); i++)  
		{ 
			if (str.charAt(i) == x) 
				count++; 
		} 

		return count; 
	} 
}

package com.aldrich.om;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JdbcInsertDemo {

	public static void main(String[] args) {
		String dbURL = "jdbc:mysql://localhost:3306/pase_local";
		String username = "root";
		String password = "12345";

		Document doc=null;
		Date date=null;
		String name=null;
		String adress=null;
		String joiningdate=null;
		String city=null;
		String state=null;
		String country=null;


		try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {

			String sql = "INSERT INTO company_employee (name,address,city,state,country,joiningdate) VALUES (?, ?, ? , ?, ?, ?)";

			PreparedStatement statement = conn.prepareStatement(sql);
			try{

				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				File folder = new File("C:\\Om\\Lavu salesnavigator\\Empstage-9");
				File[] listOfFiles = folder.listFiles();
				for (File file : listOfFiles) {


					if (file.isFile()) {
						doc=Jsoup.parse(new File("C:\\Om\\Lavu salesnavigator\\Empstage-9\\"+file.getName())
								, "utf-8");
						if(doc!=null) {

							String companyArray[]=file.getName().replace(".html", "").split("-");					
							String companyName=companyArray[1];

							Elements elem=doc.select("span[class='profile-topcard-person-entity__name Sans-24px-black-90%-bold']");
							name=elem.text();
							statement.setString(1,name);

							List<Date> list=new ArrayList<Date>();
							List<String> listAdress=new ArrayList<String>();
							Elements elements=doc.select("li[class='profile-position display-flex align-items-flex-start']");

							joiningdate="";
							statement.setString(6,joiningdate);
							for (Element element : elements) {
								try {
									Elements ele=element.select("dd[class='profile-position__secondary-title Sans-14px-black-90% mb1']");


									for (Element element2 : ele) {	

										adress="";
										statement.setString(2,adress);

										

										try {
											if(element2.text().replace("Company Name ", "").equals(companyName))
											{
												Elements addressElement=element.select("dd[class='profile-position__company-location mb2 Sans-12px-black-60%']");

												for (Element element3 : addressElement) {									
													listAdress.add(element3.text());
												}

												Elements ddElement=element.getElementsByClass("profile-position__dates-employed fl Sans-12px-black-60%");
												String []dateArray=ddElement.text().split("�");	
												if(!dateArray[0].isEmpty())
												{
													String dateInString =convertToDate(dateArray[0].replace("Dates Employed", "").replace("�", "").trim());
													if(dateInString!=null)
													{
														date = formatter.parse(dateInString);
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

							list.add(date);

							if (listAdress != null && !listAdress.isEmpty()) {		
								adress=listAdress.get(listAdress.size()-1).replace("Location", "").trim();
								statement.setString(2,adress);
							}
								if(adress.chars().filter(ch -> ch == ',').count()==2)
								{
									String addressArray[]=adress.split(",");
									city=addressArray[0].trim();
									state=addressArray[1].trim();
									country=addressArray[2].trim().toString();
									
									statement.setString(3,city);
									statement.setString(4,state);
									statement.setString(5,country);
									
									joiningdate=formatter.format(getEarliestDate(list))	;						
									statement.setString(6,joiningdate);

									int rowsInserted = statement.executeUpdate();
									if (rowsInserted > 0) {
										System.out.println("A new file was inserted successfully!");
									}

	
								}else if(adress.chars().filter(ch -> ch == ',').count()==1){

									String addressArray[]=adress.split(",");
									city=addressArray[0].trim();
									state=addressArray[1].trim();
									country="";
									
									statement.setString(3,city);
									statement.setString(4,state);
									statement.setString(5,country);
									
									joiningdate=formatter.format(getEarliestDate(list))	;						
									statement.setString(6,joiningdate);

									int rowsInserted = statement.executeUpdate();
									if (rowsInserted > 0) {
										System.out.println("A new file was inserted successfully!");
									}

								}else{
									city=adress;
									state="";
									country="";
							
									statement.setString(3,city);
									statement.setString(4,state);
									statement.setString(5,country);
									

									list.add(date);

									joiningdate=formatter.format(getEarliestDate(list))	;						
									statement.setString(6,joiningdate);

									int rowsInserted = statement.executeUpdate();
									if (rowsInserted > 0) {
										System.out.println("A new file was inserted successfully!");
									}


								}
								
							
						}
					}
				}


			}catch (Exception e) {
				e.printStackTrace();
			}

		}catch (Exception e) {
			e.printStackTrace();
		}		
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





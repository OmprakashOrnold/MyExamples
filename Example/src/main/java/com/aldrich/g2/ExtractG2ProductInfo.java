package com.aldrich.g2;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.regex.Pattern;

import org.apache.commons.lang3.time.DateUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class ExtractG2ProductInfo {

	public static void main(String[] args) {

	
		String jsonData=null;

		//File folder = new File("C:\\Users\\OmPrakashPeddamadtha\\Desktop\\g2");
		//	File[] listOfFiles = folder.listFiles();
		//	for (File file : listOfFiles) {
		//	if (file.isFile()) {
		try {
			String fullFileName = "C:\\Users\\OmPrakashPeddamadtha\\Desktop\\g2\\page_601.txt";
			jsonData=readFileAsString(fullFileName);

			if (jsonData != null) {
				JSONObject jsonObject = new JSONObject(jsonData);					
				if (jsonObject != null&& jsonObject.has("data")) {


					JSONArray dataArray = jsonObject.getJSONArray("data");
					int arraySize = dataArray.length();
					if (arraySize > 0) {
						for (int arrayIndex = 0; arrayIndex < arraySize; arrayIndex++) {
							try {
								JSONObject innerJsonObject = dataArray.getJSONObject(arrayIndex);

								String	productId	 =null;
								String	self	 =null;
								String	type	 =null;
								String	product_type	 =null;
								String	product_name	 =null;
								String	short_name	 =null;
								String	domain	 =null;
								String	slug	 =null;
								String	description	 =null;
								String	detail_description	 =null;
								String	image_url	 =null;
								String	product_url	 =null;
								Long	review_count	 =null;
								Double	star_rating	 =null;
								Double	avg_rating	 =null;
								String	public_detail_url	 =null;
								Date	updated_at	 =null;
								Date	created_at	 =null;
								String categories_self = null;
								String categories_related = null;





								//product id
								if (innerJsonObject != null&& innerJsonObject.has("id")) 
								{
									if (isValid(innerJsonObject, "id")) 
									{	
										productId=innerJsonObject.getString("id").toString();
										//System.out.println(productId);									
									}
								}

								//type
								if (innerJsonObject != null&& innerJsonObject.has("type")) 
								{
									if (isValid(innerJsonObject, "type")) 
									{	
										type=innerJsonObject.getString("type").toString();
										//System.out.println(type);									
									}
								}

								if(isValid(innerJsonObject,"attributes"))
								{
									JSONObject attributesObject =(JSONObject) innerJsonObject.get("attributes");	
									if (attributesObject != null&& attributesObject.has("product_type")) {
										if (isValid(attributesObject, "product_type")) 
										{
											product_type= attributesObject.get("product_type").toString();
											//System.out.println(product_type);	
										}
									}

									if (attributesObject != null&& attributesObject.has("name")) {
										if (isValid(attributesObject, "name")) 
										{
											product_name= attributesObject.get("name").toString();
											//System.out.println(product_name);	
										}
									}

									if (attributesObject != null&& attributesObject.has("short_name")) {
										if (isValid(attributesObject, "short_name")) 
										{
											short_name= attributesObject.get("short_name").toString();
											//System.out.println(short_name);	
										}
									}

									if (attributesObject != null&& attributesObject.has("domain")) {
										if (isValid(attributesObject, "domain")) 
										{												
											domain= attributesObject.get("domain").toString();
											//System.out.println(domain);	
										}
									}

									if (attributesObject != null&& attributesObject.has("slug")) {
										if (isValid(attributesObject, "slug")) 
										{
											slug= attributesObject.get("slug").toString();
											//System.out.println(slug);	
										}
									}
									if (attributesObject != null&& attributesObject.has("description")) {
										if (isValid(attributesObject, "description")) 
										{
											description= attributesObject.get("description").toString().replaceAll("[\r\n]+", " "); 
											//System.out.println(description);	
										}
									}

									if (attributesObject != null&& attributesObject.has("detail_description")) {
										if (isValid(attributesObject, "detail_description")) 
										{
											detail_description= attributesObject.get("detail_description").toString().replaceAll("[\r\n]+", " "); 
											//System.out.println(detail_description);	
										}
									}

									if (attributesObject != null&& attributesObject.has("image_url")) {
										if (isValid(attributesObject, "image_url")) 
										{
											image_url= attributesObject.get("image_url").toString();
											//System.out.println(image_url);	
										}
									}

									if (attributesObject != null&& attributesObject.has("product_url")) {
										if (isValid(attributesObject, "product_url")) 
										{
											product_url= attributesObject.get("product_url").toString();
											//System.out.println(product_url);	
										}
									}
									if (attributesObject != null&& attributesObject.has("review_count")) {
										if (isValid(attributesObject, "review_count")) 
										{
											review_count= Long.parseLong(attributesObject.get("review_count").toString());
											//System.out.println(review_count);	
										}
									}
									if (attributesObject != null&& attributesObject.has("star_rating")) {
										if (isValid(attributesObject, "star_rating")) 
										{
											star_rating=Double.parseDouble(attributesObject.get("star_rating").toString());
											//System.out.println(star_rating);	
										}
									}
									if (attributesObject != null&& attributesObject.has("avg_rating")) {
										if (isValid(attributesObject, "avg_rating")) 
										{
											avg_rating=Double.parseDouble(attributesObject.get("avg_rating").toString());
											//System.out.println(avg_rating);	
										}
									}
									if (attributesObject != null&& attributesObject.has("public_detail_url")) {
										if (isValid(attributesObject, "public_detail_url")) 
										{
											public_detail_url=attributesObject.get("public_detail_url").toString();
											//System.out.println(public_detail_url);	
										}
									}
									if (attributesObject != null&& attributesObject.has("created_at")) {
										if (isValid(attributesObject, "created_at")) 
										{												
											String dateSource = attributesObject.get("created_at").toString();
											String date[] = dateSource.split("T");
											created_at=new SimpleDateFormat("yyyy-MM-dd").parse(date[0]);  
										    System.out.println(created_at);
										}
									}
									if (attributesObject != null&& attributesObject.has("updated_at")) {
										if (isValid(attributesObject, "updated_at")) 
										{												
											String dateSource = attributesObject.get("updated_at").toString();
											String date[] = dateSource.split("T");
											updated_at=new SimpleDateFormat("yyyy-MM-dd").parse(date[0]);
											System.out.println(updated_at);
										}
									}


								}
								if(isValid(innerJsonObject,"relationships"))
								{
									JSONObject relationshipsObject =(JSONObject) innerJsonObject.get("relationships");	
									if(isValid(relationshipsObject,"categories"))
									{
										JSONObject categoriesObject =(JSONObject) relationshipsObject.get("categories");	
										if(isValid(categoriesObject,"links"))
										{
											JSONObject linksObject =(JSONObject) categoriesObject.get("links");
											
											if (linksObject != null&& linksObject.has("self")) {
												if (isValid(linksObject, "self")) 
												{
													categories_self=linksObject.get("self").toString();
													//System.out.println(categories_self);	
												}
											}

											if (linksObject != null&& linksObject.has("related")) {
												if (isValid(linksObject, "related")) 
												{
													categories_related=linksObject.get("related").toString();
													//System.out.println(categories_related);	
												}
											}
										}
									}

								}
								
								if(isValid(innerJsonObject,"links"))
								{
									JSONObject linksObject =(JSONObject) innerJsonObject.get("links");	
									if (linksObject != null&& linksObject.has("self")) {
										if (isValid(linksObject, "self")) 
										{
										    self=linksObject.get("self").toString();
											//System.out.println(self);	
										}
									}

								}




								//System.out.println(productId+"$"+product_type+"$"+product_name+"$"+description+"$"+detail_description+"$"+domain+"$"+product_url);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					}
				}
			}


		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	//}
	//}


	public static boolean isValid(JSONObject jsonObject, String propertyName) {
		boolean valid = false;
		try {
			if (propertyName != null) {
				if (jsonObject.has(propertyName) && !jsonObject.get(propertyName).toString().equalsIgnoreCase("null")
						&& !jsonObject.get(propertyName).toString().equalsIgnoreCase(""))
					valid = true;
			}
		} catch (Exception ex) {
			System.out.println(ex.toString());
			valid = false;
		}
		return valid;
	}

	public static String readFileAsString(String fileName)throws Exception 
	{ 
		String data = ""; 
		data = new String(Files.readAllBytes(Paths.get(fileName))); 
		return data; 
	}

	public static String getDateInUTC(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		format.setTimeZone(TimeZone.getTimeZone("GMT"));
		return format.format(date);
	}


	public static Date getDateFromString(String dateTime) {
		Date date;
		try {
			date = DateUtils.parseDate(dateTime, new String[]{"yyyy-MM-dd HH:mm:ss","yyyy-MM-dd HH:mm:ss.s","yyyy-MM-dd","dd-MM-yyyy","yyyy-MM-dd hh:mm a","yyyy-MM-dd hh:mm","MM/dd/yyyy"});
			return date;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public static boolean emailValidator(String emailId) {
		return Pattern.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", emailId);
	}

}

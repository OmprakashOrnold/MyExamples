package com.aldrich.linkdin.post;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class PostsData {

	public static void main(String[] args) {

		File file = new File("C:\\posts_22.01");
		File[] files = file.listFiles();
		for (File f : files) {
			String fileName = f.getName();
			File fullFileName = new File("C:\\posts_22.01\\" + fileName);
			processResponse(fullFileName);
		}
	}

	public static void processResponse(File fullFileName) {
		Document doc = null;
		try{
			doc = Jsoup.parse(fullFileName, "UTF-8");
			Elements mainElement = doc.select("div[class=feed-container-theme]");
			for (Element element : mainElement) {
				try{
					Elements blockElement = element.select("div[class=occludable-update ember-view]");				
					for (Element blockElements: blockElement) {

						String description=getDescription(blockElements);
						String postedDate=getPostDate(blockElements);
						String date=getRegularDateFormat(postedDate);
						String title=getTitleElement(blockElements);
						String postlink=getPostLInk(blockElements);

						if(!title.isEmpty()){
							System.out.println(date);
							System.out.println(description);
							System.out.println(title);
							System.out.println(postlink);
							System.out.println();
						}
					}						
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static String getPostLInk(Element blockElements) {
		String postlink="";
		Elements postlinkElement = blockElements.select("a[class='app-aware-link feed-shared-actor__container-link relative display-flex flex-grow-1']");
		for (Element element2 : postlinkElement) {
			try{
				postlink=element2.attr("href");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return postlink;
	}

	public static String getTitleElement(Element blockElements) {
		String title="";
		Elements titleElement = blockElements.select("h2[class='feed-shared-article__title break-words t-14 t-bold t-black']");
		for (Element element2 : titleElement) {
			try{
				title=element2.text();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return title;
	}

	public static String getPostDate(Element blockElements) {
		String postedDate="";
		Elements spanElement = blockElements.select("span[class=feed-shared-actor__sub-description t-12 t-normal t-black--light]");
		for (Element element2 : spanElement) {
			try{
				Elements dateElement = element2.select("span[aria-hidden=true]");	
				String dateElementArray[]=dateElement.text().split("\\s");
				postedDate= dateElementArray[0].trim();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return postedDate;
	}

	public static String getDescription(Element blockElements) {
		String description="";
		Elements desElement = blockElements.select("div[class=feed-shared-text relative feed-shared-update-v2__commentary  ember-view]");
		for (Element element2 : desElement) {
			try{
				description=element2.text();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return description;
	}
	
	public  static String getRegularDateFormat(String postedDate) {
		
		String strDate=null;
		if (postedDate.contains("mo")) {
			String months_info = postedDate;
			months_info = months_info.replace("mo", "").trim();
			int months_count = Integer.parseInt(months_info);
			Date currentDate = new Date();
			Calendar c = Calendar.getInstance();
			c.setTime(currentDate);
			c.add(Calendar.MONTH, -months_count);
			Date currentDatePlusOne = c.getTime();
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			strDate = formatter.format(currentDatePlusOne);

		} else if (postedDate.contains("yr")) {
			String year_info = postedDate;
			year_info = year_info.replace("yr", "").trim();
			int year_count = Integer.parseInt(year_info);
			Date currentDate = new Date();
			Calendar c = Calendar.getInstance();
			c.setTime(currentDate);
			c.add(Calendar.YEAR, -year_count);
			Date currentDatePlusOne = c.getTime();
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			strDate = formatter.format(currentDatePlusOne);
			
		} else if (postedDate.contains("h")) {
			String hour_info = postedDate;
			hour_info = hour_info.replace("h", "").trim();
			int hour_count = Integer.parseInt(hour_info);
			Date currentDate = new Date();
			Calendar c = Calendar.getInstance();
			c.setTime(currentDate);
			c.add(Calendar.HOUR, -hour_count);
			Date currentDatePlusOne = c.getTime();
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			strDate = formatter.format(currentDatePlusOne);
			
		} else if (postedDate.contains("d")) {
			String days_info = postedDate;
			days_info = days_info.replace("d", "").trim();
			int days_count = Integer.parseInt(days_info);
			Date currentDate = new Date();
			Calendar c = Calendar.getInstance();
			c.setTime(currentDate);
			c.add(Calendar.DATE, -days_count);
			Date currentDatePlusOne = c.getTime();
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			strDate = formatter.format(currentDatePlusOne);
			
		} else if (postedDate.contains("w")) {
			String week_info = postedDate;
			week_info = week_info.replace("w", "").trim();
			int week_count = Integer.parseInt(week_info);
			Date currentDate = new Date();
			Calendar c = Calendar.getInstance();
			c.setTime(currentDate);
			c.add(Calendar.DAY_OF_WEEK_IN_MONTH, -week_count);
			Date currentDatePlusOne = c.getTime();
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			strDate = formatter.format(currentDatePlusOne);
			
		}
		return strDate;
	}
}
// end the company parsing



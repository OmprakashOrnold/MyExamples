package com.aldrich.linkdin.post;


import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

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
			Document doc = null;
			String description=null;
			String postedDate=null;
			try{
				doc = Jsoup.parse(fullFileName, "UTF-8");
				Elements mainElement = doc.select("div[class=feed-container-theme]");
				for (Element element : mainElement) {
					try{
						Elements desElement = element.select("div[class=feed-shared-text relative feed-shared-update-v2__commentary  ember-view]");
						for (Element element2 : desElement) {
							try{
								description=element2.text();
								//System.out.println(description);
							} catch (Exception ex) {
								ex.printStackTrace();
							}
						}

						Elements spanElement = element.select("span[class=feed-shared-actor__sub-description t-12 t-normal t-black--light]");
						for (Element element2 : spanElement) {
							try{
								postedDate=element2.text();
							//	System.out.println(postedDate);
							} catch (Exception ex) {
								ex.printStackTrace();
							}
						}
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}

				Elements titleElement = doc.select("div[class=feed-shared-article__section]");

				for (Element element : titleElement) {
					Elements desElement = element.select("div[class=feed-shared-text relative feed-shared-update-v2__commentary  ember-view]");
					for (Element element2 : desElement) {
						try{
							description=element2.text();
							System.out.println(description);
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}

				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		}

	}
}
// end the company parsing



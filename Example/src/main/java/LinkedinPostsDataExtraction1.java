import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class LinkedinPostsDataExtraction1 {

	public static void main(String[] args) {

		String fileName = "C:\\Users\\Omprakash\\Downloads\\118.html";

		String description=null;
		String postedDate=null;
		String followersCount=null;
		String hashtag=null;
		String hashtags=null;
		String strDate=null;
		String Likes=null;
		String title=null;
		String postLink=null;
		String postedDateTemp=null;
		String pattern="[##]+([A-Za-z0-9-_]+)";
		int count1=1;

		try {
			// read the content from file
			Document doc = Jsoup.parse(new File(fileName), "utf-8"); 

			if(doc!=null)
			{
				//Followers Count----
				Elements followersCountElement=doc.select("div[class=truncate feed-shared-text-view white-space-pre-wrap break-words ember-view]");
                
				//postLink
				Elements postLinkElement=doc.select("a[class=feed-shared-actor__container-link relative display-flex flex-grow-1 app-aware-link ember-view]");
				
				//Description  
				Elements descriptionElement=doc.select("div[class=feed-shared-text__text-view feed-shared-text-view white-space-pre-wrap break-words ember-view]");
				if(descriptionElement.isEmpty())
				{
					descriptionElement=doc.select("div[class=feed-shared-text relative feed-shared-update-v2__commentary  ember-view]");
				}

				//hastags
				Elements hashtagsElement=doc.select("div[class=feed-shared-text__text-view feed-shared-text-view white-space-pre-wrap break-words ember-view]");
				if(hashtagsElement.isEmpty())
				{
					hashtagsElement=doc.select("div[class=feed-shared-text relative feed-shared-update-v2__commentary  ember-view]");
				}

				//postedDate
				Elements postedDateElement=doc.select("div[class=feed-shared-text-view white-space-pre-wrap break-words ember-view]");
			

				//Likes
				Elements likesElement=doc.select("span[class=v-align-middle social-details-social-counts__reactions-count]");

				//Title
				Elements titleElement=doc.select("div[class=feed-shared-article__section]");


				for (int count = 0; count <likesElement.size(); count++)
				{

					try {
						followersCount=followersCountElement.get(count).text().replace(" followers","").replace(",", "").trim();
						postLink=postLinkElement.attr("href");
						description=descriptionElement.get(count).text().replace("hashtag", "").replaceAll(pattern, "");			
						hashtag=hashtagsElement.get(count).text().replace("hashtag", "");
						hashtags=getHashTags(hashtag).toString();
						postedDateTemp = postedDateElement.get(count).text().replace(" â€¢", "")
								.replace(" Edited", "").replace((" ï¿½"), "");
						String[] arrSplit = postedDateTemp.split(" ");
						if (arrSplit.length > 1) {
							postedDate = arrSplit[0].trim();
						}
					
						Likes=likesElement.get(count).text().replace(",", "").replace("Comment", "").replace("Views", "");
						title=titleElement.get(count).tagName("span").text();

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
							strDate= formatter.format(currentDatePlusOne);  


						}else if (postedDate.contains("yr")) {
							String year_info = postedDate;               
							year_info =year_info.replace("yr", "").trim();
							int year_count = Integer.parseInt(year_info);
							Date currentDate = new Date();
							Calendar c = Calendar.getInstance();
							c.setTime(currentDate);
							c.add(Calendar.YEAR, -year_count);
							Date currentDatePlusOne = c.getTime();
							SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
							strDate= formatter.format(currentDatePlusOne);  


						}else if (postedDate.contains("h")) {
							String hour_info = postedDate;               
							hour_info =hour_info.replace("h", "").trim();
							int hour_count = Integer.parseInt(hour_info);
							Date currentDate = new Date();
							Calendar c = Calendar.getInstance();
							c.setTime(currentDate);
							c.add(Calendar.HOUR, -hour_count);
							Date currentDatePlusOne = c.getTime();
							SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
							strDate= formatter.format(currentDatePlusOne); 

						}else if (postedDate.contains("d")) {
							String days_info = postedDate;               
							days_info =days_info.replace("d", "").trim();
							int days_count = Integer.parseInt(days_info);
							Date currentDate = new Date();
							Calendar c = Calendar.getInstance();
							c.setTime(currentDate);
							c.add(Calendar.DATE, -days_count);
							Date currentDatePlusOne = c.getTime();
							SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
							strDate= formatter.format(currentDatePlusOne);  


						}else if (postedDate.contains("w")) {
							String week_info = postedDate;               
							week_info =week_info.replace("w", "").trim();
							int week_count = Integer.parseInt(week_info);
							Date currentDate = new Date();
							Calendar c = Calendar.getInstance();
							c.setTime(currentDate);
							c.add(Calendar.DAY_OF_WEEK_IN_MONTH, -week_count);
							Date currentDatePlusOne = c.getTime();
							SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
							strDate= formatter.format(currentDatePlusOne);    
						}

					}catch(Exception ex)
					{
						//ex.printStackTrace();
					}
					System.out.println("------------------------------------------------");	
					System.out.println(count1+"  "+"followersCount -->"+followersCount);
					count1++;
					System.out.println("Title          -->"+title);
					System.out.println("post link      --->"+postLink);
					System.out.println("Description    -->"+description);	
					System.out.println("Hashtags       -->"+hashtags);
					System.out.println("PostedDate     -->"+strDate);
					System.out.println("Likes          -->"+Likes);
					System.out.println("------------------------------------------------");				
				}
			}

		} catch (IOException e) {

			//e.printStackTrace();
		}
	}
	public static List<String> getHashTags(String hashTags) {
		Pattern pattern1 = Pattern.compile("[##]+([A-Za-z0-9-_]+)");
		Matcher  matcher = pattern1.matcher(hashTags);
		List<String> list=new ArrayList<>();
		while (matcher.find())
		{			
			list.add(matcher.group());
		}
		return list;
	}
}

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
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class LinkedPostExtractionNew {

	public static void main(String[] args) {

		String fileName = "C:\\Users\\oppeddamadthala\\Downloads\\RFID.html";

		String description=null;
		String postedDate=null;
		String followersCount=null;
		String hashtag=null;
		String hashtags=null;
		String strDate=null;
		String Likes=null;
		String title=null;
		String postLink=null; 
		String postLinkElement=null;
		String pattern="[##]+([A-Za-z0-9-_]+)";
		int count1=1;

		try {
			// read the content from file
			Document doc = Jsoup.parse(new File(fileName), "utf-8"); 

			if(doc!=null)
			{
				Elements div_elements = doc.select("div");
				if (div_elements != null && div_elements.size() > 0) {
					for (Element element : div_elements) {
						//followers Count
						if (element.hasAttr("class") && element.attr("class").equals("truncate feed-shared-text-view white-space-pre-wrap break-words ember-view")) {
							followersCount=element.text().replace(" followers","").replace(",", "").trim();
							//System.out.println("followersCount -->"+followersCount);
						}
						   //postLink
							if (element.hasAttr("class") && element.attr("class").equals("display-flex feed-shared-actor display-flex feed-shared-actor--with-control-menu ember-view")) {
								postLink=element.getElementsByTag("a").attr("href");
								//System.out.println(postLink);								
							}
							//Description
							if (element.hasAttr("class") && element.attr("class").equals("feed-shared-text__text-view feed-shared-text-view white-space-pre-wrap break-words ember-view")) {
								description=element.text().replace("hashtag", "").replaceAll(pattern, "");
								//System.out.println(description);
								
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
				
				}
			}catch (Exception e) {
				e.printStackTrace();
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

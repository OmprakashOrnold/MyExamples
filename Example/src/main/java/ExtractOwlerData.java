import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.json.JSONException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class ExtractOwlerData
{

	public static void main(String[] args)
	{
		String postedDate=null;
		String title=null;
		String comapanyName=null;
		String location = null;
		String posteDate=null;
		String jobUrl=null;
		Document document = null;	
		Document doc=null;

		File folder = new File("C:\\Om\\jobs_info");
		File[] listOfFiles = folder.listFiles();
		for (File file : listOfFiles) {
			if (file.isFile()) 
			{
				try {
				
					doc=Jsoup.parse(new File("C:\\Om\\jobs_info\\"+file.getName())
							, "utf-8");



					Elements elements = doc.select("artdeco-carousel-content");
					if (elements!=null && elements.size()>0) {
						for (Element recentlyPosted : elements) {	
							try {
								Elements recentlyPostedElement=recentlyPosted.select("div[class=org-jobs-recently-posted-job-card ember-view]");

								for (Element recentlypostedjobs : recentlyPostedElement) {	
									try {
										Elements TitleElement=recentlypostedjobs.select("h3[class=t-14 t-black t-bold pt2 lt-line-clamp lt-line-clamp--multi-line ember-view]");
										Elements CompanyElement=recentlypostedjobs.select("div[class=t-14 t-black t-normal truncate]");
										Elements LocationElement=recentlypostedjobs.select("div[class=t-12 t-black--light t-normal truncate]");
										Elements postedDateElement=recentlypostedjobs.select("time[class=t-12 t-black--light t-normal]");
										posteDate=postedDateElement.text(); 
										jobUrl=recentlypostedjobs.getElementsByTag("a").attr("href");

										location=LocationElement.text().toString().trim();



										String[] arrOfStr = location.split(", "); 



										if(arrOfStr.length==3)
										{
											if (!arrOfStr[0].equals("")) {
												String city=arrOfStr[0].trim();
												//System.out.println("city                    : "+city);
											}
											if (!arrOfStr[1].equals("")) {
												String State=arrOfStr[1].trim();
												//System.out.println("state                   : "+State);
											}
											if (!arrOfStr[2].equals("")) {
												String Country=arrOfStr[2].trim();
												//System.out.println("Country                 : "+Country);
											}
										}else {
											if (!arrOfStr[0].equals("")) {
												String city=arrOfStr[0].trim();
												//System.out.println("city                    : "+city);
											}
										}


										title=TitleElement.text();
										comapanyName=CompanyElement.text();

										if (posteDate.contains(" week ago")) {
											String week_info = posteDate;               
											week_info =week_info.replace(" week ago", "").trim();
											int week_count = Integer.parseInt(week_info);
											Date currentDate = new Date();
											Calendar c = Calendar.getInstance();
											c.setTime(currentDate);
											c.add(Calendar.DAY_OF_WEEK_IN_MONTH, -week_count);
											Date currentDatePlusOne = c.getTime();
											//System.out.println(currentDatePlusOne);
											SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
											postedDate= formatter.format(currentDatePlusOne);
										}else if (posteDate.contains(" days ago")) {
											String days_info = posteDate;               
											days_info =days_info.replace(" days ago", "").trim();
											int days_count = Integer.parseInt(days_info);
											Date currentDate = new Date();
											Calendar c = Calendar.getInstance();
											c.setTime(currentDate);
											c.add(Calendar.DATE, -days_count);
											Date currentDatePlusOne = c.getTime();
											//System.out.println(currentDatePlusOne);
											SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
											postedDate= formatter.format(currentDatePlusOne); 
											postedDate= formatter.format(currentDatePlusOne);
										}else if (posteDate.contains(" day ago")) {
											String day_info = posteDate;               
											day_info =day_info.replace(" day ago", "").trim();
											int day_count = Integer.parseInt(day_info);
											Date currentDate = new Date();
											Calendar c = Calendar.getInstance();
											c.setTime(currentDate);
											c.add(Calendar.DATE, -day_count);
											Date currentDatePlusOne = c.getTime();
											//System.out.println(currentDatePlusOne);
											SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
											postedDate= formatter.format(currentDatePlusOne);  
										}else if (posteDate.contains(" weeks ago")) {
											String week_info = posteDate;               
											week_info =week_info.replace(" weeks ago", "").trim();
											int week_count = Integer.parseInt(week_info);
											Date currentDate = new Date();
											Calendar c = Calendar.getInstance();
											c.setTime(currentDate);
											c.add(Calendar.DAY_OF_WEEK_IN_MONTH, -week_count);
											Date currentDatePlusOne = c.getTime();
											//System.out.println(currentDatePlusOne);
											SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
											postedDate= formatter.format(currentDatePlusOne);
										}else if (posteDate.contains(" months ago")) {
											String months_info = posteDate;               
											months_info =months_info.replace(" months ago", "").trim();
											int months_count = Integer.parseInt(months_info);
											Date currentDate = new Date();
											Calendar c = Calendar.getInstance();
											c.setTime(currentDate);
											c.add(Calendar.MONTH, -months_count);
											Date currentDatePlusOne = c.getTime();
											//System.out.println(currentDatePlusOne);
											SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
											postedDate= formatter.format(currentDatePlusOne);
										}else if (posteDate.contains(" month ago")) {
											String month_info = posteDate;               
											month_info =month_info.replace(" month ago", "").trim();
											int month_count = Integer.parseInt(month_info);
											Date currentDate = new Date();
											Calendar c = Calendar.getInstance();
											c.setTime(currentDate);
											c.add(Calendar.MONTH, -month_count);
											Date currentDatePlusOne = c.getTime();
											//System.out.println(currentDatePlusOne);
											SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
											postedDate= formatter.format(currentDatePlusOne);
										}else if (posteDate.contains(" hours ago")) {
											String hours_info = posteDate;               
											hours_info =hours_info.replace(" hours ago", "").trim();
											int hours_count = Integer.parseInt(hours_info);
											Date currentDate = new Date();
											Calendar c = Calendar.getInstance();
											c.setTime(currentDate);
											c.add(Calendar.HOUR, -hours_count);
											Date currentDatePlusOne = c.getTime();
											//System.out.println(currentDatePlusOne);
											SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
											postedDate= formatter.format(currentDatePlusOne);
										}else if (posteDate.contains(" hour ago")) {
											String hour_info = posteDate;               
											hour_info =hour_info.replace(" hour ago", "").trim();
											int hour_count = Integer.parseInt(hour_info);
											Date currentDate = new Date();
											Calendar c = Calendar.getInstance();
											c.setTime(currentDate);
											c.add(Calendar.HOUR, -hour_count);
											Date currentDatePlusOne = c.getTime();
											//System.out.println(currentDatePlusOne);
											SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
											postedDate= formatter.format(currentDatePlusOne);
										}
										System.out.println("---------------------------------------------");
										System.out.println("Title       --->"+title);
										System.out.println("Company     --->"+comapanyName);
										System.out.println("Location    --->"+location);
										System.out.println("postedDate  --->"+postedDate);
										System.out.println("jobUrl      --->"+"https://linkedin.com"+jobUrl);
										System.out.println("---------------------------------------------");

									}catch(Exception e)
									{
										e.printStackTrace();
									}
								}
							}catch(Exception e)
							{
								e.printStackTrace();
							}
						}	

					}


				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

		}
	}
	}
}




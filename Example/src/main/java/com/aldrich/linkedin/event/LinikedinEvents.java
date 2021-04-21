package com.aldrich.linkedin.event;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class LinikedinEvents {

	public static void main(String[] args) {

		//	File folder = new File("C:\\jobs_linkedin\\evnets");
		//	File[] listOfFiles = folder.listFiles();

		// (File file : listOfFiles) {
		//		if (file.isFile()) {
		//	System.out.println(file.getName().replace(".html",""));
		File fullFileName = new File("C:\\jobs_linkedin\\evnets\\2509.html");

		processResponse(fullFileName);

		System.out.println("******************************************************************************");
		//		}
		//	}

	}

	public static void processResponse(File fullFileName) {
		Document document=null;
		try {
			document = Jsoup.parse(fullFileName, "UTF-8");
			Elements li_tags = document.select("li");
			if (li_tags != null && li_tags.size() > 0) {
				for (Element li_tag: li_tags) {
					try {
						if (li_tag.attr("class").equals("org-events__list-item artdeco-list__item")) {

							String event_start_date=getEventStartDate(li_tag) ;
							System.out.println(getDateFromString(event_start_date));

							String event_end_date=getEventEndDate(li_tag) ;

							if(getDateFromString(event_end_date)==null||getDateFromString(event_end_date).isEmpty())
							{
								System.out.println(getDateFromString(event_start_date));
								
							}else{

								System.out.println(getDateFromString(event_end_date));
							}
						

							String title=getEventTitle(li_tag) ;
							if(!title.isEmpty())
							{
								System.out.println(title);
							}

							String event_type=getEventType(li_tag) ;
							if(event_type.contains(","))
							{
								String locationArray[]=event_type.split(",");
								String city=locationArray[0].trim();
								String state=locationArray[1].trim();
								
								System.out.println(city);
								System.out.println(state);
							}else{
								System.out.println(event_type);
							}

							String attendes=getEventAttendees(li_tag) ;
							System.out.println(attendes.replace("attendees", "").trim());

							String event_link=getEventLink(li_tag) ;
							System.out.println(event_link);

							System.out.println();

						}

					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}		
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static String getEventTitle(Element element) {
		String event_title=null;

		Elements h4_element = element.select("h4");
		if (h4_element != null && h4_element.size() > 0) {
			for (Element h4_elements: h4_element) {
				try {
					if (h4_elements.attr("class").equals("lt-line-clamp lt-line-clamp--multi-line ember-view t-16 t-bold")) {
						event_title=h4_elements.text().trim();
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}		
		return event_title;
	}

	public static String getEventAttendees(Element element) {
		String event_attendees=null;
		Elements span_element = element.select("span");
		if (span_element != null && span_element.size() > 0) {
			for (Element span_elements: span_element) {
				try {
					if (span_elements.attr("class").equals("t-12 t-black--light t-normal mvA  mt2")) {
						event_attendees=span_elements.text();
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
		return event_attendees;
	}


	public static String getEventLink(Element element) {
		String event_link=null;

		Elements a_element = element.select("a");
		if (a_element != null && a_element.size() > 0) {
			for (Element a_elements: a_element) {
				try {
					if (a_elements.attr("class").equals("ember-view link-without-hover-visited artdeco-button artdeco-button--2 artdeco-button--secondary")) {
						event_link="https://www.linkedin.com"+a_elements.attr("href");						
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}

			}
		}
		return event_link;
	}


	public static String getEventType(Element element) {
		String event_type=null;
		Elements div_element = element.select("div");
		if (div_element != null && div_element.size() > 0) {
			for (Element div_elements: div_element) {
				try {
					if (div_elements.attr("class").equals("artdeco-entity-lockup__caption ember-view")) {
						if(!div_elements.text().contains("-")){
							event_type=div_elements.text();
						}
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}	
		return event_type;
	}

	public static String getEventStartDate(Element element) {
		String event_start_date=null;

		Elements div_element = element.select("span");
		if (div_element != null && div_element.size() > 0) {
			for (Element div_elements: div_element) {
				try {
					if (div_elements.attr("class").equals("t-black")) {
						String eventArray[]=div_elements.text().split("-");
						event_start_date=eventArray[0].trim();
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}	

		return event_start_date;
	}



	public static String getEventEndDate(Element element) {
		String event_end_date=null;

		Elements div_element = element.select("span");
		if (div_element != null && div_element.size() > 0) {
			for (Element div_elements: div_element) {
				try {
					if (div_elements.attr("class").equals("t-black")) {
						String eventArray[]=div_elements.text().split("-");
						event_end_date=eventArray[1].trim();
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}

		return event_end_date;
	}


	public static String getDateFromString(String docText) {
		docText = docText.toLowerCase().replace("t.", "");
		String date = "";

		String regex1 = "(Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|Jun(e)?|Jul(y)?|Aug(ust)?|Sep(tember)?|Oct(ober)?|Nov(ember)?|Dec(ember)?)\\s(0?[1-9]|[12][0-9]|3[01])\\,\\s\\d{4,4}"
				.toLowerCase();

		String dateFormat = "(" + regex1 + ")";

		if (docText != null && !docText.isEmpty()) {
			try {
				Pattern compile = Pattern.compile(dateFormat);
				Matcher matcher = compile.matcher(docText);
				if (matcher.find()) {
					date = matcher.group(0);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return date;
	}

	public static Date convertAnyTypeDateToSingleFormat(String dateInString) {
		String dateFormat = null;
		Date date = null;		
		String regex1 = "(Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|Jun(e)?|Jul(y)?|Aug(ust)?|Sep(tember)?|Oct(ober)?|Nov(ember)?|Dec(ember)?)\\s(0?[1-9]|[12][0-9]|3[01])\\,\\s\\d{4,4}";
	
		dateInString = dateInString.toLowerCase().replace("t.", "").replace("th", "").replace("nd", "");
		if (dateInString != null && !dateInString.isEmpty()) {
			if (dateInString.matches(regex1)) {
				dateFormat = "yyyy-MM-dd";
			}
			SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
			try {
				date = formatter.parse(dateInString);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return date;
	}
	
}



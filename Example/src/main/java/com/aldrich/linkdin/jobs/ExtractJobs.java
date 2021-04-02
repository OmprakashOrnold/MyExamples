package com.aldrich.linkdin.jobs;

import java.io.File;
import java.io.IOException;

import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ExtractJobs {

	public static void main(String[] args) {

		File folder = new File("C:\\jobs_linkedin");
		File[] listOfFiles = folder.listFiles();

		for (File file : listOfFiles) {
			if (file.isFile()) {
				System.out.println(file.getName().replace(".html",""));
				File fullFileName = new File("C:\\jobs_linkedin\\"+file.getName());

				processResponse(fullFileName);

			}
		}
	}

	public static void processResponse(File fullFileName) {

		Document document=null;
		// read the content from file
		try {
			document = Jsoup.parse(fullFileName, "UTF-8");
			Elements liElement = document.select(
					"li[class=jobs-search-results__list-item occludable-update p0 relative ember-view]");
			if (liElement != null && liElement.size() > 0) {
				for (Element element : liElement) {
					try {

						String job_title = getJobTitle(element);
						String job_url =    getJobUrl(element);
						String job_location = getJobLocation(element);
						String posted_date_1 = getJobPostedDateType1(element);
						String posted_date_2 = getPostedDateType2(element);
						String posted_date = null;

						System.out.println("---------------------------------------------");
						System.out.println("Title       --->" + job_title);
						System.out.println("Location    --->" + job_location);
						System.out.println("postedDate1  --->" + posted_date_1);
						System.out.println("postedDate2  --->" + posted_date_2);
						System.out.println("jobUrl      --->" + job_url);
						System.out.println("---------------------------------------------");

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getJobUrl(Element element) {
		String job_url = "";
		try{
			Elements divElement = element.select("div[class=full-width artdeco-entity-lockup__title ember-view]");
			if (divElement != null) {
				for (Element nameElement : divElement) {
					try {
						if (nameElement.children().hasAttr("data-control-id")) {
							//job_title = nameElement.text().toString().trim();
							job_url = "https://www.linkedin.com"+ nameElement.children().attr("href");
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return job_url;
	}

	public static String getJobTitle(Element element) {
		String job_title="";
		try{
			Elements divElement = element.select("div[class=full-width artdeco-entity-lockup__title ember-view]");
			if (divElement != null) {
				for (Element nameElement : divElement) {
					try {
						if (nameElement.children().hasAttr("data-control-id")) {
							job_title = nameElement.text().toString().trim();
							//job_url = "https://www.linkedin.com"+ nameElement.children().attr("href");
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return job_title;
	}

	public static String getPostedDateType2(Element element) {
		String posted_date_2="";
		try{
			Elements divElement3 = element.select("ul[class=job-card-list__footer-wrapper job-card-container__footer-wrapper flex-shrink-zero display-flex t-sans t-12 t-black--light t-normal t-roman]");
			if (divElement3 !=null) {
				for (Element timeElement : divElement3) {
					try {
						if (timeElement.children().hasAttr("class")) {
							Elements dateElement = timeElement.children().select(
									"li[class=job-card-container__listed-time job-card-container__footer-item job-card-container__footer-item--highlighted t-bold]");
							for (Element dateElement1 : dateElement) {
								if (dateElement1.children().hasAttr("datetime")) {
									posted_date_2 = dateElement1.children().attr("datetime");

								}
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return posted_date_2;
	}

	public static String getJobPostedDateType1(Element element) {
		String posted_date_1="";
		try{
			Elements divElement2 = element.select("ul[class=job-card-list__footer-wrapper job-card-container__footer-wrapper flex-shrink-zero display-flex t-sans t-12 t-black--light t-normal t-roman]");
			if (divElement2 != null) {
				for (Element timeElement : divElement2) {
					try {
						if (timeElement.children().hasAttr("class")) {
							Elements dateElement = timeElement.children().select("li[class=job-card-container__listed-time job-card-container__footer-item ]");
							for (Element dateElement1 : dateElement) {
								if (dateElement1.children().hasAttr("datetime")) {
									posted_date_1 = dateElement1.children().attr("datetime");
								}
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return posted_date_1;
	}

	public static String getJobLocation(Element element) {
		String job_location="";
		try {
			Elements divElement1 = element.select("div[class=artdeco-entity-lockup__caption ember-view]");
			if (divElement1 != null) {
				for (Element placeElement : divElement1) {
					try {
						if (placeElement.children()
								.hasClass("job-card-container__metadata-wrapper")) {
							job_location = placeElement.children().text().toString().trim();
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return job_location;
	}



}

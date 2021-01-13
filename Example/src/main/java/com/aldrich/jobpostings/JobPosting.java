package com.aldrich.jobpostings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.aldrich.pase.util.PASEConstants;
import com.aldrich.patent.SSLExceptionSolution;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class JobPosting {

	public static void main(String[] args) {
	
		List<String> url=new ArrayList<String>();
		url.add("https://www.salary.com");
		
		String urls=null;	
		for (String string : url) {

			urls=string.trim();
			Document home_page_document =getURLResponse(urls);
			if (home_page_document != null) {
				getJobPostingsInfo(home_page_document,urls);
			}

			
		}
	}
	

	public static void getJobPostingsInfo(Document document, String company_url) {
		try {
			// get the press releases pages
			List<String> pressReleasesUrlList = getCarrerPagesUrl(document, company_url);
			if (pressReleasesUrlList.size() > 0) {
				for (String pr_url : pressReleasesUrlList) {
					try {
						
						Document individual_pr_document = getURLResponse(pr_url);
						if (individual_pr_document != null) {
							// get ind press releases pages
							List<String> individualPressReleasesUrlList = getCarrerPagesUrl(individual_pr_document, company_url);
							if (individualPressReleasesUrlList.size() > 0) {
								for (String ind_pr_url : individualPressReleasesUrlList) {
									try {
										if (!pr_url.equals(ind_pr_url)) {
											//System.out.println(ind_pr_url);
											System.out.println("------------------------------------");
											System.out.println(ind_pr_url);
											System.out.println("------------------------------------");
											/*Document ind_news_document = getURLResponse(ind_pr_url);
											if (ind_news_document != null) {
												saveNewsInfo(ind_news_document, ind_pr_url,"Press Releases");
											}*/
										}
									} catch (Exception e) {
										e.printStackTrace();
									}
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
	}
	
	
	public static List<String> getCarrerPagesUrl(Document document, String company_url) {
		List<String> pressReleasesUrlsList = new ArrayList<String>();
		String page_number = null;
		String is_pages_available = "No";
		String page_nav_type = "";
		int page_num = 0;
		List<Integer> page_num_list = new ArrayList<Integer>();
		try {
			Elements elements = document.select("a");
			if (elements != null && elements.size() > 0) {
				for (Element element : elements) {
					try {
						if (element.hasAttr("href")) {
							String text = element.text().trim().toLowerCase();
							String link = element.attr("href").trim().toLowerCase();
							if (link.contains("/careers") || link.contains("/jobs")
									|| link.contains("/careers/")|| link.contains("/jobs/")) {
								String actual_pr_url = null;
								if (link.startsWith("http")) {
									actual_pr_url = link;
								} else if (link.startsWith("www")) {
									actual_pr_url = "http://" + link;
								} else if (company_url.endsWith("/") && link.startsWith("/")) {
									actual_pr_url = company_url + link.substring(1);
								} else if (!company_url.endsWith("/") && link.startsWith("/")) {
									actual_pr_url = company_url + link;
								} else if (!company_url.endsWith("/") && !link.startsWith("/")) {
									actual_pr_url = company_url + "/" + link;
								} else {
									actual_pr_url = company_url + "/" + link;
								}
								if (actual_pr_url != null && isValidUrl(actual_pr_url) == true) {
									boolean exists = pressReleasesUrlsList.contains(actual_pr_url);
									if (exists == false) {
										pressReleasesUrlsList.add(actual_pr_url);
									}
									Document pr_document = null;
									pr_document = getURLResponse(actual_pr_url);
									if (pr_document != null) {
										Elements anchor_elements = pr_document.select("a");
										if (anchor_elements != null && anchor_elements.size() > 0) {
											for (Element ele : anchor_elements) {
												try {
													if (ele.hasAttr("href")) {
														String text1 = ele.text().trim().toLowerCase();
														String link1 = ele.attr("href").trim().toLowerCase();
														if (link1.contains("/careers")
																|| link1.contains("/jobs")
																|| link1.contains("/careers/")|| link1.contains("/jobs/")) {
															if (link1.contains("/page/") || link1.contains("/page")
																	|| link1.contains("page/")
																	|| link1.contains("page=")) {
																if (link1.contains("/page/")
																		|| link1.contains("/page")) {
																	page_nav_type = "/page/";
																}
																if (link1.contains("page=")
																		|| link1.contains("?page=")) {
																	page_nav_type = "page=";
																}
																String actual_pr_url_1 = null;
																if (link1.startsWith("http")) {
																	actual_pr_url_1 = link1;
																} else if (link1.startsWith("www")) {
																	actual_pr_url_1 = "http://" + link1;
																} else if (company_url.endsWith("/")
																		&& link1.startsWith("/")) {
																	actual_pr_url_1 = company_url + link1.substring(1);
																} else if (!company_url.endsWith("/")
																		&& link1.startsWith("/")) {
																	actual_pr_url_1 = company_url + link1;
																} else if (!company_url.endsWith("/")
																		&& !link1.startsWith("/")) {
																	actual_pr_url_1 = company_url + "/" + link1;
																} else {
																	actual_pr_url_1 = company_url + "/" + link1;
																}
																exists = pressReleasesUrlsList
																		.contains(actual_pr_url_1);
																if (exists == false
																		&& isValidUrl(actual_pr_url_1) == true) {
																	is_pages_available = "Yes";
																	page_number = actual_pr_url_1.replaceAll("[^\\d]",
																			" ");
																	page_number = page_number.trim();
																	if (page_number != null
																			&& !page_number.equals("")) {
																		page_num = Integer.parseInt(page_number);
																		page_num_list.add(page_num);
																	}
																	pressReleasesUrlsList.add(actual_pr_url_1);
																}
															}
														}
													}
												} catch (Exception e) {
													e.printStackTrace();
												}
											}
										}
									}
								}
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			if (pressReleasesUrlsList.size() > 0) {
				String first_url = pressReleasesUrlsList.get(0);
				if (page_num > 0) {
					page_num = Collections.max(page_num_list);
					for (int pagenum = 0; pagenum < page_num; pagenum++) {
						try {
							if (pagenum != 0) {
								if (is_pages_available.equals("Yes")) {
									String pagination_url = null;
									if (first_url.endsWith("/")) {
										pagination_url = first_url + "page/" + pagenum + "/";
									} else {
										pagination_url = first_url + "/page/" + pagenum + "/";
									}
									boolean exists = pressReleasesUrlsList.contains(pagination_url);
									if (exists == false && isValidUrl(pagination_url) == true) {
										pressReleasesUrlsList.add(pagination_url);
									}
								}
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					for (int pagenum = 0; pagenum < page_num; pagenum++) {
						try {
							if (pagenum != 0) {
								if (is_pages_available.equals("Yes")) {
									String pagination_url = null;
									if (page_nav_type.equals("page=")) {
										if (first_url.endsWith("/")) {
											pagination_url = first_url + "?page=" + pagenum;
										} else {
											pagination_url = first_url + "?page=" + pagenum;
										}
									}
									boolean exists = pressReleasesUrlsList.contains(pagination_url);
									if (exists == false && isValidUrl(pagination_url) == true) {
										pressReleasesUrlsList.add(pagination_url);
									}
								}
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<String> newList = pressReleasesUrlsList.stream().distinct().collect(Collectors.toList());
		return newList;
	}

	public static Document getURLResponse(String news_url) {
		Document doc = null;
		String content=null;
		try {
			CloseableHttpClient httpclient = HttpClients.createDefault(); // Create an httpclient instance
			HttpGet httpget = new HttpGet(news_url); // Create a httpget instance
			CloseableHttpResponse response = httpclient.execute(httpget); // Execute the get request
			HttpEntity entity = response.getEntity(); // Get the returned entity
			content = EntityUtils.toString(entity, "utf-8");
			doc = Jsoup.parse(content);
			
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return doc;
	}

	public static SSLSocketFactory createSslSocketFactory() throws Exception {
		TrustManager[] byPassTrustManagers = new TrustManager[] { new X509TrustManager() {
			public X509Certificate[] getAcceptedIssuers() {
				return new X509Certificate[0];
			}

			public void checkClientTrusted(X509Certificate[] chain, String authType) {
			}

			public void checkServerTrusted(X509Certificate[] chain, String authType) {
			}
		} };
		SSLContext sslContext = SSLContext.getInstance("TLS");
		sslContext.init(null, byPassTrustManagers, new SecureRandom());
		return sslContext.getSocketFactory();
	}
	
	public static boolean isValidUrl(String page_url) {
		boolean valid = true;
		try {
			if (page_url.contains("www.facebook.com") || page_url.contains("www.linkedin.com")
					|| page_url.contains("plus.google.com") || page_url.contains("twitter.com")
					|| page_url.contains("?") || page_url.contains(".pdf")) {
				valid = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return valid;
	}
}


import java.io.File;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GettingUrl {

	public static void main(String[] args) throws IOException {

		Document doc=null;
		String startEmployeeCount=null;
		String endEmployeeCount=null;
		String linkedInCompanyUrl=null;
		String companyName=null;
		String companyUrl=null;

		Document document = null;
		File fullFileName = new File("C:\\Om\\posts_info\\posts_info\\107.html");
		try {

			document = Jsoup.parse(fullFileName, "UTF-8");
			Elements code_elements = document.select("code");
			if (code_elements != null && code_elements.size() > 0) {
				for (Element element : code_elements) {
					if (element.hasAttr("style") && element.hasAttr("id")) {
						if (element.attr("style").equals("display: none") && element.attr("id").startsWith("bpr-guid-")) {
							String pageContent = element.text();
							if (pageContent != null && pageContent != "" && pageContent.contains("included")
									&& pageContent.contains("com.linkedin.voyager.deco.organization.web.WebSimilarCompanyCardWithRelevanceReason")) {


								JSONObject jsonObject=new JSONObject(pageContent.toString());
								if(jsonObject.has("included")) 	
								{
									JSONArray includedArray =jsonObject.getJSONArray("included");
									//System.out.println( includedArray);

									if(includedArray!=null)
									{
										int arraySize =includedArray.length();
										
											for (int arrayIndex = 0; arrayIndex < arraySize; arrayIndex++) {
												try {							
													JSONObject includedArrayObject =includedArray.getJSONObject(arrayIndex);
													
													if(includedArrayObject.has("*followingInfo"))
													{
												        JSONObject staffCountRange=includedArrayObject.getJSONObject("staffCountRange");
												        startEmployeeCount= staffCountRange.get("start").toString();
												        endEmployeeCount=staffCountRange.get("end").toString();
												       
												        
												        if(includedArrayObject.has("url"))
														{
												        	 linkedInCompanyUrl=includedArrayObject.getString("url");
												        
														}
												        if(includedArrayObject.has("name"))
														{
												        	companyName=includedArrayObject.getString("name");
												        	doc=Jsoup.connect("https://www.google.com/search?q="+companyName+"&rlz=1C1GCEA_enIN883IN883&oq=woundtech&aqs=chrome.0.69i59j0l7.6558j1j8&sourceid=chrome&ie=UTF-8").get();
												    		//System.out.println(doc.select("div[class=TbwUpd NJjxre]").first().text());
												    	companyUrl=doc.select("div[class=TbwUpd NJjxre]").first().text();
												    	
												        	
												        	
														}
														System.out.println("----------------------------------------------");
														System.out.println("Company Name        ----->"+companyName);
												        System.out.println("start employee count----->"+startEmployeeCount);
														System.out.println("end employee count  ----->"+endEmployeeCount);
														System.out.println("LinkedIn company url----->"+linkedInCompanyUrl);
														System.out.println("Company Url         ----->"+companyUrl);
														System.out.println("----------------------------------------------");
													}
													
												}catch (Exception e) {
													e.printStackTrace();
												}
											
										}
									}
								}


							}

						}
					}
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}

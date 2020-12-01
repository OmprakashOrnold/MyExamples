package com.aldrich.patent;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Random;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CapterrProductInfo {

	public static void main(String[] args) {
		Document documnet = null;

		for (Long productId=78268L; productId <=500000L ; productId++) {
			try{
				documnet = JsoupConnector(documnet, productId);		
				//Thread.sleep(randomNumber(5000));
				processDocument(documnet, productId);
			}catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	public static void processDocument(Document documnet, Long productId) {
		String jsonResponse=null;
		Element productName=documnet.select("h1[class='ProductHeader__ProductHeading-sc-10fs9um-2 bJyZoY Heading-p3hmo4-0 girLqU']").first();
		if(productName!=null)
		{
			Elements script_tag = documnet.select("script");
			String Json = script_tag.toString().substring(script_tag.toString().indexOf(" window['SSR_BRIDGE_DATA'] = "),script_tag.toString().indexOf("<script>(function()"));
			jsonResponse=Json.replace(" window['SSR_BRIDGE_DATA'] = ", "").replace("</script>","" );
			saveFileInLocal(jsonResponse, productId);
			System.out.println("for this "+productId+" productId succesfully json file is saved");
		}
	}

	public static void saveFileInLocal(String jsonResponse, Long productId) {
		try (FileWriter writer = new FileWriter(
				"C:\\OmPrakash\\capetrra\\"+productId+".txt", true);
				BufferedWriter bw = new BufferedWriter(writer)) {				
			bw.write(jsonResponse.trim());
			bw.write("\n");

		} catch (IOException ex) {
			System.err.format("IOException: %s%n", ex);
		}
	}

	public static Document JsoupConnector(Document documnet, Long productId) {
		try {
			documnet=Jsoup.connect("https://www.capterra.com/p/"+productId+"/SuperMap-Desktop-GIS/")
					.userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:79.0) Gecko/20100101 Firefox/79.0")
					.ignoreHttpErrors (true) // This is very important, otherwise it will report HTTP error fetching URL. Status = 404
					.get();  
		}
		catch (UnknownHostException  e) {
			e.getMessage();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return documnet;
	}

	public static int randomNumber(int number) {
		// create instance of Random class 
		Random rand = new Random(); 

		// Generate random integers in range 0 to 999 
		int rand_int1 = rand.nextInt(number);
		return rand_int1;
	} 


}

package com.aldrich.conferance;

import java.io.File;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Conferance3 {

	public static void main(String[] args) {
	
		Document document = null;
		File fullFileName = new File("C://OM//Speakers.html");
		
		try{
		document = Jsoup.parse(fullFileName, "UTF-8");
		
		Elements mainLinks=document.select("object[class='object-trade-thumbnail wow fadeInUp']");
		for (Element element : mainLinks) {
			
			
			System.out.println(element.attr("data"));
			
			
		}
		
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}

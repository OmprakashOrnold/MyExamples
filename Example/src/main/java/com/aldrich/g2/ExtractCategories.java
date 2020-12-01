package com.aldrich.g2;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;

public class ExtractCategories {

	public static void main(String[] args) {

	
		String jsonData=null;

		//File folder = new File("C:\\Users\\OmPrakashPeddamadtha\\Desktop\\g2");
		//	File[] listOfFiles = folder.listFiles();
		//	for (File file : listOfFiles) {
		//	if (file.isFile()) {
		try {
			String fullFileName = "C:\\Users\\OmPrakashPeddamadtha\\Downloads\\categores_from_software.txt";
			jsonData=readFileAsString(fullFileName);

			if (jsonData != null) {
				System.out.println(jsonData);
				JSONObject jsonObject = new JSONObject(jsonData);					
				if (jsonObject != null&& jsonObject.has("data")) {
					
					System.out.println(jsonObject);
					
					
					
				}
			}


		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static String readFileAsString(String fileName)throws Exception 
	{ 
		String data = ""; 
		data = new String(Files.readAllBytes(Paths.get(fileName))); 
		return data; 
	}
}

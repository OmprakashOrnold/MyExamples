import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import org.json.simple.parser.JSONParser;

public class ExtractingCrunchBaseData
{
	public static void main(String [] args)
	{
		String pageContent="";
		try
		{
			//connection 
			URL url = new URL("https://api.crunchbase.com/v3.1/organizations/lavu?user_key=56ae4c3d0a2b28af6e82c4e56d9c9824");

			HttpURLConnection conn = (HttpURLConnection)url.openConnection();

			conn.setRequestMethod("GET");

			conn.connect();

			//taking data from json
			Scanner sc = new Scanner(url.openStream());
			while(sc.hasNext())
			{
				pageContent=pageContent+sc.nextLine();
			}

			sc.close();
			JSONObject jsonObject = new JSONObject(pageContent);
			JSONObject dataObject= jsonObject.getJSONObject("data");
			JSONObject relationshipsObject= dataObject.getJSONObject("relationships");
			JSONObject foundersObject= relationshipsObject.getJSONObject("founders");
			JSONObject current_teamObject= relationshipsObject.getJSONObject("current_team");
			JSONObject 	past_teamObject =relationshipsObject.getJSONObject("past_team");
			//founders
			if(foundersObject.has("items"))
			{
				JSONObject pagingObject=foundersObject.getJSONObject("paging");
				System.out.println("Founder are "+pagingObject.get("total_items"));
				System.out.println();
				
				
				JSONArray itemsArray = foundersObject.getJSONArray("items");
				System.out.println("Founders Details");
				System.out.println("--------------------------");
				if (itemsArray.length() > 0) {

					for (int index = 0; index < itemsArray.length(); index++) {
						JSONObject innerObject1 = itemsArray.getJSONObject(index);
						if(innerObject1.has("properties"))
						{
							JSONObject propertiesObject= innerObject1.getJSONObject("properties");
							System.out.println("First Name :"+propertiesObject.get("first_name"));
							System.out.println("Last Name :"+propertiesObject.get("last_name").toString().replace("/", "").trim());
							System.out.println("gender :"+propertiesObject.get("gender"));
							System.out.println("Role investor "+propertiesObject.get("role_investor"));
							System.out.println();
						}
					}
				}
			}

			//current team
			if(current_teamObject.has("items"))
			{

				JSONObject pagingObject1=current_teamObject.getJSONObject("paging");
				System.out.println("Current Team are "+pagingObject1.get("total_items"));
				System.out.println();
				JSONArray itemsArray = current_teamObject.getJSONArray("items");
				//System.out.println(itemsArray);
				System.out.println("curret team names");
				System.out.println("--------------------------");
				if (itemsArray.length() > 0) {

					for (int index = 0; index < itemsArray.length(); index++) {
						JSONObject innerObject = itemsArray.getJSONObject(index);
						JSONObject relationshipsObject1=innerObject.getJSONObject("relationships");
						JSONObject personObject=relationshipsObject1.getJSONObject("person");
						if(personObject.has("properties"))
						{
							JSONObject propertiesObject= personObject.getJSONObject("properties");
							System.out.println("First Name :"+propertiesObject.get("first_name"));
							System.out.println("Last Name :"+propertiesObject.get("last_name").toString().replace("/", "").trim());
							System.out.println("gender :"+propertiesObject.get("gender"));
							System.out.println("Role investor "+propertiesObject.get("role_investor"));
							System.out.println();

						}
					}
				}
			}
			//past team
			if(	past_teamObject.has("items"))
			{

				JSONObject pagingObject2=past_teamObject.getJSONObject("paging");
				System.out.println("Past Team are "+pagingObject2.get("total_items"));
				System.out.println();
				JSONArray itemsArray1 = past_teamObject.getJSONArray("items");
				//System.out.println(itemsArray);
				System.out.println("Past team names");
				System.out.println("--------------------------");
				if (itemsArray1.length() > 0) {

					for (int index = 0; index < itemsArray1.length(); index++) {
						JSONObject innerObject = itemsArray1.getJSONObject(index);
						JSONObject relationshipsObject2=innerObject.getJSONObject("relationships");
						JSONObject personObject1=relationshipsObject2.getJSONObject("person");
						if(personObject1.has("properties"))
						{
							JSONObject propertiesObject2= personObject1.getJSONObject("properties");
							System.out.println("First Name :"+propertiesObject2.get("first_name"));
							System.out.println("Last Name :"+propertiesObject2.get("last_name").toString().replace("/", "").trim());
							System.out.println("gender :"+propertiesObject2.get("gender"));
							System.out.println("Role investor "+propertiesObject2.get("role_investor"));
							System.out.println();

						}
					}
				}
			}

		}
		catch(Exception e)
		{

		}
	}
}
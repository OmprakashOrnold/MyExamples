package com.aldrich.companyaddress;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.JSONObject;

public class USAddressParser {

	public static void main(String[] args) {

		List<String> adrs=new ArrayList<String>();
		adrs.add("	164 Market Street, Suite 167 Charleston, South Carolina, 29401	");
		adrs.add("	227 Sandy Springs Place, Suite D126 Atlanta, Georgia 30328	");
		adrs.add("	3700 South College Avenue, Unit 102 Fort Collins, CO 80525	");
		adrs.add("	12671 High Bluff Drive, Suite 200 San Diego, CA 92130	");
		adrs.add("	9850 Redhill Dr, Cincinnati, OH 45242	");
		adrs.add("	20 Jacksonville Beach, FL 32250	");
		adrs.add("	60 Bethpage Road, Hicksville, NY, 11801	");
		adrs.add("	311 west 43rd street 10th floor New York, NY 10036 18665	");
		adrs.add("	3775 Park Ave, Unit 12 Edison, NJ 08820 18665	");
		adrs.add("	2020 99 High Street, Suite 2800 Boston, MA 02110	");
		adrs.add("	35 West Wacker Drive Chicago, Illinois 60601	");
		adrs.add("	807 Debuel Road, Lutz, Florida 33549	");
		adrs.add("	1540 Main ST Ste 218, #294 Windsor, CO 80550	");
		adrs.add("	120 Graham Way Suite 100 Shelburne, VT 05482	");
		adrs.add("	1772 S Sunset Dr Kaysville, UT 84037	");
		adrs.add("	200 Jacksonville, Florida 32216	");
		adrs.add("	440 N Wolfe Road Sunnyvale, CA 94085	");
		adrs.add("	510658 Livonia, MI 481516658 8552280154	");
		adrs.add("	714 Hampton Drive Los Angeles, California 90291	");
		adrs.add("	761 Boeneman Drive, Houston, TX 77091	");
		adrs.add("	2229 South Michigan Ave Suite 303 Chicago, IL 60616	");
		adrs.add("	714 Hampton Drive Los Angeles, California 90291	");
		adrs.add("	1507 Terra Nova Blvd, Pacifica, CA 94044	");
		adrs.add("	31 Victory Court, Metuchen, NJ 08840	");
		adrs.add("	3511 Silverside Road, Suite 105, Wilmington, DE 19810	");
		adrs.add("	90 Peachtree Pl NE Atlanta, GA 30309	");
		adrs.add("	6114 LA SALLE AVE STE 183, OAKLAND, CA 94611	");
		adrs.add("	714 Hampton Drive Los Angeles, California 90291	");
		adrs.add("	900 Clopper Road, Suite 130 Gaithersburg, MD 20878	");
		adrs.add("	175 W 200 S, Garden level Salt Lake City, UT 84101	");
		adrs.add("	400 Logue Avenue Mountain View, CA 94043 4519 Admiralty Way Suite C Marina Del Rey, CA 90292	");
		adrs.add("	2000 Cincinnati, OH 45236 Quotient Ahalogy 1140 Main Street 3rd Floor Cincinnati, Ohio 45202	");
		adrs.add("	263 West 38th Street 9th floor New York, NY 10018	");
		adrs.add("	2820 Walton Cmns W, Suite 118 Madison, WI 53718 2624582470	");
		adrs.add("	2600 Gribbin Drive Lexington KY, 40517	");
		adrs.add("	220 Davidson Avenue, Somerset, NJ 08873	");
		adrs.add("	480191 Ft Lauderdale, FL 333480191	");
		adrs.add("	228 Park Ave S #90047 New York, New York 100031502	");
		adrs.add("	5444 Wade Park Blvd Suite 400 Raleigh, NC 27607	");
		adrs.add("	1901 Harrison Street, Suite 1700 Oakland, CA 94612	");
		adrs.add("	101 North Main Street Suite 308 Greenville, SC 29601	");
		adrs.add("	6330 South 3000 East Suite 700 Salt Lake City, UT 84121	");
		adrs.add("	714 Hampton Drive Los Angeles, California 90291	");
		adrs.add("	1055 West 7th Street, Los Angeles, CA 90017	");
		adrs.add("	516 Tennessee Street Suite #224 Memphis, TN 38103	");
		adrs.add("	4255574360 Meadow Creek Office Building 22525 64th St, Second Floor Issaquah, WA 98027	");
		adrs.add("	1145 12th Ave NW Suite C3 Issaquah, WA 98027	");
		adrs.add("	30 Lone Pine Trail Old Lyme, Connecticut 06371	");
		adrs.add("	714 Hampton Drive Los Angeles, California 90291	");

		for (String address : adrs) {
			saveLocationCityStateZCountryZip(address);	
		}
	}

	public static void saveLocationCityStateZCountryZip(String address) {
		String pageContent="";
		try {
			//connection 
			URL url = new URL("http://api.addresslabs.com/v1/parsed-address?address="+address.trim().replace(" ", "%20"));
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("POST");
			conn.connect();
			//taking data from json
			Scanner sc = new Scanner(url.openStream());
			while(sc.hasNext())
			{
				pageContent=pageContent+sc.nextLine();
			}
			sc.close();
			JSONObject jsonObject = new JSONObject(pageContent);
			JSONObject deliveryObject = jsonObject.getJSONObject("delivery");
			System.out.println(deliveryObject.get("address_line")+"--"+jsonObject.get("city")+"--"+jsonObject.get("state")+"--"+jsonObject.get("zip"));

			
		} catch (Exception e) {
			System.out.println("addresss format is different!!!!!!");
		}
	}

}

package com.aldrich.companyaddress;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.aldrich.pase.util.RegularExpressionUtils;
public class RegEx {

	public static void main(String[] args) {

		List<String> address=new ArrayList<String>();


		address.add("	901 Bringham Ave.Los Angeles, California 90049 - United States");
		address.add("	5th Floor, Plot No ITC 2 IT Park, Sector 67 Mohali PB 160062 India	");
		address.add("	3700 South College Avenue, Unit 102 Fort Collins, CO 80525	");
		address.add("	12671 High Bluff Drive, Suite 200 San Diego, CA 92130	");
		address.add("	9850 Redhill Dr, Cincinnati, OH 45242	");
		address.add("	20 Jacksonville Beach, FL 32250	");
		address.add("	60 Bethpage Road, Hicksville, NY, 11801	");
		address.add("	00139800  34FA00110800	");
		address.add("	60 Bethpage Road Hicksville NY 11801 18665	");
		address.add("	311 west 43rd street 10th floor New York, NY 10036 18665	");
		address.add("	320 Brooklyn, NY 11232 18665	");
		address.add("	3775 Park Ave, Unit 12 Edison, NJ 08820 18665	");
		address.add("	33487 8665736879	");
		address.add("	440 N Wolfe Road Sunnyvale, CA 94085	");
		address.add("	040  29800028	");
		address.add("	480191 Ft Lauderdale, FL 333480191	");
		address.add("	1 Keong Saik Road Level 2 The Working Capitol Singapore 019189	");
		address.add("	714 Hampton Drive Los Angeles, California 90291	");
		address.add("	761 Boeneman Drive, Houston, TX 77091	");
		address.add("	2229 South Michigan Ave Suite 303 Chicago, IL 60616	");
		address.add("	2016 Psycholate is ISO 27001	");
		address.add("	6032 Emeryville, Ca. 94608	");
		address.add("	714 Hampton Drive Los Angeles, California 90291	");
		address.add("	1 to be resource, boolean given in homecontent4712728447	");
		address.add("	000000 0.000000	");
		address.add("	249660 123.119340	");
		address.add("	18004194426 08242868088	");
		address.add("	18004194426 Chat 08242868088	");
		address.add("	1507 Terra Nova Blvd, Pacifica, CA 94044	");
		address.add("	31 Victory Court, Metuchen, NJ 08840	");
		address.add("	3511 Silverside Road, Suite 105, Wilmington, DE 19810	");
		address.add("	90 Peachtree Pl NE Atlanta, GA 30309	");
		address.add("	6114 LA SALLE AVE STE 183, OAKLAND, CA 94611	");
		address.add("	228 Park Ave S #90047 New York, New York 100031502	");
		address.add("	714 Hampton Drive Los Angeles, California 90291	");
		address.add("	900 Clopper Road, Suite 130 Gaithersburg, MD 20878	");
		address.add("	175 W 200 S, Garden level Salt Lake City, UT 84101	");
		address.add("	18004194426 08242868088	");
		address.add("	18004194426 Chat 08242868088	");
		address.add("	400 Logue Avenue Mountain View, CA 94043 4519 Admiralty Way Suite C Marina Del Rey, CA 90292	");
		address.add("	2000 Cincinnati, OH 45236 Quotient Ahalogy 1140 Main Street 3rd Floor Cincinnati, Ohio 45202	");
		address.add("	263 West 38th Street 9th floor New York, NY 10018	");
		address.add("	1050 Nashville, TN 37203	");
		address.add("	2 Ibn Gabirol St Tel Aviv, Israel 6407702	");
		address.add("	2820 Walton Cmns W, Suite 118 Madison, WI 53718 2624582470	");
		address.add("	2600 Gribbin Drive Lexington KY, 40517	");
		address.add("	424 San Francisco, CA 94108	");
		address.add("	220 Davidson Avenue, Somerset, NJ 08873	");
		address.add("	2015 12224	");
		address.add("	4 Suite 200 Austin, TX 78727	");
		address.add("	5444 Wade Park Blvd Suite 400 Raleigh, NC 27607	");
		address.add("	123 87044	");
		address.add("	1901 Harrison Street, Suite 1700 Oakland, CA 94612	");

		for (String string : address) {

			if(countChar(string.trim())>25&&wordcount(string.trim())<23)
			{
			System.out.println(getLocation(string.trim()));
			}

		}

	}

	public static String getLocation(String addressText)
	{
		String location = "";
		String zipcode="\\d{5}(?:-\\d{4})?";
		String abbrev = "AL|AK|AS|AZ|AR|CA|CO|CT|DE|DC|FM|FL|GA|GU|HI|ID|IL|IN|IA|KS|KY|LA|ME|MH|MD|MA|MI|MN|MS|MO|MT|NE|NV|N.Y.|NH|NJ|NM|NY|NC|ND|MP|OH|OK|OR|PW|PA|PR|RI|SC|SD|TN|TX|UT|VT|VI|VA|WA|WV|WI|WY";
		String street = "\\d+[ ](?:[A-Za-z\\s0-9,.#]?)+[ ]?(?:[A-Za-z\\s0-9.,#]?)[ ]?(?:[A-Za-z\\s0-9.,#]?)[ ]?(?:[A-Za-z\\s0-9.,#]?)[ ]?(?:Avenue|Lane|Roadz|Boulevard|Drive|Street|Ave|Dr|Rd|Blvd|Ln|St|Suite|th|[0-9]|[a-zA-Z#]?[ ]?)\\.?[ ]?[#]?[ ]?\\d?";
		String state = "Alabama|Alaska|Arizona|Arkansas|California|Colorado|Connecticut|Delaware|Florida|Georgia|Hawaii|Idaho|Illinois|Indiana|Iowa|Kansas|Kentucky|Louisiana|Maine|Maryland|Massachusetts|Michigan|Minnesota|Mississippi|Missouri|Montana|Nebraska|Nevada|New[ ]Hampshire|New[ ]Jersey|New[ ]Mexico|New[ ]York|North[ ]Carolina|North[ ]Dakota|Ohio|Oklahoma|Oregon|Pennsylvania|Rhode[ ]Island|South[ ]Carolina|South[ ]Dakota|Tennessee|Texas|Utah|Vermont|Virginia|Washington|West[ ]Virginia|Wisconsin|Wyoming";
		String reg = street + "[,]?[ ]?([{" + state + "}|{" + abbrev + "}]?)[,]?[ ]?"+zipcode;
		Pattern compiled = Pattern.compile(reg);
		try {

			Matcher matcher = RegularExpressionUtils.createMatcherWithTimeout(addressText, compiled, 10000);
			if (matcher.find()) {
				location = matcher.group();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return location;
	}




	public static String getCityStateZipcode(String addressText)
	{
		String location=null;
		String zipcode="((?!.*[DFIOQU])[A-VXY][0-9][A-Z] ?[0-9][A-Z][0-9])|(\\d{5}(?:-\\d{4})?)";
		String city="(?:[A-Z][a-z.-]+[ ]?)+";
		String abbrevUS="AL|AK|AS|AZ|AR|CA|CO|CT|DE|DC|FM|FL|GA|GU|HI|ID|IL|IN|IA|KS|KY|LA|ME|MH|MD|MA|MI|MN|MS|MO|MT|NE|N.Y.|NV|NH|NJ|NM|NY|NC|ND|MP|OH|OK|OR|PW|PA|PR|RI|SC|SD|TN|TX|UT|VT|VI|VA|WA|WV|WI|WY|AB|BC|MB|N[BLTSU]|ON|PE|QC|SK|YT";
		String stateUS="Alabama|Alaska|Arizona|Arkansas|California|Colorado|Connecticut|Delaware|Florida|Georgia|Hawaii|Idaho|Illinois|Indiana|Iowa|Kansas|Kentucky|Louisiana|Maine|Maryland|Massachusetts|Michigan|Minnesota|Mississippi|Missouri|Montana|Nebraska|Nevada|New[ ]Hampshire|New[ ]Jersey|New[ ]Mexico|New[ ]York|North[ ]Carolina|North[ ]Dakota|Ohio|Oklahoma|Oregon|Pennsylvania|Rhode[ ]Island|South[ ]Carolina|South[ ]Dakota|Tennessee|Texas|Utah|Vermont|Virginia|Washington|West[ ]Virginia|Wisconsin|Wyoming|Alberta|British[ ]Columbia|Manitoba|New[ ]Brunswick|Newfoundland[ ]and[ ]Labrador|Northwest[ ]Nova[ ]Scotia|Nunavut|Ontario|Quebec|Saskatchewan|Yukon|Prince[ ]Edward[ ]Island";

		String abbrevCA ="AB|BC|MB|N[BLTSU]|ON|PE|QC|SK|YT";
		String stateCA = "Alberta|British[ ]Columbia|Manitoba|New[ ]Brunswick|Newfoundland[ ]and[ ]Labrador|Northwest[ ]Nova[ ]Scotia|Nunavut|Ontario|Quebec|Saskatchewan|Yukon|Prince[ ]Edward[ ]Island";



		String reg=city+"[,]?[ ]?("+stateUS+"|"+stateCA+"|"+abbrevUS+"|"+abbrevCA+")[,]?[ ]?"+zipcode;
		Pattern compiled = Pattern.compile(reg);
		try{

			Matcher matcher = RegularExpressionUtils.createMatcherWithTimeout(addressText, compiled, 10000);
			if(matcher.find()){				
				location=matcher.group();				
			}
		}catch(Exception e)
		{
			System.out.println("null");
		}
		return 	location;



	}


	public static Integer countChar(String string) {

		int count = 0;    

		//Counts each character except space    
		for(int i = 0; i < string.length(); i++) {    
			if(string.charAt(i) != ' ')    
				count++;    
		}
		return count;
	}

	public static String getStreetAddress(String addressText)
	{
		String location=null;
		String zipcode="\\d{5}(?:-\\d{4})?";
		String city="(?:[A-Z][a-z.-]+[ ]?)+";
		String abbrev="AL|AK|AS|AZ|AR|CA|CO|CT|DE|DC|FM|FL|GA|GU|HI|ID|IL|IN|IA|KS|KY|LA|ME|MH|MD|MA|MI|MN|MS|MO|MT|NE|N.Y.|NV|NH|NJ|NM|NY|NC|ND|MP|OH|OK|OR|PW|PA|PR|RI|SC|SD|TN|TX|UT|VT|VI|VA|WA|WV|WI|WY";
		String state="Alabama|Alaska|Arizona|Arkansas|California|Colorado|Connecticut|Delaware|Florida|Georgia|Hawaii|Idaho|Illinois|Indiana|Iowa|Kansas|Kentucky|Louisiana|Maine|Maryland|Massachusetts|Michigan|Minnesota|Mississippi|Missouri|Montana|Nebraska|Nevada|New[ ]Hampshire|New[ ]Jersey|New[ ]Mexico|New[ ]York|North[ ]Carolina|North[ ]Dakota|Ohio|Oklahoma|Oregon|Pennsylvania|Rhode[ ]Island|South[ ]Carolina|South[ ]Dakota|Tennessee|Texas|Utah|Vermont|Virginia|Washington|West[ ]Virginia|Wisconsin|Wyoming";
		String street="\\d+[ ](?:[A-Za-z0-9.-]+[ ]?)+(?:Avenue|Lane|Road|Boulevard|Drive|Street|Ave|Dr|Rd|Blvd|Ln|St)\\.?";

		Pattern compiled = Pattern.compile(street);
		try{

			Matcher matcher = RegularExpressionUtils.createMatcherWithTimeout(addressText, compiled, 10000);
			if(matcher.find()){				
				location=matcher.group();				
			}
		}catch(Exception e)
		{
			System.out.println("null");
		}
		return 	location;


	}

	public static String getStreetcAddress(String addressText)
	{
		String location=null;
		//regular expression to match the address type
		Pattern newPattern = Pattern.compile("");
		Matcher newMatcher = newPattern.matcher(addressText);

		MatchResult result = null;
		while (newMatcher.find())
		{
			result = newMatcher.toMatchResult();
			System.out.println(result.group());


		}
		return 	location;
	}

	public static String getCALocation(String addressText) {
		String locationCanada= "";
		String city="(?:[A-Z][a-z.-]+[ ]?)+";
		String abbrevCA ="AB|BC|MB|N[BLTSU]|ON|PE|QC|SK|YT";
		String stateCA = "Alberta|British[ ]Columbia|Manitoba|New[ ]Brunswick|Newfoundland[ ]and[ ]Labrador|Northwest[ ]Nova[ ]Scotia|Nunavut|Ontario|Quebec|Saskatchewan|Yukon|Prince[ ]Edward[ ]Island";
		String zipcode="(?!.*[DFIOQU])[A-VXY][0-9][A-Z] ?[0-9][A-Z][0-9]";

		String reg=city+"[,]?[ ]?("+stateCA+"|"+abbrevCA+")[,]?[ ]?"+zipcode;
		Pattern compiled = Pattern.compile(reg);
		try {

			Matcher matcher = RegularExpressionUtils.createMatcherWithTimeout(addressText, compiled, 10000);
			if (matcher.find()) {
				locationCanada = matcher.group();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return locationCanada;
	}




	public static int wordcount(String string)  
	{  
		int count=0;  

		char ch[]= new char[string.length()];     
		for(int i=0;i<string.length();i++)  
		{  
			ch[i]= string.charAt(i);  
			if( ((i>0)&&(ch[i]!=' ')&&(ch[i-1]==' ')) || ((ch[0]!=' ')&&(i==0)) )  
				count++;  
		}  
		return count;  
	}  

}




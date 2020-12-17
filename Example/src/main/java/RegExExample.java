import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExExample {

	public static void main(String[] args) {
		
		 String string = "Hi here is my date omprakash@gmail.com somthing is there";
		 
		 RegExExample re=new RegExExample();
		 System.out.println(re.getDateFromString(string));
	}

	public  String getDateFromString(String nik)
	{
		String date=null;
		String regex = "\\w{1,20}[\\@](gmail.com)";
		
		
		Pattern pattern = Pattern.compile(regex);
	    Matcher matcher = pattern.matcher(nik);
	    while (matcher.find()){
	    	 date=matcher.group();
	    }	
	    
	    
	    
		return date;
	}
}

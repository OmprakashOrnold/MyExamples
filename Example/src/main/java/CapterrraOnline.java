import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CapterrraOnline {

	public static void main(String[] args) {


		Document document=null;
		String categoryLink=null;
		
		int x=100;
		
		Integer y=Integer.valueOf(x);
		
		Integer z=y.intValue();
		
		System.out.println(z);
		
		String link="https://www.capterra.com/directoryPage/rest/v1/category?htmlName=360-degree-feedback-software&countryCode=US";
		try{
			document=Jsoup.connect(link).ignoreHttpErrors(true).ignoreContentType(true).userAgent("Mozilla").get();
			System.out.println(document.text().toString().trim());
		
			
		}catch(Exception e)	
		{
			e.printStackTrace();
		}
	}

}

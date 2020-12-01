import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup; 
import org.jsoup.nodes.Document; 
import org.jsoup.nodes.Element; 
import org.jsoup.select.Elements; 
 
public class Example100 { 
   public static void main(String[] args){ 
	   List<String> list=new ArrayList<>();
		  list.add("https://twitter.com/unifiedpayments?lang=ga");
		  list.add("https://twitter.com/hightoweradvsor");
		  
		  System.out.println(list.get(0));
   } 
} 

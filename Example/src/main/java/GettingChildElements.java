import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GettingChildElements {

	public static void main(String[] args) {

		try {
			Document document = Jsoup.parse(new File("C:/Users/oppeddamadthala/Desktop/demo.html"), "UTF-8");
			
			
			Element firstElement = document.getElementsByTag("body").first().children().first();
			 
		
			System.out.println( "first child tag: " + firstElement.tagName());
			System.out.println("Selecting all HTML child elements using selector");
			Elements childElements = document.select("ul.languages > li");
			System.out.println(childElements);

			System.out.println("Selecting first child element using selector");
			Element firstChild = document.select("ul.languages > li").first();
			System.out.println(firstChild);


			System.out.println("Selecting last child element using selector");
			Element lastChild = document.select("ul.languages > li").last();
			System.out.println(lastChild);


			System.out.println("Selecting child element by index using selector");
			Element child = document.select("ul.languages > li").get(0);
			System.out.println(child);


			Element bodyElement = document.getElementsByTag("body").first();
			System.out.println( document.select("body img") );
			Element firstPElement = document.select("p").first(); 
			System.out.println( "CSS class name: " + firstPElement.className() );
			Element firstListElement = document.select("ul").first();
			System.out.println( "CSS class name: " + firstListElement.className() );
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

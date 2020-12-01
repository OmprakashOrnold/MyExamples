import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GettingSibilings {

	public static void main(String[] args) {

		try {
			Document document = Jsoup.parse(new File("C:/Users/oppeddamadthala/Desktop/demo.html"), "UTF-8");
			
			Element liElement = document.getElementsByClass("list mobiles").first();

			
			System.out.println("Selecting all sibling elements of li");
			Elements siblings = liElement.siblingElements();
			System.out.println(siblings);

			
			System.out.println("First sibling element");
			System.out.println( liElement.firstElementSibling() );

			
			System.out.println("Last sibling element");
			System.out.println( liElement.lastElementSibling() );

			
			System.out.println("All previous sibling elements");
			System.out.println( liElement.previousElementSibling() );

			
			System.out.println("All next sibling elements");
			System.out.println( liElement.nextElementSibling() );

		
			System.out.println("Previous sibling element");
			System.out.println( liElement.previousElementSibling() );

			
			System.out.println("Next sibling element");
			System.out.println( liElement.nextElementSibling() );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

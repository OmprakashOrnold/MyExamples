import java.io.File;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SelectElementsBySpecific {

	public static void main(String[] args) {
		try {

			Document document = Jsoup.parse(new File("C:/Users/oppeddamadthala/Desktop/demo.html"), "UTF-8");


			System.out.println("Selecting HTML elements having data-location attribute value starting with wiki");

			Elements elements1 = document.getElementsByAttributeValueStarting("data-location", "wiki"); 
			if(elements1.size() > 0) 
				System.out.println(elements1.get(0));

			System.out.println("Selecting HTML elements having data-location attribute value starting with wiki using selector"); 
			Elements elements2 = document.select("[data-location^=wiki]");
			if(elements2.size() > 0)
				System.out.println(elements2.get(0));

			System.out.println("Selecting HTML elements having class attribute value ending with tro"); 
			Elements elements3 = document.getElementsByAttributeValueEnding("class", "tro"); 
			if (elements3.size() > 0) 
				System.out.println(elements3.get(0));


			System.out.println("Selecting HTML elements having class attribute value ending with tro using selector");
			Elements elements4 = document.select("[class$=tro]"); 
			if (elements4.size() > 0) 
				System.out.println(elements4.get(0));

			System.out.println("Selecting HTML elements having id attribute value containing eeti");
			Elements elements5 = document.getElementsByAttributeValueContaining("id","eeti");
			if (elements5.size() > 0)
				System.out.println(elements5.get(0));

			System.out.println("Selecting HTML elements having attribute value  containing eeti using selector"); 
			Elements elements6 = document.select("[id*=eeti]"); 
			if (elements6.size() >0)
				System.out.println(elements6.get(0));

			System.out.println("Selecting HTML elements having data-name attribute value matching regex");
			Elements elements7 =
					document.getElementsByAttributeValueMatching("data-name", ".*sung$"); 
			if(elements7.size() > 0) 
				System.out.println(elements7.get(0));

			System.out.println("Selecting HTML elements having data-name attribute value matching regex using selector");
			Elements elements8 = document.select("[data-name~=.*sung$]");
			if(elements8.size() > 0) 
				System.out.println(elements8.get(0));
			
			//getting children

			Elements elements9 = document.getElementsByClass("languages");
			if(elements9.size() > 0){

				Element ulElement = elements9.get(0);
				System.out.println("ulelement"+ulElement);

				System.out.println("Selecting all HTML child elements");


				Elements childElements = ulElement.children();
				System.out.println(childElements);

				System.out.println("Selecting first child element by index");
				System.out.println( ulElement.child(0) );

				System.out.println("Selecting last child element by index");
				System.out.println( ulElement.child( ulElement.children().size() - 1 ) );

			}


		} catch (Exception e) {
			e.printStackTrace();
		}


	}

}

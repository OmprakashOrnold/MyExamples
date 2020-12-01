import java.io.File;
import java.io.IOException;
import java.security.KeyStore.Entry.Attribute;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupWorkingOnHtmlFile {

	public static void main(String[] args) {
		try {
			Document doc=Jsoup.parse(new File("C:/Users/oppeddamadthala/Desktop/demo.html"),"UTF-8");


			Element element=doc.getElementById("greeting");
			System.out.println(element);

			Elements elements = doc.select("#greeting"); 
			System.out.println(elements);


			Elements element2=doc.getElementsByTag("title");
			System.out.println(element2);

			Elements elements3=doc.select("title"); 
			System.out.println(elements3);



			System.out.println("Fetching using DOM syntax");

			Elements elements4 = doc.getElementsByClass("list");
			System.out.println(elements4);

			System.out.println("Fetching using CSS syntax");

			Elements elements5 = doc.select(".list"); 
			System.out.println(elements5);



			System.out.println("Fetching using DOM syntax");

			Elements elements6 = doc.getElementsByClass("list mobiles");
			if(elements6.size() > 0)
				System.out.println(elements6.get(0));

			System.out.println("Fetching using CSS syntax");

			Elements elements7 = doc.select(".list.mobiles");
			if(elements7.size() > 0)
				System.out.println(elements7.get(0));


			System.out.println("Selecting HTML tag name having specified class name");
			Elements elements8= doc.select("p.intro");
			if(elements8.size() > 0)
				System.out.println(elements8.get(0));

			System.out.println("Selecting HTML tag having specified id");
			Elements elements9 = doc.select("div#greeting");

			if(elements9.size() > 0)
				System.out.println(elements9.get(0));

			System.out.println("Selecting HTML elements having src attribute");
			Elements elements10 = doc.getElementsByAttribute("src");

			System.out.println(elements10);

			System.out.println("Selecting HTML elements having src attribute usign selector");
			Elements elements11 = doc.select("[src]");
			if(elements11.size() > 0)
				System.out.println(elements11.get(0));

			System.out.println("Selecting all div having id attribute");
			Elements elements12 = doc.select("div[id]");
			System.out.println(elements12);

			System.out.println("Selecting HTML elements having attribute name starting with data-");
			Elements elements13 = doc.getElementsByAttributeStarting("data-");
			if(elements13.size() > 0)
				System.out.println(elements13.get(0));

			System.out.println("Selecting HTML elements having attribute name starting with data- using selector");
			Elements elements14 = doc.select("[^data-]");
			if(elements14.size() > 0)
				System.out.println(elements14.get(0));

			System.out.println("Selecting HTML elements having specific attribute value");
			Elements elements15 = doc.getElementsByAttributeValue("data-index", "2");
			if(elements15.size() > 0)
				System.out.println(elements15.get(0));

			System.out.println("Selecting HTML elements having specific attribute value using selector");
			Elements elements16 = doc.select("[data-index=2]");
			if(elements16.size() > 0)
				System.out.println(elements16.get(0));
			
			
			Element ol = doc.select("ol").last();

			System.out.println( "List element html:\n" + ol.text()) ;


			Elements uls = doc.select("ul");
			System.out.println(uls.outerHtml());
			
			Element a = doc.select("a").first();
			System.out.println("Link href attribute: " + a.attr("href"));
			
			Attributes attribute=a.attributes();
			
			for (org.jsoup.nodes.Attribute attribute2 : attribute) {
				System.out.println(attribute2);
	
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}

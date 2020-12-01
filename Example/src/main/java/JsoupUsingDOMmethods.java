import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupUsingDOMmethods {

	public static void main(String[] args) {

		try {
			Document doc = Jsoup.connect("https://twitter.com/TCS?ref_src=twsrc%5Egoogle%7Ctwcamp%5Eserp%7Ctwgr%5Eauthor").get();
			//System.out.println(doc.title());

			//System.out.println(doc.html());

			/*
			 * Element id= doc.getElementById("mySidenav"); System.out.println(id);
			 */


			/*
			 * Elements tags=doc.getElementsByTag("span"); for (Element tag : tags) {
			 * System.out.println("tags are "+tag);
			 * 
			 * }
			 */


			/*
			 * Elements cls=doc.getElementsByClass("floating-form");
			 * System.out.println(" class is "+cls);
			 */


			/*
			 * Elements attribute=doc.getElementsByAttribute("content"); for (Element
			 * attributes : attribute) { System.out.println(attributes); }
			 */


			/*
			 * Element parent= doc.parent(); System.out.println(parent);
			 */

			/*
			 * Element child=doc.child(0); System.out.println("Child element "+child);
			 */

			/*
			 * Elements children=doc.children(); System.out.println(children);
			 */



		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

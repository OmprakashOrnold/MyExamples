import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ExtractCompetiterFromOwler {

	public static void main(String[] args) {
		Document document = null;
	

		File fullFileName = new File("C:\\Users\\oppeddamadthala\\Downloads\\Owler\\Owler\\1055.html");
		
		try {
			document = Jsoup.parse(fullFileName, "UTF-8");
			Elements div_elements = document.select("div");
			if (div_elements != null && div_elements.size() > 0) {
				for (Element element : div_elements) {
					if (element.hasAttr("class") && element.attr("class").equals("fc large tablets-ignore")) {
						if (element.childNodes().size() > 0) {
							for (int count = 0; count < element.childNodes().size(); count++) {
								try {
									if (element.child(count).hasAttr("class")
											&& element.child(count).attr("class").equals("table")) {
										if (element.child(count).childNodes().size() > 0) {
											
											Element inner = element.child(count);	
											
											System.out.println(inner);
												if (inner.nodeName().equals("div") && inner.hasAttr("class")
														&& inner.attr("class").equals(
																"table-row botifycompetitor")) {
													System.out.println(inner);
														
													
											   	
												}
											
										}
										
										
									}
								} catch (Exception ex) {
									//ex.printStackTrace();
								}
							}


						}
					}

				}
			}


		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
}

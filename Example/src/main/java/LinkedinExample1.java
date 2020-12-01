
import java.io.File;
import java.io.IOException;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import org.jsoup.select.Elements;

public class LinkedinExample1 {
	public static void main(String[] args) {
		try {

			File folder = new File("C:\\Users\\oppeddamadthala\\Downloads\\pase6.1\\pase6.1\\");
			File[] listOfFiles = folder.listFiles();

			for (File file : listOfFiles) {
				if (file.isFile()) {
					System.out.println(file.getName().replace(".html",""));

					Document doc=Jsoup.parse(new File("C:\\Users\\oppeddamadthala\\Downloads\\pase6.1\\pase6.1\\"+file.getName()),"utf-8");
					if(doc!=null) {
						Elements tags=doc.getElementsByClass("t-20 t-black");
						if (tags != null && tags.size() > 0) {
							int employes=Integer.parseInt(tags.text().toString().replace(" employees","").replace(",", "").trim());
							System.out.println(employes);

						}
						Elements country=doc.getElementsByClass("insight-container");
						if(country.hasClass("insight-container"))
						{
							if (country.get(0)!=null) {
								for (int i = 0; i < country.size(); i++) {

									Elements element3=country.get(i).getElementsByClass("t-16 t-bold t-black inline-block flex-1");
									System.out.println(element3.text());
									Elements element1=country.get(i).getElementsByTag("strong");
									for (int j = 0; j < element1.size(); j++) {

										System.out.println(element1.get(j).text());


										Elements element2=country.get(i).getElementsByClass("org-people-bar-graph-element__category");

										System.out.println(element2.get(j).text());

									}
                                  try {
									Thread.sleep(1000);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

								}
							}
						}
					}
					System.out.println("----------------------------------------------------------------------------");
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

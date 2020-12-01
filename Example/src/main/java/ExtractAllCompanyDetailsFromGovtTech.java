import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ExtractAllCompanyDetailsFromGovtTech {

	public static void main(String[] args) {

		try {
			Document doc = Jsoup.connect("https://www.govtech.com/100/2016/").followRedirects(true).timeout(0).get();
			for (Element table : doc.select("tbody"))
			{

				for (Element tr : table.select("tr"))
				{	
					
					Elements tds=tr.select("td");
					//System.out.println("----------------------------------------------------------");
				
					System.out.println(tr.tagName("td").getElementsByTag("a").text());
					//System.out.println("Founded     :"+tds.get(1).text());
					//System.out.println("HeadQuaters :"+tds.get(2).text());
					//System.out.println("Description :"+tds.get(3).text());
					Elements companyLink=tr.getElementsByAttributeValueContaining("href", ".html");
					

					String url=companyLink.attr("href");
					
					if(!url.isEmpty())
					{
						Document doc1 = Jsoup.connect(url).followRedirects(true).timeout(0).get();	
						Elements divTag =doc1.getElementsByClass("col-md-8");	
                        
						
						
						Elements table1=divTag.select("tbody");
						Elements tr1=table1.select("tr");

						Elements imageTag=divTag.select("img");	
                        System.out.println(imageTag.attr("src"));

						Element row1=tr1.get(0);
						Elements td1=row1.select("td");
						if(!td1.get(1).text().isEmpty())
						{
							//System.out.println("Acquisitions:"+td1.get(1).text());
						}




						Element row2=tr1.get(1);
						Elements td2=row2.select("td");
						if(!td2.get(1).text().isEmpty())
						{
							//System.out.println("Funding     :"+td2.get(1).text());
						}


						if(tr1.size()>4)
						{

							Element row4=tr1.get(4);
							Elements td4=row4.select("td");
							if(!td4.get(1).text().isEmpty())
							{
								//System.out.println("Categories  :"+td4.get(1).text().trim());
							}


							Elements divTagForCrunchBase =doc1.getElementsByClass("col-sm-4");
							Elements crunchBaseLink=divTagForCrunchBase.select("a");
							//System.out.println("CrunchBase Link     :"+crunchBaseLink.attr("href"));


						}
						if(tr1.size()>7)
						{
							Element row7=tr1.get(7); Elements td7=row7.select("td");
							//System.out.println("Employees   :"+td7.get(1).text());

							Element row5=tr1.get(5); 
							Elements td5=row5.select("td"); 
							Elements socialLink=td5.select("a");
							if(socialLink.size()>0)
							{
								//System.out.println("Facebook Link "+socialLink.get(0).attr("href"));
								if(socialLink.size()>1)
								{
									//System.out.println("Twitter Link "+socialLink.get(1).attr("href"));
								}
								if(socialLink.size()>2)
								{
									//System.out.println("Linked Link "+socialLink.get(2).attr("href"));
								}
							}
						}
					}
				}
			}
		} catch (IOException e) 
		{
			System.out.println();

		}catch (IndexOutOfBoundsException ee)
		{
			System.out.println(ee);
		}catch (Exception eee)
		{
			System.out.println(eee);
		}
	}
}

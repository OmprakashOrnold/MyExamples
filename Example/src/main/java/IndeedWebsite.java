import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class IndeedWebsite {

	public static void main(String[] args) {
		List<String> urls=new ArrayList<String>();

		urls.add("	http://www.indeed.com/viewjob?jk=0e6ebdd36944b809&qd=RUpyYwg65pn4GFpztfzjmjdq_BzfIEfBlf87CJpwCyO64R4TtKJO-1xHJv-CusJ2Kf1X0FSgsoYtnO6Imj_QwAKzzCVmZKitaEzJWqrPLViOC1wrnnrgj0QDi_ghBHXCONF_UajJqFsteOnGIgmm5Q&indpubnum=5427925295141725&atk=1e19jud5ef1b4800\r\n" + 
				"	");
		
		
		
		Iterator<String> it= urls.iterator();
		Document doc=null;
		String redirecturl=null;
		String redirecturl1=null;
		while (it.hasNext()) {
			String urlLinks = (String)it.next();	
			try {
				doc=Jsoup.connect(urlLinks).followRedirects(true).get();
				Elements thirdLink=doc.select("div");
				//System.out.println(thirdLink);
				if (thirdLink!=null && !thirdLink.isEmpty()) {

					for (Element applyLink : thirdLink) {
						try {
							if(applyLink.getElementsByClass("icl-Button icl-Button--primary icl-Button--md").first().attr("href")!="")
							{
								//System.out.println(applyLink.getElementsByClass("icl-Button icl-Button--primary icl-Button--md").attr("href"));
								
								if(!applyLink.getElementsByClass("icl-Button icl-Button--primary icl-Button--md").attr("href").contentEquals("/promo/resume"))
								{	
									System.out.println(applyLink.getElementsByClass("icl-Button icl-Button--primary icl-Button--md").attr("href"));
									redirecturl1=applyLink.getElementsByClass("icl-Button icl-Button--primary icl-Button--md").attr("href");
									Response response1 = Jsoup.connect(redirecturl1).execute();
									System.out.println(response1.url());
								}else
								{
									System.out.println("no link");
								}
							}

						} catch (IOException e) {
							System.out.println(applyLink.getElementsByClass("icl-Button icl-Button--primary icl-Button--md").attr("href"));
						}
					}
				}
			}catch (Exception e) {
				System.out.println();
			}
		}
	}
}
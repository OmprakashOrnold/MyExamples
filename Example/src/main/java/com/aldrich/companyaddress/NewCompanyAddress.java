package com.aldrich.companyaddress;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class NewCompanyAddress {


	public static void main(String[] args) {
		Document document=null;
		String address=null;
		String regex = "((\\d{1,}) [a-zA-Z0-9\\s]+(\\.)? [a-zA-Z]+(\\,)? [A-Z]{2} [0-9]{5,6}|[0-9]{5}(?:-[0-9]{4})?)+";
		Pattern pattern = Pattern.compile(regex);


		List<String> urls=new ArrayList<String>();
		urls.add("	https://www.alliedwallet.com/");

	

		Iterator<String> it= urls.iterator();
		while (it.hasNext()) {
			String urlLinks = (String)it.next();
			try {
				document=getURLResponse(urlLinks.trim());
				if(document!=null)
				{
					Elements elements1 = Jsoup.parse(document.toString()).getElementsMatchingOwnText(pattern);

					for(Element element:elements1)
					{			
						address=null;
						try
						{					
							address = element.text();					

							if(!address.toLowerCase().contains("img height="))
							{
								if(!address.toLowerCase().contains("name"))
								{
									if(!address.toLowerCase().startsWith("contact us"))
									{
										if(!address.toLowerCase().startsWith("+"))
										{
											if(!address.toLowerCase().contains("telephone:"))
											{
												if(!address.toLowerCase().replace("-", "").contains("(toll free)") || !address.toLowerCase().contains("toll free"))
												{
													String cityN="";
													

													String abbrev="AL|AK|AS|AZ|AR|CA|CO|CT|DE|DC|FM|FL|GA|GU|HI|ID|IL|IN|IA|KS|KY|LA|ME|MH|MD|MA|MI|MN|MS|MO|MT|NE|NV|NH|NJ|NM|NY|NC|ND|MP|OH|OK|OR|PW|PA|PR|RI|SC|SD|TN|TX|UT|VT|VI|VA|WA|WV|WI|WY";

													String street="\\d+[ ](?:[A-Za-z0-9.,-]+[ ]?)+(?:Avenue|Lane|Roadz|Boulevard|Drive|Street|Ave|Dr|Rd|Blvd|Ln|St|Suite|[0-9])\\.?";

													String state="Alabama|Alaska|Arizona|Arkansas|California|Colorado|Connecticut|Delaware|Florida|Georgia|Hawaii|Idaho|Illinois|Indiana|Iowa|Kansas|Kentucky|Louisiana|Maine|Maryland|Massachusetts|Michigan|Minnesota|Mississippi|Missouri|Montana|Nebraska|Nevada|New[ ]Hampshire|New[ ]Jersey|New[ ]Mexico|New[ ]York|North[ ]Carolina|North[ ]Dakota|Ohio|Oklahoma|Oregon|Pennsylvania|Rhode[ ]Island|South[ ]Carolina|South[ ]Dakota|Tennessee|Texas|Utah|Vermont|Virginia|Washington|West[ ]Virginia|Wisconsin|Wyoming";
													
													String reg=street+"+,?+[ ]?+(?:[A-Z][a-z.-]+[ ]?)+,[ ]+([{"+state+"}|{"+abbrev+"}]?)+[ ]+\\d{5}(?:-\\d{4})?";


													Pattern compile = Pattern.compile(reg);

													Matcher matcher = compile.matcher(address);
													if(matcher.find()){
														cityN=matcher.group();				
													}

													if(!cityN.isEmpty())
													{
														System.out.println(urlLinks.trim()+"                 -"+cityN);
													}
												}
											}
										}
									}
								}
							}
						}catch(Exception e)
						{
							System.out.println();
						}
					}

				}else{
					System.out.println();
				}

			}catch(Exception e)
			{
				System.out.println();
			}
		}
	}

	public static Document getURLResponse(String url)
	{
		Document documnet=null;
		try {
			documnet=Jsoup.connect(url)
					.userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:79.0) Gecko/20100101 Firefox/79.0")
					.timeout(100000).ignoreHttpErrors(true).get();
		} catch (Exception e) {
			//e.printStackTrace();
		}
		return documnet;
	}
}

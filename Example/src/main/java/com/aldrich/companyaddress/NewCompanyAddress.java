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
		urls.add("	http://www.tmgfinancialservices.com			");
		urls.add("	https://www.joepulizzi.com/			");
		urls.add("	https://www.alliedwallet.com/			");
		urls.add("	http://www.prudentitinc.com/			");
		urls.add("	http://www.archoninfosys.com			");
		urls.add("	https://www.callingmart.com/			");
		urls.add("	http://www.assurancefa.com			");
		urls.add("	http://www.vistaimagingservices.com			");
		urls.add("	http://www.keepcalling.net/			");
		urls.add("	https://www.efwnow.com/			");
		urls.add("	https://www.kellermortgage.com/			");
		urls.add("	https://www.verusboc.com/			");
		urls.add("	https://www.crescendrf.com/			");
		urls.add("	https://www.nlogic.com/			");
		urls.add("	http://www.utilipath.com			");
		urls.add("	http://www.aribex.com			");
		urls.add("	http://www.wcslending.com			");
		urls.add("	http://www.expertsit.com			");
		urls.add("	https://www.ifgsd.com/			");
		urls.add("	http://www.bristleconeadvisors.com			");
		urls.add("	http://www.intrustgroup.com			");
		urls.add("	https://www.rtsav.com/			");
		urls.add("	https://www.asset-security-pro.com/			");
		urls.add("	https://www.saw-grass.com/			");
		urls.add("	https://www.sentryprotectsyou.com/			");
		urls.add("	http://www.technosecure.com			");
		urls.add("	http://www.uscarrier.com			");
		urls.add("	https://www.inboxdollars.com/			");
		urls.add("	http://www.blogspot.com			");
		urls.add("	http://www.symptomfind.com			");
		urls.add("	http://www.prevention.com			");
		urls.add("	http://www.canon.com			");
		urls.add("	http://www.logmein.com			");
		urls.add("	http://www.informars.com			");
		urls.add("	http://www.rightdiagnosis.com			");
		urls.add("	http://www.jstor.org			");
		urls.add("	http://www.self.com			");
		urls.add("	http://www.helprx.info			");
		urls.add("	http://www.fitpregnancy.com			");
		urls.add("	http://www.digitalpoint.com			");
		urls.add("	http://www.uk.com			");
		urls.add("	http://www.healingwell.com			");
		urls.add("	http://www.lifestylelift.com			");
		urls.add("	http://www.askdrsears.com			");
		urls.add("	https://www.brighthub.com/			");
		urls.add("	http://www.websitetoolbox.com			");
		urls.add("	https://www.corp.viewbix.com/			");
		urls.add("	http://www.momtastic.com			");
		urls.add("	http://www.healthaliciousness.com			");
		urls.add("	http://www.md-health.com			");
		urls.add("	https://www.wego.here.com/traffic			");
		urls.add("	http://www.padiact.com			");
		urls.add("	http://www.justcloud.com			");
		urls.add("	http://www.patientfusion.com			");
		urls.add("	http://www.wayport.net			");
		urls.add("	http://www.pandodaily.com			");
		urls.add("	http://www.omeda.com			");
		urls.add("	http://www.talentedk12.com			");
		urls.add("	http://www.wepay.com			");
		urls.add("	http://www.auctionflex.com			");
		urls.add("	http://www.rrd.com			");
		urls.add("	http://www.axill.com			");
		urls.add("	https://www.wirewax.com/			");
		urls.add("	http://www.wellnessmama.com			");
		urls.add("	http://www.freeadvice.com			");
		urls.add("	https://www.mojopages.com/san-diego-ca			");
		urls.add("	https://www.tennischanneleverywhere.com/			");
		urls.add("	http://www.userreport.com			");
		urls.add("	http://www.followmyhealth.com			");
		urls.add("	http://www.endocrineweb.com			");
		urls.add("	http://www.ticketplatform.com			");
		urls.add("	http://www.123contactform.com			");
		urls.add("	https://www.outdoorhub.com/			");
		urls.add("	http://www.mommyish.com			");
		urls.add("	http://www.diabeticlivingonline.com			");
		urls.add("	http://www.sheppardsoftware.com			");
		urls.add("	http://www.rodalenews.com			");
		urls.add("	http://www.jalbum.net			");
		urls.add("	http://www.easylocator.net			");
		urls.add("	http://www.yogawiz.com			");
		urls.add("	http://www.nsw.gov.au			");
		urls.add("	http://www.secure-res.com			");
		urls.add("	http://www.cincopa.com			");
		urls.add("	https://www.diy.com/			");
		urls.add("	http://www.livezilla.net			");
		urls.add("	https://www.clickdesk.com/			");
		urls.add("	http://www.supplementwarehouse.com			");
		urls.add("	http://www.hipaaspace.com			");
		urls.add("	http://www.citationmachine.net			");
		urls.add("	http://www.turn-page.com			");
		urls.add("	http://www.forecast.io			");
		urls.add("	http://www.weelicious.com			");
		urls.add("	http://www.xsplit.com			");
		urls.add("	http://www.blipstar.com			");
		urls.add("	http://www.clear-reports.com			");
		urls.add("	http://www.windsurfercrs.com			");
		urls.add("	http://www.internetdrugcoupons.com			");
		urls.add("	http://www.fitlife.tv			");
		urls.add("	https://www.plugnpay.com/			");
		urls.add("	https://www.pureorthodontics.ca/			");

	

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

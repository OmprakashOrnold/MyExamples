package com.aldrich.companyaddress;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.aldrich.pase.util.PASEConstants;

public class UkAddressExtraction {

	public static void main(String[] args) {

		Document document = null;
		List<String> url=new ArrayList<String>();
		
		String address_pattern = "(contact-us|contact us|contact-us.html|contact|about|support)+";

		url.add("	http://www.anomaly42.com	");
		url.add("	http://www.darktrace.com/	");
		url.add("	http://www.esellerpro.com/	");
		url.add("	http://www.parmenion.co.uk	");
		url.add("	http://www.thermoteknix.com	");
		url.add("	https://www.mobilehorizons.com/	");
		url.add("	http://www.clusterhq.com	");
		url.add("	http://www.invoicesharing.com	");
		url.add("	http://www.amfax.xo.uk	");
		url.add("	https://www.dotit.com	");
		url.add("	http://www.paywithvelocity.com	");
		url.add("	http://www.silverliningusa.com/	");
		url.add("	https://www.eims.biz/	");
		url.add("	http://www.celltick.com/	");
		url.add("	https://icarehealth.co.uk/	");
		url.add("	https://www.rapyd.net/	");
		url.add("	https://trussle.com/	");
		url.add("	https://geospock.com/	");
		url.add("	https://verj.io/	");
		url.add("	https://b2b2c.eu/	");
		url.add("	https://edgefolio.com/	");
		url.add("	http://weengs.co.uk	");
		url.add("	http://www.majesticseo.com/	");
		url.add("	http://www.poqcommerce.com	");
		url.add("	https://www.bnkbl.com/	");
		url.add("	https://oodlefinance.com/	");
		url.add("	http://www.11fs.co.uk	");
		url.add("	https://www.accelins.com/	");
		url.add("	https://acin.com/	");
		url.add("	http://www.adept.co.uk	");
		url.add("	http://www.alphafx.co.uk	");
		url.add("	https://anexsys.com/	");
		url.add("	https://www.apgecommerce.com/	");
		url.add("	https://www.atnahs.com/	");
		url.add("	https://www.auden.co.uk/	");
		url.add("	https://www.avaskaccounting.co.uk/	");
		url.add("	https://www.balticapprenticeships.com/	");
		url.add("	http://www.bbk.ac.uk	");
		url.add("	https://bionic.co.uk/	");
		url.add("	http://www.blockchain.cs.ucl.ac.uk	");
		url.add("	https://www.bridgesforenterprise.com/	");
		url.add("	http://www.business-school.exeter.ac.uk	");
		url.add("	http://www.cambridgeconsultingnetwork.com	");
		url.add("	https://www.capitalontap.com/	");
		url.add("	https://www.carringtonwest.com/	");
		url.add("	http://www.cassmape.com	");
		url.add("	https://www.cellohealth.com/	");
		url.add("	https://www.codat.io/	");
		url.add("	https://www.convexin.com/	");
		url.add("	https://corndel.com/	");
		url.add("	https://www.cuvva.com/	");
		url.add("	https://www.demica.com/	");
		url.add("	https://www.dfcapital.co.uk/	");
		url.add("	https://www.eastwestrail.co.uk/	");
		url.add("	https://www.eyalliance.org.uk/	");
		url.add("	https://www.faculty.ai/	");
		url.add("	https://www.fe-fundinfo.com/	");
		url.add("	https://www.fintru.com/	");
		url.add("	https://www.form3.tech/	");
		url.add("	https://www.fortus.co.uk/	");
		url.add("	http://www.getcarbon.co	");
		url.add("	https://www.goldfish.com/	");
		url.add("	https://www.healios.org.uk/	");
		url.add("	https://www.hireful.co.uk/	");
		url.add("	https://www.huma.com/	");
		url.add("	https://icsdigitaltherapies.com/	");
		url.add("	https://illingworthresearch.com/	");
		url.add("	https://www.imaginecurve.com/	");
		url.add("	http://www.infinityquest.co.uk	");
		url.add("	https://www.infinox.com	");
		url.add("	https://www.ioassociates.co.uk/	");
		url.add("	https://www.isio.com/	");
		url.add("	https://www.itecco.co.uk/	");
		url.add("	https://www.kingswood-group.com/	");
		url.add("	https://www.konexoglobal.com/	");
		url.add("	https://landbay.co.uk/	");
		url.add("	https://www.lendable.co.uk/	");
		url.add("	https://liaisongroup.com/	");
		url.add("	https://www.lineten.com/	");
		url.add("	https://www.loreto.ac.uk/	");
		url.add("	https://www.lsesu.com/	");
		url.add("	https://www.markeltax.co.uk/	");
		url.add("	https://www.marshmallow.com/	");
		url.add("	https://www.medix-global.com/	");
		url.add("	https://mentalhealthinnovations.org/	");
		url.add("	https://www.moneyboxapp.com/	");
		url.add("	https://oaklandcare.com/	");
		url.add("	https://www.oceanfinance.co.uk/	");
		url.add("	https://www.optiogroup.com/	");
		url.add("	https://www.parity.io/	");
		url.add("	https://www.partnersand.com/	");
		url.add("	http://www.paymentsense.co.uk	");
		url.add("	https://www.payxpert.com/	");
		url.add("	https://www.quantexa.com/	");
		url.add("	https://www.quantuma.com/	");
		url.add("	https://www.quilterfinancialadvisers.co.uk/	");
		url.add("	https://www.quilterfinancialplanning.co.uk/	");
		url.add("	https://www.quilterinternational.com/	");
		url.add("	https://www.quilterpca.co.uk/	");

		//String regex = "\\d{1,5}(th|rd|nd)?[ ]?([a-zA-Z0-9!@#$&()-`.+,\\s\\\"\\']*)(([a-zA-Z]){1}([0-9][0-9]|[0-9]|[a-zA-Z][0-9][a-zA-Z]|[a-zA-Z][0-9][0-9]|[a-zA-Z][0-9]){1}([ ])([0-9][a-zA-z][a-zA-z]){1})";

		String regex = "\\d{1,5}([A-Za-z\\,\\s\\']+)(([a-zA-Z]){1}([0-9][0-9]|[0-9]|[a-zA-Z][0-9][a-zA-Z]|[a-zA-Z][0-9][0-9]|[a-zA-Z][0-9]){1}([ ])([0-9][a-zA-z][a-zA-z]){1})";
		Pattern pattern = Pattern.compile(regex);
		try {

			for (String string : url) {

				document =getURLResponse(string.trim());
				if(document!=null)
				{
					//System.out.println(getLocationBssedonZipcode(getUKZipcode(document.text()),document.text()));

					if(getLocationBssedonZipcode(getUKZipcode(document.text()),document.text())!=null){
						Matcher matcher = pattern.matcher(getLocationBssedonZipcode(getUKZipcode(document.text()),document.text()));
						if (matcher.find()) {
							System.out.println(matcher.group());
						}
					}

					Elements contactlink = document.getElementsByAttributeValueMatching("href", address_pattern);
					for (Element contactlinks : contactlink) {
						if (contactlinks != null) {
							if (contactlinks.hasAttr("href")) {
								String contactPages = contactlinks.attr("abs:href");
								if (!contactPages.contains("wp-content")) {
									Document document_new = getURLResponse(contactPages);
									if (document_new != null) {
										
										//System.out.println(getLocationBssedonZipcode(getUKZipcode(document_new.text()),document_new.text()));
										
										if(getLocationBssedonZipcode(getUKZipcode(document_new.text()),document_new.text())!=null){
											Matcher matcher = pattern.matcher(getLocationBssedonZipcode(getUKZipcode(document_new.text()),document_new.text()));
											if (matcher.find()) {
												System.out.println(matcher.group());
											}
										}
										
									}
								}
							}
						}
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}


	}


	public static String getLocationBssedonZipcode(String zipcode,String address) {

		String location=null;

		try{		
			if(zipcode!=null&&!zipcode.isEmpty())
			{
				Integer endInde =address.indexOf(zipcode);
				if(address.length()>0)
				{
					
					int startInde=endInde-100;	
					location=address.substring(startInde, endInde)+" "+zipcode;
					/*
					int startInde=endInde-100;			
					String locationMain=address.substring(startInde, endInde).trim();	
					String str = locationMain.replaceAll("[^-?0-9]+", " ").trim(); 
					if(str.length()>0)
					{
						Integer index=locationMain.lastIndexOf(str.charAt(0));
						if(index!=null&&index!=0)
						{
							location=locationMain.substring(index)+" "+zipcode;
						}
					}
				*/}
			}		

		} catch (Exception e) {
			e.printStackTrace();
		}
		return location;
	}



	public static String getUKZipcode(String addressText) {

		String zipcode=null;
		String zipCodePattern = "([a-zA-Z]){1}([0-9][0-9]|[0-9]|[a-zA-Z][0-9][a-zA-Z]|[a-zA-Z][0-9][0-9]|[a-zA-Z][0-9]){1}([ ])([0-9][a-zA-z][a-zA-z]){1}";
		try {
			Pattern compiled = Pattern.compile(zipCodePattern);
			Matcher matcher = compiled.matcher(addressText);
			if (matcher.find()) {
				zipcode = matcher.group();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return zipcode;
	}




	public static Document getURLResponse(String url) {
		Document document = null;
		try {
			document = Jsoup.connect(url).followRedirects(true).userAgent(PASEConstants.USER_AGENT).ignoreHttpErrors(true).timeout(0).get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return document;
	}

}

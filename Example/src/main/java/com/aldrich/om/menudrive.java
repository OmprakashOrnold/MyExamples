package com.aldrich.om;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.aldrich.pase.util.PASEConstants;

public class menudrive {

	public static void main(String[] args) {

		Document document=null;

		try {



			document=Jsoup.connect("https://www.menudrive.com/blog/").userAgent(PASEConstants.USER_AGENT).ignoreContentType(true).ignoreHttpErrors(true).get();


			System.out.println(document);

            try (FileWriter writer = new FileWriter(
					"C:\\OmPrakash\\menudrive.txt", true);
					BufferedWriter bw = new BufferedWriter(writer)) {				
			    bw.write(document.toString());
				bw.write("\n");
				
			} catch (IOException ex) {
				System.err.format("IOException: %s%n", ex);
			}
			Elements ele=document.select("span[class='psac-post-meta-innr psac-time']");

			for (Element element : ele) {
				System.out.println(element);
			}



		


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}

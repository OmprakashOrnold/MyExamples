import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Demo {

	public static void main(String[] args) {

		String s="September 2003 – January 2005(1 year 4 months)";
		String s1=s.replaceAll("[a-zA-z,\\(\\)]", "").trim();
		String s2[]=s1.split(" – ");
		System.out.println(s2[0].trim());

	}
}
	



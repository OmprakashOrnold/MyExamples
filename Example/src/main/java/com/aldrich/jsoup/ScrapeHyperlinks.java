package com.aldrich.jsoup;
import java.io.IOException;
 
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
 
public class ScrapeHyperlinks {
 
  public static void main(String[] args) {
    try {
     
      Document doc = Jsoup.connect("https://aldrichcap.com/NewsandMedia.html").get();

      Elements links = doc.select("a[href]");
      
      links.forEach((e) -> {
        System.out.println(e.attr("abs:href"));
     
      });
     
    } catch (IOException e) {
    e.printStackTrace();
    }
  }
}
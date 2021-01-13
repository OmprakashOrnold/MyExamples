package com.aldrich.jsoup;
import java.io.File;
import java.io.IOException;
 
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.safety.Whitelist;
 
public class JsoupCleanHTMLExample {
 
    public static void main(String[] args) throws IOException {
        
        String strHTML = "<html>" +
                "<head>" +
                "<title>your title here</title>" +
                "</head>" +
                "<body bgcolor=\"ffffff\">" +
                "<center><img src=\"clouds.jpg\" align=\"bottom\"> </center>" +
                "<hr>" +
                "<a href=\"http://www.google.com\">Google</a>" +
                "<h1>heading 1</h1>" +
                "<h2>heading2</h2>" +
                "My email link <a href=\"mailto:myemail@example.com\">" +
                "myemail@example.com</a>." +
                "<p>Para tag</p>" +
                "<p><b>bold paragraph</b>" +
                "<br><b><i>bold italics text.</i></b>" +
                "<hr>Horizontal line" +
                "</body>" +
                "</html>";
        
        //clean HTML using none whitelist (remove all HTML tags)
        String cleanedHTML = Jsoup.clean(strHTML, Whitelist.basic());
        System.out.println("None whitelist");
        System.out.println(cleanedHTML);
 
        System.out.println("");
        
        //clean HTML using relaxed whitelist
        cleanedHTML = Jsoup.clean(strHTML, Whitelist.relaxed());
        System.out.println("Relaxed whitelist");
        System.out.println(cleanedHTML);
 
    }
}
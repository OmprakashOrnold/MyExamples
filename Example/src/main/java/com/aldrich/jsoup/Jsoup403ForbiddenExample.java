package com.aldrich.jsoup;
import java.io.IOException;
 
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
 
public class Jsoup403ForbiddenExample {
 
    public static void main(String[] args) {
        
        try{
            
            //connect to the website
            Connection connection = Jsoup.connect("http://www.example.com");
            
            //get the HTML document
            Document doc = connection.get();
            
            //parse text from HTML
            String strHTML = doc.text();
            
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
 
    }
}
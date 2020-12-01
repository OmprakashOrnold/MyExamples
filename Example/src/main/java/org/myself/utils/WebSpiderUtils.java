package org.myself.utils;
 
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
/**
 * Created by zhao_xinhu
 * On 2018/8/27
 * Simple web crawler tools
 */
public class WebSpiderUtils {
    private static Logger logger = LoggerFactory.getLogger(WebSpiderUtils.class);
 
    /**
           * Read webpage source code of incoming url
     * @param parentUrl
     * @return
     */
    private static String getHtmlText(String parentUrl){
        HttpURLConnection connection = null;
        URL url = null;
        InputStream inputStream = null;
        BufferedReader bufferedReader = null;
        StringBuffer stringBuffer = null;
        try{
            url = new URL(parentUrl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            connection.setDoInput(true);
            connection.connect();
            inputStream = connection.getInputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            stringBuffer = new StringBuffer("");
            String line = null;
            while ((line = bufferedReader.readLine()) != null){
                stringBuffer.append(line);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            connection.disconnect();
            try{
                inputStream.close();
                bufferedReader.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return stringBuffer.toString();
    }
 
    /**
           * Get document
     * @param url
     * @return
     */
    private static Document getDocument(String url){
        String htmlText = getHtmlText(url);
        Document document = Jsoup.parse(htmlText);
        return document;
    }
 
    
}
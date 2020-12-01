package com.aldrich.patent;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.net.ssl.*;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class SSLExceptionSolution {
    
    final static String requestUrl = "https://somewhere.com/target.jsp";

    public static void enableSSLSocket() throws KeyManagementException, NoSuchAlgorithmException {
        HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        });

        SSLContext context = SSLContext.getInstance("TLS");
        context.init(null, new X509TrustManager[]{new X509TrustManager() {
            public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            }

            public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            }

            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        }}, new SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(context.getSocketFactory());
    }

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, KeyManagementException {
        String bigno = "S";
        String midno = "11";
        String useno = "111111";
        String chkno = "1";

        enableSSLSocket();

        Connection.Response response = Jsoup.connect(requestUrl)
                .data("bigno", bigno)
                .data("midno", midno)
                .data("useno", useno)
                .data("chkno", chkno)
                .userAgent("Mozilla/5.0 (Windows NT 6.2; WOW64; rv:29.0) Gecko/20100101 Firefox/29.0")
                .method(Connection.Method.POST)
                .execute();

        switch (response.statusCode()) {
            case 200:
                doProcess(response.parse());
                break;
            default:
                
                break;
        }
    }

    public static void doProcess(Document document){
        // do something...
    }
}
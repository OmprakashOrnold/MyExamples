package com.aldrich.om;

import java.io.FileInputStream;

public class ExceptionDemo {

	public static void main(String[] args) {
	
		try {
			FileInputStream fis = null;
			  fis = new FileInputStream("C:\\OmPrakash\\patent.txt"); 
			  int k; 

			  while(( k = fis.read() ) != -1) 
			  { 
			   System.out.print((char)k); 
			  } 
			  fis.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	

		 

	}

}

package com.java.practice;

import java.io.FileWriter;
import java.io.PrintWriter;

public class StringExample {

	public static void main(String[] args) {

		int count=0;

		try {
			FileWriter fw=new FileWriter("C:\\OmPrakash\\files\\crickewt.txt");
			PrintWriter out=new PrintWriter(fw);
			out.write(100);
			out.println(100);
			out.println(true);
			out.println('c');
			out.println("SaiCharan");
			out.flush();
			out.close(); 
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

}

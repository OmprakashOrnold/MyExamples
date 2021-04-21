package com.aldrich.apchepoi;
import java.io.*;
import java.sql.*;
import java.util.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

/**
 * Sample Java program that imports data from an Excel file to MySQL database.
 *
 * @author Nam Ha Minh - https://www.codejava.net
 *
 */
public class Excel2DatabaseTest {

	public static void main(String[] args) {


		String excelFilePath = "C:\\Users\\OPrakash\\Downloads\\Biotech.xlsx".replaceAll("\\\\", "-").replace("-", "//");
		
		String str= "\"" + excelFilePath +"\"" ;
		System.out.println(str);
		String name=null;
		String url =null;


		try {
			FileInputStream inputStream = new FileInputStream(excelFilePath);

			Workbook workbook = new XSSFWorkbook(inputStream);

			Sheet firstSheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = firstSheet.iterator();

			rowIterator.next(); // skip the header row

			while (rowIterator.hasNext()) {
				Row nextRow = rowIterator.next();
				Iterator<Cell> cellIterator = nextRow.cellIterator();

				while (cellIterator.hasNext()) {
					Cell nextCell = cellIterator.next();
					int columnIndex = nextCell.getColumnIndex();
					switch (columnIndex) {
					case 0:
						name = nextCell.getStringCellValue();
						break;
					case 1:
						url  = nextCell.getStringCellValue();
					}
				}
				System.out.println(name+" "+url);
			}
			workbook.close();
		} catch (IOException ex1) {
			System.out.println("Error reading file");
			ex1.printStackTrace();
		}
	}
}
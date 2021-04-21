package com.aldrich.peronal;


import java.util.List;

import com.demo.helpers.ExcelHelper;

public class Snippet {
	public String process() throws Exception {
	
			String fileName = "";
			System.out.println("File Name: " + fileName);
		
			ExcelHelper excelHelper = new ExcelHelper("");
			List<Product> products = excelHelper.readData(Product.class.getName());
		
			for (Product product : products) {
				System.out.println("Id: " + product.getId());
				System.out.println("Name: " + product.getName());
				System.out.println("Price: " + product.getPrice());
				System.out.println("Quantity: " + product.getQuantity());
				System.out.println("Status: " + product.isStatus());
				System.out.println("=========================");
			}
			return "product/index";
		}
	
	

}


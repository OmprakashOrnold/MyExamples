package com.aldrich.pase.util;

public class FormatDisplayName {
	@SuppressWarnings({ "nls" })
	public static String formatDisplayName(String display_Price) {
		try {
			String displayPrice = "";
			displayPrice = display_Price.replaceAll("\u00A0", "");
			displayPrice = displayPrice.replace("Rs.", "");
			displayPrice = displayPrice.replace("$", "");
			displayPrice = displayPrice.replaceAll("^\\s+", "");
			displayPrice = displayPrice.replace("₹", "");
			displayPrice = displayPrice.trim();
			return displayPrice;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
}

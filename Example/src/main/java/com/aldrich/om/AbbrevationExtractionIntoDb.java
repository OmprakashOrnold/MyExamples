package com.aldrich.om;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class AbbrevationExtractionIntoDb {

	public static void main(String[] args) {
		String dbURL = "jdbc:mysql://localhost:3306/abbrevation";
		String username = "root";
		String password = "12345";

		try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {

			String sql = "INSERT INTO abbrevations (short_name,abbrevation,category,sub_category) VALUES (?, ?, ?, ? )";

			PreparedStatement statement = conn.prepareStatement(sql);

			Document documnet = null;
			Long endLimit = null;
			String catArray[] = null;
			String shortName = null;
			String abbrivation = null;
			String category = null;
			String subCategory = null;
			Long count=1L;
			try {

				List<String> list = new ArrayList<String>();
				list.add("A");
				list.add("B");
				list.add("C");
				list.add("D");
				list.add("E");
				list.add("F");
				list.add("G");
				list.add("H");
				list.add("I");
				list.add("J");
				list.add("K");
				list.add("L");
				list.add("M");
				list.add("N");
				list.add("O");
				list.add("P");
				list.add("Q");
				list.add("R");
				list.add("S");
				list.add("T");
				list.add("U");
				list.add("V");
				list.add("W");
				list.add("X");
				list.add("Y");
				list.add("Z");
				for (String alphabet : list) {

					documnet = getDocument("https://www.abbreviations.com/abbreviations/" + alphabet);
					if (documnet != null) {
						Element limit = documnet.select("a[class='rc5']").last();
						endLimit = Long.parseLong(limit.text());

						for (int i = 1; i <= endLimit; i++) {
							documnet = getDocument("https://www.abbreviations.com/abbreviations/" + alphabet + "/" + i);

							Elements table = documnet.select("table[class='table tdata']");
							if (table != null && table.size() > 0) {
								for (Element element : table) {
									try {
										Elements trs = element.select("tr");
										for (Element tr : trs) {
											shortName = "";
											statement.setString(1, shortName );
											abbrivation = "";
											statement.setString(2, abbrivation );
											category = "";
											statement.setString(3, category );
											subCategory = "";
											statement.setString(4, subCategory );

											shortName = tr.child(0).text();
											statement.setString(1, shortName );
											abbrivation = tr.child(1).getElementsByClass("desc").text();
											statement.setString(2, abbrivation );

											if (tr.child(1).getElementsByClass("path").text().contains("»")) {
												catArray = tr.child(1).getElementsByClass("path").text().split("»");
												category = catArray[0].toString().trim();
												statement.setString(3, category );
												subCategory = catArray[1].toString().trim();
												statement.setString(4, subCategory );
												int rowsInserted = statement.executeUpdate();
												if (rowsInserted > 0) {
													System.out.println(count++ +" file was inserted successfully!");
												}

											} else {
												category = catArray[0].toString();
												statement.setString(3, category );
												int rowsInserted = statement.executeUpdate();
												if (rowsInserted > 0) {
													System.out.println(count++ +"  file was inserted successfully!");
												}

											}

										}

									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							}
						}
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	public static Document getDocument(String url) {
		Document documnet = null;
		try {
			documnet = Jsoup.connect(url)
					.userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:79.0) Gecko/20100101 Firefox/79.0")
					.ignoreHttpErrors(true).get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return documnet;
	}

}

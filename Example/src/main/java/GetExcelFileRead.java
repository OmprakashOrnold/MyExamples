import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;



public class GetExcelFileRead {

	public static void main(String[] args) {

		String fileName = "C:\\OmPrakash\\sba_paycheck_data.csv";

		String regex3 = "(0[1-9]|1[012])\\/(0[1-9]|[12][0-9]|3[01])\\/\\d{4,4}";
		String regex4 = "(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])\\-\\d{4,4}";
		
		String dateFormat=null;
		
		List<String[]> r;
		try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
			r = reader.readAll();
			for (String[] arrays : r) {
				
				
				System.out.println(arrays[13]);
				
				
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}



	}
	
	public static  Date convertAnyTypeDateToSingleFormat(String dateInString) {
		String dateFormat = null;
		Date date = null;
		
		String regex3 = "(0[1-9]|1[012])\\/(0[1-9]|[12][0-9]|3[01])\\/\\d{4,4}";
		String regex4 = "(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])\\-\\d{4,4}";
		
		
		if (dateInString != null && !dateInString.isEmpty()) {
			 if (dateInString.matches(regex3)) {
				dateFormat = "MM/dd/yyyy";
			} else if (dateInString.matches(regex4)) {
				dateFormat = "MM-dd-yyyy";
			}
			
			SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
			try {
				date = formatter.parse(dateInString);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return date;
	}

}

import java.text.SimpleDateFormat;
import java.util.Date;

public class ATMDemo {

	public static void main(String[] args) {
		
		String date="4/11/2020";

		System.out.println(convertDateToSingleFormat(date));
	}
	

	public  static  Date convertDateToSingleFormat(String dateInString) {
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

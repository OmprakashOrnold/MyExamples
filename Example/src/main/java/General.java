import java.util.Calendar;

public class General {

	public static void main(String[] args) {
		
		Calendar calendar = Calendar.getInstance();
        int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
        
        
        System.out.println("Week in Year: " + weekOfYear);
	}

}

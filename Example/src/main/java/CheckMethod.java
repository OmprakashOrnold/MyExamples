import java.util.ArrayList;

public class CheckMethod {

	public static void main(String[] args) {
	
		String url="http://www.omprakash.com/blog";
		if(isURLValid(url))
		{
			System.out.println(url);
		}

	}

	public static boolean isURLValid(String url) {
		boolean valid = true;

		try {
			ArrayList<String> wordsList = new ArrayList<String>();

			wordsList.add("press");
			wordsList.add("news");
			wordsList.add("testimonial");
			wordsList.add("careers");
			wordsList.add("train");
			wordsList.add("appoint");
			wordsList.add("join");
			wordsList.add("policy");
			wordsList.add("opening");
			wordsList.add("job");
			wordsList.add("terms");
			wordsList.add("privacy");
			wordsList.add("career");
			wordsList.add("customer");
			wordsList.add("partner");
			wordsList.add("client");
			wordsList.add("forum");
			wordsList.add("blog");
			wordsList.add("tag");
			wordsList.add("locations");
			wordsList.add("contact");


			for (String word : wordsList) {
				try {
					if (url.toLowerCase().contains(word)) {
						valid = false;
					}
				} catch (Exception excp) {
					excp.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return valid;
	}
}


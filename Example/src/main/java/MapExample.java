import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class MapExample {

	public static void main(String[] args) {

		Map<String, String> mapCountryCodes = new HashMap<>();

		mapCountryCodes.put("1", "USA");
		mapCountryCodes.put("44", "United Kingdom");
		mapCountryCodes.put("33", "France");
		mapCountryCodes.put("81", "Japan");


		/*Set<String> set=mapCountryCodes.keySet();
		Iterator<String> itr =set.iterator();
		while(itr.hasNext())
		{
			String code = itr.next();
			String country = mapCountryCodes.get(code);

			System.out.println(code + " => " + country);

		}*/

		/*Collection<String> c=mapCountryCodes.values();
		Iterator<String> itr =c.iterator();
		while(itr.hasNext())
		{
			String code = itr.next();
			System.out.println(code);
		
		}*/
		
		Set<Entry<String,String>> entry=mapCountryCodes.entrySet();
		for (Entry<String, String> entry2 : entry) {
			System.out.println(entry2.getKey()+" "+entry2.getValue());
		}

	}

}

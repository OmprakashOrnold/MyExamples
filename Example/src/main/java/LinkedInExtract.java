import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class LinkedInExtract
{
	public static void main(String[] args)

{

	File folder = new File("C:\\Users\\oppeddamadthala\\Downloads\\pase6.1\\pase6.1\\");
	File[] files = folder.listFiles();
	for (File file : files) 
	{
		File filePath = new File(file.getPath());
		try (BufferedReader br = new BufferedReader(new FileReader(filePath)))
		{		
		String sCurrentLine;
		while ((sCurrentLine = br.readLine()) != null)
		{
			try {
				Document doc = Jsoup.parse(new File(sCurrentLine),"UTF-8"); 
				Elements employeeCount=doc.getElementsByClass("t-20 t-black");

				if(employeeCount!=null&&employeeCount.size()>0)
				{
					System.out.println(employeeCount.text().toString());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
	
		}
		}

	catch (IOException e1) {
		e1.printStackTrace();
	}}
}
}



import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.omprakash.nlp.NewsTriggerKeywords;
import com.omprakash.nlp.Pipeline;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreSentence;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;

public class ExtractingSentancesFromWebpage {

	public static void main(String[] args) {


		Document document=null;
		String description=null;

		String url="https://www.piifx.com/thursday-february-20th-2020/";
		try {
			document=Jsoup.connect(url).ignoreHttpErrors(true).userAgent("Mozilla").get();

			description=document.text().toString().trim().toString();
			System.out.println("======================================================================");

			String simple = "[.?!]";      
			String[] splitString = (description.split(simple));     
			for (String string : splitString)
			{
				System.out.println(string);
			}

			System.out.println("======================================================================");
			StanfordCoreNLP stanfordCoreNLP=Pipeline.getPipeline();
			CoreDocument coreDocument= new CoreDocument(description);
			stanfordCoreNLP.annotate(coreDocument);
			
			List<CoreSentence> sentences =coreDocument.sentences();

			for (CoreSentence sentence : sentences) {

				System.out.println(sentence.toString());
			}
			
			System.out.println("======================================================================");
			
			InputStream inputStream = new FileInputStream("C:\\Users\\Omprakash\\Downloads\\en-sent.bin"); 
			SentenceModel model = new SentenceModel(inputStream); 

			//Instantiating the SentenceDetectorME class 
			SentenceDetectorME detector = new SentenceDetectorME(model);  

			//Detecting the sentence
			String sentences1[] = detector.sentDetect(description); 

			//Printing the sentences 
			for(String sent : sentences1)        
				System.out.println(sent);  
		
	}catch(Exception e)
	{
		e.printStackTrace();
	}

}

}

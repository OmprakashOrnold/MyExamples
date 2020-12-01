import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.omprakash.nlp.NewsTriggerKeywords;
import com.omprakash.nlp.Pipeline;

import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreSentence;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

public class GetOnlySentancesAndDisplay
{
	public static void main(String[] args) {
		Document document=null;
		String description=null;

		List<String> urls=new ArrayList<String>();
		urls.add("https://www.mongooseresearch.com/blog/advancement/texting-in-advancement-best-practices-and-new-opportunities");
		
		Iterator<String> iterator= urls.iterator();
		while (iterator.hasNext()) {
			System.out.println("--------------------------------------------------");
			String urlLink= (String) iterator.next();
			{

				try {
					document=Jsoup.connect(urlLink).ignoreHttpErrors(true).userAgent("Mozilla").get();

					description=document.text().toString().trim().toString();

					StanfordCoreNLP stanfordCoreNLP=Pipeline.getPipeline();
					CoreDocument coreDocument= new CoreDocument(description);
					stanfordCoreNLP.annotate(coreDocument);

					List<String> sentencesList=new ArrayList<String>();
					List<String> keywordsList=new ArrayList<String>();

					List<CoreSentence> sentences =coreDocument.sentences();
					for (CoreSentence sentence : sentences) {

						sentencesList.add(sentence.toString());	
						//System.out.println(sentence);
					}

					List<String> keywords = NewsTriggerKeywords.keywordsList();
					if (!keywords.isEmpty())
					{
						for (String keyword : keywords)
						{	
							keywordsList.add(keyword);
						}
					}

					for (String temp: sentencesList) {
						boolean match = keywordsList.stream().anyMatch(temp::contains);
						if(match)
						{
							System.out.println(removeSpecialCharacters(temp));
						}
					}


				}catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	public static String removeSpecialCharacters(String inputString) {
		return inputString.replaceAll("[^a-zA-Z0-9\\s]", "");
	}
}
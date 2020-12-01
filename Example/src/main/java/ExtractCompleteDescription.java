import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.ArrayStack;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.omprakash.nlp.NewsTriggerKeywords;
import com.omprakash.nlp.Pipeline;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

public class ExtractCompleteDescription {

	public static void main(String[] args) {

		Document document=null;
		String description=null;
		
		String url="https://writingcenter.prompt.com/new-santa-clara-university-essay-prompts-for-2019-20";
		try {
			
			document=Jsoup.connect(url).ignoreHttpErrors(true).userAgent("Mozilla").get();

			description=document.text().toString().trim().toString();
			//System.out.println(description);
						
			StanfordCoreNLP stanfordCoreNLP=Pipeline.getPipeline();

			CoreDocument coreDocument= new CoreDocument(description);
			stanfordCoreNLP.annotate(coreDocument);

			List<Object> compareList1=new ArrayList<Object>();
			List<Object> compareList2=new ArrayList<Object>();
			
			List<CoreLabel> coreLabelList =coreDocument.tokens();
			for (CoreLabel coreLabel : coreLabelList) {
				
				String lemma=coreLabel.lemma();
				compareList1.add(lemma);
				
			}
			
			List<String> keywordsList = NewsTriggerKeywords.keywordsList();
			if (!keywordsList.isEmpty())
			{
				for (String keyword : keywordsList)
				{	
					compareList2.add(keyword);
				}
			}
			
			for (Object i: compareList1) {
	            if (compareList2.contains(i)) {
	                System.out.println("Match Found " + i);
	               
	            }
	        }
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}

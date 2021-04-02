package com.omprakash.nlp;

import java.util.List;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

public class NERExample {

	public static void main(String[] args) {

		String text="CS Rao";
		int count=getAccuratePersonNameCount(text);		
		
		if(count>1){
			System.out.println(text);
		}
	}

	public static Integer getAccuratePersonNameCount(String text) {

		StanfordCoreNLP stanfordCoreNLP=Pipeline.getPipeline();
		CoreDocument coreDocument= new CoreDocument(text);
		stanfordCoreNLP.annotate(coreDocument);

		int count=0;
		try{
			List<CoreLabel> coreLabelList =coreDocument.tokens();
			for (CoreLabel coreLabel : coreLabelList) {
				String ner=coreLabel.get(CoreAnnotations.NamedEntityTagAnnotation.class);
				if(ner.equals("PERSON"))
				{
					count=count+1;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
	}

}

package com.omprakash.nlp;

import java.util.List;

import edu.stanford.nlp.coref.CorefCoreAnnotations.CorefAnnotation;
import edu.stanford.nlp.ling.CoreAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

public class NERExample {

	public static void main(String[] args) {
		StanfordCoreNLP stanfordCoreNLP=Pipeline.getPipeline();
		String text="Hey this is Robert am from New York Tokyo he is Dinesh from Berlin";
		
		CoreDocument coreDocument= new CoreDocument(text);
		stanfordCoreNLP.annotate(coreDocument);

		
		List<CoreLabel> coreLabelList =coreDocument.tokens();

		for (CoreLabel coreLabel : coreLabelList) {
			
			String ner=coreLabel.get(CoreAnnotations.NamedEntityTagAnnotation.class);
			
			if(ner.equals("CITY"))
			System.out.println(coreLabel.originalText());
		}
	}

}

package com.omprakash.nlp;

import java.util.List;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

public class LemmatizationExample {

	public static void main(String[] args) {
		StanfordCoreNLP stanfordCoreNLP=Pipeline.getPipeline();
		String text="hiring hire hired fired fireing fire appointed appoint appointing change innovation revolution merge combine incorporate consolidate acquision acquiring acquired launch lanching lanched launches funding financing fund raised raising participate participated participating cooperate engage compete attend attending exhibit exhibiting exhibited sponsor sponsoring sponsored supporter promoter presenter contributor presenting location new location moved to expansion opens office new office re-locate relocation announce announced announcement announcing reveal investment investing invested partner associate companion colleague new client new customer patent filed litigation award grant";
		
		CoreDocument coreDocument= new CoreDocument(text);
		stanfordCoreNLP.annotate(coreDocument);

		
		List<CoreLabel> coreLabelList =coreDocument.tokens();

		for (CoreLabel coreLabel : coreLabelList) {
			
			String lemma=coreLabel.lemma();
			System.out.println(coreLabel.originalText()+"------>"+lemma);
		}

	}

}

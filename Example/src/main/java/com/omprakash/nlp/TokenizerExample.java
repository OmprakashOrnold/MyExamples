package com.omprakash.nlp;

import java.util.List;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

public class TokenizerExample {

	public static void main(String[] args) {

		StanfordCoreNLP stanfordCoreNLP=Pipeline.getPipeline();
		String text="Hi Vijay,As I spoke with you last week, we are trying improve PASE system algorithms accuracy. One of the algorithm is, identifying the important triggers from the news.Please go through the attached document. We will discuss the current strategy and challenges.";

		CoreDocument coreDocument= new CoreDocument(text);
		stanfordCoreNLP.annotate(coreDocument);

		List<CoreLabel> coreLabelList =coreDocument.tokens();

		for (CoreLabel coreLabel : coreLabelList) {

			System.out.println(coreLabel.originalText());
		}

	}
}

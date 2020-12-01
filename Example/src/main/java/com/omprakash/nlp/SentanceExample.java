package com.omprakash.nlp;

import java.util.List;

import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreSentence;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

public class SentanceExample {

	public static void main(String[] args) {
		StanfordCoreNLP stanfordCoreNLP=Pipeline.getPipeline();
		String text="Airline Ambassadors International (AAI) is a 501(c)3 non-profit organization affiliated with the United Nations and recognized by the US Congress. It began as a network of airline employees using their pass privileges to help others and has expanded into a network of members from all backgrounds who volunteer as “Ambassadors of Goodwill” in their home communities and abroad. Membership provides a way for members to share their unique skills and talents to care for others and bring compassion into action.Thousands of our members volunteer their skills, time, finances and effort as part of three volunteer programs:1. We PROVIDE for orphans and vulnerable children via our Humanitarian Aid program.2. We PROTECT children traveling via our Medical Escort Program3. We EDUCATE on child protection via our volunteer training on Human TraffickingWe leverage contacts with the travel industry to match world resource to world need. Thousands of members volunteer their skills, time and finances to become a direct link, providing humanitarian aid and building goodwill in countries throughout the globe.";
		CoreDocument coreDocument= new CoreDocument(text);
		stanfordCoreNLP.annotate(coreDocument);
		

		List<CoreSentence> sentences =coreDocument.sentences();

		for (CoreSentence sentence : sentences) {

			System.out.println(removeSpecialCharacters(sentence.toString()));
		}

	}
	public static String removeSpecialCharacters(String inputString) {
		return inputString.replaceAll("[^a-zA-Z0-9\\s\\(\\)]", "");
	}
}

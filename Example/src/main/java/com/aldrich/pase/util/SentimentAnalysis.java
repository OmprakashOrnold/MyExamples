package com.aldrich.pase.util;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.neural.rnn.RNNCoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations.SentimentAnnotatedTree;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.CoreMap;

public class SentimentAnalysis {

	StanfordCoreNLP pipeline;

	public SentimentAnalysis() {
		Properties props = new Properties();
		props.setProperty("annotators", "tokenize, ssplit, parse, sentiment");

		pipeline = new StanfordCoreNLP(props);

	}

	public Double getSentiment(String args) throws IOException {

		// Initialize an Annotation with some text to be annotated. The text is
		// the argument to the constructor.
		Annotation annotation;
		annotation = new Annotation(args);

		// run all the selected Annotators on this text
		pipeline.annotate(annotation);

		List<CoreMap> sentences = annotation.get(CoreAnnotations.SentencesAnnotation.class);
		double totalSentiment = 0;
		for (CoreMap sentence : sentences) {
			String sentiment = sentence.get(SentimentCoreAnnotations.SentimentClass.class);
			System.out.println(sentence.toString());
			System.out.println("The first sentence overall sentiment rating is " + sentiment + "\n");
			switch (sentiment) {
			case "Positive":
				totalSentiment += 1;
				break;
			case "Very positive":
				totalSentiment += 2;
				break;
			case "Negative":
				totalSentiment -= 1;
				break;
			case "Very negative":
				totalSentiment -= 2;
				break;
			default:
				break;
			}
		}
		totalSentiment = totalSentiment / sentences.size();
		return totalSentiment;
	}

	public Integer getSentiment2(String args) {

		int mainSentiment = 0;

		// Initialize an Annotation with some text to be annotated. The text is
		// the argument to the constructor.

		if (args != null && args.length() > 0) {
			Annotation annotation;
			annotation = new Annotation(args);

			// run all the selected Annotators on this text
			pipeline.annotate(annotation);

			List<CoreMap> sentences = annotation.get(CoreAnnotations.SentencesAnnotation.class);

			for (CoreMap sentence : sentences) {

				int longest = 0;
				Tree tree = sentence.get(SentimentAnnotatedTree.class);
				int sentiment = RNNCoreAnnotations.getPredictedClass(tree);
				String partText = sentence.toString();
				if (partText.length() > longest) {
					mainSentiment = sentiment;
					longest = partText.length();
				}

			}
		}

		return mainSentiment;
	}

	public static void main(String[] args) throws Exception {

		SentimentAnalysis analysis = new SentimentAnalysis();
		String content = "PhishMe has raised $42.5 million in a Series C funding round, destined for use in an international portfolio push.";
		double totalSentiment = analysis.getSentiment(content);
		System.out.println(totalSentiment);
	}

}

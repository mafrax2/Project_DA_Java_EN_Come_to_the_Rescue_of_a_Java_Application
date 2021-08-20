package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.util.Iterator;
import java.util.List;

public class AnalyticsCounter {
	private static int headacheCount = 0; // initialize to 0
	private static int rashCount = 0; // initialize to 0
	private static int pupilCount = 0; // initialize to 0

	public static void main(String args[]) throws Exception {

		ReadSymptomDataFromFile symptomDataFromFile = new ReadSymptomDataFromFile("./Project02Eclipse/symptoms.txt");

		List<String> symptoms = symptomDataFromFile.GetSymptoms();

		int headCount = 0; // counts headaches
		for (Iterator iterator = symptoms.iterator(); iterator.hasNext();) {
			String symptom = (String) iterator.next();
			if (symptom.equals("headache")) {
				headCount++;
				System.out.println("number of headaches: " + headCount);
			} else if (symptom.equals("rush")) {
				rashCount++;
			} else if (symptom.contains("pupils")) {
				pupilCount++;
			}

		}

		// next generate output
		FileWriter writer = new FileWriter("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	}
}

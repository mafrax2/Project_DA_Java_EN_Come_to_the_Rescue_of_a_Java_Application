package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.util.List;
import java.util.Map;

public class AnalyticsCounter {
	private static int headacheCount = 0; // initialize to 0
	private static int rashCount = 0; // initialize to 0
	private static int pupilCount = 0; // initialize to 0

	public static void main(String args[]) throws Exception {

		SymptomDataReader symptomDataFromFile = new SymptomDataReader("./Project02Eclipse/symptoms.txt");

		List<String> symptomsList = symptomDataFromFile.GetSymptoms();

		Symptoms symptoms = new Symptoms(symptomsList);
		Map<String, Long> symptomsMap = symptoms.regroupAndCount();
		symptomsMap = symptoms.order(symptomsMap);

		// next generate output
		FileWriter writer = new FileWriter("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	}
}

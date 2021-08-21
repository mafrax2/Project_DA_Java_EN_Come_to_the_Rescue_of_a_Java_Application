package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class AnalyticsCounter {

	public static void main(String args[]) throws Exception {

		SymptomDataReader symptomDataFromFile = new SymptomDataReader("./Project02Eclipse/symptoms.txt");

		List<String> symptomsList = symptomDataFromFile.GetSymptoms();

		Symptoms symptoms = new Symptoms(symptomsList);
		Map<String, Long> symptomsMap = symptoms.regroupAndCount();
		symptomsMap = symptoms.order(symptomsMap);

		CustomFileWriter customFileWriter = new CustomFileWriter("result.out");
		customFileWriter.writeFile(symptomsMap);
	}
}

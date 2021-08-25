package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AnalyticsCounter {

	public static void main(String args[]) throws Exception {

		SymptomDataReader symptomDataFromFile = new SymptomDataReader("./Project02Eclipse/symptoms.txt");

		CustomFileWriter customFileWriter = new CustomFileWriter("result.out");

		dataTreatment(symptomDataFromFile, customFileWriter);

	}

	public static void dataTreatment(ISymptomReader reader, IFileWriter writer) throws IOException {
		List<String> symptomsList = reader.getSymptoms();
		Symptoms symptoms = new Symptoms(symptomsList);
		Map<String, Long> symptomsMap = symptoms.regroupAndCount();
		symptomsMap = symptoms.order(symptomsMap);
		writer.writeFile(symptomsMap);
	}

}

package com.hemebiotech.analytics;


import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class CustomFileWriter implements IFileWriter {

	private String outputFileName;

	public CustomFileWriter(String string) {
		this.outputFileName = string;
	}

	@Override
	public void writeFile(Map<String, Long> symptomsCount) throws IOException {
		writeFile(symptomsCount, outputFileName);
	}

	@Override
	public void writeFile(Map<String, Long> symptomsCount, String outputFileName) throws IOException {

		FileWriter writer = new FileWriter(outputFileName);
		for (Map.Entry<String, Long> entry : symptomsCount.entrySet()) {
			writer.write(entry.getKey() + " : " + entry.getValue() + "\n");
		}
		writer.close();

		System.out.println("File written");
	}

	public String getOutputFileName() {
		return outputFileName;
	}

	public void setOutputFileName(String outputFileName) {
		this.outputFileName = outputFileName;
	}

}

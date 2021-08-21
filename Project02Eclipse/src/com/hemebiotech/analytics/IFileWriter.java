package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.Map;

public interface IFileWriter {

	void writeFile(Map<String, Long> symptomsCount) throws IOException;

	void writeFile(Map<String, Long> symptomsCount, String outputFileName) throws IOException;

}

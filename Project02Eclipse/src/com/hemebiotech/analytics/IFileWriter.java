package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.Map;

public interface IFileWriter {

	/**
	 * 
	 * @param symptomsCount
	 * @throws IOException
	 */
	void writeFile(Map<String, Long> symptomsCount) throws IOException;

	/**
	 * 
	 * @param symptomsCount
	 * @param outputFileName
	 * @throws IOException
	 */
	void writeFile(Map<String, Long> symptomsCount, String outputFileName) throws IOException;

}

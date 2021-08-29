package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple brute force implementation
 *
 */
public class SymptomDataReader implements ISymptomReader {

	private String filepath;

	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it,
	 *                 one per line
	 */
	public SymptomDataReader(String filepath) {
		this.filepath = filepath;
	}

	private List<String> getSymptoms(String filepath) throws IOException {
		ArrayList<String> result = new ArrayList<String>();

		BufferedReader reader = new BufferedReader(new FileReader(filepath));
		try {
			if (filepath != null) {
				String line = reader.readLine();

				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
			} else {
				throw new IOException("No filepath found, please give a Filepath");
			}

			return result;

		} finally {
			if (reader != null) {
				reader.close();
			}
		}

	}

	@Override
	public List<String> getSymptoms() throws IOException {
		return this.getSymptoms(filepath);
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

}

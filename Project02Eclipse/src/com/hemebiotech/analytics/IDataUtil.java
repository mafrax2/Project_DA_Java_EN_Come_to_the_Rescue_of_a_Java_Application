package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public interface IDataUtil {

	/**
	 * 
	 * @param symptoms
	 * @return map with key: symptom , value: number of occurrences
	 */
	Map<String, Long> regroupAndCount(List<String> symptoms);

	/**
	 * 
	 * @return map with key: symptom , value: number of occurrences
	 */
	Map<String, Long> regroupAndCount();

	Map<String, Long> order(Map<String, Long> collect);

}

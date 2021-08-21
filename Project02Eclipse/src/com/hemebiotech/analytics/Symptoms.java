package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Symptoms implements IDataUtil {

	List<String> symptomsList;

	public Symptoms(List<String> symptomsList) {
		this.symptomsList = symptomsList;
	}

	@Override
	public Map<String, Long> regroupAndCount() {
		return this.regroupAndCount(symptomsList);
	}

	@Override
	public Map<String, Long> regroupAndCount(List<String> symptoms) {
		Map<String, Long> collect = new HashMap<>();

		if (!symptoms.isEmpty() && symptoms != null) {
			collect = symptoms.stream().collect(Collectors.groupingBy(String::toString, Collectors.counting()));
		} else {
			throw new NullPointerException("symptoms list is null or empty, please provide a symptom list");
		}
		return collect;
	}

	@Override
	public Map<String, Long> order(Map<String, Long> collect) {
//Solution found on internet for later reference		
//		Map<String, Long> result = collect.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors
//				.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
		ArrayList<String> keys = new ArrayList<String>(collect.keySet());
		Collections.sort(keys);
		Map<String, Long> map = new TreeMap<>();

		for (String key : keys) {
			map.put(key, collect.get(key));
		}
		return map;
	}

	public List<String> getSymptomsList() {
		return symptomsList;
	}

	public void setSymptomsList(List<String> symptomsList) {
		this.symptomsList = symptomsList;
	}

}

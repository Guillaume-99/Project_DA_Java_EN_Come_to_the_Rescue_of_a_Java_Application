package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {

	private ISymptomReader reader;
	private ISymptomWriter writer;

	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}

	public List<String> getSymptoms() {
		return this.reader.GetSymptoms();
	}

	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> counter = new HashMap<>();
		for (String symptom : symptoms){
			if (counter.containsKey(symptom)) {
				int previousNumber = counter.get(symptom);
				counter.put(symptom, previousNumber + 1);
			} else {
				counter.put(symptom, 1);
			}
		}
		return counter;
	}

	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		Map<String, Integer> sorted = new TreeMap<>();

		for (Map.Entry<String, Integer> entry : symptoms.entrySet()){
			sorted.put(entry.getKey(), entry.getValue());
		}
		return sorted;
	}

	public void writeSymptoms(Map<String, Integer> symptoms) {
		this.writer.writeSymptoms(symptoms);
	}


}


package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Anything that will read, write symptoms from a source
 */

public class AnalyticsCounter {

    private ISymptomReader reader;
    private ISymptomWriter writer;

    /**
     * init reader writer
     */

    public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    /**
     * create a List for get symptoms
     *
     * @return List read in symptoms txt
     */

    public List<String> getSymptoms() {
        return this.reader.getSymptoms();
    }

    /**
     *
     * @param symptoms List create when read symptoms txt
     * @return a Map with how many symptoms saw
     */

    public Map<String, Integer> countSymptoms(List<String> symptoms) {
        Map<String, Integer> counter = new HashMap<>();
        for (String symptom : symptoms) {
            if (counter.containsKey(symptom)) {
                int previousNumber = counter.get(symptom);
                counter.put(symptom, previousNumber + 1);
            } else {
                counter.put(symptom, 1);
            }
        }
        return counter;
    }

    /**
     * @param symptoms sort symptoms
     * @return a map sort A-Z
     */

    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
        Map<String, Integer> sorted = new TreeMap<>();

        for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
            sorted.put(entry.getKey(), entry.getValue());
        }
        return sorted;
    }

    /**
     * Write in the file result
     *
     * @param symptoms take symptoms name and how many
     */

    public void writeSymptoms(Map<String, Integer> symptoms) {
        this.writer.writeSymptoms(symptoms);
    }


}


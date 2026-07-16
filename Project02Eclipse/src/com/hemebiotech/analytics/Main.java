package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String args[]) {

        ISymptomReader symptomReader = new readSymptomDataFromFile("symptoms.txt");
        ISymptomWriter symptomWriter = new WriteSymptomDataToFile();
        AnalyticsCounter analyticsCounter = new AnalyticsCounter(symptomReader, symptomWriter);

        List<String> symptomsList = analyticsCounter.getSymptoms();
        Map<String,Integer> countSymptoms = analyticsCounter.countSymptoms(symptomsList);
        Map<String,Integer> sortSymptoms = analyticsCounter.sortSymptoms(countSymptoms);
        analyticsCounter.writeSymptoms(sortSymptoms);


    }
}

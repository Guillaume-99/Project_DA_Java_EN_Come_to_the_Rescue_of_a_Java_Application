package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Write anything that could be in the symptoms txt
 */

public class WriteSymptomDataToFile implements ISymptomWriter {

    /**
     * Try to write each symptom in result
     *
     * @param symptoms take symptoms name and how many
     */

    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {

        try {
            FileWriter writer = new FileWriter("result.out");

            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                writer.write(entry.getKey() + " : " + entry.getValue() + "\n");
            }
            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Anything that will write symptoms data from a source and how many
 *
 */

public interface ISymptomWriter {

    /**
     * Write in the file result
     *
     * @param symptoms take symptoms name and how many
     */

    public void writeSymptoms(Map<String, Integer> symptoms);

}

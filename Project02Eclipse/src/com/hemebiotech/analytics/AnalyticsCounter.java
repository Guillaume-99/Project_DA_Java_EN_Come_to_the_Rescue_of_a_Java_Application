package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class AnalyticsCounter {
	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;
	
	 static void main(String args[]) throws Exception {

		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = reader.readLine();

		// error: i deleted useless
		int headCount = 0;
		while (line != null) {

			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headacheCount++; // error: syntax 'headCount'
			}
			else if (line.equals("rash")) { // error: syntax 'rash'
				rashCount++;
			}
			else if (line.contains("pupils")) {
				pupilCount++;
			}

			line = reader.readLine();
		}
		

		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dilated pupils: " + pupilCount + "\n");
		writer.close();
	}
}

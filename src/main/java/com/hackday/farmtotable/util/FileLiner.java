package com.hackday.farmtotable.util;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class FileLiner {

	private static final String IN = "training.dat";
	private static final String OUT = "keywords.txt";

	public static void main(String args[]) throws IOException {
		Set<String> uniqueDataPoints = new HashSet<String>();

		InputStream is = FileLiner.class.getClassLoader().getResourceAsStream(IN);
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		String line;
		while ((line = br.readLine()) != null) {
			String[] data = line.split(",");
			String[] words = data[1].split(" ");
			for (String w : words) {
				uniqueDataPoints.add(w);
			}
		}

		File out = new File(OUT);
		out.createNewFile();

		// creates a FileWriter Object
		FileWriter writer = new FileWriter(out);

		Iterator<String> iterator = uniqueDataPoints.iterator();
		while (iterator.hasNext()) {
			String setElement = iterator.next();
			writer.write(setElement);
			writer.write("\n");
			writer.flush();
		}

		writer.close();
	}

}

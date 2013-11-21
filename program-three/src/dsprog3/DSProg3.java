/**
 *	@author Marshall Bowers
 */

package dsprog3;

import java.util.*;
import java.util.Map.Entry;
import java.util.regex.*;

import util.WebDoc;

public class DSProg3 {
	public static void main(String[] args) {
		final int maxPairs = 30;

		String url;
		url = "http://en.wikipedia.org/wiki/Jimi_Hendrix";
		// url = "http://www.cs.wcupa.edu/~rkline/prog3test.html";

		String word_pattern = "[A-Za-z]{5,}";

		String content = null;

		try {
			content = WebDoc.getBodyContent(url);
		} catch (Exception ex) {
			ex.printStackTrace();
			System.exit(1);
		}

		Set<String> skip = new HashSet<String>(
				Arrays.asList(new String[] { "after", "which", "later",
						"other", "during", "their", "about" }));

		Map<String, Integer> words = new HashMap<String, Integer>();
		int total = 0;
		Matcher match = Pattern.compile(word_pattern).matcher(content);

		while (match.find()) {
			String word = match.group().toLowerCase();

			// Check if word is in the skip set
			if (!skip.contains(word)) {
				// If the word is already is already in the map then increment
				// the number of occurrences
				if (words.containsKey(word)) {
					words.put(word, words.get(word) + 1);
				} else {
					// If the world is not in the map, add it to the map with
					// occurrence of 1
					words.put(word, 1);
				}
				
				// Update the number of total words
				total++;
			}
		}

		class WordFrequency implements Comparable<Object> {
			String word;
			Integer numocc;

			WordFrequency(String word, Integer numocc) {
				this.word = word;
				this.numocc = numocc;
			}

			@Override
			public int compareTo(Object compareWord) {
				// Get the occurrences for the compared word
				int occ = ((WordFrequency) compareWord).numocc;

				// Return difference of the two occurrences
				return occ - this.numocc;
			}
		}

		// Create a new ArrayList to hold the information for sorting.
		// Set initial capacity to the size of the map to avoid additional overhead
		ArrayList<WordFrequency> sortable = new ArrayList<WordFrequency>(words.size());

		// Create a new Iterator for the words map
		Iterator<Entry<String, Integer>> it = words.entrySet().iterator();

		// Iterate over the entries of the map
		while (it.hasNext()) {
			// Get the next entry
			Map.Entry<String, Integer> e = it.next();

			// Add the word and its occurrences to the sortable list
			sortable.add(new WordFrequency((String) e.getKey(), (Integer) e.getValue()));
		}

		// Sort the list
		Collections.sort(sortable);

		// Print number of total words (counting duplicates)
		System.out.println("Total Words: " + total);

		// Print number of distinct words (ignoring duplicates)
		System.out.println("Distinct Words: " + sortable.size());

		// Print words with highest occurrences (up to maxPairs)
		System.out.println("Max Pairs:");

		// Create maximum index to account for when list size < maxPairs
		int max = sortable.size() > maxPairs ? maxPairs : sortable.size();
		for (int i = 0; i < max; i++) {
			System.out.println(sortable.get(i).word + ": " + sortable.get(i).numocc);
		}
	}
}

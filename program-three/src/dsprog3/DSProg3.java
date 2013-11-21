package dsprog3;

import java.util.*;
import java.util.regex.*;

import util.WebDoc;

public class DSProg3 {
	public static void main(String[] args) {
		final int maxPairs = 30;

		String url;
		// url = "http://www.maxdeviant.com/about";
		// url = "http://en.wikipedia.org/wiki/Jimi_Hendrix";
		url = "http://www.cs.wcupa.edu/~rkline/prog3test.html";

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
			// System.out.println(word);

			// Check if word is in the skip set
			if (!skip.contains(word)) {
				// If the
				if (words.containsKey(word)) {
					words.put(word, words.get(word) + 1);
				} else {
					words.put(word, 1);
				}
			}
		}
		System.out.println(words);

		class WordFrequency implements Comparable<Object> {
			String word;
			Integer numocc;

			WordFrequency(String word, Integer numocc) {
				this.word = word;
				this.numocc = numocc;
			}

			@Override
			public int compareTo(Object compareWord) {
				int occ = ((WordFrequency) compareWord).numocc;

				return occ - this.numocc;
			}
		}

		ArrayList<WordFrequency> sortable = new ArrayList<WordFrequency>();

		Iterator it = words.entrySet().iterator();

		while (it.hasNext()) {
			Map.Entry e = (Map.Entry) it.next();

			sortable.add(new WordFrequency((String) e.getKey(), (Integer) e
					.getValue()));
		}

		Collections.sort(sortable);

		// Debugging
		// for (WordFrequency w : sortable) {
		// System.out.println(w.word + " " + w.numocc);
		// }

		for (WordFrequency w : sortable) {
			total += w.numocc;
		}

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

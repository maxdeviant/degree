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
			System.out.println(word);

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

		class WordFrequency {
			String word;
			Integer numocc;

			WordFrequency(String word, Integer numocc) {
				this.word = word;
				this.numocc = numocc;
			}
		}

		Set<WordFrequency> sortable = null;

		Iterator i = words.entrySet().iterator();

		while (i.hasNext()) {
			Map.Entry e = (Map.Entry) i.next();
			System.out.println(e.getKey() + " " + e.getValue());
//			sortable.add(new WordFrequency((String) e.getKey(), (Integer) e.getValue()));
		}

		// for (int i = 0; i < sortable.size(); i++) {
		// sortable[i] = words.get;
		// }

		// TODO Iterate through words and store map entry pairs

		// TODO Create a comparator for WordFrequency, then sort by occurrence

		// TODO Print: Total words in list

		// TODO Print: Number of distinct words

		// TODO Print: Up to maxPairs, words with highest occurrence
	}
}

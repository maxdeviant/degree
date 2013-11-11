package dsprog3;

import java.util.*;
import java.util.regex.*;
import util.WebDoc;

public class DSProg3 {
	public static void main(String[] args) {
		final int maxPairs = 30;

		String url;
		url = "http://en.wikipedia.org/wiki/Jimi_Hendrix";
//		url = "http://www.cs.wcupa.edu/~rkline/prog3test.html";

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
			
			// Add Code: ignore any word in the 'skip' set, otherwise add occurrence
		}
		
//		System.out.println(words);
		
		class WordFrequency {
			String word;
			Integer numocc;
			WordFrequency(String word, Integer numocc) {
				this.word = word;
				this.numocc = numocc;
			}
		}
	}
}

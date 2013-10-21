package dsprog2;

import java.util.*;
import tree.SearchTreeMap;

public class DSProg2 {
	private static void show(Map map) {
		System.out.println(map);
		System.out.println(map.size());
		if (map instanceof SearchTreeMap) {
			System.out.println("-----------------");
			((SearchTreeMap) map).reverseInorderOutput();
			System.out.println("-----------------");
		}
	}

	public static void main(String[] args) {
		 Map<String, Integer> map = new TreeMap<String, Integer>();
//		Map<String, Integer> map = new SearchTreeMap<String, Integer>();

		String data[] = { "MM", "GG", "SS", "DD", "LL", "NN", "UU", "FF", "JJ",
				"PP", "RR", "QQ", "II", "KK" };

		int num = 0;
		for (String s : data) {
			Integer value = (num++ < 12) ? s.hashCode() : null;
			map.put(s, value);
		}

		show(map);

		for (String s : new String[] { "MM", "GG", "KK", "RR", "MM" }) {
			System.out.println("remove(" + s + ") = " + map.remove(s));
			show(map);
		}
	}
}

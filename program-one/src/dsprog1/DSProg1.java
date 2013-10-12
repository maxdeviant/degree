package dsprog1; // Derived from the project name

import java.util.*;

import tree.SearchTreeSet;

public class DSProg1 {
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
//		NavigableSet<Integer> set = new TreeSet<Integer>();
		NavigableSet<Integer> set = new SearchTreeSet<Integer>();

		final int RANGE = 20; // random number range
		final int NUM = 12; // make this 0 to create an empty set

		// These "todo" keys are meant to focus your efforts.
		// Uncomment only the group that you're developing.
		Set<String> todo = new HashSet<String>();
//		todo.add("first-last");
//		todo.add("pollFirst");
//		todo.add("headSet");
		todo.add("floor");

		Random rand = new Random();
		for (int i = 0; i < NUM; ++i) {
			int n = rand.nextInt(RANGE);
			set.add(n);
		}

		System.out.println("\n");
		System.out.println("set = " + set);
		System.out.println("set.size() = " + set.size());

		if (set instanceof SearchTreeSet) {
			System.out.println("\n");
			((SearchTreeSet) set).reverseInorderOutput();
		}

		if (todo.contains("first-last")) {
			System.out.println("\n");
			System.out.println("set.first() = " + set.first());
			System.out.println("set.last() = " + set.last());
		}

		if (todo.contains("pollFirst")) {
			System.out.println("\n");
			System.out.println("set.pollFirst() = " + set.pollFirst());
			System.out.println("set = " + set);
			System.out.println("set.size() = " + set.size());
		}

		int elt = rand.nextInt(RANGE); // try specific values of this as well

		if (todo.contains("headSet")) {
			System.out.println("\n");
			System.out
					.println("set.headSet(" + elt + ") = " + set.headSet(elt));
		}

		if (todo.contains("floor")) {
			System.out.println("\n");
			System.out.println("set.floor(" + elt + ") = " + set.floor(elt));
		}
	}
}

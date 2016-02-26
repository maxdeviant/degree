package sorts;

import java.util.*;

public class Sorter {
	public interface Choice {
		public void sort(Object[] a);

		public void sort(Object[] a, int fromIndex, int toIndex);
	}

	private Map<String, Choice> sorts = new LinkedHashMap<String, Choice>();

	public Sorter() {
		sorts.put("select", new Selection());
		sorts.put("insert", new Insertion());
		sorts.put("shell", new Shell());
		sorts.put("quick", new Quick());
		sorts.put("merge", new Merge());
		sorts.put("heap", new Heap());
		sorts.put("java", new Java());
		sorts.put("stableQuick", new StableQuick());
	}

	public Choice getSorter(String choice) {
		return sorts.get(choice);
	}

	public Set<String> getChoices() {
		return sorts.keySet();
	}

	private class Selection implements Choice {
		@Override
		public void sort(Object[] a) {
			Algorithms.selectionSort(a);
		}

		@Override
		public void sort(Object[] a, int fromIndex, int toIndex) {
			Algorithms.selectionSort(a, fromIndex, toIndex);
		}
	}

	private class Insertion implements Choice {
		@Override
		public void sort(Object[] a) {
			Algorithms.insertionSort(a);
		}

		@Override
		public void sort(Object[] a, int fromIndex, int toIndex) {
			Algorithms.insertionSort(a, fromIndex, toIndex);
		}
	}

	private class Shell implements Choice {
		@Override
		public void sort(Object[] a) {
			Algorithms.shellSort(a);
		}

		@Override
		public void sort(Object[] a, int fromIndex, int toIndex) {
			Algorithms.shellSort(a, fromIndex, toIndex);
		}
	}

	private class Quick implements Choice {
		@Override
		public void sort(Object[] a) {
			Algorithms.quickSort(a);
		}

		@Override
		public void sort(Object[] a, int fromIndex, int toIndex) {
			Algorithms.quickSort(a, fromIndex, toIndex);
		}
	}

	private class Merge implements Choice {
		@Override
		public void sort(Object[] a) {
			Algorithms.mergeSort(a);
		}

		@Override
		public void sort(Object[] a, int fromIndex, int toIndex) {
			Algorithms.mergeSort(a, fromIndex, toIndex);
		}
	}

	private class Heap implements Choice {
		@Override
		public void sort(Object[] a) {
			Algorithms.heapSort(a);
		}

		@Override
		public void sort(Object[] a, int fromIndex, int toIndex) {
			Algorithms.heapSort(a, fromIndex, toIndex);
		}
	}

	private class Java implements Choice {
		@Override
		public void sort(Object[] a) {
			Arrays.sort(a);
		}

		@Override
		public void sort(Object[] a, int fromIndex, int toIndex) {
			Arrays.sort(a, fromIndex, toIndex);
		}
	}
	
	// -------------- added by Marshall Bowers
	private class StableQuick implements Choice {
		@Override
		public void sort(Object[] a) {
			Algorithms.stableQuickSort(a);
		}

		@Override
		public void sort(Object[] a, int fromIndex, int toIndex) {
			Algorithms.stableQuickSort(a, fromIndex, toIndex);
		}
	}
}

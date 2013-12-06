package sorts;

import java.util.*;

public class Algorithms {
	public static <E> void swap(E[] a, int i, int j) {
		E tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

	public static <E> boolean isSorted(E[] a, int fromIndex, int toIndex,
			Comparator<? super E> c) {
		for (int i = fromIndex; i < toIndex - 1; ++i) {
			if (c.compare(a[i], a[i + 1]) > 0) {
				return false;
			}
		}
		return true;
	}

	public static <E> boolean isSorted(E[] a, Comparator<? super E> c) {
		return isSorted(a, 0, a.length, c);
	}

	public static <E> boolean isSorted(Object[] a, int fromIndex, int toIndex) {
		Comparator<Object> c = new Comparator<Object>() {
			@Override
			public int compare(Object lhs, Object rhs) {
				return ((Comparable) lhs).compareTo(rhs);
			}
		};
		return isSorted(a, fromIndex, toIndex, c);
	}

	public static <E> boolean isSorted(Object[] a) {
		Comparator<Object> c = new Comparator<Object>() {
			@Override
			public int compare(Object lhs, Object rhs) {
				return ((Comparable) lhs).compareTo(rhs);
			}
		};
		return isSorted(a, 0, a.length, c);
	}

	// selectionSort
	public static <E> void selectionSort(E[] a, int fromIndex, int toIndex,
			Comparator<? super E> c) {
		for (int i = fromIndex; i < toIndex - 1; ++i) {
			int selected_index = i;
			for (int j = i + 1; j < toIndex; ++j) {
				if (c.compare(a[j], a[selected_index]) < 0) {
					selected_index = j;
				}
			}
			if (selected_index != i) {
				swap(a, selected_index, i);
			}
		}
	}

	public static <E> void selectionSort(E[] a, Comparator<? super E> c) {
		selectionSort(a, 0, a.length, c);
	}

	public static void selectionSort(Object[] a, int fromIndex, int toIndex) {
		Comparator<Object> c = new Comparator<Object>() {
			@Override
			public int compare(Object lhs, Object rhs) {
				return ((Comparable) lhs).compareTo(rhs);
			}
		};
		selectionSort(a, fromIndex, toIndex, c);
	}

	public static void selectionSort(Object[] a) {
		selectionSort(a, 0, a.length);
	}

	// insertionSort
	public static <E> void insertionSort(E[] a, int fromIndex, int toIndex,
			Comparator<? super E> c) {
		for (int i = fromIndex + 1; i < toIndex; ++i) {
			E insert_value = a[i];
			int j;
			for (j = i; j > fromIndex; --j) {
				if (c.compare(a[j - 1], insert_value) > 0) {
					a[j] = a[j - 1];
				} else {
					break;
				}
			}
			if (j != i) {
				a[j] = insert_value;
			}
		}
	}

	public static <E> void insertionSort(E[] a, Comparator<? super E> c) {
		insertionSort(a, 0, a.length, c);
	}

	public static void insertionSort(Object[] a, int fromIndex, int toIndex) {
		Comparator<Object> c = new Comparator<Object>() {
			@Override
			public int compare(Object lhs, Object rhs) {
				return ((Comparable) lhs).compareTo(rhs);
			}
		};
		insertionSort(a, fromIndex, toIndex, c);
	}

	public static void insertionSort(Object[] a) {
		insertionSort(a, 0, a.length);
	}

	// shellSort
	// permit us to specify the shell sort increments externally
	private static LinkedList<Integer> shellSortIncrements = null;

	public static void setShellSortIncrements(
			LinkedList<Integer> shellSortIncrements) {
		Algorithms.shellSortIncrements = shellSortIncrements;
	}

	public static <E> void shellSort(E[] a, int fromIndex, int toIndex,
			Comparator<? super E> c) {
		int size = toIndex - fromIndex;

		if (shellSortIncrements == null) {
			// set increments to the default
			shellSortIncrements = new LinkedList<Integer>();
			for (int inc = 1; inc < size; inc = 2 * (inc + 1) - 1) {
				shellSortIncrements.add(inc);
			}
		}
		Iterator<Integer> iter = shellSortIncrements.descendingIterator();

		while (iter.hasNext()) {
			int gap = iter.next();
			for (int k = 0; k < gap; ++k) {
				// insertionSort on ( a[fromIndex+k], a[fromIndex+k+gap], ... )
				for (int i = fromIndex + k + gap; i < toIndex; i += gap) {

					E insert_value = a[i];
					int j = i;
					for (; j >= fromIndex + k + gap; j -= gap) {

						if (c.compare(a[j - gap], insert_value) > 0) {

							a[j] = a[j - gap];
						} else {
							break;
						}
					}
					if (j != i) {
						a[j] = insert_value;
					}
				}
			}
		}
	}

	public static <E> void shellSort(E[] a, Comparator<? super E> c) {
		shellSort(a, 0, a.length, c);
	}

	public static void shellSort(Object[] a, int fromIndex, int toIndex) {
		Comparator<Object> c = new Comparator<Object>() {
			@Override
			public int compare(Object lhs, Object rhs) {
				return ((Comparable) lhs).compareTo(rhs);
			}
		};
		shellSort(a, fromIndex, toIndex, c);
	}

	public static void shellSort(Object[] a) {
		shellSort(a, 0, a.length);
	}

	// quickSort
	private static <E> E medianOf3(E a[], int left, int right,
			Comparator<? super E> c) {

		int center = (left + right) / 2;

		// do insertionsort on a[left], a[center], a[right]

		if (c.compare(a[left], a[center]) > 0) {
			swap(a, left, center);
		}
		// now left <= center
		E insert = a[right];
		if (c.compare(a[center], insert) > 0) {
			a[right] = a[center];
			if (c.compare(a[left], insert) > 0) {
				a[center] = a[left];
				a[left] = insert;
			} else {
				a[center] = insert;
			}
		}
		return a[center];
	}

	private static int QUICKSORT_CUTOFF = 10;

	public static void setQuicksortCutoff(int cutoff) {
		QUICKSORT_CUTOFF = cutoff;
	}

	private static <E> int partition(E[] a, int fromIndex, int toIndex,
			Comparator<? super E> c) {
		E pivot = medianOf3(a, fromIndex, toIndex - 1, c);
		int i = fromIndex, j = toIndex - 1;
		while (true) {
			while (c.compare(a[++i], pivot) < 0) {
			}
			while (c.compare(pivot, a[--j]) < 0) {
			}
			if (i < j) {
				swap(a, i, j);
			} else { // swap, then advance both
				break;
			}
		}
		return i;
	}

	public static <E> void quickSort(E[] a, int fromIndex, int toIndex,
			Comparator<? super E> c) {

		if (toIndex - fromIndex <= QUICKSORT_CUTOFF) {
			insertionSort(a, fromIndex, toIndex, c);
		} else {
			int i = partition(a, fromIndex, toIndex, c);

			if (i - fromIndex <= toIndex - i) {
				quickSort(a, fromIndex, i, c);
				quickSort(a, i, toIndex, c);
			} else {
				quickSort(a, i, toIndex, c);
				quickSort(a, fromIndex, i, c);
			}
		}
	}

	public static <E> void quickSort(E[] a, Comparator<? super E> c) {
		quickSort(a, 0, a.length, c);
	}

	public static void quickSort(Object[] a, int fromIndex, int toIndex) {
		Comparator<Object> c = new Comparator<Object>() {
			@Override
			public int compare(Object lhs, Object rhs) {
				return ((Comparable) lhs).compareTo(rhs);
			}
		};
		quickSort(a, fromIndex, toIndex, c);
	}

	public static void quickSort(Object[] a) {
		quickSort(a, 0, a.length);
	}

	// mergeSort
	public static <E> void mergeSort(E[] a, int fromIndex, int toIndex,
			Comparator<? super E> c) {

		E[] b = (E[]) new Object[a.length];

		boolean merge_to_a = true; // merge direction: final merge => a

		mergeSort(a, b, merge_to_a, fromIndex, toIndex, c);
	}

	private static <E> void merge(E[] source, E[] target, int fromIndex,
			int middle, int toIndex, Comparator<? super E> c) {

		int i = fromIndex, j = middle, // source indices in from array
		k = fromIndex; // target index in to array

		while (i < middle || j < toIndex) {
			if (i == middle) {
				target[k++] = source[j++];
			} else if (j == toIndex) {
				target[k++] = source[i++];
			} else {
				if (c.compare(source[i], source[j]) <= 0) { // "<=" gives
															// stability
					target[k++] = source[i++];
				} else {
					target[k++] = source[j++];
				}
			}
		}
	}

	// private helper function
	private static <E> void mergeSort(E[] a, E[] b, boolean merge_to_a,
			int fromIndex, int toIndex, Comparator<? super E> c) {

		if (toIndex - fromIndex == 0) {
			return;
		} else if (toIndex - fromIndex == 1) {
			if (!merge_to_a) { // must end up in b
				b[fromIndex] = a[fromIndex];
			}
		} else {
			// recursively sort halves merging in the opposite direction

			int middle = (toIndex + fromIndex) / 2;
			mergeSort(a, b, !merge_to_a, fromIndex, middle, c);
			mergeSort(a, b, !merge_to_a, middle, toIndex, c);

			// merge in the direction indicated by merge_to_a
			E[] source, target;
			if (merge_to_a) {
				source = b;
				target = a;
			} else {
				source = a;
				target = b;
			}

			merge(source, target, fromIndex, middle, toIndex, c);
		}
	}

	public static <E> void mergeSort(E[] a, Comparator<? super E> c) {
		mergeSort(a, 0, a.length, c);
	}

	public static void mergeSort(Object[] a, int fromIndex, int toIndex) {
		Comparator<Object> c = new Comparator<Object>() {
			@Override
			public int compare(Object lhs, Object rhs) {
				return ((Comparable) lhs).compareTo(rhs);
			}
		};
		mergeSort(a, fromIndex, toIndex, c);
	}

	public static void mergeSort(Object[] a) {
		mergeSort(a, 0, a.length);
	}

	// heapSort
	public static <E> void heapSort(E[] a, int fromIndex, int toIndex,
			Comparator<? super E> c) {

		int start = (toIndex - fromIndex) / 2;
		while (start > 0) {
			int heapInd = start;
			int par = fromIndex + heapInd - 1;
			E insert = a[par];
			int j = toIndex;
			int lchild = par + heapInd;
			int rchild = lchild + 1;
			while (true) {
				if (lchild > j - 1) { // par is a leaf
					break;
				}
				int child; // child with the largest value

				if (lchild == j - 1) {
					// i has only a left child
					child = lchild;
					heapInd = 2 * heapInd;
				} else {
					if (c.compare(a[lchild], a[rchild]) >= 0) {
						// 2 children with bigger or equal left
						child = lchild;
						heapInd = 2 * heapInd;
					} else {
						// 2 children with smaller right
						child = rchild;
						heapInd = 2 * heapInd + 1;
					}
				}
				if (c.compare(insert, a[child]) >= 0) {
					break;
				} else {
					a[par] = a[child]; // shift child up
				}
				par = fromIndex + heapInd - 1;
				lchild = par + heapInd;
				rchild = lchild + 1;
			}
			a[par] = insert;
			--start;
		}

		// move the heap top a[fromIndex] (greatest element)
		// into position a[j] and reinsert a[j]

		for (int j = toIndex - 1; j > fromIndex; --j) {
			E insert = a[j];
			a[j] = a[fromIndex];
			int heapInd = 1;
			int par = fromIndex + heapInd - 1;
			int lchild = par + heapInd;
			int rchild = lchild + 1;
			while (true) {
				if (lchild > j - 1) { // par is a leaf
					break;
				}

				int child; // child with the largest value

				if (lchild == j - 1) {
					// i has only a left child
					child = lchild;
					heapInd = 2 * heapInd;
				} else {
					if (c.compare(a[lchild], a[rchild]) >= 0) {
						// 2 children with bigger or equal left
						child = lchild;
						heapInd = 2 * heapInd;
					} else {
						// 2 children with smaller right
						child = rchild;
						heapInd = 2 * heapInd + 1;
					}
				}
				if (c.compare(insert, a[child]) >= 0) {
					break;
				} else {
					a[par] = a[child]; // shift child up
				}
				par = fromIndex + heapInd - 1;
				lchild = par + heapInd;
				rchild = lchild + 1;
			}
			a[par] = insert;
		}
	}

	public static <E> void heapSort(E[] a, Comparator<? super E> c) {
		heapSort(a, 0, a.length, c);
	}

	public static void heapSort(Object[] a, int fromIndex, int toIndex) {
		Comparator<Object> c = new Comparator<Object>() {
			@Override
			public int compare(Object lhs, Object rhs) {
				return ((Comparable) lhs).compareTo(rhs);
			}
		};
		heapSort(a, fromIndex, toIndex, c);
	}

	public static void heapSort(Object[] a) {
		heapSort(a, 0, a.length);
	}
	
	// stableQuickSort -------------- added by Marshall Bowers
	public static <E> void stableQuickSort(E[] a, int fromIndex, int toIndex, Comparator<? super E> c) {
		
	}
	
	public static <E> void stableQuickSort(E[] a, Comparator<? super E> c) {
		
	}
	
	public static void stableQuickSort(Object[] a, int fromIndex, int toIndex) {
		
	}
	
	public static void stableQuickSort(Object[] a) {
		
	}
}

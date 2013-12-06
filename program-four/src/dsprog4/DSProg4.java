package dsprog4;

import java.util.*;
import sorts.*;

public class DSProg4 {
	public static void main(String[] args) {
		mainCheckStability(args);
		// mainMakeStableQuickSort(args);
		// mainTimeSorts(args);
	}

	public static void mainCheckStability(String[] args) {
		class Sample {
			int int_part;
			char chr_part;

			Sample(int int_part, char chr_part) {
				this.int_part = int_part;
				this.chr_part = chr_part;
			}

			@Override
			public String toString() {
				return "(" + int_part + "," + chr_part + ")";
			}
		}

		Sample[] Q = new Sample[15];

		Random r = new Random();

		for (int i = 0; i < Q.length; ++i) {
			int n = r.nextInt(10);
			char c = (char) (((int) 'A') + r.nextInt(26));
			Q[i] = new Sample(n, c);
		}

		Sample[] A = Arrays.copyOf(Q, Q.length);
		Sample[] B = Arrays.copyOf(Q, Q.length);
		Sample[] C = Arrays.copyOf(Q, Q.length);
		Sample[] D = Arrays.copyOf(Q, Q.length);

		final Comparator<Sample> cmp = new Comparator<Sample>() {
			@Override
			public int compare(Sample lhs, Sample rhs) {
				return lhs.int_part - rhs.int_part;
			}
		};

		Algorithms.setQuicksortCutoff(5);

		System.out.println("array:\t" + Arrays.toString(Q) + "\n");

		Algorithms.mergeSort(A, cmp);
		System.out.println("merge,full: " + Arrays.toString(A));

		Algorithms.quickSort(B, cmp);
		System.out.println("quick,full: " + Arrays.toString(B));
		System.out.println();

		int low = 3, high = Q.length - 3;

		System.out.println("array:\t" + Arrays.toString(Q) + "\n");

		Algorithms.mergeSort(C, low, high, cmp);
		System.out.println("merge," + low + "-" + high + ": "
				+ Arrays.toString(C));

		Algorithms.quickSort(D, low, high, cmp);
		System.out.println("quick," + low + "-" + high + ": "
				+ Arrays.toString(D));
	}
	
	public static void mainMakeStableQuickSort(String[] args) {
		class Sample {
			int int_part;
			char chr_part;

			Sample(int int_part, char chr_part) {
				this.int_part = int_part;
				this.chr_part = chr_part;
			}

			@Override
			public String toString() {
				return "(" + int_part + "," + chr_part + ")";
			}
		}
		
		class MyPair {
			Sample sample;
			int index;
			
			MyPair(Sample sample, int index) {
				this.sample = sample;
				this.index = index;
			}
		}

		Sample[] Q = new Sample[15];

		Random r = new Random();

		for (int i = 0; i < Q.length; ++i) {
			int n = r.nextInt(10);
			char c = (char) (((int) 'A') + r.nextInt(26));
			Q[i] = new Sample(n, c);
		}

		Sample[] A = Arrays.copyOf(Q, Q.length);
		Sample[] B = Arrays.copyOf(Q, Q.length);
		Sample[] C = Arrays.copyOf(Q, Q.length);
		Sample[] D = Arrays.copyOf(Q, Q.length);

		final Comparator<Sample> cmp = new Comparator<Sample>() {
			@Override
			public int compare(Sample lhs, Sample rhs) {
				return lhs.int_part - rhs.int_part;
			}
		};
		
		Comparator<MyPair> sort_cmp = new Comparator<MyPair>() {
			@Override
			public int compare(MyPair lhs, MyPair rhs) {
				if (cmp.compare(lhs.sample, rhs.sample) == 0) {
					return lhs.index - rhs.index;
				}
				
				return cmp.compare(lhs.sample, rhs.sample);
			}
		};
		

		Algorithms.setQuicksortCutoff(5);

		System.out.println("array:\t" + Arrays.toString(Q) + "\n");

		Algorithms.mergeSort(A, cmp);
		System.out.println("merge,full: " + Arrays.toString(A));

		Algorithms.quickSort(B, cmp);
		System.out.println("quick,full: " + Arrays.toString(B));
		System.out.println();

		int low = 3, high = Q.length - 3;

		System.out.println("array:\t" + Arrays.toString(Q) + "\n");

		Algorithms.mergeSort(C, low, high, cmp);
		System.out.println("merge," + low + "-" + high + ": "
				+ Arrays.toString(C));

		Algorithms.quickSort(D, low, high, cmp);
		System.out.println("quick," + low + "-" + high + ": "
				+ Arrays.toString(D));
	}

	public static void mainTimeSorts(String[] args) {

		// choose the sorting algorithms
		// the array size (SIZE)
		// the random number max (RANGE)
		// the number of accumulated trials (NUM_TRIALS)

		String choices[] = { "select", "insert", "shell" };
		final int SIZE = 6000;
		final int RANGE = SIZE * 10;
		final int NUM_TRIALS = 10;

		Sorter sorter = new Sorter();

		Map<String, Sorter.Choice> sorter_for = new HashMap<String, Sorter.Choice>();
		Map<String, Long> timer_for = new HashMap<String, Long>();

		for (String choice : choices) {
			Sorter.Choice sort_alg = sorter.getSorter(choice);
			if (sort_alg == null) {
				System.out.println("bad sorter choice: " + choice);
				System.out.println("here are your choices: "
						+ sorter.getChoices());
				System.exit(1);
			}
			sorter_for.put(choice, sort_alg);
			timer_for.put(choice, new Long(0));
		}

		Random r = new Random();
		Integer[] sample = new Integer[SIZE];

		Integer[] A = new Integer[SIZE];

		for (int trial = 1; trial <= NUM_TRIALS; ++trial) {
			for (int i = 0; i < SIZE; ++i) {
				sample[i] = r.nextInt(RANGE);
			}
			for (String choice : choices) {
				Integer[] copy = (Integer[]) sample.clone();

				Sorter.Choice sort_alg = sorter_for.get(choice);

				long start = System.currentTimeMillis();
				sort_alg.sort(copy);
				long stop = System.currentTimeMillis();

				long diff = stop - start;
				long current = timer_for.get(choice);
				timer_for.put(choice, current + diff);
			}
		}

		System.out.println("array size:  " + SIZE);
		System.out.println("value range: " + RANGE);
		System.out.println("number of trials: " + NUM_TRIALS);
		for (String choice : choices) {
			long time = timer_for.get(choice);
			System.out.println("choice: " + choice + ", time: " + time);
		}
	}
}

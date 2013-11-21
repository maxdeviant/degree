package dsprog4;
import java.util.*;
import sorts.*;

public class DSProg4 {
	public static void main(String[] args) {
		mainCheckStability(args);
//		mainMakeStableQuickSort(args);
//		mainTimeSorts(args);
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
		System.out.println("merge," + low + "-" + high + ": " + Arrays.toString(C));
		
		Algorithms.quickSort(D, low, high, cmp);
		System.out.println("quick," + low + "-" + high + ": " + Arrays.toString(D));
	}
}

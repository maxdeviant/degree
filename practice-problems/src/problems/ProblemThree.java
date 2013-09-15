package problems;

public class ProblemThree {
	public static void a(int key) {
		int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18};
		
		binarySearch(arr, 0, 19, key);
	}
	
	public static int binarySearch(int[] A, int from, int to, int key) {
		if (from == to) {
			return from - 1;
		}
		
		int mid = (from + to) / 2;
		
		System.out.println(A[mid] + " : (" + from + ", " + to + ")");
		
		if (key == A[mid]) {
			return mid;
		} else if (key < A[mid]) {
			return binarySearch(A, from, mid, key);
		} else {
			return binarySearch(A, mid + 1, to, key);
		}
	}
}

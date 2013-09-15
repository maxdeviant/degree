package main;

public class Functions {
	public static int T(int n) {
		if (n == 1) {
			return 7;
		} else {
			return 2 * T(n / 2) + 3 * n;
		}
	}

	public static int U(int n) {
		if (n == 1) {
			return 7;
		} else {
			return 4 * U(n / 2) + 3 * (n * n);
		}
	}

	public static int V(int n) {
		if (n == 1) {
			return 7;
		} else {
			return 4 * V(n / 2) + 3 * n;
		}
	}
}

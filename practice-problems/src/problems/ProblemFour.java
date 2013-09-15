package problems;

import java.text.DecimalFormat;

import main.Functions;

public class ProblemFour {
	static DecimalFormat df = new DecimalFormat("#.##");

	public static void a() {
		System.out.println("n\tT(n)\t<=\tC\tn * log(n)");

		for (int n = 2; n < 7; n++) {
			System.out.println(n + "\t" + Functions.T(n) + "\t\t"
					+ df.format(T(n)) + "\t" + df.format(O(n)));
		}
	}

	public static double O(int n) {
		return n * (Math.log(n) / Math.log(2));
	}

	public static double T(int n) {
		return O(1);
	}
}

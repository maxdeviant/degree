package problems;

import java.text.DecimalFormat;

import main.Functions;

public class ProblemSeven {
	static DecimalFormat df = new DecimalFormat("#.##");

	public static void a() {
		// T(n)
		System.out.println("n\tT(n)\tn * log(n)\tT(n) / (n * log(n))");

		for (int n = 2; n < 11; n++) {
			System.out.println(n + "\t" + Functions.T(n) + "\t"
					+ df.format(ProblemFour.O(n)) + "\t\t"
					+ df.format(Functions.T(n) / ProblemFour.O(n)));
		}

		// U(n)
		System.out.println("\nn\tU(n)\tn^2 * log(n)\tU(n) / (n^2 * log(n))");

		for (int n = 2; n < 11; n++) {
			System.out.println(n + "\t" + Functions.U(n) + "\t"
					+ df.format(ProblemFive.O(n)) + "\t\t"
					+ df.format(Functions.U(n) / ProblemFive.O(n)));
		}

		// V(n)
		System.out.println("\nn\tV(n)\t10n^2 - 3n");

		for (int n = 2; n < 11; n++) {
			System.out.println(n + "\t" + Functions.V(n) + "\t"
					+ (10 * (n * n) - 3 * n));
		}
	}
}

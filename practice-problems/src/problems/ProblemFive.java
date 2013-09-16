package problems;

import java.text.DecimalFormat;

import main.Functions;

public class ProblemFive {
	static DecimalFormat df = new DecimalFormat("#.##");

	public static void a() {
		System.out.println("n\tU(n)\t<=\tC\tn^2 * log(n)");

		for (int n = 2; n < 7; n++) {
			System.out.println(n + "\t" + Functions.U(n) + "\t\t"
					+ C(n) + "\t" + df.format(O(n)));
		}
	}

	public static double O(int n) {
		return (n * n) * (Math.log(n) / Math.log(2));
	}
	
	public static int C(int n) {
		return Functions.T(n) / n;
	}
}

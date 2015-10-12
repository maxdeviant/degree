import java.util.Scanner;

/**
 * @author Marshall Bowers
 */
public class prog1 {

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        boolean isCLIMode = args.length > 0;

        int n;

        if (isCLIMode) {
            n = Integer.valueOf(args[0]);
        } else {
            n = input.nextInt();
        }

        int[] x = new int[n];
        int[] w = new int[n];

        for (int i = 0; i < n; i++) {
            if (isCLIMode) {
                x[i] = Integer.valueOf(args[i + 1]);
            } else {
                x[i] = input.nextInt();
            }

            w[i] = 1;
        }

        System.out.println("Number of input values = " + n);
        System.out.println("Input values         x = " + joinArray(x));
        System.out.println("After initialization w = " + joinArray(w));

        for (int i = 0; i < x.length - 1; i++) {
            Thread thread = new Thread(new Comparator(i, i + 1, x, w));

            thread.start();

            thread.join();
        }

        System.out.println("After Step 2         w = " + joinArray(w));

        Thread thread = new Thread(new FindMaximum(x, w));

        thread.start();
    }

    /**
     * Joins the elements of an array of integers into a string containing the elements separated by spaces.
     *
     * @param ints The array of integers to join.
     * @return A string containing the array's elements, joined by spaces.
     */
    private static String joinArray(int[] ints) {
        StringBuilder builder = new StringBuilder();

        for (int i : ints) {
            builder.append(i);

            builder.append(" ");
        }

        return builder.toString();
    }

}

/**
 * @author Marshall Bowers
 */
public class FindMaximum implements Runnable {

    private int[] x;
    private int[] w;

    public FindMaximum(int[] x, int[] w) {
        this.x = x;
        this.w = w;
    }

    @Override
    public void run() {
        for (int i = 0; i < w.length; i++) {
            if (w[i] == 1) {
                System.out.println("Maximum                = " + x[i]);
                System.out.println("Location               = " + i);
            }
        }
    }

}

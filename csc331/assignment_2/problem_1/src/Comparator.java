/**
 * @author Marshall Bowers
 */
public class Comparator implements Runnable {

    private int i;
    private int j;
    private int[] x;
    private int[] w;

    public Comparator(int i, int j, int[] x, int[] w) {
        this.i = i;
        this.j = j;
        this.x = x;
        this.w = w;
    }

    @Override
    public void run() {
        int index;

        if (x[i] < x[j]) {
            w[i] = 0;

            index = i;
        } else {
            w[j] = 0;

            index = j;
        }

        System.out.printf("Thread T(%d,%d) compares x[%d] = %d and x[%d] = %d, and writes 0 into w[%d]\n", i, j, i, x[i], j, x[j], index);
    }

}

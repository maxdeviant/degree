public class Customer implements Runnable {

    /**
     * The number of threads.
     */
    public static final int COUNT = 5;

    /**
     * The number of different resources.
     */
    private int numberOfResources;

    /**
     * The maximum number this thread will demand.
     */
    private int[] maxDemand;

    /**
     * This customer's number.
     */
    private int customerNumber;

    /**
     * The request it is making.
     */
    private int[] request;

    /**
     * Random number generator.
     */
    private java.util.Random random;

    /**
     * Synchronization object.
     */
    private Bank bank;

    public Customer(int customerNumber, int[] maxDemand, Bank bank) {
        this.customerNumber = customerNumber;
        this.maxDemand = new int[maxDemand.length];
        this.bank = bank;

        System.arraycopy(maxDemand, 0, this.maxDemand, 0, maxDemand.length);

        numberOfResources = maxDemand.length;
        request = new int[numberOfResources];
        random = new java.util.Random();
    }

    public void run() {
        boolean canRun = true;

        while (canRun) {
            try {
                // rest for a while
                SleepUtilities.nap();

                // make a resource request
                for (int i = 0; i < numberOfResources; i++)
                    request[i] = random.nextInt(maxDemand[i] + 1);

                // see if the customer can proceed
                if (bank.requestResources(customerNumber, request)) {
                    // use the resources
                    SleepUtilities.nap();

                    // release the resources
                    bank.releaseResources(customerNumber, request);
                }
            } catch (InterruptedException ie) {
                canRun = false;
            }
        }

        System.out.println("Thread # " + customerNumber + " I'm interrupted.");
    }

}

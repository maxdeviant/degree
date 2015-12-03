/**
 * The Bank
 */
public class BankImpl implements Bank {

    /**
     * The number of threads in the system.
     */
    private int n;

    /**
     * The number of resources.
     */
    private int m;

    /**
     * The amount available of each resource.
     */
    private int[] available;

    /**
     * The maximum demand of each thread.
     */
    private int[][] maximum;

    /**
     * The amount currently allocated to each thread.
     */
    private int[][] allocated;

    /**
     * The remaining needs of each thread.
     */
    private int[][] need;

    /**
     * Create a new bank with resources.
     */
    public BankImpl(int[] resources) {
        // m is the number of resources
        m = resources.length;
        n = Customer.COUNT;

        // initialize the resources array
        available = new int[m];
        System.arraycopy(resources, 0, available, 0, m);

        // create the array for storing the maximum demand by  each thread
        maximum = new int[Customer.COUNT][];
        allocated = new int[Customer.COUNT][];
        need = new int[Customer.COUNT][];
    }

    /**
     * This method is invoked by a thread when it enters the system. It records
     * its maximum demand with the bank.
     */

    public void addCustomer(int threadNum, int[] maxDemand) {
        maximum[threadNum] = new int[m];
        allocated[threadNum] = new int[m];
        need[threadNum] = new int[m];

        System.arraycopy(maxDemand, 0, maximum[threadNum], 0, maxDemand.length);
        System.arraycopy(maxDemand, 0, need[threadNum], 0, maxDemand.length);
    }

    /**
     * Outputs the state for each thread
     */
    public void getState() {
        System.out.print("Available = [");

        for (int i = 0; i < m - 1; i++) {
            System.out.print(available[i] + " ");
        }

        System.out.println(available[m - 1] + "]");
        System.out.print("\nAllocation = ");

        for (int i = 0; i < n; i++) {
            System.out.print("[");

            for (int j = 0; j < m - 1; j++) {
                System.out.print(allocated[i][j] + " ");
            }

            System.out.print(allocated[i][m - 1] + "]");
        }

        System.out.print("\nMax = ");

        for (int i = 0; i < n; i++) {
            System.out.print("[");

            for (int j = 0; j < m - 1; j++) {
                System.out.print(maximum[i][j] + " ");
            }

            System.out.print(maximum[i][m - 1] + "]");
        }

        System.out.print("\nNeed = ");

        for (int i = 0; i < n; i++) {
            System.out.print("[");

            for (int j = 0; j < m - 1; j++) {
                System.out.print(need[i][j] + " ");
            }

            System.out.print(need[i][m - 1] + "]");
        }

        System.out.println();
    }

    /**
     * Determines whether granting a request results in leaving the system in a safe state or not.
     *
     * @param threadNum
     * @param request
     * @return Whether or not the system is in a safe state.
     */
    private boolean isSafeState(int threadNum, int[] request) {
        System.out.print("\n Customer # " + threadNum + " requesting ");

        for (int i = 0; i < m; i++) {
            System.out.print(request[i] + " ");
        }

        System.out.print("Available = ");

        for (int i = 0; i < m; i++) {
            System.out.print(available[i] + "  ");
        }

        // first check if there are sufficient resources available
        for (int i = 0; i < m; i++) {
            if (request[i] > available[i]) {
                System.err.println("INSUFFICIENT RESOURCES");

                return false;
            }
        }

        // ok, there are. Now let's see if we can find an ordering of threads to finish
        //initialize the Finish (canFinish) matrix
        boolean[] canFinish = new boolean[n];

        for (int i = 0; i < n; i++) {
            canFinish[i] = false;
        }

        // copy the available matrix to avail
        int[] avail = new int[m];
        System.arraycopy(available, 0, avail, 0, available.length);

        // Now decrement avail by the request.
        // Temporarily adjust the value of need for this thread.
        // Temporarily adjust the value of allocated for this thread.
        for (int i = 0; i < m; i++) {
            avail[i] -= request[i];
            need[threadNum][i] -= request[i];
            allocated[threadNum][i] += request[i];
        }

        /**
         * Now try to find an ordering of threads so that
         * each thread can finish.
         */

        for (int i = 0; i < n; i++) {
            // first find a thread that can finish
            for (int j = 0; j < n; j++) {
                if (!canFinish[j]) {
                    boolean temp = true;

                    for (int k = 0; k < avail.length; k++) {
                        if (!((maximum[j][k] - allocated[j][k]) > avail[k])) {
                            canFinish[j] = true;

                            for (int l = 0; l < avail.length; l++) {
                                avail[l] += allocated[j][l];
                            }
                        }
                    }
                }
            }
        }

        //Because earlier we temporarily adjusted the value of need and allocated,
        // we need to restore the value of need and allocated for this thread
        for (int i = 0; i < available.length; i++) {
            allocated[threadNum][i] -= request[i];
        }

        // now go through the boolean array and see if all threads could complete
        //if not, set returnValue to false
        for(int i = 0; i < canFinish.length; i++){
            if(canFinish[i] == false){
                return false;
            }
        }

        return true;
    }

    /**
     * Make a request for resources. This is a blocking method that returns
     * only when the request can safely be satisfied.
     *
     * @return false - the request is not granted.
     */
    public synchronized boolean requestResources(int threadNum, int[] request) {
        if (!isSafeState(threadNum, request)) {
            //System.out.println("Customer # " + threadNum + " is denied.");
            return false;
        }

        // if it is safe, allocate the resources to thread threadNum
        for (int i = 0; i < request.length; i++) {
            if (request[i] > available[i]) {
                return false;
            }

            if (request[i] > maximum[threadNum][i]) {
                return false;
            }
        }

        //For debugging:
        System.out.println("Customer # " + threadNum + " using resources.");
        System.out.print("Available = ");

        for (int i = 0; i < m; i++) {
            System.out.print(available[i] + "  ");
        }

        System.out.print("Allocated = [");

        for (int i = 0; i < m; i++) {
            System.out.print(allocated[threadNum][i] + "  ");
        }

        System.out.print("]");

        return true;
    }

    /**
     * Release resources.
     *
     * @param threadNum The number of the customer being added.
     * @param release   The resources to be released.
     */
    public synchronized void releaseResources(int threadNum, int[] release) {
        System.out.print("\n Customer # " + threadNum + " releasing ");
        for (int i = 0; i < m; i++) System.out.print(release[i] + " ");

        //modify available, allocated, and need matrices
        //FILL IN THE BLANKS HERE!!!!


        //output available and allocated matrices
        System.out.print("Available = ");
        for (int i = 0; i < m; i++)
            System.out.print(available[i] + "  ");

        System.out.print("Allocated = [");
        for (int i = 0; i < m; i++)
            System.out.print(allocated[threadNum][i] + "  ");
        System.out.print("]");


    }

}

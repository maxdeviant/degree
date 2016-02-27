import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * A factory class that creates (1) the bank and (2) each customer at the bank.
 * <p>
 * Usage:
 * java Factory <one or more resources>
 * <p>
 * I.e.
 * java Factory 10 5 7
 */
public class Factory {

    public static void main(String[] args) {
        int numOfResources = args.length;
        int[] resources = new int[numOfResources];

        for (int i = 0; i < numOfResources; i++) {
            resources[i] = Integer.parseInt(args[i].trim());
        }

        Bank theBank = new BankImpl(resources);
        int[] maxDemand = new int[numOfResources];

        // the customers
        Thread[] workers = new Thread[Customer.COUNT];

        // read initial values for maximum array
        String line;

        try {
            BufferedReader inFile = new BufferedReader(new FileReader("infile.txt"));

            int threadNumber = 0;
            int resourceNumber = 0;

            for (int i = 0; i < Customer.COUNT; i++) {
                line = inFile.readLine();

                StringTokenizer tokens = new StringTokenizer(line, ",");

                while (tokens.hasMoreTokens()) {
                    int amount = Integer.parseInt(tokens.nextToken().trim());

                    maxDemand[resourceNumber++] = amount;
                }

                workers[threadNumber] = new Thread(new Customer(threadNumber, maxDemand, theBank));
                theBank.addCustomer(threadNumber, maxDemand);
                //theBank.getCustomer(threadNum);
                ++threadNumber;
                resourceNumber = 0;
            }
        } catch (FileNotFoundException e) {
            throw new Error("Unable to find file \"infile.txt\"");
        } catch (IOException e) {
            throw new Error("Error processing \"infile.txt\"");
        }

        // start all the customers
        System.out.println("FACTORY: created threads");

        for (int i = 0; i < Customer.COUNT; i++) {
            workers[i].start();
        }

        System.out.println("FACTORY: started threads");

        /**
         try { Thread.sleep(5000); } catch (InterruptedException ie) { }
         System.out.println("FACTORY: interrupting threads");
         for (int i = 0; i < Customer.COUNT; i++)
         workers[i].interrupt();
         */
    }

}

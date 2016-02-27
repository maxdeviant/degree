/**
 * @author Marshall Bowers
 */
public class Problem2 {

   public static void main(String[] args) throws InterruptedException {
       Thread threadA = new Thread(new PrintA());
       Thread threadB = new Thread(new PrintB());
       Thread threadC = new Thread(new PrintC());

       Thread[] threads = {threadA, threadB, threadC};

       int runningThread = 0;

       while (true) {
           threads[runningThread % threads.length].start();
           threads[runningThread % threads.length].join();

           if (++runningThread == 3000) {
               break;
           }
       }
   }

}

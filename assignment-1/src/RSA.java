import java.math.BigInteger;
import java.util.Random;

/**
 * Marshall Bowers
 * CSC 302
 * Assignment 1
 */

public class RSA {

    private BigInteger p;
    private BigInteger q;
    private BigInteger n;
    private BigInteger phi;
    private BigInteger e;
    private BigInteger d;

    public RSA() {
        p = BigInteger.probablePrime(256, new Random());
        q = BigInteger.probablePrime(256, new Random());

//        p = new BigInteger("61");
//        q = new BigInteger("53");

//        System.out.println(p);
//        System.out.println(q);

        n = p.multiply(q);

//        System.out.println(n);

        phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        System.out.println(phi);

        e = BigInteger.ONE;

        while (e.intValue() < phi.intValue()) {
            e = e.nextProbablePrime();

            if (phi.gcd(e).intValue() == 1) {
                break;
            }
        }

        System.out.println(e);

        d = e.modInverse(phi);

        System.out.println(d);
    }

}

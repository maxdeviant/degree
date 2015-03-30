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

    public RSA() {
        p = BigInteger.probablePrime(2048, new Random());
        q = BigInteger.probablePrime(2048, new Random());

        System.out.println(p);
        System.out.println(q);

        n = p.multiply(q);

        System.out.println(n);
    }

}

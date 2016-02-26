import java.math.BigInteger;

/**
 * Marshall Bowers
 * CSC 302
 * Assignment 1
 */

public class PublicKey {

    private BigInteger e;
    private BigInteger n;

    public PublicKey(BigInteger e, BigInteger n) {
        this.e = e;
        this.n = n;
    }

    public BigInteger getE() {
        return e;
    }

    public BigInteger getN() {
        return n;
    }

    public String toString() {
        return "<" + e + ", " + n + ">";
    }

}

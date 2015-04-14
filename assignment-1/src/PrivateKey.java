import java.math.BigInteger;

/**
 * Marshall Bowers
 * CSC 302
 * Assignment 1
 */

public class PrivateKey {

    private BigInteger d;
    private BigInteger n;

    public PrivateKey(BigInteger d, BigInteger n) {
        this.d = d;
        this.n = n;
    }

    public BigInteger getD() {
        return d;
    }

    public BigInteger getN() {
        return n;
    }


}

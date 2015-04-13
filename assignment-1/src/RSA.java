import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
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
        p = BigInteger.probablePrime(1024, new Random());
        q = BigInteger.probablePrime(1024, new Random());

        n = p.multiply(q);

        phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        e = BigInteger.ONE;

        while (e.intValue() < phi.intValue()) {
            e = e.nextProbablePrime();

            if (phi.gcd(e).intValue() == 1) {
                break;
            }
        }

        d = e.modInverse(phi);
    }

    public String encrypt(String message) {
        BigInteger plaintext = new BigInteger(message.getBytes(StandardCharsets.UTF_8));

        BigInteger encrypted = plaintext.modPow(e, n);

        return encrypted.toString();
    }

    public String decrypt(String encryptedText, String publicKey) {
        BigInteger encrypted = new BigInteger(encryptedText);

        BigInteger decrypted = encrypted.modPow(d, n);

        return new String(decrypted.toByteArray());
    }

}

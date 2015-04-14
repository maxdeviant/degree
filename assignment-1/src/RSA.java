import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Random;

/**
 * Marshall Bowers
 * CSC 302
 * Assignment 1
 */

public class RSA {

    private PublicKey publicKey;
    private PrivateKey privateKey;

    private BigInteger signature;

    public RSA() {
        BigInteger p = BigInteger.probablePrime(1024, new Random());
        BigInteger q = BigInteger.probablePrime(1024, new Random());

        BigInteger n = p.multiply(q);

        BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        BigInteger e = BigInteger.ONE;

        while (e.intValue() < phi.intValue()) {
            e = e.nextProbablePrime();

            if (phi.gcd(e).equals(BigInteger.ONE)) {
                break;
            }
        }

        BigInteger d = e.modInverse(phi);

        publicKey = new PublicKey(e, n);
        privateKey = new PrivateKey(d, n);
    }

    public String encrypt(String message) {
        BigInteger plaintext = new BigInteger(message.getBytes(StandardCharsets.UTF_8));

        BigInteger encrypted = plaintext.modPow(publicKey.getE(), publicKey.getN());

        signature = generateSignature(plaintext);

        return encrypted.toString(16);
    }

    public String decrypt(String encryptedText) {
        BigInteger encrypted = new BigInteger(encryptedText, 16);

        BigInteger decrypted = encrypted.modPow(privateKey.getD(), privateKey.getN());

        return new String(decrypted.toByteArray());
    }

    public boolean isVerified(String message) {
        BigInteger plaintext = new BigInteger(message.getBytes(StandardCharsets.UTF_8));

        return isVerified(plaintext);
    }

    private boolean isVerified(BigInteger message) {
        return generateVerification(signature).equals(message);
    }

    private BigInteger generateSignature(BigInteger message) {
        return message.modPow(privateKey.getD(), privateKey.getN());
    }

    private BigInteger generateVerification(BigInteger signature) {
        return signature.modPow(publicKey.getE(), publicKey.getN());
    }

}

/**
 * Marshall Bowers
 * CSC 302
 * Assignment 1
 */

public class Test {

    public static void main(String[] argv) {
        RSA rsa = new RSA(1024);

        String message = "Hello, World!";

        System.out.println("Public Key: " + rsa.getPublicKey());
        System.out.println("Private Key: " + rsa.getPrivateKey());

        System.out.println("Original Message:  " + message);

        String encrypted = rsa.encrypt(message);

        System.out.println("Encrypted Message: " + encrypted);

        String decrypted = rsa.decrypt(encrypted);

        System.out.println("Decrypted Message: " + decrypted);

        System.out.println(decrypted);

        System.out.println("Verified: " + rsa.isVerified(message));
    }

}

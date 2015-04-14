/**
 * Marshall Bowers
 * CSC 302
 * Assignment 1
 */

public class Test {

    public static void main(String[] argv) {
        RSA rsa = new RSA();

        String message = "Hello, World!";

        String encrypted = rsa.encrypt(message);

        System.out.println(encrypted);

        String decrypted = rsa.decrypt(encrypted);

        System.out.println(decrypted);

        System.out.println(rsa.isVerified(message));
    }

}

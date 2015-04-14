/**
 * Marshall Bowers
 * CSC 302
 * Assignment 1
 */

public class Test {

    public static void main(String[] argv) {
        RSA rsa = new RSA();

        String encrypted = rsa.encrypt("Hello, World!");

        System.out.println(encrypted);

        String decrypted = rsa.decrypt(encrypted);

        System.out.println(decrypted);
    }

}

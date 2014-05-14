/*
 * 495 - Fibonacci Freeze
 * 
 * Compute fibs bottom-up. Use BigInteger.
 */

import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    /**
     * Entry point.
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String fmt = "The Fibonacci number for %d is %d\n";

        BigInteger[] fibs = fibs(5001);

        while (in.hasNextInt()) {
            int n = in.nextInt();
            System.out.format(fmt, n, Util.fibs[n]);
        }

        in.close();
    }
}
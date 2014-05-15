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
            System.out.format(fmt, n, fibs[n]);
        }

        in.close();
    }
    
    /**
     * Returns an array of n Fibonacci numbers.
     */
    static BigInteger[] fibs(int n) {
        BigInteger[] fibs = new BigInteger[n];
        fibs[0] = BigInteger.ZERO;
        fibs[1] = BigInteger.ONE;

        for (int i = 2; i < fibs.length; i++)
            fibs[i] = fibs[i - 1].add(fibs[i - 2]);

        return fibs;
    }
}
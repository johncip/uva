/*
 * 10127 - Ones
 * 
 * We want to know when the value of some X mod N. We can store N but not X.
 * X is a sequence of ones with unknown length.
 * 
 * Some mod facts:
 *  If X = AB [A, B in integers] then X mod M = A(B mod M) mod M.
 *  Also, (X + 1) mod M = (X mod M + 1) mod M. 
 * 
 * We can combine these to get:
 *  (10X + 1) mod M = (10(X mod M) + 1) mod M.
 * 
 * Thus we can check each sequence of ones without storing it.
 * 
 * e.g. given M = 1 mod N:
 *          11 mod n = (M * 10 + 1) % n
 *      
 *      given M = 11 mod N:
 *          111 mod n = (M * 10 + 1) % n
 * 
 * We count the number of iterations and stop when the remainder is 0.
 * 
 * My thanks to v1n1t for the insight and clear explanation.
 * 
 * My original idea was to generate all of the sequences of 1s using BigInts,
 * up to some arbitrary limit, thinking the limit (and thus the search space)
 * would be rather small, perhaps less than 100. Unfortunately is much higher,
 * at least 5000, at which point I started exceeding the time limit.
 */

import java.util.Scanner;

public class Main {

    /**
     * Entry point.
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextInt())
            System.out.println(lenOnes(in.nextInt()));

        in.close();
    }

    /**
     * Returns the length of the smallest number composed of only ones which has
     * n as a divisor.
     */
    static int lenOnes(int n) {
        int v = 0;
        int digits = 0;

        do {
            v = (10 * v + 1) % n;
            digits++;
        } while (v != 0);

        return digits;
    }
}

/*
 * 160 - Factors and Factorials
 * 
 * Do the prime factorization for each number from 2 to n and count the
 * occurrence of each prime.
 * 
 * Is there a faster way?
 */

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    /**
     * the prime numbers from 2 to 100
     */
    static int[] primes = Primes.primes(30);

    /**
     * Entry point. For each number n, outputs the number of occurrences of each
     * prime in n!.
     */
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        StringBuilder res = new StringBuilder();
        BufferedOutputStream out = new BufferedOutputStream(System.out);

        for (int n = in.nextInt(); n != 0; n = in.nextInt()) {
            output(n, occurs(n), res);
            res.append('\n');
        }

        out.write(res.toString().getBytes());
        
        in.close();
        out.close();
    }

    /**
     * Produces the output for a given number and occurrence table.
     */
    private static void output(int n, int[] occurs, StringBuilder res) {
        res.append(String.format("%3d", n));
        res.append("! =");

        for (int i = 0; i < occurs.length; i++) {
            int o = occurs[i];
            if (o == 0)
                return;

            if (i > 0 && i % 15 == 0)
                res.append("\n      ");

            res.append(String.format("%3d", o));
        }
    }

    /**
     * Returns a table of the number of times each prime <= 100 occurs in n!.
     */
    private static int[] occurs(int n) {
        int[] occurs = new int[primes.length];

        fact: for (int f = 2; f <= n; f++)
            for (int i = 0; i < primes.length; i++) {
                int p = primes[i];
                int fc = f; // use a copy

                while (fc % p == 0) {
                    occurs[i]++;
                    fc /= p;

                    if (fc == 1)
                        continue fact;
                }
            }

        return occurs;
    }

}

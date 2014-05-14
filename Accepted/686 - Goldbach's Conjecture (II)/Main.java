/*
 * 686 - Goldbach's Conjecture (II)
 * 
 * Iterate over primes <= n/2, check if difference is also prime.
 * 
 * Using both a list of primes and a sieve, could probably also just use the
 * list of primes and binary search it to determine membership.
 */

import java.util.Scanner;

public class Main {

    static int[] primes = Primes.primes(5000);
    static boolean[] isPrime = Primes.sieve(32768);

    /**
     * Entry point.
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder res = new StringBuilder();

        for (int n = in.nextInt(); n != 0; n = in.nextInt()) {
            res.append(handleCase(n));
            res.append('\n');
        }

        System.out.print(res);
        in.close();
    }

    /**
     * Returns the number of distinct pairs of primes which add up to n.
     */
    static int handleCase(int n) {
        int pairs = 0;

        for (int i = 0; primes[i] <= n / 2; i++) {
            int p = primes[i];

            if (isPrime[n - p])
                pairs++;
        }

        return pairs;
    }

}

/*
 * 10110 - Light, more light
 * 
 * The final solution turned out to be far simpler, because it's possible
 * to know if the number of divisors is even or odd without actually
 * calculating it.
 * 
 * I believe this one to work, although it doesn't work in
 * under the time limit. The idea is to do the prime factorization
 * and a little combinatorial work, which is explained below.
 * 
 */

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FirstTry {

    static BufferedReader in = new BufferedReader(new InputStreamReader(
            System.in));
    static BufferedOutputStream out = new BufferedOutputStream(System.out);
    static StringBuilder res = new StringBuilder();
    static int[] primes = new int[1000];

    /**
     * Entry point. For each test case, prints yes if the number of divisors is
     * odd, no if not.
     */
    public static void main(String[] args) throws NumberFormatException,
            IOException {

        for (int i = 0; i < 1000; i++)
            System.out.format("%d = %b\n", i, divisorsBF(i) % 2 == 0);

        cachePrimes();

        while (true) {
            String line = in.readLine();
            long n = Long.parseLong(line);

            if (n == 0)
                break;

            int divs = divisors(n);
            res.append(divs % 2 == 1 ? "yes" : "no");
            res.append("\n");
        }

        out.write(res.toString().getBytes());
        out.flush();

        in.close();
        out.close();

    }

    /**
     * Generates and stores a few primes.
     */
    private static void cachePrimes() {
        primes[0] = 2;
        int n = 1; // number stored

        candidates: for (int c = 3; n < primes.length; c += 2) {
            for (int i = 0; i < n; i++)
                if (c % primes[i] == 0)
                    continue candidates;
            primes[n++] = c;
        }
    }

    /**
     * The number of divisors of n in [1..n].
     */
    private static int divisors(final long n) {

        // each time we see a new prime factor p,
        // double the number of divisors
        // for each power p^n that's a divisor
        // and then add one for each p^n

        int divisors = 0;
        int p_idx = 0;
        boolean broke = false;
        int sqrt = (int) (Math.sqrt(n) + 1);

        long m = n;
        while (m > 1) {
            int p = primes[p_idx++];

            if (p > sqrt) {
                broke = true;
                break;
            }

            int seen = 0;
            while (m % p == 0) {
                seen++;
                m /= p;
            }
            divisors *= (seen + 1);
            divisors += seen;
        }

        divisors += 1; // the number one

        if (broke)
            divisors *= 2; // must be the square root, add it in

        // ^^^ should have been the point at which I realized
        // numbers with an integer square root were special

        return divisors; // 1
    }

    /**
     * The number of divisors of n in [1..n] (brute force).
     */
    private static int divisorsBF(long n) {
        int divisors = 0;

        for (long i = 1; i <= n; i++)
            if (n % i == 0)
                divisors++;

        return divisors;
    }

}

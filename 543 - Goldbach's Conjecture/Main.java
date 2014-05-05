/*
 * 543 - Goldbach's Conjecture
 * 
 * Use a sieve.
 * 
 * To stay under the time limit, avoid scanner and don't print until the end.
 * 
 * To submit: include Util/Primes
 */

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static boolean[] prime = Primes.sieve(1000000);
    static BufferedReader in = new BufferedReader(new InputStreamReader(
            System.in));

    /**
     * Entry point. For each input number m, print the pair of primes which add
     * up to it.
     */
    public static void main(String[] args) throws IOException {
        BufferedOutputStream out = new BufferedOutputStream(System.out);
        StringBuilder res = new StringBuilder();

        while (true) {
            int n = readInt();
            if (n == 0)
                break;

            int p = firstPrime(n);
            res.append(String.format("%d = %d + %d\n", n, p, n - p));
        }

        in.close();
        out.write(res.toString().getBytes());
        out.close();
    }

    /**
     * Reads an int from the input.
     */
    private static int readInt() throws IOException {
        return Integer.parseInt(in.readLine());
    }

    /**
     * Returns the first prime in a pair of primes which add up to n.
     */
    private static int firstPrime(int n) {
        for (int p = 3, q = n - 3;; p++, q--) {
            if (prime[p] && prime[q])
                return p;
        }
    }
}

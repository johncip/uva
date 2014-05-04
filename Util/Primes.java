/*
 * Utilities for generating prime numbers.
 */

// TODO: iterator with resizing array

class Primes {

    /**
     * Returns an array of the first n primes by checking candidates for
     * primality.
     */
    static int[] primes(int n) {
        int[] primes = new int[n];
        if (n == 0)
            return primes;

        int i = 0; // location of next prime
        primes[0] = 2;
        i++;

        candidates: for (int c = 3; i < n; c += 2) {
            for (int j = 0; j < i; j++)
                if (c % primes[j] == 0)
                    continue candidates;
            primes[i++] = c;
        }

        return primes;
    }

    /**
     * Returns a boolean array of primality for numbers up to n.
     * 
     * Can we stop at sqrt(n) in the inner loop?
     */
    static boolean[] sieve(int n) {
        boolean[] primes = new boolean[n];
        if (n < 3)
            return primes;

        // init with 2 and all odds >= 3 : true
        primes[2] = true;
        for (int i = 3; i < n; i += 2) {
            primes[i] = true;
        }

        // keep odd base and discard multiples
        for (int i = 3; i < n; i += 2) {
            if (primes[i] == false)
                continue;

            for (int j = 2; i * j < n; j++)
                primes[i * j] = false;
        }

        return primes;
    }
}
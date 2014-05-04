public class Primes {

    static int[] primes;

    /**
     * Creates and fills the primes array.
     */
    static void cachePrimes(int cap) {
        primes = new int[cap];
        primes[0] = 2;
        int n = 1; // number stored

        candidates: for (int c = 3; n < primes.length; c += 2) {
            for (int i = 0; i < n; i++)
                if (c % primes[i] == 0)
                    continue candidates;
            primes[n++] = c;
        }
    }
}

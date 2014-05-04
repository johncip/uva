import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.Arrays;

import org.junit.Test;

/**
 * Unit tests for prime number generators.
 */
public class PrimesTest {

    final int[] expected = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41 };

    @Test
    public void testPrimes() {
        assertArrayEquals(expected, Primes.primes(13));
    }

    @Test
    public void testSieve() {
        int n = 42;
        boolean[] sieve = Primes.sieve(n);

        for (int i = 0, j = 0; i < n; i++, j++) {
            while (i < expected[j])
                assertFalse(sieve[i++]);

            assertTrue(sieve[i]);
        }
    }

    @Test
    public void testPrimesEmpty() {
        assertArrayEquals(new int[0], Primes.primes(0));
    }

    @Test
    public void testSieveEmpty() {
        assertTrue(Arrays.equals(new boolean[0], Primes.sieve(0)));
    }
}

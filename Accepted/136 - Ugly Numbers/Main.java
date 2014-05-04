/*
 * 136 - Ugly Numbers
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("The 1500'th ugly number is 859963392.");

        // // code used to compute
        // int n = 1500;
        // UglyGenerator gen = new UglyGenerator();
        // for (int i = 0; i < n - 1; i++) gen.next();
        // System.out.format("The 1500'th ugly number is %d.\n", gen.next());
    }
}

/**
 * Generates ugly numbers.
 */
class UglyGenerator {

    static private int[] factors = { 2, 3, 5 };
    private int cur = 1;

    /**
     * Returns the next ugly number.
     */
    public int next() {
        int prev = cur;
        while (!isUgly(++cur))
            ;
        return prev;
    }

    private boolean isUgly(int x) {
        for (int y : factors)
            while (x % y == 0)
                x /= y;

        return x == 1;
    }

}

/*
 * 357 - Let Me Count The Ways
 * 
 * This is #674 - Coin Change, with a different output format and a larger
 * maximum n.
 * 
 * We need a long to store the result.
 */

import java.util.Scanner;

public class Main {

    static int[] coins = { 50, 25, 10, 5, 1 };
    static long[][] cache = new long[4][30001]; // max stated in problem

    /**
     * Entry point. For each value, prints the number of ways to make change
     * using US coins up to half-dollar.
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String fmt = "There are %d ways to produce %d cents change.\n";
        String fmt1 = "There is only 1 way to produce %d cents change.\n";

        while (in.hasNextInt()) {
            int n = in.nextInt();
            long ways = ways(n, 0);

            if (ways == 1)
                System.out.format(fmt1, n);
            else
                System.out.format(fmt, ways, n);
        }

        in.close();
    }

    /**
     * Counts the number of ways to make change for n cents.
     */
    static long ways(int n, int first) {
        if (n < 0) // degenerate, stop recursion
            return 0;

        if (n == 0) // exactly one way for 0c
            return 1;

        if (first == coins.length - 1) // pennies
            return 1;

        if (cache[first][n] > 0)
            return cache[first][n];

        long res = ways(n - coins[first], first) + ways(n, first + 1);
        cache[first][n] = res;
        return res;
    }
}

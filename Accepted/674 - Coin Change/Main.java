/*
 * 674 - Coin Change
 * 
 * The number of ways to make change for a n using a particular set of
 * distinct, sorted coin values, W(n, {coins}), is equal to:
 * 
 *  W(n - v, {coins}), where v is the value of the first coin
 *          +
 *  W(n, {coins - v}), i.e. the way to make change for n without the first coin
 *                          available.
 * 
 * The above is true in the presence of the following base cases:
 *      W(n < 0, {coins}) -> 0
 *      W(0, {coins}) -> 1
 *      W(n, {1}) -> 1   , or   W(n, {}) -> 0
 * 
 * Sadly, after many different tries to find a suitable recursive solution
 * which did not double-count any possibilities, I had to look it up here:
 * 
 * http://mitpress.mit.edu/sicp/full-text/sicp/book/node16.html
 * 
 * Here the second parameter of ways() is not the set of coins but an index
 * to the coins array.
 * 
 * Large values of n take a very long time to compute, but always involve
 * computing smaller values of n, so we're using a cache to speed things up.
 */

import java.util.Scanner;

public class Main {

    static int[] coins = { 50, 25, 10, 5, 1 };
    static int[][] cache = new int[4][7490];

    /**
     * Entry point. For each value, prints the number of ways to make change
     * using US coins up to half-dollar.
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextInt())
            System.out.println(ways(in.nextInt(), 0));

        in.close();
    }

    /**
     * Counts the number of ways to make change for n cents.
     */
    static int ways(int n, int first) {
        if (n < 0) // degenerate, stop recursion
            return 0;

        if (n == 0) // exactly one way for 0c
            return 1;

        if (first == coins.length - 1) // pennies
            return 1;

        if (cache[first][n] > 0)
            return cache[first][n];

        int res = ways(n - coins[first], first) + ways(n, first + 1);
        cache[first][n] = res;
        return res;
    }
}

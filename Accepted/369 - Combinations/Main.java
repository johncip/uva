/*
 * 369 - Combinations
 * 
 * n choose k is the binomial coefficient nC_k. Calculate and store the table
 * of binomial coefficients, bottom-up.
 */

import java.util.Scanner;

public class Main {

    /**
     * Entry point.
     */
    public static void main(String[] args) {
        String fmt = "%d things taken %d at a time is %d exactly.\n";
        Scanner in = new Scanner(System.in);

        long[][] bc = binom(101, 101);

        while (in.hasNextInt()) {
            int n = in.nextInt();
            int k = in.nextInt();

            if (n == 0 && k == 0)
                break;

            System.out.format(fmt, n, k, bc[n][k]);
        }

        in.close();
    }

    /**
     * Produces a table of the binomial coefficients up to n and up to k.
     */
    static long[][] binom(int n, int k) {
        long[][] bc = new long[n][k];

        for (int i = 0; i < n; i++)
            bc[i][0] = 1; // 1 way to choose 0 items

        for (int i = 0; i < k; i++)
            bc[i][i] = 1; // 1 way to choose k=n items

        for (int i = 1; i < n; i++)
            for (int j = 1; j < k && j < i; j++)
                bc[i][j] = bc[i - 1][j] + bc[i - 1][j - 1];

        return bc;
    }

}

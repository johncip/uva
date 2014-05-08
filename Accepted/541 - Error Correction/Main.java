/*
 * 541 - Error Correction
 * 
 * Check each row and column for badness. Matrix can be fixed by flipping one
 * bit if exactly one row and one column are bad.
 * 
 * "...to be in error is to be reborn." - Alan J. Perlis
 */

import java.util.Scanner;

public class Main {

    static Scanner in = new Scanner(System.in);

    /**
     * Entry point.
     */
    public static void main(String[] args) {

        while (in.hasNextInt()) {
            int n = in.nextInt();
            if (n == 0)
                break;

            int[][] m = readMatrix(n);

            int badRows = numBadRows(m);
            int badCols = badCols(m);

            if (badRows == 0 && badCols == 0)
                System.out.println("OK");
            else if (badRows == 1 && badCols == 1) {
                String fmt = "Change bit (%d,%d)\n";
                System.out.format(fmt, firstBadRow(m), firstBadCol(m));
            } else
                System.out.println("Corrupt");
        }

        in.close();
    }

    /**
     * Reads an NxN matrix from stdin.
     */
    private static int[][] readMatrix(int n) {
        int[][] res = new int[n][n];

        for (int r = 0; r < n; r++)
            for (int c = 0; c < n; c++)
                res[r][c] = in.nextInt();

        return res;
    }

    // ------------------------------------------------------------------------
    // Rows
    // ------------------------------------------------------------------------

    /**
     * Returns true if the row is bad.
     */
    static boolean isBadRow(int[][] m, int r) {
        int sum = 0;
        for (int c = 0; c < m.length; c++)
            sum ^= m[r][c];
        return sum == 1;
    }

    /**
     * Returns the first bad row, numbered from 1.
     */
    static int firstBadRow(int[][] m) {
        for (int r = 0; r < m.length; r++)
            if (isBadRow(m, r))
                return r + 1;

        return -1;
    }

    /**
     * Returns the number of bad rows, or 2 if it is >= 2.
     */
    static int numBadRows(int[][] m) {
        int badRows = 0;

        for (int r = 0; r < m.length; r++) {
            if (isBadRow(m, r))
                badRows++;

            if (badRows == 2)
                break;
        }

        return badRows;
    }

    // ------------------------------------------------------------------------
    // Columns
    // ------------------------------------------------------------------------

    /**
     * Returns the first bad column, numbered from 1.
     */
    static int firstBadCol(int[][] m) {
        for (int c = 0; c < m.length; c++)
            if (isBadCol(m, c))
                return c + 1;

        return -1;
    }

    /**
     * Returns true if the column is bad.
     */
    static boolean isBadCol(int[][] m, int c) {
        int sum = 0;
        for (int r = 0; r < m.length; r++)
            sum ^= m[r][c];

        return sum == 1;
    }

    /**
     * Returns the number of bad columns, or 2 if it is >= 2.
     */
    static int badCols(int[][] m) {
        int badCols = 0;

        for (int c = 0; c < m.length; c++) {
            if (isBadCol(m, c))
                badCols++;

            if (badCols == 2)
                break;
        }

        return badCols;
    }
}

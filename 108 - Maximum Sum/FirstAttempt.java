/*
 * 108 - Maximum Sum
 */

import java.util.Scanner;

public class FirstAttempt {

    static Scanner in = new Scanner(System.in);
    static int[][][][] cache;
    static int[][] arr;

    /**
     * Handles each case? Actually it seems like there's only one.
     */
    public static void main(String[] args) {
        while (in.hasNext()) {
            readArray();
            maxRectSum();
        }
    }

    /**
     * Reads a 2D array from stdin. Initializes cache.
     */
    private static int[][] readArray() {
        int n = in.nextInt();
        arr = new int[n][n];
        cache = new int[n][n][n][n];

        for (int r = 0; r < n; r++)
            for (int c = 0; c < n; c++)
                arr[r][c] = in.nextInt();

        return arr;
    }

    // ------------------------------------------------------------------

    /**
     * Brute force didn't work. Trying using cached rows.
     */
    private static void maxRectSum() {
        int n = arr.length;
        int max = Integer.MIN_VALUE;

        for (int r1 = 0; r1 < n; r1++)
            for (int c1 = 0; c1 < n; c1++)
                for (int r2 = r1; r2 < n; r2++)
                    for (int c2 = c1; c2 < n; c2++) {
                        int sum = sum(arr, r1, c1, r2, c2);
                        if (max < sum)
                            max = sum;
                    }
        System.out.println(max);
    }

    /**
     * Returns the sum of array values over the rectangle anchored at (r1,c2)
     * and (r2,c2).
     */
    private static int sum(int[][] a, int r1, int c1, int r2, int c2) {
        int sum;

        // sum = next smallest rect, diagonally...
        if (r2 > 0 && c2 > 0)
            sum = cache[r1][c1][r2 - 1][c2 - 1];
        else
            sum = 0;

        // plus the bottom row...
        for (int c = c1; c <= c2; c++)
            sum += arr[r2][c];

        // plus the right column...
        for (int r = r1; r <= r2; r++)
            sum += arr[r][c2];

        // minus the bottom-right corner (counted twice)
        sum -= arr[r2][c2];

        cache[r1][c1][r2][c2] = sum;
        return sum;
    }
}

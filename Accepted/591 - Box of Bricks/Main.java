/*
 * 591 - Box of Bricks
 * 
 * The minimum number is half of the sum of deviations from the average height.
 */

import java.util.Scanner;

public class Main {

    static Scanner in = new Scanner(System.in);

    /**
     * Sets up each test case.
     */
    public static void main(String[] args) {
        String fmt = "Set #%d\nThe minimum number of moves is %d.\n\n";

        for (int i = 0;; i++) {
            int n = in.nextInt();
            if (n == 0)
                return;

            System.out.format(fmt, i + 1, minMoves(n));
        }
    }

    /**
     * Reads n blocks from stdin and returns the minimum number of moves needed
     * to level them.
     */
    private static int minMoves(int n) {
        int[] heights = new int[n];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            heights[i] = in.nextInt();
            sum += heights[i];
        }

        int avg = sum / n;

        int oop = 0;
        for (int i = 0; i < n; i++)
            if (heights[i] > avg)
                oop += heights[i] - avg;

        return oop;
    }

}

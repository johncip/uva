/*
 * 10079 - Pizza Cutting
 * 
 * Trying a few cases, we see that the maximum number of slices is related to the
 * triangular numbers. Need long ints to store some of the outputs.
 * 
 */

import java.util.Scanner;

public class Main {

    /**
     * Entry point. For each cut number, return the maximum number of pieces.
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        for (int i = in.nextInt(); i >= 0; i = in.nextInt()) {
            System.out.println(handle(i));
        }

        in.close();
    }

    /**
     * Returns the (n + 1)th triangular number, plus one.
     */
    private static long handle(long n) {
        return 1 + n * (n + 1) / 2;
    }

}

/*
 * 10041 - Vito's Family
 * 
 * Print the sum of distances from the median.
 * 
 * Problem is poorly worded -- Vito cannot live at any address, only an existing house.
 */

import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);

    /**
     * Entry point. Prints sum(absolute deviation) for each test case.
     */
    public static void main(String[] args) {
        for (int t = 0, n = in.nextInt(); t < n; t++) {
            Integer[] rels = readInts(in.nextInt());
            Util.sort(rels);

            System.out.println(sumAbsDeviation(rels));
        }

        in.close();
    }

    /**
     * Returns the sum of the absolute deviation for each element.
     */
    private static int sumAbsDeviation(Integer[] arr) {
        int sum = 0;
        int median = arr[arr.length / 2];

        for (int i = 0; i < arr.length; i++)
            sum += Math.abs(arr[i] - median);

        return sum;
    }

    /**
     * Returns an array of n ints read from stdin.
     */
    private static Integer[] readInts(int n) {
        Integer res[] = new Integer[n];

        for (int i = 0; i < n; i++)
            res[i] = in.nextInt();

        return res;
    }

}
/*
 * 10327 - Flip Sort
 * 
 * Use insertion sort and count the swaps.
 */

import java.util.Scanner;

public class Main {

    static Scanner in = new Scanner(System.in);
    static int flips;

    /**
     * Entry point.
     */
    public static void main(String[] args) {

        while (in.hasNextInt()) {
            int n = in.nextInt();
            Integer[] arr = new Integer[n];

            for (int i = 0; i < n; i++)
                arr[i] = in.nextInt();

            flips = 0;
            sort(arr);
            System.out.println("Minimum exchange operations : " + flips);
        }
    }

    /**
     * Insertion sort.
     */
    @SuppressWarnings("rawtypes")
    public static void sort(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++)
            for (int j = i; j > 0 && less(arr[j], arr[j - 1]); j -= 1)
                swap(arr, j, j - 1);
    }

    /**
     * Returns true if a < b.
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    /**
     * Swaps values at two array indices. Increments the flip count.
     */
    @SuppressWarnings("rawtypes")
    public static void swap(Comparable[] A, int i, int j) {
        Comparable tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;

        flips++;
    }
}
/*
 * 10107 - What is the Median?
 * 
 * For a sorted array of length n, median is
 *   A[n/2],                n is odd
 *   avg(A[n/2-1], A[n/2]), n is even
 *   
 * Have to resort using an algorithm that is good on sorted data (like
 * insertion sort).
 *
 * Sorted data structures will probably do better (pair of heaps? BST?)
 * but sorting is fast enough to pass the judge. (At least with insertion
 * sort, which has good performance on mostly sorted data).
 * 
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int[] nums = new int[10000];

        for (int n = 0; in.hasNextInt();) {
            nums[n++] = in.nextInt();
            sb.append(median(nums, n));
            sb.append('\n');
        }

        System.out.print(sb);
        in.close();
    }

    /**
     * Returns the floor of the median of the first n elements of an array.
     * Sorts the first n elements.
     */
    static int median(int[] arr, int n) {
        sort(arr, n);
        if (n % 2 == 1)
            return arr[n / 2];
        else {
            int a = arr[n / 2 - 1];
            int b = arr[n / 2];
            return a + (b - a) / 2;
        }
    }

    /**
     * Insertion sort first n elements of an array.
     */
    static void sort(int[] arr, int n) {
        for (int i = 0; i < n; i++)
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j -= 1)
                swap(arr, j, j - 1);
    }

    /**
     * Swaps values at two array indices.
     */
    static void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}

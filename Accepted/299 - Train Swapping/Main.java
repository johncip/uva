/*
 * 299 - Train Swapping
 * 
 * Train swapping is the same as insertion sort.
 */

import java.util.Scanner;

public class Main {

    /**
     * Entry point. Prints minimum swaps for each test case.
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        for (int n = in.nextInt(), i = 0; i < n; i++)
            System.out.format("Optimal train swapping takes %d swaps.\n",
                    sort(readTrain(in)));
    }

    /**
     * Reads a single "train" of integers from stdin.
     */
    private static int[] readTrain(Scanner in) {
        int l = in.nextInt();
        int[] train = new int[l];
        for (int j = 0; j < l; j++)
            train[j] = in.nextInt();

        return train;
    }

    /**
     * Insertion sort. Returns number of swaps.
     */
    public static int sort(int[] arr) {
        int swaps = 0;

        for (int i = 0; i < arr.length; i++)
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j -= 1) {
                swap(arr, j, j - 1);
                swaps++;
            }

        return swaps;
    }

    /**
     * Swaps array values at the given indices.
     */
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
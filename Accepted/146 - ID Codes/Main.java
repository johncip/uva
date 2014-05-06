/*
 * 146 - ID Codes
 * 
 * Consider the string as L+R: L is sorted and won't change, R is in reverse
 * order except possibly for its leftmost char, and will change.
 * 
 * Thus for a one-character string, L is empty and R is length one.
 *
 * Changing R means (1) swapping its leftmost char for the next largest one
 * and (2) reversing everything that follows (after the swap it will still
 * be in non-increasing order).
 * 
 * If R's leftmost char is its largest (also implying that L is empty), then
 * there is no next permutation. 
 * 
 */

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /**
     * Entry point.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream out = new BufferedOutputStream(System.out);
        StringBuilder res = new StringBuilder();

        String line;
        while (!(line = in.readLine().trim()).equals("#")) {
            char[] code = line.toCharArray();

            if (next(code))
                res.append(code);
            else
                res.append("No Successor");

            res.append('\n');
        }

        out.write(res.toString().getBytes());

        in.close();
        out.close();
    }

    /**
     * Modifies the array to contain the lexicographically next permutation of
     * its characters, if one exists.
     * 
     * Returns true if the array was modified.
     */
    static boolean next(char[] arr) {
        // i is the first character of the subarray we intend to change
        // everything following it is in non-increasing order
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] >= arr[i + 1])
                continue;
            else {
                int j = larger(arr, arr[i]);
                swap(arr, i, j);
                reverse(arr, i + 1);
                return true;
            }
        }

        return false;
    }

    /**
     * Returns the first character seen that is larger than a given value,
     * searching from the right.
     */
    private static int larger(char[] arr, char val) {
        int j = arr.length - 1;
        while (arr[j] <= val)
            j--;
        return j;
    }

    /**
     * Reverses characters in array from lo to the end of the array.
     */
    static void reverse(char[] arr, int lo) {
        for (int hi = arr.length - 1; lo < hi; lo++, hi--)
            swap(arr, lo, hi);
    }

    /**
     * Swaps values at two array indices.
     */
    public static void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}

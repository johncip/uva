/*
 * 11385 - Da Vinci Code
 * 
 * Generate fibonacci sequence use binary search to implement the
 * inverse fib() function.
 * 
 * Stop when either the integer sequence runs out or the ciphertext runs out,
 * as they are not necessary the same length.
 * 
 * Don't insert spaces, just initialize the output to be all spaces and
 * overwrite the spaces with uppercase letters where necessary. Not having
 * trailing spaces means the output array has to be initialized with the
 * exact length (largest inverse fibonacci number seen).
 * 
 * Library imports are not allowed.
 * 
 */

import java.util.Scanner;

public class Main {

    static int[] fibs = Util.fibs2(46);

    /**
     * Entry point. For each set of Fibonacci numbers and ciphertext, produce
     * the plaintext by rearranging the letters.
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        for (int c = 0, cases = in.nextInt(); c < cases; c++) {
            int[] nums = readArray(in);
            String ciph = clean(in.nextLine());

            System.out.println(decipher(ciph, nums));
        }

        in.close();
    }

    /**
     * Reads an array specified as <length> <nums...>.
     */
    private static int[] readArray(Scanner in) {
        int[] nums = new int[in.nextInt()];
        for (int i = 0; i < nums.length; i++)
            nums[i] = in.nextInt();
        in.nextLine(); // flush
        return nums;
    }

    /**
     * Returns only the uppercase letters in the input String.
     */
    static String clean(String line) {
        return line.replaceAll("[^A-Z]", "");
    }

    /**
     * Rearranges the letters of the input string according to the result of
     * applying the inverse Fibonacci function to the array.
     */
    static String decipher(String line, int[] nums) {
        // map nums values to inverse fib
        for (int i = 0; i < nums.length; i++)
            nums[i] = Util.binSearch(nums[i], fibs);
        
        // create sorted copy & determine largest position
        int[] sorted = Util.sortedCopy(nums);
        int len = sorted[sorted.length - 1] - 1;

        // initialize output array
        char[] output = new char[len];
        for (int i = 0; i < len; i++)
            output[i] = ' ';
        
            // create output string without spaces
        for (int i = 0; i < nums.length && i < line.length(); i++)
            output[nums[i] - 2] = line.charAt(i);

        return new String(output);
    }

    /**
     * Inserts a space into the character array at index i.
     */
    static void insertSpace(char[] arr, int i) {
        System.arraycopy(arr, i, arr, i + 1, arr.length - 1 - i);
        arr[i] = ' ';
    }

}

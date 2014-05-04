/*
 * 10018 - Reverse and Add
 */

import java.util.Scanner;

public class Main {

    /**
     * Entry point, handles each test case.
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        for (int i = 0, n = in.nextInt(); i < n; i++)
            handleCase(in.nextInt());

        in.close();
    }

    /**
     * Adds a number to its reverse. If the result is palindromic, stop,
     * otherwise repeat with the sum.
     */
    private static void handleCase(long x) {
        int trials = 0;
        
        do {
            x += reverse(x);
            trials++;
        } while (!palindrome(x));

        System.out.format("%d %d\n", trials, x);
    }

    /**
     * Returns a number with the digits reversed.
     */
    static long reverse(long x) {
        long rev = 0;

        while (true) {
            rev += x % 10;
            x /= 10;
            if (x == 0)
                break;
            rev *= 10;
        }

        return rev;
    }

    /**
     * Returns true if x is a palindromic number.
     */
    static boolean palindrome(long x) {
        return palindrome(String.valueOf(x));
    }

    /**
     * Returns true if a string is palindromic.
     */
    static boolean palindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right)
            if (s.charAt(left++) != s.charAt(right--))
                return false;

        return true;
    }

}

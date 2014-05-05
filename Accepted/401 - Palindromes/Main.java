/*
 * 401 - Palindromes
 * 
 * A string is a mirror string if it is equal to the same string with
 * characters reversed and substituted their "mirror images" as the
 * problem defines them.
 * 
 * A string is a mirrored palindrome if it meets the above criteria
 * and is also a palindrome.
 * 
 * Note that if a palindrome consists of only characters which have vertical
 * symmetry, it is a mirrored palindrome, but the converse isn't true.
 */

import java.util.Scanner;

public class Main {

    /**
     * Entry point. Determines whether each input string is a palindrome, a
     * mirrored string, both, or neither.
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder res = new StringBuilder();

        while (in.hasNextLine()) {
            String line = in.nextLine().trim();
            res.append(line);

            boolean pal = isPalindrome(line);
            boolean mir = isMirrored(line);

            if (pal & mir)
                res.append(" -- is a mirrored palindrome.");
            else if (pal)
                res.append(" -- is a regular palindrome.");
            else if (mir)
                res.append(" -- is a mirrored string.");
            else
                res.append(" -- is not a palindrome.");

            res.append("\n\n");
        }

        System.out.print(res);
        in.close();

    }

    /**
     * Returns true if a string is a palindrome.
     */
    static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right)
            if (s.charAt(left++) != s.charAt(right--))
                return false;

        return true;
    }

    /**
     * Returns true if a string is equal to the mirror image of itself.
     */
    static boolean isMirrored(String s) {
        return mirrorable(s) && s.equals(mirror(s));
    }

    /**
     * Returns true if a string consists of only mirrorable characters.
     */
    static boolean mirrorable(String s) {
        String valid = "AEHIJLMOSTUVWXYZ12358";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (valid.indexOf(c) == -1)
                return false;
        }
        return true;
    }

    // -----------------------------------------------------------------------
    // String mirroring
    // -----------------------------------------------------------------------

    /**
     * Returns the mirror image of the string. String must have a valid mirror
     * image.
     */
    static String mirror(String s) {
        assert (mirrorable(s));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++)
            sb.append(mirror(s.charAt(i)));

        return sb.reverse().toString();
    }

    /**
     * Returns the mirror image of a character, if it exists and is a different
     * character.
     */
    private static char mirror(char c) {
        // @formatter:off
        switch (c) {
            case 'E': return '3';
            case 'J': return 'L';
            case 'L': return 'J';
            case 'S': return '2';
            case 'Z': return '5';
            case '2': return 'S';
            case '3': return 'E';
            case '5': return 'Z';
        } // @formatter:on

        return c;
    }

}
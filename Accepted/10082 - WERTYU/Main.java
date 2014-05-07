/*
 * 10082 - WERTYU
 * 
 * We know that the leftmost characters don't appear in the input, so there's
 * no looping or special cases. Linear search for the value to map to is enough
 * to pass the judge.
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String line = in.nextLine();
            System.out.println(shift(line));
        }

        in.close();
    }

    /**
     * Shifts each character in a string one position to the left on a QWERTY
     * keyboard.
     */
    private static char[] shift(String text) {
        char[] shifted = text.toCharArray();

        for (int i = 0; i < shifted.length; i++)
            shifted[i] = shift(shifted[i]);

        return shifted;
    }

    /**
     * Shifts a character one position to the left on a QWERTY keyboard.
     */
    private static char shift(char c) {
        assert "`QAZ".indexOf(c) == -1;

        if (c == ' ')
            return c;

        String keys = "`1234567890-=QWERTYUIOP[]\\ASDFGHJKL;'ZXCVBNM,./";
        int idx = keys.indexOf(c);
        assert idx != -1;

        return keys.charAt(idx - 1);
    }
}

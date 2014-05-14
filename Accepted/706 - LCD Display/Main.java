/*
 * 706 - LCD Display
 * 
 * Straightforward, although maybe a simpler solution exists than what I've
 * used. Python's list comprehensions and join() come to mind. 
 */

import java.util.Scanner;

public class Main {

    static StringBuilder res = new StringBuilder();
    
    // "font" definitions
    static String top = "- -- -----";
    static String mid = "  ----- --";
    static String bottom = "- -- -- --";
    static String upleft = "|   ||| ||";
    static String upright = "|||||  |||";
    static String lowleft = "| |   | | ";
    static String lowright = "|| |||||||";

    /**
     * For each input pair, prints n "LCD-style" at the given size.
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {
            int sz = in.nextInt();
            String n = in.next();

            if (sz == 0)
                break;

            display(n, sz);
            res.append('\n');
        }

        System.out.print(res);
        in.close();
    }

    /**
     * Returns the LCD-style ASCII art representation of n for a given size.
     */
    static void display(String n, int sz) {
        horizontal(n, sz, top);

        for (int i = 0; i < sz; i++)
            vertical(n, sz, upleft, upright);

        horizontal(n, sz, mid);

        for (int i = 0; i < sz; i++)
            vertical(n, sz, lowleft, lowright);

        horizontal(n, sz, bottom);
    }

    /**
     * Appends vertical lines to the global StringBuilder.
     */
    static void vertical(String n, int sz, String onLeft, String onRight) {
        for (int i = 0; i < n.length(); i++) {
            int c = n.charAt(i) - '0';

            res.append(onLeft.charAt(c));
            for (int j = 0; j < sz; j++)
                res.append(' ');
            res.append(onRight.charAt(c));

            if (i < n.length() - 1)
                res.append(' ');
        }
        res.append('\n');
    }

    /**
     * Appends horizontal lines to the global StringBuilder.
     */
    static void horizontal(String n, int sz, String on) {
        for (int i = 0; i < n.length(); i++) {
            int c = n.charAt(i) - '0';

            res.append(' ');
            for (int j = 0; j < sz; j++)
                res.append(on.charAt(c));
            res.append(' ');

            if (i < n.length() - 1)
                res.append(' ');
        }
        res.append('\n');
    }

}

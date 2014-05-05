/*
 * 445 - Marvelous Mazes
 * 
 * Similar to run-length encoding except multi-digit character runs need to be
 * added rather than treated as a number.
 */

import java.util.Scanner;
import static java.lang.Character.isDigit;

public class Main {

    static String line; // last read line
    static int i; // index to line

    /**
     * Entry point. For each line, prints the corresponding maze piece.
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder res = new StringBuilder();

        while (in.hasNextLine()) {
            line = in.nextLine().trim();

            if (!line.equals(""))
                res.append(parseMaze());

            res.append('\n');
        }

        System.out.print(res);
        in.close();
    }

    /**
     * Returns a decoded maze segment parsed from the last line scanned.
     */
    static String parseMaze() {
        StringBuilder res = new StringBuilder();
        int n = 0;

        i = 0; // reset for new parse

        while (i < line.length()) {
            char c = line.charAt(i);

            if (isDigit(c))
                n = readNum();
            else if (c == 'b')
                appendMany(res, ' ', n);
            else if (c == '!')
                res.append('\n');
            else
                appendMany(res, c, n);

            i++;
        }

        return res.toString();
    }

    /**
     * Append a character 'n' times to a the given StringBuilder.
     */
    private static void appendMany(StringBuilder res, char c, int times) {
        for (int i = 0; i < times; i++)
            res.append(c);
    }

    /**
     * Reads digits from the current line and returns their sum.
     */
    private static int readNum() {
        int sum = 0;

        do
            sum += line.charAt(i++) - '0';
        while (isDigit(line.charAt(i)));

        i--; // had to look ahead
        return sum;
    }

}
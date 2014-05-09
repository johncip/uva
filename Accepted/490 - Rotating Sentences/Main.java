/*
 * 490 - Rotating Sentences
 * 
 * Read the lines into a 2D array and output the characters in rotated order --
 * By columns, then rows, with rows in decreasing order.
 * 
 * We need to keep track of the bounds while reading.
 * 
 */

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(
            System.in));
    static BufferedOutputStream out = new BufferedOutputStream(System.out);
    static StringBuilder res = new StringBuilder();
    static char[][] data = new char[100][100];

    /**
     * Entry point.
     */
    public static void main(String[] args) throws IOException {
        int maxRow = 0;
        int maxCol = 0;

        String line;
        while ((line = in.readLine()) != null) {
            if (line.length() > maxCol)
                maxCol = line.length();

            System.arraycopy(line.toCharArray(), 0, data[maxRow++], 0,
                    line.length());
        }

        appendOutput(maxRow - 1, maxCol);

        out.write(res.toString().getBytes());
        in.close();
        out.close();
    }

    /**
     * Prints the character grid rotated 90 degrees.
     */
    private static void appendOutput(int maxRow, int maxCol) {

        for (int col = 0; col < maxCol; col++) {
            for (int row = maxRow; row >= 0; row--) {
                char ch = data[row][col];
                if (ch == '\0')
                    ch = ' ';

                res.append(ch);
            }

            res.append("\n");
        }
    }

}

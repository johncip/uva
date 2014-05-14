/*
 * 572 - Oil Deposits
 * 
 * This is connected-component labeling, for cells which are "8-connected."
 * Using DFS.
 * 
 * An outer loop iterates over each cell in the grid. When an unlabeled cell is
 * found, the label (which is also the number of disconnected oil deposits) is
 * incremented and written into the cell.
 * 
 * Labeling is recursive: writing a label to a cell also means writing it to
 * each of its connected neighbors, and neighbors' neighbors, etc. Thus, the
 * next unlabeled cell seen by the outer loop must be part of a unique oil
 * deposit.
 */

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    final static int FREE = -1;

    static BufferedReader in = new BufferedReader(new InputStreamReader(
            System.in));
    static BufferedOutputStream out = new BufferedOutputStream(System.out);
    static StringBuilder res = new StringBuilder();

    static int blobs;

    /**
     * Entry point. For each oil field description, prints the number of
     * connected components.
     */
    public static void main(String[] args) throws IOException {
        while (true) {
            String line = in.readLine();
            int m = Integer.valueOf(line.split(" ")[0]);
            int n = Integer.valueOf(line.split(" ")[1]);

            if (m == 0)
                break;

            blobs = 0;
            int[][] field = readField(m, n);
            labelBlobs(field);

            res.append(blobs);
            res.append('\n');
        }

        out.write(res.toString().getBytes());
        in.close();
        out.close();
    }

    /**
     * Reads an "oil field" from stdin and sets the cell to its index (counted
     * from 1) if it contains oil, leaves it as zero otherwise.
     */
    static int[][] readField(int m, int n) throws IOException {
        String line;
        int[][] field = new int[m][n];

        // read in
        for (int row = 0; row < m; row++) {
            line = in.readLine();
            for (int col = 0; col < n; col++) {
                char c = line.charAt(col);
                if (c == '@')
                    field[row][col] = FREE;
            }
        }

        return field;
    }

    /**
     * Replaces each label in the field with its smallest neighbor.
     */
    static void labelBlobs(int[][] field) {
        for (int r = 0; r < field.length; r++)
            for (int c = 0; c < field[0].length; c++)
                if (field[r][c] == FREE)
                    labelCell(r, c, ++blobs, field);
    }

    /**
     * Labels a cell, then recursively visits and labels any unlabeled connected
     * cells.
     */
    static void labelCell(int row, int col, int label, int[][] field) {
        field[row][col] = label;

        for (int r = row - 1; r <= row + 1; r++) {
            if (r < 0 || r >= field.length)
                continue;
            for (int c = col - 1; c <= col + 1; c++) {
                if (c < 0 || c >= field[0].length)
                    continue;

                if (field[r][c] == FREE)
                    labelCell(r, c, label, field);
            }
        }
    }
}

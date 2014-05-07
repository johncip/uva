/*
 * 10189 - Minesweeper
 * 
 * Store the "game state" as a grid, updating adjacent cells when
 * a bomb is placed.
 * 
 * The number of adjacent bombs is always in the single digits, so we can use
 * a char grid if we want (else we need a sentinel int for bombs and special
 * print logic).
 */

import java.util.Scanner;

public class Main {

    static Scanner in = new Scanner(System.in);

    /**
     * Handles each test case.
     */
    public static void main(String[] args) {
        String delim = "";

        for (int x = 1; true; x++) {
            int n = in.nextInt();
            int m = in.nextInt();

            in.nextLine(); // flush

            if (n == 0)
                return;
            else
                System.out.format("%sField #%d:\n%s\n", delim, x,
                        loadField(n, m));

            delim = "\n";
        }

    }

    /**
     * Returns a minefield read from stdin with given dimensions.
     */
    private static Field loadField(int rows, int cols) {
        Field field = new Field(rows, cols);

        for (int r = 0; r < rows; r++) {
            String line = in.nextLine();
            for (int c = 0; c < cols; c++)
                if (line.charAt(c) == '*')
                    field.addMine(r, c);
        }

        return field;
    }

}

/**
 * A grid of zones. A zone is either a mine or the number of adjacent mines.
 */
class Field {
    int rows;
    int cols;
    char[][] zones;

    Field(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.zones = new char[rows][cols];

        for (int r = 0; r < rows; r++)
            for (int c = 0; c < cols; c++)
                zones[r][c] = '0';
    }

    /**
     * Adds a mine to the field. Increments the counts of zones surrounding it,
     * except those which are also mines.
     */
    void addMine(int row, int col) {
        zones[row][col] = '*';

        for (int r = row - 1; r < row + 2; r++)
            for (int c = col - 1; c < col + 2; c++)
                if (!inside(r, c))
                    continue;
                else if (zones[r][c] == '*')
                    continue;
                else
                    zones[r][c] += 1;
    }

    /**
     * Returns true if the row-col pair is inside the field.
     */
    private boolean inside(int r, int c) {
        return 0 <= r && r < rows && 0 <= c && c < cols;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                sb.append(zones[r][c]);
            }
            sb.append('\n');
        }

        return sb.toString().trim();
    }
}

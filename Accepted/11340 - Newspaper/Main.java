/*
 * 11340 - Newspaper
 * 
 * Use a Map.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(
            System.in));

    /**
     * Entry point. For each test case, prints the cost of the article.
     */
    public static void main(String[] args) throws IOException {
        String fmt = "%d.%02d$\n";

        for (int i = 0, n = readInt(); i < n; i++) {
            int cost = articleCost();
            System.out.format(fmt, cost / 100, cost % 100);
        }
    }

    /**
     * Reads a cost table and article from stdin and returns the cost of the
     * article.
     */
    static int articleCost() throws IOException {
        Map<Character, Integer> costs = new HashMap<>();

        for (int i = 0, n = readInt(); i < n; i++) {
            String line = in.readLine();
            char ch = line.charAt(0);
            int cost = Integer.valueOf(line.substring(2));
            costs.put(ch, cost);
        }

        int sum = 0;
        for (int i = 0, n = readInt(); i < n; i++)
            sum += lineCost(in.readLine(), costs);

        return sum;
    }

    /**
     * Returns the cost of a line.
     */
    private static int lineCost(String line, Map<Character, Integer> costs) {
        int sum = 0;

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (costs.containsKey(c))
                sum += costs.get(c);
        }

        return sum;
    }

    /**
     * Reads an int (on its own line) from stdin.
     */
    static Integer readInt() throws IOException {
        return Integer.valueOf(in.readLine());
    }

}

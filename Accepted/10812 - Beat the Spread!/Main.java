/*
 * 10812 - Beat the Spread!
 * 
 * A linear system (assume x >= y):
 *   sum = x + y
 *   diff = x - y
 * 
 * So:
 *   sum + diff = 2x
 *   sum - diff = 2y
 * 
 * x and y are nonnegative ==> so sum > diff.
 * 2x can't be odd ==> sum + diff is even.
 * 
 */

import java.util.Scanner;

public class Main {

    static StringBuilder res = new StringBuilder();

    /**
     * Entry point. For each input pair (sum, diff), output x and y.
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        for (int i = 0, n = in.nextInt(); i < n; i++) {
            int sum = in.nextInt();
            int diff = in.nextInt();
            appendScores(sum, diff);
        }

        System.out.print(res);
        in.close();

    }

    /**
     * Appends x and y to the result, if they exist.
     */
    static void appendScores(int sum, int diff) {
        if (diff > sum || (diff + sum) % 2 == 1)
            res.append("impossible\n");
        else {
            res.append((sum + diff) / 2);
            res.append(" ");
            res.append((sum - diff) / 2);
            res.append("\n");
        }
    }
}
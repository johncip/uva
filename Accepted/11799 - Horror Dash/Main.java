/*
 * 11799 - Horror Dash
 */

import java.util.Scanner;

public class Main {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            int max = readMax(in.nextInt());
            System.out.format("Case %d: %d\n", i + 1, max);
        }
    }

    /**
     * Reads "num" runner speeds from stdin and retains the max.
     */
    static int readMax(int num) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < num; i++) {
            int cur = in.nextInt();
            if (max < cur)
                max = cur;
        }

        return max;
    }
}

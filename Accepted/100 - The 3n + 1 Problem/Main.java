/**
 * 100 - The 3n + 1 problem
 * 
 * For any two numbers i and j you are to determine
 * the maximum cycle length over all numbers between i and j.
 * 
 * Accepted on 2014-04-28
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {
            int i = in.nextInt();
            int j = in.nextInt();

            int first = Math.min(i, j);
            int last = Math.max(i, j);

            // for each i, j, compute max cycle length
            int max = 0;
            for (int n = first; n <= last; n++) {
                int length = cycleLength(n);
                if (length > max)
                    max = length;
            }

            System.out.format("%d %d %d\n", i, j, max);
        }

        in.close();
    }

    /**
     * Counts the cycle length for the 3n+1 algorithm for a given n.
     */
    public static int cycleLength(int n) {
        int count = 1;

        while (n != 1) {
            if (n % 2 == 1)
                n = 3 * n + 1;
            else
                n /= 2;
            count++;
        }

        return count;
    }

}

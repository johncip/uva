/*
 * 10038 - Jolly Jumpers
 * 
 * Here we store the gap's presence or absence in a boolean array, being
 * careful not to exceed its bounds.
 * 
 * We could also store the actual gaps and sort them; this way is linear.
 */

import java.util.Scanner;

public class Main {

    /**
     * Reads in input and determines if a sequence is a jolly jumper.
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            int n = in.nextInt();
            if (n == 0)
                continue;

            boolean[] gaps = new boolean[n];

            for (int i = 1, prev = in.nextInt(); i < n; i++) {
                int cur = in.nextInt();
                int diff = Math.abs(cur - prev);

                if (0 < diff && diff < n)
                    gaps[diff] = true;

                prev = cur;
            }

            System.out.println(jolly(gaps) ? "Jolly" : "Not jolly");
        }

        in.close();
    }

    /**
     * Returns true if true appears in all array indices from 1 to n-1.
     */
    static boolean jolly(boolean[] arr) {
        for (int i = 1; i < arr.length; i++)
            if (!arr[i])
                return false;

        return true;
    }
}

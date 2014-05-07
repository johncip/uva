/*
 * 10050 - Hartals
 * 
 * If there were only a couple of parties, it'd just be a matter of not double-
 * counting the weekends and days where their strikes overlap (and thus an easy
 * easy closed form), but with a lot of parties it seems like a combinations to
 * check, and the simulation is straightforward.
 * 
 * (Didn't realize we could use the Collections API; going to include some
 * higher-level stuff from here on out.)
 * 
 * Using a TreeSet so that we can break as early as possible.
 */

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


public class Main {

    /**
     * Entry point.
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder res = new StringBuilder();

        for (int i = 0, t = in.nextInt(); i < t; i++) {
            int n = in.nextInt();
            int p = in.nextInt();

            Set<Integer> hs = new TreeSet<>();
            for (int h = 0; h < p; h++)
                hs.add(in.nextInt());

            res.append(hartals(n, hs));
            res.append('\n');
        }

        System.out.println(res.toString().trim());
        in.close();
    }

    /**
     * Returns the number of "hartals" for a simulation over n days, given the
     * set of hartal-numbers.
     */
    private static int hartals(int n, Set<Integer> hs) {
        int strikes = 0;

        days: for (int d = 1; d <= n; d++) {
            if ((d + 1) % 7 == 0) // Friday
                continue;
            if (d % 7 == 0) // Saturday
                continue;

            for (int h : hs)
                if (d % h == 0) {
                    strikes++;
                    continue days;
                }
        }

        return strikes;
    }

}

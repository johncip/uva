/*
 * 264 - Count on Cantor
 * 
 * Given an input value N, print the Nth term in Cantor's enumeration.
 * 
 * We figure out what diagonal n is on, which gives us the fraction for the
 * first term of that diagonal (1/2, 3/1, 1/4, 5/1, etc.). Then, we adjust the
 * numerator and denominator based on the distance from the first term, as well
 * as the direction (up-right for odd diagonals, down-left for even).
 * 
 * The triangular number function (taken over the reals) has an inverse. We can
 * take the ceiling of that to learn the diagonal.
 */

import java.util.Scanner;

public class Main {

    /**
     * Entry point. For each input number n, prints the nth term in Cantor's
     * sequence.
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String fmt = "TERM %d IS %s\n";

        while (in.hasNextInt()) {
            int n = in.nextInt();
            System.out.format(fmt, n, cantorTerm(n));
        }

        in.close();
    }

    /**
     * Returns the nth term in Cantor's sequence.
     */
    static String cantorTerm(int n) {
        int inv = diagonal(n);
        int dist = distance(n);

        int den, num;

        if (inv % 2 == 0) {
            // even rows: numerators start small
            num = 1 + dist;
            den = inv - dist;
        } else {
            // odd rows: numerators start big
            num = inv - dist;
            den = 1 + dist;
        }

        return num + "/" + den;
    }

    /**
     * Returns which diagonal n is on.
     */
    static int diagonal(int n) {
        double it = (Math.sqrt(1 + 8 * n) - 1) / 2.0;

        return (int) Math.ceil(it);
    }

    /**
     * Returns the distance along the diagonal.
     */
    static int distance(int n) {
        int diag = diagonal(n);
        int first = 1 + triangular(diag - 1);

        return n - first;
    }

    /**
     * Returns the nth triangular number.
     */
    private static int triangular(int n) {
        return (n * (n + 1)) / 2;
    }

}

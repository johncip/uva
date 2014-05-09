/*
 * 10970 - Big Chocolate
 * 
 * It's always M * N - 1.
 */

import java.util.Scanner;

public class Main {

    /**
     * Entry point. For each M x N bar of chocolate, print the minimum number of
     * cuts to produce M * N squares.
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {
            int m = in.nextInt();
            int n = in.nextInt();

            int cuts = m * n - 1;
            System.out.println(cuts);
        }

        in.close();
    }

}

/*
 * 10300 - Ecological Premium
 */

import java.util.Scanner;

public class Main {

    static Scanner in = new Scanner(System.in);

    /**
     * Prints sum for each test case.
     */
    public static void main(String[] args) {
        for (int i = 0, n = in.nextInt(); i < n; i++)
            System.out.println(sumPremiums());
    }

    /**
     * Sums premiums for a single test case's farmers.
     */
    private static int sumPremiums() {
        int sum = 0;

        for (int f = in.nextInt(), i = 0; i < f; i++) {
            int area = in.nextInt();
            in.nextInt(); // skip animals to avoid FP math
            int eco = in.nextInt();

            sum += eco * area;
        }
        return sum;
    }
}

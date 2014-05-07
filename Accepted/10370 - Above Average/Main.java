/*
 * 10370 - Above Average
 * 
 * Take the average, count the ones above it. We could avoid division by n if
 * we were concerned about precision, but this is clearer and passes the judge.
 */

import java.util.Scanner;

public class Main {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        for (int i = 0, n = in.nextInt(); i < n; i++)
            System.out.format("%.3f%%\n", aboveAvg());
    }

    /**
     * Reads a set of integers from stdin and returns the percent above average.
     */
    private static double aboveAvg() {
        int n = in.nextInt();
        int[] grades = new int[n];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            grades[i] = in.nextInt();
            sum += grades[i];
        }

        double avg = (double) sum / n;
        int above = 0;

        for (int i = 0; i < n; i++)
            if (grades[i] > avg)
                above++;

        return (double) 100 * above / n;
    }

}

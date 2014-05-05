/*
 * 10346 - Peter's Smokes
 * 
 * Divide n by k repeatedly until n < k.
 * k is always > 1.
 * 
 * Have to remember to include the old butts.
 * 
 * There is probably a closed form but this passes the judge.
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {
            int n = in.nextInt();
            int k = in.nextInt();
            System.out.println(sumSmokes(n, k));
        }

        in.close();
    }

    static int sumSmokes(int n, int k) {
        if (k <= 1)
            throw new IllegalArgumentException();

        // think of n as the number of butts
        int sum = n;

        while (n >= k) {
            sum += n/k;
            n = (n / k) + (n % k);
        }

        return sum;
    }

}

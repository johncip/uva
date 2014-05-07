/*
 * 10346 - Peter's Smokes
 * 
 * Divide n by k repeatedly until n < k. Remember to include the butts from the
 * last round.
 * 
 * There's also a nice closed form solution, but I didn't come up with it so
 * I'm not including it here, but it's in the forums.
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
        int sum = n;

        while (n >= k) {
            sum += n/k;
            n = (n / k) + (n % k);
        }

        return sum;
    }

}

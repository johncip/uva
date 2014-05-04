/*
 * 382 - Perfection
 * 
 * Given a number, determine if it is perfect, abundant, or deficient.
 * Largest input number is 60000.
 */

import java.util.Scanner;

public class Main {

    static int[] primes = Primes.primes(6100); // so largest p > 60000

    /**
     * Entry point. For each number, prints whether it is abundant, deficient,
     * or perfect.
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("PERFECTION OUTPUT");

        for (int i = in.nextInt(); i != 0; i = in.nextInt())
            System.out.format("%5d  %s\n", i, type(i));

        System.out.println("END OF OUTPUT");
        in.close();
    }

    /**
     * Returns whether a number is abundant, deficient, or perfect.
     * 
     * Linear search with small speedup: only check below sqrt(n), and when
     * finding a divisor, add its counterpart.
     * 
     * Prime factorization is also an option if this isn't fast enough to pass
     * the judge.
     */
    static Is type(int n) {
        int sum = 1; // 1 is a divisor
        double sqrt = Math.sqrt(n);

        for (int i = 2; i < sqrt; i++)
            if (n % i == 0)
                sum += i + n / i;

        if (sum < n)
            return Is.DEFICIENT;
        else if (sum > n)
            return Is.ABUNDANT;
        else
            return Is.PERFECT;
    }
}

enum Is {
    ABUNDANT, DEFICIENT, PERFECT;
}
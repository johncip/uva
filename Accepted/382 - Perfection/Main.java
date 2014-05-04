/*
 * 382 - Perfection
 * 
 * Given a number, determine if it is perfect, abundant, or deficient. Largest
 * input number is 60000.
 * 
 * If we only check up to sqrt(n), we must be careful to treat 1 as a special
 * case (since its sqrt is 1 and we've already included it).
 * 
 * Note that the problem defines perfection differently than usual (sum of
 * proper divisors (which includes 1) is < n, as opposed to sum of all divisors
 * is < 2n).
 * 
 * To submit: include Util/Primes
 */

import java.util.Scanner;

public class Main {

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
     */
    static Is type(int n) {
        int sum = divisorSum(n);

        if (sum < n)
            return Is.DEFICIENT;
        else if (sum > n)
            return Is.ABUNDANT;
        else
            return Is.PERFECT;
    }

    /**
     * Returns the sum of n's divisors.
     * 
     * Linear search with small speedup: only check below sqrt(n), and when
     * finding a divisor, add n/i as well.
     */
    static int divisorSum(int n) {
        if (n == 1) // 1 is not a proper divisor
            return 0;
        
        int sum = 1; // 1 is a proper divisor
        double sqrt = Math.sqrt(n);

        for (int i = 2; i < sqrt; i++)
            if (n % i == 0)
                sum += i + n / i;

        if (sqrt == (int) sqrt)
            sum += sqrt; // only add sqrt once

        return sum;
    }
}

enum Is {
    ABUNDANT, DEFICIENT, PERFECT;
}
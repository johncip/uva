/*
 * 10783 - Odd Sum
 * 
 * Probably a simple closed form, but this suffices.
 */

import java.util.Scanner;

public class Main {

    
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        for (int i = 0, t = in.nextInt(); i < t; i++) {
            int res = oddSum(in.nextInt(), in.nextInt());
            System.out.format("Case %d: %d\n", i + 1, res);
        }
    }

    /**
     * Returns the sum of the odd integers between and including a and b.
     */
    private static int oddSum(int a, int b) {
        int sum = 0;
        
        if (a % 2 == 0)
            a++;
        
        for (int i = a; i <= b; i += 2)
                sum += i;

        return sum;
    }

}

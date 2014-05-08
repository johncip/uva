/*
 * 10469 - To Carry or not to Carry
 * 
 * The operation described is XOR. Using longs to simulate unsigned ints.
 */

import java.io.IOException;
import java.util.Scanner;

public class Main {

    /**
     * Entry point. For each input pair, print a ^ b.
     */
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLong())
            System.out.println(in.nextLong() ^ in.nextLong());

        in.close();
    }

}

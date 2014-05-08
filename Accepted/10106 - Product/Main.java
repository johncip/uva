/*
 * 10106 - Product
 * 
 * Use BigInteger.
 */

import java.util.Scanner;
import java.math.BigInteger;

public class Main {

    /**
     * Entry point.
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            BigInteger x = new BigInteger(in.nextLine());
            BigInteger y = new BigInteger(in.nextLine());
            System.out.println(x.multiply(y));
        }
        
        in.close();
    }
}

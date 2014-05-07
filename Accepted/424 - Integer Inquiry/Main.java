/*
 * 424 - Integer Inquiry
 * 
 * They allow java.math.BigInteger; may as well use it.
 */

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(
            System.in));
    static BufferedOutputStream out = new BufferedOutputStream(System.out);

    /**
     * Entry point. Sum of very large numbers.
     */
    public static void main(String[] args) throws NumberFormatException,
            IOException {
        BigInteger sum = BigInteger.valueOf(0);

        while (true) {
            String line = in.readLine();
            BigInteger n = new BigInteger(line);

            if (n.equals(BigInteger.ZERO))
                break;
            
            sum  = sum.add(n);
        }
        
        System.out.println(sum);
        
        in.close();
    }

}

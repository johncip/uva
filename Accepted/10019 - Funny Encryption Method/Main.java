/*
 * 10019 - Funny Encryption
 * 
 * Count the on bits. Note that this is the Hamming weight / population count,
 * and there are faster ways to do it, see
 * 
 * http://aggregate.ee.engr.uky.edu/MAGIC/
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(
            System.in));

    /**
     * Entry point.
     */
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(in.readLine());
        while (n-- > 0) {
            String line = in.readLine();
            int d = Integer.parseInt(line);
            int x = Integer.parseInt(line, 16);
            
            System.out.format("%d %d\n", onBits(d), onBits(x));
        }
        
        in.close();
    }
    
    /**
     * Returns the number of ones in the binary representation of n.
     */
    static int onBits(int n) {
        int res = 0;
        
        while (n > 0) {
            res += n % 2;
            n /= 2;
        }
        
        return res;        
    }

}

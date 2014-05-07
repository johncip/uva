/*
 * 374 - Big Mod
 * 
 * x = ab, with integers a and b, implies
 * x^n % m = (a^n % m)(b^n % m) % m
 * 
 * So we can do the multiplication by hand and take mod after each step.
 * 
 * However, it is faster (and necessary to pass the judge) to square the base
 * repeatedly instead. Since m < sqrt(MAX INT), we know this will not overflow.
 * 
 * (If p is odd then we should multiply once first to decrement it.)
 * 
 * We can probably use BigInteger.modPow() as well. The implementation uses
 * repeated squaring.
 */

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /**
     * Entry point. For each input set of b, p, m, outputs b^p % m.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream out = new BufferedOutputStream(System.out);
        StringBuilder res = new StringBuilder();

        while (true) {
            // skip blank lines and end when no more input
            String line = in.readLine();
            if (line == null)
                break;
            else if (line.equals(""))
                continue;

            int b = Integer.valueOf(line);
            int p = Integer.valueOf(in.readLine());
            int m = Integer.valueOf(in.readLine());

            res.append(modPow(b, p, m));
            res.append('\n');
        }

        out.write(res.toString().getBytes());

        out.close();
        in.close();
    }

    /**
     * Returns pow(b,p) mod m
     */
    static int modPow(int b, int p, int m) {
        b = b % m;
        int res = 1;

        while (p > 0) {
            if (p % 2 == 1)
                res = (res * b) % m;
            p /= 2;
            b = b * b % m;
        }
        return res;
    }

}

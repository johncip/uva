/*
 * 113 - Power of Cryptography
 * 
 * This first attempt was based on the idea that we could get away with
 * using mod_pow to only check as many of the right-most digits as would fit
 * into an int. My assumption was that this was enough to avoid most collisions
 * and you could be reasonably sure you'd found the root.
 * 
 * It's not, and the worst case is powers of 10, since you're only ever looking
 * at a bunch of zeroes.
 * 
 * Still, I like the code, so that's something.
 * 
 */

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class ModAttempt {

    static DataInputStream in = new DataInputStream(System.in);
    static StringBuilder res = new StringBuilder();
    static BufferedOutputStream out = new BufferedOutputStream(System.out);

    /**
     * Entry point.
     */
    @SuppressWarnings("deprecation")
    public static void main(String[] args) throws IOException {

        modRoot(1024, 2, 1000);

        while (true) {

            // read n or break
            String nline = in.readLine();
            if (nline == null || nline.equals(""))
                break;
            int n = Integer.valueOf(nline);

            // read p % 10^9
            String p = in.readLine();

            res.append(guessRoot(p, n, 6));
            res.append("\n");
        }

        out.write(res.toString().getBytes());
        out.flush();
    }

    /**
     * Guesses the root of the number in pline by checking the modRoot for
     * pline's righthand digits.
     * 
     * In practice this answer seems to match the real answer for arbitrary
     * values of p as long as 3 < digits < 7.
     */
    static int guessRoot(String p, int n, int digits) {
        int m = (int) Math.pow(10, digits);
        int len = p.length();

        if (len > digits)
            p = p.substring(len - (digits + 1), len);

        int pmod = Integer.valueOf(p);

        return modRoot(pmod, n, m);
    }

    /**
     * Finds the nth root of p (given p mod some power of ten)
     */
    static int modRoot(int modp, int n, int m) {
        modp = modp % m; // just in case

        for (int k = 0; k <= modp; k++) {
            int modpowres = modPow(k, n, m);
            if (modpowres == modp)
                return k;
        }
        return -1;
    }

    /**
     * Returns pow(a,b) mod m
     */
    static int modPow(int a, int b, int m) {
        int res = 1;

        for (int i = 0; i < b; i++)
            res = (res * a) % m;

        return res;

    }
}
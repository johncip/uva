/*
 * 113 - Power of Cryptography
 * 
 * Find the nth root of p, with the guarantee that the root will be an integer.
 * 
 * Most other solutions use floating point. This doesn't strike me as correct
 * right answer--what about numbers that aren't representable with a double
 * (e.g. 2^53 + 1)?
 * 
 * Here, we use bignums and do a binary search for the root. Search space is
 * between 0 and 2^31 - 1, but it's still fast enough to pass the judge.
 * 
 */

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.math.BigInteger;

public class Main {

    static DataInputStream in = new DataInputStream(System.in);
    static StringBuilder res = new StringBuilder();
    static BufferedOutputStream out = new BufferedOutputStream(System.out);

    /**
     * For each test case, prints the Nth root of P.
     */
    @SuppressWarnings("deprecation")
    public static void main(String[] args) throws IOException {

        while (true) {
            // read n or break
            String nline = in.readLine();
            if (nline == null /* || nline.equals("") */)
                break;
            int n = Integer.valueOf(nline);

            // read p
            BigInteger p = new BigInteger(in.readLine());

            res.append(binarySearchRoot(p, n));
            res.append("\n");
        }

        out.write(res.toString().getBytes());
        out.flush();
        in.close();
    }

    /**
     * Finds the nth root of p using binary search.
     */
    static int binarySearchRoot(BigInteger p, int n) {
        int lo = 0;
        int hi = Integer.MAX_VALUE;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            BigInteger k = BigInteger.valueOf(mid);
            BigInteger pow = k.pow(n);

            int cmp = pow.compareTo(p);

            if (cmp > 0)
                hi = mid - 1;
            else if (cmp < 0)
                lo = mid + 1;
            else {
                return mid;
            }
        }

        // it is guaranteed to exist
        throw new RuntimeException("Couldn't find the root!");
    }
}
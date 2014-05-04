/*
 * 10110 - Light, more light
 * 
 * This question has a really short solution as well as some tantalizing "fast"
 * solutions that take longer.
 * 
 * Divisors always occur in pairs (and thus the number of them is even), unless
 * there's an integer square root.
 * 
 * Note to self: for these number theory ones, with the brute force solution in
 * hand, look for patterns in the output over a large range of test cases before
 * continuing on.
 */

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(
            System.in));
    static BufferedOutputStream out = new BufferedOutputStream(System.out);
    static StringBuilder res = new StringBuilder();

    /**
     * Entry point. For each test case, prints yes if the number of divisors is
     * odd, no if not.
     */
    public static void main(String[] args) throws NumberFormatException,
            IOException {

        while (true) {
            String line = in.readLine();
            long n = Long.parseLong(line);

            if (n == 0)
                break;

            double sqrt = Math.sqrt(n);
            res.append((int) sqrt == sqrt ? "yes" : "no");
            res.append("\n");
        }

        out.write(res.toString().getBytes());
        out.flush();

        in.close();
        out.close();

    }

}

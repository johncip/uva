/*
 * 10424 - Love Calculator
 * 
 * Recursively sum the digits. Don't forget to ignore non-alphabetic characters.
 * 
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
     * Entry point.
     */
    public static void main(String[] args) throws IOException {
        String one, two;
        while ((one = in.readLine()) != null) {
            two = in.readLine();

            double val = loveRatio(clean(one), clean(two));
            res.append(String.format("%.2f %%\n", val));
        }

        out.write(res.toString().getBytes());
        in.close();
        out.close();
    }

    /**
     * Prepares the string for summing.
     */
    static String clean(String s) {
        return s.trim().toUpperCase();
    }

    /**
     * Returns the ratio between the (recursive) character sums for each string.
     */
    static double loveRatio(String one, String two) {
        int i = sum(one);
        int j = sum(two);
        
        if (i > j)
            return 100 * (double) j / (double) i;
        else if (j > i)
            return 100 * (double) i / (double) j;
        else
            return 100.0;
    }

    /**
     * Returns the string's character value sum.
     */
    static int sum(String s) {
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);            
            if (c < 'A' || c > 'Z')
                continue;
            sum += c - 'A' + 1;
        }

        return sumDigits(sum);
    }

    /**
     * Repeatedly sums digits until the result is less than 10.
     */
    static int sumDigits(int sum) {
        int res = 0;

        while (sum >= 10) {
            res += (sum % 10);
            sum /= 10;
        }
        res += sum;

        if (res < 10)
            return res;
        else
            return sumDigits(res);
    }
}

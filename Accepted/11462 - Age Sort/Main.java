/*
 * 11462 - Age Sort
 * 
 * We can use the built-in sorting methods. To save time(?) we sort the strings
 * rather than parsing the numbers as integers.
 */

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(
            System.in));
    static BufferedOutputStream out = new BufferedOutputStream(System.out);
    static StringBuilder res = new StringBuilder();
    static final NumComparator CMP = new NumComparator();

    /**
     * Entry point.
     */
    public static void main(String[] args) throws IOException {
        while (true) {
            int n = Integer.valueOf(in.readLine());

            if (n == 0)
                break;

            String line = in.readLine();
            String[] nums = line.split(" ");
            Arrays.sort(nums, CMP);

            for (int i = 0; i < nums.length; i++) {
                res.append(nums[i]);

                if (i < nums.length - 1)
                    res.append(' ');
            }

            res.append('\n');
        }

        out.write(res.toString().getBytes());
        in.close();
        out.close();
    }
}

/**
 * Comparator for Strings representing numbers.
 */
class NumComparator implements Comparator<String> {

    @Override
    public int compare(String a, String b) {

        int lenA = a.length();
        int lenB = b.length();

        if (lenA < lenB)
            return -1;
        else if (lenA > lenB)
            return 1;
        else
            return a.compareTo(b);
    }
}
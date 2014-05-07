/*
 * 10340 - All in All
 * 
 * Keep an index on the plaintext and look at each character in the
 * ciphertext, incrementing the PT index when the current CT char matches the
 * indexed PT char.
 */

import java.util.Scanner;

public class Main {

    /**
     * Entry point. For each test case, prints out whether the plaintext appears
     * in the ciphertext.
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        while (in.hasNext()) {
            String ptext = in.next();
            String ctext = in.next();

            if (check(ptext, ctext))
                sb.append("Yes\n");
            else
                sb.append("No\n");

        }

        System.out.print(sb);
        in.close();
    }

    /**
     * Returns true if each character of the plaintext is found in the same
     * relative order in the ciphertext.
     */
    private static boolean check(String ptext, String ctext) {
        int i = 0;

        for (int j = 0; j < ctext.length(); j++) {
            if (ctext.charAt(j) == ptext.charAt(i))
                i++;

            if (i == ptext.length())
                return true;
        }

        return false;
    }

}

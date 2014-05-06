/*
 * 499 - What's The Frequency, Kenneth?
 * 
 * Same as "10008 - What's Cryptanalysis?" except we have to keep track of
 * both uppercase and lowercase, and the output format is slightly different.
 */

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] freqs;

    /**
     * Entry point.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream out = new BufferedOutputStream(System.out);
        StringBuilder res = new StringBuilder();

        String line;
        while ((line = in.readLine()) != null) {
            line = line.trim();
            analyze(line);
            res.append(listFreqs());
        }

        out.write(res.toString().getBytes());
        in.close();
        out.close();
    }

    /**
     * Counts the occurrence of each letter.
     */
    private static void analyze(String line) {
        freqs = new int[52];

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if ('a' <= c && c <= 'z')
                freqs[c - 'a' + 26]++;
            else if ('A' <= c && c <= 'Z')
                freqs[c - 'A']++;
            else
                continue;
        }
    }

    /**
     * Outputs the letter frequencies from most to least.
     */
    private static String listFreqs() {
        StringBuilder res = new StringBuilder();
        int[] order = new int[52];
        for (int i = 0; i < order.length; i++)
            order[i] = i;

        Util.sortUsing(order, freqs);

        int max = freqs[order[0]];

        for (int i = 0; i < order.length && freqs[order[i]] == max; i++) {
            int let = order[i];

            if (let < 26)
                res.append((char) (let + 'A'));
            else
                res.append((char) (let - 26 + 'a'));
        }

        res.append(" " + max + "\n");
        return res.toString();
    }

}

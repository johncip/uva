/*
 * 10008 - What's Cryptanalysis?
 * 
 * Count the frequencies. A more Java-like solution would involve
 * Comparable frequency objects, but trying to avoid the libraries I've
 * instead created an array of int "pointers" and sorted those.
 */

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(
            System.in));
    static StringBuilder res = new StringBuilder();
    static BufferedOutputStream out = new BufferedOutputStream(System.out);
    static int[] freqs = new int[26];

    /**
     * Entry point. Adds each occurrence of an alphabetic character in stdin to
     * a frequency table, then prints the table, sorted.
     */
    public static void main(String[] args) throws NumberFormatException,
            IOException {

        int t = Integer.valueOf(in.readLine());
        for (int i = 0; i < t; i++) {
            String line = in.readLine();
            analyze(line);
        }

        listFreqs();
        out.write(res.toString().getBytes());
        out.flush();

        in.close();
        out.close();
    }

    /**
     * Outputs the letter frequencies from most to least.
     */
    private static void listFreqs() throws IOException {
        int[] order = new int[26];
        for (int i = 0; i < order.length; i++)
            order[i] = i;

        sortUsing(order, freqs);

        for (int i = 0; i < order.length; i++) {
            int freq = freqs[order[i]];

            if (freq == 0)
                break;

            char letter = (char) (order[i] + 'A');
            res.append(letter + " " + freq + "\n");
        }
    }

    /**
     * Counts the occurrence of each letter.
     */
    private static void analyze(String line) {
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if ('a' <= c && c <= 'z')
                freqs[c - 'a']++;
            else if ('A' <= c && c <= 'Z')
                freqs[c - 'A']++;
            else
                continue;
        }
    }

    /**
     * Insertion sorts array a using the values in b.
     */
    public static void sortUsing(int[] a, int[] b) {
        assert a.length == b.length;

        int[] c = new int[b.length];
        System.arraycopy(b, 0, c, 0, b.length);

        for (int i = 0; i < c.length; i++)
            for (int j = i; j > 0 && c[j] > c[j - 1]; j -= 1) {
                swap(a, j, j - 1);
                swap(c, j, j - 1);
            }
    }

    /**
     * Swaps array values at the given indices.
     */
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}

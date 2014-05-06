/*
 * 499 - What's The Frequency, Kenneth?
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
        String line;
        while ((line = in.readLine()) != null) {
            line = line.trim();
            res.append(handleCase(line));
            res.append('\n');
        }
        
        out.write(res.toString().getBytes());
        in.close();
        out.close();
    }

    /**
     * Handles a case.
     */
    private static String handleCase(String line) {
        return line;
    }

}

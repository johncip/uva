/*
 * 12577 - Hajj-e-Akbar
 * 
 * Use fast IO.
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
     * Entry point. For each input, print the matching output.
     */
    public static void main(String[] args) throws IOException {
        for (int i = 1;; i++) {
            String line = in.readLine();
            if (line.equals("*"))
                break;

            res.append("Case ");
            res.append(i);
            res.append(": ");
            res.append(handleCase(line));
            res.append('\n');
        }

        out.write(res.toString().getBytes());
        in.close();
        out.close();
    }

    /**
     * Returns Hajj-e-Akbar if the input is Hajj, or else returns Hajj-e-Asghar.
     */
    static String handleCase(String line) {
        if (line.equals("Hajj"))
            return "Hajj-e-Akbar";
        else
            return "Hajj-e-Asghar";
    }

}

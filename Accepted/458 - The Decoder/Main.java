/*
 * 458 - The Decoder
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Main {

    /**
     * Reads lines and deciphers.
     */
    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(System.in);
        DataOutputStream out = new DataOutputStream(System.out);

        int c;
        while ((c = in.read()) != -1) {
            if (c == ' ' || c == '\n' || c == '\r')
                out.write(c);
            else
                out.write(c - 7);
        }
    }
}
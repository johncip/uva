/*
 * 488 - Triangle Wave
 * 
 * time to beat: 3.6
 */

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class Main {

    static DataInputStream in = new DataInputStream(System.in);
    static StringBuilder result = new StringBuilder();
    static BufferedOutputStream out = new BufferedOutputStream(System.out);
    static String line;

    /**
     * Entry point. Outputs an ASCII triangle wave for each test case.
     * 
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        for (int i = 0, t = nextInt(); i < t; i++) {
            int amp = nextInt();
            int freq = nextInt();
            wave(amp, freq);
        }
        
        String trimmed = result.substring(0, result.length() -1);
        out.write(trimmed.getBytes());
        
        in.close();
        out.close();
    }

    /**
     * Reads the next int from the input stream. Deprecated but faster than
     * Scanner.
     * 
     * @throws NumberFormatException
     * @throws IOException
     */
    @SuppressWarnings("deprecation")
    private static int nextInt() throws NumberFormatException, IOException {
        
        do
            line = in.readLine();
        while (line.equals(""));
        
        return Integer.parseInt(line);
    }

    /**
     * A wave is one or more crests, each followed by a newline.
     */
    private static void wave(int amp, int freq) {
        for (int i = 0; i < freq; i++)
            crest(amp);
    }

    /**
     * A crest is one or more bars, with the longest in the center.
     */
    private static void crest(int amp) {
        for (int i = 1; i < amp; i++)
            bar(i);

        bar(amp);

        for (int i = amp - 1; i > 0; i--)
            bar(i);

        result.append('\n'); // blank line
    }

    /**
     * A bar is a digit repeated $digit number of times.
     */
    private static void bar(int dig) {
        for (int i = 0; i < dig; i++)
            result.append(dig);

        result.append('\n');
    }

}

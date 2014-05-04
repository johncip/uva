/*
 * 10696 - f91
 * 
 * Learned: DataInputStream is faster for reading ints (but deprecated).
 * Building a gigantic string is still faster than doing lots of separate I/O.
 * 
 */

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class Main {
    
    static DataInputStream in = new DataInputStream(System.in);
    static StringBuilder res = new StringBuilder();
    static BufferedOutputStream out = new BufferedOutputStream(System.out);

    /**
     * For each x in stdin, print f91(x). Zero terminates.
     */
    @SuppressWarnings("deprecation")
    public static void main(String[] args) throws IOException {

        while (true) {
            final int x = Integer.parseInt(in.readLine());
            if (x == 0)
                break;

            res.append("f91(");
            res.append(x);
            res.append(") = ");
            res.append(x <= 100 ? 91 : x - 10);
            res.append('\n');
        }

        out.write(res.toString().getBytes());
        out.flush();
    }

}

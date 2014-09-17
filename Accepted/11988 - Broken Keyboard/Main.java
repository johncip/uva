/*
 * 11988 - Broken Keyboard
 * 
 * Use a data structure where the beginning and end are quickly accessible.
 */

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

    static int i; // shared by reading methods

    /**
     * Reads line segments into a string list, then appends the strings to the
     * output.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream out = new BufferedOutputStream(System.out);
        StringBuilder res = new StringBuilder();

        String line;

        while ((line = in.readLine()) != null) {
            Deque<StringBuilder> sbs = chopLine(line.trim());
            for (StringBuilder sb : sbs)
                res.append(sb);
            res.append('\n');
        }

        out.write(res.toString().getBytes());
        in.close();
        out.close();
    }

    /**
     * Chops a line into segments, adding them in the proper order to a
     * double-ended queue.
     */
    static Deque<StringBuilder> chopLine(String line) {
        Deque<StringBuilder> deque = new LinkedList<>();
        char last = ']';
        i = 0;

        for (; i < line.length(); i++) {
            StringBuilder sb = readUntil(line);

            if (last == '[')
                deque.addFirst(sb);
            else if (last == ']')
                deque.addLast(sb);

            if (i < line.length())
                last = line.charAt(i);
        }

        return deque;
    }

    /**
     * Reads characters from a line until the end or the next bracket.
     */
    static StringBuilder readUntil(String line) {
        StringBuilder res = new StringBuilder();

        for (; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == '[' || c == ']')
                break;
            res.append(c);
        }

        return res;
    }
}
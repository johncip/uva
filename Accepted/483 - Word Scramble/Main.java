/*
 * 483 - Word Scramble
 * 
 * To submit, append Stack<T>.
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

    static Stack<Character> stack = new Stack<>(100);
    static final int WORD = 0, NON_WORD = 1;
    static int state;

    /**
     * For each line, prints the line with words reversed. Words are defined as
     * including punctuation (but not whitespace). Word length must be less than
     * the stack size.
     */
    public static void main(String[] args) throws IOException {

        for (String line = in.readLine(); line != null; line = in.readLine()) {
            scramble(line);
        }

        out.write(res.toString().getBytes());
        out.flush();

        in.close();
        out.close();
    }

    /**
     * Appends the scrambled line to global StringBuilder.
     */
    static void scramble(String line) {
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);

            if (state == WORD) {
                if (wordChar(c))
                    stack.push(c);
                else {
                    while (!stack.isEmpty())
                        res.append(stack.pop());
                    res.append(c);
                    state = NON_WORD;
                }

            } else if (state == NON_WORD) {
                if (wordChar(c)) {
                    stack.push(c);
                    state = WORD;
                } else
                    res.append(c);
            }
        }

        while (!stack.isEmpty())
            res.append(stack.pop());

        res.append('\n');
    }

    /**
     * Returns true if the character is a letter, number, or ASCII punctuation.
     */
    static boolean wordChar(char c) {
        return Character.isJavaIdentifierPart(c) || ('!' <= c && c <= '~');
    }
}

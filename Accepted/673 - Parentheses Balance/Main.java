/*
 * 673 - Parentheses Balance
 * 
 * Use a stack.
 * 
 * Note: this solution uses an old stack implementation which has since been
 * replaced.
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

    static Stack sk = new Stack(10000);

    public static void main(String[] args) throws NumberFormatException,
            IOException {

        int t = Integer.valueOf(in.readLine());
        for (int i = 0; i < t; i++) {
            String line = in.readLine();

            sk.reset();
            boolean balanced = balanced(line);

            res.append(balanced ? "Yes" : "No");
            res.append("\n");
        }

        out.write(res.toString().getBytes());
        out.flush();

        in.close();
        out.close();

    }

    private static boolean balanced(String line) {
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);

            if (c == '(' || c == '[')
                sk.push(c);
            else if (c == ')' && !sk.isEmpty() && sk.peek() == '(')
                sk.pop();
            else if (c == ']' && !sk.isEmpty() && sk.peek() == '[')
                sk.pop();
            else
                return false;
        }

        return sk.isEmpty();
    }
}

/*
 * 272 - TEX Quotes
 */

import java.util.Scanner;

public class Main {
    
    static int seen;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            System.out.println(swapQuotes(in.nextLine()));
        }
    }

    /**
     * Replaces straight quotes with TEX-style quotes.
     */
    private static String swapQuotes(String text) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == '"') {
                String marks = seen % 2 == 0 ? "``" : "''";
                sb.append(marks);
                seen++;
            } else
                sb.append(c);
        }

        return sb.toString();
    }
}
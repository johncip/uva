/*
 * 494 - Kindergarten Counting Game
 * 
 * Small state machine.
 * 
 */
import java.util.Scanner;

public class Main {

    static public void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine())
            System.out.println(wordCount(in.nextLine()));

        in.close();
    }

    /**
     * Counts the number of words (runs of alphabetic chars) in a line.
     */
    private static int wordCount(String line) {
        int words = 0;
        boolean inWord = false;

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (inWord && !Character.isAlphabetic(c))
                inWord = false;
            else if (!inWord && Character.isAlphabetic(c)) {
                inWord = true;
                words++;
            }
        }

        return words;
    }
}

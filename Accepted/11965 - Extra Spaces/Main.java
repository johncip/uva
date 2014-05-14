/*
 * 11965 - Extra Spaces
 * 
 * Regular expressions will work.
 */

import java.util.Scanner;

public class Main {

    /**
     * Entry point. For each line, replace multiple consecutive spaces with a
     * single space.
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int cases = in.nextInt();
        in.nextLine(); // flush

        for (int i = 0; i < cases; i++) {
            System.out.format("Case %d:\n", i + 1);

            int lines = in.nextInt();
            in.nextLine(); // flush

            for (int j = 0; j < lines; j++) {
                String line = in.nextLine();
                System.out.println(line.replaceAll(" +", " "));
            }

            if (i < cases - 1)
                System.out.println();
        }

        in.close();
    }

}

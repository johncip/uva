/*
 * 10696 - f91
 */

import java.util.Scanner;

public class FirstTry {

    /**
     * For each x in stdin, print f91(x). Zero terminates.
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (true) {
            int x = in.nextInt();
            if (x == 0)
                break;

            // closed form, inline
            int fx = (x <= 100) ? 91 : x - 10;
            System.out.format("f91(%d) = %d\n", x, fx);
        }

        in.close();
    }

    /**
     * An iterative version of f91... I think.
     */
    private static int f91i(int x) {
        while (x <= 100) {
            x += 11;

            while (x <= 100) {
                x += 11;
            }
            x -= 10;
        }

        x -= 10;
        return x;
    }

    /**
     * The classic f91.
     */
    private static int f91(int x) {
        if (x >= 101)
            return x - 10;
        else
            return f91(f91(x + 11));
    }

}

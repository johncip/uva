/*
 * Title
 */

import java.util.Scanner;

public class Main {

    /**
     * Entry point.
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {
            int a = in.nextInt();
            int res = handleCase(a);
            System.out.println(res);
        }
        
        in.close();
    }

    /**
     * Handles a case.
     */
    private static int handleCase(int n) {
        return n;
    }

}

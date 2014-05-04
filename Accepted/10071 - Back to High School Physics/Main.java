/*
 * 10071 - Back to High School Physics
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            int v = in.nextInt();
            int s = in.nextInt();
            System.out.println(v * 2 * s);
        }

        in.close();
    }
}
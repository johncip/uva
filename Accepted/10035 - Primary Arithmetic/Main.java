/*
 * 10035 - Primary Arithmetic
 */
import java.util.Scanner;

public class Main {

    /**
     * Prints the number of carry operations for each test case.
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (true) {
            int a = in.nextInt();
            int b = in.nextInt();

            if (a == 0 && b == 0)
                break;

            int cs = carries(a, b);
            String pre = cs == 0 ? "No" : "" + cs;
            String post = cs <= 1 ? "" : "s";
            System.out.format("%s carry operation%s.\n", pre, post);
        }
        
        in.close();
    }

    /**
     * Returns the number of carries generated when adding two base-10 numbers.
     */
    private static int carries(int a, int b) {
        int res = 0;

        for (int carry = 0; a > 0 || b > 0; a /= 10, b /= 10) {
            int da = a % 10;
            int db = b % 10;

            carry = (da + db + carry) / 10;
            res += carry;
        }

        return res;
    }

}

/*
 * 11727 - Cost Cutting
 * 
 * Could sort, do a couple swaps, etc. I went with a decision tree.
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            
            int res;
            
            if (a < b)
                if (b < c)
                    res = b;
                else if (a < c)
                    res = c;
                else
                    res = a;
            else
                if (b < c)
                    if (a < c)
                        res = a;
                    else
                        res = c;
                else
                    res = b;
            
            
            System.out.format("Case %d: %d\n", i+1, res);
        }
        
        in.close();
    }

}

/*
 * 11498 - Division of Nlogonia
 * 
 * Remember the absolute values.
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int k = in.nextInt();
            
            if (k == 0) {
                in.close();
                return;                
            }
            
            int n = in.nextInt();
            int m = in.nextInt();

            for (int i = 0; i < k; i++) {
                int x = in.nextInt();
                int y = in.nextInt();

                if (Math.abs(x) == Math.abs(n) || Math.abs(y) == Math.abs(m))
                    System.out.println("divisa");
                else {
                    String ns = y > m ? "N" : "S";
                    String ew = x > n ? "E" : "O";
                    System.out.println(ns + ew);
                }
            }
        }
        
        in.close();
    }
    
}
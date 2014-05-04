/*
 * 579 - ClockHands
 */

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class Main {

    static DataInputStream in = new DataInputStream(System.in);
    static StringBuilder res = new StringBuilder();
    static BufferedOutputStream out = new BufferedOutputStream(System.out);

    public static void main(String[] args) throws IOException {

        while (true) {
            String[] split = in.readLine().split(":");
            int h = Integer.valueOf(split[0]);
            int m = Integer.valueOf(split[1]);
            
            if (h + m == 0)
                break;
            
            res.append(String.format("%.3f\n", angle(h, m)));
        }
        
        out.write(res.toString().getBytes());
        out.flush();
    }

    /**
     * Returns the smallest angle between clock hands.
     */
    private static double angle(int h, int m) {
        double ang = Math.abs(angleHour(h, m) - angleMin(m));
        if (ang > 180)
            ang = 360 - ang;

        return ang;
    }

    /**
     * Returns the angle (from zero) of the hour hand.
     */
    private static double angleHour(int h, int m) {
        int oneHour = 360 / 12;
        int withoutMin = h * oneHour;

        return withoutMin + (0.5 * m);
    }

    /**
     * Returns the angle (from zero) of the minute hand.
     */
    private static double angleMin(int m) {
        m %= 60;
        int oneMin = 360 / 60;
        return m * oneMin;
    }

}

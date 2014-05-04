import java.util.Scanner;

/**
 * 102 - Ecological Bin Packing
 * 
 * Sort bottles into bins with minimum number of moves.
 * 
 * Small number of cases, just enumerate and pick the minimum.
 * 
 */
public class Main {

    static Scanner in = new Scanner(System.in);
    static Bin[] bins;

    public static void main(String[] args) {
        while (in.hasNext()) {
            readBins();
            printMin();
        }
    }

    /**
     * Initialize bins to integers read from stdin.
     */
    private static void readBins() {
        bins = new Bin[3];
        for (int i = 0; i < bins.length; i++)
            bins[i] = new Bin(in.nextInt(), in.nextInt(), in.nextInt());
    }

    /**
     * Returns the number of bottle moves needed for a given sort.
     */
    static int moves(String sort) {
        int sum = 0;
        for (int i = 0; i < bins.length; i++)
            sum += bins[i].keep(sort.charAt(i));
        return sum;
    }

    /**
     * Finds and prints the sort requiring the least bottle moves, and the
     * number of moves.
     */
    static void printMin() {
        String[] configs = { "BCG", "BGC", "CBG", "CGB", "GBC", "GCB" };
        String sort = "";
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < configs.length; i++) {
            int moves = moves(configs[i]);
            if (moves < min) {
                min = moves;
                sort = configs[i];
            }
        }

        System.out.println(sort + " " + min);
    }

    static class Bin {
        final int brown, green, clear;

        Bin(int b, int g, int c) {
            brown = b;
            green = g;
            clear = c;
        }

        int keep(char color) {
            switch (color) {
                case 'B': return green + clear;
                case 'G': return brown + clear;
                case 'C': return brown + green;
            }
            
            return -1;
        }
    }
}
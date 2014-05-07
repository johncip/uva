/*
 * 103 - Stacking Boxes
 * 
 * Print the longest chain of n-dimensional boxes that fit inside one another.
 * 
 * (Sort dimensions, sort boxes, create a "contains" tree bottom-up where the
 * child with the longest path is preferred over the others.)
 * 
 * To submit, include Box and Util.
 */

import java.util.Scanner;

public class Main {

    static Scanner in = new Scanner(System.in);

    /**
     * Entry point.
     */
    public static void main(String[] args) {
        while (in.hasNext()) {
            Box[] boxes = readBoxes();
            Util.sort(boxes);

            buildLinks(boxes);

            Box max = hasMost(boxes);
            System.out.println(1 + max.holds);
            System.out.println(max.children());
        }
    }

    /**
     * Reads in boxes (plus N and K) from stdin.
     */
    private static Box[] readBoxes() {
        int k = in.nextInt();
        int n = in.nextInt();
        in.nextLine(); // flush newline

        Box[] boxes = new Box[k];
        for (int i = 0; i < k; i++) {
            String name = String.valueOf(i + 1);
            boxes[i] = new Box(name, n, in.nextLine());
        }

        return boxes;
    }

    /**
     * Returns the box for which holds is greatest.
     */
    private static Box hasMost(Box[] boxes) {
        Box max = boxes[0];
        for (int i = 1; i < boxes.length; i++)
            if (boxes[i].holds > max.holds)
                max = boxes[i];

        return max;
    }

    /**
     * Builds a tree of "contains" links, bottom-up. Boxes have a child link and
     * prefer to keep the one with the longest sequences of children.
     */
    private static void buildLinks(Box[] bs) {
        for (int j = 1; j < bs.length; j++)
            for (int i = 0; i < j; i++)
                if (bs[i].fitsIn(bs[j]))
                    if (bs[j].holds < 1 + bs[i].holds) {
                        bs[j].holds = 1 + bs[i].holds;
                        bs[j].child = bs[i];
                    }
    }

}
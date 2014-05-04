/**
 * 575 - Skew Binary
 */

import java.io.IOException;
import java.util.Scanner;

public class Main {

    static Scanner in = new Scanner(System.in);

    /**
     * Entry point. For each line, build the graph and try to color it.
     */
    public static void main(String[] args) throws NumberFormatException,
            IOException {
        StringBuilder res = new StringBuilder();

        while (true) {
            int n = in.nextInt();

            if (n == 0)
                break;

            ALGraph g = new ALGraph(n);
            for (int edges = in.nextInt(); edges > 0; edges--)
                g.addEdge(in.nextInt(), in.nextInt());

            if (!g.bicolorable())
                res.append("NOT ");

            res.append("BICOLORABLE.\n");
        }

        System.out.print(res);
    }
}

class ALGraph {

    int[][] links;
    int[] degree;
    boolean[] marked;
    boolean[] ncolor;

    public ALGraph(int n) {
        links = new int[n][n];
        degree = new int[n];
        marked = new boolean[n];
        ncolor = new boolean[n];
    }

    /**
     * Adds an edge to the graph.
     */
    void addEdge(int a, int b) {
        links[a][degree[a]] = b;
        degree[a]++;

        links[b][degree[b]] = a;
        degree[b]++;
    }

    /**
     * Does a depth-first search of the tree.
     */
    boolean bicolorable() {
        return visit(0, false);
    }

    /**
     * Visits a node and recursively visits the linked nodes.
     */
    boolean visit(int node, boolean color) {
        marked[node] = true;
        ncolor[node] = color;

        for (int i = 0; i < degree[node]; i++) {
            int link = links[node][i];

            if (!marked[link])
                visit(link, !color);
            else if (ncolor[link] == color)
                return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int node = 0; node < links.length; node++)
            if (degree[node] > 0) {
                sb.append(ncolor[node] ? "[" : "");
                sb.append(node);
                sb.append(ncolor[node] ? "]" : "");
                sb.append(" --> ");
                for (int link = 0; link < degree[node]; link++)
                    sb.append(links[node][link] + " ");
                sb.append('\n');
            }

        return sb.toString();
    }

}
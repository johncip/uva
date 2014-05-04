/* 
 * Problem 101 - Blocks World
 * 
 * Create an array of stacks and manage their state.
 * 
 * This problem can be done by simulating the stacks in a 2D array, which is
 * how I solved it while in school. However, a "real" stack ADT is easy to
 * write, and using it the commands given reduce to a few push and pop
 * operations. The code for this solution is much more readable, I think,
 * and more amenable to unit testing. 
 * 
 * To submit: include BlockWorld.java and Util/Stack.java.
 */

import java.util.Scanner;

/**
 * Handles input parsing and output for the block world simulation.
 * 
 */
public class Main {

    /**
     * Entry point.
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BlockWorld world = new BlockWorld(in.nextInt());
        
        while (readCommands(in, world))
            ;
    }

    /**
     * Reads verb and arguments. Dispatches, unless verb is "quit."
     */
    static boolean readCommands(Scanner in, BlockWorld world) {
        String verb = in.next();

        if (verb.equals("quit")) {
            System.out.print(world);
            return false;
        }

        int a = in.nextInt();
        String prep = in.next();
        int b = in.nextInt();

        if (verb.equals("move"))
            world.move(a, b, prep.equals("onto"));
        else if (verb.equals("pile"))
            world.pile(a, b, prep.equals("onto"));

        return true;
    }
}
/*
 * 10258 - Contest Scoreboard
 * 
 * Need to record the total time spent on each problem per contestant, if
 * the problem was attempted at all.
 * 
 * Unsolved problems don't contribute to the time penalty, and penalties should
 * not be incremented for problems once they are considered solved.
 * 
 * Sorting should be done based on problems solved (descending), time penalty
 * (for solved problems), and contestant id, in that order.
 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(
            System.in));

    /**
     * Entry point.
     */
    public static void main(String[] args) throws IOException {
        int cases = Integer.parseInt(in.readLine());
        in.readLine(); // flush first blank

        for (int i = 0; i < cases; i++) {
            handleCase();
            if (i < cases - 1)
                System.out.println();
        }

        in.close();
    }

    /**
     * Handles a case (list of submission attempts) by initializing the map from
     * contestant to score, reading the lines, and printing the contestants by
     * rank.
     */
    static void handleCase() throws IOException {
        Map<Integer, Contestant> cts = new HashMap<>();
        updateScores(cts);

        // get scores array
        Contestant[] vals = new Contestant[0];
        vals = (Contestant[]) cts.values().toArray(vals);

        // print in sorted order
        Arrays.sort(vals);
        for (Contestant c : vals)
            System.out.println(c);
    }

    /**
     * For all lines in the test case, update the contestants' scores.
     */
    static void updateScores(Map<Integer, Contestant> cts) throws IOException {
        int id, prob, time;
        String status;

        while (true) {
            String line = in.readLine();
            if (line == null || line.equals(""))
                break;

            Scanner sc = new Scanner(line);
            id = sc.nextInt();
            prob = sc.nextInt();
            time = sc.nextInt();
            status = sc.next();
            sc.close();

            if (!cts.containsKey(id))
                cts.put(id, new Contestant(id));
            cts.get(id).update(prob, time, status);
        }
    }
}

/**
 * A single contestant's solved problems and times.
 */
class Contestant implements Comparable<Contestant> {
    private final int id;
    private final Set<Integer> solved;
    private final Map<Integer, Integer> times;

    Contestant(int id) {
        this.id = id;
        solved = new HashSet<>();
        times = new HashMap<>();
    }

    /**
     * Adds to time spent on the given problem.
     */
    public void addTime(int prob, int time) {
        if (!times.containsKey(prob))
            times.put(prob, 0);

        times.put(prob, times.get(prob) + time);
    }

    /**
     * Returns the total time spent on solved problems.
     */
    public int totalTime() {
        int sum = 0;
        for (int prob : solved)
            sum += times.get(prob);
        return sum;
    }

    /**
     * Updates problems solved and times based on the status.
     */
    public void update(int prob, int time, String status) {        
        if (solved.contains(prob))
            return;
        
        if (status.equals("C")) {
            addTime(prob, time);
            solved.add(prob);
        } else if (status.equals("I"))
            addTime(prob, 20);
    }

    @Override
    public int compareTo(Contestant that) {
        int solvedCmp = that.solved.size() - this.solved.size(); // descending
        int timeCmp = this.totalTime() - that.totalTime();

        if (solvedCmp != 0)
            return solvedCmp;
        else if (timeCmp != 0)
            return timeCmp;
        else
            return this.id - that.id;
    }

    @Override
    public String toString() {
        return id + " " + solved.size() + " " + this.totalTime();
    }
}
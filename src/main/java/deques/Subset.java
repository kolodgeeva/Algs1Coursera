package main.java.deques;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by User on 10/4/2016.
 */
public class Subset {
    /**
     * Testing.
     * @param args args
     */
    public static void main(String[] args) {
        RandomizedQueue<String> rq = new RandomizedQueue<>();

        while (StdIn.hasNextLine() && !StdIn.isEmpty()) {
            String s = StdIn.readString();
            rq.enqueue(s);
        }

        int k = Integer.parseInt(args[0]);
        for (int i = 0; i < k; i++) {
            StdOut.println(rq.dequeue());
        }
    }
}

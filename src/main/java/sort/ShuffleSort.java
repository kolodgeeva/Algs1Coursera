package main.java.sort;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by User on 10/5/2016.
 */
public class ShuffleSort {


    public static boolean less(Comparable v, Comparable w) {
        if (v.compareTo(w) < 0) {
            return true;
        }
        return false;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static void shuffle(Comparable[] a) {

        int N = a.length;
        for (int i = 0; i < N; i++) {
            int r = StdRandom.uniform(i + 1);
            exch(a, i, r);
        }
    }


    public static void main(String[] args) {

        Integer[] ints = new Integer[10];

        for (int i = 0; i < ints.length; i++) {
            ints[i] = i;
            StdOut.println(ints[i]);
        }

        shuffle(ints);

        StdOut.println("Shuffled:");

        for (Integer anInt : ints) {
            StdOut.println(anInt);
        }
    }

}

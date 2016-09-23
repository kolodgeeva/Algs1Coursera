package main.java.percolation;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

/**
 * Created by User on 9/20/2016.
 */
public class PercolationStats {

    private int dimension;
    private int trials;
    private double[] results;

    /**
     * Perform trials independent experiments on an n-by-n grid
     * @param n dimension
     * @param trials experiments
     */
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException();
        }
        this.dimension = n;
        this.trials = trials;
        Percolation percolation;
        int count;
        results = new double[trials];
        for (int i = 0; i < trials; i++) {
            percolation = new Percolation(this.dimension);
            count = 0;
            int row;
            int column;
            while(!percolation.percolates()) {
                row = StdRandom.uniform(this.dimension) + 1;
                column = StdRandom.uniform(this.dimension) + 1;
                if (!percolation.isOpen(row, column)) {
                    percolation.open(row, column);
                    count++;
                }
            }
            results[i] = count / (Math.pow(dimension, 2));
        }
    }

    /**
     * Sample mean of percolation threshold
     * @return mean
     */
    public double mean() {
        return StdStats.mean(results);
    }

    /**
     * Sample standard deviation of percolation threshold
     * @return stddev
     */
    public double stddev() {
        return StdStats.stddev(results);
    }

    /**
     * Low endpoint of 95% confidence interval
     * @return confidenceLo
     */
    public double confidenceLo() {
        return (mean() - (1.96 * stddev()) / Math.sqrt(trials));
    }

    /**
     * High endpoint of 95% confidence interval
     * @return confidenceHi
     */
    public double confidenceHi() {
        return (mean() + (1.96 * stddev()) / Math.sqrt(trials));
    }

    /**
     * test client
     * @param args - dimension, trials
     */
    public static void main(String[] args) {

        int dimension = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

        PercolationStats stats = new PercolationStats(dimension, trials);

        StdOut.println("mean                    = "+ stats.mean());
        StdOut.println("stddev                  = "+ stats.stddev());
        StdOut.println("95% confidence interval = "+ stats.confidenceLo() +", "+ stats.confidenceHi());


    }
}

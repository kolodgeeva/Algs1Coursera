package main.java.percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * Created by User on 9/20/2016.
 */
public class Percolation {

    private int dimension = 0;
    private int virtualTop;
    private int virtualBottom;
    private boolean[] grid;
    private WeightedQuickUnionUF weightedQuickUnionUF;

    /**
     * Create dimension-by-dimension grid, with all sites blocked
     * Define Virtual Top and Virtual Bottom
     * @param n - Grid Dimension
     */
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        this.dimension = n;
        int size = n * n;
        this.virtualTop = size;
        this.virtualBottom = size + 1;
        this.grid = new boolean[size];
        this.weightedQuickUnionUF = new WeightedQuickUnionUF(size + 2);
    }

    /**
     * Open site (row i, column j) if it is not open already
     * @param i - row (from 1 to dimension)
     * @param j - column (from 1 to dimension)
     */
    public void open(int i, int j) {

        int siteIndex = getIndexByRowColumn(i, j);
        if (!grid[siteIndex]) {
            grid[siteIndex] = true;

            // Get left neighbour site
            if (j > 1) {
                int leftNeighbour = getIndexByRowColumn(i, j - 1);
                if (grid[leftNeighbour]) {
                    weightedQuickUnionUF.union(leftNeighbour, siteIndex);
                }
            }

            // Get left neighbour site
            if (j < dimension) {
                int rightNeighbour = getIndexByRowColumn(i, j + 1);
                if (grid[rightNeighbour]) {
                    weightedQuickUnionUF.union(rightNeighbour, siteIndex);
                }
            }

            // Get bottom neighbour site
            if (i < dimension) {
                int bottomNeighbour = getIndexByRowColumn(i + 1, j);
                if (grid[bottomNeighbour]) {
                    weightedQuickUnionUF.union(bottomNeighbour, siteIndex);
                }
            }

            // Get top neighbour site
            if (i > 1) {
                int topNeighbour = getIndexByRowColumn(i - 1, j);
                if (grid[topNeighbour]) {
                    weightedQuickUnionUF.union(topNeighbour, siteIndex);
                }
            }

            // Connect to Virtual Top
            if (i == 1) {
                weightedQuickUnionUF.union(virtualTop, siteIndex);
            }

            // Connect to Virtual Bottom
            if (i == dimension) {
                weightedQuickUnionUF.union(virtualBottom, siteIndex);
            }
        }
    }

    /**
     * Is site (row i, column j) open?
     * @param i row
     * @param j column
     * @return is open
     */
    public boolean isOpen(int i, int j) {
        return grid[getIndexByRowColumn(i, j)];
    }

    /**
     * Is site (row i, column j) full?
     * @param i row
     * @param j row
     * @return is full
     */
    public boolean isFull(int i, int j) {
        return weightedQuickUnionUF.connected(virtualTop, getIndexByRowColumn(i, j));
    }

    /**
     * does the system percolate?
     * @return is percolates
     */
    public boolean percolates() {
        return weightedQuickUnionUF.connected(virtualTop, virtualBottom);
    }

    /**
     * Get index by row and column
     * @param i - row
     * @param j - column
     * @return index
     */
    private int getIndexByRowColumn(int i, int j) {
        if (i < 1 || i > dimension || j < 1 || j > dimension) {
            throw new IndexOutOfBoundsException();
        }
        return (i - 1) * dimension + (j - 1);
    }
}

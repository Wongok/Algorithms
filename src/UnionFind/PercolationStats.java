package UnionFind;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private final double[] results;
    private final double mean;
    private final double stddev;
    private static final double CONFIDENCE_95 = 1.96;

    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) throw new IllegalArgumentException();
        results = new double[trials];
        for (int i = 0; i < trials; i++) {
            Percolation percolation = new Percolation(n);
            while (!percolation.percolates()) {
                int row = StdRandom.uniform(1, n+1);
                int col = StdRandom.uniform(1, n+1);
                if (row <= 0 || row > n || col <= 0 || col > n) throw new IllegalArgumentException();
                if (!percolation.isOpen(row, col)) percolation.open(row, col);
            }
            results[i] = (double) percolation.numberOfOpenSites() / (double) (n * n);
        }
        mean = StdStats.mean(results);
        stddev = StdStats.stddev(results);
    }

    public double mean() {
        return mean;
    }
    public double stddev() {
        return stddev;
    }
    public double confidenceLo() {
        return mean - (CONFIDENCE_95 * stddev / Math.sqrt(results.length));
    }
    public double confidenceHi() {
        return mean + (CONFIDENCE_95 * stddev / Math.sqrt(results.length));
    }
    public static void main(String[] args) {
        PercolationStats percolationStats = new PercolationStats(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        StdOut.println("mean                    = " + percolationStats.mean());
        StdOut.println("stddev                  = " + percolationStats.stddev());
        StdOut.println("95% confidence interval = [" + percolationStats.confidenceLo() + ", " + percolationStats.confidenceHi() + "]");
    }
}
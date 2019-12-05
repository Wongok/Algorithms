package UnionFind;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private final int gridSize;
    private final WeightedQuickUnionUF uf;
    private final WeightedQuickUnionUF full;
    private boolean[] open;
    private final int start;
    private final int end;
    private int cnt = 0;
    // creates n-by-n grid, with all sites initially blocked
    // ------------------------------- start site : 0
    // 1       2       3     ...   n
    // n+1    n+2    n+3     ...  2n
    // 2n+1  2n+2   2n+3     ...  3n   grid : 1 ~ n^2
    // 3n+1  3n+2   3n+3     ...  4n
    //                       ...
    // n*(n-1)+1             ...  (n*n)
    // ------------------------------- end site : n^2 + 1
    public Percolation(int n) {
        if (n <= 0) throw new IllegalArgumentException();
        this.gridSize = n;
        start = 0;
        end = n * n + 1;
        uf = new WeightedQuickUnionUF(gridSize*gridSize + 2);
        full = new WeightedQuickUnionUF(gridSize*gridSize + 2);
        open = new boolean[gridSize*gridSize + 2];
    }

    // opens the site (row, col) if it not open already
    public void open(int row, int col) {
        int current = getIndex(row, col);
        if (open[current]) return;
        open[current] = true; // open
        cnt++;
        // left
        try {
            int left = getIndex(row, col-1);
            if (open[left]) {
                uf.union(current, left);
                full.union(current, left);
            }
        } catch (IllegalArgumentException e) {
        }
        // right
        try {
            int right = getIndex(row, col+1);
            if (open[right]) {
                uf.union(current, right);
                full.union(current, right);
            }
        } catch (IllegalArgumentException e) {
        }

        // up
        try {
            int up = getIndex(row-1, col);
            if (open[up]) {
                uf.union(current, up);
                full.union(current, up);
            }
        } catch(IllegalArgumentException e) {
            if (row == 1) {
                uf.union(current, start);
                full.union(current, start);
            }
        }

        // down
        try {
            int down  = getIndex(row+1, col);
            if (open[down]) {
                uf.union(current, down);
                full.union(current, down);
            }
        } catch (IllegalArgumentException e) {
            if(row == gridSize) {
                uf.union(current, end);
            }
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        int current = getIndex(row, col);
        return open[current];
    }

    // is the site (row, col) full?
    // start and current percolate?
    // prevent backwash
    public boolean isFull(int row, int col) {
        int current = getIndex(row, col);

        return open[current] && full.find(start) == full.find(current);
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return cnt;
    }

    // does the system percolate?
    // start and end percolate?
    public boolean percolates() {
        return uf.find(start) == uf.find(end);
    }

    private int getIndex(int row, int col) {
        if (row <= 0 || row > gridSize || col <= 0 || col > gridSize) throw new IllegalArgumentException();
        return (row - 1) * gridSize + col;
    }
}
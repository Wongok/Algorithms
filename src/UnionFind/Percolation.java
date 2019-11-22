package UnionFind;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private int gridSize;
    private WeightedQuickUnionUF uf;
    private boolean[] open;
    private int start;
    private int end;
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
        this.gridSize = n;
        start = 0;
        end = n * n + 1;
        uf = new WeightedQuickUnionUF(gridSize*gridSize + 2);
        open = new boolean[gridSize*gridSize + 2];
    }

    // opens the site (row, col) if it not open already
    public void open(int row, int col) {
        if(isOpen(row, col)) return;
        cnt++;
        int current = (row - 1) * gridSize + col;
        open[current] = true; // open
        // left
        try {
            if(isOpen(row, col-1)) {
                int left = (row - 1) * gridSize + col - 1;
                uf.union(current, left);
            }
        } catch(ArrayIndexOutOfBoundsException e) {
        }
        // right
        try {
            if(isOpen(row, col+1)) {
                int right = (row - 1) * gridSize + col + 1;
                uf.union(current, right);
            }
        } catch(ArrayIndexOutOfBoundsException e) {
        }

        // up
        try {
            if(isOpen(row-1, col)) {
                int up = (row - 2) * gridSize + col;
                uf.union(current, up);
            }
        } catch(ArrayIndexOutOfBoundsException e) {
        }

        // down
        try {
            if(isOpen(row+1, col)) {
                int down = row * gridSize + col;
                uf.union(current, down);
            }
        } catch(ArrayIndexOutOfBoundsException e) {
        }

        if(row == 1) {
            uf.union(current, start);
        }
        if(row == gridSize) {
            uf.union(current, end);
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        int current = (row - 1) * gridSize + col;
        return open[current];
    }

    // is the site (row, col) full?
    // start and current percolate?
    public boolean isFull(int row, int col) {
        int current = (row - 1) * gridSize + col;
        return uf.find(0)==uf.find(current);
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return cnt;
    }

    // does the system percolate?
    // start and end percolate?
    public boolean percolates() {
        return uf.find(start)==uf.find(end);
    }

    public static void main(String[] args) {
        // StdRandom
    }
}

package UnionFind;

import java.util.Scanner;

public class QuickUnionUF {

    private int[] id;

    QuickUnionUF(int N) {
        // set id of each object to itself
        // (N array accesses)
        id = new int[N];
        for(int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    int root(int n) {
        // chase parent pointers until reach root
        // (depth of p and q array accesses)
        while(id[n] != n) {
            n = id[n];
        }
        return n;
    }

    boolean connected(int p, int q) {
        // check if p and q have same root
        // (depth of p and q array accesses)
        return root(p) == root(q);
    }

    void union(int p, int q) {
        // change root of p to point to root of q
        // (depth of p and q array accesses)
        id[root(p)] = root(q);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p, q;
        int N = sc.nextInt();
        QuickUnionUF uf = new QuickUnionUF(N);
        int cnt = N;
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            p = sc.nextInt();
            q = sc.nextInt();
            if(!uf.connected(p, q)) {
                uf.union(p, q);
                cnt--;
            }
        }
        for(int i = 0; i < uf.id.length; i++) {
            System.out.print(uf.id[i]+" ");
        }
        System.out.println();
        System.out.println("Count : " + cnt);
    }
}

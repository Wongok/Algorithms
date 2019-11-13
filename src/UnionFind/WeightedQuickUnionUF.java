package UnionFind;

import java.util.Scanner;

public class WeightedQuickUnionUF {
    private int[] id;
    private int[] size;

    WeightedQuickUnionUF(int N) {
        id = new int[N];
        size = new int[N];
        for(int i = 0; i < N; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }

    int root(int n) {
        while(id[n] != n) {
            id[n] = id[id[n]];
            n = id[n];
        }
        return n;
    }

    boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    void union(int p, int q) {
        if(root(p)==root(q)) return;
        if(size[root(p)] < size[root(q)]) {
            id[root(p)] = root(q);
            size[root(q)] += size[root(p)];
        } else {
            id[root(q)] = root(p);
            size[root(p)] += size[root(q)];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p, q;
        int N = sc.nextInt();
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);
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
        for(int i = 0; i < uf.size.length; i++) {
            System.out.print(uf.size[i]+" ");
        }
        System.out.println();
        System.out.println("Count : " + cnt);
    }
}

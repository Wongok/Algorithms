package UnionFind;

import java.util.Scanner;

public class QuickFindUF {

    private int[] id;

    public QuickFindUF(int N) {
        // set id of each object to itself
        // (N array accesses)
        id = new int[N];
        for(int i=0; i<N; i++) {
            id[i] = i;
        }
    }

    boolean connected(int p, int q) {
        // check whether p and q are in the same component
        // (2 array accesses)
        return id[p] == id[q];
    }

    void union(int p, int q) {
        // change all entries with id[p] to id[q]
        // (at most 2N+2 array accesses)
        for(int i = 0; i < id.length; i++) {
            if(id[i] == id[p]) id[i] = id[q];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        QuickFindUF uf = new QuickFindUF(N);

        int n = sc.nextInt();
        int cnt = N;
        for(int i=0; i<n; i++) {
            int p = sc.nextInt();
            int q = sc.nextInt();
            if(!uf.connected(p, q)) {
                uf.union(p,q);
                cnt--;
            }
        }
        for(int i=0; i<uf.id.length; i++) {
            System.out.print(uf.id[i] + " ");
        }
        System.out.println();
        System.out.println("Count : " + cnt);
        sc.close();
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////////
//
// Source: 2.4. Data Structures with Our Own Libraries, 2. Data Structures and Libraries,
//         Competitive Programming 3: The New Lower Bound of Programming Contests, pp. 49-63
// Author: Yang, Sichao
// Email:  sichao@cs.wisc.edu
//
////////////////////////////////////////////////////////////////////////////////////////////////////

import java.util.ArrayList;
import java.util.TreeMap;

public class Main {
    static class Graph {
        int V, E;
        // Adjacency Matrix
        int[][] AdjMat = new int[V][V]; // Small dense simple graph.
        // Adjacency List
        TreeMap<Integer, TreeMap<Integer, Integer>> AdjList = new TreeMap<>(); // First choice.
        //      fromIndex        toIndex  weight
        // Edge List
        ArrayList<int[]> EdgeList = new ArrayList<>(E); // Usually sorted. Kruskal's algorithm.
        // int[]: {fromIndex, toIndex, weight}               

        // Implicit Graph: edges are not stored since they can be determined with rules
    }
    
    static class UnionFindDisjointSets {
        int n;
        int[] parent, rank;
        
        public UnionFindDisjointSets(int n) {
            this.n = n;
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }
        
        public int findSet(int i) { return parent[i] == i ? i : (parent[i] = findSet(parent[i])); }
        
        public void unionSets(int i, int j) {
            int si = findSet(i), sj = findSet(j);
            if (rank[si] > rank[sj]) parent[sj] = si;
            else {
                parent[si] = sj;
                if (rank[si] == rank[sj]) rank[sj]++;
            }
        }
    }
    
    static class SegmentTree {
        private int[] a, st;
        private int n;
        
        private int ls(int p) { return (p << 1) + 1; }
        private int rs(int p) { return (p << 1) + 2; }
        
        public SegmentTree(int[] a) {
            this.a = a;
            n = a.length;
            st = new int[2 * n];
            build(0, 0, n - 1);
        }
        
        public int rmp(int i, int j) { return rmp(0, 0, n - 1, i, j); }
        
        private int rmp(int p, int l, int r, int i, int j) {
            if (i > r || j < l) return -1;
            if (i <= l && r <= j) return st[p];
            int lp = rmp(ls(p), l, (l + r) / 2, i, j), rp = rmp(rs(p), (l + r) / 2 + 1, r, i, j);
            return lp < 0 ? rp : rp < 0 ? lp : a[lp] <= a[rp] ? lp : rp;
        }
        
        private void build(int p, int l, int r) {
            if (l == r) st[p] = l;
            else {
                build(ls(p), l, (l + r) / 2);
                build(rs(p), (l + r) / 2 + 1, r);
                int lp = st[ls(p)], rp = st[rs(p)];
                st[p] = a[lp] <= a[rp] ? lp : rp;
            }
        }
    }
    
    static class FenwickTree {
        private int[] ft;
        
        public FenwickTree(int n) { ft = new int[n + 1]; }
        
        public int rsq(int a, int b) { return rsq(b) - rsq(a - 1); }
        
        public void adjust(int key, int increment) {
            for (; key < ft.length; key += (key & -key)) {
                ft[key] += increment;
                System.out.println("key: " + key);
            }
        }
        
        private int rsq(int b) {
            int sum = 0;
            for (; b > 0; b -= (b & -b)) sum += ft[b];
            return sum;
        }
    }
    
    public static void main(String[] args) {
        UnionFindDisjointSets ufds = new UnionFindDisjointSets(3);
        ufds.unionSets(1, 2);
        System.out.println(ufds.findSet(0) != ufds.findSet(1));
        System.out.println(ufds.findSet(1) == ufds.findSet(2));
        
        int[] a = new int[]{ 18, 17, 13, 19, 15, 11, 20 };
        SegmentTree st = new SegmentTree(a);
        System.out.println(st.rmp(1, 3));
        System.out.println(st.rmp(4, 6));
        
        int[] f = new int[]{ 2,4,5,5,6,6,6,7,7,8,9 };
        FenwickTree ft = new FenwickTree(10);
        for (int i = 0; i < 11; i++) ft.adjust(f[i], 1);
        System.out.println(ft.rsq(1, 1));
        System.out.println(ft.rsq(1, 2));
        System.out.println(ft.rsq(1, 10));
        System.out.println(ft.rsq(3, 6));
        ft.adjust(5, 2);
        System.out.println(ft.rsq(1, 10));
    }
}
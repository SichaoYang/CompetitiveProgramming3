////////////////////////////////////////////////////////////////////////////////////////////////////
//
// Source: UVa 11503 - Virtual Friends
// Author: Yang, Sichao
// Email:  sichao@cs.wisc.edu
//
////////////////////////////////////////////////////////////////////////////////////////////////////
package Union_Find_Disjoint_Sets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.TreeMap;

/**
 * A UFDS maintaining the set size.
 */
public class UVa11503VirtualFriends {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    
    static class UnionFindDisjointSets {
        int n;
        int[] parent, size;
        
        public UnionFindDisjointSets(int n) {
            this.n = n;
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }
        
        public int findSet(int i) { return parent[i] == i ? i : (parent[i] = findSet(parent[i])); }
        
        public void unionSets(int i, int j) {
            int si = findSet(i), sj = findSet(j);
            if (si == sj) return; // Avoids size change.
            if (size[si] > size[sj]) {
                parent[sj] = si;
                size[si] += size[sj];
            }
            else {
                parent[si] = sj;
                size[sj] += size[si];
            }
        }
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        int C  = Integer.parseInt(reader.readLine());
        while (C-- > 0) {
            int F = Integer.parseInt(reader.readLine()), index = 0;           
            TreeMap<String, Integer> map = new TreeMap<>();
            UnionFindDisjointSets ufds = new UnionFindDisjointSets(2 * F);
            while (F-- > 0) {
                String[] names = reader.readLine().split(" ");
                if (!map.containsKey(names[0])) map.put(names[0], index++);
                if (!map.containsKey(names[1])) map.put(names[1], index++);
                ufds.unionSets(map.get(names[0]), map.get(names[1]));
                writer.println(ufds.size[ufds.findSet(map.get(names[0]))]);
            }
        }
        reader.close();
        writer.close();
    }
}

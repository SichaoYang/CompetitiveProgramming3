////////////////////////////////////////////////////////////////////////////////////////////////////
//
// Source: UVa 00793 - Network Connections
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
import java.util.StringTokenizer;

/**
 * Trivial UFDS.
 */
public class UVa00793NetworkConnections {
    private static class io {
        static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        static PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        static StringTokenizer tokenizer;
        public static boolean nextLine() throws IOException {
            String input = reader.readLine();
            if (input == null || input.isEmpty()) return false;
            tokenizer = new StringTokenizer(input);
            return true;
        }
        public static int nextInt() { return Integer.parseInt(tokenizer.nextToken()); }
        public static int nextLineInt() throws IOException { return Integer.parseInt(reader.readLine()); }
        public static void close() throws IOException { reader.close(); writer.close(); }
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
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        int case_num = io.nextLineInt();
        io.reader.readLine();
        while (case_num-- > 0) {
            int n = io.nextLineInt(), s = 0, u = 0;
            UnionFindDisjointSets ufds = new UnionFindDisjointSets(n);
            while (io.nextLine()) {
                String op = io.tokenizer.nextToken();
                int i = io.nextInt() - 1, j = io.nextInt() - 1;
                if (op.equals("c")) ufds.unionSets(i, j);
                else if (ufds.findSet(i) == ufds.findSet(j)) s++;
                else u++;
            }
            io.writer.println(s + "," + u);
            if (case_num > 0) io.writer.println();
        }
        io.close();
    }
}

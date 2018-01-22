////////////////////////////////////////////////////////////////////////////////////////////////////
//
// Source: UVa 10264 - The Most Potent Corner
// Author: Yang, Sichao
// Email:  sichao@cs.wisc.edu
//
////////////////////////////////////////////////////////////////////////////////////////////////////
package Bit_Manipulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Bit toggle. Can be combined with BFS. 
 */
public class UVa10264TheMostPotentCorner {
    private static class io {
        static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        static PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        static StringTokenizer tokenizer;
        public static boolean nextLine() throws IOException {
            String input = reader.readLine();
            if (input == null) return false;
            tokenizer = new StringTokenizer(input);
            return true;
        }
        public static int nextInt() { return Integer.parseInt(tokenizer.nextToken()); }
        public static int nextLineInt() throws IOException { return Integer.parseInt(reader.readLine()); }
        public static void close() throws IOException { reader.close(); writer.close(); }
    }
    
    public static void main(String[] args) throws IOException {
        while (io.nextLine()) {
            int N = io.nextInt(), n = 1 << N;
            int[] weights = new int[n], potencies = new int[n];
            int m = 0;
            for (int i = 0; i < n; i++)
                weights[i] = io.nextLineInt();
            for (int i = 0; i < n; i++)
                for (int sh = 0; sh < N; sh++)
                    potencies[i] += weights[i ^ (1 << sh)];
            for (int i = 0; i < n; i++)
                for (int sh = 0; sh < N; sh++) {
                    int sum = potencies[i] + potencies[i ^ (1 << sh)];
                    if (sum > m) m = sum;
                }
            io.writer.println(m);
        }
        io.close();
    }
}

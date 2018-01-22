////////////////////////////////////////////////////////////////////////////////////////////////////
//
// Source: UVa 12356 - Army Buddies
// Author: Yang, Sichao
// Email: sichao@cs.wisc.edu
//
////////////////////////////////////////////////////////////////////////////////////////////////////
package _1D_Array_Manipulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Linked list in direct addressing tables.
 */
public class UVa12356ArmyBuddies {
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
        public static void close() throws IOException { reader.close(); writer.close(); }
    }
    
    public static void main(String[] args) throws IOException {
        int[] l = new int[100000]; // first alive soldier to the left
        int[] r = new int[100000]; // first alive soldier to the right
        while (io.nextLine()) {
            int S = io.nextInt(), B = io.nextInt();
            if (S == 0) break;
            for (int i = 0; i < S; i++) {
                l[i] = i - 1;
                r[i] = i + 1;
            }
            while (B-- > 0 && io.nextLine()) {
                int L = io.nextInt() - 1, R = io.nextInt() - 1;
                if (l[L] >= 0) {
                    r[l[L]] = r[R];
                    io.writer.print(l[L] + 1);
                } else io.writer.print("*");
                io.writer.print(" ");
                if (r[R] < S) {
                    l[r[R]] = l[L];
                    io.writer.print(r[R] + 1);
                } else io.writer.print("*");
                io.writer.println();
            }
            io.writer.println("-");
        }
        io.close();
    }
}
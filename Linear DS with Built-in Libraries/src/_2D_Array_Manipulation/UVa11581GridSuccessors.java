////////////////////////////////////////////////////////////////////////////////////////////////////
//
// Source: UVa 11581 - Grid Successors
// Author: Yang, Sichao
// Email:  sichao@cs.wisc.edu
//
////////////////////////////////////////////////////////////////////////////////////////////////////
package _2D_Array_Manipulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;

/**
 * Cellular automaton simulation.
 */
public class UVa11581GridSuccessors {
    private static class io {
        static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        static PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        public static int nextLineInt() throws IOException { return Integer.parseInt(reader.readLine()); }
        public static int nextLineInt(int base) throws IOException { return new BigInteger(reader.readLine(), base).intValue(); }
        public static void close() throws IOException { reader.close(); writer.close(); }
    }
    
    static int f(int g) {
        int r = 0;
        for (int i = 0; i < 9; i++) {
            if (i > 2) r ^= (g & (1 << i - 3)) << 3;     // down   mod 2 plus == xor
            if (i < 6) r ^= (g & (1 << i + 3)) >> 3;     // up
            if (i % 3 > 0) r ^= (g & (1 << i - 1)) << 1; // right
            if (i % 3 < 2) r ^= (g & (1 << i + 1)) >> 1; // left
        }
        return r;
    }
    
    public static void main(String[] args) throws IOException {
        int n = io.nextLineInt();
        while (n-- > 0) {
            io.reader.readLine();
            int g = (io.nextLineInt(2) << 6) + // 876   bitmask
                    (io.nextLineInt(2) << 3) + // 543
                    (io.nextLineInt(2));       // 210
            int k = -1;
            while (g != 0) {
                g = f(g);
                k++;
            }
            io.writer.println(k);
        }
        io.close();
    }
}

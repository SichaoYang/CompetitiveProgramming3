////////////////////////////////////////////////////////////////////////////////////////////////////
//
// Source: UVa 11933 - Splitting Numbers
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
/**
 * Pure bitmask manipulation.
 */
public class UVa11933SplittingNumbers {
    private static class io {
        static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        static PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        public static int nextLineInt() throws IOException { return Integer.parseInt(reader.readLine()); }
        public static void close() throws IOException { reader.close(); writer.close(); }
    }
    
    public static void main(String[] args) throws IOException {
        int n, i, toggle;
        while ((n = io.nextLineInt()) != 0) {
            int[] a = new int[2];
            toggle = 1;
            for (i = 0; n > 0; i++, n >>= 1)
                if ((n & 1) == 1)
                    a[toggle ^= 1] += 1 << i;
           io.writer.println(a[0] + " " + a[1]);
        }
        io.close();
    }
}

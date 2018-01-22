////////////////////////////////////////////////////////////////////////////////////////////////////
//
// Source: UVa 10920 - Spiral Tap
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
import java.util.StringTokenizer;

/**
 * Spiral walk simulation:
 *      13 12 11 10 ↑
 *      14  3  2  9 ↑
 *      15  4  1  8 ↑
 *      16  5  6  7 ↑
 *      17 18 19 -→ ↑
 */
public class UVa10920SpiralTap {
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
        public static long nextLong() { return Long.parseLong(tokenizer.nextToken()); }
        public static void close() throws IOException { reader.close(); writer.close(); }
    }
    
    public static void main(String[] args) throws IOException {
        while (io.nextLine()) {
            long SZ = io.nextLong(), P = io.nextLong(); // long!
            if (P == 0) break;
            long dx = 1, dy = 0, x = SZ / 2 + 1, y = SZ / 2 + 1, p = 1;
            boolean sim = true;
            for (int i = 1; sim; i++)
                for (int j = 0; sim && j < 2; j++) {
                    if (p + i < P) {
                        x += i * dx;
                        y += i * dy;
                        p += i;
                        long temp = dx; dx = dy; dy = -temp; // -pi / 2: [0 1; -1 0][x; y] = [y; -x]
                    } else {
                        io.writer.println("Line = " + (x + (P - p) * dx) + 
                                   ", column = " + (y + (P - p) * dy) + ".");
                        sim = false;
                    }
                }
        }
        io.close();
    }
}

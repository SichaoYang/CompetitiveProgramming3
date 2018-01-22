////////////////////////////////////////////////////////////////////////////////////////////////////
//
// Source: UVa 11926 - Multitasking
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
import java.util.BitSet;
import java.util.StringTokenizer;

/**
 * BitSet intersection detection.
 */
public class UVa11926Multitasking {
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
    
    static final int TIME = 1000000;
    static BitSet calendar = new BitSet(TIME);

    static boolean task(int l, int r) {
        if (calendar.get(l, r).cardinality() > 0) return false;
        calendar.set(l, r);
        return true;
    }
    
    static boolean multitask(int n, int m) throws IOException {
        while (n-- > 0 && io.nextLine()) {
            int l = io.nextInt(), r = io.nextInt();
            if (!task(l, r)) {
                for (n += m; n-- > 0;) io.reader.readLine(); // Tricky point: input may be unfinished!
                return false;
            }
        }
        while (m-- > 0 && io.nextLine()) {
            int l = io.nextInt(), r = io.nextInt(), i = io.nextInt();
            for (int j = 0; l + j < TIME; j += i) // Tricky point: right boundary can exceed limit!
                if (!task(l + j, Math.min(r + j, TIME))) {
                    while (m-- > 0) io.reader.readLine();
                    return false;
                }
        }
        return true;
    }
    
    public static void main(String[] args) throws IOException {
        while (io.nextLine()) {
            int n = io.nextInt(), m = io.nextInt();
            if (n == 0 && m == 0) break;
            calendar.clear();
            if (multitask(n, m)) io.writer.println("NO CONFLICT");
            else io.writer.println("CONFLICT");
        }
        io.close();
    }
}

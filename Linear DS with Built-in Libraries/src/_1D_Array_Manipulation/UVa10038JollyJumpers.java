////////////////////////////////////////////////////////////////////////////////////////////////////
//
// Source: UVa 10038 - Jolly Jumpers
// Author: Yang, Sichao
// Email:  sichao@cs.wisc.edu
//
////////////////////////////////////////////////////////////////////////////////////////////////////
package _1D_Array_Manipulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.BitSet;
import java.util.StringTokenizer;

/**
 * Difference sequence and mapping.
 */
public class UVa10038JollyJumpers {
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
    
    public static boolean isJolly() {
        int n = io.nextInt(), iOld = io.nextInt(), iNew;
        BitSet bitSet = new BitSet(n - 1);
        for (int i = 1; i < n; i++) {
            iNew = io.nextInt();
            int iDif = Math.abs(iNew - iOld) - 1;
            if (iDif < 0 || iDif >= n || bitSet.get(iDif)) return false;
            bitSet.set(iDif);
            iOld = iNew;
        }
        return true;
    }
    
    public static void main(String[] args) throws IOException {
        while (io.nextLine()) System.out.println(isJolly() ? "Jolly" : "Not jolly");
        io.close();
    }
}

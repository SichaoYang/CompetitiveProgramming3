////////////////////////////////////////////////////////////////////////////////////////////////////
//
// Source: UVa 11849 - CD
// Author: Yang, Sichao
// Email:  sichao@cs.wisc.edu
//
////////////////////////////////////////////////////////////////////////////////////////////////////
package Java_TreeSet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.BitSet;
import java.util.StringTokenizer;

/**
 * Mapping or hashing (DAT).
 */
public class UVa11849CD {
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
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BitSet cds = new BitSet(1000000000);
        while (io.nextLine()) {
            int ans = 0, jack = io.nextInt(), jill = io.nextInt();
            if (jack == 0 && jill == 0) break;
            cds.clear();
            while (jack-- > 0) cds.set(io.nextLineInt());
            while (jill-- > 0) if (cds.get(io.nextLineInt())) ans++;
            io.writer.println(ans);
        }
        io.close();
    }
}
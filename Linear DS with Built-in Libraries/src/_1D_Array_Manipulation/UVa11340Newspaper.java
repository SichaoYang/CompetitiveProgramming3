////////////////////////////////////////////////////////////////////////////////////////////////////
//
// Source: UVa 11340 - Newspaper
// Author: Yang, Sichao
// Email:  sichao@cs.wisc.edu
//
////////////////////////////////////////////////////////////////////////////////////////////////////
//
// Reference: https://www.redgreencode.com/solving-uva-11340-in-java/
//
////////////////////////////////////////////////////////////////////////////////////////////////////
package _1D_Array_Manipulation;

import java.io.*;
import java.util.HashMap;

/**
 * Counting with a direct addressing table.
 */
public class UVa11340Newspaper {
    private static class IO {
        BufferedReader reader;
        PrintWriter writer;
        public IO() throws UnsupportedEncodingException {
            // Tricky point: an 8-bit character encoding is required for this problem.
            reader = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"), 10000);
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        }
        public int nextLineInt() throws IOException { return Integer.parseInt(reader.readLine()); }
        public void close() throws IOException { reader.close(); writer.close(); }
    }
    
    public static void main(String[] args) throws IOException {
        IO io = new IO();
        int N = io.nextLineInt();
        while (N-- > 0) {
            // Hashmap can be slower than a 8-bit-char-indexed int array, but is still O(1) and fast
            // enough for this problem, as the true bottleneck is the input speed.
            HashMap<Character, Integer> map = new HashMap<>();
            int K = io.nextLineInt();
            while (K-- > 0) {
                String line = io.reader.readLine();
                map.put(line.charAt(0), Integer.parseInt(line.substring(2).trim()));
            }
            long value = 0;
            int M = io.nextLineInt();
            while (M-- > 0) {
                String line = io.reader.readLine();
                for (int i = 0; i < line.length(); i++)
                    value += map.getOrDefault(line.charAt(i), 0);
            }
            io.writer.printf("%d.%02d$\n", value / 100, value % 100);
        }
        io.close();
    }
}

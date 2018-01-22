////////////////////////////////////////////////////////////////////////////////////////////////////
//
// Source: UVa 10954 - Add All
// Author: Yang, Sichao
// Email:  sichao@cs.wisc.edu
//
////////////////////////////////////////////////////////////////////////////////////////////////////
package Java_PriorityQueue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Pure priority queue.
 */
public class UVa10954AddAll {
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
        public static int nextLineInt() throws IOException { return Integer.parseInt(reader.readLine()); }
        public static void close() throws IOException { reader.close(); writer.close(); }
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        PriorityQueue<Long> queue = new PriorityQueue<>();
        int n;
        while ((n = io.nextLineInt()) != 0) {
            io.nextLine();
            for (int i = 0; i < n; i++) queue.add(io.nextLong());
            long ans = 0;
            while (queue.size() > 1) {
                long temp = queue.poll() + queue.poll();
                ans += temp;
                queue.add(temp);
            }
            queue.poll(); // Clear the queue.
            io.writer.println(ans);
        }
        io.close();
    }
}

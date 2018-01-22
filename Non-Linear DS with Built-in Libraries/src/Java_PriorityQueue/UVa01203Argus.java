////////////////////////////////////////////////////////////////////////////////////////////////////
//
// Source: UVa 01203 - Argus
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
public class UVa01203Argus {
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
    
    static class Query {
        int num;
        int interval;
        int time;
        
        public Query(int num, int interval) {
            this.num = num;
            time = this.interval = interval;
        }    
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        PriorityQueue<Query> queries = new PriorityQueue<>((q1, q2) -> (q1.time - q2.time) * 3000 + q1.num - q2.num);
        while (io.nextLine() && !io.tokenizer.nextToken().equals("#"))
            queries.add(new Query(io.nextInt(), io.nextInt()));
        int k = io.nextLineInt();
        while (k-- > 0) {
            Query query = queries.poll();
            query.time += query.interval;
            queries.add(query);
            io.writer.println(query.num);
        }
        io.close();
    }
}
////////////////////////////////////////////////////////////////////////////////////////////////////
//
// Source: UVa 01203 - Argus
// Author: Yang, Sichao
// Email:  sichao@cs.wisc.edu
//
////////////////////////////////////////////////////////////////////////////////////////////////////
package Java_PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;

/**
 * Pure priority queue.
 */
public class UVa01203Argus {
    static class Query {
        int num;
        int interval;
        int time;
        
        public Query(int num, int interval) {
            this.num = num;
            time = this.interval = interval;
        }    
    }
    
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter writer = new PrintWriter(System.out);
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        PriorityQueue<Query> queries = new PriorityQueue<>((q1, q2) -> (q1.time - q2.time) * 3000 + q1.num - q2.num);
        String input;
        while (!(input = reader.readLine()).equals("#"))
            queries.add(new Query(Integer.parseInt(input.split(" ")[1]), Integer.parseInt(input.split(" ")[2])));
        int k = Integer.parseInt(reader.readLine());
        while (k-- > 0) {
            Query query = queries.poll();
            query.time += query.interval;
            queries.add(query);
            writer.println(query.num);
        }
        reader.close();
        writer.close();
    }
}
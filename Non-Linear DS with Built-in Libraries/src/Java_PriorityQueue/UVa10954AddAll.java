////////////////////////////////////////////////////////////////////////////////////////////////////
//
// Source: UVa 10954 - Add All
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
import java.util.StringTokenizer;

/**
 * Pure priority queue.
 */
public class UVa10954AddAll {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter writer = new PrintWriter(System.out);
    public static void main(String[] args) throws NumberFormatException, IOException {
        PriorityQueue<Long> queue = new PriorityQueue<>();
        int n;
        while ((n = Integer.parseInt(reader.readLine())) != 0) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            for (int i = 0; i < n; i++) queue.add(Long.parseLong(tokenizer.nextToken()));
            long ans = 0;
            while (queue.size() > 1) {
                long temp = queue.poll() + queue.poll();
                ans += temp;
                queue.add(temp);
            }
            queue.poll(); // Clear the queue.
            writer.println(ans);
        }
        reader.close();
        writer.close();
    }
}

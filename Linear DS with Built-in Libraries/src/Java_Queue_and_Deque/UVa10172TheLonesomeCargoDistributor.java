////////////////////////////////////////////////////////////////////////////////////////////////////
//
// Source: UVa 10172 - The Lonesome Cargo Distributor
// Author: Yang, Sichao
// Email:  sichao@cs.wisc.edu
//
////////////////////////////////////////////////////////////////////////////////////////////////////
package Java_Queue_and_Deque;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Simulation with both stacks and queues.
 */
public class UVa10172TheLonesomeCargoDistributor {
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
    
    @SuppressWarnings("serial")
    static class Queue extends LinkedList<Integer> {} // Java does not support generic arrays.
    
    public static void main(String[] args) throws IOException {
        int SET = io.nextLineInt();
        while (SET-- > 0 && io.nextLine()) {
            int t = 0, r = 0, N = io.nextInt(), S = io.nextInt(), Q = io.nextInt();
            Stack<Integer> stack = new Stack<>();
            Queue[] queues = new Queue[100];
            for (int i = 0; i < N && io.nextLine(); i++) {
                int Qi = io.nextInt();
                r += Qi;
                queues[i] = new Queue();
                while (Qi-- > 0) queues[i].add(io.nextInt() - 1);
            }
            for (int i = 0;; t += 2, i = (i + 1) % N) {
                while (!stack.isEmpty()) {
                    if (stack.peek() == i) {
                        stack.pop();
                        r--;
                        t++;
                    } else if (queues[i].size() < Q) {
                        queues[i].add(stack.pop());
                        t++;
                    } else break;               
                }
                while (!queues[i].isEmpty() && stack.size() < S) {
                    stack.add(queues[i].poll());
                    t++;
                }
                if (r == 0) break;
            }
            io.writer.println(t);
        }
        io.close();
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////////
//
// Source: UVa 11995 - I Can Guess the Data Structure!
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
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Simulation with a stack, queue and priority queue.
 */
public class Uva11995ICanGuessTheDataStructure {
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
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        Stack<Integer> stack = new Stack<>();
        LinkedList<Integer> queue = new LinkedList<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((i, j) -> j - i);
        while (io.nextLine()) {
            int n = io.nextInt();
            stack.clear(); queue.clear(); priorityQueue.clear();
            boolean isStack = true, isQueue = true, isPriorityQueue = true;
            while (n-- > 0 && io.nextLine()) {
                int op = io.nextInt(), val = io.nextInt();
                if (op == 1) {
                    stack.add(val); queue.add(val); priorityQueue.add(val);
                } else { // 2 can appear before 1, which results in the answer "impossible".
                    if (stack.isEmpty() || stack.pop() != val) isStack = false;
                    if (queue.isEmpty() || queue.poll() != val) isQueue = false;
                    if (priorityQueue.isEmpty() || priorityQueue.poll() != val) isPriorityQueue = false;
                }
            }
            switch ((isStack ? 4 : 0) + (isQueue ? 2 : 0) + (isPriorityQueue ? 1 : 0)) {
                case 0: io.writer.println("impossible"); break;
                case 1: io.writer.println("priority queue"); break;
                case 2: io.writer.println("queue"); break;
                case 4: io.writer.println("stack"); break;
                default: io.writer.println("not sure"); break;
            }
        }
        io.close();
    }
}
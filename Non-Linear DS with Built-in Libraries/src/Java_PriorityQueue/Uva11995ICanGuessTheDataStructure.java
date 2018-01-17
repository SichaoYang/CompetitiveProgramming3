////////////////////////////////////////////////////////////////////////////////////////////////////
//
// Source: UVa 11995 - I Can Guess the Data Structure!
// Author: Yang, Sichao
// Email:  sichao@cs.wisc.edu
//
////////////////////////////////////////////////////////////////////////////////////////////////////
package Java_PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Simulation with a stack, queue and priority queue.
 */
public class Uva11995ICanGuessTheDataStructure {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter writer = new PrintWriter(System.out);
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        String N;
        Stack<Integer> stack = new Stack<>();
        LinkedList<Integer> queue = new LinkedList<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((i, j) -> j - i);
        while ((N = reader.readLine()) != null) {
            int n = Integer.parseInt(N);
            stack.clear(); queue.clear(); priorityQueue.clear();
            boolean isStack = true, isQueue = true, isPriorityQueue = true;
            while (n-- > 0) {
                String[] input = reader.readLine().split(" ");
                int op = Integer.parseInt(input[0]), val = Integer.parseInt(input[1]);
                if (op == 1) {
                    stack.add(val); queue.add(val); priorityQueue.add(val);
                } else { // 2 can appear before 1, which results in the answer "impossible".
                    if (stack.isEmpty() || stack.pop() != val) isStack = false;
                    if (queue.isEmpty() || queue.poll() != val) isQueue = false;
                    if (priorityQueue.isEmpty() || priorityQueue.poll() != val) isPriorityQueue = false;
                }
            }
            switch ((isStack ? 4 : 0) + (isQueue ? 2 : 0) + (isPriorityQueue ? 1 : 0)) {
                case 0: writer.println("impossible"); break;
                case 1: writer.println("priority queue"); break;
                case 2: writer.println("queue"); break;
                case 4: writer.println("stack"); break;
                default: writer.println("not sure"); break;
            }
        }
        reader.close();
        writer.close();
    }
}
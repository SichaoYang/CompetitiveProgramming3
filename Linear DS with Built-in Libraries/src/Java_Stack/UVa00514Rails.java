////////////////////////////////////////////////////////////////////////////////////////////////////
//
// Source: UVa 00514 - Rails
// Author: Yang, Sichao
// Email:  sichao@cs.wisc.edu
//
////////////////////////////////////////////////////////////////////////////////////////////////////
package Java_Stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Stack;

/**
 * Simulation with stacks.
 */
public class UVa00514Rails {
    private static class io {
        static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        static PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        public static int nextLineInt() throws IOException { return Integer.parseInt(reader.readLine()); }
        public static void close() throws IOException { reader.close(); writer.close(); }
    }
    
    public static void main(String[] args) throws IOException {
        int n;
        while ((n = io.nextLineInt()) != 0) {
            String input;
            Stack<Integer> stack = new Stack<>();
            while (!(input = io.reader.readLine()).equals("0")) {
                stack.clear();
                int[] reorganization = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
                int i = 0;
                for (int j = 1; j <= n; j++) {
                    stack.add(j);
                    while (!stack.isEmpty() && stack.peek() == reorganization[i]) {
                        stack.pop();
                        i++;
                    }
                }
                if (i == n) io.writer.println("Yes");
                else io.writer.println("No");
            }
            io.writer.println();
        }
        io.close();
    }
}

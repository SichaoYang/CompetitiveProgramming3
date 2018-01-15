////////////////////////////////////////////////////////////////////////////////////////////////////
//
// Source: UVa 00514 - Rails
// Author: Yang, Sichao
// Email:  sichao@cs.wisc.edu
//
////////////////////////////////////////////////////////////////////////////////////////////////////
package Java_Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Stack;

/**
 * Simulation with stacks.
 */
public class UVa00514Rails {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        int n;
        while ((n = Integer.parseInt(reader.readLine())) != 0) {
            String input;
            Stack<Integer> stack = new Stack<>();
            while (!(input = reader.readLine()).equals("0")) {
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
                if (i == n) writer.println("Yes");
                else writer.println("No");
            }
            writer.println();
        }
        reader.close();
        writer.close();
    }
}
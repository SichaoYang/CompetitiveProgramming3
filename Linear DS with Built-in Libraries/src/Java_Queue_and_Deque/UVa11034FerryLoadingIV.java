////////////////////////////////////////////////////////////////////////////////////////////////////
//
// Source: UVa 11034 - Ferry Loading IV
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
import java.util.StringTokenizer;

/**
 * Simulation with queues.
 */
public class UVa11034FerryLoadingIV {
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
    
    public static void main(String[] args) throws IOException {
        int c = io.nextLineInt();
        while (c-- > 0 && io.nextLine()) {
            int T = 0, l = io.nextInt() * 100, m = io.nextInt();
            LinkedList<Integer> left = new LinkedList<>(), right = new LinkedList<>();
            while (m-- > 0 && io.nextLine()) {
                int car = io.nextInt();
                (io.tokenizer.nextToken().equals("left") ? left : right).add(car);
            }
            boolean onLeft = true;
            while (!left.isEmpty() || !right.isEmpty()) {
                LinkedList<Integer> side = onLeft ? left : right;
                for (int L = l; !side.isEmpty() && L > side.peek(); L -= side.pop());
                T++;
                onLeft = !onLeft;
            }
            io.writer.println(T);
        }
        io.close();
    }
}
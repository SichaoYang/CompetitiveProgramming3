////////////////////////////////////////////////////////////////////////////////////////////////////
//
// Source: UVa 00978 - Lemmings Battle
// Author: Yang, Sichao
// Email:  sichao@cs.wisc.edu
//
////////////////////////////////////////////////////////////////////////////////////////////////////
package Java_TreeSet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Simulation with multisets or priority queues.
 */
public class UVa00978LemmingsBattle {
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
    
    static int B, SG, SB;
    static PriorityQueue<Integer> green = new PriorityQueue<>((i, j) -> j - i);
    static PriorityQueue<Integer> blue = new PriorityQueue<>((i, j) -> j - i);
    static int[] remains = new int[100000]; // buffer 
    
    static void init() throws NumberFormatException, IOException {
        io.nextLine();
        B = io.nextInt(); SG = io.nextInt(); SB = io.nextInt();
        green.clear();
        blue.clear();
        for (int i = 0; i < SG; i++) green.add(io.nextLineInt());
        for (int i = 0; i < SB; i++) blue.add(io.nextLineInt());
    }
    
    static void solve() {
        while (!green.isEmpty() && !blue.isEmpty()) {
            for (int i = 0; i < B; i++)
                remains[i] = (green.isEmpty() ? 0 : green.poll()) - (blue.isEmpty() ? 0 : blue.poll());
            for (int i = 0; i < B; i++)
                if (remains[i] > 0) green.add(remains[i]);
                else if (remains[i] < 0) blue.add(-remains[i]);
        }
        io.writer.println(!green.isEmpty() ? "green wins" : !blue.isEmpty() ? "blue wins" : "green and blue died");
        while (!green.isEmpty()) io.writer.println(green.poll());
        while (!blue.isEmpty()) io.writer.println(blue.poll());
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        int N = io.nextLineInt();
        while (N-- > 0) {
            init();
            solve();
            if (N > 0) io.writer.println();
        }
        io.close();
    }
}
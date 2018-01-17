////////////////////////////////////////////////////////////////////////////////////////////////////
//
// Source: UVa 00978 - Lemmings Battle
// Author: Yang, Sichao
// Email:  sichao@cs.wisc.edu
//
////////////////////////////////////////////////////////////////////////////////////////////////////
package Java_TreeSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Simulation with multisets or priority queues.
 */
public class UVa00978LemmingsBattle {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter writer = new PrintWriter(System.out);
    static int B, SG, SB;
    static PriorityQueue<Integer> green = new PriorityQueue<>((i, j) -> j - i);
    static PriorityQueue<Integer> blue = new PriorityQueue<>((i, j) -> j - i);
    static int[] remains = new int[100000]; // buffer 
    
    static int readInt() throws NumberFormatException, IOException {
        return Integer.parseInt(reader.readLine().trim());
    }
    
    static void init() throws NumberFormatException, IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        B = Integer.parseInt(tokenizer.nextToken());
        SG = Integer.parseInt(tokenizer.nextToken());
        SB = Integer.parseInt(tokenizer.nextToken());
        green.clear();
        blue.clear();
        for (int i = 0; i < SG; i++) green.add(readInt());
        for (int i = 0; i < SB; i++) blue.add(readInt());
    }
    
    static void solve() {
        while (!green.isEmpty() && !blue.isEmpty()) {
            for (int i = 0; i < B; i++)
                remains[i] = (green.isEmpty() ? 0 : green.poll()) - (blue.isEmpty() ? 0 : blue.poll());
            for (int i = 0; i < B; i++)
                if (remains[i] > 0) green.add(remains[i]);
                else if (remains[i] < 0) blue.add(-remains[i]);
        }
        if (!green.isEmpty()) {
            writer.println("green wins");
            while (!green.isEmpty()) writer.println(green.poll());
        } else if (!blue.isEmpty()) {
            writer.println("blue wins");
            while (!blue.isEmpty()) writer.println(blue.poll());
        } else writer.println("green and blue died");
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        int N = readInt();
        while (N-- > 0) {
            init();
            solve();
            if (N > 0) writer.println();
        }
        reader.close();
        writer.close();
    }
}
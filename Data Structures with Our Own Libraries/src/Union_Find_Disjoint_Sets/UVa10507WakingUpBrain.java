////////////////////////////////////////////////////////////////////////////////////////////////////
//
// Source: UVa 10507 - Waking up brain
// Author: Yang, Sichao
// Email:  sichao@cs.wisc.edu
//
////////////////////////////////////////////////////////////////////////////////////////////////////
package Union_Find_Disjoint_Sets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Simulation with priority queues. I do not know how to use UFDS to simplify this problem.
 */
public class UVa10507WakingUpBrain {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        TreeMap<Character, TreeSet<Character>> g = new TreeMap<>();
        int[] w = new int[26], t = new int[26];
        while (true) {
            g.clear();
            int n = Integer.parseInt(reader.readLine()), m = Integer.parseInt(reader.readLine());
            String waken = reader.readLine();
            while (m-- > 0) {
                String input = reader.readLine();
                char src = input.charAt(0), dst = input.charAt(1);
                if (!g.containsKey(src)) g.put(src, new TreeSet<>());
                g.get(src).add(dst);
                if (!g.containsKey(dst)) g.put(dst, new TreeSet<>());
                g.get(dst).add(src);
            }
            for (Character ch : g.keySet()) {
                w[ch - 'A'] = 0;
                t[ch - 'A'] = Integer.MAX_VALUE;
            }
            for (int i = 0; i < 3; i++) {
                if (g.get(waken.charAt(i)) == null) g.put(waken.charAt(i), new TreeSet<>());
                w[waken.charAt(i) - 'A'] = 3;
                t[waken.charAt(i) - 'A'] = 0;
            }
            PriorityQueue<Character> queue = new PriorityQueue<>((c1, c2) -> t[c1 - 'A'] - t[c2 - 'A']);
            for (Character src : g.keySet()) queue.add(src); 
            char src = '-';
            int counter = 0;
            while (!queue.isEmpty() && w[queue.peek() - 'A'] >= 3) {
                counter++;
                src = queue.poll();
                for (Character dst : g.get(src))
                    if (++w[dst - 'A'] == 3) {
                        t[dst - 'A'] = t[src - 'A'] + 1;
                        queue.remove(dst);
                        queue.add(dst);
                    }
            }
            if (counter == n) writer.println("WAKE UP IN, " + t[src - 'A'] + ", YEARS");
            else writer.println("THIS BRAIN NEVER WAKES UP");
            if (reader.readLine() == null) break;
        }
        reader.close();
        writer.close();
    }
}

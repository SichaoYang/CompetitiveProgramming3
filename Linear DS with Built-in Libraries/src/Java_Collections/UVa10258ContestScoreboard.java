////////////////////////////////////////////////////////////////////////////////////////////////////
//
// Source: UVa 10258 - Contest Scoreboard
// Author: Yang, Sichao
// Email:  sichao@cs.wisc.edu
//
////////////////////////////////////////////////////////////////////////////////////////////////////
package Java_Collections;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * Sorting.
 */

public class UVa10258ContestScoreboard {
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
    
    static class Contestant {
        int number;
        BitSet AC = new BitSet(10);
        int[] time = new int[10];
        
        public Contestant(int number) {
            this.number = number;
        }
        
        int penalty() {
            int total = 0;
            for (int i = 1; i <= 9; i++) if (AC.get(i)) total += time[i];
            return total;
        }
        
        @Override
        public String toString() {
            return String.format("%d %d %d", number, AC.cardinality(), penalty());
        }
    }
    
    public static void main(String[] args) throws IOException {
        int n = io.nextLineInt();
        io.reader.readLine();
        while (n-- > 0) {
            Contestant[] hash = new Contestant[101];
            ArrayList<Contestant> contestants = new ArrayList<>();
            while (true) {
                if (!io.nextLine() || !io.tokenizer.hasMoreTokens()) break;
                int contestant = io.nextInt(), problem = io.nextInt(), time = io.nextInt();
                String L = io.tokenizer.nextToken();
                if (hash[contestant] == null)
                    contestants.add(hash[contestant] = new Contestant(contestant));
                if (!hash[contestant].AC.get(problem)) {
                    if (L.equals("I"))
                        hash[contestant].time[problem] += 20;
                    if (L.equals("C")) {
                        hash[contestant].AC.set(problem);
                        hash[contestant].time[problem] += time;
                    }
                }
            }
            Collections.sort(contestants, (c1, c2) ->
                    Integer.signum(-Integer.compare(c1.AC.cardinality(), c2.AC.cardinality())) * 4 + 
                    Integer.signum(Integer.compare(c1.penalty(), c2.penalty())) * 2 +
                    Integer.signum(Integer.compare(c1.number, c2.number))
            );
            for (Contestant contestant : contestants) io.writer.println(contestant);
            if (n > 0) io.writer.println();
        }
        io.close();
    }
}
////////////////////////////////////////////////////////////////////////////////////////////////////
//
// Source: UVa 10258 - Contest Scoreboard
// Author: Yang, Sichao
// Email:  sichao@cs.wisc.edu
//
////////////////////////////////////////////////////////////////////////////////////////////////////
package Java_Collections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * Sorting.
 */
class Contestant {
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

public class UVa10258ContestScoreboard {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        
        int n = Integer.parseInt(reader.readLine());
        reader.readLine();
        while (n-- > 0) {
            Contestant[] hash = new Contestant[101];
            ArrayList<Contestant> contestants = new ArrayList<>();
            while (true) {
                String input = reader.readLine();
                if (input == null || input.isEmpty()) break;
                StringTokenizer tokenizer = new StringTokenizer(input);
                int contestant = Integer.parseInt(tokenizer.nextToken());
                int problem = Integer.parseInt(tokenizer.nextToken());
                int time = Integer.parseInt(tokenizer.nextToken());
                String L = tokenizer.nextToken();
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
            for (Contestant contestant : contestants)
                writer.println(contestant);
            if (n > 0) writer.println();
        }
        
        reader.close();
        writer.close();
    }
}
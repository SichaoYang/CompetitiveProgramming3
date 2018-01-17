////////////////////////////////////////////////////////////////////////////////////////////////////
//
// Source: UVa 11136 - Hoax or what
// Author: Yang, Sichao
// Email:  sichao@cs.wisc.edu
//
////////////////////////////////////////////////////////////////////////////////////////////////////
package Java_TreeSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * Pure multiset.
 */
public class UVa11136HoaxOrWhat {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter writer = new PrintWriter(System.out);
    static TreeSet<Integer> multiset = new TreeSet<>((i, j) ->  i < j ? -1 : 1);
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        int n;
        while ((n = Integer.parseInt(reader.readLine())) > 0) {
            multiset.clear();
            long ans = 0; // 10^6 * 10^5 > 2^31 
            while (n-- > 0) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                int k = Integer.parseInt(tokenizer.nextToken());
                while (k-- > 0) multiset.add(Integer.parseInt(tokenizer.nextToken()));
                ans += multiset.pollLast() - multiset.pollFirst();
            }
            writer.println(ans);
        }
        reader.close();
        writer.close();
    }
}

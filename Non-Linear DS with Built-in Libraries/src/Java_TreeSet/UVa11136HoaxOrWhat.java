////////////////////////////////////////////////////////////////////////////////////////////////////
//
// Source: UVa 11136 - Hoax or what
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
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * Pure multiset.
 */
public class UVa11136HoaxOrWhat {
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
    
    static TreeSet<Integer> multiset = new TreeSet<>((i, j) ->  i < j ? -1 : 1);
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        int n;
        while ((n = io.nextLineInt()) > 0) {
            multiset.clear();
            long ans = 0; // 10^6 * 10^5 > 2^31 
            while (n-- > 0 && io.nextLine()) {
                int k = io.nextInt();
                while (k-- > 0) multiset.add(io.nextInt());
                ans += multiset.pollLast() - multiset.pollFirst();
            }
            io.writer.println(ans);
        }
        io.close();
    }
}

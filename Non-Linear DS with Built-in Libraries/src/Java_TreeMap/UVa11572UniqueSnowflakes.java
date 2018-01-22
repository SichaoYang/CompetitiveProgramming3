////////////////////////////////////////////////////////////////////////////////////////////////////
//
// Source: UVa 11572 - Unique Snowflakes
// Author: Yang, Sichao
// Email:  sichao@cs.wisc.edu
//
////////////////////////////////////////////////////////////////////////////////////////////////////
package Java_TreeMap;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.TreeMap;

/**
 * Two pointers and mapping.
 */
public class UVa11572UniqueSnowflakes {
    private static class io {
        static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        static PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        public static int nextLineInt() throws IOException { return Integer.parseInt(reader.readLine()); }
        public static void close() throws IOException { reader.close(); writer.close(); }
    }
    
    static int n;
    static int[] snowflakes = new int[1000000];
    static TreeMap<Integer, Integer> map = new TreeMap<>();
    
    static void init() throws NumberFormatException, IOException {
        n = io.nextLineInt();
        for (int i = 0; i < n; i++) snowflakes[i] = io.nextLineInt();
        map.clear();
    }
    
    static void solve() {
        int l = 0, ans = 0;
        for (int r = 0; r < n; r++) {
            map.merge(snowflakes[r], 1, Integer::sum);            
            while (map.get(snowflakes[r]) == 2)
                map.replace(snowflakes[l], map.get(snowflakes[l++]) - 1);
            if (r - l + 1 > ans) ans = r - l + 1;
        }
        io.writer.println(ans);
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        int c = io.nextLineInt();
        while (c-- > 0) {
            init();
            solve();
        }
        io.close();
    }
}

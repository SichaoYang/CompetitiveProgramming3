////////////////////////////////////////////////////////////////////////////////////////////////////
//
// Source: UVa 10855 - Rotated Squares
// Author: Yang, Sichao
// Email:  sichao@cs.wisc.edu
//
////////////////////////////////////////////////////////////////////////////////////////////////////
package _2D_Array_Manipulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * Matrix rotation.
 */
public class UVa10855RotatedSquares {
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
        public static void close() throws IOException { reader.close(); writer.close(); }
    }
    
    public static void main(String[] args) throws IOException {
        while (true) {
            io.nextLine();
            int N = io.nextInt(), n = io.nextInt();
            if (N == 0) break;
            char[][] big = new char[N][N];
            char[][] small = new char[n][n];
            for (int i = 0; i < N; i++)
                big[i] = io.reader.readLine().toCharArray();
            for (int i = 0; i < n; i++)
                small[i] = io.reader.readLine().toCharArray();
            int[] times = new int[4];
            for (int t = 0; t < 4; t++)
                for (int R = 0; R <= N - n; R++)
                    for (int C = 0; C <= N - n; C++) {
                        boolean same = true;
                        for (int r = 0; same && r < n; r++)
                            for (int c = 0; same && c < n; c++) {
                                int _r = t == 0 ? r : t == 1 ? n - 1 - c : t == 2 ? n - 1 - r : c;
                                int _c = t == 0 ? c : t == 1 ? r : t == 2 ? n - 1 - c : n - 1 - r;
                                same = small[_r][_c] == big[R + r][C + c];
                            }
                        if (same) times[t]++;
                    }
            io.writer.println(Arrays.stream(times).mapToObj(Integer::toString).collect(Collectors.joining(" ")));
        }
        io.close();
    }
}

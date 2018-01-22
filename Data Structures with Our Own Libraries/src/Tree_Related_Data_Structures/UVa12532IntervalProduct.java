////////////////////////////////////////////////////////////////////////////////////////////////////
//
// Source: UVa 12532 - Interval Product
// Author: Yang, Sichao
// Email:  sichao@cs.wisc.edu
//
////////////////////////////////////////////////////////////////////////////////////////////////////
package Tree_Related_Data_Structures;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class UVa12532IntervalProduct {
    @SuppressWarnings("unused")
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
        public static long nextLong() { return Long.parseLong(tokenizer.nextToken()); }
        public static int nextLineInt() throws IOException { return Integer.parseInt(reader.readLine()); }
        public static void close() throws IOException { reader.close(); writer.close(); }
    }
    
    private static class FenwickTree {
        private int[] ft;
        
        public FenwickTree(int n) { ft = new int[n + 1]; }
        
        public int rsq(int a, int b) { return rsq(b) - rsq(a - 1); }
        
        public void adjust(int key, int increment) {
            for (; key < ft.length; key += (key & -key)) ft[key] += increment;
        }
        
        private int rsq(int b) {
            int sum = 0;
            for (; b > 0; b -= (b & -b)) sum += ft[b];
            return sum;
        }
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        int[] elems = new int[100001];
        while (io.nextLine()) {
            int n = io.nextInt(), k = io.nextInt();
            FenwickTree zeros = new FenwickTree(n);
            FenwickTree minus = new FenwickTree(n);
            io.nextLine();
            for (int key = 1; key <= n; key++) {
                int val = elems[key] = Integer.signum(io.nextInt());
                if (val == 0) zeros.adjust(key, 1);
                else if (val < 0) minus.adjust(key, 1);
            }
            while (k-- > 0 && io.nextLine()) {
                if (io.tokenizer.nextToken().equals("C")) {
                    int key = io.nextInt(), val = Integer.signum(io.nextInt());
                    if (elems[key] == val) continue;
                    else if (elems[key] == 0) zeros.adjust(key, -1);
                    else if (val == 0) zeros.adjust(key, 1);
                    else if (elems[key] < 0) minus.adjust(key, -1);
                    else if (val < 0) minus.adjust(key, 1);
                    elems[key] = val;
                } else {
                    int l = io.nextInt(), r = io.nextInt();
                    io.writer.print(zeros.rsq(l, r) > 0 ? "0" : (minus.rsq(l, r) & 1) == 1 ? "-" : "+");
                }
            }
            io.writer.println();
        }
        io.close();
    }
}

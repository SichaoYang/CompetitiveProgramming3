////////////////////////////////////////////////////////////////////////////////////////////////////
//
// Source: 
// Author: Yang, Sichao
// Email:  sichao@cs.wisc.edu
//
////////////////////////////////////////////////////////////////////////////////////////////////////

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Template {
    @SuppressWarnings("unused")
    private static class io {
        static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        static PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        static StringTokenizer tokenizer;
        public static boolean nextLine() throws IOException {
            String input = reader.readLine();
            if (input == null || input.isEmpty()) return false;
            tokenizer = new StringTokenizer(input);
            return true;
        }
        public static int nextInt() { return Integer.parseInt(tokenizer.nextToken()); }
        public static long nextLong() { return Long.parseLong(tokenizer.nextToken()); }
        public static int nextLineInt() throws IOException { return Integer.parseInt(reader.readLine()); }
        public static void close() throws IOException { reader.close(); writer.close(); }
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        while (io.nextLine()) {
            int n = io.nextInt();
        }
        io.close();
    }
}
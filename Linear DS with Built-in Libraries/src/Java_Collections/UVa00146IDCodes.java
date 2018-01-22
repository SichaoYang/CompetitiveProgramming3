////////////////////////////////////////////////////////////////////////////////////////////////////
//
// Source: UVa 00146 - ID Codes
// Author: Yang, Sichao
// Email: sichao@cs.wisc.edu
//
////////////////////////////////////////////////////////////////////////////////////////////////////
package Java_Collections;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * Next permutation.
 */
public class UVa00146IDCodes {
    private static class io {
        static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        static PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        public static void close() throws IOException { reader.close(); writer.close(); }
    }
    
    static String next_permutation(String string) {
        if (string.length() < 2) return "No Successor"; // Edge condition!
        int i = string.length() - 2, j = string.length() - 1;
        while (string.charAt(i) >= string.charAt(i + 1)) // Descending order
            if (i-- == 0) return "No Successor";
        while (string.charAt(i) >= string.charAt(j)) j--;
        StringBuilder builder = new StringBuilder(string);
        builder.setCharAt(i, string.charAt(j));
        builder.setCharAt(j, string.charAt(i));
        return builder.substring(0, i + 1) + builder.reverse().substring(0, string.length() - i - 1);
    }
    
    public static void main(String[] args) throws IOException {
        while (true) {
            String input = io.reader.readLine();
            if (input.equals("#")) break;
            io.writer.println(next_permutation(input));
        }
        io.close();
    }
}

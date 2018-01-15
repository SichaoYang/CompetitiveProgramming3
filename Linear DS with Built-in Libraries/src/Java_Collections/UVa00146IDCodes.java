////////////////////////////////////////////////////////////////////////////////////////////////////
//
// Source: UVa 00146 - ID Codes
// Author: Yang, Sichao
// Email: sichao@cs.wisc.edu
//
////////////////////////////////////////////////////////////////////////////////////////////////////
package Java_Collections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Next permutation.
 */
public class UVa00146IDCodes {
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
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        while (true) {
            String input = reader.readLine();
            if (input.equals("#")) break;
            writer.println(next_permutation(input));
        }
        reader.close();
        writer.close();
    }
}

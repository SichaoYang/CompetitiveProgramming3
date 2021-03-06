////////////////////////////////////////////////////////////////////////////////////////////////////
//
// Source: UVa 01062 - Containers
// Author: Yang, Sichao
// Email:  sichao@cs.wisc.edu
//
////////////////////////////////////////////////////////////////////////////////////////////////////
package Java_Stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * LIS. But the book author has figured out an O(n) solution, and I have not gotten it yet.
 */
public class UVa01062Containers {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    
    public static void main(String[] args) throws IOException {
        int index = 1;
        String input;
        while (!(input = reader.readLine()).equals("end")) {
            char[] array = input.toCharArray();
            int max = 0, n = array.length;
            int[] dp = new int[n];
            for (int i = 1; i < n; i++)
                for (int j = 0; j < i; j++)
                    if (array[j] < array[i] && dp[j] + 1 > dp[i]) dp[i] = dp[j] + 1;
            for (Integer len : dp) if (len > max) max = len;
            writer.println("Case " + index++ + ": " + (max + 1));
        }
        reader.close();
        writer.close();
    }
}

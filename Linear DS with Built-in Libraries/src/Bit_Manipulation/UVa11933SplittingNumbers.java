////////////////////////////////////////////////////////////////////////////////////////////////////
//
// Source: UVa 11933 - Splitting Numbers
// Author: Yang, Sichao
// Email:  sichao@cs.wisc.edu
//
////////////////////////////////////////////////////////////////////////////////////////////////////
package Bit_Manipulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * Pure bitmask manipulation.
 */
public class UVa11933SplittingNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n, i, toggle;
        while ((n = Integer.parseInt(reader.readLine())) != 0) {
            int[] a = new int[2];
            toggle = 1;
            for (i = 0; n > 0; i++, n >>= 1)
                if ((n & 1) == 1)
                    a[toggle ^= 1] += 1 << i;
            System.out.println(a[0] + " " + a[1]);
        }
        reader.close();
    }
}

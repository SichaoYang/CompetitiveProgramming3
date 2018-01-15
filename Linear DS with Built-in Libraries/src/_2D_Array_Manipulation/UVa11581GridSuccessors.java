////////////////////////////////////////////////////////////////////////////////////////////////////
//
// Source: UVa 11581 - Grid Successors
// Author: Yang, Sichao
// Email:  sichao@cs.wisc.edu
//
////////////////////////////////////////////////////////////////////////////////////////////////////
package _2D_Array_Manipulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Cellular automaton simulation.
 */
public class UVa11581GridSuccessors {    
    static int f(int g) {
        int r = 0;
        for (int i = 0; i < 9; i++) {
            if (i > 2) r ^= (g & (1 << i - 3)) << 3;     // down   mod 2 plus == xor
            if (i < 6) r ^= (g & (1 << i + 3)) >> 3;     // up
            if (i % 3 > 0) r ^= (g & (1 << i - 1)) << 1; // right
            if (i % 3 < 2) r ^= (g & (1 << i + 1)) >> 1; // left
        }
        return r;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        while (n-- > 0) {
            reader.readLine();
            int g = (new BigInteger(reader.readLine(), 2).intValue() << 6) + // 876   bitmask
                    (new BigInteger(reader.readLine(), 2).intValue() << 3) + // 543
                    (new BigInteger(reader.readLine(), 2).intValue());       // 210
            int k = -1;
            while (g != 0) {
                g = f(g);
                k++;
            }
            System.out.println(k);
        }
        reader.close();
    }
}

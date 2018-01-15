////////////////////////////////////////////////////////////////////////////////////////////////////
//
// Source: UVa 11926 - Multitasking
// Author: Yang, Sichao
// Email:  sichao@cs.wisc.edu
//
////////////////////////////////////////////////////////////////////////////////////////////////////
package Bit_Manipulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;

/**
 * BitSet intersection detection.
 */
public class UVa11926Multitasking {
    static final int TIME = 1000000;
    static BitSet calendar = new BitSet(TIME);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    
    static boolean task(int l, int r) {
        if (calendar.get(l, r).cardinality() > 0) return false;
        calendar.set(l, r);
        return true;
    }
    
    static boolean multitask(int n, int m) throws IOException {
        while (n-- > 0) {
            String[] input = reader.readLine().split(" ");
            int l = Integer.parseInt(input[0]), r = Integer.parseInt(input[1]);
            if (!task(l, r)) {
                for (n += m; n-- > 0;) reader.readLine(); // Tricky point: input may be unfinished!
                return false;
            }
        }
        while (m-- > 0) {
            String[] input = reader.readLine().split(" ");
            int l = Integer.parseInt(input[0]), r = Integer.parseInt(input[1]), i = Integer.parseInt(input[2]);
            for (int j = 0; l + j < TIME; j += i) // Tricky point: right boundary can exceed limit!
                if (!task(l + j, Math.min(r + j, TIME))) {
                    while (m-- > 0) reader.readLine();
                    return false;
                }
        }
        return true;
    }
    
    public static void main(String[] args) throws IOException {
        while (true) {
            String[] input = reader.readLine().split(" ");
            int n = Integer.parseInt(input[0]), m = Integer.parseInt(input[1]);
            if (n == 0 && m == 0) break;
            calendar.clear();
            if (multitask(n, m)) System.out.println("NO CONFLICT");
            else System.out.println("CONFLICT");
        }
        reader.close();
    }
}

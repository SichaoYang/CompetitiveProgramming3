////////////////////////////////////////////////////////////////////////////////////////////////////
//
// Source: UVa 10264 - The Most Potent Corner
// Author: Yang, Sichao
// Email:  sichao@cs.wisc.edu
//
////////////////////////////////////////////////////////////////////////////////////////////////////
package Bit_Manipulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Bit toggle. Can be combined with BFS. 
 */
public class UVa10264TheMostPotentCorner {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input = reader.readLine()) != null) {
            int N = Integer.parseInt(input), n = 1 << N;
            short[] weights = new short[n], potencies = new short[n];
            int m = 0;
            for (int i = 0; i < n; i++)
                weights[i] = Short.parseShort(reader.readLine());
            for (int i = 0; i < n; i++)
                for (int sh = 0; sh < N; sh++)
                    potencies[i] += weights[i ^ (1 << sh)];
            for (int i = 0; i < n; i++)
                for (int sh = 0; sh < N; sh++) {
                    int sum = potencies[i] + potencies[i ^ (1 << sh)];
                    if (sum > m) m = sum;
                }
            System.out.println(m);
        }
        reader.close();
    }
}

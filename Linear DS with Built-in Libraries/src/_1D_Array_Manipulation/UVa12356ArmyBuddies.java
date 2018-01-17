////////////////////////////////////////////////////////////////////////////////////////////////////
//
// Source: UVa 12356 - Army Buddies
// Author: Yang, Sichao
// Email: sichao@cs.wisc.edu
//
////////////////////////////////////////////////////////////////////////////////////////////////////
package _1D_Array_Manipulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Linked list in direct addressing tables.
 */
public class UVa12356ArmyBuddies {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        int[] l = new int[100000]; // first alive soldier to the left
        int[] r = new int[100000]; // first alive soldier to the right
        while (true) {
            String[] SB = reader.readLine().split(" ");
            int S = Integer.parseInt(SB[0]), B = Integer.parseInt(SB[1]);
            if (S == 0) break;
            for (int i = 0; i < S; i++) {
                l[i] = i - 1;
                r[i] = i + 1;
            }
            while (B-- > 0) {
                String[] LR = reader.readLine().split(" ");
                int L = Integer.parseInt(LR[0]) - 1, R = Integer.parseInt(LR[1]) - 1;
                if (l[L] >= 0) {
                    r[l[L]] = r[R];
                    writer.print(l[L] + 1);
                } else writer.print("*");
                writer.print(" ");
                if (r[R] < S) {
                    l[r[R]] = l[L];
                    writer.print(r[R] + 1);
                } else writer.print("*");
                writer.println();
            }
            writer.println("-");
        }
        reader.close();
        writer.close();
    }
}
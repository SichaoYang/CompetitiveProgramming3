////////////////////////////////////////////////////////////////////////////////////////////////////
//
// Source: UVa 11849 - CD
// Author: Yang, Sichao
// Email:  sichao@cs.wisc.edu
//
////////////////////////////////////////////////////////////////////////////////////////////////////
package Java_TreeSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.BitSet;

/**
 * Mapping or hashing (DAT).
 */
public class UVa11849CD {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter writer = new PrintWriter(System.out);
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BitSet cds = new BitSet(1000000000);
        String input;
        while (!(input = reader.readLine()).equals("0 0")) {
            int ans = 0, jack = Integer.parseInt(input.split(" ")[0]), jill = Integer.parseInt(input.split(" ")[1]);
            cds.clear();
            while (jack-- > 0) cds.set(Integer.parseInt(reader.readLine()));
            while (jill-- > 0) if (cds.get(Integer.parseInt(reader.readLine()))) ans++;
            writer.println(ans);
        }
        reader.close();
        writer.close();
    }
}
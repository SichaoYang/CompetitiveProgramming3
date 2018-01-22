////////////////////////////////////////////////////////////////////////////////////////////////////
//
// Source: UVa 10226 - Hardwood Species
// Author: Yang, Sichao
// Email:  sichao@cs.wisc.edu
//
////////////////////////////////////////////////////////////////////////////////////////////////////
package Java_TreeMap;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Map;
import java.util.TreeMap;

/**
 * Counting by mapping. Maybe a trie tree is needed for a larger input size.
 */
public class UVa10226HardwoodSpecies {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        reader.readLine();
        while (n-- > 0) {
            TreeMap<String, Integer> map = new TreeMap<>();
            String key;
            double total = 0;
            while ((key = reader.readLine()) != null && !key.isEmpty()) {
                map.merge(key, 1, Integer::sum);
                total++;
            }
            for (Map.Entry<String, Integer> entry : map.entrySet())
                writer.printf("%s %.4f\n", entry.getKey(), 100 * entry.getValue() / total);
            if (n > 0) writer.println();
        }
        
        reader.close();
        writer.close();
    }
}

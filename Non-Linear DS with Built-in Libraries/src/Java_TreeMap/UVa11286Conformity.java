////////////////////////////////////////////////////////////////////////////////////////////////////
//
// Source: UVa 11286 - Conformity
// Author: Yang, Sichao
// Email:  sichao@cs.wisc.edu
//
////////////////////////////////////////////////////////////////////////////////////////////////////
package Java_TreeMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeMap;

/**
 * Counting by mapping.
 */
public class UVa11286Conformity {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        
        int n;
        while ((n = Integer.parseInt(reader.readLine())) != 0) {
            TreeMap<String, Integer> map = new TreeMap<>(); // Arrays cannot be keys.
            int[][] students = new int[n][5];
            for (int i = 0; i < n; i++) {
                students[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(s -> Integer.parseInt(s) - 100).toArray();
                Arrays.sort(students[i]);
                map.merge(Arrays.toString(students[i]), 1, Integer::sum);
            }
            int prizes = 0, m = Collections.max(map.values()); // Multiple optimal combinations.
            for (int[] student : students) if (map.get(Arrays.toString(student)) == m) prizes++;
            writer.println(prizes);
        }
        
        reader.close();
        writer.close();
    }
}
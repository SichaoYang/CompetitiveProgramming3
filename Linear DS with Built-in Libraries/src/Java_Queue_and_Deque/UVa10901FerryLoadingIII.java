////////////////////////////////////////////////////////////////////////////////////////////////////
//
// Source: UVa 10901 - Ferry Loading III
// Author: Yang, Sichao
// Email:  sichao@cs.wisc.edu
//
////////////////////////////////////////////////////////////////////////////////////////////////////
package Java_Queue_and_Deque;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Simulation with queues.
 */
public class UVa10901FerryLoadingIII {
    private static class io {
        static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        static PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        static StringTokenizer tokenizer;
        public static boolean nextLine() throws IOException {
            String input = reader.readLine();
            if (input == null) return false;
            tokenizer = new StringTokenizer(input);
            return true;
        }
        public static int nextInt() { return Integer.parseInt(tokenizer.nextToken()); }
        public static int nextLineInt() throws IOException { return Integer.parseInt(reader.readLine()); }
        public static void close() throws IOException { reader.close(); writer.close(); }
    }
    
    private static class Car {
        static int i;
        int index;
        int time;
        
        public Car(int t) {
            index = i++;
            time = t;
        }
    }
    
    public static void main(String[] args) throws IOException {
        int c = io.nextLineInt();
        while (c-- > 0 && io.nextLine()) {
            int T = 0, n = io.nextInt(), t = io.nextInt(), m = io.nextInt();
            int[] times = new int[m];
            LinkedList<Car> left = new LinkedList<>(), right = new LinkedList<>();
            Car.i = 0;
            while (m-- > 0 && io.nextLine()) {
                Car car = new Car(io.nextInt());
                if (io.tokenizer.nextToken().equals("left")) left.add(car);
                else right.add(car);
            }
            boolean onLeft = true;
            while (!left.isEmpty() || !right.isEmpty()) {
                T = Math.max(T, Math.min(left.isEmpty() ? Integer.MAX_VALUE : left.peek().time,
                                        right.isEmpty() ? Integer.MAX_VALUE : right.peek().time));
                LinkedList<Car> side = onLeft ? left : right;
                for (int i = 0; i < n && !side.isEmpty() && side.peek().time <= T; i++)
                    times[side.poll().index] = T + t;
                T += t;
                onLeft = !onLeft;
            }
            for (Integer time : times) io.writer.println(time);
            if (c > 0) io.writer.println();
        }
        io.close();
    }
}

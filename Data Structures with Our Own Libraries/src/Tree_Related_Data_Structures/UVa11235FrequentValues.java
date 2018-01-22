////////////////////////////////////////////////////////////////////////////////////////////////////
//
// Source: UVa 11235 - Frequent Values
// Author: Yang, Sichao
// Email:  sichao@cs.wisc.edu
//
////////////////////////////////////////////////////////////////////////////////////////////////////
package Tree_Related_Data_Structures;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Range maximum query with asymmetric segment tree.
 */
public class UVa11235FrequentValues {
    private static class io {
        static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        static PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        static StringTokenizer tokenizer;
        public static boolean nextLine() throws IOException {
            String input = reader.readLine();
            tokenizer = new StringTokenizer(input);
            return !input.equals("0");
        }
        public static int nextInt() { return Integer.parseInt(tokenizer.nextToken()); }
        public static void close() throws IOException { reader.close(); writer.close(); }
    }
    
    private static class STNode {
        int l, r, f;
        STNode ls, rs;
        
        public STNode(int l, int r, int f) {
            this.l = l;
            this.r = r;
            this.f = f;
        }
        
        public STNode(int l, int r, int f, STNode ls, STNode rs) {
            this(l, r, f);
            this.ls = ls;
            this.rs = rs;
        }
    }
    
    private static int rmq(STNode seg, int l, int r) {
        if (l > seg.r || r < seg.l) return 0;
        if (l <= seg.l && seg.r <= r) return seg.f;
        if (seg.ls == null) return seg.f - (seg.l < l ? l - seg.l : 0) - (seg.r > r ? seg.r - r : 0);
        return Math.max(rmq(seg.ls, l, r), rmq(seg.rs, l, r));
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        LinkedList<STNode> st = new LinkedList<>(), buffer = new LinkedList<>();
        while (io.nextLine()) {
            st.clear();
            int n = io.nextInt() - 1, q = io.nextInt();
            io.nextLine();
            int l = 1, r = 1, oldv = io.nextInt(), newv;
            while (n-- > 0) {
                if ((newv = io.nextInt()) != oldv) {
                    st.add(new STNode(l, r, r - l + 1));
                    l = r + 1;
                    oldv = newv;
                }
                r++;
            }
            st.add(new STNode(l, r, r - l + 1));
            while (st.size() > 1) {
                buffer.clear();
                while (st.size() > 1) {
                    STNode ls = st.poll(), rs = st.poll();
                    buffer.add(new STNode(ls.l, rs.r, Math.max(ls.f, rs.f), ls, rs));
                }
                if (st.size() > 0) buffer.add(st.poll());
                st.addAll(buffer);
            }
            while (q-- > 0 && io.nextLine()) {
                io.writer.println(rmq(st.peek(), io.nextInt(), io.nextInt()));
            }
        }
        io.close();
    }
}

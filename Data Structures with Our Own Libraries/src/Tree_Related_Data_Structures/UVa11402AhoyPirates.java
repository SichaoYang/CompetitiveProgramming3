////////////////////////////////////////////////////////////////////////////////////////////////////
//
// Source: UVa 11402 - Ahoy, Pirates
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
import java.util.BitSet;
import java.util.StringTokenizer;

/**
 * Segment tree with lazy updates.
 */
public class UVa11402AhoyPirates {
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
    
    static class SegmentTree {
        private int n;
        private BitSet pirates;
        private int[] st;
        private Op[] ops;
        
        private int pr(int p) { return (p - 1) >> 1; }
        private int ls(int p) { return (p << 1) + 1; }
        private int rs(int p) { return (p << 1) + 2; }
        
        private enum Op {
            NON, SET, CLR, INV;
            
            public static Op cmb(Op op1, Op op2) {
                switch (op2) {
                    case NON: return op1;
                    case SET: return SET;
                    case CLR: return CLR;
                    case INV:
                        switch (op1) {
                            case NON: return INV;
                            case SET: return CLR;
                            case CLR: return SET;
                            case INV: return NON;
                        }
                }
                throw new IllegalStateException();
            }
            
            public int calc(int stp, int l, int r) {
                switch (this) {
                    case SET: return r - l + 1;
                    case CLR: return 0;
                    case INV: return r - l + 1 - stp;
                    case NON: return stp;
                }
                throw new IllegalStateException();
            }
        }
        
        public SegmentTree(BitSet pirates, int n) {
            this.pirates = pirates;
            this.n = n;
            st = new int[n << 2];
            ops = new Op[n << 2];
            for (int i = 0; i < n << 2; i++) ops[i] = Op.NON;
            build(0, 0, n - 1);
        }
        
        public void set(int i, int j) { refresh(Op.SET, 0, 0, n - 1, i, j); }
        public void clr(int i, int j) { refresh(Op.CLR, 0, 0, n - 1, i, j); }
        public void inv(int i, int j) { refresh(Op.INV, 0, 0, n - 1, i, j); }
        public int count(int i, int j) { return count(0, 0, n - 1, i, j); }
        
        private void refresh(Op op, int p, int l, int r, int i, int j) {
            if (i > r || j < l) return;
            if (i <= l && r <= j) {
                adjust(p, op.calc(st[p], l, r) - st[p]);
                ops[p] = Op.cmb(ops[p], op);
                return;
            }
            pushDown(p, l, r);
            refresh(op, ls(p), l, (l + r) / 2, i, j);
            refresh(op, rs(p), (l + r) / 2 + 1, r, i, j);
        }
        
        private int count(int p, int l, int r, int i, int j) {
            if (i > r || j < l) return 0;
            if (i <= l && r <= j) return st[p];
            pushDown(p, l, r);
            return count(ls(p), l, (l + r) / 2, i, j) + count(rs(p), (l + r) / 2 + 1, r, i, j);
        }
        
        private void pushDown(int p, int l, int r) {
            st[ls(p)] = ops[p].calc(st[ls(p)], l, (l + r) / 2);
            st[rs(p)] = ops[p].calc(st[rs(p)], (l + r) / 2 + 1, r);
            ops[ls(p)] = Op.cmb(ops[ls(p)], ops[p]);
            ops[rs(p)] = Op.cmb(ops[rs(p)], ops[p]);
            ops[p] = Op.NON;
        }
        
        private void adjust(int p, int v) {
            if (v != 0) for (; p >= 0; p = pr(p)) st[p] += v;
        }
        
        private void build(int p, int l, int r) {
            if (l == r) st[p] = pirates.get(l) ? 1 : 0;
            else {
                build(ls(p), l, (l + r) / 2);
                build(rs(p), (l + r) / 2 + 1, r);
                st[p] = st[ls(p)] + st[rs(p)];
            }
        }
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        int T = io.nextLineInt();
        BitSet pirates = new BitSet(1024000);
        for (int test = 1; test <= T; test++) {
            pirates.clear();
            io.writer.println("Case " + test + ":");
            int M = io.nextLineInt(), index = 0;
            while (M-- > 0) {
                int t = io.nextLineInt();
                String string = io.reader.readLine();
                int c = string.length(), tc = t * c;
                for (int j = 0; j < c; j++)
                    if (string.charAt(j) == '1')
                        for (int i = 0; i < tc; i += c)
                            pirates.set(index + j + i);
                index += tc;
            }
            SegmentTree st = new SegmentTree(pirates, index);
            int Q = io.nextLineInt(), q = 1;
            while (Q-- > 0 && io.nextLine()) {
                String op = io.tokenizer.nextToken();
                int l = io.nextInt(), r = io.nextInt();
                switch (op) {
                    case "F": st.set(l, r); break;
                    case "E": st.clr(l, r); break;
                    case "I": st.inv(l, r); break;
                    case "S": io.writer.println("Q" + q++ + ": " + st.count(l, r));
                }
            }
        }
        io.close();
    }
}

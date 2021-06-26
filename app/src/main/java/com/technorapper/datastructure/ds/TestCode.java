package com.technorapper.datastructure.ds;


import java.util.HashMap;
import java.util.Map;

class TestCode {
    public static int TestCode(int n) {
        int[] d = new int[30];
        int l = 0;
        int p;
        while (n > 0) {
            d[l] = n % 2;
            n /= 2;
            l++;
        }
        for (p = 1; p < l; p++) {
            if (p <= l / 2) {
                boolean ok = true;
                for (int i = 0; i < l - p; i++) {
                    if (d[i] != d[i + p]) {
                        ok = false;
                        break;
                    }
                }
                if (ok) {
                    return p;
                }
            }
        }
        return -1;
    }


    int solution(int n) {
        int[] d = new int[30];
        int l = 0;
        int p;
        while (n > 0) {
            d[l] = n % 2;
            n /= 2;
            l++;
        }
        for (p = 1; p < 1 + l; ++p) {
            if (p <= l / 2) {
            int i;
            boolean ok = true;
            for (i = 0; i < l - p; ++i) {
                if (d[i] != d[i + p]) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                return p;
            }}
        }
        return -1;


    }

    ////Largest M-aligned Subset
    public int solution(int[] A, int M) {
        // write your code in Java SE 8



        if (M <= 1) return A.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : A) {
            int rem = n < 0 ? n % M + M : n % M;
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }
        int res  = 0;
        for (int rem : map.keySet()) {
            res = Math.max(res, map.get(rem));
        }
        return res;
    }
    public static void main(String args[]) {
        // creating a binary tree and entering the nodes
        TestCode(955);
    }
}


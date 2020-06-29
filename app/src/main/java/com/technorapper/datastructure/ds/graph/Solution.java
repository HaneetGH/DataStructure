package com.technorapper.datastructure.ds.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {

        //int[][] judge = {{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}};
        // findJudge(5, judge);
        int[][] paths = {{4, 1}, {4, 2}, {4, 3}, {2, 5}, {1, 2}, {1, 5}};

        System.out.println((Arrays.equals(new int[]{1, 2, 1, 3, 3}, gardenNoAdj(5, paths))));


    }

    public static int findJudge(int N, int[][] trust) {
        int[] indegree = new int[N + 1];
        int[] outdegree = new int[N + 1];

        for (int i = 0; i < trust.length; i++) {
            outdegree[trust[i][0]]++;
            indegree[trust[i][1]]++;
        }

        for (int i = 1; i <= N; i++) {
            System.out.println(indegree[i] + " " + outdegree[i]);
            if (indegree[i] == N - 1 && outdegree[i] == 0) {
                //   return i;
            }
        }

        return -1;
    }

    public static int[] gardenNoAdj(int N, int[][] paths) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] p : paths) {
            adj.get(p[0]).add(p[1]);
            adj.get(p[1]).add(p[0]);
        }
        int[] res = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            int[] colours = new int[5];
            for (int x : adj.get(i)) {
                colours[res[x]] = 1;
            }
            for (int y = 4; y >= 1; y--) {
                if (colours[y] != 1) {
                    res[i] = y;
                }
            }
        }
        return Arrays.copyOfRange(res, 1, res.length);
    }

}

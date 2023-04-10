package com.nichols.dsa.graphs;

import java.util.ArrayList;
import java.util.HashMap;

public class ConstructRoads {
    static long m = 0;
    static long n = 0;

    static int getColor(int i) {
        if (i == 0) return 1;
        if (i == 1) return 2;
        if (i == 2) return 1;
        return 0;
    }

    static void dfs(HashMap<Integer, ArrayList<Integer>> adj_list, HashMap<Integer, Integer> visited, int node, int color) {
        visited.put(node, color);
        if (color == 1) m++;
        if (color == 2) n++;
        if (!adj_list.containsKey(node)) return;
        for (int i = 0; i < adj_list.get(node).size(); i++) {
            int neighbor = adj_list.get(node).get(i);
            if (visited.get(neighbor) == 0) {
                dfs(adj_list, visited, neighbor, getColor(visited.get(node)));
            }
        }
    }

    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        HashMap<Integer, ArrayList<Integer>> adj_list = new HashMap<>();
        HashMap<Integer, Integer> visited = new HashMap<>();
        m = 0;
        n = 0;
        for (int i = 1; i <= A; i++) {
            visited.put(i, 0);
        }
        // Create adj list
        for (int i = 0; i < B.size(); i++) {
            int node1 = B.get(i).get(0);
            int node2 = B.get(i).get(1);
            if (!adj_list.containsKey(node1)) {
                adj_list.put(node1, new ArrayList<Integer>());
            }
            if (!adj_list.containsKey(node2)) {
                adj_list.put(node2, new ArrayList<Integer>());
            }
            adj_list.get(node1).add(node2);
            adj_list.get(node2).add(node1);
        }
        for (int i = 1; i <= A; i++) {
            if (visited.get(i) == 0) {
                dfs(adj_list, visited, i, getColor(0));
            }
        }
        if ((1L * m * n) < 1L * (A - 1)) return 0;
        long sum = ((1L * (m * n)) - (A - 1)) % 1000000007;
        return (int) sum;
    }
}

package com.nichols.dsa.graphs;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.*;

class Solution {
    int[] Rank = new int[1000005];
    int[] Parent = new int[1000005];

    int Find(int x) {
        if (x != Parent[x])
            Parent[x] = Find(Parent[x]);
        return Parent[x];
    }

    int Union(int u, int v, int cost) {
        int x = Find(u);
        int y = Find(v);

        if (x == y)
            return 0;

        if (Rank[x] > Rank[y]) {
            Parent[y] = x;
            Rank[x] += Rank[y];
        } else {
            Parent[x] = y;
            Rank[y] += Rank[x];
        }

        return cost;
    }

    int comp(final ArrayList<Integer> a, final ArrayList<Integer> b) {
        return a.get(2) - b.get(2);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    int solve(int A, ArrayList<ArrayList<Integer>> B) {
        for (int i = 0; i < A; i++) {
            Parent[i] = i;
            Rank[i] = 1;
        }

        B.sort((a, b) -> comp(a, b));

        int n = B.size();
        int ans = 0;

        for (int i = 0; i < n; i++)
            ans += Union(B.get(i).get(0) - 1, B.get(i).get(1) - 1, B.get(i).get(2));

        return ans;
    }
}
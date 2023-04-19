package com.nichols.dsa.dynamicprogramming;

public class MaxSumWithoutAdjacentElements {
    public int adjacent(int[][] A) {
        int n = A.length;
        int inc = Math.max(A[0][0], A[1][0]);
        int excl = 0,excl_new;

        for(int i = 1; i < n; i++)
        {
            excl_new = Math.max(excl,inc);
            inc = excl + Math.max(A[0][1], A[1][i]);
            excl = excl_new;
        }
        return Math.max(excl, inc);
    }
}

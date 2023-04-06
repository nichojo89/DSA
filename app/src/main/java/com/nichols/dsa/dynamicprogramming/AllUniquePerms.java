package com.nichols.dsa.dynamicprogramming;

import java.util.Arrays;

public class Solution {
    public int solve(final int[] A) {
        int n = A.length;
        int sum = 0;
        int negCount = 0;

        for (int i = 0; i < n; i++) {
            sum += A[i];
            if (A[i] < 0)
                negCount++;
        }

        if (sum >= 0)
            return negCount;

        Arrays.sort(A, (a, b) -> Math.abs(a) - Math.abs(b));

        int flips = 0;
        for (int i = 0; i < n; i++) {
            sum += 2 * Math.abs(A[i]);
            flips++;
            if (sum >= 0)
                break;
        }

        return flips;
    }
}
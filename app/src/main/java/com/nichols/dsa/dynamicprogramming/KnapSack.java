package com.nichols.dsa.dynamicprogramming;

public class KnapSack {
    static int maxn = 1009;
    static int[][] dp = new int[maxn][maxn];
    public static int knapsack(int[] A, int[] B, int C) {
        for (int[] row: dp)
            Arrays.fill(row, 0);
        int n = A.length;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= C; j++) {
                dp[i][j] = dp[i - 1][j];
                if (B[i - 1] <= j)
                    dp[i][j] = Math.max(dp[i][j], A[i - 1] + dp[i - 1][j - B[i - 1]]);
            }
        }
        return dp[n][C];
    }
    public int solve(int[] A, int[] B, int C) {
        return knapsack(A, B, C);
    }
}
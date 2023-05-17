package com.nichols.dsa.dynamicprogramming;

public class SolveAlienSignals {
    public int solve(int A) {
        if(A<=0)
            return 0;
        int mod = (int)1e9+7;
        int[] dp = new int[A+1];
        dp[0] = 1;
        dp[1] = 2;

        for(int i = 2; i <= A; i++)
            dp[i] = (dp[i-1] + dp[i-2]) % mod;

        return dp[A];
    }
}

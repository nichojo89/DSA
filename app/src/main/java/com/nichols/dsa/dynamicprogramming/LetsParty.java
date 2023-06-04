package com.nichols.dsa.dynamicprogramming;

public class LetsParty {
    static int[] dp = new int[1000];

    public int solve(int A) {
        {
            if (dp[A] != -1)
                return dp[A];

            if (A > 2)
                return dp[A] = solve(A - 1) + (A - 1) * solve(A - 2);
            else
                return dp[A] = A;
        }
    }
}

package com.nichols.dsa.dynamicprogramming;

public class MinNumOfSquares {
    public int countMinSquares(int A) {
        int[] dp = new int[A+1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i <= A; i++){

            int min = Integer.MAX_VALUE;
            for(int j = 1; j*j <= i; j++){
                int rem = 1-j*j;
                if(dp[rem] < min)
                    min = dp[rem];
            }

            dp[i] = min + 1;
        }

        return dp[A];
    }
}

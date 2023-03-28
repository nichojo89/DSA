package com.nichols.dsa.dynamicprogramming;

import java.util.Arrays;

public class EditDistance {
    public int minDistance(String A, String B) {
        int n = A.length();
        int m = B.length();
        int[][] dp = new int[n+1][m+1];
        for(int i = 0; i < n+1; i++)
            Arrays.fill(dp[i],-1);

        return minDis(A,B,n,m,dp);
    }

    private int minDis(String A, String B, int n, int m, int[][] dp){
        if(n==0)
            return m;
        if(m==0)
            return n;

        if(dp[n][m] != -1)
            return dp[n][m];

        if(A.charAt(n-1) == B.charAt(m-1))
            return dp[n][m] = minDis(A,B,n-1,m-1,dp);
        else {
            int insert,del,replace;
            insert = minDis(A,B,n,m-1,dp);
            del = minDis(A,B,n-1,m,dp);
            replace = minDis(A,B,n-1,m-1,dp);
            return dp[n][m] = 1+Math.min(insert,Math.min(del,replace));
        }
    }
}

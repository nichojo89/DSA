package com.nichols.dsa.dynamicprogramming;

public class InterleavingStrings {
//    public int isInterleave(String A, String B, String C) {
//        int m = A.length();
//        int n = B.length();
//        int[][] dp = new int[m+1][n+1];
//
//        if((m+n) != C.length())
//            return -1;
//
//        for(int i =0; i < m; i++)
//            for(int j = 0; j < n;j++){
//                if(i==0&&j==0)
//                    dp[i][j] = 1;
//                else if(i==0 && B.charAt(j-1) == C.charAt(j-1))
//                    dp[i][j] = dp[i][j-1];
//                else if(j==0 && A.charAt(i-1) == C.charAt(i-1))
//                    dp[i][j] = dp[i-1][j];
//                else if(A.charAt(i-1) == C.charAt(i+j-1) && B.charAt(j-1) != C.charAt(i+j-1))
//                    dp[i][j] = dp[i-1][j];
//                else if(A.charAt(i-1) != C.charAt(i+j-1) && B.charAt(j-1) == C.charAt(i+j-1))
//                    dp[i][j] = dp[i][j-1];
//                else if(A.charAt(i-1) == C.charAt(i+j-1) && B.charAt(j-1) == C.charAt(i+j-1))
//                    dp[i][j] = (dp[i-1][j] != 0 || dp[i][j-1] != 0) ? 1 : 0;
//
//            }
//
//        return dp[m][n];
//    }
public int isInterleave(String A, String B, String C) {
    int m = A.length();
    int n = B.length();

    if (C.length() != m + n)
        return 0;

    boolean[][] dp = new boolean[m + 1][n + 1];

    dp[0][0] = true;

    // Fill the first row of dp
    for (int j = 1; j <= n; j++)
        if (B.charAt(j - 1) == C.charAt(j - 1))
            dp[0][j] = dp[0][j - 1];

    // Fill the first column of dp
    for (int i = 1; i <= m; i++)
        if (A.charAt(i - 1) == C.charAt(i - 1))
            dp[i][0] = dp[i - 1][0];

    // Fill the remaining cells of dp
    for (int i = 1; i <= m; i++)
        for (int j = 1; j <= n; j++) {
            if (A.charAt(i - 1) == C.charAt(i + j - 1))
                dp[i][j] = dp[i - 1][j];

            if (B.charAt(j - 1) == C.charAt(i + j - 1))
                dp[i][j] = dp[i][j] || dp[i][j - 1];
        }

    return dp[m][n] ? 1 : 0;
}
}

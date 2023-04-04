package com.nichols.dsa.dynamicprogramming

import java.util.*

class MaxStocksII {
    fun maxProfit(A: IntArray): Int {
        var profit = 0
        for(i in A.indices)
            if(A[i+1] > A[i])
                profit += A[i+1] - A[i]

        return profit
    }


    fun isMatch(A: String, B: String): Int {
        val n = A.length
        val m = B.length
        val dp = Array(n+1){IntArray(m+1)}
        dp[0][0] = 1
        for(i in 1..m)
            if(B[i-1] == '*')
                dp[0][i] = 1
            else
                break

        for(i in 1..n){
            for(j in 1 .. m){
                if(A[i-1]==B[j-1] || B[j-1] == '?')
                    dp[i][j] = dp[i-1][j-1]
                else if (B[j-1]=='*')
                    dp[i][j] = if(dp[i-1][j] == 1 || dp[i][j-1] == 1) 1 else 0
            }
        }
        return dp[n][m]
    }
}
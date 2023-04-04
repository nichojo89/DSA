package com.nichols.dsa.dynamicprogramming

class MatrixChainMultiplication {
    fun solve(A: IntArray): Int {
        val n = A.size
        val dp = Array(n){IntArray(n){0} }

        for(l in 1 until n-1)
            for(i in 1..n-l)
                dp[i][i+l] = Math.min(
                    dp[i+1][i+l] + A[i-1] * A[i] * A[i+l],
                    dp[i][i+l-1] + A[i-1] * A[i+l-1] * A[i+l]
                    )
        return dp[1][n-1]
    }

    fun MatrixChainOrder(A: IntArray): Int {
        val n = A.size
        val dp = Array(n) { IntArray(n) }

//        for (i in 1 until n) dp[i][i] = 0

        for (L in 1 until n - 1)
            for (i in 1 until n - L) dp[i][i + L] = Math.min(
            dp[i + 1][i + L] + A[i - 1] * A[i] * A[i + L],
            dp[i][i + L - 1] + A[i - 1] * A[i + L - 1] * A[i + L]
        )
        return dp[1][n - 1]
    }
}
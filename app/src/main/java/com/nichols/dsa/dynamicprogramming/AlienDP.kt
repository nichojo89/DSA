package com.nichols.dsa.dynamicprogramming

class AlienDP {
    fun solve(A: Int): Int {
        if (A <= 0)
            return 0

        val mod = 1e9.toInt() + 7
        val dp = IntArray(A + 1)
        dp[0] = 1
        dp[1] = 2
        for (i in 2..A)
            dp[i] = (dp[i - 1] + dp[i - 2]) % mod

        return dp[A]
    }
}
package com.nichols.dsa.dynamicprogramming

class KnapsackII {
    fun solve(A: ArrayList<Int>, B: ArrayList<Int>, C: Int): Int {
        val n = A.size
        val mxval = 50 * n
        val dp = IntArray(mxval + 1) { 1e9.toInt() }

        dp[0] = 0

        for (i in 0 until n) {
            for (`val` in mxval downTo A[i]) {
                dp[val] = Math.min(dp[`val`], B[i] + dp[`val` - A[i]])
            }
        }

        var ans = 0
        for (`val` in mxval downTo 0) {
            if (dp[`val`] <= C) {
                ans = `val`
                break
            }
        }
        return ans
    }
}
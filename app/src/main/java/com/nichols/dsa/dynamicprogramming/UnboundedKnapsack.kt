package com.nichols.dsa.dynamicprogramming

class UnboundedKnapsack {

    fun solve(A: Int, B: IntArray?, C: IntArray?): Int {
        val n = B!!.size
        return unboundedKnapsack(A, n, B, C!!)
    }
    private fun max(i: Int, j: Int): Int  = if (i > j) i else j

    private fun unboundedKnapsack( W: Int, n: Int,`val`: IntArray, wt: IntArray): Int {
        val dp = IntArray(W + 1)
        for (i in 0..W) {
            for (j in 0 until n) {
                if (wt[j] <= i) {
                    dp[i] = max(
                        dp[i], dp[i - wt[j]] +
                                `val`[j]
                    )
                }
            }
        }
        return dp[W]
    }
}
package com.nichols.dsa.dynamicprogramming

class LCSS {

    fun solve(A: String, B: String): Int =
        lcs(A, B, A.length, B.length)

    private fun lcs(X: String, Y: String, m: Int, n: Int): Int {
        if (m == 0 || n == 0) return 0
        return if (X[m - 1] == Y[n - 1]) 1 + lcs(X, Y, m - 1, n - 1)
        else lcs(X, Y, m, n - 1).coerceAtLeast(lcs(X, Y, m - 1, n))
    }
}
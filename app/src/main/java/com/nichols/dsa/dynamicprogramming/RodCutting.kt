package com.nichols.dsa.dynamicprogramming

import java.util.*

class RodCutting {
    fun solve(A: IntArray): Int =
        rodCutter(A,  A.size)

    private fun rodCutter(prices: IntArray, n: Int): Int {
        val mat = Array(n + 1) { IntArray(n + 1) }
        for (i in 0..n) {
            for (j in 0..n) {
                mat[i][j] =
                    if (i == 0 || j == 0)  0
                    else if (i == 1) j * prices[i - 1]
                    else if (i > j) mat[i - 1][j]
                    else Math.max( prices[i - 1] + mat[i][j - i], mat[i - 1][j])
            }
        }
        return mat[n][n]
    }

    fun solve(A: IntArray, B: IntArray): Int {
        val n = A.size
        val jobs = Array(n) { IntArray(2) }
        for (i in 0 until n) {
            jobs[i][0] = B[i]
            jobs[i][1] = A[i]
        }
        Arrays.sort(jobs) { a: IntArray, b: IntArray ->
            a[0].compareTo(b[0])
        }
        var count = 0
        var endTime = -1
        for (job in jobs) {
            if (job[1] >= endTime) {
                count++
                endTime = job[0]
            }
        }
        return count
    }
}
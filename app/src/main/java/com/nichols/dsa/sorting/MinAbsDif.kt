package com.nichols.dsa.sorting

class MinAbsDif {
    fun findMinRec(A: IntArray, i: Int, s: Int, t: Int): Int {
        return if (i == 0)
            Math.abs(t - s - s
        ) else
            Math.min(
            findMinRec(A, i - 1, s + A[i - 1], t),
            findMinRec(A, i - 1, s, t)
        )
    }

    fun solveFindMin(A: IntArray): Int {
        val n = A.size
        var sumTotal = 0
        for (i in 0 until n)
            sumTotal += A[i]

        return findMinRec(A, n, 0, sumTotal)
    }






    private fun calculateDiff(
        i: Int, j: Int,
        A: IntArray
    ): Int = Math.abs(A[i] - A[j]) + Math.abs(i - j)

    fun solve(A: IntArray): Int {
        var result = 0

        // Iterate pairs
        for (i in A.indices) {
            for (j in i until A.size)
                result = Math.max(result, calculateDiff(i, j, A))
        }
        return result
    }
}
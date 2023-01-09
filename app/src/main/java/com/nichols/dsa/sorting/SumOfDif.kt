package com.nichols.dsa.sorting



fun solveMaxMin(A: IntArray): Int {
    val n = A.size
    val mod = 1000000007
    A.sort()

    var min_sum = 0L
    var max_sum = 0L
    for (i in 0 until n) {
        max_sum = 2 * max_sum + A[n - 1 - i]
        max_sum %= mod.toLong()
        min_sum = 2 * min_sum + A[i]
        min_sum %= mod.toLong()
    }
    return ((max_sum - min_sum + mod) % mod).toInt()
}
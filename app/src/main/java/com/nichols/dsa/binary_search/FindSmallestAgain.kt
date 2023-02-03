package com.nichols.dsa.binary_search

import java.util.*

fun check(A: IntArray, `val`: Int): Int {
    var cnt = 0
    for (i in A.indices) {
        var s = i + 1
        var e = A.size - 1
        while (s < e) {
            if (A[i] + A[s] + A[e] < `val`) {
                cnt += e - s
                s++
            } else {
                e--
            }
        }
    }
    return cnt
}

fun solve(A: IntArray, B: Int): Int {
    Arrays.sort(A)
    val n = A.size
    var low = 0
    var high = A[n - 1] + A[n - 2] + A[n - 3]
    var ans = 0
    while (low <= high) {
        val mid = (high - low) / 2 + low
        // count of triplets with sum less than mid
        val count = check(A, mid)
        if (count >= B) {
            high = mid - 1
        } else {
            ans = mid
            low = mid + 1
        }
    }
    return ans
}
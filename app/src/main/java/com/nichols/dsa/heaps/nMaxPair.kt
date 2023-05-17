package com.nichols.dsa.heaps

import java.util.*

fun solve(A: IntArray): Int {
    val n = A.size
    for (i in A.indices) {

        val leftMedian = findMedian(A, 0, i - 1)
        val rightMedian = findMedian(A, i + 1, n - 1)

        if (A[i] == leftMedian || A[i] == rightMedian)
            return 1
    }
    return 0
}

private fun findMedian(A: IntArray, start: Int, end: Int): Int {
    val length = end - start + 1
    val subarray = IntArray(length)

    System.arraycopy(A, start, subarray, 0, length)

    Arrays.sort(subarray)

    return if (length % 2 == 0) {
        val mid1 = subarray[length / 2 - 1]
        val mid2 = subarray[length / 2]
        (mid1 + mid2) / 2
    } else
        subarray[length / 2]
}
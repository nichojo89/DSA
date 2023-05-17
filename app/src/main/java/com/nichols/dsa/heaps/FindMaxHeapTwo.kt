package com.nichols.dsa.heaps

import java.util.*

class FindMaxHeapTwo {
    fun solve(A: IntArray, B: Int): Int {
        var low: Int = A.minOrNull()!!
        var high: Int = A.maxOrNull()!! + B
        var result = high
        while (low <= high) {
            val mid = low + (high - low) / 2
            if (isPossible(A, B, mid)) {
                result = mid
                high = mid - 1
            } else {
                low = mid + 1
            }
        }
        return result
    }

    private fun isPossible(A: IntArray, B: Int, target: Int): Boolean {
        var operations = 0
        for (i in A.indices) {
            if (A[i] < target) {
                operations += target - A[i]
                if (operations > B) {
                    return false
                }
            }
        }
        return true
    }
}
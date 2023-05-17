package com.nichols.dsa.graphs

import java.util.*

class FindOneSquare {
    fun maximalRectangle(A: Array<IntArray>): Int {
        return maxHist(A.size,A[0].size,A)
    }
    fun maxHist(R: Int, C: Int, row: IntArray): Int {
        val result: Stack<Int> = Stack<Int>()
        var top_val = 0
        var max_area = 0
        var area = 0
        var i = 0
        while (i < C) {
            if (result.empty() || row[result.peek()] <= row[i]
            ) result.push(i++) else {
                top_val = row[result.peek()]
                result.pop()
                area = top_val * i
                if (!result.empty()) area = top_val * (i - result.peek() - 1)
                max_area = Math.max(area, max_area)
            }
        }

        while (!result.empty()) {
            top_val = row[result.peek()]
            result.pop()
            area = top_val * i
            if (!result.empty()) area = top_val * (i - result.peek() - 1)
            max_area = Math.max(area, max_area)
        }
        return max_area
    }
}
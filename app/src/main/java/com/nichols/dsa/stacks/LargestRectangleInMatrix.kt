package com.nichols.dsa.stacks

import java.util.*

fun solveLargestRectangleAre(A: Array<IntArray>): Int {
    val n = A.size
    val m = A[0].size
    var maxArea = 0
    val height = IntArray(m)
    for(i in A.indices){
        for(j in 0 until m)
            if(A[i][j] == 1)
                height[j]++
            else
                height[j] = 0
        val area = largestRectangleArea(height)
        maxArea = Math.max(area,maxArea)
    }

    return maxArea
}
fun largestRectangleArea(A: IntArray): Int {
    val st: Stack<Int> = Stack()
    var maxA = 0
    val n = A.size
    for (i in 0..n) {
        while (!st.empty() && (i == n || A[st.peek()] >= A[i])) {
            val height = A[st.peek()]
            st.pop()
            var width: Int = if (st.empty()) i else i - st.peek() - 1
            maxA = Math.max(maxA, width * height)
        }
        st.push(i)
    }
    return maxA
}
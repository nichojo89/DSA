package com.nichols.dsa.stacks

import java.util.*
import kotlin.collections.ArrayList


fun Precedenece(ch: Char): Int {
    when (ch) {
        '+', '-' -> return 1
        '*', '/' -> return 2
        '^' -> return 3
    }
    return -1
}

// Utility function to replace all non-zero values in a matrix by 1
fun resetMatrix(mat: Array<IntArray>) {
    for (i in mat.indices) {
        for (j in mat[0].indices) {
            if (mat[i][j] != 0) {
                mat[i][j] = 1
            }
        }
    }
}

// Function to calculate the area of the largest rectangle of 1's where
// swapping of columns is allowed
fun findMaxRectArea(mat: ArrayList<ArrayList<Int>>?): Int {
    // base case
    if (mat == null || mat.size == 0) {
        return 0
    }

    // `M × N` matrix
    val M = mat.size
    val N = mat[0].size

    // update the matrix to store the counts of consecutive 1's present
    // in each column
    for (j in 0 until N) {
        // process each column from bottom to top
        for (i in M - 2 downTo 0) {
            if (mat[i][j] == 1) {
                mat[i][j] = mat[i + 1][j] + 1
            }
        }
    }

    // keep track of the largest rectangle of 1's found so far
    var maxArea = 0

    // traverse each row in the modified matrix to find the maximum area
    for (i in 0 until M) {
        // create a count array for each row `i`
        val count = IntArray(M + 1)

        // process row `i`
        for (j in 0 until N) {
            if (mat[i][j] > 0) {
                // increment value in the count array using the
                // current element `mat[i][j]` as an index
                count[mat[i][j]] += 1

                // the area can be calculated by multiplying the current
                // element `mat[i][j]` with the corresponding value
                // in the count array `count[mat[i][j]]`
                maxArea = Integer.max(maxArea, mat[i][j] * count[mat[i][j]])
            }
        }
    }

    // reset matrix before returning
    resetMatrix(mat)
    return maxArea
}


fun solveinfixToPostfix(A: String): String? {
    var result = ""

    val stack: Deque<Char> = ArrayDeque()
    for (element in A) {

        if (Character.isLetterOrDigit(element)) result += element else if (element == '(') stack.push(
            element
        ) else if (element == ')') {
            while (!stack.isEmpty() && stack.peek() != '(') {
                result += stack.peek()
                stack.pop()
            }
            stack.pop()
        } else
        {
            while (!stack.isEmpty() && Precedenece(element) <= Precedenece(stack.peek()!!)) {
                result += stack.peek()
                stack.pop()
            }
            stack.push(element)
        }
    }

    while (!stack.isEmpty()) {
        if (stack.peek() === '(') return "Invalid Expression"
        result += stack.peek()
        stack.pop()
    }
    return result
}
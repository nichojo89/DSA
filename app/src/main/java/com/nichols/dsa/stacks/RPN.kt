package com.nichols.dsa.stacks

import java.util.*

const val MAX_CHAR=26
class Solution {
    fun findNextGreaterElements(input: IntArray): IntArray {
        val ans = arrayListOf<Int>()
        if (input == null) {
            return ans.toIntArray()
        }

        // do for each element
        for (i in input.indices) {
            // keep track of the next greater element for element `input[i]`
            var next = -1

            // process elements on the right of element `input[i]`
            for (j in i + 1 until input.size) {
                // break the inner loop at the first larger element on the
                // right of element `input[i]`
                if (input[j] > input[i]) {
                    next = input[j]
                    break
                }
            }
            print("$next ")
        }
        return input
    }
    fun getMaxArea(A: IntArray, n: Int): Int {
        val s =  Stack<Int>()
        s.push(-1)
        var maxArea = A[0]
        val leftSmaller = IntArray(n)
        val rightSmaller = IntArray(n)
        for (i in 0 until n) {
            leftSmaller[i] = -1
            rightSmaller[i] = n
        }
        var i = 0
        while (i < n) {
            while (!s.empty() && s.peek() != -1 && A[i] < A[s.peek()]) {
                rightSmaller[s.peek()] = i
                s.pop()
            }
            if (i > 0 && A[i] == A[i - 1])
                leftSmaller[i] = leftSmaller[(i - 1)]
            else
                leftSmaller[i] = s.peek()

            s.push(i)
            i++
        }
        i = 0
        while (i < n) {
            maxArea = Math.max(
                maxArea,
                A[i] * (rightSmaller[i] - leftSmaller[i] - 1)
            )
            i++
        }
        return maxArea
    }
}

fun evalRPN(A: Array<String>): Int {
    val operators: Set<String> = HashSet(listOf("+", "-", "*", "/"))
    val stk = Stack<Int>()
    for (c in A) {
        if (!operators.contains(c)) stk.push(c.toInt()) else {
            val b = stk.pop()
            val a = stk.pop()
            if (c == "+") stk.push(a + b) else if (c == "-") stk.push(a - b) else if (c == "*") stk.push(
                a * b
            ) else stk.push(a / b)
        }
    }
    return stk.pop()
}

fun checkRedundancy(s: String): Boolean {
    // create a stack of characters
    val st: Stack<Char> = Stack()
    val str = s.toCharArray()
    // Iterate through the given expression
    for (ch in str) {

        // if current character is close parenthesis ')'
        if (ch == ')') {
            var top = st.peek()
            st.pop()

            // If immediate pop have open parenthesis '('
            // duplicate brackets found
            var flag = true
            while (top != '(') {

                // Check for operators in expression
                if (top == '+' || top == '-' || top == '*' || top == '/') {
                    flag = false
                }

                // Fetch top element of stack
                top = st.peek()
                st.pop()
            }

            // If operators not found
            if (flag == true) {
                return true
            }
        } else {
            st.push(ch) // push open parenthesis '(',
        } // operators and operands to stack
    }
    return false
}

fun findRedundant(A: String) : Int {
    val ans = checkRedundancy(A)
    return if (ans) {
        1
    } else {
        0
    }
}

package com.nichols.dsa.stacks

import java.util.*

class FindNextGreater {
    lateinit var a: IntArray
    fun findNextGreaterElement(Next_greater_element: IntArray, n: Int) {
        // this function calculates next_greater element index
        val s: Stack<Int> = Stack<Int>()
        for (i in 0 until n) Next_greater_element[i + 1] = n + 1
        for (i in 1..n) {
            if (s.empty()) {
                s.push(i)
            } else {
                while (!s.empty() && a[s.peek()] <= a[i]) {
                    Next_greater_element[s.peek()] = i
                    s.pop()
                }
                s.push(i)
            }
        }
    }

    fun findPreviousGreaterElement(Previous_greater_element: IntArray, n: Int) {
        // this function calculates Previous_greater element index
        val s: Stack<Int> = Stack<Int>()
        for (i in n downTo 1) {
            if (s.empty()) {
                s.push(i)
            } else {
                while (!s.empty() && a[i] > a[s.peek()]) {
                    Previous_greater_element[s.peek()] = i
                    s.pop()
                }
                s.push(i)
            }
        }
    }

    fun findPreviousSmallerElement(Previous_smaller_element: IntArray, n: Int) {
        // this function calculates Previous smaller element index
        val s: Stack<Int> = Stack<Int>()
        for (i in n downTo 1) {
            if (s.empty()) {
                s.push(i)
            } else {
                while (!s.empty() && a[i] <= a[s.peek()]) {
                    Previous_smaller_element[s.peek()] = i
                    s.pop()
                }
                s.push(i)
            }
        }
    }

    fun findNextSmallerElement(Next_smaller_element: IntArray, n: Int) {
        // function function calculates Next smaller element index
        val s: Stack<Int> = Stack<Int>()
        for (i in 0 until n) Next_smaller_element[i + 1] = n + 1
        for (i in 1..n) {
            if (s.empty()) {
                s.push(i)
            } else {
                while (!s.empty() && a[i] < a[s.peek()]) {
                    Next_smaller_element[s.peek()] = i
                    s.pop()
                }
                s.push(i)
            }
        }
    }

    fun solve(A: IntArray): Int {
        val n = A.size
        val mod = 1000 * 1000 * 1000 + 7
        a = IntArray(n + 1)
        val Next_greater_element = IntArray(n + 1)
        val Previous_greater_element = IntArray(n + 1)
        val Previous_smaller_element = IntArray(n + 1)
        val Next_smaller_element = IntArray(n + 1)
        for (i in 0 until n) {
            a[i + 1] = A[i]
        }
        findNextGreaterElement(Next_greater_element, n)
        findPreviousGreaterElement(Previous_greater_element, n)
        findPreviousSmallerElement(Previous_smaller_element, n)
        findNextSmallerElement(Next_smaller_element, n)
        var ans: Long = 0
        for (i in 1..n) {
            var right = (Next_greater_element[i] - i).toLong()
            var left = (i - Previous_greater_element[i]).toLong()
            ans += left * right % mod * a[i] % mod
            ans %= mod.toLong()
            left = (i - Previous_smaller_element[i]).toLong()
            right = (Next_smaller_element[i] - i).toLong()
            ans -= left * right % mod * a[i] % mod
            ans += mod.toLong()
            ans %= mod.toLong()
        }
        return ans.toInt()
    }
}
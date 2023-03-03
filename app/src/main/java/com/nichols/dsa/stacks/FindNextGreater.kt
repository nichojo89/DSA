package com.nichols.dsa.stacks

import com.nichols.dsa.binarytrees.DiameterOfTree.TreeNode

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

//    fun maximumXor(A: IntArray): Int {
//        val n = A.size
//        val sForward = Stack<Int>()
//        val sBackward = Stack<Int>()
//
//        // To store the final answer
//        var ans = -1
//        for (i in A.indices) {
//            while (!sForward.isEmpty()  && A[i] < A[sForward.peek()]) {
//                ans = Math.max(ans, A[i] xor A[sForward.peek()])
//                sForward.pop()
//            }
//            sForward.add(i)
//
//            while (!sBackward.isEmpty() && A[n - i - 1] < A[sBackward.peek()]) {
//                ans = Math.max(ans, A[n - i - 1] xor A[sBackward.peek()])
//                sBackward.pop()
//            }
//            sBackward.add(n - i - 1)
//        }
//        return ans
//    }
var root: TreeNode? = null

    fun sum(node: TreeNode?): Int {
        return if (node == null) {
            0
        } else sum(node.left) + node.`val` + sum(node.right)
    }

    fun solve(node: TreeNode): Int {
        val ls: Int
        val rs: Int

        if (node == null || node.left == null && node.right == null) {
            return 1
        }

        ls = sum(node.left)
        rs = sum(node.right)

        return if (node.`val` == ls + rs && solve(node.left) != 0 && solve(node.right) != 0) {
            1
        } else 0
    }
}
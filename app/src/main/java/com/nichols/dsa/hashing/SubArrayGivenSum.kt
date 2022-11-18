package com.nichols.dsa.hashing

fun main(){
    val twoAndThree = solveSubSum(intArrayOf(1, 2, 3, 4, 5), 5)
}

fun solveSubSum(A: IntArray, B: Int): IntArray {
    val n = A.size
    var s = A[0]
    var left = 0
    var right: Int

    right = 1
    while (right <= n) {
        //shrink
        while (s > B && left < right - 1) {
            s = s - A[left]
            left++
        }

        //winner
        if (s == B) {
            return A.copyOfRange(left,right)
        }

        //expand
        if (right < n)
            s = s + A[right]

        right++
    }

    return intArrayOf(-1)
}
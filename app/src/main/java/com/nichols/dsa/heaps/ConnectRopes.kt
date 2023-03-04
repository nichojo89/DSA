package com.nichols.dsa.heaps

import java.util.*


fun solveConnectRopes(A: IntArray): Int {
    var res = 0
    val Q = PriorityQueue<Int>()

    for (i in A)
        Q.add(i)

    while (Q.size > 1) {
        val first = Q.poll()!!
        val second = Q.poll()!!

        res += first + second
        Q.add(first + second)
    }
    return res
}
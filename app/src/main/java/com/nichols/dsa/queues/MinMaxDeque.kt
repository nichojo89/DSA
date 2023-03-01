package com.nichols.dsa.queues

import java.util.*

fun solveMinMaxDeque(A: IntArray, B: Int): Int {
    var sum = 0L
    val mod =  (1000000000 + 7)
    val min: Deque<Int> = LinkedList()
    val max: Deque<Int> = LinkedList()

    var i = 0
    while (i < B) {
        while (!min.isEmpty() && A[min.peekLast()] >= A[i])
            min.removeLast()

        while (!max.isEmpty() && A[max.peekLast()] <= A[i])
            max.removeLast()

        max.addLast(i)
        min.addLast(i)
        i++
    }

    while (i < A.size) {
        sum = ((sum + A[min.peekFirst()] + A[max.peekFirst()]) % mod).toLong()
        while (!min.isEmpty() && min.peekFirst() <= i - B)
            min.removeFirst()

        while (!max.isEmpty() && max.peekFirst() <= i - B)
            max.removeFirst()

        while (!min.isEmpty() && A[min.peekLast()] >= A[i])
            min.removeLast()

        while (!max.isEmpty() && A[max.peekLast()] <= A[i])
            max.removeLast()

        max.addLast(i)
        min.addLast(i)
        i++
    }

    sum = ((sum + A[min.peekFirst()] + A[max.peekFirst()]) % mod).toLong()
    sum = (sum + mod) % mod
    return (sum).toInt()
}
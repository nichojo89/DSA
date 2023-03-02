package com.nichols.dsa.queues

import java.util.*

fun main(){
    val a = solveReversingElementsInQueue(intArrayOf(1, 2, 3, 4, 5), 3)
}
fun solveReversingElementsInQueue(A: IntArray, B: Int): IntArray {
    val stk = Stack<Int>()
    for(i in 0 until B)
        stk.push(A[i])

    for(i in 0 until B)
        A[i] = stk.pop()

    return A
}